package com.yummy.yummytrip.attraction.service;

import com.yummy.yummytrip.attraction.mapper.AttractionMapper;
import com.yummy.yummytrip.attraction.model.AttractionSearchRequestDto;
import com.yummy.yummytrip.attraction.model.GetAttractionResponseDto;
import com.yummy.yummytrip.exception.CustomException;
import com.yummy.yummytrip.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class AttractionService {
    private final AttractionMapper mapper;

    public GetAttractionResponseDto getAttractionById(Long attractionId) {
        return findAttraction(attractionId);
    }

    public List<GetAttractionResponseDto> getAttractionByFiltering(AttractionSearchRequestDto searchDto) {
        return mapper.getAttractionByFiltering(searchDto);
    }

    private GetAttractionResponseDto findAttraction(Long attractionId) {
        return mapper.getAttractionById(attractionId)
                .orElseThrow(() -> new CustomException(ErrorCode.DATA_NOT_EXISTS, "관광지가 존재하지 않습니다. (AttractionService)"));
    }
}
