package dev.toke.springthymehtmxstarter.service.impl;

import dev.toke.springthymehtmxstarter.data.api.UserApi;
import dev.toke.springthymehtmxstarter.data.dto.AmeUserDto;
import dev.toke.springthymehtmxstarter.service.AmeUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AmeUserServiceImpl implements AmeUserService {
    private final UserApi userApi;

    @Override
    public List<AmeUserDto> getUsers() {
        return userApi.getUsers();
    }

    @Override
    public AmeUserDto getUser(String username) {
        return userApi.getUser(username);
    }
}
