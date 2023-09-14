package com.daisx.demo.neo4j.service;

import com.daisx.demo.neo4j.domain.model.MedicalImagingData;
import com.daisx.demo.neo4j.domain.model.MedicalImagingDataSource;
import com.daisx.demo.neo4j.domain.model.MedicalImagingLabel;
import com.daisx.demo.neo4j.repository.MedicalImagingDataRepository;
import com.daisx.demo.neo4j.repository.MedicalImagingDataSourceRepository;
import com.daisx.demo.neo4j.repository.MedicalImagingLabelRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author daisx
 */
@Slf4j
@AllArgsConstructor
@Service
public class InitDataService {
    private final MedicalImagingDataSourceRepository dataSourceRepository;
    private final MedicalImagingLabelRepository labelRepository;
    private final MedicalImagingDataRepository dataRepository;

    public void creatData(int i) {
        List<String> areaList = List.of("华东", "华南", "华北", "华中", "东南", "西南", "东北", "西北");
        List<String> channelList = List.of("中科院", "信通院", "协和医院", "人民医院",
                "东方医院", "瑞金医院", "华西医院", "华山医院");
        List<String> typeList = List.of("影像设备", "医学影像系统（PACS）");
        List<String> keyList = List.of("应用病种", "临床场景", "数据模态", "数据用途", "年龄分布");
        List<List<String>> valueList = new ArrayList<>();
        valueList.add(List.of("眼底糖网", "肺结节", "肺炎", "冠脉病变", "骨龄分析", "牙齿缺损", "宫颈癌", "肝脏病变", "肾脏病变"));
        valueList.add(List.of("目标检测", "影像分类", "影像分割", "影像测量", "分诊分级", "患者随访"));
        valueList.add(List.of("超声", "MRI", "CT", "病变彩照", "电动图", "X射线"));
        valueList.add(List.of("模型训练", "模型验证", "模型调优", "模型训练", "模型测试"));
        valueList.add(List.of("18-25岁", "26-29岁", "30-35岁", "36-39岁", "40-45岁", "46-49岁", "50-55岁", "56-59岁", "60-65岁", "65岁以上"));


        long startTime = System.currentTimeMillis();

        MedicalImagingDataSource dataSource = new MedicalImagingDataSource();
        dataSource.setArea(areaList.get(i % 8));
        dataSource.setType(typeList.get(i % 2));
        dataSource.setChannel(channelList.get(i % 8));
        dataSource.setUniqueKey("source_" + i);
        dataSource.setName("数据源_" + i);
        dataSource.setDesc("测试数据");
        dataSource.setCreatedBy("admin");
        dataSource.setCreatedTime(LocalDateTime.now());
        log.info("数据源{}->标签", i);
        for (int j = 1; j < keyList.size() + 1; j++) {
            MedicalImagingLabel label = new MedicalImagingLabel();
            label.setKey(keyList.get(j % 5));
            label.setUniqueKey("label_" + i + j);
            label.setName(keyList.get(j % 5)+"_" + i + j);
            label.setDesc("测试数据");
            label.setCreatedBy("admin");
            label.setCreatedTime(LocalDateTime.now());
            dataSource.pointToDataset(label);
            log.info("标签1_{}->data", j);
            for (int f = 1; f < 2; f++) {
                MedicalImagingData data = new MedicalImagingData();
                data.setUniqueKey("data_" + i + j + f);
                data.setName("影像数据_" + i + j + f);
                data.setDesc("测试数据");
                data.setCreatedBy("admin");
                data.setCreatedTime(LocalDateTime.now());
                data.setSize("10240000");
                data.setFormat("dicom");
                data.setStatus("success");
                data.setType("CT");
                data.setOrigin("/medical-imaging/影像数据" + i + j + f + ".dicom");
                label.out(data);
            }
            List<String> valList = valueList.get(j % 5);
            int size = valList.size();
            log.info("标签1_{}->标签2", j);
            for (int h = 1; h < size + 1; h++) {
                MedicalImagingLabel label2 = new MedicalImagingLabel();
                label2.setKey(valList.get(h % size));
                label2.setUniqueKey("label_2" + i + j + h);
                label2.setName(valList.get(h % size)+"_" + i + j + h);
                label2.setDesc("测试数据");
                label2.setCreatedBy("admin");
                label2.setCreatedTime(LocalDateTime.now());
                label.pointToDataset(label2);
                for (int k = 1; k < 3; k++) {
                    MedicalImagingData data = new MedicalImagingData();
                    data.setUniqueKey("data_" + i + j + h + k);
                    data.setName("影像数据" + i + j + h + k);
                    data.setDesc("测试数据");
                    data.setCreatedBy("admin");
                    data.setCreatedTime(LocalDateTime.now());
                    data.setSize("10240000");
                    data.setFormat("dicom");
                    data.setStatus("success");
                    data.setType("CT");
                    data.setOrigin("/medical-imaging/影像数据" + i + j + h + k + ".dicom");
                    label2.out(data);
                }
            }
            dataSourceRepository.save(dataSource);
        }
        long endTime = System.currentTimeMillis();
        long l = endTime - startTime;
        System.out.println("总耗时(ms)：" + l);
    }
}
