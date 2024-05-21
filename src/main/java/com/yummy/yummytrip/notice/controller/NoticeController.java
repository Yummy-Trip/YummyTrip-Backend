package com.yummy.yummytrip.notice.controller;

import com.yummy.yummytrip.notice.model.GetNoticeResponseDto;
import com.yummy.yummytrip.notice.model.NoticeCreateRequestDto;
import com.yummy.yummytrip.notice.model.NoticeUpdateRequestDto;
import com.yummy.yummytrip.notice.service.NoticeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/notice")
@Tag(name = "2. Notice", description = "공지사항 정보 CRUD")
public class NoticeController {
    private final NoticeService noticeService;

    @Operation(summary = "Add notice.", description = "공지사항 작성")
    @PostMapping("/add")
    public ResponseEntity<Boolean> createNotice(
            @RequestBody @Valid NoticeCreateRequestDto requestDto
    ){
        return ResponseEntity.ok(noticeService.createNotice(requestDto));
    }

    @Operation(summary = "Get information on just one notice.", description = "공지사항 정보 조회 (단일 아이디)")
    @GetMapping("/{noticeId}")
    public ResponseEntity<GetNoticeResponseDto> getNoticeById(
            @PathVariable("noticeId") Long noticeId
    ){
        return ResponseEntity.ok(noticeService.getNoticeById(noticeId));
    }

    @Operation(summary = "Get all notices.", description = "공지사항 정보 전체 조회")
    @GetMapping("/get")
    public ResponseEntity<List<GetNoticeResponseDto>> getNotices(){
        return ResponseEntity.ok(noticeService.getNotices());
    }

    @Operation(summary = "Update notice By noticeId", description = "공지사항 수정")
    @PutMapping("/upadate")
    public ResponseEntity<Long> updateNotice(
            @RequestBody @Valid NoticeUpdateRequestDto requestDto
    ){
        noticeService.updateNotice(requestDto);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Delete notice By noticeId", description = "공지사항 삭제")
    @DeleteMapping("/delete/{noticeId}")
    public ResponseEntity<Void> deleteNotice(
            @PathVariable("noticeId") Long noticeId
    ){
        noticeService.deleteNotice(noticeId);
        return ResponseEntity.ok().build();
    }
}
