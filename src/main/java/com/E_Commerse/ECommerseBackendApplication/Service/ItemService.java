package com.E_Commerse.ECommerseBackendApplication.Service;

import com.E_Commerse.ECommerseBackendApplication.Exception.ProductNotFoundException;
import com.E_Commerse.ECommerseBackendApplication.Models.Item;
import com.E_Commerse.ECommerseBackendApplication.Models.Product;
import com.E_Commerse.ECommerseBackendApplication.Repository.ProductRepository;
import com.E_Commerse.ECommerseBackendApplication.ResponseDto.ItemResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    @Autowired
    ProductRepository productRepository;

    public ItemResponseDto viewItem(int productId) throws ProductNotFoundException {

        Product product;
        try {
            product = productRepository.findById(productId).get();
        } catch (Exception e) {
            throw new ProductNotFoundException("Sorry! Invalid product id.");
        }

        Item item = Item.builder()
                .requiredQuantity(0)
                .product(product)
                .build();

        // map item to product
        product.setItem(item);

        // save both item and product
        productRepository.save(product);

        // prepare the response dto
        ItemResponseDto itemResponseDto = ItemResponseDto.builder()
                .productName(product.getProductName())
                .price(product.getPrice())
                .productCategory(product.getProductCategory())
                .productStatus(product.getProductStatus())
                .build();

        return itemResponseDto;
    }
}

