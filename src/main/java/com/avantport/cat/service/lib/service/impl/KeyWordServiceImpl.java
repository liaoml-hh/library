package com.avantport.cat.service.lib.service.impl;

import com.avantport.cat.platform.core.constant.UserConstants;
import com.avantport.cat.platform.core.utils.StringUtils;
import com.avantport.cat.platform.datascope.annotation.DataScope;
import com.avantport.cat.service.lib.domain.LibKeyword;
import com.avantport.cat.service.lib.mapper.LibKeywordMapper;
import com.avantport.cat.service.lib.service.KeywordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author lml
 * @Date 2022-04-01 17:45
 */
@Service
public class KeyWordServiceImpl implements KeywordService {
    @Resource
    private LibKeywordMapper keywordMapper;

    @Override
    public List<LibKeyword> getList(LibKeyword Keyword) {
        List<LibKeyword> LibKeyword =  keywordMapper.selectKeywordList(Keyword);
        return LibKeyword;
    }

    @Override
    public String checkKeywordUnique(LibKeyword Keyword) {
        Long deptId = StringUtils.isNull(Keyword.getId()) ? -1L : Keyword.getId();
        LibKeyword info = keywordMapper.checkKeywordUnique(Keyword.getKeywordName());
        if (StringUtils.isNotNull(info) && info.getId().longValue() != deptId.longValue()) {
            return UserConstants.NOT_UNIQUE;
        }
        return UserConstants.UNIQUE;
    }

    @Override
    public int insertKeyword(LibKeyword Keyword) {
        return keywordMapper.insert(Keyword);
    }

    @Override
    public int updateKeyword(LibKeyword Keyword) {
        return keywordMapper.updateByPrimaryKey(Keyword);
    }


    @Override
    public boolean checkKeywordExistFiles(Long id) {
        return keywordMapper.checkKeywordExistFiles(id)>0;
    }

    @Override
    public int deleteKeywordById(Long id) {
        return keywordMapper.deleteByPrimaryKey(id);
    }

    @Override
    public LibKeyword selectKeywordById(Long id) {
        return keywordMapper.selectByPrimaryKey(id);
    }

}
