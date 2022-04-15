package com.avantport.cat.service.lib.mapper;

import com.avantport.cat.service.lib.domain.LibRelationInfo;
import com.avantport.cat.service.lib.domain.LibRelationInfoKey;

import java.util.List;

public interface LibRelationInfoMapper {
    int deleteByPrimaryKey(LibRelationInfoKey key);

    int insert(LibRelationInfo record);

    LibRelationInfo selectByPrimaryKey(LibRelationInfoKey key);

    int updateByPrimaryKey(LibRelationInfo record);

    void batchInsert(List<LibRelationInfo> list);

    int batchDeleteByFileId(Long fileId);

    List<LibRelationInfo> getByFileId(Long id);

    List<LibRelationInfo> getByKeywordIds(Long[] keywordIds);
}