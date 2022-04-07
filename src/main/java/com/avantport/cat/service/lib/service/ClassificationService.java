package com.avantport.cat.service.lib.service;

import com.avantport.cat.service.lib.domain.LibClassification;
import com.avantport.cat.service.lib.domain.vo.TreeSelect;
import org.bouncycastle.asn1.cmp.OOBCertHash;

import java.util.List;

/**
 * @Author lml
 * @Date 2022-04-01 17:37
 */
public interface ClassificationService {
    List<LibClassification> getList(LibClassification classification);

    /**
     * * 校验分类名是否唯一
     * @param classification
     * @return
     */
    String checkClassNameUnique(LibClassification classification);

    /**
     * 新增分类列表
     * @param classification
     * @return
     */
    int insertClassification(LibClassification classification);

    /**
     * 修改分类类别
     * @param classification
     * @return
     */
    int updateClassification(LibClassification classification);

    /**
     * 判断是否存在子分类
     * @param id 分类id
     * @return
     */
    boolean hasChildByClassificationId(Long id);

    /**
     * 删除分类
     * @param id 分类id
     * @return
     */
    int deleteClassById(Long id);

    /**
     * 判断当前分类下是否存在其他文件
     * @param id 分类id
     * @return
     */
    boolean checkClassificationExistFiles(Long id);

    LibClassification selectClassificationById(Long id);

    List<TreeSelect> buildDeptTreeSelect(List<LibClassification> list);
}
