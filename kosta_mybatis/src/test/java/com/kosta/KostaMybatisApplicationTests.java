package com.kosta;


import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.List;

import org.hamcrest.beans.HasPropertyWithValue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.kosta.dto.Community;
import com.kosta.service.CommunityService;


@SpringBootTest//애플리케이션 통합 테스트
@AutoConfigureMockMvc//MockMvc 자동 구성(일반 컨트롤러 테스트)
@MybatisTest//마이바티스 테스트야
class KostaMybatisApplicationTests {
	@Autowired
	protected MockMvc mockMvc;//HTTP를 모방해 테스트
	
	@Autowired
	private WebApplicationContext context;//스프링 설정과 빈을 관리하는 컨텍스트
	
	@BeforeEach
	public void mockMvcSetUp() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	@DisplayName("커뮤니티 리스트 테스트")
	@Test
	public void communityListTest() throws Exception{
		final String url="/community/list";
		final ResultActions result = mockMvc.perform(MockMvcRequestBuilders.get(url).accept(MediaType.TEXT_HTML));
		
		result
		// 응답상태가 200인지(OK)
		.andExpect(status().isOk())
		// 반환된 뷰가  community/communitylist.html 인지
		.andExpect(view().name("community/communitylist"))
		// 모델에 list 라는 속성이 있는지
		.andExpect(model().attributeExists("list"))
		// list 모델이 List 타입인지
		.andExpect(model().attribute("list", instanceOf(List.class)))
		// list 내부 구성요소가 Community DTO 로 구성되어 있는지
		.andExpect(model().attribute("list", everyItem(instanceOf(Community.class))))
		// list 내부 구성요소의 Community DTO에 title 값이 null 이 아니고, 빈 문자열도 아닌지
		.andExpect(model().attribute("list", everyItem(HasPropertyWithValue.hasProperty("title", notNullValue()))))
		// 응답 콘텐츠가 text/html;charset=UTF-8인지
		.andExpect(content().contentType("text/html;charset=UTF-8"));
	}
	@Autowired
	private CommunityService cs;
	@DisplayName("커뮤니티 리스트 서비스 테스트")
	@Test
	public void communityListServiceTest() throws Exception {
		List<Community> communityList = cs.getAllCommunity();
		
		assertThat(communityList).isNotNull();
		assertThat(communityList.size()).isEqualTo(4);
		assertThat(communityList.get(0).getTitle()).isEqualTo("공룡사진");
	}
	
}
