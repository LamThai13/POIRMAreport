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
public class ReadExcelFileToList {
     public List<RMA_report> readExcelData(String fileName) throws IOException{
    List<RMA_report> listRMA = new ArrayList<RMA_report>();
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
            
            //create iterator for row
            Iterator<Row> rowIterator = sheet.iterator();
            while(rowIterator.hasNext()){
                //get the row and travel through each line
                Row row = rowIterator.next();
                //skip the first line
                if(row.getRowNum()==0)
                    continue;
                //create an POS object to store value
                RMA_report quoObj = new RMA_report();
                //create iterator for cell
                Iterator<Cell> cellIterator = row.cellIterator();
                while(cellIterator.hasNext()){
                    //get the cell object and travel through each cell
                    Cell cell = cellIterator.next();
                    //get the column index to assign appropriate value to Object
                    int columnIndex = cell.getColumnIndex();
                    
                    //using switch to assign the cells' value to POS object
                    switch (columnIndex+1){
                        case 1:
                            quoObj.setSerial(String.valueOf(getCellValue(cell)) );
                            break;
                        case 2:
                            quoObj.setRMA(String.valueOf(getCellValue(cell)));
                            break;
                        case 3:
                            quoObj.setInWarranty(String.valueOf(getCellValue(cell)));
                            break;
                        case 4:
                            quoObj.setStatus(String.valueOf(getCellValue(cell)));
                            break;
                        case 5:
                            quoObj.setModel(String.valueOf(getCellValue(cell)));
                            break;
                        case 6:
                            quoObj.setCustomerProblem(String.valueOf(getCellValue(cell)));
                            break;
                        case 7:
                            /*quoObj.setCustomerFoundissue(String.valueOf(getCellValue(cell)));
                            break;
                        case 8:*/
                            quoObj.setReceivedDate(String.valueOf(getCellValue(cell)));
                            break;
                        case 8:
                            quoObj.setShippingDate(String.valueOf(getCellValue(cell)));
                            break;
                        case 9:
                            quoObj.setCompany(String.valueOf(getCellValue(cell)));
                            break;
                        case 10:
                            quoObj.setCustomer(String.valueOf(getCellValue(cell)));
                            break;
                        case 11:
                            quoObj.setSupplyer(String.valueOf(getCellValue(cell)) );
                            break;
                        case 12:
                            quoObj.setReturnDate(String.valueOf(getCellValue(cell)));
                            break;
                        case 13:
                            quoObj.setRepairNote(String.valueOf(getCellValue(cell)));
                            break;
                        case 14:
                           /* quoObj.setRootCause(String.valueOf(getCellValue(cell)));
                            break;
                        case 16:*/
                            quoObj.setRouteType(String.valueOf(getCellValue(cell)));
                            break;
                        case 15:
                            quoObj.setSymptom(String.valueOf(getCellValue(cell)));
                            break;
                        case 16:
                            quoObj.setProblem(String.valueOf(getCellValue(cell)));
                            break;
                        case 17:
                            quoObj.setDistribution(String.valueOf(getCellValue(cell)));
                            break;
                        case 18:
                            quoObj.setCategory(String.valueOf(getCellValue(cell)));
                            break;
                        case 19:
                            quoObj.setRepairDate(String.valueOf(getCellValue(cell)));
                            break;
                        case 20:
                            quoObj.setPartSN(String.valueOf(getCellValue(cell)));
                            break;
                        case 21:
                            quoObj.setTAT(String.valueOf(getCellValue(cell)));
                            break;
                        case 22:
                            quoObj.setRepairer(String.valueOf(getCellValue(cell)));
                            break;
                        case 23:
                            quoObj.setCusRMANo(String.valueOf(getCellValue(cell)));
                            break;
                        case 24:
                            quoObj.setBU(String.valueOf(getCellValue(cell)));
                            break;
                        case 25:
                            quoObj.setMore(String.valueOf(getCellValue(cell)));
                            break;
                        case 26:
                            quoObj.setRequestDate(String.valueOf(getCellValue(cell)));
                            break;
                        
                    }//end of swich
                    
                }//end of cells iterator
                listRMA.add(quoObj);
            }//end of rows
            fis.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReadExcelFileToList.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listRMA;
    }
    public  Object getCellValue(Cell cell){
        //check cell type and process accordingly
        switch (cell.getCellType()){
            case Cell.CELL_TYPE_BOOLEAN:
                return cell.getBooleanCellValue();
            case Cell.CELL_TYPE_FORMULA:
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
            case Cell.CELL_TYPE_STRING:
                return cell.getStringCellValue();
            case Cell.CELL_TYPE_NUMERIC:
                return cell.getNumericCellValue();
            case Cell.CELL_TYPE_BLANK:
                return "";
            case Cell.CELL_TYPE_ERROR:
                return cell.getErrorCellValue();
        } 
        return null;
    }
}
