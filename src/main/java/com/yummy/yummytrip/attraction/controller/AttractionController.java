package com.yummy.yummytrip.attraction.controller;

import com.yummy.yummytrip.attraction.model.GetAttractionResponseDto;
import com.yummy.yummytrip.attraction.service.AttractionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/attraction")
public class AttractionController {
    private final AttractionService attractionService;

    // TODO : 관광지 업데이트

    @GetMapping("/{attractionId}")
    public ResponseEntity<GetAttractionResponseDto> getAttractionById(@PathVariable("attractionId") Long attractionId){
        return ResponseEntity.ok(attractionService.getAttractionById(attractionId));
    }
}
