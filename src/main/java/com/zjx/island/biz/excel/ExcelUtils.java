package com.zjx.island.biz.excel;


import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import sun.misc.BASE64Decoder;

import java.io.File;
import java.io.FileOutputStream;

/**
 * @author derek.liang on 2017/7/7.
 */
public class ExcelUtils {
    private static final String BASE_64_Header = "data:application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;base64,";
    private static final String FILE_PATH = "D:\\excelTest\\";
    private static final String DEFAULT_SHEET_NAME = "Sheet1";


    public static Sheet insertByExcel(String path, String sheetName) throws Exception {
        File file = new File(path);
        Workbook workbook = WorkbookFactory.create(file);
        Sheet sheet = workbook.getSheet(sheetName);
        return sheet;
    }

    public static Sheet insertByExcelDefault(String path) throws Exception {
        return insertByExcel(path,DEFAULT_SHEET_NAME);
    }


    private static void decoderBase64File(String base64Code, String targetPath) throws Exception {
        byte[] buffer = new BASE64Decoder().decodeBuffer(base64Code);
        FileOutputStream out = new FileOutputStream(targetPath);
        out.write(buffer);
        out.close();
    }
}
