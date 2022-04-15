package com.avantport.cat.service.lib.service.impl;

import com.avantport.cat.platform.core.utils.StringUtils;
import com.avantport.cat.service.lib.domain.LibFileInfo;
import com.avantport.cat.service.lib.domain.LibRelationInfo;
import com.avantport.cat.service.lib.mapper.LibRelationInfoMapper;
import com.avantport.cat.service.lib.service.RelationInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * @Author lml
 * @Date 2022-04-01 17:45
 */
@Service
public class RelationInfoServiceImpl implements RelationInfoService {
    @Resource
    private LibRelationInfoMapper relationInfoMapper;


    @Override
    public void insertRelationInfoByFile(LibFileInfo fileInfo) {
        Long[] keywordIds = fileInfo.getKeywordIds();
        //先删除当前文件下的关键词
        relationInfoMapper.batchDeleteByFileId(fileInfo.getId());
        if (StringUtils.isNotNull(keywordIds)) {
            // 新增用户与岗位管理
            List<LibRelationInfo> list = new ArrayList<>();
            for (Long keywordId : keywordIds) {
                LibRelationInfo relationInfo = new LibRelationInfo();
                relationInfo.setFileId(fileInfo.getId());
                relationInfo.setKeywordId(keywordId);
                list.add(relationInfo);
            }
            if (list.size() > 0) {
                relationInfoMapper.batchInsert(list);
            }
        }

    }

    @Override
    public  Set<Long> getRelationInfoByFileId(Long id) {
        List<LibRelationInfo> list = relationInfoMapper.getByFileId(id);
        Set<Long> permsSet = new HashSet<>();
        for (LibRelationInfo perm : list) {
            if (StringUtils.isNotNull(perm)) {
                permsSet.addAll(Arrays.asList(perm.getKeywordId()));
            }
        }
        return permsSet;
    }

    @Override
    public List<LibRelationInfo> getRelationInfoByKeywordIds(Long[] keywordIds) {
        return  relationInfoMapper.getByKeywordIds(keywordIds);
    }
}
