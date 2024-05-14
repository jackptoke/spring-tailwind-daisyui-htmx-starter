package dev.toke.springthymehtmxstarter.data.model;

public enum PrintColour {
    BLACK("BLACK"),
    WHITE("WHITE"),
    BOTH("BOTH"),
    NONE("NONE");

    private final String value;

    PrintColour(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
