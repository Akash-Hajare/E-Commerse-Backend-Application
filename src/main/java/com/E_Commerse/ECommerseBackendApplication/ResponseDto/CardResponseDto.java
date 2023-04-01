package com.E_Commerse.ECommerseBackendApplication.ResponseDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CardResponseDto {

    private String name;

    private List<CardDto> cardDtos;
}