package com.framework.security.integral.web.biz.sys;

import com.framework.security.integral.common.biz.BaseBiz;
import com.framework.security.integral.common.exception.BaseException;
import com.framework.security.integral.common.msg.ObjectRestResponse;
import com.framework.security.integral.core.dao.sys.RoleUserMapper;
import com.framework.security.integral.core.model.sys.RoleUser;
import com.framework.security.integral.core.vo.RoleUserVO;
import com.framework.security.integral.core.vo.UserRoleVO;
import com.framework.security.integral.web.vo.AuthVO;
import com.framework.security.integral.web.vo.KeyValue;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author gaoxu
 */
@Service
public class RoleUserBiz extends BaseBiz<RoleUserMapper, RoleUser> {


    /**
     * 根据用户账号（用户姓名）查询角色信息
     *
     * @param userName
     * @return
     */
    public RoleUserVO selectRoleByUserName(String userName) {

        return mapper.selectRoleByUserName(userName);
    }

    /**
     * 用户赋权
     *
     * @param role
     * @param userName
     * @return
     */
    public ObjectRestResponse selectPermission(int role, String userName) {

        AuthVO authVO = new AuthVO();
        List<KeyValue> keyValues = selectNoPermissionUsers(role, userName);
        List<String> strings = selectPermissionUsers(role, userName);
        authVO.setKeyValueList(keyValues);
        authVO.setKeys(strings);
        return ObjectRestResponse.success(authVO);
    }

    /**
     * 查询未赋权的用户列表
     *
     * @param roleId
     * @return
     */
    public List<KeyValue> selectNoPermissionUsers(int roleId, String userName) {

        List<UserRoleVO> users = mapper.selectNoPermissionUsersByRoleId(roleId, userName);
        return convert(users);
    }

    /**
     * 查询已赋权的用户列表
     *
     * @param role
     * @param userName
     * @return
     */
    public List<String> selectPermissionUsers(int role, String userName) {

        return mapper.selectPermissionUsersByRoleId(role, userName);
    }

    /**
     * 为用户赋予角色
     *
     * @param roleUser
     * @return
     */
    public ObjectRestResponse insertRoleForUser(RoleUser roleUser) {

        roleUser.setGmtCreate(new Date());
        roleUser.setGmtModified(new Date());
        roleUser.setIsDelete(true);
        this.mapper.insertSelective(roleUser);

        return ObjectRestResponse.success();
    }

    /**
     * 批量移除已有用户的权限
     *
     * @param roleUser
     * @return
     */
    public ObjectRestResponse deleteRoleForUser(List<RoleUser> roleUser) {

        return ObjectRestResponse.success();
    }

    public List<KeyValue> convert(List<UserRoleVO> userRoleVOS) {

        List<KeyValue> keyValues = new ArrayList<>();
        Optional.of(userRoleVOS).orElse(null).forEach(userRoleVO -> {
            keyValues.add(new KeyValue(userRoleVO.getId().toString(), userRoleVO.getUserName(),false));
        });

        return keyValues;
    }
}
