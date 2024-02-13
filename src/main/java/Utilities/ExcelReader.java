package Utilities;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelReader {

    // This function reads data from Excel sheet and stores in List of Maps
    public static List<Map<String, String>> readExcelData(String filePath, String sheetName, String TestcaseID) {

        List<Map<String, String>> excelData = new ArrayList<>();

        try (Workbook workbook = new XSSFWorkbook(new FileInputStream(new File(filePath)))) {
            Sheet sheet = workbook.getSheet(sheetName);

            // Assuming the first row is the template
            Row templateRow = sheet.getRow(0);
            int lastRowNum = sheet.getLastRowNum();
            int lastCellNum = templateRow.getLastCellNum();
            String cellFirstColumn="";

            for (int rowNum = 1; rowNum <= lastRowNum; rowNum++) {


                Row currentRow = sheet.getRow(rowNum);
                if(currentRow.getCell(0).getStringCellValue().equalsIgnoreCase(TestcaseID)) {
                    Map<String, String> rowData = new HashMap<>();

                    for (int cellNum = 0; cellNum < lastCellNum; cellNum++) {
                        Cell templateCell = templateRow.getCell(cellNum);
                        Cell currentCell = currentRow.getCell(cellNum);

                        // Assuming template cells have values and are not empty
                        String columnName = templateCell.getStringCellValue();
                        String cellValue = currentCell.getStringCellValue();
                        rowData.put(columnName, cellValue);
                    }

                    excelData.add(rowData);
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return excelData;
    }
}

