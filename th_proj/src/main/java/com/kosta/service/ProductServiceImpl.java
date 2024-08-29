package com.kosta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosta.dto.ProductDTO;
import com.kosta.mapper.ProductMapper;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductMapper pm;	
	
	@Override
	public List<ProductDTO> getAllProductList() throws Exception {
		
		return pm.selectAllProduct();
	}

	@Override
	public void addProduct(ProductDTO proDTO) throws Exception {
		pm.insertProduct(proDTO);
		
	}

	@Override
	public void removeProduct(int id) throws Exception {
		pm.deleteProduct(id);
		
	}

	@Override
	public ProductDTO getProduct(int id) throws Exception {
		return pm.getProduct(id);
		
	}

	@Override
	public void modifyProduct(ProductDTO proDTO) throws Exception {
		pm.modifyProduct(proDTO);
		
	}

}
