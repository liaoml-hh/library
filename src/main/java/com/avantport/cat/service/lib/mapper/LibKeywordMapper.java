package com.avantport.cat.service.lib.mapper;

import com.avantport.cat.service.lib.domain.LibKeyword;

import java.util.List;

public interface LibKeywordMapper {

    int deleteByPrimaryKey(Long id);

    int insert(LibKeyword record);

    LibKeyword selectByPrimaryKey(Long id);

    int updateByPrimaryKey(LibKeyword record);

    List<LibKeyword> selectKeywordList(LibKeyword keyword);

    LibKeyword checkKeywordUnique(String keywordName);

    int checkKeywordExistFiles(Long id);
}