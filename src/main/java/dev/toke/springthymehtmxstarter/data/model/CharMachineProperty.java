package dev.toke.springthymehtmxstarter.data.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Data
@DiscriminatorValue("Char")
public class CharMachineProperty extends MachineProperty {
    private char charValue;

    @Override
    public DataType getType() {
        return DataType.Char;
    }
}
