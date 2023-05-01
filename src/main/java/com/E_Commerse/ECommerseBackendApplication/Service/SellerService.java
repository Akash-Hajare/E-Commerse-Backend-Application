package com.E_Commerse.ECommerseBackendApplication.Service;

import com.E_Commerse.ECommerseBackendApplication.Convertor.SellerConvertor;
import com.E_Commerse.ECommerseBackendApplication.Models.Seller;
import com.E_Commerse.ECommerseBackendApplication.Repository.SellerRepository;
import com.E_Commerse.ECommerseBackendApplication.RequestDto.SellerRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SellerService {

    @Autowired
    SellerRepository sellerRepo;
    @Autowired
    JavaMailSender emailSender;

    public String addSeller(SellerRequestDto sellerRequestDto){

        Seller seller = SellerConvertor.SellerRequestDtoToSeller(sellerRequestDto);
        seller=sellerRepo.save(seller);

        String response= "Congrats! Now you can sell on E- Market !!!" +
                "Your details are as mention below"+
                "\nName : "+seller.getName()+
                "\nEmail id :"+seller.getEmail()+
                "\nMobile No :"+seller.getMobNo()+
                "\nPan Card No : "+seller.getPanNo();
        // send an email
        //String text = "Congrats your order with total value "+order.getTotalCost()+" has been placed";

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("backendspringrocks@gmail.com");
        message.setTo("akashhajared11@gmail.com");
        message.setSubject("Seller Registration Notification");
        message.setText(response);
        emailSender.send(message);
        return response;
    }
}
