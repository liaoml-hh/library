package com.avantport.cat.service.lib.mapper;

import com.avantport.cat.service.lib.domain.LibUploadLog;

public interface LibUploadLogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(LibUploadLog record);

    LibUploadLog selectByPrimaryKey(Long id);

    int updateByPrimaryKey(LibUploadLog record);
}