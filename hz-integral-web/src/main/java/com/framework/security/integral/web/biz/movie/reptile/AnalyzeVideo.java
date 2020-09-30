package com.framework.security.integral.web.biz.movie.reptile;

import com.framework.security.integral.web.util.JsoupUtils;
import lombok.SneakyThrows;
import org.jsoup.Connection;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

public class AnalyzeVideo {

    private static final String analyzeUrl = "https://okjx.cc/?url=";


    @SneakyThrows
    public static void main(String[] args) {

        //ok视频地址
        String url = "https://youku.cdn7-okzy.com/share/1820c4b6fcbf5be5758bffe24c41fa6a";

        Connection connection = JsoupUtils.JsoupConnection(analyzeUrl + url);
        Document decument = JsoupUtils.getDecument(connection);
        System.out.println(connection);
        System.out.println(decument);

    }
}
