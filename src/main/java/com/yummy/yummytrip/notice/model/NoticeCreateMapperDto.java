package com.yummy.yummytrip.notice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NoticeCreateMapperDto {
    private String title;
    private String content;
    private Long userId;

    public NoticeCreateMapperDto(NoticeCreateRequestDto requestDto, Long userId) {
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
        this.userId = userId;
    }
}
