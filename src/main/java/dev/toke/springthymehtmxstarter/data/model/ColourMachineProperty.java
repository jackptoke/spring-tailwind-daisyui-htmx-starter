package dev.toke.springthymehtmxstarter.data.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
@DiscriminatorValue("Colour")
public class ColourMachineProperty extends MachineProperty{
    private PrintColour colourValue = PrintColour.WHITE;

    @Override
    public DataType getType() {
        return DataType.Colour;
    }
}
