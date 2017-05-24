/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.servlet;
import java.util.Calendar;
import java.util.Date;
/**
 *
 * @author seiya
 */
public class nomalclass04 {
    
    public static void main(String[] args){
        Calendar c1 = Calendar.getInstance();
            c1.set(2015, 0, 1, 0, 0, 0);
        
        Calendar c2 = Calendar.getInstance();
            c2.set(2015, 11, 31, 23, 59, 59);
            
            Date d1 = c1.getTime();
               
            Date d2 = c2.getTime();
                
       long miri = (c2.getTimeInMillis() - c1.getTimeInMillis());
        
            System.out.print(miri);
    
    }
}



//2015年1月1日 0時0分0秒と2015年12月31日 23時59分59秒の差（ミリ秒）を表示してください。