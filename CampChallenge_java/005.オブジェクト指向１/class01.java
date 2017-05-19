/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.PrintWriter;

/**
 *
 * @author seiya
 */
public class class01 {
    
    class Human{
        
        public String name ="";
        
        public int age = 0;
        
        public void setHuman(String n,int a){
            this.name = n;
            this.age = a;
        }
      
        public void sample(PrintWriter pw){
            pw.print(name);
            pw.print(age);
        }
        }
   
    }
    


  