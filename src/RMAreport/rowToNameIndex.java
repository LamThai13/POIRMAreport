/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMAreport;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Kevin
 */
public class rowToNameIndex {
    public rowToNameIndex (String fileName, int sheetInx) throws IOException{
    Map<String, Integer> map = new HashMap<String,Integer>(); //Create map
    try {
            FileInputStream fis = new FileInputStream(fileName);
            //create instance workbook for reading both xlsx,xls
            Workbook workbook = null;
            if(fileName.toLowerCase().endsWith("xlsx")||fileName.toLowerCase().endsWith("xlsm")){
                workbook = new XSSFWorkbook(fis);
            }else if(fileName.toLowerCase().endsWith("xls")){
                workbook = new HSSFWorkbook(fis);
            }
            //get sheet position
            Sheet sheet = workbook.getSheetAt(sheetInx);
            
            Row row = sheet.getRow(0); //Get first row

            short minColIx = row.getFirstCellNum(); //get the first column index for a row
            short maxColIx = row.getLastCellNum(); //get the last column index for a row
            for(short colIx=minColIx; colIx<maxColIx; colIx++) { //loop from first to last index
            Cell cell = row.getCell(colIx); //get the cell
            map.put(cell.getStringCellValue(),cell.getColumnIndex()) ;//add the cell contents (name of column) and cell index to the map
            }
            }
            catch (FileNotFoundException ex) {
            Logger.getLogger(ReadExcelFileToList.class.getName()).log(Level.SEVERE, null, ex);
            }
    
    }   

    rowToNameIndex() {
        
    }
    }
    

