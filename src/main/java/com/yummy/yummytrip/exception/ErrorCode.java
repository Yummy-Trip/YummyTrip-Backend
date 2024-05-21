package com.yummy.yummytrip.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    PERMISSION_NOT_GRANTED_ERROR(HttpStatus.BAD_REQUEST, "권한이 없습니다."),
    INVALID_PARAMETER(HttpStatus.BAD_REQUEST, "잘못된 파라미터입니다."),
    INVALID_OPTIONS_REQUEST(HttpStatus.BAD_REQUEST, "잘못된 옵션으로 접근하였습니다."),
    DATA_NOT_EXISTS(HttpStatus.NOT_FOUND, "데이터가 존재하지 않습니다."),
    DATA_EXISTS(HttpStatus.CONFLICT, "데이터가 이미 존재합니다."),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "서버오류입니다. 관리자에게 문의하세요."),
    PARSE_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "데이터 파싱에 실패했습니다."),
    INVALID_PASSWORD(HttpStatus.UNAUTHORIZED, "잘못된 비밀번호입니다.");

    private final HttpStatus httpStatus;
    private final String message;
}
