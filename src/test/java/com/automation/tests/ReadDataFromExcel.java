package com.automation.tests;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class ReadDataFromExcel {

    @Test
    public void readExcelFileTest() throws IOException {

        //we need to get a file as an object
        File file = new File("Book it - test case doc.xlsx");
        //object that represents excel file
        Workbook workbook = WorkbookFactory.create(file);
        //get QA1-short
        Sheet workSheet = workbook.getSheet("Asena");
        //get 1st row
        Row firstRow = workSheet.getRow(0);
        //get 1st cell
        Cell firstCell = firstRow.getCell(0);
        //get string value
        String value = firstCell.getStringCellValue();
        String secodCellValue = firstRow.getCell(1).getStringCellValue();

        System.out.println(value);
        System.out.println(secodCellValue);

        int lastCellNum = firstRow.getLastCellNum();

        for (int i = 0; i <lastCellNum ; i++) {
            System.out.print(firstRow.getCell(i)+ " | ");

        }

        int numberOfRow = workSheet.getLastRowNum()+1;
        // return how many rows att all
        int numberOfRow2 = workSheet.getPhysicalNumberOfRows();
        System.out.println("\nNumber of rows : "+numberOfRow);
        System.out.println("\n Number of row 2 : " +numberOfRow2);

        System.out.println("###################################");

        for (int row = 0; row < workSheet.getPhysicalNumberOfRows() ; row++) {
            for (int cell = 0; cell < workSheet.getRow(row).getLastCellNum(); cell++) {
                String cellValue = workSheet.getRow(row).getCell(cell).getStringCellValue();
                System.out.println(cellValue+" | ");
                
            }
            System.out.println();
            
        }


    }
}
