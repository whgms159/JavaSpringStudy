package com.kosta.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.kosta.entity.Article;

@DataJpaTest//JPA 관련 테스트
@AutoConfigureTestDatabase(replace=Replace.NONE)//실제 DB 사용
public class BlogRepositoryTest {
	@Autowired
	private BlogRepository blogRepository;
	
	//테스트 코드 패턴 : Given - When - Then / 주고 - 테스트 - 검증
	
	@Test
	@DisplayName("게시글 추가 테스트")
	public void saveArticle() {
		//g
		Article article = Article.builder().title("TEST title").content("TEST content").build();
		//w
		Article savedArticle = blogRepository.save(article);
		//t
		assertThat(savedArticle).isNotNull();
		assertThat(savedArticle.getId()).isNotNull();
		assertThat(savedArticle.getTitle()).isEqualTo("TEST title");
		assertThat(savedArticle.getContent()).isEqualTo("TEST content");
	}
	@Test
	@DisplayName("게시글 전체 조회 테스트")
	public void findAllTest() {
		//g
		Article article1 = Article.builder().title("제목1").content("내용1").build();
		blogRepository.save(article1);
	
		Article article2 = Article.builder().title("제목2").content("내용2").build();
		blogRepository.save(article2);
		//w
		List<Article> articleList = blogRepository.findAll();
		//t
		assertThat(articleList).isNotNull();
		assertThat(articleList.size()).isGreaterThanOrEqualTo(2);
		assertThat(articleList.stream().anyMatch(article -> article.getTitle().equals("제목1"))).isTrue();
		assertThat(articleList.stream().anyMatch(article -> article.getContent().equals("내용2"))).isTrue();
	}
	@Test
	@DisplayName("특정 게시물 조회(ID)")
	public void findByIdTest() {
		//g
		Article article = Article.builder().title("새로운 글 제목").content("새로운 글 내용").build();
		Article savedArticle = blogRepository.save(article);
		//w
		Article foundArticle = blogRepository.findById(savedArticle.getId()).get();
		
		
		//t
		assertThat(foundArticle).isNotNull();
		assertThat(foundArticle.getId()).isEqualTo(savedArticle.getId());
		assertThat(foundArticle.getTitle()).isEqualTo(savedArticle.getTitle());
		assertThat(foundArticle.getContent()).isEqualTo(savedArticle.getContent());
		
	}
	@Test
	@DisplayName("게시물 삭제")
	public void deleteById() {
		int originSize = blogRepository.findAll().size();
		Article article = Article.builder().title("새로운 글 제목").content("새로운 글 내용").build();
		Article savedArticle = blogRepository.save(article);
		
		blogRepository.deleteById(savedArticle.getId());
		int newSize = blogRepository.findAll().size();
		
		assertThat(originSize).isEqualTo(newSize);
	}
	@Test
	@DisplayName("게시물 수정")
	public void updateArticle() {
		Article article = Article.builder().title("새로운 글 제목").content("새로운 글 내용").build();
		Article savedArticle = blogRepository.save(article);
		
		Article foundArticle = blogRepository.findById(savedArticle.getId()).get();
		foundArticle.setTitle("변경된 글 제목");
		foundArticle.setContent("변경된 글 내용");
		
		Article changedArticle = blogRepository.findById(savedArticle.getId()).get();
		assertThat(foundArticle.getTitle()).isEqualTo(changedArticle.getTitle());
		assertThat(foundArticle.getContent()).isEqualTo(changedArticle.getContent());
	}
	
	@Test
	@DisplayName("제목 또는 내용 rjator & 정렬")
	public void searchByTitleOrContent() {
		Article article1 = Article.builder().title("에스파 - Supernova").content("슈슈슈슈슈퍼노바").build();
		Article savedArticle1 = blogRepository.save(article1);
		Article article2 = Article.builder().title("난 이게 좋아").content("에스파 넥스트레벨").build();
		Article savedArticle2 = blogRepository.save(article2);
		
		List<Article> resultList = blogRepository.findByTitleContainsOrContentContainsOrderByTitleAsc("에스파", "에스파");
		
		assertThat(resultList.indexOf(savedArticle1)).isGreaterThan(resultList.indexOf(savedArticle2));
		assertThat(resultList.stream().allMatch(article -> {return article.getTitle().contains("에스파") || article.getContent().contains("에스파");
		})).isTrue();
		
	}
}
