package dev.toke.springthymehtmxstarter.data.model;

public enum UnitOfMeasurement {
    Each("EA"),
    Gallon("GA"),
    Inch("IN"),
    Kilogram("KG"),
    Millimeter("MM"),
    Meter("MT"),
    Litre("LT");

    public final String name;
    UnitOfMeasurement(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
