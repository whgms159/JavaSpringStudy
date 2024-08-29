package com.board.controller;

import java.nio.charset.StandardCharsets;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriUtils;

import com.board.dto.BoardDTO;
import com.board.dto.FileDTO;
import com.board.service.BoardService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller //컨트롤러 지정 애너테이션
@RequestMapping("/board")
public class BoardController {
	@Autowired//서비스 빈 자동ㅈ ㅜ입
	private BoardService bs;

	@RequestMapping("/list") //요청에 맞는 주소 지정
	public ModelAndView boardList() throws Exception {
		
		
		
		ModelAndView mv = new ModelAndView("board/list");//src/main/resources/templates/board/list.html 으로 화면 지정
		//비지니스 로직 수행
		
		List<BoardDTO> boardList = bs.selectBoardList();
		mv.addObject("list", boardList);
		return mv;
	}
	@GetMapping("/insert")
	public String boardInsertView()throws Exception {
		log.warn("글쓰기 페이지로 이동");
		return "board/write";
	}
	@PostMapping("/insert")
	public String boardInsert(BoardDTO boardDTO, @RequestParam(value = "files", required = false) List<MultipartFile> files)throws Exception {
		//글쓰기 비즈니스 로직
		bs.insertBoard(boardDTO, files);
		return "redirect:/board/list";
	}
	@RequestMapping("/detail")
	public ModelAndView boardDetail(@RequestParam("id") int id) throws Exception {
		ModelAndView mv = new ModelAndView("board/detail");
		BoardDTO boardDTO = bs.selectBoardById(id);
		mv.addObject("board", boardDTO);
		return mv;
				
	}
	@PostMapping("/update")
	public String BoardUpdate(BoardDTO boardDTO) throws Exception{
		bs.updateBoard(boardDTO);
		return "redirect:/board/list";
	}
	@PostMapping("/delete")
	public String BoardDelete(@RequestParam("id") int id) throws Exception{
		bs.deleteBoard(id);
		return "redirect:/board/list";
	}
//	@ExceptionHandler(Exception.class)
//	public ModelAndView handleException(Exception e) {
//		log.error("예외 발생 : {}", e.getMessage());
//		ModelAndView mv=new ModelAndView("board/error");
//		mv.addObject("errorMSG", e.getMessage());
//		return mv;
//		
//	}	
	
	@RequestMapping("/download")
	public ResponseEntity<Resource> downloadFile(@RequestParam("id") int id, @RequestParam("boardId") int boardId) throws Exception{
		//서비스 역할 : 매퍼를 통해서 id와 boardId가 일치하는 파일DTO를 가져온 뒤 파일 리소스를 만들어서 반환해주자
		FileDTO fileDTO = bs.selectFileByIds(id, boardId);
		String fileName = fileDTO.getOriginFileName();
		UrlResource resource;
		try {
			resource = new UrlResource("file:"+fileDTO.getStoredFilePath());
		} catch (Exception e) {
			throw new Exception("파일 다운로드 에러");
		}
		String encodedFileName=UriUtils.encode(fileName, StandardCharsets.UTF_8);
		String ContentDispositionValue="attachment; filename=\""+encodedFileName+"\"";
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, ContentDispositionValue).body(resource);
	}
}
