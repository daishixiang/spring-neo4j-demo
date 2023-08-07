package com.daisx.demo.neo4j.repository;

import com.daisx.demo.neo4j.domain.model.MedicalImagingLabel;
import org.springframework.data.neo4j.repository.Neo4jRepository;

/**
 * @author daisx
 */
public interface MedicalImagingLabelRepository extends Neo4jRepository<MedicalImagingLabel, Long> {

}
