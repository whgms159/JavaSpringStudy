package com.kosta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kosta.dto.ProductDTO;
import com.kosta.dto.UserDTO;
import com.kosta.service.ProductService;
import com.kosta.service.UserService;

@Controller
@RequestMapping("/notebook")
public class NotebookController {
	@Autowired
	private ProductService ps;
	@Autowired
	private UserService us;
	
	
	//상품 화면
	@RequestMapping(value= {"","/","/notebook"})
	public ModelAndView showProductList() throws Exception{
		ModelAndView mav = new ModelAndView("product/productlist");
		List<ProductDTO> productList = ps.getAllProductList();
		mav.addObject("productlist", productList);
		//상품 가져오기
		return mav;
	}
	//상품 등록 화면
	@GetMapping("/dr")
	public String showProductDr(Model model) throws Exception{
		List<UserDTO> userList = us.getAllUserList();
		model.addAttribute("users",userList);
		return "product/dr";
	}
	//상품 등록
	@PostMapping("/dr")
	public String drProduct(ProductDTO proDTO) throws Exception{
		ps.addProduct(proDTO);
		return "redirect:/notebook";
		
	}
	//상품 삭제
	@DeleteMapping("/delete")
	public String deleteProduct(@RequestParam("id") int id)throws Exception{
		ps.removeProduct(id);
		return "redirect:/notebook";
	}
	
	//상품 수정 화면
	@GetMapping("/modify")
	public ModelAndView showProductModify(@RequestParam("id") int id)throws Exception{
		ModelAndView mav=new ModelAndView("product/dr");
		return mav;
	}
	
	//상품 수정
	@PostMapping("/modify")
	public String modifyProduct(ProductDTO proDTO) throws Exception{
		ps.modifyProduct(proDTO);
		return "redirect:/notebook";
	}
	//상품 상세보기
	@GetMapping("/detail/{id}")
	public ModelAndView showProductDetail(@PathVariable int id) throws Exception{
		ModelAndView mav = new ModelAndView("product/detail");
		ProductDTO proDTO = ps.getProduct(id);
		mav.addObject("product", proDTO);
		return mav;
	}

	//파일 이미지 다운로드
}
