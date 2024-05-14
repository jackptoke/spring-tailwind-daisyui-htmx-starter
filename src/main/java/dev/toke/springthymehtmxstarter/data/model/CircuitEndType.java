package dev.toke.springthymehtmxstarter.data.model;

public enum CircuitEndType {
    END1("END1"),
    END2("END2"),
    MIDDLE("MIDDLE"),
    WHOLE("WHOLE");
    private String endName;

    CircuitEndType(String endName) {
        this.endName = endName;
    }
}
