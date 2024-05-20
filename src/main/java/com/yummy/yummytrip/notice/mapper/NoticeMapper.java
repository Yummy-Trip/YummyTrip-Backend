package com.yummy.yummytrip.notice.mapper;

import com.yummy.yummytrip.notice.model.GetNoticeResponseDto;
import com.yummy.yummytrip.notice.model.NoticeCreateRequestDto;
import com.yummy.yummytrip.notice.model.NoticeUpdateRequestDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface NoticeMapper {
    int insertNotice(NoticeCreateRequestDto requestDto);
    Optional<GetNoticeResponseDto> getNoticeById(@Param("noticeId") Long noticeId);
    List<GetNoticeResponseDto> selectAllNotices();
    void updateNotice(NoticeUpdateRequestDto requestDto);
    void deleteNotice(@Param("noticeId") Long noticeId);
}
