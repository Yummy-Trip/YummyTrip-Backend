package com.yummy.yummytrip.attraction.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAttractionResponseDto {
    private Long attractionId;
    private int gugunCode;
    private int sidoCode;
    private Long attractiontypeId;
    private String title;
    private String addr1;
    private String addr2;
    private String zipcode;
    private String tel;
    private String firstImage;
    private String firstImage2;
    private int readCount;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private String mlevel;
}
