package com.daisx.demo.neo4j.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;

/**
 * @author daisx
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Node("medical-imaging-label")
public class MedicalImagingLabel extends MedicalDatasetNode {

    @Property("key")
    private String key;

    @Property("value")
    private String value;

}
