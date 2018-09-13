/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMAreport;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.hssf.usermodel.HSSFFormulaEvaluator;
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
public class writeRMAtoFile {
    public void writeRMAtoFile(FileInputStream input, String fileName, List<RMA_report> ListRMA, int SheetAt, int rowIndex) throws Exception{
        Workbook workbook = null;
        if(fileName.toLowerCase().endsWith("xlsx")||fileName.toLowerCase().endsWith("xlsm")){
            workbook = new XSSFWorkbook(input);
        }else if(fileName.toLowerCase().endsWith("xls")){
            workbook = new HSSFWorkbook(input);
        }
        else throw new Exception("invalid file name, should be excel file");
        
        //create sheet
        Sheet sheet = workbook.getSheetAt(SheetAt);
        Iterator<RMA_report> IterQuote = ListRMA.iterator();
         
        while(IterQuote.hasNext()){
            RMA_report quote = IterQuote.next();
            Row row = sheet.createRow(rowIndex++);             
               writeCell(quote,row);
        }   
        HSSFFormulaEvaluator.evaluateAllFormulaCells(workbook);
        
        FileOutputStream outputstream = new FileOutputStream(fileName);
        workbook.write(outputstream);
    }
    private void writeCell(RMA_report quoObj,Row row){       
        
        Cell cell = row.createCell(0);
        cell.setCellValue(quoObj.getSerial());
        
        cell = row.createCell(1);
        cell.setCellValue(quoObj.getRMA());
        
        cell = row.createCell(2);
        cell.setCellValue(quoObj.getInWarranty());
        
        cell = row.createCell(3);
        cell.setCellValue(quoObj.getStatus());
        
        cell = row.createCell(4);
        cell.setCellValue(quoObj.getModel());
        
        cell = row.createCell(5);
        cell.setCellValue(quoObj.getCustomerProblem());
        
        cell = row.createCell(6);
        String cusIssue= quoObj.getCustomerFoundissue();
        //if(cusIssue==null){
            //cell.setCellValue("other");
        //}else {
            cell.setCellValue(cusIssue);
        //}
        
        
        cell = row.createCell(7);
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date dateformat;
            String date = String.valueOf(quoObj.getReceivedDate());
                        dateformat = format.parse(date);
                        SimpleDateFormat print = new SimpleDateFormat("MM/dd/yyyy");                       
                        cell.setCellValue(print.format(dateformat));  
                    } catch (ParseException ex) {
                        Logger.getLogger(ReadExcelFileToList.class.getName()).log(Level.SEVERE, null, ex);
                    }
        
        
        cell = row.createCell(8);
        cell.setCellValue(quoObj.getShippingDate());
        
        cell = row.createCell(9);
        cell.setCellValue(quoObj.getCompany());
        
        cell = row.createCell(10);
        cell.setCellValue(quoObj.getCustomer());
        
        cell = row.createCell(11);
        cell.setCellValue(quoObj.getSupplyer());
        
        cell = row.createCell(12);
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date dateformat = null;
            String date = String.valueOf(quoObj.getReturnDate());
                        if(date!=null)
                        dateformat = format.parse(date);
                        SimpleDateFormat print = new SimpleDateFormat("MM/dd/yyyy");                       
                        cell.setCellValue(print.format(dateformat));  
                    } catch (ParseException ex) {
                        Logger.getLogger(ReadExcelFileToList.class.getName()).log(Level.SEVERE, null, ex);
                    }
        
        
        cell = row.createCell(13);
        cell.setCellValue(quoObj.getRepairNote());
        
        cell = row.createCell(14);
        cell.setCellValue(quoObj.getRootCause());
        
        cell = row.createCell(15);
        cell.setCellValue(quoObj.getRouteType());
        
        cell = row.createCell(16);
        cell.setCellValue(quoObj.getSymptom());
        
        cell = row.createCell(17);
        cell.setCellValue(quoObj.getProblem());
        
        cell = row.createCell(18);
        cell.setCellValue(quoObj.getDistribution());
        
        cell = row.createCell(19);
        cell.setCellValue(quoObj.getCategory());
        
        cell = row.createCell(20);
        cell.setCellValue(quoObj.getRepairDate());
        
        cell = row.createCell(21);
        cell.setCellValue(quoObj.getPartSN());
        
        cell = row.createCell(22);
        cell.setCellValue(quoObj.getTAT());
        
        cell = row.createCell(23);
        cell.setCellValue(quoObj.getRepairer());
        
        cell = row.createCell(24);
        cell.setCellValue(quoObj.getCusRMANo());
        
        cell = row.createCell(25);
        cell.setCellValue(quoObj.getBU());
        
        cell = row.createCell(26);
        cell.setCellValue(quoObj.getMore());
        
        cell = row.createCell(27);
        cell.setCellValue(quoObj.getRequestDate());
    }
}
