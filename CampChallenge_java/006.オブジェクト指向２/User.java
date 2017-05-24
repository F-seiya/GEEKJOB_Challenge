/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.servlet;

import java.util.*;


/**
 *
 * @author seiya
 */
public class User extends Human {
    
   
    
    //引いたカードをUserの手札に追加  
    @Override
    public void setCard(ArrayList<Integer> array){
        for(Integer u : array){
            myCards.add(u);
        }
     }

    @Override
   public boolean checkSum(){
       int total2 = open();
       if(total2 < 19){
           return true;
       }else{
           return false;
       }
    }
    //引いたカードの合計値を出す。
     @Override
    public int open(){
        int total2 = 0;
        for(int value : myCards){
            total2 += value;
        }
        return total2;
    }
    ArrayList<Integer> myCards = new<Integer> ArrayList();
    
}
