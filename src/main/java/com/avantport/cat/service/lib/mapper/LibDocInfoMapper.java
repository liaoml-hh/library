package com.avantport.cat.service.lib.mapper;

import com.avantport.cat.service.lib.domain.LibDocInfo;

public interface LibDocInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(LibDocInfo record);

    int insertSelective(LibDocInfo record);

    LibDocInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(LibDocInfo record);

    int updateByPrimaryKey(LibDocInfo record);
}