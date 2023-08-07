package com.daisx.demo.neo4j.repository;

import com.daisx.demo.neo4j.domain.model.MedicalImagingData;
import com.daisx.demo.neo4j.service.dto.MedicalImagingDataDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.List;

/**
 * @author daisx
 */
public interface MedicalImagingDataRepository extends Neo4jRepository<MedicalImagingData, Long> {


    @Query(value = "match (n:`medical-imaging-label`{name:$uniqueCode})-->(d:`medical-data`) return d",
            countQuery = "match (n:`medical-imaging-label`{name:$uniqueCode})-->(d:`medical-data`) return count(d)")
    Page<MedicalImagingDataDto> findListByLabel(String uniqueCode,Pageable pageable);

    @Query(value = "match (n:`medical-imaging-data`{unique_code:$uniqueCode}) return n")
    List<MedicalImagingDataDto> findByUniqueCode(String uniqueCode);


    @Query(value = "match (n:`medical-dataset`{unique_code:$uniqueCode})-[*]->(d:`medical-data`) return d",
            countQuery = "match (n:`medical-dataset`{unique_code:$uniqueCode})-[*]->(d:`medical-data`) return count(d)")
    Page<MedicalImagingDataDto> findListBySource(String uniqueCode,Pageable pageable);
}

