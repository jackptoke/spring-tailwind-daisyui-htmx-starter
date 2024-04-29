package dev.toke.springthymehtmxstarter.utils;

import dev.toke.springthymehtmxstarter.data.model.PrintColour;
import dev.toke.springthymehtmxstarter.data.model.User;
import dev.toke.springthymehtmxstarter.events.ResetMachineDataEvent;
import dev.toke.springthymehtmxstarter.data.model.Machine;
import dev.toke.springthymehtmxstarter.repository.MachineRepo;
import dev.toke.springthymehtmxstarter.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.stream.Stream;

@Component
@RequiredArgsConstructor
public class Initializer {
    private final MachineRepo machineRepo;
    private final UserService userService;

    @EventListener({ ApplicationReadyEvent.class, ResetMachineDataEvent.class})
    void reset() {
        machineRepo.deleteAll();

        Stream.of(new User(null, "jackptoke", "jackptoke@gmail.com", "password", true),
                new User(null, "amytoke", "amytoke@gmail.com", "password", true),
                new User(null, "josiahtoke", "josiahtoke@gmail.com", "password", false),
                new User(null, "jeremiahtoke", "jeremiahtoke@gmail.com", "password", false),
                new User(null, "adrielletoke", "adrielletoke@gmail.com", "password", false),
                new User(null, "israeltoke", "israeltoke@gmail.com", "password", false))
                .forEach(userService::save);
        User user1 = userService.findByUsername("jackptoke");
        User user2 = userService.findByUsername("amytoke");
        Stream.of(
                new Machine
                                (null,
                                "Kappa1",
                                "The Kappa 350 - A",
                                "Kappa",
                                "350",
                                "\\\\valentine\\WPCS\\Kappa1\\WPCS_Data",
                                "\\\\valentine\\WPCS\\Kappa1\\WPCS_Feedback",
                                        true,
                                        40,
                                        40,
                                        200,
                                        5000,
                                        true,
                                        true,
                                        true,
                                        PrintColour.WHITE,
                                        user1,
                                        LocalDateTime.now(),
                                        null
                                ),
                        new Machine
                                (null,
                                        "Kappa2",
                                        "The Kappa 350 - A",
                                        "Kappa",
                                        "350",
                                        "\\\\valentine\\WPCS\\Kappa2\\WPCS_Data",
                                        "\\\\valentine\\WPCS\\Kappa2\\WPCS_Feedback",
                                        true,
                                        50,
                                        50,
                                        210,
                                        5100,
                                        false,
                                        true,
                                        true,
                                        PrintColour.WHITE,
                                        user2,
                                        LocalDateTime.now(),
                                        null
                                ),
                        new Machine
                                (null,
                                        "Kappa3",
                                        "The Kappa 350 - A",
                                        "Kappa",
                                        "350",
                                        "\\\\valentine\\WPCS\\Kappa3\\WPCS_Data",
                                        "\\\\valentine\\WPCS\\Kappa3\\WPCS_Feedback",
                                        true,
                                        60,
                                        60,
                                        220,
                                        5200,
                                        false,
                                        true,
                                        true,
                                        PrintColour.BLACK,
                                        user1,
                                        LocalDateTime.now(),
                                        null
                                ),
                        new Machine
                                (null,
                                        "Zeta1",
                                        "The Zeta 115 - A",
                                        "Zeta",
                                        "115",
                                        "\\\\valentine\\WPCS\\Zeta1\\WPCS_Data",
                                        "\\\\valentine\\WPCS\\Zeta1\\WPCS_Feedback",
                                        true,
                                        70,
                                        70,
                                        230,
                                        5300,
                                        true,
                                        true,
                                        true,
                                        PrintColour.BOTH,
                                        user2,
                                        LocalDateTime.now(),
                                        null
                                ),
                        new Machine
                                (null,
                                        "Zeta2",
                                        "The Zeta 115 - A",
                                        "Zeta",
                                        "115",
                                        "\\\\valentine\\WPCS\\Zeta2\\WPCS_Data",
                                        "\\\\valentine\\WPCS\\Zeta2\\WPCS_Feedback",
                                        true,
                                        80,
                                        80,
                                        280,
                                        20800,
                                        true,
                                        true,
                                        true,
                                        PrintColour.BOTH,
                                        user1,
                                        LocalDateTime.now(),
                                        null
                                ))
                .forEach( machineRepo::save );
    }
}
