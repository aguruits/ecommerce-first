package com.ecomm.ecommproductservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecomm.ecommproductservice.model.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer>{

}
