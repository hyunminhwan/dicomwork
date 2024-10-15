package com.study.dicom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.dicom.domain.ImageTab;
import com.study.dicom.repository.ImageTabRepository;

@Service
public class ImageTabService {

	@Autowired
	ImageTabRepository imageTabRepository;
	
	public List<ImageTab> list(Long studyKey,Long seriesKey) {
		return imageTabRepository.findByStudyKeyAndSeriesKeyOrderByImageKey(studyKey,seriesKey);
	}

}
