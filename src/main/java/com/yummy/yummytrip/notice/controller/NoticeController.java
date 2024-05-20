package com.yummy.yummytrip.notice.controller;

import com.yummy.yummytrip.notice.model.NoticeCreateRequestDto;
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
}
