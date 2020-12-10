package com.zjx.island.utils.file;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Demo class
 *
 * @author trevor.zhao
 * @date 2020/11/19
 */
public class FileUtils {

    private class myPrivate {

    }

    public static void main(String[] args) {
        String bucketName = "zjxht62";
        File file = new File("/zjx/oss/" + bucketName);
        String[] folders = file.list();
//        System.out.println(Arrays.toString(folders));
        System.out.println(new FileUtils().getFiles("/zjx/oss/zjxht62"));


    }

    private List<String> nameList = new ArrayList<>();

    public List<String> getFiles(String path) {
        File file = new File(path);
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                if (files[i].isDirectory()) {
                    getFiles(files[i].getPath());
                } else {
                    nameList.add(files[i].getPath());
                }
            }
        } else {
            nameList.add(file.getPath());
        }
        return nameList;
    }
}


