package com.framework.security.integral.web.biz.movie.reptile;


import com.framework.security.integral.core.model.video.VideoType;
import com.framework.security.integral.web.util.JsoupUtils;
import com.framework.security.integral.web.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

@Service
@Slf4j
public class ReptileService {

    private final static String url = "http://okzyw.com/";

    /**
     * 获取视频清单类型的清单数据
     */
    public List<VideoType> getTypeList() throws IOException {

        List<VideoType> video = new ArrayList<>();

        Document decument = JsoupUtils.getDecument(JsoupUtils.JsoupConnection(url));
        Elements sddm = decument.getElementsByClass("sddm");

        Elements select = sddm.select("li");
        Iterator<Element> iterator = select.iterator();
        while (iterator.hasNext()) {
            Element next = iterator.next();
            VideoType videoType = new VideoType();
            String suffixUrl = next.select("a[href]").attr("href");
            if ("/".equals(suffixUrl)) {
                continue;
            }
            String videoName = next.select("a[onmouseout=mclosetime()]").text();
            videoType.setGmtCreate(new Date());
            videoType.setGmtModified(new Date());
            videoType.setIsDelete(false);
            videoType.setParentId(0);
            videoType.setCode(StringUtil.StringIndexOfNumber(suffixUrl));
            videoType.setUrl(suffixUrl);
            videoType.setName(videoName);
            video.add(videoType);
        }

        return video;
    }

    /**
     * 获取电影电影地址列表
     *
     * @return
     * @throws IOException
     */
    public static List<String> getMovieUrl(int code) throws IOException {


        Document document = JsoupUtils.getDecument(JsoupUtils.JsoupConnection(getUrl(code)));
        Elements select = document.getElementsByClass("xing_vb4");
        Iterator<Element> iterator = select.iterator();
        List<String> htmlStr = new ArrayList<>();
        while (iterator.hasNext()) {
            Element next = iterator.next();
            String href = next.select("a[href]").attr("href");
            htmlStr.add(url + href);
        }

        return htmlStr;
    }

    /**
     * 获取电影的基本信息
     *
     * @return
     * @throws IOException
     */
    public static Movie getMovie(int code) throws IOException {

        // "http://okzyw.com//?m=vod-detail-id-51019.html"
        Document document = JsoupUtils.getDecument(JsoupUtils.JsoupConnection(getUrl(code)));
        List<String> names = new ArrayList<>();
        names.add("vodh");
        names.add("vodImg");
        names.add("vodinfobox");
        names.add("vodplayinfo");

        Map<String, Elements> element = getElement(names, document);

        Movie movie = new Movie();
        movie.setName(element.get("vodh").select("h2").text());
        movie.setImgUrl(element.get("vodImg").select("img[src]").attr("src"));
        Elements select = element.get("vodinfobox").select("span");
        Elements vodplayinfo = element.get("vodplayinfo");
        List<String> selectInfos1 = getSelectInfos(vodplayinfo);
        movie.setSynopsis(selectInfos1.get(0));
        movie.setScore(Float.valueOf(element.get("vodh").select("label").text()));
        List<String> selectInfos = getSelectInfos(select);
        movie.setDirector(selectInfos.get(1));
        movie.setActor(selectInfos.get(2));
        movie.setDate(selectInfos.get(8));

//        System.out.println(element.get("vodplayinfo").select("input").select("input[name=\"copy_sel\"]").select("input[value]").attr("value"));
//        System.out.println(element.get("vodplayinfo"));
        Elements urls = element.get("vodplayinfo").select("input").select("input[name=\"copy_sel\"]").select("input[value]");
        List<String> urlList = getSelectInfo2(urls, "value");
        movie.setMovieUrl(urlList.get(0));
        movie.setDownloadUrl(urlList.get(2));
        movie.setCode(code);
        return movie;
    }

    /**
     * 根据名称获取各个Elements
     *
     * @param names
     * @param document
     * @return
     */
    public static Map<String, Elements> getElement(List<String> names, Document document) {

        Map<String, Elements> elementsMap = new HashMap<>();
        names.forEach((String name) -> {
            elementsMap.put(name, document.getElementsByClass(name));
        });
        return elementsMap;
    }

    public static List<String> getSelectInfos(Elements select) {
        Iterator<Element> iterator = select.iterator();
        List<String> movieInfo = new ArrayList<>();
        while (iterator.hasNext()) {
            movieInfo.add(iterator.next().text());
        }
        return movieInfo;
    }

    public static List<String> getSelectInfo2(Elements select, String name) {
        Iterator<Element> iterator = select.iterator();
        List<String> movieInfo = new ArrayList<>();
        while (iterator.hasNext()) {
            movieInfo.add(iterator.next().attr(name));
        }
        return movieInfo;
    }

    public static String getUrl(int code) {
        String prev = "/?m=vod-detail-id-" + code + ".html";
        return url + prev;
    }

    public static void main(String[] args) throws Exception {
//        List<VodioType> typeList = ReptileService.getTypeList();
//        VodioType vodioType = new VodioType();
//        typeList.forEach(vodioType1 -> {
//            System.out.println(vodioType1.getTypeName());
//            System.out.println(url + vodioType1.getSuffixUrl());
//        });

//        List<String> movie = ReptileService.getMovieUrl();
//        movie.forEach(System.out::println);


        Movie movie1 = ReptileService.getMovie(51019);
        System.out.println(movie1.toString());

    }


}

