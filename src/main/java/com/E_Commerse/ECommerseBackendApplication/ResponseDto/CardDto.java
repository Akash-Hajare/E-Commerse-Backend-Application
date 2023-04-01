package com.E_Commerse.ECommerseBackendApplication.ResponseDto;

import com.E_Commerse.ECommerseBackendApplication.Enum.CardType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CardDto {

    private String cardNo;

    private CardType cardType;

}
