package com.yummy.yummytrip.notice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NoticeUpdateRequestDto {
    private Long noticeId;
    private String title;
    private String content;
}
