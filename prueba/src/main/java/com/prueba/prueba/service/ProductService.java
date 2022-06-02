package com.prueba.prueba.service;

import java.util.List;

import com.prueba.prueba.dto.NewProductDTO;
import com.prueba.prueba.dto.ProductDTO;

public interface ProductService {
    public ProductDTO create (NewProductDTO productDTO);
    public ProductDTO retrieve (Long id);
    public ProductDTO update (ProductDTO productDTO, Long id);
    public void delete (Long id);
    public List<ProductDTO> list();
}
