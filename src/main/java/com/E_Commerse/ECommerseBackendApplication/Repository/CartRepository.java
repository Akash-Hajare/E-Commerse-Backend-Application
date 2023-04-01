package com.E_Commerse.ECommerseBackendApplication.Repository;

import com.E_Commerse.ECommerseBackendApplication.Models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart,Integer> {

}
