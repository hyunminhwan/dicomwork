package com.study.dicom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.study.dicom.domain.SeriesTab;
import com.study.dicom.repository.SeriesTabRepository;

@Service
public class SeriesTabService {

	@Autowired
	SeriesTabRepository seriesTabRepository;
	
	public List<SeriesTab> seriesList( Long studyKey) {
		return seriesTabRepository.findAllByIdStudyKey(studyKey);
	}
}
