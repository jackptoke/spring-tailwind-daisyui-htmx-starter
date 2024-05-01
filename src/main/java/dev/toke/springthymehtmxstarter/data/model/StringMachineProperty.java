package dev.toke.springthymehtmxstarter.data.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Data
@DiscriminatorValue("String")
public class StringMachineProperty extends MachineProperty {
    private String stringValue = "";

    @Override
    public DataType getType() {
        return DataType.String;
    }
}
