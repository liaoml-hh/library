package com.avantport.cat.service.lib.domain;

import java.util.Date;

public class LibRelationInfo extends LibRelationInfoKey {
    private Date createTime;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}