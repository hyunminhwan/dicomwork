package com.study.dicom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.study.dicom.domain.StudyTab;
import com.study.dicom.service.StudyTabService;

@Controller
public class StudyTabController {

	@Autowired
	StudyTabService studyTabService;
	
	@GetMapping("/StudyTabList")
	public String list(Model model) {
		List<StudyTab> study=studyTabService.list();
		
		model.addAttribute("study",study);
		return "Study/StudyList";
	}
}
