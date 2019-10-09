package com.framework.security.integral.web.biz.sys;

import com.framework.security.integral.common.biz.BaseBiz;
import com.framework.security.integral.common.msg.ObjectRestResponse;
import com.framework.security.integral.common.util.Query;
import com.framework.security.integral.common.util.TreeUtil;
import com.framework.security.integral.core.dao.sys.DepartmentMapper;
import com.framework.security.integral.core.model.sys.Department;
import com.framework.security.integral.web.constant.ReturnCode;
import com.framework.security.integral.web.vo.DepartmentVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 1. 查询部门的所有信息
 * 2. 添加部门信息
 * 3. 更新部门信息
 * 4. 查询部门  树形展示
 * 5. 删除部门信息
 *
 * @author gaoxu
 * @date 2019-10-09 10:25
 */

@Service
public class DepartmentBiz extends BaseBiz<DepartmentMapper, Department> {

    /**
     * 添加部门信息
     *
     * @param department
     * @return
     */
    public ObjectRestResponse insertDepartment(Department department) {

        // 判断部门名称
        if (StringUtils.isBlank(department.getName())) {
            return ObjectRestResponse.failure(ReturnCode.DEPARTMENT_NAME_NOT_EMPTY.getCode(), ReturnCode.DEPARTMENT_NAME_NOT_EMPTY.getMsg());
        }

        if (null == department.getParentId()) {
            return ObjectRestResponse.failure(ReturnCode.SUPERIOR_DEPARTMENT_NOT_SELECTED.getCode(), ReturnCode.SUPERIOR_DEPARTMENT_NOT_SELECTED.getMsg());
        }
        // 从token中获取用户id


        if (null == department.getSort()) {

            department.setSort(99);
        }
        department.setSort(department.getSort());
        department.setGmtModified(new Date());
        department.setGmtCreate(new Date());
        department.setIsDelete(false);
        department.setIsEnable(false);

        try {
            this.insert(department);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ObjectRestResponse.success();
    }

    /**
     * 查询所有的部门信息
     *
     * @param query
     * @return
     */
    public ObjectRestResponse selectDepartment(Query query) {

        // 原始数据
        List<Department> departments = this.selectListAll();
        // 转换数据
        List<DepartmentVO> departmentVos = new ArrayList<>();
        // 返回数据
        List<DepartmentVO> returnVos = new ArrayList<>();

        if (departments.size() > 0) {

            for (Department department : departments) {

                DepartmentVO departmentVO = new DepartmentVO();
                departmentVO.setId(department.getId());
                departmentVO.setParentId(department.getParentId());
                departmentVO.setPath(department.getPath());
                departmentVO.setName(department.getName());
                departmentVO.setLabel(String.valueOf(department.getName()));
                departmentVO.setGmtCreate(department.getGmtCreate());
                departmentVO.setGmtModified(department.getGmtModified());
                departmentVO.setIsDelete(department.getIsDelete());
                departmentVO.setIsEnable(department.getIsEnable());
                departmentVO.setSort(department.getSort());
                departmentVO.add(departmentVO);
            }

            if (departmentVos.size() > 0) {
                returnVos = TreeUtil.buildByRecursive(departmentVos, 0);
            }

        }

        return ObjectRestResponse.success(returnVos);
    }
}
