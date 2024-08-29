package com.kosta.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kosta.dto.ProductDTO;

@Mapper
public interface ProductMapper {
		//노 삭제 상품 리스트
		List<ProductDTO> selectAllProduct() throws Exception;
		//상품 추가
		void insertProduct(ProductDTO proDTO) throws Exception;
		//상품 삭제
		void deleteProduct(int id) throws Exception;
		//상품 가져오기
		ProductDTO getProduct(int id) throws Exception;
		//상품 수정
		void modifyProduct(ProductDTO proDTO) throws Exception;
		
	
}
