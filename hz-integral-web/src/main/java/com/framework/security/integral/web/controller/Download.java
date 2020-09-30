package com.framework.security.integral.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.rmi.runtime.Log;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author gaoxu
 */


@RestController
@RequestMapping("/down")
@Slf4j
public class Download {

    @RequestMapping("downloadFileAction")
    public void downloadFileAction(HttpServletRequest request, HttpServletResponse response) {

        response.setCharacterEncoding(request.getCharacterEncoding());
        response.setContentType("application/octet-stream");
        FileInputStream fis = null;
        try {
            File file = new File("http://192.168.1.213/share/jg-sharecompat/text.txt");
            log.info("文件路径：{}", file);
            fis = new FileInputStream(file);
            response.setHeader("Content-Disposition", "attachment; filename=" + file.getName());
            IOUtils.copy(fis, response.getOutputStream());
            response.flushBuffer();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws UnknownHostException {

        // TODO Auto-generated method stub
//        // 在我的电脑属性查看名称粘贴过来，此为我的虚拟名。  这个方法不适合于全部
//        InetAddress IP = InetAddress.getByName("DESKTOP-3T17LSR");
//        System.out.println("第一种方式:" + IP);

        InetAddress ip = InetAddress.getLocalHost();
        System.out.println("第二种方式:" + ip);

//        byte[] addr = {10, 10, 21, (byte) 168};
//        // 在电脑网络设置查看自己的IP地址，粘贴过来，此为我的虚拟地址。
//        InetAddress ip2 = InetAddress.getByAddress(addr);
//        System.out.println("第三种方式:" + ip2);

//        System.out.println(ip2.getHostName());
//        byte[] address = ip2.getAddress();
//        for (byte a : address) {
//            int b = (a < 0) ? (a + 256) : a;
//            System.out.println("常规方法:" + b + ".");
//        }
    }

}



