package com.E_Commerse.ECommerseBackendApplication.Controller;

import com.E_Commerse.ECommerseBackendApplication.RequestDto.SellerRequestDto;
import com.E_Commerse.ECommerseBackendApplication.Service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/seller")
public class SellerController {

    @Autowired
    SellerService sellerService;

    @PostMapping("/add")
    public String addSeller(@RequestBody SellerRequestDto sellerRequestDto){
        return sellerService.addSeller(sellerRequestDto);
    }

    // Get all sellers

    // get a seller by PAN Card

    // find sellers of a particular age
}
/*
         http://localhost:8080:seller/add

         {
            "name" : "Puma" ,
            "mobNo" : "9898986932" ,
            "email" : "pumaindia@gmail.com"
            "panNo" : "AERZ457896LK"
         }
 */