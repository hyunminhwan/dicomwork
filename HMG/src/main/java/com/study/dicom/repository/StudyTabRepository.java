package com.study.dicom.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.study.dicom.domain.StudyTab;

@Repository
public interface StudyTabRepository extends JpaRepository<StudyTab,Long>{

	List<StudyTab> findAllByOrderByStudyKeyDesc();

	 @Query("SELECT s FROM STUDYTAB s WHERE "
	            + "(:pid IS NULL OR s.pid LIKE %:pid%) " 
	            + "AND (:pname IS NULL OR s.pname LIKE %:pname%) "
	            + "AND (:reportStatus = 0 OR s.reportStatus = :reportStatus) "
	            + "AND (:modality IS NULL OR s.modality = :modality)")
	    List<StudyTab> findStudyTabsByCriteria(@Param("pid") String pid,
	                                           @Param("pname") String pname,
	                                           @Param("reportStatus") Long reportStatus,
	                                           @Param("modality") String modality);
}

