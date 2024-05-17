package com.yummy.yummytrip.attraction.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AttractionSearchRequestDto {
    private String input;
    private int sidoCode;
    private int gugunCode;
    private int attractionTypeId;
}
