package com.kosta.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kosta.entity.Stu;

@Service
public interface StuService {


	List<Stu> getAll()throws Exception;

	void addStu(Stu stu)throws Exception;

	void deleteStu(int id)throws Exception;

	void modifyStu(Stu stu) throws Exception;
	
	Stu getStuById(int id) throws Exception;

}
