package com.yummy.yummytrip.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor
public class ErrorResponse {
    private final String code;
    private final String message;

    public ErrorResponse(ErrorCode errorCode){
        this.code = errorCode.toString();
        this.message = errorCode.getMessage();
    }

    public ErrorResponse(ErrorCode errorCode, String message){
        this.code = errorCode.toString();
        this.message = message;
    }

    @Override
    public String toString() {
        return "ErrorResponse{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
