package com.kosta.service;

import java.util.List;

import com.kosta.domain.StudyGroupDTO;
import com.kosta.entity.StudyGroup;
import com.kosta.entity.User;

public interface GroupService {

	List<StudyGroupDTO> getAllGroup();

	

	StudyGroup save(StudyGroup sg, User user);



	void deleteGroup(int id) throws Exception;



	StudyGroupDTO findById(int id, User user) throws Exception;

//	StudyGroup getGroup(int id);

}
