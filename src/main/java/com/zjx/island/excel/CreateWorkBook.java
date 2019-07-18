package com.zjx.island.excel;


import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;

/**
 * Demo class
 *
 * @author trevor.zhao
 * @date 2019/7/11
 */
public class CreateWorkBook {
    public static void main(String[] args) {
        try {
            //Create Blank workbook
            XSSFWorkbook workbook = new XSSFWorkbook();

            //Create file system using specific name
            FileOutputStream out = new FileOutputStream(new File("createworkbook.xlsx"));

            //write operation workbook using file out object
            workbook.write(out);
            out.close();
            System.out.println("createworkbook.xlsx written successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
