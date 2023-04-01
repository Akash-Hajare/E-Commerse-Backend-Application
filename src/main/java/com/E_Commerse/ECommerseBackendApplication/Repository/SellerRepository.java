package com.E_Commerse.ECommerseBackendApplication.Repository;

import com.E_Commerse.ECommerseBackendApplication.Models.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerRepository extends JpaRepository<Seller,Integer> {
}