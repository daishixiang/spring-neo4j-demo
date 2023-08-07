package com.daisx.demo.neo4j.domain.enums;

/**
 * 节点关系枚举
 * @author daisx
 */

public enum RelationShipEnum {
    SUBSET("SUBSET","子集"),

    KINDRED("KINDRED","血缘"),

    ELEMENT("ELEMENT","元素");
    private final String code;
    private final String description;

    RelationShipEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }
}
