package com.daisx.demo.neo4j.rest;

import com.daisx.demo.neo4j.repository.MedicalImagingDataRepository;
import com.daisx.demo.neo4j.service.InitDataService;
import com.daisx.demo.neo4j.service.dto.MedicalImagingDataDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author daisx
 */
@Slf4j
@RestController
@AllArgsConstructor
public class SystemResource {

    private final InitDataService initDataService;

    private final MedicalImagingDataRepository dataRepository;

    @GetMapping("/create/{index}/{size}")
    public void createData(@PathVariable("index") int index, @PathVariable("size") int size) {
        for (int i = 0; i <= size; i++) {
            initDataService.creatData(index + i);
        }
    }


    @GetMapping("/find/{key}")
    public List<MedicalImagingDataDto> find(@PathVariable("key") String key) {
        return dataRepository.findByUniqueCode(key);
    }

    @GetMapping("/find/list/{key}")
    public Page<MedicalImagingDataDto> findList(@PathVariable("key") String key) {
        Pageable pageable = PageRequest.of(1, 20);
        return dataRepository.findListByLabel(key, pageable);
    }
}
