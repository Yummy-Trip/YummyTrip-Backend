package com.yummy.yummytrip.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class EmptyDataException extends RuntimeException {
    private final ErrorCode errorCode;
}
