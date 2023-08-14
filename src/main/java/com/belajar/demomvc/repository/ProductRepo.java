package com.belajar.demomvc.repository;

import com.belajar.demomvc.entity.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepo extends CrudRepository<Product, Long> {

    List<Product> findByNameContains(String keyword);

}
