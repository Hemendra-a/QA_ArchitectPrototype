package Reader;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelReader {


/*getExcelData()-- excel read data for
*
* @parameter- sheetName-
*             dataId-
*
* @return- Map<String,String>
*
* */
    public Map<String, String> excelReader(String sheetName, String input,String filepath) {
        FileInputStream is = null;
        Map<String,String> dataMap=new HashMap<String,String>();
         try{
             //dynamic with RTO through parameter
        is= new FileInputStream(filepath);
        Workbook book =new XSSFWorkbook(is);
        Sheet sheetObj = book.getSheet(sheetName);
             int rowCount=sheetObj.getLastRowNum();
           int dataRowNumber =0;
           for(int i=0;i<=rowCount;i++){
               Row row=sheetObj.getRow(i);
               Cell cell=row.getCell(0, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
               String dataIdValue=cell.getStringCellValue();
               if(dataIdValue.equalsIgnoreCase(input)){
                   dataRowNumber = i;
               }
           }
           Row dataRow=sheetObj.getRow(dataRowNumber);
           Row firstRow=sheetObj.getRow(0);
           for(int i=1;i<=firstRow.getLastCellNum()-1;i++){
               Cell cellKey=firstRow.getCell(i,Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
               Cell cellData=dataRow.getCell(i, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
              String columnName= cellKey.getStringCellValue();
              String dataValue=cellData.getStringCellValue();
              System.out.println(columnName+":-"+dataValue);
              dataMap.put(columnName,dataValue);
           }
         }catch (IOException e){
         e.printStackTrace();
         }
return dataMap;
    }

    /*--writeData()-- excel read data for
     *
     * @parameter- sheetName-
     *             dataId-
     *
     * @return- Map<String,String>
     *
     * */
    public String excelWriteData(List<String> data,String filePath){
     Workbook dataBook=new XSSFWorkbook();
    Sheet sheet=dataBook.createSheet();
    File location=new File(filePath);

        for(int i=0;i<data.size();i++){
            Row row=sheet.createRow(i);
            Cell cell=row.createCell(0);
            cell.setCellValue(data.get(i));
        }
       try(FileOutputStream outputS=new FileOutputStream(location)){
            dataBook.write(outputS);
           dataBook.close();//
       }catch (IOException e){
           e.printStackTrace();
       }
       return location.getAbsolutePath();
}

/*Hemendra
* */
public  String getBranchCode(String sheetName, String referenceColumn, String referenceValue, String targetColumn, String filepath) {
    FileInputStream is = null;
    String value = null;
    try {
        is = new FileInputStream(filepath);
        Workbook workbook = new XSSFWorkbook(is);
        Sheet sheet = workbook.getSheet(sheetName);
        int referenceColIndex = -1;
        int targetColIndex = -1;

        // Find the column indices for the reference and target columns
        Row headerRow = sheet.getRow(0);
        for (Cell cell : headerRow) {
            if (cell.getStringCellValue().equalsIgnoreCase(referenceColumn)) {
                referenceColIndex = cell.getColumnIndex();
            }
            if (cell.getStringCellValue().equalsIgnoreCase(targetColumn)) {
                targetColIndex = cell.getColumnIndex();
            }
        }

        System.out.println("Reference Column Index: " + referenceColIndex);
        System.out.println("Target Column Index: " + targetColIndex);

        if (referenceColIndex == -1 || targetColIndex == -1) {
            throw new IllegalArgumentException("Invalid column names provided.");
        }

        // Find the row with the reference value
        for (Row row : sheet) {
            Cell referenceCell = row.getCell(referenceColIndex, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
            if (referenceCell.getCellType() == CellType.STRING && referenceCell.getStringCellValue().trim().equalsIgnoreCase(referenceValue.trim())) {
                Cell targetCell = row.getCell(targetColIndex, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);

                // Extract and concatenate numeric and string parts
                if (targetCell.getCellType() == CellType.STRING) {
                    String cellValue = targetCell.getStringCellValue().trim();
                    String numericPart = cellValue.replaceAll("[^0-9]", ""); // Extract numeric part
                    String stringPart = cellValue.replaceAll("[0-9]", ""); // Extract string part
                    value = numericPart + stringPart;
                } else if (targetCell.getCellType() == CellType.NUMERIC) {
                    value = String.valueOf((int) targetCell.getNumericCellValue());
                } else {
                    System.out.println("Target cell is neither numeric nor a valid string.");
                }
                break;
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        if (is != null) {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    return value;
}

    public  String getRTOLocation(String sheetName, String referenceColumn, String referenceValue, String targetColumn, String filepath) {
        FileInputStream is = null;
        String value = null;
        try {
            is = new FileInputStream(filepath);
            Workbook workbook = new XSSFWorkbook(is);
            Sheet sheet = workbook.getSheet(sheetName);
            int referenceColIndex = -1;
            int targetColIndex = -1;

            // Find the column indices for the reference and target columns
            Row headerRow = sheet.getRow(0);
            for (Cell cell : headerRow) {
                if (cell.getStringCellValue().equalsIgnoreCase(referenceColumn)) {
                    referenceColIndex = cell.getColumnIndex();
                }
                if (cell.getStringCellValue().equalsIgnoreCase(targetColumn)) {
                    targetColIndex = cell.getColumnIndex();
                }
            }

            System.out.println("Reference Column Index: " + referenceColIndex);
            System.out.println("Target Column Index: " + targetColIndex);

            if (referenceColIndex == -1 || targetColIndex == -1) {
                throw new IllegalArgumentException("Invalid column names provided.");
            }
            String newReferenceValue=null;
            if (referenceValue.length() == 5 && referenceValue.charAt(3) == '0') {
             newReferenceValue = referenceValue.substring(0, 3) + referenceValue.substring(4);
                 } else if (referenceValue.length() == 4) {
                newReferenceValue = referenceValue.substring(0, 3) + "0" + referenceValue.substring(3);
              }

            // Find the row with the reference value
            for (Row row : sheet) {
                Cell referenceCell = row.getCell(referenceColIndex, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                if (referenceCell.getCellType() == CellType.STRING && referenceCell.getStringCellValue().trim().equalsIgnoreCase(referenceValue.trim()) ||
                 referenceCell.getCellType() == CellType.STRING && newReferenceValue != null && referenceCell.getStringCellValue().trim().equalsIgnoreCase(newReferenceValue.trim())) {
                    Cell targetCell = row.getCell(targetColIndex, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);

                    // Extract and concatenate numeric and string parts
                    if (targetCell.getCellType() == CellType.STRING) {
                        String cellValue = targetCell.getStringCellValue().trim();
                        String numericPart = cellValue.replaceAll("[^0-9]", ""); // Extract numeric part
                        String stringPart = cellValue.replaceAll("[0-9]", ""); // Extract string part
                        value = numericPart + stringPart;
                    } else if (targetCell.getCellType() == CellType.NUMERIC) {
                        value = String.valueOf((int) targetCell.getNumericCellValue());
                    } else {
                        System.out.println("Target cell is neither numeric nor a valid string.");
                    }
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return value;
    }

}