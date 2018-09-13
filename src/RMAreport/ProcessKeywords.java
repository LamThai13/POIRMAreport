/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMAreport;

import java.awt.FlowLayout;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Thai
 */
public class ProcessKeywords  {
    public static void main(String[] args) throws IOException {
    JFrame jframe = new JFrame("Please, choose the file generated from report 2");
    jframe.setLayout(new FlowLayout());
    jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JFileChooser filechooser = new JFileChooser();
    filechooser.setCurrentDirectory(new File(System.getProperty("user.home")));
    int result = filechooser.showOpenDialog(jframe);
        if(result == JFileChooser.APPROVE_OPTION){
            File selectedFile = filechooser.getSelectedFile();
    ReadExcelFileToList readFile = new ReadExcelFileToList();
    ReadExcelKeywordToList readKeyWord = new ReadExcelKeywordToList();
    List<keyword> list;
    String path = "C:/Users/Kevin/Desktop/book1.xlsx";
    list = readKeyWord.readExcelData(path);
    
    List<RMA_report> listR;
    String path1 = selectedFile.toString();
   
    
    listR = readFile.readExcelData(path1);
    for (int i=0; i<listR.size();i++){
        String cusProb = listR.get(i).getCustomerProblem();
        
        for (int j=0; j<list.size();j++){            
            String keyword = list.get(j).getKeyword();
            if(cusProb.toLowerCase().trim().contains(keyword.toLowerCase())){
            listR.get(i).setCustomerFoundissue(list.get(j).getGroupName());
            continue;
            }
            //System.out.println(list.get(j).getCustomerfoundissue()); 
        
    }
    
    }
     /*   for (int i=0; i<listR.size();i++){
        String root = listR.get(i).getRepairNote();
        
        for (int j=0; j<list.size()-9;j++){
            String rootC = list.get(j).getRootcause();           
            if(root.toLowerCase().contains(rootC.toLowerCase())){
            listR.get(i).setRootCause(rootC);
            }
                   
    }
    
    }*/
        
         FileInputStream input = new FileInputStream(new File("C:/Users/Kevin/Desktop/Forcepoint RMA report.xls"));
            
            writeRMAtoFile writer = new writeRMAtoFile();
        try {
            writer.writeRMAtoFile(input,"C:/Users/Kevin/Desktop/RMA Report test1.xls", listR, 1, 1);
        } catch (Exception ex) {
            Logger.getLogger(ProcessKeywords.class.getName()).log(Level.SEVERE, null, ex);
        }
    /*for (int i=0;i<listR.size();i++)
        System.out.println(listR.get(i).getRootCause());*/
     

    }
    }  
    }

