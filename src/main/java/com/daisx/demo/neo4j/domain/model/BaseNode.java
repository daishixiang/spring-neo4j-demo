package com.daisx.demo.neo4j.domain.model;

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
public class BaseNode implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Property("unique_key")
    private String uniqueKey;

    @Property("name")
    private String name;

    @Property("desc")
    private String desc;

    @Property("created_time")
    private LocalDateTime createdTime;

    @Property("updated_time")
    private LocalDateTime updatedTime;

    @Property("created_by")
    private String createdBy;

    @Property("updated_by")
    private String updatedBy;
}
