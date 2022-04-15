package com.avantport.cat.service.lib.controller;

import com.avantport.cat.platform.core.constant.UserConstants;
import com.avantport.cat.platform.core.utils.StringUtils;
import com.avantport.cat.platform.core.web.domain.AjaxResult;
import com.avantport.cat.platform.core.web.page.TableDataInfo;
import com.avantport.cat.service.lib.domain.LibFileInfo;
import com.avantport.cat.service.lib.service.FileInfoService;
import com.avantport.cat.service.lib.service.RelationInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

/**
 * @Author lml
 * @Date 2022-04-06 15:15
 */
@RestController
@RequestMapping("/file")
public class FileInfoController extends BaseController {
    
    @Autowired
    private FileInfoService fileInfoService;
    @Autowired
    private RelationInfoService relationInfoService;
    /**
     * 分页获取文件表所有数据
     */

    @GetMapping(value = "/list")
    public TableDataInfo list(LibFileInfo fileInfo) {
        startPage();
        List<LibFileInfo> list = fileInfoService.getList(fileInfo);
        return getDataTable(list);
    }

    /**
     * 根据文件编号获取详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable Long id) {
        AjaxResult ajax = AjaxResult.success();
        Set<Long> keywordIds = relationInfoService.getRelationInfoByFileId(id);
        if (StringUtils.isNotNull(id)) {
            ajax.put(AjaxResult.DATA_TAG,fileInfoService.selectFileInfoById(id));
            ajax.put("keywordIds", keywordIds);
        }
        return ajax;
    }
    /**
     * 新增文件
     */
    // @Log(title = "文件管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@Validated @RequestBody LibFileInfo list) {
        list.setCreateBy(getLoginUserName());
        return toAjax(fileInfoService.insertFileInfo(list));
    }

        /**
         * 修改文件
         */
    //@Log(title = "文件管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@Validated @RequestBody LibFileInfo fileInfo) {
        if (UserConstants.NOT_UNIQUE.equals(fileInfoService.checkFileInfoUnique(fileInfo))) {
            return AjaxResult.error("修改文件'" + fileInfo.getFileName() + "'失败，文件名称已存在");
        }
        fileInfo.setUpdateBy(getLoginUserName());
        return toAjax(fileInfoService.updateFileInfo(fileInfo));
    }

    /**
     * 删除文件
     */
    //@Log(title = "文件管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{id}")
    public AjaxResult remove(@PathVariable Long id) {
        return toAjax(fileInfoService.deleteFileInfoById(id));
    }
}
