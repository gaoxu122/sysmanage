package com.framework.security.integral.web.biz;

import cn.hutool.json.JSONException;
import cn.hutool.json.JSONObject;

import java.io.*;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.charset.Charset;

/**
 * @author gaoxu
 */
public class IpService {

    public static String getLocalIp() throws UnknownHostException {

        InetAddress ip = InetAddress.getLocalHost();
        return ip.toString();
    }


    public String getCity() {


        return null;
    }

    /**
     * @param rd
     * @return
     * @throws IOException
     */
    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = null;
        try {
            is = new URL(url).openStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json = new JSONObject(jsonText);
            return json;
        } finally {

            // 关闭输入流
            is.close();
        }
    }

    public static void main(String[] args) throws IOException {
        String localIp = getLocalIp();
        JSONObject jsonObject = readJsonFromUrl("http://api.map.baidu.com/location/ip?ak=iTrwV0ddxeFT6QUziPQh2wgGofxmWkmg&ip=" + localIp);
        System.out.println(jsonObject);

    }
}
