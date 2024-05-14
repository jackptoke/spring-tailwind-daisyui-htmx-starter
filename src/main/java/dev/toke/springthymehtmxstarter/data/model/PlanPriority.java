package dev.toke.springthymehtmxstarter.data.model;

public enum PlanPriority {
    NORMAL("NORMAL"),
    MEDIUM("MEDIUM"),
    HIGH("HIGH"),
    URGENT("URGENT");

    private final String value;
    PlanPriority(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

}

