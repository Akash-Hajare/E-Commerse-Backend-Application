package com.E_Commerse.ECommerseBackendApplication.Service;

import com.E_Commerse.ECommerseBackendApplication.Exception.CustomerNotFoundException;
import com.E_Commerse.ECommerseBackendApplication.Models.Card;
import com.E_Commerse.ECommerseBackendApplication.Models.Customer;
import com.E_Commerse.ECommerseBackendApplication.Repository.CustomerRepository;
import com.E_Commerse.ECommerseBackendApplication.RequestDto.CardRequestDto;
import com.E_Commerse.ECommerseBackendApplication.ResponseDto.CardDto;
import com.E_Commerse.ECommerseBackendApplication.ResponseDto.CardResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CardService {

    @Autowired
    CustomerRepository customerRepository;

    public CardResponseDto addCard(CardRequestDto cardRequestDto) throws CustomerNotFoundException {

        Customer customer;

        try {
            customer = customerRepository.findById(cardRequestDto.getCustomerId()).get();
        } catch (Exception e) {
            throw new CustomerNotFoundException("Invalid customer id");
        }

        // Make a card object
        Card card = Card.builder()
                .cardNo(cardRequestDto.getCardNo())
                .cvv(cardRequestDto.getCvv())
                .cardType(cardRequestDto.getCardType())
                .customer(customer)
                .build();

        // add the card to current card list of customer
        customer.getCards().add(card);

        customerRepository.save(customer); // save both customer and card

        // prepare Response Dto
        CardResponseDto cardResponseDto = new CardResponseDto();
        cardResponseDto.setName(customer.getName());

        // convert every card to cardDto
        List<CardDto> cardDtoList = new ArrayList<>();
        for (Card card1 : customer.getCards()) {
            CardDto cardDto = new CardDto();
            cardDto.setCardNo(card1.getCardNo());
            cardDto.setCardType(card1.getCardType());

            cardDtoList.add(cardDto);
        }

        cardResponseDto.setCardDtos(cardDtoList);
        return cardResponseDto;

    }
}
