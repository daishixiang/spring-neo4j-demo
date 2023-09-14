package com.daisx.demo.neo4j.domain.model;

import java.util.List;

/**
 * 基本关系
 *
 * @author daisx
 */
public interface BaseRelationship<S, T> {

    void in(S s);

    void out(T t);
}
