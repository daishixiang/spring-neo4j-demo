package com.daisx.demo.neo4j.repository;

import com.daisx.demo.neo4j.domain.model.MedicalImagingLabel;
import com.daisx.demo.neo4j.service.dto.MedicalImagingDataDto;
import com.daisx.demo.neo4j.service.dto.MedicalImagingLabelDto;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.List;

/**
 * @author daisx
 */
public interface MedicalImagingLabelRepository extends Neo4jRepository<MedicalImagingLabel, Long> {


    @Query(value = "match (n:`medical-imaging-label`{unique_key:$uniqueKey}) return n")
    MedicalImagingLabelDto findByUniqueKey(String uniqueKey);
}
