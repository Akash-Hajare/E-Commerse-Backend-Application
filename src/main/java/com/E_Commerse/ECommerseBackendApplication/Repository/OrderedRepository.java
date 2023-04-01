package com.E_Commerse.ECommerseBackendApplication.Repository;

import com.E_Commerse.ECommerseBackendApplication.Models.Ordered;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderedRepository extends JpaRepository<Ordered,Integer> {

}
