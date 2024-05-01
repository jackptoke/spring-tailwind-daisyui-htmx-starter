package dev.toke.springthymehtmxstarter.data.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity(name = "MachineProperty")
@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        name = "propertyType",
        discriminatorType = DiscriminatorType.STRING)
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "propertyType")
@JsonSubTypes({
        @JsonSubTypes.Type(value = BooleanMachineProperty.class, name = "Boolean"),
        @JsonSubTypes.Type(value = CharMachineProperty.class, name = "Char"),
        @JsonSubTypes.Type(value = ColourMachineProperty.class, name = "Colour"),
        @JsonSubTypes.Type(value = FloatMachineProperty.class, name = "Float"),
        @JsonSubTypes.Type(value = IntegerMachineProperty.class, name = "Integer"),
        @JsonSubTypes.Type(value = StringMachineProperty.class, name = "String"),
})
public abstract class MachineProperty {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank
    private String propertyName;
    public abstract DataType getType();
}
