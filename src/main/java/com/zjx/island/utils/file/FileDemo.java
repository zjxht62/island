package com.zjx.island.utils.file;

import java.io.File;
import java.util.Arrays;

/**
 * Demo class
 *
 * @author trevor.zhao
 * @date 2020/11/19
 */
public class FileDemo {
    public static void main(String[] args) {
        String bucketName = "zjxht62";
        File file = new File("/zjx/oss/" + bucketName);
        String[] folders = file.list();
//        System.out.println(Arrays.toString(folders));
        getFiles("/zjx/oss/zjxht62");


    }

    public static void getFiles(String path) {
        File file = new File(path);
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                if (files[i].isDirectory()) {
                    getFiles(files[i].getPath());
                } else {
                    System.out.println("文件: " + files[i].getPath());
                }
            }
        } else {
            System.out.println("文件: " + file.getPath());
        }


    }
}
