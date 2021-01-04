package com.rayllanderson.dsdeliver.services;

import java.util.List;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rayllanderson.dsdeliver.dto.ProductDTO;
import com.rayllanderson.dsdeliver.entities.Product;
import com.rayllanderson.dsdeliver.repositories.ProductRepository;

@Service //anotação para que seja injetado em outros componentes usando @Autowired
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Transactional(readOnly = true)
    public List<ProductDTO> findAll(){
	List<Product> list = repository.findAllByOrderByNameAsc();
	return list.stream().map(x -> new ProductDTO(x)).collect(Collectors.toList());
    }
}
