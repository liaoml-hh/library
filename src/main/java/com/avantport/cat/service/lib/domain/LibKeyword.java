package com.avantport.cat.service.lib.domain;

import com.avantport.cat.platform.core.web.domain.BaseEntity;

import java.util.Date;

public class LibKeyword extends BaseEntity {
    private Long id;

    private String keywordName;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKeywordName() {
        return keywordName;
    }

    public void setKeywordName(String keywordName) {
        this.keywordName = keywordName == null ? null : keywordName.trim();
    }

}