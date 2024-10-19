package com.study.dicom.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.study.dicom.domain.SeriesTab;
import com.study.dicom.domain.SeriesTabId;

@Repository
public interface SeriesTabRepository  extends JpaRepository<SeriesTab, SeriesTabId>{

	ArrayList<SeriesTab> findAllByIdStudyKey(Long studyKey);

}
