package com.yummy.yummytrip.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ExistDataException extends RuntimeException {
    private final ErrorCode errorCode;
}
