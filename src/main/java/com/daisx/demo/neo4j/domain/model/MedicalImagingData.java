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
@Node("medical-imaging-data")
public class MedicalImagingData extends MedicalDataNode {

    @Property("format")
    private String format;

    @Property("size")
    private String size;

    @Property("type")
    private String type;

    @Property("status")
    private String status;

    @Property("origin")
    private String origin;

    @Property("mark")
    private String mark;

    @Property("parse")
    private String parse;

    @Property("thumbnail")
    private String thumbnail;

}
