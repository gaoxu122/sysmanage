package com.framework.security.integral.web.controller.sys;

import com.framework.security.integral.common.controller.BaseController;
import com.framework.security.integral.common.msg.ObjectRestResponse;
import com.framework.security.integral.common.util.Query;
import com.framework.security.integral.core.dao.sys.UserMapper;
import com.framework.security.integral.core.model.sys.User;
import com.framework.security.integral.web.biz.sys.UserBiz;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author gaoxu
 * @date 2019-07-12 11:49
 */
@RestController
@RequestMapping(value = "user")
public class UserController extends BaseController<UserBiz, UserMapper> {


    @GetMapping(value = "/select_user")
    public ObjectRestResponse selectUser(@RequestParam Map<String, Object> paream) {
        Query query = new Query(paream);
        return baseBiz.selectUser(query);
    }

    @PutMapping(value = "update_user")
    public ObjectRestResponse updateUser(@RequestBody User user) {

        return baseBiz.editeUser(user);
    }

    @DeleteMapping(value = "delete_user")
    public ObjectRestResponse deleteUser(Integer id) {

        return baseBiz.deleteUser(id);
    }

    @DeleteMapping(value = "batch_delete_user")
    public ObjectRestResponse batchDeleteUser(String ids) {

        return baseBiz.batchDeleteUsers(ids);
    }
}
