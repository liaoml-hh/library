package com.avantport.cat.service.lib.controller;

import com.avantport.cat.platform.core.constant.UserConstants;
import com.avantport.cat.platform.core.web.domain.AjaxResult;
import com.avantport.cat.platform.core.web.page.TableDataInfo;
import com.avantport.cat.service.lib.domain.LibKeyword;
import com.avantport.cat.service.lib.service.KeywordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author lml
 * @Date 2022-04-06 15:15
 */
@RestController
@RequestMapping("/keyword")
public class KeywordController extends BaseController {
    
    @Autowired
    private KeywordService keywordService;
    /**
     * 分页获取关键词表所有数据
     */

    @GetMapping(value = "/list")
    public TableDataInfo list(LibKeyword keyword) {
        startPage();
        List<LibKeyword> list = keywordService.getList(keyword);
        return getDataTable(list);
    }

    /**
     * 根据关键词编号获取详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable Long id) {
        return AjaxResult.success(keywordService.selectKeywordById(id));
    }



    /**
     * 新增关键词
     */
    //@Log(title = "关键词管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@Validated @RequestBody LibKeyword keyword) {
        if (UserConstants.NOT_UNIQUE.equals(keywordService.checkKeywordUnique(keyword))) {
            return AjaxResult.error("新增关键词'" + keyword.getKeywordName() + "'失败，关键词名称已存在");
        }

        keyword.setCreateBy(getLoginUserName());
        return toAjax(keywordService.insertKeyword(keyword));
    }

    /**
     * 修改关键词
     */
    //@Log(title = "关键词管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@Validated @RequestBody LibKeyword keyword) {
        if (UserConstants.NOT_UNIQUE.equals(keywordService.checkKeywordUnique(keyword))) {
            return AjaxResult.error("修改关键词'" + keyword.getKeywordName() + "'失败，关键词名称已存在");
        }
        keyword.setUpdateBy(getLoginUserName());
        return toAjax(keywordService.updateKeyword(keyword));
    }

    /**
     * 删除关键词
     */
    //@Log(title = "关键词管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{id}")
    public AjaxResult remove(@PathVariable Long id) {

        if (keywordService.checkKeywordExistFiles(id)) {
            return AjaxResult.error("此关键词存在关联的文件,不允许删除");
        }
        return toAjax(keywordService.deleteKeywordById(id));
    }


    /**
     * 获取关键词选择框列表
     */
    @GetMapping("/optionselect")
    public AjaxResult optionselect() {
        List<LibKeyword> posts = keywordService.selectKeywordAll();
        return AjaxResult.success(posts);
    }
}
