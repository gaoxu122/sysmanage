package com.framework.security.integral.web.util;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author gaoxu
 */
public class IOUtils {
//    private final static List<Map<String, String>> list = new ArrayList<>();

    public static void main(String[] args) {

        try {
            List<Map<String, String>> maps = readFile("D:/video");
            System.out.println(maps.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 读取某个文件夹下的所有文件(支持多级文件夹)
     *
     * @param filepath 根文件夹路径
     * @return List<Map < String, String>> 所有文件的信息{路径信息}，{文件名信息}，
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static List<Map<String, String>> readFile(String filepath) throws FileNotFoundException, IOException {

        List<Map<String, String>> list = new ArrayList<>();
        try {

            File file = new File(filepath);
            if (!file.isDirectory()) {
                Map<String, String> map = new HashMap<>();
                map.put("path", file.getPath());
                map.put("name", file.getName());
                list.add(map);
            } else if (file.isDirectory()) {
                String[] filelist = file.list();
                for (int i = 0; i < filelist.length; i++) {
                    File readfile = new File(filepath + "/" + filelist[i]);
                    if (!readfile.isDirectory()) {
                        Map<String, String> map = new HashMap<>();
                        String path =readfile.getPath();
                        String s = path.replaceAll("\\\\", "/");
                        map.put("path",s);
                        map.put("name", readfile.getName());
                        list.add(map);
//                        System.out.println("path="+readfile.getPath());
//                        System.out.println("absolutepath=" + readfile.getParent());
//                        System.out.println("name=" + readfile.getName());

                    } else if (readfile.isDirectory()) {

                        readFile(filepath + "/" + filelist[i]);
                    }
                }

            }

        } catch (FileNotFoundException e) {
            System.out.println("readFile()   Exception:" + e.getMessage());
        }
        return list;
    }
}
