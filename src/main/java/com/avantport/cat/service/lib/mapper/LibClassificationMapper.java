package com.avantport.cat.service.lib.mapper;

import com.avantport.cat.service.lib.domain.LibClassification;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LibClassificationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(LibClassification record);

    LibClassification selectByPrimaryKey(Long id);

    int updateByPrimaryKey(LibClassification record);

    List<LibClassification> selectClassificationList(LibClassification classification);

    LibClassification checkClassNameUnique(@Param("className")String className,@Param("parentId") Long parentId);

    int hasChildById(Long id);

    int checkClassificationExistFiles(Long id);
}