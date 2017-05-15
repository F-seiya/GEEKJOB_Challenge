/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.servlet;

import java.io.Serializable;
import java.util.Date;
import java.util.Random;
import javax.servlet.RequestDispatcher;
import org.camp.servlet.ResultData;
/**
 *
 * @author seiya
 */
public class ResultData implements Serializable{
     
     public ResultData(){};
     
     private Date d;
     private String luck;
     
     public Date getD() {
         return d;
     }
     
     public void setD(Date d) {
         this.d = d;
     }
     
     public String getLuck(){
         return luck;
     }
     
     public void setLuck(String luck){
         this.luck = luck;
     }

 }