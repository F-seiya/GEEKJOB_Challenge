/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jums;

import java.io.Serializable;
import java.util.Date;

/**
 *  商品情報クラス
 * @author seiya
 */
public class ItemBeans implements Serializable{
    
    private String name;          
    private String description;   
    private String code;          
    private String image;         
    private String price;         
    private String reviewAverage; 
    private int deliveryType; 
    
    private int userID;
    private Date buyDate;
    
    private String totalResultsAvailable;
    
    public String getName(){
        return this.name;
    }
    public void setName(String name){
       this.name = name;
    }
    
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    
    public String getCode(){
        return this.code;
    }
    public void setCode(String code){
        this.code = code;
    }
    
    public String getImage(){
        return this.image;
    }
    public void setImage(String image){
        this.image = image;
    }
    
    public String getPrice(){
        return this.price;
    }
    public void setPrice(String price){
        this.price = price;
    }
    
    public String getReviewAverage(){
        return this.reviewAverage;
    }
    public void setReviewAverage(String reviewAverage){
        this.reviewAverage = reviewAverage;
    }
    
    public int getDeliveryType(){
        return this.deliveryType;
    }
    public void setDeliveryType(int deliveryType){
        this.deliveryType = deliveryType;    
    }
    
    public int getUserID(){
        return this.userID;
    }
    public void setUserID(int userID){
        this.userID = userID;
    }
    
     public void setBuyDate(Date buyDate) {
        this.buyDate = buyDate;
    }
    public Date getBuyDate() {
        return this.buyDate;
    }
    
 
    public String getTotalResultsAvailable(){
        return this.totalResultsAvailable;
    }
    public void setTotalResultsAvailable(String totalResultsAvailable){
        this.totalResultsAvailable = totalResultsAvailable;
    }
    
//  フォームの値とユーザー情報をBuyDataDTOにマッピングするメソッド
    public void  BD2DTOMapping (BuyDataDTO bdd, int userID){
        bdd.setUserID(userID);
        bdd.setItemCode(code);
        bdd.setType(deliveryType);   
    }
    
    
}


