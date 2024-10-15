package com.study.dicom.repository;

import com.study.dicom.domain.ImageTab;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageTabRepository extends JpaRepository<ImageTab,Long> {


	List<ImageTab> findByStudyKeyAndSeriesKeyOrderByImageKey(Long studyKey, Long seriesKey);
 
}
