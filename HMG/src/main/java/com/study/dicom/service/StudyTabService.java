package com.study.dicom.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.dicom.domain.StudyTab;
import com.study.dicom.repository.StudyTabRepository;

@Service
public class StudyTabService {
	ArrayList<StudyTab> list = new ArrayList<StudyTab>();
	
	@Autowired
	StudyTabRepository studyTabRepository;

	public List<StudyTab> list() {
		return studyTabRepository.findAllByOrderByStudyKeyDesc();
	}	
}
