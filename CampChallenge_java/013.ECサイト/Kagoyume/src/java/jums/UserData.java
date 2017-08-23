/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jums;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *  フォームから入出力されるデータを格納するBeans
 * @author seiya
 */
public class UserData implements Serializable{
    
    private String name;
    private String password;
    private String mail;
    private String address;
    private int total;
    
    public UserData(){
        this.name="";
        this.password="";
        this.mail="";
        this.address="";
        
    }
    
    /**
     * 未入力の場合、空文字をセット(total以外)
     */
    
    public String getName(){
        return name;
    }
    public void setName(String name){
        if(name.trim().length()==0){
            this.name ="";
        }else{
            this.name = name;
        }
    }
    
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        if(password.trim().length()==0){
            this.password ="";
        }else{
            this.password = password;
        }
    }
    
    public String getMail(){
        return mail;
    }
    public void setMail(String mail){
        if(mail.trim().length()==0){
            this.mail="";
        }else{
            this.mail = mail;
        }
    }
    
    public String getAddress(){
        return address;
    }
    public void setAddress(String address){
        if(address.trim().length()==0){
            this.address="";
        }else{
            this.address = address;
        }
    }
    
    //未入力の場合、ArrayListに追加
    public ArrayList<String> chkbeans(){
        ArrayList<String> chkarray = new ArrayList<String>();
        if(this.name.equals("")){
            chkarray.add("name");
        }
        if(this.password.equals("")){
            chkarray.add("password");
        }
        if(this.mail.equals("")){
            chkarray.add("mail");
        }
        if(this.address.equals("")){
            chkarray.add("address");
        }
        return chkarray;
    }
    
    
    //新規登録入力フォームの値をUserDataDTOにマッピングするメソッド
    public void UD2DTOMapping(UserDataDTO udd){
        udd.setName(this.name);
        udd.setPassword(this.password);
        udd.setMail(this.mail);
        udd.setAddress(this.address);
    }
}
