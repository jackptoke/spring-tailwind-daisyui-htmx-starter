package dev.toke.springthymehtmxstarter.data.model;

public enum UnitOfMaesurement {
    Each("EA"),
    Gallon("GA"),
    Inch("IN"),
    Kilogram("KG"),
    Millimeter("MM"),
    Meter("MT"),
    Litre("LT");

    public final String name;
    UnitOfMaesurement(String name) {
        this.name = name;
    }
}
