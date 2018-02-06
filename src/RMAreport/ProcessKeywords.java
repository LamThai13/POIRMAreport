/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMAreport;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

/**
 *
 * @author Thai
 */
public class ProcessKeywords  {
    public static void main(String[] args) throws IOException {
    ReadExcelFileToList readFile = new ReadExcelFileToList();
    ReadExcelKeywordToList readKeyWord = new ReadExcelKeywordToList();
    List<keyword> list;
    String path = "C:/Users/Thai/Desktop/keywords.xlsx";
    list = readKeyWord.readExcelData(path);
    
    List<RMA_report> listR;
    String path1 = "C:/Users/Thai/Desktop/Grand.xlsm";
   
    
    listR = readFile.readExcelData(path1);
    for (int i=0; i<listR.size();i++){
        String cusProb = listR.get(i).getCustomerProblem();
        
        for (int j=0; j<list.size();j++){
            String keyword = list.get(j).getCustomerfoundissue();           
            if(cusProb.toLowerCase().contains(keyword.toLowerCase())){
            listR.get(i).setCustomerFoundissue(keyword);
            }
            continue;        
    }
    
    }
        for (int i=0; i<listR.size();i++){
        String root = listR.get(i).getRepairNote();
        
        for (int j=0; j<list.size()-6;j++){
            String rootC = list.get(j).getRootcause();           
            if(root.toLowerCase().contains(rootC.toLowerCase())){
            listR.get(i).setRootCause(rootC);
            }
                   
    }
    
    }
        
         FileInputStream input = new FileInputStream(new File("C:/Users/Thai/Desktop/RMA Report test.xls"));
            
            writeRMAtoFile writer = new writeRMAtoFile();
        try {
            writer.writeRMAtoFile(input,"C:/Users/Thai/Desktop/RMA Report test1.xls", listR, 1, 1);
        } catch (Exception ex) {
            Logger.getLogger(ProcessKeywords.class.getName()).log(Level.SEVERE, null, ex);
        }
    /*for (int i=0;i<listR.size();i++)
        System.out.println(listR.get(i).getRootCause());
     */
    }  
}
