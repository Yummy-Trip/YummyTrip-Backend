package com.yummy.yummytrip.attraction.mapper;

import com.yummy.yummytrip.attraction.model.AttractionSearchRequestDto;
import com.yummy.yummytrip.attraction.model.GetAttractionResponseDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface AttractionMapper {

    public Optional<GetAttractionResponseDto> getAttractionById(Long attractionId);

    public List<GetAttractionResponseDto> getAttractionByFiltering(AttractionSearchRequestDto searchDto);
}
