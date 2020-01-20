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
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
@Transactional(rollbackFor = {Exception.class})
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

        // 如果sort为空，则默认99
        if (null == department.getSort()) {
            department.setSort(99);
        }
        department.setSort(department.getSort());
        department.setGmtModified(new Date());
        department.setGmtCreate(new Date());
        department.setIsDelete(false);
        department.setIsEnable(false);

        try {
            this.mapper.insert(department);
            String path = department.getParentId() + "," + department.getId();
            department.setPath("," + path);
            this.mapper.updateByPrimaryKeySelective(department);
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
                departmentVO.setValue(String.valueOf(department.getId()));
                departmentVO.setGmtCreate(department.getGmtCreate());
                departmentVO.setGmtModified(department.getGmtModified());
                departmentVO.setIsDelete(department.getIsDelete());
                departmentVO.setIsEnable(department.getIsEnable());
                departmentVO.setSort(department.getSort());
                departmentVos.add(departmentVO);
            }

            if (departmentVos.size() > 0) {
                returnVos = TreeUtil.buildByRecursive(departmentVos, 0);
            }

        }

        return ObjectRestResponse.success(returnVos);
    }

    /**
     * 更新部门时间
     *
     * @param department
     * @return
     */
    public ObjectRestResponse updateDepartment(Department department) {

        // 判断部门名称
        if (StringUtils.isBlank(department.getName())) {
            return ObjectRestResponse.failure(ReturnCode.DEPARTMENT_NAME_NOT_EMPTY.getCode(), ReturnCode.DEPARTMENT_NAME_NOT_EMPTY.getMsg());
        }

        if (null == department.getParentId()) {
            return ObjectRestResponse.failure(ReturnCode.SUPERIOR_DEPARTMENT_NOT_SELECTED.getCode(), ReturnCode.SUPERIOR_DEPARTMENT_NOT_SELECTED.getMsg());
        }

        // 查询对应的改变数据
        this.updateSelectiveById(department);
        return ObjectRestResponse.success();
    }

    /**
     * 删除部门信息
     *
     * @return
     */
    public ObjectRestResponse deleteDepartment(Integer id) {

        // 删除本级节点
        this.mapper.deleteByPrimaryKey(id);
        // 根据节点删除所有的下级节点
        Department department = this.mapper.selectByPrimaryKey(id);
        String path = department.getPath();
        // 根据ID 批量删除部门信息
        Class<Department> clazz = (Class<Department>) ((ParameterizedType) getClass().getGenericSuperclass()).
                getActualTypeArguments()[1];
        Example example = new Example(clazz);
        Example.Criteria criteria = example.createCriteria();
        criteria.andLike("%", "," + path);
        return ObjectRestResponse.success();
    }

    /**
     * 搜索部门信息
     * 这个比较复杂
     *
     * @return
     */
    public ObjectRestResponse selectDepartment(Map map) {

        // 根据输入的部门名称查询部门，并生成和上级对应的树
        // 根据path的路径来查询有多少上级节点

        List<Department> departments = mapper.selectAll();
        departments.stream().filter(department -> {

            return false;
        });

        return ObjectRestResponse.success();
    }
}
