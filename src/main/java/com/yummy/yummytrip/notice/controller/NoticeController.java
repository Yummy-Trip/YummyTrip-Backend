package com.yummy.yummytrip.notice.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/notice")
@Tag(name = "2. Notice", description = "공지사항 정보 CRUD")
public class NoticeController {

}
