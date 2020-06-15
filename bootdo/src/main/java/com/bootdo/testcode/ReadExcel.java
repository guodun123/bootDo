package com.bootdo.testcode;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.*;

import java.io.*;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ReadExcel {

    public static void main(String[] args) {
// TODO Auto-generated method stub
       // ReadExcel ertw = new ReadExcel();
        //ertw.writeExcel();
        //ertw.readExcel();
        try {
            FileInputStream fis = new FileInputStream("D:\\address.xlsx");
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            parseExcel(wb);
        }catch (Exception e){

        }

    }

    //在Excel中写入数据
    public void writeExcel() {
        try {
            FileOutputStream fos = new FileOutputStream("D:\\address.xlsx");
            HSSFWorkbook wb = new HSSFWorkbook();
            HSSFSheet s = wb.createSheet();
            wb.setSheetName(0, "first sheet");
            HSSFRow row = s.createRow(0);
            HSSFCell cell = row.createCell(0, 0);
            HSSFRichTextString hts = new HSSFRichTextString("row0 第一行第一列数据");//第一行第一列数据
            cell.setCellValue(hts);

            HSSFRow row1 = s.createRow(1);
            HSSFCell cell1 = row1.createCell(0, 1);
            HSSFRichTextString hts1 = new HSSFRichTextString("row1 第二行第一列数据");//第二行第一列数据
            cell1.setCellValue(hts1);

// HSSFCell cell2 = row.createCell((int)1, 0);
// cell2.setCellValue(222);//写入整型
            wb.write(fos);
            fos.flush();
            fos.close();
            System.out.println("excel中成功添加数据");
        } catch (IOException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    //从Excel中读数据
    public void readExcel() {
        try {
            FileInputStream fis = new FileInputStream("D:\\phone.xlsx");
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet s = wb.getSheetAt(0);
            Iterator<Row> row = s.iterator();
            for (Iterator<Row> it = row; it.hasNext(); ) {
                Row r = it.next();
                Iterator<Cell> cs =  r.iterator();
                for (Iterator<Cell> iter = cs; iter.hasNext(); ) {
                    Cell c = iter.next();
                    System.out.println(4);
                }
            }

        } catch (IOException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    private static void parseExcel(XSSFWorkbook workbook) {
        // 解析sheet
        for (int sheetNum = 0; sheetNum < workbook.getNumberOfSheets(); sheetNum++) {
            Sheet sheet = workbook.getSheetAt(sheetNum);

            // 校验sheet是否合法
            if (sheet == null) {
                continue;
            }

            // 获取第一行数据
            int firstRowNum = sheet.getFirstRowNum();
            Row firstRow = sheet.getRow(firstRowNum);

            // 解析每一行的数据，构造数据对象
            int rowStart = firstRowNum + 1;
            int rowEnd = sheet.getPhysicalNumberOfRows();
            int a = 0;
            for (int rowNum = rowStart; rowNum < rowEnd; rowNum++) {

                Row row = sheet.getRow(rowNum);
                String before = row.getCell(0).getStringCellValue();
                String after = row.getCell(2).getStringCellValue();
                if (!before.equals(after)){
                    System.out.println(before);
                    System.out.println(after);
                }

                a++;
            }
            System.out.println(a);
        }
    }

}
