package com.belajar.demomvc.service;

import com.belajar.demomvc.entity.Product;
import com.belajar.demomvc.repository.ProductRepo;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductRepo repo;

    public Iterable<Product> findAll() {
        return repo.findAll();
    }

    public void addProduct(Product product) {
        repo.save(product);
    }

    public void deleteById(long id) {
        repo.deleteById(id);
    }

    public Optional<Product> findById(long id) {
        return repo.findById(id);
    }

    public void updateProduct(Product product) {
        repo.save(product); // JPA akan pintar, entah ini save buat menyimpan data baru, atau update data yg sudah ada
                            // dengan melihat ID pada object-nya.
    }

    public List<Product> findByName(String keyword) {
        return repo.findByNameContains(keyword);
    }


}
