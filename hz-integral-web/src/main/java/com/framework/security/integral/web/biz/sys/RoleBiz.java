package com.framework.security.integral.web.biz.sys;

import com.framework.security.integral.common.biz.BaseBiz;
import com.framework.security.integral.common.exception.BaseException;
import com.framework.security.integral.common.msg.ObjectRestResponse;
import com.framework.security.integral.common.util.Query;
import com.framework.security.integral.core.dao.sys.RoleMapper;
import com.framework.security.integral.core.model.sys.Menu;
import com.framework.security.integral.core.model.sys.Role;
import com.framework.security.integral.web.constant.ReturnCode;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author gaoxu
 * @date 2019-10-08 12:54
 */


@Service
public class RoleBiz extends BaseBiz<RoleMapper, Role> {


    /**
     * 获得所有的角色列表
     *
     * @param query
     * @return
     * @date 2020-5-19  添加分页查询 以及模糊查询
     */
    public ObjectRestResponse getRoles(Query query) {

        Example example = new Example(Role.class);
        Example.Criteria criteria = example.createCriteria();

        if (query.entrySet().size() > 0) {
            for (Map.Entry<String, Object> entry : query.entrySet()) {
                criteria.andLike(entry.getKey(), "%" + entry.getValue().toString() + "%");
            }
        }
        criteria.andEqualTo("isDelete", false);
        Page<Object> result = PageHelper.startPage(query.getPage(), query.getLimit());
        List<Role> roles = mapper.selectByExample(example);
        return ObjectRestResponse.genTableResult(result.getTotal(), roles);
    }

    /**
     * 添加角色
     *
     * @return
     */
    public ObjectRestResponse insertRole(Role role) {

        // 判断不为空的项
        if (StringUtils.isBlank(role.getName())) {
            return ObjectRestResponse.failure(ReturnCode.ROLE_NAME_NOT_EMPTY.getCode(), ReturnCode.ROLE_NAME_NOT_EMPTY.getMsg());
        }
        role.setGmtCreate(new Date());
        role.setGmtModified(new Date());
        role.setIsEnable(false);
        role.setIsDelete(false);

        try {
            this.mapper.insert(role);
        } catch (Exception e) {
            throw new BaseException(ReturnCode.INSERT_FAILED.getMsg(), ReturnCode.INSERT_FAILED.getCode());
        }


        return ObjectRestResponse.genJsonResultByOk();
    }

    /**
     * 修改角色信息
     *
     * @param role
     * @return
     */
    public ObjectRestResponse updateRole(Role role) {

        // 判断不为空的项
        if (StringUtils.isBlank(role.getName())) {
            return ObjectRestResponse.failure(ReturnCode.ROLE_NAME_NOT_EMPTY.getCode(), ReturnCode.ROLE_NAME_NOT_EMPTY.getMsg());
        }
        this.mapper.updateByPrimaryKeySelective(role);
        return ObjectRestResponse.success();
    }

    /**
     * 删除角色
     *
     * @param roleId
     * @return
     */
    public ObjectRestResponse deleteRole(@NotNull int roleId) {

        Role role = this.mapper.selectByPrimaryKey(roleId);
        role.setIsDelete(true);
        this.mapper.updateByPrimaryKeySelective(role);
        return ObjectRestResponse.success();
    }

    /**
     * 启用/禁用
     *
     * @param id
     * @return
     */
    public ObjectRestResponse enable(Integer id) {

        if (id <= 0) {
            return ObjectRestResponse.failure(ReturnCode.PARAMETER_INCOMING_ERROR.getCode(), ReturnCode.PARAMETER_INCOMING_ERROR.getMsg());
        }

        Role role = mapper.selectByPrimaryKey(id);
        Example example = new Example(Menu.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("isEnable", !role.getIsEnable());
        this.mapper.updateByPrimaryKeySelective(role);
        return ObjectRestResponse.success();
    }


}
