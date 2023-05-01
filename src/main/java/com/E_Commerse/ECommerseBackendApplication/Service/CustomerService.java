package com.E_Commerse.ECommerseBackendApplication.Service;

import com.E_Commerse.ECommerseBackendApplication.Convertor.CustomerConvertor;
import com.E_Commerse.ECommerseBackendApplication.Models.Cart;
import com.E_Commerse.ECommerseBackendApplication.Models.Customer;
import com.E_Commerse.ECommerseBackendApplication.Repository.CustomerRepository;
import com.E_Commerse.ECommerseBackendApplication.RequestDto.CustomerRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    JavaMailSender emailSender;

    public String addCustomer(CustomerRequestDto customerRequestDto){

        Customer customer = CustomerConvertor.CustomerRequestDtoToCustomer(customerRequestDto);

        // allocate a cart to customer
        Cart cart = new Cart();
        cart.setCartTotal(0);
        cart.setCustomer(customer);

        // set cart in customer
        customer.setCart(cart);
         //email
        String response="Congrats !! Welcome to E -Market."+
                "\nCustomer Details are mentioned below"+
                "\nCustomer Name "+customer.getName()+
                "\nAge "+customer.getAge()+
                "\nEmail id "+customer.getEmail()+
                "\nMobile Number "+customer.getMobNo();

        customer=customerRepository.save(customer);
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("backendspringrocks@gmail.com");
        message.setTo("akashhajared11@gmail.com");
        message.setSubject("Customer Registration Notification");
        message.setText(response);
        emailSender.send(message);

        return response;
    }
}