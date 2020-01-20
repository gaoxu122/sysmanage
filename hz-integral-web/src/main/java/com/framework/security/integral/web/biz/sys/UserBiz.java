package com.framework.security.integral.web.biz.sys;

import com.framework.security.integral.common.biz.BaseBiz;
import com.framework.security.integral.common.msg.ObjectRestResponse;
import com.framework.security.integral.common.util.Query;
import com.framework.security.integral.core.dao.sys.UserMapper;
import com.framework.security.integral.core.model.sys.User;
import com.framework.security.integral.core.service.sys.UserService;
import com.framework.security.integral.web.constant.ReturnCode;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author gaoxu
 * @date 2019-07-12 11:49
 */
@Service
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class UserBiz extends BaseBiz<UserMapper, User> {

    @Autowired
    private UserService userService;

    /**
     * 查询人员信息
     *
     * @return
     */
    public ObjectRestResponse selectUser(Query query) {

        Example example = new Example(User.class);
        List<User> users = null;
        Page<Object> result = null;
        Example.Criteria criteria = example.createCriteria();
        try {
            if (query.entrySet().size() > 0) {
                for (Map.Entry<String, Object> entry : query.entrySet()) {
                    criteria.andLike(entry.getKey(), "%" + entry.getValue().toString() + "%");
                }
            }

            criteria.andEqualTo("isDelect", false);
            result = PageHelper.startPage(query.getPage(), query.getLimit());
            users = this.selectByExample(example);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ObjectRestResponse.genTableResult(result.getTotal(), users);
    }

    /**
     * 编辑用户信息
     *
     * @param user
     * @return
     */
    public ObjectRestResponse editeUser(User user) {

        if (StringUtils.isBlank(user.getUserName())) {
            return ObjectRestResponse.failure(ReturnCode.PARAMETER_INCOMING_ERROR.getCode(), ReturnCode.PARAMETER_INCOMING_ERROR.getMsg());
        }
        User user1 = this.mapper.selectByPrimaryKey(user.getId());

        try {
            user1.setUserName(user.getUserName());
            user1.setPassword(user.getPassword());
            user1.setEmail(user.getEmail());
            user1.setTel(user.getTel());
            user1.setIsEnable(user.getIsEnable());
            user1.setGmtModified(new Date());
            this.updateSelectiveById(user1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ObjectRestResponse.success();
    }

    /**
     * 删除用户
     *
     * @param id
     * @return
     */
    public ObjectRestResponse deleteUser(Integer id) {

        User user = mapper.selectByPrimaryKey(id);
        try {
            user.setGmtModified(new Date());
            user.setIsDelect(true);
            mapper.updateByPrimaryKeySelective(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ObjectRestResponse.success();
    }

    /**
     * 批量删除用户
     *
     * @param ids
     * @return
     */
    public ObjectRestResponse batchDeleteUsers(String ids) {

        log.info("删除的数据为：[{}]", ids);
        String[] strings = ids.split(",");
        Integer[] idsInt = (Integer[]) ConvertUtils.convert(strings, Integer.class);
        List<Integer> list = Arrays.asList(idsInt);
        Boolean aBoolean = userService.batchDeleteUser(list);
        log.info("删除状态：[{}]", aBoolean.toString());
        return ObjectRestResponse.success();
    }
}
