package com.zjx.island.biz.readfile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * Demo class
 *
 * @author trevor.zhao
 * @date 2019/10/21
 */
public class ReadAFile {
    public static void main(String[] args) {
        try {
            File file = new File("config.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader reader = new BufferedReader(fileReader);

            String line = null;

            while ((line = reader.readLine()) != null) {
                if (line.startsWith("#")) {
                    continue;
                }
                String[] eles = line.split(";");
                System.out.println(eles[7]);
//                for (String ele : eles) {
//                    System.out.println(ele);
//                }
//                System.out.println(eles.length);
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
