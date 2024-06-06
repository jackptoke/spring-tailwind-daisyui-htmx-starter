package dev.toke.springthymehtmxstarter.service;

import dev.toke.springthymehtmxstarter.data.dto.AmeUserDto;

import java.util.List;

public interface AmeUserService {
    List<AmeUserDto> getUsers();
    AmeUserDto getUser(String username);
}
