package com.gaoxu.redis.servise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;



/**
 * @author gaoxu
 */
@Service
public class LoginService {

    @Autowired
    private ValueOperations valueOperations;

    @Autowired
    private RedisTemplate redisTemplate;


    /**
     * 增加每日访问量
     *
     * @param key
     * @return
     */
    public void visits(String key) throws Exception {

        if (StringUtils.isEmpty(key)) {
            throw new Exception("KEY不能为空！");
        }
        int number = 0;
        // 如果可以存在，数量加1
        if (redisTemplate.hasKey(key)) {
            number = Integer.valueOf(valueOperations.get(key).toString());
        }
        valueOperations.set(key, number + 1);
    }

    /**
     * 获得访问量
     *
     * @param key
     * @return
     * @throws Exception
     */
    public String getVisits(String key) throws Exception {

        if (StringUtils.isEmpty(key)) {
            throw new Exception("KEY不能为空！");
        }

        return valueOperations.get(key).toString();
    }

}
