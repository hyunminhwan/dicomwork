package com.study.dicom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.study.dicom.domain.SeriesTab;
import com.study.dicom.service.SeriesTabService;

@Controller
public class SeriesTabController {
	
	@Autowired
	SeriesTabService seriesTabService;
	
	@GetMapping("/seriesForm")
	public String seriesForm(@RequestParam(value="studyKey") Long studyKey , Model model) {
		List<SeriesTab> series = seriesTabService.seriesList(studyKey);
		model.addAttribute("series",series);
		return "Series/SeriesForm";
	}
}
