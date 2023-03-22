package com.programming.springsecuritylatest.service;

import com.programming.springsecuritylatest.dto.Product;
import com.programming.springsecuritylatest.model.UserInfo;
import com.programming.springsecuritylatest.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    List<Product> productList = null;

    @Autowired
    private UserInfoRepository repo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String addUser(UserInfo userInfo) {
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        repo.save(userInfo);
        return "user added to the system";
    }

    public List<Product> getAllProducts() {
        return productList;
    }

    public Product getProductById(int id) {
        return productList.stream()
                .filter(product -> product.getProductId()==id)
                .findAny()
                .orElseThrow(()->new RuntimeException("product " + id + " not found"));
    }
}
