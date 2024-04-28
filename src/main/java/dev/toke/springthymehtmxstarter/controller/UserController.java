package dev.toke.springthymehtmxstarter.controller;

import dev.toke.springthymehtmxstarter.data.dto.UserDto;
import dev.toke.springthymehtmxstarter.data.model.User;
import dev.toke.springthymehtmxstarter.service.UserService;
import io.github.wimdeblauwe.htmx.spring.boot.mvc.HtmxResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {
    private final UserService userService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("user", new User());
        addAttributesForIndex(model, ListFilter.ALL);
        return "users/index";
    }

    @GetMapping("/active")
    public String activeIndex(Model model) {
        addAttributesForIndex(model, ListFilter.ACTIVE);
        return "users/index";
    }

    @GetMapping("/inactive")
    public String inactiveIndex(Model model) {
        addAttributesForIndex(model, ListFilter.INACTIVE);
        return "users/index";
    }

    @GetMapping("/{username}")
    public String show(@PathVariable String username, Model model) {
        model.addAttribute("user", userService.findByUsername(username));
        return "users/show";
    }

    @PostMapping
    public HtmxResponse addUser(@Valid @ModelAttribute("user") User user, Model model) {
        userService.save(user);
        model.addAttribute("user", new User());
        addAttributesForIndex(model, ListFilter.ALL);
        return HtmxResponse.builder()
                .view("users/index :: users")
                .view("users/index :: user-form-dialog")
                .build();
    }

    @PutMapping("/{username}")
    public String updateUser(@PathVariable String username, @Valid @ModelAttribute("user") User user) {
        if (!user.getUsername().equalsIgnoreCase(username)) return "redirect:/users/" + username;
        var existingUser = userService.findByUsername(username);
        if (existingUser != null) {
            existingUser.setEmail(user.getEmail());
            existingUser.setPassword(user.getPassword());
            existingUser.setIsActive(user.getIsActive());
            userService.save(existingUser);
            return "redirect:/users/" + username;
        }
        return "redirect:/users/index";
    }

    @DeleteMapping("/{username}")
    public String deleteUser(@PathVariable String username, Model model) {
        log.info("Deleting user {}", username);
        var existingUser = userService.findByUsername(username);
        if (existingUser == null) return "redirect:/users/index";
        userService.delete(existingUser.getId());
        addAttributesForIndex(model, ListFilter.ALL);
        return "users/index :: users";
    }

    private void addAttributesForIndex(Model model, ListFilter listFilter) {
        model.addAttribute("users", getUsers(listFilter));
        model.addAttribute("numberOfUsers", userService.findAll().size());
    }

    private List<UserDto> convertToDto(List<User> users) {
        return users.stream()
                .map(user -> new UserDto(user.getId(), user.getUsername(), user.getEmail(), user.getIsActive())).toList();
    }

    private List<UserDto> getUsers(ListFilter filter) {
        return switch (filter) {
            case ALL -> convertToDto(userService.findAll());
            case ACTIVE -> convertToDto(userService.findUsersByIsActiveStatus(true));
            case INACTIVE -> convertToDto(userService.findUsersByIsActiveStatus(false));
        };
    }

    public enum ListFilter {
        ALL,
        ACTIVE,
        INACTIVE
    }
}
