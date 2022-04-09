package com.avantport.cat.service.lib.domain;


import com.avantport.cat.platform.core.web.domain.BaseEntity;

import java.util.ArrayList;
import java.util.List;

public class LibClassification extends BaseEntity {
    private Long id;

    private String className;

    private Long parentId;

    private String parentPath;

    private Integer delFlag;

    private String brief;

    private List<LibClassification> children = new ArrayList();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className == null ? null : className.trim();
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getParentPath() {
        return parentPath;
    }

    public void setParentPath(String parentPath) {
        this.parentPath = parentPath == null ? null : parentPath.trim();
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }


    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief == null ? null : brief.trim();
    }

    public List<LibClassification> getChildren() {
        return children;
    }

    public void setChildren(List<LibClassification> children) {
        this.children = children;
    }
}