package com.framework.security.integral.web.controller.sys;

import com.framework.security.integral.common.controller.BaseController;
import com.framework.security.integral.common.msg.ObjectRestResponse;
import com.framework.security.integral.common.util.Query;
import com.framework.security.integral.core.model.sys.Department;
import com.framework.security.integral.web.biz.sys.DepartmentBiz;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

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

    @GetMapping("select_department_tree")
    public ObjectRestResponse selectDepartmentTree(Map<String, Object> params) {
        Query query = new Query(params);
        params.get("ids");
        return baseBiz.selectDepartment(query);
    }
}
