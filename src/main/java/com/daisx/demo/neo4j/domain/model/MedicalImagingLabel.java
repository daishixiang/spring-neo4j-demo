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
@Node("medical-imaging-label")
public class MedicalImagingLabel extends MedicalDatasetNode {

    @Property("key")
    private String key;

    @Property("value")
    private String value;

}
