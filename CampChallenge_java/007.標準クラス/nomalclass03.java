/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.servlet;
import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;
/**
 *
 * @author seiya
 */
public class nomalclass03 {
    
    public static void main (String[] args){
        
        Calendar c = Calendar.getInstance();
            c.set(2016, 10, 4, 10, 0, 0);
            //TimeStamp作成
            Date d = c.getTime();
        //SimpleDateFormatクラス作成
        SimpleDateFormat s =  new SimpleDateFormat("yyyy/MM/dd/HH/mm/ss");
                          //Date型を文字列に変換
         System.out.print(s.format(d));
         
    
    } 
}
