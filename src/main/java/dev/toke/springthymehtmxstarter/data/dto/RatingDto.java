package dev.toke.springthymehtmxstarter.data.dto;

import com.fasterxml.jackson.annotation.JsonValue;

public record RatingDto(double rate, int count) {
    
}
