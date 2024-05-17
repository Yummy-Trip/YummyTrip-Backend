package com.yummy.yummytrip.attraction.service;

import com.yummy.yummytrip.attraction.mapper.AttractionMapper;
import com.yummy.yummytrip.attraction.model.GetAttractionResponseDto;
import com.yummy.yummytrip.exception.CustomException;
import com.yummy.yummytrip.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AttractionService {
    private final AttractionMapper mapper;

    private GetAttractionResponseDto findAttraction(Long attractionId) {
        return mapper.getAttractionById(attractionId)
                .orElseThrow(() -> new CustomException(ErrorCode.DATA_NOT_EXISTS, "관광지가 존재하지 않습니다. (AttractionService)"));
    }
}
