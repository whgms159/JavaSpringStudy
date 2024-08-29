package com.kosta.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kosta.entity.Article;

@Service
public interface BlogService {

	Article addArticle(Article article)throws Exception;

	List<Article> findAll() throws Exception;

	Article findById(int id) throws Exception;

	void deleteArticle(int id)throws Exception;

	void modifyPage(int id) throws Exception;

	Article modifyArticle(Article article)throws Exception;

	List<Article> findByTitle(String title)throws Exception;



}
