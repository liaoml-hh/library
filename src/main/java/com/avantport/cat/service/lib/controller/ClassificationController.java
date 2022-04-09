package com.avantport.cat.service.lib.controller;

import com.avantport.cat.platform.core.constant.UserConstants;
import com.avantport.cat.platform.core.web.domain.AjaxResult;
import com.avantport.cat.platform.core.web.page.TableDataInfo;
import com.avantport.cat.service.lib.domain.LibClassification;
import com.avantport.cat.service.lib.service.ClassificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author lml
 * @Date 2022-04-01 17:30
 */
@RestController
@RequestMapping("/classification")
public class ClassificationController extends BaseController{
    @Autowired
    private ClassificationService classificationService;

    /**
     * 分页获取类别表所有数据
     */

    @GetMapping(value = "/list")
    public TableDataInfo list(LibClassification classification) {
        startPage();
        List<LibClassification> list = classificationService.getList(classification);
        return getDataTable(list);
    }

    /**
     * 根据分类编号获取详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable Long id) {
        return AjaxResult.success(classificationService.selectClassificationById(id));
    }

    /**
     * 获取分类下拉树列表
     */
    @GetMapping("/treeselect")
    public AjaxResult treeselect(LibClassification classification) {
        List<LibClassification> list = classificationService.getList(classification);
        return AjaxResult.success(classificationService.buildDeptTreeSelect(list));
    }


    /**
     * 新增分类
     */
    //@Log(title = "分类管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@Validated @RequestBody LibClassification classification) {
        if (UserConstants.NOT_UNIQUE.equals(classificationService.checkClassNameUnique(classification))) {
            return AjaxResult.error("新增分类'" + classification.getClassName() + "'失败，分类名称已存在");
        }
        classification.setCreateBy(getLoginUserName());
        return toAjax(classificationService.insertClassification(classification));
    }

    /**
     * 修改分类
     */
    //@Log(title = "分类管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@Validated @RequestBody LibClassification classification) {
        if (UserConstants.NOT_UNIQUE.equals(classificationService.checkClassNameUnique(classification))) {
            return AjaxResult.error("修改分类'" + classification.getClassName() + "'失败，分类名称已存在");
        } else if (classification.getParentId()!=null && classification.getParentId().equals(classification.getId())) {
            return AjaxResult.error("修改分类'" + classification.getClassName() + "'失败，上级分类不能是自己");
        }
        classification.setUpdateBy(getLoginUserName());
        return toAjax(classificationService.updateClassification(classification));
    }

    /**
     * 删除分类
     */
    //@Log(title = "分类管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{id}")
    public AjaxResult remove(@PathVariable Long id) {
        if (classificationService.hasChildByClassificationId(id)) {
            return AjaxResult.error("存在下级分类,不允许删除");
        }
        if (classificationService.checkClassificationExistFiles(id)) {
            return AjaxResult.error("分类存在文件,不允许删除");
        }
        return toAjax(classificationService.deleteClassById(id));
    }


}
