package dev.toke.springthymehtmxstarter.data.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Data
@DiscriminatorValue("Boolean")
public class BooleanMachineProperty extends MachineProperty {
    private Boolean booleanValue = false;


    @Override
    public DataType getType() {
        return DataType.Boolean;
    }
}
