package com.avantport.cat.service.lib.domain;

import com.avantport.cat.platform.core.web.domain.BaseEntity;

import java.util.Date;

public class LibDocInfo extends BaseEntity {
    private Long id;

    private Long userId;

    private String docName;

    private String docBiref;

    private Integer delFlag;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName == null ? null : docName.trim();
    }

    public String getDocBiref() {
        return docBiref;
    }

    public void setDocBiref(String docBiref) {
        this.docBiref = docBiref == null ? null : docBiref.trim();
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }


}