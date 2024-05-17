package com.yummy.yummytrip.attraction.controller;

import com.yummy.yummytrip.attraction.model.AttractionSearchRequestDto;
import com.yummy.yummytrip.attraction.model.GetAttractionResponseDto;
import com.yummy.yummytrip.attraction.service.AttractionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/attraction")
@Tag(name = "2. Attraction", description = "관광지 정보 CRUD")
public class AttractionController {
    private final AttractionService attractionService;

    // TODO : 관광지 업데이트

    @Operation(summary = "Get information on just one attraction.", description = "관광지 정보 조회 (단일 아이디)")
    @GetMapping("/{attractionId}")
    public ResponseEntity<GetAttractionResponseDto> getAttractionById(@PathVariable("attractionId") Long attractionId){
        return ResponseEntity.ok(attractionService.getAttractionById(attractionId));
    }

    @Operation(summary = "Get attractions filtered by address and place type.", description = "관광지 정보 조회 (주소, 장소타입, 검색어)")
    @GetMapping("/get")
    public ResponseEntity<List<GetAttractionResponseDto>> getAttractionByFiltering(
            @RequestBody AttractionSearchRequestDto searchDto
    ){
        return ResponseEntity.ok(attractionService.getAttractionByFiltering(searchDto));
    }
}
