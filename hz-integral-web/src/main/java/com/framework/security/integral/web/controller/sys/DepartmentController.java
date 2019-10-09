package com.framework.security.integral.web.controller.sys;

import com.framework.security.integral.common.controller.BaseController;
import com.framework.security.integral.common.msg.ObjectRestResponse;
import com.framework.security.integral.core.model.sys.Department;
import com.framework.security.integral.web.biz.sys.DepartmentBiz;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author gaoxu
 * @date 2019-10-09 10:24
 */

@RestController
@RequestMapping("/department")
public class DepartmentController extends BaseController<DepartmentBiz, Department> {

    /**
     * 添加部门信息
     *
     * @param department
     * @return
     */
    @PostMapping("/insert_department")
    public ObjectRestResponse insertDepartment(Department department) {

        return baseBiz.insertDepartment(department);
    }
}
