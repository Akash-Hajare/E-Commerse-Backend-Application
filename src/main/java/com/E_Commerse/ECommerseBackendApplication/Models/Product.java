package com.E_Commerse.ECommerseBackendApplication.Models;

import com.E_Commerse.ECommerseBackendApplication.Enum.ProductCategory;
import com.E_Commerse.ECommerseBackendApplication.Enum.ProductStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name="product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String productName;

    private int price;

    private int quantity;

    @Enumerated(EnumType.STRING)
    private ProductCategory productCategory;

    @Enumerated(EnumType.STRING)
    private ProductStatus productStatus;

    @ManyToOne
    @JoinColumn
    private Seller seller;

    @OneToOne(mappedBy = "product",cascade = CascadeType.ALL)
    private Item item;


}
