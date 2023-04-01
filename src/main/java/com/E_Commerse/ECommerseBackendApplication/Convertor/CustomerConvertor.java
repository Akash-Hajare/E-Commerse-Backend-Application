package com.E_Commerse.ECommerseBackendApplication.Convertor;

import com.E_Commerse.ECommerseBackendApplication.Models.Customer;
import com.E_Commerse.ECommerseBackendApplication.RequestDto.CustomerRequestDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CustomerConvertor {

    public static Customer CustomerRequestDtoToCustomer(CustomerRequestDto customerRequestDto){

        return Customer.builder()
                .name(customerRequestDto.getName())
                .age(customerRequestDto.getAge())
                .email(customerRequestDto.getEmail())
                .mobNo(customerRequestDto.getMobNo())
                .build();
    }
}