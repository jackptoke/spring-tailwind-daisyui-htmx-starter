package dev.toke.springthymehtmxstarter.data.dto;

import com.fasterxml.jackson.annotation.JsonValue;

public enum SortType {
    BatchSort(1),
    TrolleySort(2),
    FullyOptimised(3);

    private int value;
    SortType(int value) {
        this.value = value;
    }

    @JsonValue
    public int getValue() {
        return this.value;
    }
}