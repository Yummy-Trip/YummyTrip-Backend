package com.yummy.yummytrip.notice.service;

import com.yummy.yummytrip.exception.CustomException;
import com.yummy.yummytrip.exception.ErrorCode;
import com.yummy.yummytrip.notice.mapper.NoticeMapper;
import com.yummy.yummytrip.notice.model.GetNoticeResponseDto;
import com.yummy.yummytrip.notice.model.NoticeCreateRequestDto;
import com.yummy.yummytrip.notice.model.NoticeUpdateRequestDto;
import com.yummy.yummytrip.user.mapper.UserMapper;
import com.yummy.yummytrip.user.model.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class NoticeService {
    private final NoticeMapper noticeMapper;
    private final UserMapper userMapper;

    public Boolean createNotice(NoticeCreateRequestDto requestDto, String email) {
        UserDto userDto = userMapper.findByEmail(email);
        GetNoticeResponseDto mapperDto = GetNoticeResponseDto
                .builder()
                .title(requestDto.getTitle())
                .content(requestDto.getContent())
                .userId(userDto.getUserId())
                .build();
        return noticeMapper.insertNotice(mapperDto) > 0;
    }

    public GetNoticeResponseDto getNoticeById(Long noticeId) {
        return findNotice(noticeId);
    }

    public List<GetNoticeResponseDto> getNotices() {
        return noticeMapper.selectAllNotices();
    }

    public void updateNotice(NoticeUpdateRequestDto requestDto) {
        noticeMapper.updateNotice(requestDto);
    }

    public void deleteNotice(Long noticeId) {
        noticeMapper.deleteNotice(noticeId);
    }

    private GetNoticeResponseDto findNotice(Long noticeId) {
        return noticeMapper.getNoticeById(noticeId)
                .orElseThrow(() -> new CustomException(ErrorCode.DATA_NOT_EXISTS, "공지사항이 존재하지 않습니다. (NoticeService)"));
    }
}
