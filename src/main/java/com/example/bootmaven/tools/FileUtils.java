package com.example.bootmaven.tools;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: robin
 * @description:
 * @author: caowujun
 * @create: 2020-07-02 08:34
 **/
public class FileUtils {
    /*
     * @description：
     * @param： [size]
     * @return： java.lang.String
     * @author： caowujun
     * @date： 2020/7/2
     */
    public static String getFileSize(Long size) {

        if (size.intValue() > 1048576) {
            return String.format("%.2fmb", size.doubleValue() / 1048576);

        } else {
            return String.format("%.2fkb", size.doubleValue() / 1024);
        }
    }

    /*
     * @description： 根据递归获取所有的文件,外面判断file是否存在
     * @param： [dir] 选中的文件夹对象
     * @return：
     * @author： caowujun
     * @date： 2019/6/21
     */
    public static List<File> getFiles(File dir) {
        if (dir.isFile()) {
            return new ArrayList<File>();
        }

        File[] files = dir.listFiles();
        List<File> result = new ArrayList<File>();
        if (files == null || files.length == 0) return result;
        for (File file : files) {
            if (file.isFile()) {
                result.add(file);
            }
            if (file.isDirectory()) {
                result.addAll(getFiles(file));
            }
        }
        return result;
    }


    /*
     * @description：
     * @param： [path]
     * @return： boolean
     * @author： caowujun
     * @date： 2019/6/24
     */
    public static boolean deleteFile(String path) {
        try {
            File file = new File(path);
            if (file.exists()) {
                return file.delete();
            }
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    /*
     * @description：
     * @param： [dir]
     * @return： java.util.List<java.io.File>
     * @author： caowujun
     * @date： 2020/7/2
     */
//    private static List<File> getFiles_child(File dir) {
//        if (dir.isFile()) {
//            return new ArrayList<File>();
//        }
//        File[] files = dir.listFiles();
//
//        List<File> result = new ArrayList<File>();
//        if (files == null || files.length == 0) return result;
//
//         for (File file : files) {
//            if (file.isFile()) {
//                result.add(file);
//            }
//            if (file.isDirectory()) {
//                result.addAll(getFiles_child(file));
//            }
//        }
//        return result;
//    }
}
