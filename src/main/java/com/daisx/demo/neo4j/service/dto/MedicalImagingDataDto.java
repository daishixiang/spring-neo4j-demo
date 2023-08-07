package com.daisx.demo.neo4j.service.dto;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author daisx
 */
@Data
public class MedicalImagingDataDto implements Serializable {

    private Long id;

    private String uniqueCode;

    private String name;

    private String desc;

    private LocalDateTime createdTime;

    private LocalDateTime updatedTime;

    private String createdBy;

    private String updatedBy;

    private String format;

    private String size;

    private String type;

    private String status;

    private String origin;

    private String mark;

    private String parse;

    private String thumbnail;

}
