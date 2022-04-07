package com.avantport.cat.service.lib.service;

import com.avantport.cat.service.lib.domain.LibFileInfo;

import java.util.List;

/**
 * @Author lml
 * @Date 2022-04-01 17:37
 */
public interface FileInfoService {
    
    List<LibFileInfo> getList(LibFileInfo fileInfo);

    
    LibFileInfo selectFileInfoById(Long id);

    /**
     * 检查关键词的唯一性
     * @param fileInfo
     * @return
     */
    String checkFileInfoUnique(LibFileInfo fileInfo);
    /**
     * 新增关键词列表
     * @param fileInfo
     * @return
     */
    int insertFileInfo(LibFileInfo fileInfo);
    /**
     * 修改关键词类别
     * @param fileInfo
     * @return
     */
    int updateFileInfo(LibFileInfo fileInfo);

    /**
     * 删除关键词
     * @param id 关键词id
     * @return
     */
    int deleteFileInfoById(Long id);

}
