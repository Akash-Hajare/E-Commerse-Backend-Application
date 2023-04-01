package com.E_Commerse.ECommerseBackendApplication.Service;

import com.E_Commerse.ECommerseBackendApplication.Convertor.SellerConvertor;
import com.E_Commerse.ECommerseBackendApplication.Models.Seller;
import com.E_Commerse.ECommerseBackendApplication.Repository.SellerRepository;
import com.E_Commerse.ECommerseBackendApplication.RequestDto.SellerRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerService {

    @Autowired
    SellerRepository sellerRepo;

    public String addSeller(SellerRequestDto sellerRequestDto){

        Seller seller = SellerConvertor.SellerRequestDtoToSeller(sellerRequestDto);
        sellerRepo.save(seller);

        return "Congrats! Now you can sell on Chine Market !!!";
    }
}
