package com.E_Commerse.ECommerseBackendApplication.Repository;

import com.E_Commerse.ECommerseBackendApplication.Models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
