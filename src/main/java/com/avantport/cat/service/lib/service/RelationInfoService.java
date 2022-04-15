package com.avantport.cat.service.lib.service;

import com.avantport.cat.service.lib.domain.LibFileInfo;
import com.avantport.cat.service.lib.domain.LibRelationInfo;

import java.util.List;
import java.util.Set;

/**
 * @Author lml
 * @Date 2022-04-01 17:37
 */
public interface RelationInfoService {

    /**
     * 根据文件新增文件与关键词的关联表
     * @param fileInfo
     */
    void insertRelationInfoByFile(LibFileInfo fileInfo);

    Set<Long> getRelationInfoByFileId(Long id);

    List<LibRelationInfo> getRelationInfoByKeywordIds(Long[] keywordIds);
}
