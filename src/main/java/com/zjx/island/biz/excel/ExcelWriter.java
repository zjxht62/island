package com.zjx.island.biz.excel;

/**
 * Demo class
 *
 * @author trevor.zhao
 * @date 2019/7/11
 */
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ExcelWriter {

    private static String[] columns = {"Name", "Email", "Date Of Birth", "Salary"};
    private static List<Employee> employees =  new ArrayList<>();

    // Initializing employees data to insert into the excel file
    static {
        Calendar dateOfBirth = Calendar.getInstance();
        dateOfBirth.set(1992, 7, 21);
        employees.add(new Employee("Rajeev Singh", "rajeev@example.com",
            dateOfBirth.getTime(), 1200000.0));

        dateOfBirth.set(1965, 10, 15);
        employees.add(new Employee("Thomas cook", "thomas@example.com",
            dateOfBirth.getTime(), 1500000.0));

        dateOfBirth.set(1987, 4, 18);
        employees.add(new Employee("Steve Maiden", "steve@example.com",
            dateOfBirth.getTime(), 1800000.0));
    }

//    public static void main(String[] args) throws IOException, InvalidFormatException {
//        // Create a Workbook
//        Workbook workbook = new XSSFWorkbook(); // new HSSFWorkbook() for generating `.xls` file
//
//        /* CreationHelper helps us create instances of various things like DataFormat,
//           Hyperlink, RichTextString etc, in a format (HSSF, XSSF) independent way */
//        CreationHelper createHelper = workbook.getCreationHelper();
//
//        // Create a Sheet
//        Sheet sheet = workbook.createSheet("Employee");
//
//        // Create a Font for styling header cells
//        Font headerFont = workbook.createFont();
//        headerFont.setBold(true);
//        headerFont.setFontHeightInPoints((short) 14);
//        headerFont.setColor(IndexedColors.RED.getIndex());
//
//        // Create a CellStyle with the font
//        CellStyle headerCellStyle = workbook.createCellStyle();
//        headerCellStyle.setFont(headerFont);
//
//        // Create a Row
//        Row headerRow = sheet.createRow(0);
//
//        // Create cells
//        for(int i = 0; i < columns.length; i++) {
//            Cell cell = headerRow.createCell(i);
//            cell.setCellValue(columns[i]);
//            cell.setCellStyle(headerCellStyle);
//        }
//
//        // Create Cell Style for formatting Date
//        CellStyle dateCellStyle = workbook.createCellStyle();
//        dateCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));
//
//        // Create Other rows and cells with employees data
//        int rowNum = 1;
//        for(Employee employee: employees) {
//            Row row = sheet.createRow(rowNum++);
//
//            row.createCell(0)
//                .setCellValue(employee.getName());
//
//            row.createCell(1)
//                .setCellValue(employee.getEmail());
//
//            Cell dateOfBirthCell = row.createCell(2);
//            dateOfBirthCell.setCellValue(employee.getDateOfBirth());
//            dateOfBirthCell.setCellStyle(dateCellStyle);
//
//            row.createCell(3)
//                .setCellValue(employee.getSalary());
//        }
//
////        // Resize all columns to fit the content size
////        for(int i = 0; i < columns.length; i++) {
////            sheet.autoSizeColumn(i);
////        }
//
//        // Write the output to a file
//        FileOutputStream fileOut = new FileOutputStream("poi-generated-file.xlsx");
//        workbook.write(fileOut);
//        fileOut.close();
//
//        // Closing the workbook
//        workbook.close();
//    }

    private static void modifyExistingWorkbook() throws InvalidFormatException, IOException {
        // Obtain a workbook from the excel file
        Workbook workbook = WorkbookFactory.create(new File("existing-spreadsheet.xlsx"));

        // Get Sheet at index 0
        Sheet sheet = workbook.getSheetAt(0);

        // Get Row at index 1
        Row row = sheet.getRow(1);

        // Get the Cell at index 2 from the above row
        Cell cell = row.getCell(2);

        // Create the cell if it doesn't exist
        if (cell == null)
            cell = row.createCell(2);

        // Update the cell's value
        cell.setCellType(CellType.STRING);
        cell.setCellValue("Updated Value");

        // Write the output to the file
        FileOutputStream fileOut = new FileOutputStream("existing-spreadsheet.xlsx");
        workbook.write(fileOut);
        fileOut.close();

        // Closing the workbook
        workbook.close();
    }

    public static void main(String[] args) {
        try {
            Workbook workbook = WorkbookFactory.create(new File("0708加机构编码.xlsx"));
            Sheet sheet = workbook.getSheet("Sheet1");

            Row row = sheet.getRow(1);

            Cell cell = row.getCell(2);
            System.out.println(cell.getStringCellValue());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
