package com.study.dicom.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.dicom.domain.ImageTab;
import com.study.dicom.repository.ImageTabRepository;

@Service
public class ImageTabService {

	@Autowired
	ImageTabRepository imageTabRepository;
	
	public ArrayList<ImageTab> list(Long studyKey,Long seriesKey) {
		return imageTabRepository.findByIdStudyKeyAndIdSeriesKeyOrderByIdImageKey(studyKey,seriesKey);
	}

	public ArrayList<ImageTab> imageDetail(Long studyKey, Long seriesKey) {
		return imageTabRepository.findByIdStudyKeyAndIdSeriesKey(studyKey,seriesKey);
	}

//	public ArrayList<ImageTab> imgList(Long studyKey) {
//		return imageTabRepository.findByIdStudyKeyOrderByIdSeriesKeyAscIdImageKeyAsc(studyKey);
//	}

}
