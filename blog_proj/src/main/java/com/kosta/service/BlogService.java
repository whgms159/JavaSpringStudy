package com.kosta.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kosta.entity.Article;
import com.kosta.entity.User;

@Service
public interface BlogService {
	Article save(Article article, User user);
	
	List<Article> findAll();
	
	Article findById(Long id) throws Exception;
	
	Article update(Article article, User user) throws Exception;
	
	List<Article> searchAndOrder(String keyword, String order);

	void deletedById(Long id, User user) throws Exception;
}
