package dev.toke.springthymehtmxstarter.utils;

import dev.toke.springthymehtmxstarter.data.model.*;
import dev.toke.springthymehtmxstarter.events.ResetMachineDataEvent;
import dev.toke.springthymehtmxstarter.repository.CableTypeRepo;
import dev.toke.springthymehtmxstarter.repository.MachineRepo;
import dev.toke.springthymehtmxstarter.repository.ProductionStatusRepo;
import dev.toke.springthymehtmxstarter.repository.UsersRolesRepo;
import dev.toke.springthymehtmxstarter.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.stream.Stream;

@Component
@RequiredArgsConstructor
public class Initializer {
    private final MachineRepo machineRepo;
    private final UserService userService;
    private final CableTypeRepo cableTypeRepo;
    private final ProductionStatusRepo productionStatusRepo;
    private final Random random = new Random();
    private final RoleService roleService;

    private final BatchOrderService batchOrderService;
    private final UsersRolesService usersRolesService;
    private final MaterialComponentService materialComponentService;

    @EventListener({ ApplicationReadyEvent.class, ResetMachineDataEvent.class})
    void reset() {
        machineRepo.deleteAll();
        userService.deleteAll();
        if(cableTypeRepo.findAll().isEmpty()) {
            Stream.of(
                    new CableType(null, "UNKNOWN TYPE"),
                    new CableType(null, "AVS"),
                    new CableType(null, "GXL"),
                    new CableType(null, "TXL"),
                    new CableType(null, "RADOX"),
                    new CableType(null, "PVC")
                    )
                    .forEach(cableTypeRepo::save);
        }

        Stream.of(new ProductionStatus(null, "Plan production process not started"),
                new ProductionStatus(null, "Plan Batches Assigned"),
                        new ProductionStatus(null, "Plan Articles Assigned to Machine"),
                        new ProductionStatus(null, "Plan Job Transfer started"),
                        new ProductionStatus(null, "Plan Job Transfer completed"),
                        new ProductionStatus(null, "Plan production started"),
                        new ProductionStatus(null, "Plan production completed"),
                        new ProductionStatus(null, "Komax Production Plan on hold"))
                .forEach(productionStatusRepo::save);

        if(batchOrderService.getUnplannedBatchOrders().isEmpty()){
            for(int i = 0; i < 10; i++){
                String harness = getRandomString(5, true) + "-" + getRandomString(5, true) + "-" + getRandomString(3, true);
                String revision = switch (random.nextInt(5)){
                    case 0 -> "A";
                    case 1 -> "B";
                    case 2 -> "C";
                    case 3 -> "D";
                    case 4 -> "E";
                    default -> throw new IllegalStateException("Unexpected value: " + random.nextInt(5));
                };
                int quantity = random.nextInt(10) + 1;
                int circuitCount = random.nextInt(100) + 1;
                int terminalCount = random.nextInt(100) + 1;

                String customer = switch (random.nextInt(10)) {
                    case 0 -> "A2K";
                    case 1 -> "AAMP";
                    case 2 -> "ABAR";
                    case 3 -> "ABB";
                    case 4 -> "ABLE";
                    case 5 -> "ABLER";
                    case 6 -> "ABLESZ";
                    case 7 -> "ABSOLUT";
                    case 8 -> "ABTC";
                    case 9 -> "ABTECH";
                    default -> throw new IllegalStateException("Unexpected value: " + random.nextInt(10));
                };

                String siteName = switch (random.nextInt(2)) {
                    case 0 -> "ARARAT";
                    case 1 -> "MELBOURNE";
                    default -> throw new IllegalStateException("Unexpected value: " + random.nextInt(2));
                };

                String deliverySite = switch (random.nextInt(2)) {
                    case 0 -> "ARARAT";
                    case 1 -> "MELBOURNE";
                    default -> throw new IllegalStateException("Unexpected value: " + random.nextInt(2));
                };

                String deliveryLocation = switch (random.nextInt(3)) {
                    case 0 -> "FGOODS";
                    case 1 -> "wip_BATT";
                    case 2 -> "wip_BATT";
                    default -> throw new IllegalStateException("Unexpected value: " + random.nextInt(3));
                };
                String releaseLocation = switch (random.nextInt(2)) {
                    case 0 -> "Cutting";
                    case 1 -> "PREASSY";
                    default -> throw new IllegalStateException("Unexpected value: " + random.nextInt(3));
                };

                LocalDate releaseDueDate = LocalDate.of(2024, 05, random.nextInt(31)+1);

                BatchOrder batchOrder = new BatchOrder(
                        null, harness, revision, quantity, circuitCount, terminalCount,
                         customer, siteName, deliverySite, deliveryLocation, releaseLocation,
                        "", null, releaseDueDate,
                        null, null, LocalDateTime.now(), null,
                        "jackt", "");
                batchOrderService.createBatchOrder(batchOrder);
            }
        }

        Stream.of(
                new Role("Planning Supervisor", "This user has the highest privilege within the Planning department"),
                new Role("Planning User", "This is a regular user in the Planning department"),
                new Role("Dispatch Supervisor", "This is the user with the highest privilege within Dispatch"),
                new Role("Dispatch User", "This is the regular user in the Dispatch department")
                ).forEach(roleService::addRole);

        Stream.of(new User(null, "jackptoke", "jackptoke@gmail.com", "password", true, Collections.emptySet()),
                new User(null, "amytoke", "amytoke@gmail.com", "password", true, Collections.emptySet()),
                new User(null, "josiahtoke", "josiahtoke@gmail.com", "password", false, Collections.emptySet()),
                new User(null, "jeremiahtoke", "jeremiahtoke@gmail.com", "password", false, Collections.emptySet()),
                new User(null, "adrielletoke", "adrielletoke@gmail.com", "password", false, Collections.emptySet()),
                new User(null, "israeltoke", "israeltoke@gmail.com", "password", false, Collections.emptySet()))
                .forEach(userService::save);


        User user1 = userService.findByUsername("jackptoke");
        User user2 = userService.findByUsername("amytoke");
        Role role = roleService.getUserRoles().get(0);

        usersRolesService.addUserRole(new UsersRoles(null, user1, role));

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
                                        user1,
                                        LocalDateTime.now(),
                                        null,
                                        "",
                                        new HashSet<>()
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
                                        user2,
                                        LocalDateTime.now(),
                                        null,
                                        "",
                                        new HashSet<>()
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
                                        user1,
                                        LocalDateTime.now(),
                                        null,
                                        "",
                                        new HashSet<>()
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
                                        user2,
                                        LocalDateTime.now(),
                                        null,
                                        "",
                                        new HashSet<>()
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
                                        user1,
                                        LocalDateTime.now(),
                                        null,
                                        "",
                                        new HashSet<>()
                                ))
                .forEach( machineRepo::save );

        Stream.of(new MaterialComponent(
                "1BGE7800K014", "1BGE7800K014", "1BGE7800K014",
                "Some Kenworth part", user1, user1, UnitOfMeasurement.Each,
                0.250, UnitOfMeasurement.Kilogram, ComponentGroup.COMPONENT
                ),
                new MaterialComponent(
                        "A92-1422-103", "A92-1422-103", "A92-1422-103",
                        "Some Kenworth part", user1, user1, UnitOfMeasurement.Each,
                        1.55, UnitOfMeasurement.Kilogram, ComponentGroup.HARNESS
                )).forEach(materialComponentService::addComponent);
    }

    private String getRandomString(int length, boolean alphaOnly) {
        int leftLimit;
        if(alphaOnly) {
            leftLimit = 97;
        }
        else leftLimit = 48;
        int rightLimit = 122;

        return random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(length)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}
