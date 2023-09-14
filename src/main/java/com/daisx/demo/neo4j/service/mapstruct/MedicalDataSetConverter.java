package com.daisx.demo.neo4j.service.mapstruct;

import com.daisx.demo.neo4j.domain.model.MedicalImagingLabel;
import com.daisx.demo.neo4j.service.dto.MedicalImagingLabelDto;
import org.mapstruct.Mapper;

/**
 * @author daisx
 */
@Mapper(componentModel = "Spring")
public interface MedicalDataSetConverter {

    MedicalImagingLabel convertLabelEntity(MedicalImagingLabelDto dto);
}
