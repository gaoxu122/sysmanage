package com.framework.security.integral.web.biz.log;

import com.framework.security.integral.common.biz.BaseBiz;
import com.framework.security.integral.core.dao.log.LoginLogMapper;
import com.framework.security.integral.core.model.log.LoginLog;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author gaoxu
 * @date 2019-07-08 16:18
 */

@Service
@Transactional(rollbackFor = Exception.class)
public class LoginLogBiz extends BaseBiz<LoginLogMapper,LoginLog> {
}
