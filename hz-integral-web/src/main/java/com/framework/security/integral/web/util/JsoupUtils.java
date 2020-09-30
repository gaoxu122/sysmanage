package com.framework.security.integral.web.util;


import com.framework.security.integral.common.exception.BaseException;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.util.StringUtils;

import java.io.IOException;


@Slf4j
public class JsoupUtils {


    public static Connection JsoupConnection(String url) {

        if (StringUtils.isEmpty(url)) {
            log.error("JsoupConnection: 地址为空!");
            throw new BaseException("JsoupConnection: 地址为空!", 34568);
        }
        Connection con = Jsoup.connect(url)
                .ignoreContentType(true)
                .ignoreHttpErrors(true)
                .timeout(1000 * 30)
                .userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36")
                .header("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8")
                .header("accept-encoding", "gzip, deflate, br")
                .header("accept-language", "zh-CN,zh;q=0.9,en-US;q=0.8,en;q=0.7");

        return con;
    }

    public static Document getDecument(Connection connection) throws IOException {

        Document document = null;
        try {
            document = connection.timeout(50000).get();
        } catch (IOException e) {
            throw new BaseException("连接路径时间太长", 34567);
        }
        return document;
    }


}
