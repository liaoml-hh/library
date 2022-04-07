package com.avantport.cat.service.lib.mapper;

import com.avantport.cat.platform.api.domain.SysDept;
import com.avantport.cat.service.lib.domain.LibClassification;

import java.util.List;

public interface LibClassificationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(LibClassification record);

    int insertSelective(LibClassification record);

    LibClassification selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(LibClassification record);

    int updateByPrimaryKeyWithBLOBs(LibClassification record);

    int updateByPrimaryKey(LibClassification record);


    List<LibClassification> selectClassificationList(LibClassification classification);

    LibClassification checkClassNameUnique(String className, Long parentId);

    int hasChildById(Long id);

    boolean checkClassificationExistFiles(Long id);
}