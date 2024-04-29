package dev.toke.springthymehtmxstarter.data.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Machine")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Machine {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank
    private String name;
    private String description;
    @NotBlank
    private String brand;
    @NotBlank
    private String model;
    private String dataPath;  // WPCS data path
    private String feedbackPath; // WPCS feedback path
    private Boolean isActive;

    private Integer cableThreshold = 40;
    private Integer termAndSealThreshold = 40;
    private Integer minimumLength = 60;
    private Integer maximumLength = 5000;
    private Boolean canChangeCable = false;
    private Boolean canChangeTerminal = false;
    private Boolean canCutAndStrip = false;
    private PrintColour printColour = PrintColour.WHITE;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
    @Setter(AccessLevel.NONE)
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

