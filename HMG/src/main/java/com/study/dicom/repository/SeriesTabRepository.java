package com.study.dicom.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.study.dicom.domain.SeriesTab;
import com.study.dicom.domain.SeriesTabId;

@Repository
public interface SeriesTabRepository  extends JpaRepository<SeriesTab, SeriesTabId>{

	List<SeriesTab> findAllByIdStudyKey(Long studyKey);

}
