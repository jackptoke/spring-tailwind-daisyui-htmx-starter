package dev.toke.springthymehtmxstarter.data.dto;

import dev.toke.springthymehtmxstarter.data.model.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BillOfMaterialDTO implements Serializable {
    private Long billOfMaterialsId;
    private String circuitName;
    private Integer priceCategoryId;
    private String updateUser;
    private LocalDateTime updateTimestamp;
    private String insertUser;
    private LocalDateTime insertTimestamp;
    private Double quantity;
    private String unitOfMeasurement;

    private String componentType;
    private String bomComponent;
    private String harnessPartNumber;
    private String harnessRevision;

    private EngineerInstruction engineerInstruction;
    private Circuit circuit;
    private CircuitCableEndDTO cableEnd;
    private Long parent;
}
