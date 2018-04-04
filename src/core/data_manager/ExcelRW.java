package core.data_manager;
//Purpose: To manage CRUD ON EXCEL FILES.

import core.extras.BankQues;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataValidation;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddressList;
import org.apache.poi.xssf.usermodel.XSSFDataValidation;
import org.apache.poi.xssf.usermodel.XSSFDataValidationConstraint;
import org.apache.poi.xssf.usermodel.XSSFDataValidationHelper;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import setup.SetupManager;

public class ExcelRW {

    // excel file column names..
    // question
    // marks
    // difficulty - easy/medium/hard
    // type - short/long
    // unit/chapter
    // topic
    private static final String headers[]
            = {"Chapter/Unit", "Topic", "Question", "Type", "Difficulty", "Marks"};
    
    private static ArrayList<Integer> noList = new ArrayList<>();

    private static void createCell(Workbook wb, Row row, int column, String value,
            Font font, HorizontalAlignment halign, VerticalAlignment valign) {

        // cell settings 
        Cell cell = row.createCell(column);
        cell.setCellValue(value);
        CellStyle cellStyle = wb.createCellStyle();
        cellStyle.setAlignment(halign);
        cellStyle.setVerticalAlignment(valign);
        cellStyle.setFont(font);
        cell.setCellStyle(cellStyle);
    }

    public static boolean createExcel(String filename, String sheetname) {
        boolean success = true;
        // export the written file to desktop
        // sheet name is exam assistant - subject name
        XSSFWorkbook wb = new XSSFWorkbook();
        // Font setings ↓
        Font font = wb.createFont();
        font.setFontHeightInPoints((short) 12);
        font.setBold(true);
        font.setFontName("Verdana");
        try {
            FileOutputStream fs = new FileOutputStream(
                    new File(SetupManager.getDir("desktop") + "\\" + filename + ".xlsx"));
            XSSFSheet sheet = wb.createSheet(sheetname);
            sheet.setDefaultRowHeightInPoints(20); // for every row
            Row row = sheet.createRow(0); // for first row 
            row.setHeightInPoints(35); // first row only
            sheet.createFreezePane(0, 1, 0, 1); // first row is frozen
            for (int i = 0; i < 6; i++) {
                createCell(wb, row, i, headers[i], font,
                        HorizontalAlignment.CENTER, VerticalAlignment.CENTER);
            }
            // columns created..              
            sheet.setColumnWidth(0, 7000);
            sheet.setColumnWidth(1, 7000);
            sheet.setColumnWidth(2, 18000);
            sheet.setColumnWidth(3, 4000);
            sheet.setColumnWidth(4, 4000);
            sheet.setColumnWidth(5, 4000);
            // column width adjustment ↑

            // drop down lists
            // difficulty drop down list and validation
            XSSFDataValidationHelper dvHelper = new XSSFDataValidationHelper(sheet);
            XSSFDataValidationConstraint dvConstraint
                    = (XSSFDataValidationConstraint) dvHelper.createExplicitListConstraint(new String[]{"EASY", "MEDIUM", "HARD"});
            CellRangeAddressList addressList = new CellRangeAddressList(1, 5000, 4, 4);
            XSSFDataValidation validation = (XSSFDataValidation) dvHelper.createValidation(
                    dvConstraint, addressList);
            validation.setSuppressDropDownArrow(true);
            validation.setErrorStyle(DataValidation.ErrorStyle.STOP);
            validation.createErrorBox("Wrong data entered", "Please choose a value from drop down list");
            validation.setShowErrorBox(true);
            sheet.addValidationData(validation);
            // type drop down list and validation
            XSSFDataValidationConstraint dvConstraint1
                    = (XSSFDataValidationConstraint) dvHelper.createExplicitListConstraint(new String[]{"SHORT", "LONG"});
            CellRangeAddressList addressList1 = new CellRangeAddressList(1, 5000, 3, 3);
            XSSFDataValidation validation1 = (XSSFDataValidation) dvHelper.createValidation(
                    dvConstraint1, addressList1);
            validation1.setSuppressDropDownArrow(true);
            validation1.setErrorStyle(DataValidation.ErrorStyle.STOP);
            validation1.createErrorBox("Wrong data entered", "Please choose a value from drop down list");
            validation1.setShowErrorBox(true);
            sheet.addValidationData(validation1);
            // validation for marks 
            XSSFDataValidationConstraint dvConstraint2 = (XSSFDataValidationConstraint) dvHelper.createNumericConstraint(
                    XSSFDataValidationConstraint.ValidationType.INTEGER,
                    XSSFDataValidationConstraint.OperatorType.BETWEEN,
                    "1", "20");
            CellRangeAddressList addressList2 = new CellRangeAddressList(1, 5000, 5, 5);
            XSSFDataValidation validation2 = (XSSFDataValidation) dvHelper.createValidation(
                    dvConstraint2, addressList2);
            validation2.setErrorStyle(DataValidation.ErrorStyle.STOP);
            validation2.createErrorBox("Wrong data entered", "ONLY INTEGERS ALLOWED (1-20)");
            validation2.setShowErrorBox(true);
            sheet.addValidationData(validation2);
            // VALIDATION ADDED FOR MARKS, TYPE AND DIFFICULTY
            wb.write(fs);
            fs.close();

        } catch (Exception e) {
            success = false;
        }
        return success;
    }

    public static BankQues[] readExcel(String path) throws IOException {
        ArrayList<BankQues> ar = new ArrayList<>();
        int max = 0;
        Row row = null;    
            XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(path));
            XSSFSheet sh = wb.getSheetAt(0);
            max = sh.getLastRowNum();
            for (int i = 1; i <= max; i++) {
                if(noList.contains(i)){
                    continue;
                }
                
            // to iterate through excel rows
                row = sh.getRow(i);
                ar.add(new BankQues(row.getCell(0).getStringCellValue(),
                row.getCell(1).getStringCellValue(),
                row.getCell(2).getStringCellValue(),
                row.getCell(3).getStringCellValue(),
                row.getCell(4).getStringCellValue(), 
                row.getCell(5).getNumericCellValue()));
            }
     return ar.toArray(new BankQues[ar.size()]);
    }

    public static boolean validateExcel(String path) {
        // to check the structural integrity of file before proceeding reading
        boolean success = true;
        int max = 0;
        Row row = null; 
        try{
            XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(path));
            XSSFSheet sh = wb.getSheetAt(0);
            max = sh.getLastRowNum();
            
            // validate headers..
            row = sh.getRow(0);
            for (int i = 0; i < 6; i++) {
                if(!row.getCell(i).getStringCellValue().equals(headers[i])){
                  return false;  
                }
            }
            // when done.
            // look for blank values..
            for (int i = 1; i <= max; i++) {
                row = sh.getRow(i);
                for (int j = 0; j < 6; j++) {
                   if(row.getCell(j) == null){
                     noList.add(i); // it will add that list to reject list
                   } 
                }
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
            success = false;
        }
        return success;
    }

}
