package com.yummy.yummytrip.notice.service;

import com.yummy.yummytrip.exception.CustomException;
import com.yummy.yummytrip.exception.ErrorCode;
import com.yummy.yummytrip.notice.mapper.NoticeMapper;
import com.yummy.yummytrip.notice.model.GetNoticeResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class NoticeService {
    private final NoticeMapper mapper;

    private GetNoticeResponseDto findNotice(Long noticeId) {
        return mapper.getNoticeById(noticeId)
                .orElseThrow(() -> new CustomException(ErrorCode.DATA_NOT_EXISTS, "공지사항이 존재하지 않습니다. (NoticeService)"));
    }
}
