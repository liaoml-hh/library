package com.avantport.cat.service.lib.domain;

import com.avantport.cat.platform.core.web.domain.BaseEntity;

import java.util.List;


public class LibFileInfo extends BaseEntity {
    private Long id;

    private String fileName;

    private Long fileSize;

    private Integer fileStyle;

    private String fileExt;

    private Long fileUserId;

    private String fileUuid;

    private String filePath;

    private Integer state;

    private Long fileClassId;

    private Integer delFlag;

    private String fileBrief;
    private Long[] keywordIds;
    private String keyWords;
    private LibClassification classification;
    private List<LibKeyword> libKeywordList;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }

    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    public Integer getFileStyle() {
        return fileStyle;
    }

    public void setFileStyle(Integer fileStyle) {
        this.fileStyle = fileStyle;
    }

    public String getFileExt() {
        return fileExt;
    }

    public void setFileExt(String fileExt) {
        this.fileExt = fileExt == null ? null : fileExt.trim();
    }

    public Long getFileUserId() {
        return fileUserId;
    }

    public void setFileUserId(Long fileUserId) {
        this.fileUserId = fileUserId;
    }

    public String getFileUuid() {
        return fileUuid;
    }

    public void setFileUuid(String fileUuid) {
        this.fileUuid = fileUuid == null ? null : fileUuid.trim();
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath == null ? null : filePath.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Long getFileClassId() {
        return fileClassId;
    }

    public void setFileClassId(Long fileClassId) {
        this.fileClassId = fileClassId;
    }



    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }


    public String getFileBrief() {
        return fileBrief;
    }

    public void setFileBrief(String fileBrief) {
        this.fileBrief = fileBrief == null ? null : fileBrief.trim();
    }

    public Long[] getKeywordIds() {
        return keywordIds;
    }

    public void setKeywordIds(Long[] keywordIds) {
        this.keywordIds = keywordIds;
    }

    public String getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords;
    }

    public LibClassification getClassification() {
        return classification;
    }

    public void setClassification(LibClassification classification) {
        this.classification = classification;
    }

    public List<LibKeyword> getLibKeywordList() {
        return libKeywordList;
    }

    public void setLibKeywordList(List<LibKeyword> libKeywordList) {
        this.libKeywordList = libKeywordList;
    }
}