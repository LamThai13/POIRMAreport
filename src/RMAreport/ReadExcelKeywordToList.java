/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMAreport;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Thai
 */
public class ReadExcelKeywordToList {
     
     public List readExcelData(String fileName) throws IOException{
     List<keyword> keyword = new ArrayList<keyword>();
     int maxDatacount=0;
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
            Sheet sheet = workbook.getSheetAt(0);
            for(int r=sheet.getFirstRowNum();r<sheet.getLastRowNum();r++){               
                Row row = sheet.getRow(r);
                keyword keyObj;
                for( int c = row.getFirstCellNum();c<row.getLastCellNum();c++ ){  
                    keyObj = new keyword();
                Cell cell = row.getCell(c);
                
                keyObj.setGroupName(String.valueOf(getCellValue(sheet.getRow(0).getCell(cell.getColumnIndex()))));
                keyObj.setKeyword(String.valueOf(getCellValue(cell)));
                keyword.add(keyObj); 
            }
            //create iterator for row
            /*Iterator<Row> rowIterator = sheet.iterator();
            
            while(rowIterator.hasNext()){
                //get the row and travel through each line
                Row row = rowIterator.next();
                        // if(row.getRowNum()==0){
                    //maxDatacount=row.getLastCellNum();                    
                //}
                //if(this.isRowEmpty(row,maxDatacount)){
               //Exit the processing
                //break;
                //}

                //skip the first line
                //if(row.getRowNum()==0)
                   //continue;
                //create keyword Object to store value
                keyword keyObj = new keyword();
                //create iterator for cell
                Iterator<Cell> cellIterator = row.cellIterator();
                int columnIndex = row.getFirstCellNum();
                int lastColumn = row.getLastCellNum();
                while(cellIterator.hasNext()){               
                    //get the cell object and travel through each cell
                    Cell cell = cellIterator.next();
                                                                
                        keyObj.setKeyword(String.valueOf(getCellValue(cell)));
                        keyObj.setGroupName(String.valueOf(getCellValue(sheet.getRow(0).getCell(cell.getColumnIndex()))));
                
                }
                keyword.add(keyObj);
                
            }//end of rows*/
            for(int i = 0;i<keyword.size();i++)
                System.out.println(keyword.get(i).getGroupName());
            fis.close();
            }
        }catch (FileNotFoundException ex) {
            Logger.getLogger(ReadExcelKeywordToList.class.getName()).log(Level.SEVERE, null, ex);
        }
        return keyword;
     }
    public  Object getCellValue(Cell cell){
        //check cell type and process accordingly
        switch (cell.getCellTypeEnum()){
            case BOOLEAN:
                return cell.getBooleanCellValue();
            case FORMULA:
                return cell.getCellFormula();
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                SimpleDateFormat fdate = new SimpleDateFormat();
                switch(cell.getCachedFormulaResultType()){
                    case Cell.CELL_TYPE_NUMERIC:
                        if(HSSFDateUtil.isCellDateFormatted(cell)){
                            return fdate.format(cell.getDateCellValue());
                        }else{
                            return cell.getNumericCellValue();
                        }
                    case Cell.CELL_TYPE_STRING:
                        return cell.getRichStringCellValue();
                }
                
            case BLANK:
                return "";
            case ERROR:
                return cell.getErrorCellValue();
        } 
        return "";
    }
        public boolean isRowEmpty(Row row,int lastcellno) {

     for (int c = row.getFirstCellNum(); c < lastcellno; c++) {

         Cell cell = row.getCell(c,Row.CREATE_NULL_AS_BLANK);

         if (cell != null && cell.getCellType() != Cell.CELL_TYPE_BLANK)

             return false;

     }

     return true;

 }
}
