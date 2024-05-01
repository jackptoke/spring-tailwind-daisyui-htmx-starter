package dev.toke.springthymehtmxstarter.data.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
@DiscriminatorValue("Integer")
public class IntegerMachineProperty extends MachineProperty {
    private Integer integerValue = 40;

    @Override
    public DataType getType() {
        return DataType.Integer;
    }
}
