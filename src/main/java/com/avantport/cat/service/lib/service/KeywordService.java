package com.avantport.cat.service.lib.service;

import com.avantport.cat.service.lib.domain.LibKeyword;

import java.util.List;

/**
 * @Author lml
 * @Date 2022-04-01 17:37
 */
public interface KeywordService {
    
    List<LibKeyword> getList(LibKeyword keyword);

    
    LibKeyword selectKeywordById(Long id);

    /**
     * 检查关键词的唯一性
     * @param keyword
     * @return
     */
    String checkKeywordUnique(LibKeyword keyword);
    /**
     * 新增关键词列表
     * @param keyword
     * @return
     */
    int insertKeyword(LibKeyword keyword);
    /**
     * 修改关键词类别
     * @param keyword
     * @return
     */
    int updateKeyword(LibKeyword keyword);

    /**
     * 判断当前关键词是否存在文件
     * @param id
     * @return
     */
    boolean checkKeywordExistFiles(Long id);
    /**
     * 删除关键词
     * @param id 关键词id
     * @return
     */
    int deleteKeywordById(Long id);

}
