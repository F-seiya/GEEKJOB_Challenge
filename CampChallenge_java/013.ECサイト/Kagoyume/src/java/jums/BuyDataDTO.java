/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jums;

import java.sql.Timestamp;

/**
 * 購入情報のjavaBeans
 * データベースのカラムと型(buy_t)に対応
 * @author seiya
 */
public class BuyDataDTO {
    
   private int buyID;
   private int userID;
   private String itemCode;
   private int type;
   private Timestamp buyDate;
   
   public int getBuyID(){
       return buyID;
   }
   public void setBuyID(int buyID){
       this.buyID = buyID;
   }
   
   public int getUserID(){
       return userID;
   }
   public void setUserID(int userID){
       this.userID = userID;
   }
    
   public String getItemCode(){
       return itemCode;
   }
   public void setItemCode(String itemCode){
       this.itemCode = itemCode;
   }
   
   public int getType(){
       return type;
   }
   public void setType(int type){
       this.type = type;
   }
   
   public Timestamp getBuyDate(){
        return buyDate;
    }
    public void setBuyDate(Timestamp buyDate){
        this.buyDate = buyDate;
    }
   
}
