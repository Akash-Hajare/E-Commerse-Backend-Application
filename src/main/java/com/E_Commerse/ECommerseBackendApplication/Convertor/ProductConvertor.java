package com.E_Commerse.ECommerseBackendApplication.Convertor;

import com.E_Commerse.ECommerseBackendApplication.Enum.ProductStatus;
import com.E_Commerse.ECommerseBackendApplication.Models.Product;
import com.E_Commerse.ECommerseBackendApplication.RequestDto.ProductRequestDto;
import com.E_Commerse.ECommerseBackendApplication.ResponseDto.ProductResponseDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ProductConvertor {

    public static Product productRequestDtotoProduct(ProductRequestDto productRequestDto){

        return Product.builder()
                .productName(productRequestDto.getProductName())
                .price(productRequestDto.getPrice())
                .quantity(productRequestDto.getQuantity())
                .productCategory(productRequestDto.getProductCategory())
                .productStatus(ProductStatus.AVAILABLE)
                .build();
    }

    public static ProductResponseDto productToProductResponseDto(Product product){

        return ProductResponseDto.builder()
                .name(product.getProductName())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .productStatus(product.getProductStatus())
                .build();
    }
}