/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMAreport;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Thai
 */
public class ProcessKeywords  {
    public static void main(String[] args) throws IOException {
    ReadExcelKeywordToList readKeyWord = new ReadExcelKeywordToList();
    List<keyword> list;
    String path = "C:/Users/Thai/Desktop/keywords.xlsx";
    list = readKeyWord.readExcelData(path);
    for (int i = 0;i<list.size();i++)
            System.out.println(list.get(i).getCustomerfoundissue());
    
    }  
}
