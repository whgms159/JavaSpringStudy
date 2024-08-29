package com.kosta.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosta.entity.Stu;
import com.kosta.repository.StuRepository;

@Service
public class StuServiceImpl implements StuService {
	@Autowired
	private StuRepository stuRepository;

	@Override
	public List<Stu> getAll() { //리스트 가져오기		
		return stuRepository.findAll();
	}

	@Override
	public void addStu(Stu stu) { //학생 추가
		stuRepository.save(stu);
		
	}

	@Override
	public void deleteStu(int id) throws Exception {//학생 삭제
		stuRepository.deleteById(id);
	}

	

	@Override
	public Stu getStuById(int id) throws Exception {
		Optional<Stu> optStu = stuRepository.findById(id);
		Stu stu = optStu.orElseThrow(()-> new Exception("없는 아이디"));
		return stu;
	}
	@Override
	public void modifyStu(Stu stu) throws Exception {
		//id (stu.getId())값을 통해 stu1를 가져온다.
		Stu stu1 = getStuById(stu.getId());
		//stu1.setname(stu.getname())
		stu1.setName(stu.getName());
		//save(stu1)
		stuRepository.save(stu1);
		
	}

}
