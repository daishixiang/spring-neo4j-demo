package com.daisx.demo.neo4j.domain.model;

import lombok.*;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;

/**
 * @author daisx
 */
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Node("medical-imaging-data-source")
public class MedicalImagingDataSource extends MedicalDatasetNode {

    @Property("type")
    private String type;

    @Property("area")
    private String area;

    @Property("channel")
    private String channel;

}
