package com.yummy.yummytrip.util;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@RequiredArgsConstructor
@Getter
public enum Role {
    USER("USER"), ADMIN("ADMIN");

    private final String value;

    public static Role findByValue(String value) {
        return Arrays.stream(Role.values())
                .filter(role -> role.getValue().equals(value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}

