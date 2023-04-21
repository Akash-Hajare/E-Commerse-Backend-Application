package com.E_Commerse.ECommerseBackendApplication.Service;

import com.E_Commerse.ECommerseBackendApplication.Convertor.CustomerConvertor;
import com.E_Commerse.ECommerseBackendApplication.Models.Cart;
import com.E_Commerse.ECommerseBackendApplication.Models.Customer;
import com.E_Commerse.ECommerseBackendApplication.Repository.CustomerRepository;
import com.E_Commerse.ECommerseBackendApplication.RequestDto.CustomerRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public String addCustomer(CustomerRequestDto customerRequestDto){

        Customer customer = CustomerConvertor.CustomerRequestDtoToCustomer(customerRequestDto);

        // allocate a cart to customer
        Cart cart = new Cart();
        cart.setCartTotal(0);
        cart.setCustomer(customer);

        // set cart in customer
        customer.setCart(cart);

        customer=customerRepository.save(customer);
        return "Congrats !! Welcome to E -Market.";
    }
}