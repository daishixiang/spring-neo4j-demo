package com.daisx.demo.neo4j.domain.model;

import lombok.*;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.ArrayList;
import java.util.List;

/**
 * @author daisx
 */
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Node("medical-dataset")
public class MedicalDatasetNode extends BaseNode implements BaseRelationship<MedicalDatasetNode,MedicalDataNode>{

    // 定义一个关系，注意：direction代表箭头方向，INCOMING箭头指向自己，OUTGOING箭头指向TargetNode
    @Relationship(type = "SUBSET", direction = Relationship.Direction.OUTGOING)
    private List<MedicalDatasetNode> toSubsets = new ArrayList<>();

    // 定义一个关系，注意：direction代表箭头方向，INCOMING箭头指向自己，OUTGOING箭头指向TargetNode
    @Relationship(type = "SUBSET", direction = Relationship.Direction.INCOMING)
    private List<MedicalDatasetNode> datasets = new ArrayList<>();

    // 定义一个关系，注意：direction代表箭头方向，INCOMING箭头指向自己，OUTGOING箭头指向TargetNode
    @Relationship(type = "ELEMENT", direction = Relationship.Direction.OUTGOING)
    private List<MedicalDataNode> datas = new ArrayList<>();

    /**
     * this -> 医疗数据集
     *
     * @param dataset 医疗数据集
     */
    public void pointToDataset(MedicalDatasetNode dataset) {
        toSubsets.add(dataset);
    }

    @Override
    public void in(MedicalDatasetNode dataset) {
        datasets.add(dataset);
    }

    @Override
    public void out(MedicalDataNode data) {
        datas.add(data);
    }
}
