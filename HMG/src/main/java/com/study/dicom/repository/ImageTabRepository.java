package com.study.dicom.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.study.dicom.domain.ImageTab;
import com.study.dicom.domain.ImageTabId;

@Repository
public interface ImageTabRepository extends JpaRepository<ImageTab,ImageTabId> {


	ArrayList<ImageTab> findByIdStudyKeyAndIdSeriesKeyOrderByIdImageKey(Long studyKey, Long seriesKey);

	//detail
	ArrayList<ImageTab> findByIdStudyKeyAndIdSeriesKey(Long studyKey, Long seriesKey);

//	ArrayList<ImageTab> findByIdStudyKeyOrderByIdSeriesKeyAscIdImageKeyAsc(Long studyKey);
 
}
