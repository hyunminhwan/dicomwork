package com.study.dicom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.study.dicom.domain.ImageTab;
import com.study.dicom.service.ImageTabService;

@Controller
public class ImageTabController {
	
	@Autowired
	ImageTabService imageTabService;
	
	@GetMapping("ImageTabList")
	public String list(@RequestParam("studyKey") Long studyKey,@RequestParam("seriesKey") Long seriesKey, 
            Model model) {
		
		List<ImageTab> images = imageTabService.list(studyKey,seriesKey);
		for(int i=0; i<images.size();i++) {
			ImageTab imgTab = images.get(i);
			imgTab.setPath(imgTab.getPath().replace("\\","/"));
			images.set(i,imgTab);
		}
		
		System.out.println("image"+images);
		model.addAttribute("image",images);
		return "Image/ImageList";
		
	}
	
}
