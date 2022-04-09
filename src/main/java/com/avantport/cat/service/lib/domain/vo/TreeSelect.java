package com.avantport.cat.service.lib.domain.vo;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import com.avantport.cat.service.lib.domain.LibClassification;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Treeselect树结构实体类
 * 
 * @author 
 */
public class TreeSelect implements Serializable {
    private static final long serialVersionUID = 1L;

    /** 节点ID */
    private Long value;

    /** 节点名称 */
    private String label;

    /** 子节点 */
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<TreeSelect> children;

    public TreeSelect() {

    }

    public TreeSelect(LibClassification classification) {
        this.value = classification.getId();
        this.label = classification.getClassName();
        this.children = classification.getChildren().stream().map(TreeSelect::new).collect(Collectors.toList());
    }



    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<TreeSelect> getChildren() {
        return children;
    }

    public void setChildren(List<TreeSelect> children) {
        this.children = children;
    }
}
