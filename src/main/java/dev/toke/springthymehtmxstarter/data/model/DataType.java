package dev.toke.springthymehtmxstarter.data.model;

public enum DataType {
    Boolean("BOOLEAN"),
    Char("CHAR"),
    Colour("COLOUR"),
    Double("DOUBLE"),
    Float("FLOAT"),
    Integer("INTEGER"),
    String("STRING");

    private final String value;
    DataType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
