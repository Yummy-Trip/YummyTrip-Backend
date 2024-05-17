package com.yummy.yummytrip.attraction.controller;

import com.yummy.yummytrip.attraction.service.AttractionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/attraction")
public class AttractionController {
    private final AttractionService attractionService;
}
