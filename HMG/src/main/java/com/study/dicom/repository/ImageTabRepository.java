package com.study.dicom.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.study.dicom.domain.ImageTab;

@Repository
public interface ImageTabRepository extends JpaRepository<ImageTab,Long> {


	ArrayList<ImageTab> findByIdStudyKeyAndIdSeriesKeyOrderByIdImageKey(Long studyKey, Long seriesKey);

//	ArrayList<ImageTab> findByIdStudyKeyOrderByIdSeriesKeyAscIdImageKeyAsc(Long studyKey);
 
}
