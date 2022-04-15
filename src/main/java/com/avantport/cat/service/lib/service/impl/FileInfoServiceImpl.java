package com.avantport.cat.service.lib.service.impl;

import com.avantport.cat.platform.core.constant.UserConstants;
import com.avantport.cat.platform.core.utils.StringUtils;
import com.avantport.cat.service.lib.domain.LibFileInfo;
import com.avantport.cat.service.lib.domain.LibKeyword;
import com.avantport.cat.service.lib.mapper.LibClassificationMapper;
import com.avantport.cat.service.lib.mapper.LibFileInfoMapper;
import com.avantport.cat.service.lib.mapper.LibKeywordMapper;
import com.avantport.cat.service.lib.service.FileInfoService;
import com.avantport.cat.service.lib.service.RelationInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author lml
 * @Date 2022-04-01 17:45
 */
@Service
public class FileInfoServiceImpl implements FileInfoService {
    @Resource
    private LibFileInfoMapper fileInfoMapper;
    @Autowired
    private RelationInfoService relationInfoService;
    @Autowired
    private LibClassificationMapper classificationMapper;
    @Autowired
    private LibKeywordMapper libKeywordMapper;
    @Override
    public List<LibFileInfo> getList(LibFileInfo fileInfo) {
//        if(fileInfo.getKeywordIds() != null && fileInfo.getKeywordIds().length >0){
//            String  s = "";
//            for(int i=0;i<fileInfo.getKeywordIds().length;i++){
//                if(i==fileInfo.getKeywordIds().length-1){
//                    s+=fileInfo.getKeywordIds()[i];
//                }else{
//                    s+=fileInfo.getKeywordIds()[i]+",";
//                }
//            }
//            fileInfo.setKeyWords(s);
//        }
        List<LibFileInfo> libFileInfos =  fileInfoMapper.selectFileInfoList(fileInfo);
        //
        for(LibFileInfo libFileInfo :libFileInfos){
            if(libFileInfo.getFileClassId() != null){
                libFileInfo.setClassification(classificationMapper.selectByPrimaryKey(libFileInfo.getFileClassId()));
            }
            List<LibKeyword> keywords = libKeywordMapper.selectByFileId(libFileInfo.getId());
            libFileInfo.setLibKeywordList(keywords);
        }
        return libFileInfos;
    }

    @Override
    public String checkFileInfoUnique(LibFileInfo fileInfo) {
        Long deptId = StringUtils.isNull(fileInfo.getId()) ? -1L : fileInfo.getId();
        LibFileInfo info = fileInfoMapper.checkFileInfoUnique(fileInfo.getFileName());
        if (StringUtils.isNotNull(info) && info.getId().longValue() != deptId.longValue()) {
            return UserConstants.NOT_UNIQUE;
        }
        return UserConstants.UNIQUE;
    }

    @Override
    public int insertFileInfo(LibFileInfo fileInfo) {
        return fileInfoMapper.insert(fileInfo);
    }

    @Override
    public int updateFileInfo(LibFileInfo fileInfo) {
        int i = fileInfoMapper.updateByPrimaryKey(fileInfo);
        if(fileInfo.getKeywordIds().length >0){
            relationInfoService.insertRelationInfoByFile(fileInfo);
        }
        return i;
    }



    @Override
    public int deleteFileInfoById(Long id) {
        return fileInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertFilesInfo(List<LibFileInfo> list) {
        return fileInfoMapper.insertFilesInfo(list);
    }

    @Override
    public LibFileInfo selectFileInfoById(Long id) {
        return fileInfoMapper.selectByPrimaryKey(id);
    }

}
