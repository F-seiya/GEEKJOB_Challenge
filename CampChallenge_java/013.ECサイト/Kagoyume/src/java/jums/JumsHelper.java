/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jums;

import java.util.ArrayList;

/**
 *
 * @author seiya
 */

public class JumsHelper {
    
    //トップへのリンクを定数として設定
    private final String topURL ="top.jsp";
       
    public static JumsHelper getInstance(){
        return new JumsHelper();
    }
    
    //トップへのリンクを返却
    public String top(){
        return "<a href=\""+topURL+"\">トップへ戻る</a>";
    }
    
    
    
     /**
    * 入力されたデータの内、未入力項目がある場合、どの項目が未入力なのかをhtml文に返却
    * @param chklist
    * @return 
    */
    public String check(ArrayList<String> chkList){
        String outcheck ="";
        
        for(String val : chkList){
            if(val.equals("name")){
                outcheck += "ユーザー名";
            }
            if(val.equals("password")){
                outcheck += "パスワード";
            }
            if(val.equals("mail")){
                outcheck += "メールアドレス";
            }
            if(val.equals("address")){
                outcheck += "住所";
            }
            outcheck += "が未記入です<br>";
        }
        
        return outcheck;
    }

    
}
