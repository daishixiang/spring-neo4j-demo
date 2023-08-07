package com.daisx.demo.neo4j.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.ArrayList;
import java.util.List;

/**
 * @author daisx
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Node("medical-data")
public class MedicalDataNode extends AbstractNode {

    // 定义一个关系，注意：direction代表箭头方向，INCOMING箭头指向自己，OUTGOING箭头指向TargetNode
    @Relationship(type = "ELEMENT", direction = Relationship.Direction.INCOMING)
    private List<MedicalDatasetNode> datasetList = new ArrayList<>();

    // 定义一个关系，注意：direction代表箭头方向，INCOMING箭头指向自己，OUTGOING箭头指向TargetNode
    @Relationship(type = "KINDRED", direction = Relationship.Direction.OUTGOING)
    private List<MedicalDataNode> dataList = new ArrayList<>();

    /**
     * 医疗数据集 -> this
     *
     * @param dataset 医疗数据集
     */
    public void pointToMe(MedicalDatasetNode dataset) {
        datasetList.add(dataset);
    }

    /**
     * this ->  医疗数据
     *
     * @param data 医疗数据
     */
    public void pointToMedicalData(MedicalDataNode data) {
        dataList.add(data);
    }
}
