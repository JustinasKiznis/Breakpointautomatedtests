package utils;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtils {
    private static XSSFWorkbook workbook;

    private static XSSFSheet sheet;

    private static XSSFCell cell;

    public static Double[][] getTableArray(String fileName, String sheetName) throws IOException {
        Double[][] tabArray = null;

        String filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\" + fileName + ".xlsx";
        FileInputStream excelFile = new FileInputStream(filePath);

        workbook = new XSSFWorkbook(excelFile);
        sheet = workbook.getSheet(sheetName);

        int startRow = 0;
        int startCol = 0;
        int totalRows = sheet.getLastRowNum();
        int totalColumns = sheet.getRow(0).getLastCellNum();
        int ci;
        int cj;

        tabArray = new Double[totalRows][totalColumns];
        ci = 0;
        for (int i = startRow; i < totalRows; i++, ci++) {
            cj = 0;
            for (int j = startCol; j < totalColumns; j++, cj++) {
                tabArray[ci][cj] = getCellData(i, j);
                System.out.println(tabArray[ci][cj]);
            }
        }
        workbook.close();
        return tabArray;
    }

    private static Double getCellData(int rowNum, int colNum) {
        cell = sheet.getRow(rowNum).getCell(colNum);
        return cell.getNumericCellValue();
    }


    private static int[][][] getMarkInfo(String fileName, String sheetName) throws IOException{
        int x[][][] = null;
        Object[][] markSheetInfo = getTableArray(fileName, sheetName);
        int markCount = Integer.getInteger(markSheetInfo[0][0].toString());
        for(int i = 0; i < markCount; i++){
            //x[i][i][i] =
        }
        return x;
    }
}
