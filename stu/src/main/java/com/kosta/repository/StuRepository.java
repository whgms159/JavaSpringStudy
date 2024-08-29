package com.kosta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kosta.entity.Stu;
@Repository
public interface StuRepository extends JpaRepository<Stu, Integer>{


}
