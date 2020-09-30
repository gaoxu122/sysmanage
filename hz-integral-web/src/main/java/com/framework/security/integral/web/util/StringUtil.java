package com.framework.security.integral.web.util;

import com.framework.security.integral.common.exception.BaseException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author gaoxu
 */
@Slf4j
public class StringUtil {

    /**
     * 提取字符串中的数字
     *
     * @param string
     * @return
     */
    public static Integer StringIndexOfNumber(String string) {

        String resultString = Optional.of(string)
                .orElseThrow(() -> new BaseException("传入字符串为空", -1));
        String regEx = "[^0-9]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(resultString);

        return Integer.valueOf(m.replaceAll("").trim());
    }

    /**
     * 获取字符串的最后一个元素
     *
     * @param string
     * @return
     */
    public static Integer getLastStr(String string) {


        if (StringUtils.isBlank(string)) {
            return 0;
        }

        String[] split = string.split(",");
        return Integer.valueOf(split[split.length - 1]);
    }
}
