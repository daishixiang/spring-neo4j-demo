package com.daisx.demo.neo4j;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.json.JSONUtil;
import com.daisx.demo.neo4j.domain.model.MedicalDataNode;
import com.daisx.demo.neo4j.domain.model.MedicalImagingData;
import com.daisx.demo.neo4j.domain.model.MedicalImagingLabel;
import com.daisx.demo.neo4j.repository.MedicalImagingDataRepository;
import com.daisx.demo.neo4j.repository.MedicalImagingLabelRepository;
import com.daisx.demo.neo4j.service.InitDataService;
import com.daisx.demo.neo4j.service.dto.MedicalImagingDataDto;
import com.daisx.demo.neo4j.service.dto.MedicalImagingLabelDto;
import com.daisx.demo.neo4j.service.mapstruct.MedicalDataSetConverter;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
class SpringNeo4jDemoApplicationTests {

    @Resource
    private InitDataService initDataService;

    @Resource
    private MedicalImagingDataRepository dataRepository;

    @Resource
    private MedicalImagingLabelRepository labelRepository;

    @Resource
    private MedicalDataSetConverter dataSetConverter;


    @Test
    void createData() {
        int index = 999;
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

    @Test
    void updateLabelData() {
        MedicalImagingLabelDto labelDto = labelRepository.findByUniqueKey("label_9991");
        System.out.println(JSONUtil.formatJsonStr(JSONUtil.toJsonStr(labelDto)));

        MedicalImagingLabel label = dataSetConverter.convertLabelEntity(labelDto);

        labelRepository.save(label);
    }


    private MedicalDataNode generatedData() {
        String rangeKey = RandomUtil.randomString(16);
        MedicalImagingData data = new MedicalImagingData();
        data.setUniqueKey("data_" + rangeKey);
        data.setName("影像数据" + rangeKey);
        data.setDesc("测试数据");
        data.setCreatedBy("admin");
        data.setCreatedTime(LocalDateTime.now());
        data.setSize("10240000");
        data.setFormat("dicom");
        data.setStatus("success");
        data.setType("CT");
        data.setOrigin("/medical-imaging/影像数据" + rangeKey + ".dicom");
        return data;
    }
}
