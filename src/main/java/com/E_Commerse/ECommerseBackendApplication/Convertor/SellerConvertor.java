package com.E_Commerse.ECommerseBackendApplication.Convertor;

import com.E_Commerse.ECommerseBackendApplication.Models.Seller;
import com.E_Commerse.ECommerseBackendApplication.RequestDto.SellerRequestDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class SellerConvertor {

    public static Seller SellerRequestDtoToSeller(SellerRequestDto sellerRequestDto){

        return Seller.builder()
                .name(sellerRequestDto.getName())
                .email(sellerRequestDto.getEmail())
                .mobNo(sellerRequestDto.getMobNo())
                .panNo(sellerRequestDto.getPanNo())
                .build();
    }
}