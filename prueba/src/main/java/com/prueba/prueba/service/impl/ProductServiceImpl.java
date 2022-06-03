package com.prueba.prueba.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.transaction.annotation.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.prueba.dto.NewProductDTO;
import com.prueba.prueba.dto.ProductDTO;
import com.prueba.prueba.model.Product;
import com.prueba.prueba.repository.ProductRepository;
import com.prueba.prueba.service.ProductService;
import com.prueba.prueba.exception.ResourceNotFoundException;

@Service
public class ProductServiceImpl implements ProductService{
   
    final ModelMapper modelMapper;
    final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(@Autowired ProductRepository repository, ModelMapper mapper){
        this.productRepository = repository;
        this.modelMapper = mapper;
    }

    @Override
    @Transactional
    public ProductDTO create(NewProductDTO productDTO) {
        Product product = modelMapper.map(productDTO, Product.class);
        productRepository.save(product);        
        return modelMapper.map(product, ProductDTO.class); 
    }

    @Override
    @Transactional(readOnly = true)
    public ProductDTO retrieve(Long id) {
        Product product = productRepository.findById(id)
            .orElseThrow(()-> new ResourceNotFoundException("Product not found"));
        return modelMapper.map(product, ProductDTO.class);
    }

    @Override
    @Transactional
    public ProductDTO update(ProductDTO productDTO, Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Product not valid"));
        
        product.setId(id);
        product = modelMapper.map(productDTO, Product.class);
        productRepository.save(product);       

        return modelMapper.map(product, ProductDTO.class);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Product product = productRepository.findById(id)
        .orElseThrow(()-> new ResourceNotFoundException("Product not found"));        
        productRepository.deleteById(product.getId());        
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<ProductDTO> list() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(product -> modelMapper.map(product, ProductDTO.class))
            .collect(Collectors.toList());        
    }
    
}
