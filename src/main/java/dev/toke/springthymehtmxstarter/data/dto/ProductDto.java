package dev.toke.springthymehtmxstarter.data.dto;

public record ProductDto(int id, String title, double price, String description, String category, String image, RatingDto rating) {
}
