package com.kosta.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kosta.entity.Article;

@Repository
public interface BlogRepository extends JpaRepository<Article, Long>{

	List<Article> findAllByTitleContainsOrContentContains(String string, String string2);

	List<Article> findAllByOrderByTitleDesc();

	List<Article> findAllByOrderByTitleAsc();

	List<Article> findByTitleContainsOrContentContainsOrderByTitleDesc(String keyword, String keyword2);

	List<Article> findByTitleContainsOrContentContainsOrderByTitleAsc(String keyword, String keyword2);
}
