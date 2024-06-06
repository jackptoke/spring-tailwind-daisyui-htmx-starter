package dev.toke.springthymehtmxstarter.data.api;

import dev.toke.springthymehtmxstarter.data.dto.AmeUserDto;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;

import java.util.List;

public interface UserApi {
    @GetExchange("/users")
    List<AmeUserDto> getUsers();
    @GetExchange("/users/{username}")
    AmeUserDto getUser(@PathVariable(name = "username") String username);

}
