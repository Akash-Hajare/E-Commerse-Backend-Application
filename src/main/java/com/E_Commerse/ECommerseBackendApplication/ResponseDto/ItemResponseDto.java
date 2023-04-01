package com.E_Commerse.ECommerseBackendApplication.ResponseDto;

import com.E_Commerse.ECommerseBackendApplication.Enum.ProductCategory;
import com.E_Commerse.ECommerseBackendApplication.Enum.ProductStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemResponseDto {

    private String productName;

    private int price;

    private ProductCategory productCategory;

    private ProductStatus productStatus;
}