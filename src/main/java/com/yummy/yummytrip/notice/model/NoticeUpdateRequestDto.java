package com.yummy.yummytrip.notice.model;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NoticeUpdateRequestDto {
    @NotNull(message = "공지사항을 수정하기 위해서는 공지사항 아이디가 필요합니다.")
    private Long noticeId;
    private String title;
    private String content;
}
