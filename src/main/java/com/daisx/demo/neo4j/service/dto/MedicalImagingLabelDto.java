package com.daisx.demo.neo4j.service.dto;


import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author daisx
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class MedicalImagingLabelDto implements Serializable {

    private Long id;

    private String uniqueKey;

    private String name;

    private String desc;

    private LocalDateTime createdTime;

    private LocalDateTime updatedTime;

    private String createdBy;

    private String updatedBy;

    private String key;

    private String vale;

}
