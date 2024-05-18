package com.yummy.yummytrip.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class InvalidPasswordException extends RuntimeException {
    private final ErrorCode errorCode;
}
