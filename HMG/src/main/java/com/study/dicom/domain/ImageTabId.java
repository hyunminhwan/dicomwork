package com.study.dicom.domain;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImageTabId implements Serializable {

    private static final long serialVersionUID = 1L;  // 직렬화 버전 ID 추가

    private Long studyKey;
    private Long seriesKey;
    private Long imageKey;

}
