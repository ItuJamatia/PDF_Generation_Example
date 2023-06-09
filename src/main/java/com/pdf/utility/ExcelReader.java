package com.pdf.utility;

import org.springframework.stereotype.Component;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReader {
	
    public void readExcel() {
        String filePath = "C:\\Users\\Itu J\\Desktop\\important\\basic.xlsx";

        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            // Get the first sheet of the workbook
            Sheet sheet = workbook.getSheetAt(0);

            // Iterate over rows
            for (Row row : sheet) {
                // Iterate over cells
                for (Cell cell : row) {
                    // Get the cell value
                    CellType cellType = cell.getCellType();
                    if (cellType == CellType.STRING) {
                        System.out.print(cell.getStringCellValue() + "\t");
                    } else if (cellType == CellType.NUMERIC) {
                        System.out.print(cell.getNumericCellValue() + "\t");
                    } else if (cellType == CellType.BOOLEAN) {
                        System.out.print(cell.getBooleanCellValue() + "\t");
                    } // Handle other cell types as needed
                }
                System.out.println();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

