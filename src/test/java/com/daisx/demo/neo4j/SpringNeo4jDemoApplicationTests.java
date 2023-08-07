package com.daisx.demo.neo4j;

import cn.hutool.json.JSONUtil;
import com.daisx.demo.neo4j.repository.MedicalImagingDataRepository;
import com.daisx.demo.neo4j.repository.MedicalImagingLabelRepository;
import com.daisx.demo.neo4j.service.InitDataService;
import com.daisx.demo.neo4j.service.dto.MedicalImagingDataDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

@SpringBootTest
class SpringNeo4jDemoApplicationTests {

    @Autowired
    private InitDataService initDataService;

    @Autowired
    private MedicalImagingDataRepository dataRepository;

    @Autowired
    private MedicalImagingLabelRepository labelRepository;


    @Test
    void createData() {
        int index = 142;
        int size = 1;
        for (int i = 0; i < size; i++) {
            initDataService.creatData(index + i);
        }
    }


    @Test
    void testData() {
        long l11 = System.currentTimeMillis();
        Pageable pageable = PageRequest.of(1, 20);
        Page<MedicalImagingDataDto> dataDtoPage = dataRepository.findListByLabel("标签210111", pageable);
        System.out.println(dataDtoPage.getContent().size());
        long l12 = System.currentTimeMillis() - l11;
        System.out.println(l12);
    }

    @Test
    void findDataFromSource() {
        long l11 = System.currentTimeMillis();
        Pageable pageable = PageRequest.of(8, 20);
        Page<MedicalImagingDataDto> dataDtoPage = dataRepository.findListBySource("source_1004", pageable);
        System.out.println(dataDtoPage.getContent().size());
        long l12 = System.currentTimeMillis() - l11;
        System.out.println(l12);
    }
    @Test
    void findDataFromLabel() {

        long l11 = System.currentTimeMillis();
        List<MedicalImagingDataDto> data11 = dataRepository.findByUniqueCode("data_999111179");
        System.out.println(data11.size());
        long l12 = System.currentTimeMillis() - l11;
        System.out.println(l12);
    }
}
