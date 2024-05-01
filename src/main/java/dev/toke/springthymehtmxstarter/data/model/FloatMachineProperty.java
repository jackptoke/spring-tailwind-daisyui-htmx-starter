package dev.toke.springthymehtmxstarter.data.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Data
@DiscriminatorValue("Float")
public class FloatMachineProperty extends MachineProperty {
    private Float floatValue = 0.0f;

    @Override
    public DataType getType() {
        return DataType.Float;
    }
}
