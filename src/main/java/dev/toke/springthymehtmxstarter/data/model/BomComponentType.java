package dev.toke.springthymehtmxstarter.data.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "BOMComponentTypes")
@Getter
@Setter
public class BomComponentType {
    @Id
    @Setter(AccessLevel.PROTECTED)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String updateUser;
    private LocalDateTime updateTimestamp;
    private String insertUser;
    private LocalDateTime insertTimestamp;
}