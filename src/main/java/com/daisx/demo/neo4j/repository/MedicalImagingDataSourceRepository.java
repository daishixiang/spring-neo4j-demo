package com.daisx.demo.neo4j.repository;

import com.daisx.demo.neo4j.domain.model.MedicalImagingDataSource;
import org.springframework.data.neo4j.repository.Neo4jRepository;

/**
 * @author daisx
 */
public interface MedicalImagingDataSourceRepository extends Neo4jRepository<MedicalImagingDataSource, Long> {

}
