package com.avantport.cat.service.lib.mapper;

import com.avantport.cat.service.lib.domain.LibRelationInfo;
import com.avantport.cat.service.lib.domain.LibRelationInfoKey;

public interface LibRelationInfoMapper {
    int deleteByPrimaryKey(LibRelationInfoKey key);

    int insert(LibRelationInfo record);


    LibRelationInfo selectByPrimaryKey(LibRelationInfoKey key);


    int updateByPrimaryKey(LibRelationInfo record);
}