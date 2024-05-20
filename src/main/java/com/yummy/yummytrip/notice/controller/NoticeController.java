package com.yummy.yummytrip.notice.controller;

import com.yummy.yummytrip.notice.model.GetNoticeResponseDto;
import com.yummy.yummytrip.notice.model.NoticeCreateRequestDto;
import com.yummy.yummytrip.notice.model.NoticeUpdateRequestDto;
import com.yummy.yummytrip.notice.service.NoticeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/notice")
@Tag(name = "2. Notice", description = "공지사항 정보 CRUD")
public class NoticeController {
    private final NoticeService noticeService;

    @PostMapping("/add")
    public ResponseEntity<Boolean> createNotice(
            @RequestBody NoticeCreateRequestDto requestDto
    ){
        return ResponseEntity.ok(noticeService.createNotice(requestDto));
    }

    @GetMapping("/{noticeId}")
    public ResponseEntity<GetNoticeResponseDto> getNoticeById(
            @PathVariable("noticeId") Long noticeId
    ){
        return ResponseEntity.ok(noticeService.getNoticeById(noticeId));
    }

    @GetMapping("/get")
    public ResponseEntity<List<GetNoticeResponseDto>> getNotices(){
        return ResponseEntity.ok(noticeService.getNotices());
    }

    @PostMapping("/upadate")
    public ResponseEntity<Long> updateNotice(
            @RequestBody NoticeUpdateRequestDto requestDto
    ){
        return ResponseEntity.ok(noticeService.updateNotice(requestDto));
    }

    @DeleteMapping("/delete/{noticeId}")
    public ResponseEntity<Void> deleteNotice(
            @PathVariable("noticeId") Long noticeId
    ){
        noticeService.deleteNotice(noticeId);
        return ResponseEntity.ok().build();
    }
}
