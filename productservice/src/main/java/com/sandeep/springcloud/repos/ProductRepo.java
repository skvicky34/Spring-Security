package com.sandeep.springcloud.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sandeep.springcloud.model.Product;

public interface ProductRepo extends JpaRepository<Product, Long> {

}
