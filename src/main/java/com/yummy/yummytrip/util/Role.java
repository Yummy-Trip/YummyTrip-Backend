package com.yummy.yummytrip.util;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Role {
    USER("USER"), ADMIN("ADMIN");

    private final String value;

}
