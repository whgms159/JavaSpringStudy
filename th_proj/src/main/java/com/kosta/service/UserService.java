package com.kosta.service;

import java.util.List;

import com.kosta.dto.UserDTO;

public interface UserService {
	//삭제 안 된 리스트 가져오기
	List<UserDTO> getAllUserList()throws Exception;
	//회원 추가하기
	void addUser(UserDTO userDTO)throws Exception;
	//회원 삭제하기
	void removeUser(int id) throws Exception;
}
