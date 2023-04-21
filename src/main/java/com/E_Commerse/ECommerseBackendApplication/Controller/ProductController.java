package com.E_Commerse.ECommerseBackendApplication.Controller;

import com.E_Commerse.ECommerseBackendApplication.Enum.ProductCategory;
import com.E_Commerse.ECommerseBackendApplication.RequestDto.ProductRequestDto;
import com.E_Commerse.ECommerseBackendApplication.ResponseDto.ProductResponseDto;
import com.E_Commerse.ECommerseBackendApplication.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/add") // http:localhost:8080/product/add
    public ResponseEntity addProduct(@RequestBody ProductRequestDto productRequestDto){

        ProductResponseDto productResponseDto;
        try{
            productResponseDto = productService.addProduct(productRequestDto);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity(productResponseDto,HttpStatus.ACCEPTED);
    }
/*
          http://localhost:8080/product/add

       {
          "sellerId": 5,
          "productName": "Realme c2 5G",
          "price": 10000,
          "quantity": 100,
          "productCategory": "ELECTRONICS"
      }


 */
    @GetMapping("/get/category/{productCategory}")
    public List<ProductResponseDto> getAllProductsByCategory(@PathVariable("productCategory") ProductCategory productCategory){

        return productService.getProductsByCategory(productCategory);
    }
}
/*
         http://localhost8080/product/get/category/SPORTS

 */