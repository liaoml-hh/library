package com.avantport.cat.service.lib.mapper;

import com.avantport.cat.service.lib.domain.LibFileInfo;

import java.util.List;

public interface LibFileInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(LibFileInfo record);

    int insertSelective(LibFileInfo record);

    LibFileInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKey(LibFileInfo record);

    LibFileInfo checkFileInfoUnique(String fileName);

    List<LibFileInfo> selectFileInfoList(LibFileInfo fileInfo);

    boolean checkFileInfoExistFiles(Long id);

    int insertFilesInfo(List<LibFileInfo> list);
}