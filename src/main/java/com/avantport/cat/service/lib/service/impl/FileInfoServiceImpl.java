package com.avantport.cat.service.lib.service.impl;

import com.avantport.cat.platform.core.constant.UserConstants;
import com.avantport.cat.platform.core.utils.StringUtils;
import com.avantport.cat.service.lib.domain.LibFileInfo;
import com.avantport.cat.service.lib.mapper.LibFileInfoMapper;
import com.avantport.cat.service.lib.mapper.LibFileInfoMapper;
import com.avantport.cat.service.lib.service.FileInfoService;
import com.avantport.cat.service.lib.service.FileInfoService;
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
    @Override
    public List<LibFileInfo> getList(LibFileInfo FileInfo) {
        List<LibFileInfo> LibFileInfo =  fileInfoMapper.selectFileInfoList(FileInfo);
        return LibFileInfo;
    }

    @Override
    public String checkFileInfoUnique(LibFileInfo FileInfo) {
        Long deptId = StringUtils.isNull(FileInfo.getId()) ? -1L : FileInfo.getId();
        LibFileInfo info = fileInfoMapper.checkFileInfoUnique(FileInfo.getFileName());
        if (StringUtils.isNotNull(info) && info.getId().longValue() != deptId.longValue()) {
            return UserConstants.NOT_UNIQUE;
        }
        return UserConstants.UNIQUE;
    }

    @Override
    public int insertFileInfo(LibFileInfo FileInfo) {
        return fileInfoMapper.insert(FileInfo);
    }

    @Override
    public int updateFileInfo(LibFileInfo FileInfo) {
        return fileInfoMapper.updateByPrimaryKey(FileInfo);
    }



    @Override
    public int deleteFileInfoById(Long id) {
        return fileInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public LibFileInfo selectFileInfoById(Long id) {
        return fileInfoMapper.selectByPrimaryKey(id);
    }

}
