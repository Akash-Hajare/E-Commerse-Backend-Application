package com.E_Commerse.ECommerseBackendApplication.Service;

import com.E_Commerse.ECommerseBackendApplication.Convertor.ProductConvertor;
import com.E_Commerse.ECommerseBackendApplication.Enum.ProductCategory;
import com.E_Commerse.ECommerseBackendApplication.Exception.SellerNotFoundException;
import com.E_Commerse.ECommerseBackendApplication.Models.Product;
import com.E_Commerse.ECommerseBackendApplication.Models.Seller;
import com.E_Commerse.ECommerseBackendApplication.Repository.ProductRepository;
import com.E_Commerse.ECommerseBackendApplication.Repository.SellerRepository;
import com.E_Commerse.ECommerseBackendApplication.RequestDto.ProductRequestDto;
import com.E_Commerse.ECommerseBackendApplication.ResponseDto.ProductResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    SellerRepository sellerRepository;
    @Autowired
    private ProductRepository productRepository;

    public ProductResponseDto addProduct(ProductRequestDto productRequestDto) throws SellerNotFoundException {

        Seller seller;

        try{
            seller = sellerRepository.findById(productRequestDto.getSellerId()).get();
        }
        catch(Exception e){
            throw new SellerNotFoundException("Invalid Seller Id");
        }

        Product product = ProductConvertor.productRequestDtotoProduct(productRequestDto);
        product.setSeller(seller);

        seller.getProducts().add(product);

        // saved the seller and product - parent and child
        sellerRepository.save(seller);

        // prepare response
        ProductResponseDto productResponseDto = ProductConvertor.productToProductResponseDto(product);
        return productResponseDto;
    }

    public List<ProductResponseDto> getProductsByCategory(ProductCategory productCategory){

        List<Product> products = productRepository.findAllByProductCategory(productCategory);

        // prepare a list of response dtos
        List<ProductResponseDto> productResponseDtos = new ArrayList<>();
        for(Product product: products){
            ProductResponseDto productResponseDto = ProductConvertor.productToProductResponseDto(product);
            productResponseDtos.add(productResponseDto);
        }

        return productResponseDtos;
    }

}
