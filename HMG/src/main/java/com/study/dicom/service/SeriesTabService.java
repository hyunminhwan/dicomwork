package com.study.dicom.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.dicom.domain.SeriesTab;
import com.study.dicom.repository.SeriesTabRepository;

@Service
public class SeriesTabService {

	@Autowired
	SeriesTabRepository seriesTabRepository;
	
	public ArrayList<SeriesTab> seriesList( Long studyKey) {
		return seriesTabRepository.findAllByIdStudyKey(studyKey);
	}
}
