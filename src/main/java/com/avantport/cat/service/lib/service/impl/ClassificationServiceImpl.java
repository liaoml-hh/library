package com.avantport.cat.service.lib.service.impl;

import com.avantport.cat.platform.core.constant.UserConstants;
import com.avantport.cat.platform.core.utils.StringUtils;
import com.avantport.cat.service.lib.domain.LibClassification;
import com.avantport.cat.service.lib.domain.vo.TreeSelect;
import com.avantport.cat.service.lib.mapper.LibClassificationMapper;
import com.avantport.cat.service.lib.service.ClassificationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author lml
 * @Date 2022-04-01 17:45
 */
@Service
public class ClassificationServiceImpl implements ClassificationService {
    @Resource
    private LibClassificationMapper libClassificationMapper;
    @Override
    public List<LibClassification> getList(LibClassification classification) {
        List<LibClassification> libClassification =  libClassificationMapper.selectClassificationList(classification);
        return libClassification;
    }

    @Override
    public String checkClassNameUnique(LibClassification classification) {
        Long deptId = StringUtils.isNull(classification.getId()) ? -1L : classification.getId();
        LibClassification info = libClassificationMapper.checkClassNameUnique(classification.getClassName(), classification.getParentId());
        if (StringUtils.isNotNull(info) && info.getId().longValue() != deptId.longValue()) {
            return UserConstants.NOT_UNIQUE;
        }
        return UserConstants.UNIQUE;
    }

    @Override
    public int insertClassification(LibClassification classification) {
        return libClassificationMapper.insert(classification);
    }

    @Override
    public int updateClassification(LibClassification classification) {
        return libClassificationMapper.updateByPrimaryKey(classification);
    }

    @Override
    public boolean hasChildByClassificationId(Long id) {
        int result = libClassificationMapper.hasChildById(id);
        return result > 0 ? true : false;
    }

    @Override
    public int deleteClassById(Long id) {
        return libClassificationMapper.deleteByPrimaryKey(id);
    }

    @Override
    public boolean checkClassificationExistFiles(Long id) {
        return libClassificationMapper.checkClassificationExistFiles(id)>0 ? true : false;
    }

    @Override
    public LibClassification selectClassificationById(Long id) {
        return libClassificationMapper.selectByPrimaryKey(id);
    }

    /**
     * 构建前端所需要下拉树结构
     *
     * @param list 分类列表
     * @return 下拉树结构列表
     */

    @Override
    public List<TreeSelect> buildDeptTreeSelect(List<LibClassification> list) {
        List<LibClassification> deptTrees = buildDeptTree(list);
        return deptTrees.stream().map(TreeSelect::new).collect(Collectors.toList());
    }

    private List<LibClassification> buildDeptTree(List<LibClassification> list) {
        List<LibClassification> returnList = new ArrayList<>();
        List<Long> tempList = new ArrayList<Long>();
        for (LibClassification dept : list) {
            tempList.add(dept.getId());
        }
        for (Iterator<LibClassification> iterator = list.iterator(); iterator.hasNext();) {
            LibClassification dept = iterator.next();
            // 如果是顶级节点, 遍历该父节点的所有子节点
            if (!tempList.contains(dept.getParentId())) {
                recursionFn(list, dept);
                returnList.add(dept);
            }
        }
        if (returnList.isEmpty()) {
            returnList = list;
        }
        return returnList;
    }
    /**
     * 递归列表
     */
    private void recursionFn(List<LibClassification> list, LibClassification t) {
        // 得到子节点列表
        List<LibClassification> childList = getChildList(list, t);
        t.setChildren(childList);
        for (LibClassification tChild : childList) {
            if (hasChild(list, tChild)) {
                recursionFn(list, tChild);
            }
        }
    }

    /**
     * 得到子节点列表
     */
    private List<LibClassification> getChildList(List<LibClassification> list, LibClassification t) {
        List<LibClassification> tlist = new ArrayList<LibClassification>();
        Iterator<LibClassification> it = list.iterator();
        while (it.hasNext()) {
            LibClassification n = it.next();
            if (StringUtils.isNotNull(n.getParentId()) && n.getParentId().longValue() == t.getId().longValue()) {
                tlist.add(n);
            }
        }
        return tlist;
    }

    /**
     * 判断是否有子节点
     */
    private boolean hasChild(List<LibClassification> list, LibClassification t) {
        return getChildList(list, t).size() > 0 ? true : false;
    }
}
