package com.rayllanderson.dsdeliver.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rayllanderson.dsdeliver.dto.ProductDTO;
import com.rayllanderson.dsdeliver.services.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;
    
    @GetMapping
    public ResponseEntity<List<ProductDTO>> findll(){
	List<ProductDTO> list = service.findAll();
	return ResponseEntity.ok(list);
    }
}
