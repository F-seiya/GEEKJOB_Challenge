/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.servlet;

import java.util.Collections;
import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;

/**
 *
 * @author seiya
 */
public class nomalclass10 {
    
//配列をシャッフルするCollectionsを使用
   
  public static void main(String[] args) throws Exception{
        
      File fl = new File("sample.txt");
      
      FileWriter fw = new FileWriter(fl);
     
      Date D = new Date();
      SimpleDateFormat sdf =
            new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

        fw.write(sdf.format(D) + "処理を開始します。/");  
      
     ArrayList<String> word = new ArrayList<String>();
        
         word.add("a"); 
         word.add("b");
         word.add("c");
         word.add("d");
        
        Collections.shuffle(word);
        
        for(String s : word){
        
            fw.write(s + "/");
        
        }
       fw.write(sdf.format(D) + "処理を終了します。/");
       
       
     FileReader fr = new FileReader(fl);
     
     BufferedReader br = new BufferedReader(fr);
     
     int sr = fr.read(); 
     
     while(sr != -1){
     
      char c = (char) sr;  
      
      System.out.print(c);
      
      sr = fr.read();
     }
     fw.close();
     br.close();
        
    }
    
 }



   


