package com.framework.security.integral.core.dao.sys;

import com.framework.security.integral.core.model.sys.Department;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author gaoxu
 */

@Service
@Transactional(rollbackFor = Exception.class)
public interface DepartmentMapper extends Mapper<Department> {

    /**
     * 根据部门的ID去批量删除部门信息
     *
     * @param id
     */
    void deleteBatchDept(int[] id);

    void deleteDeptByPath();
}