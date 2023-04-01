package com.E_Commerse.ECommerseBackendApplication.Repository;

import com.E_Commerse.ECommerseBackendApplication.Models.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item,Integer> {
}