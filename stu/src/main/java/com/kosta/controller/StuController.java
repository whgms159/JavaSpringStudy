package com.kosta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kosta.entity.Stu;
import com.kosta.service.StuService;

@Controller
public class StuController {
	@Autowired
	private StuService ss;
	
	@GetMapping("/list")
	public ModelAndView listPage() throws Exception{
		ModelAndView mv = new ModelAndView("stu/stulist");
		List<Stu> sList= ss.getAll();
		mv.addObject("list", sList);
		return mv;
		
	}
	@GetMapping("/add")
	public ModelAndView addPage() throws Exception{
		ModelAndView mv = new ModelAndView("stu/stuadd");
		return mv;
		
	}
	@PostMapping("/add")
	public String addStu(Stu stu) throws Exception{
		ss.addStu(stu);
		return "redirect:/list";
		
	}
	@GetMapping("/delete/{id}")
	public String deleteStu(@PathVariable("id") int id)throws Exception{
		ss.deleteStu(id);
		return "redirect:/list";
	}
	@PostMapping("/modify")
	public String modifyStu(Stu stu) throws Exception{
		ss.modifyStu(stu);
		return "redirect:/list";
	} 
	@GetMapping("/modify/{id}")
	public String modifyPage(@PathVariable("id") int id, Model model) throws Exception{
		Stu stu = ss.getStuById(id);
		model.addAttribute("stu", stu);
		return "stu/stuadd";
		
	}

}
