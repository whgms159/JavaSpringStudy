package com.kosta.service;

import java.util.List;

import com.kosta.dto.ProductDTO;

public interface ProductService {
		//삭제 안 된 리스트 가져오기
		List<ProductDTO> getAllProductList()throws Exception;
		//상품 추가하기
		void addProduct(ProductDTO proDTO)throws Exception;
		//상품 삭제하기
		void removeProduct(int id) throws Exception;
		//상품 정보 가져오기
		ProductDTO getProduct(int id) throws Exception;
		//상품 수정하기
		void modifyProduct(ProductDTO proDTO)throws Exception;
}
