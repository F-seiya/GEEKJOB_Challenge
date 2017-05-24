/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.servlet;

import java.util.*;
import java.util.Collections;


/**
 *
 * @author seiya
 */
public class Dealer extends Human {

    
    public ArrayList<Integer> cards = new ArrayList<Integer>();
    
    Dealer(){    
      for(int i = 0;  i<4; i++ ){
        
        for(int j= 1; j<14; j++){
           
          if(j>10){
                cards.add(10);
            }else{
                cards.add(j);
            }
        }
      }
      Collections.shuffle(cards);
    }
    

    public ArrayList<Integer> deal(){
      ArrayList<Integer> result =new ArrayList<Integer>();
      //カードを引いて、山札から引いたカードの要素を取り除く。
     for(int k = 0; k<2; k++){ 
      int card1 =cards.get(0);
      result.add(card1);
      cards.remove(0);
     }
    return result;
     
    }
    //追加でカードを引く
    public ArrayList<Integer> hit(){
        ArrayList<Integer> result2 = new ArrayList<Integer>();
            int card3 = cards.get(0);
            result2.add(card3);
            cards.remove(0);
            return result2;
    }
    
    
       
    @Override
    public void setCard(ArrayList<Integer> array){
       //引いたカードをDealerの手札に追加
        for(Integer d : array){
            myCards.add(d);
        } 
      
    
    }
   
    @Override
   public boolean checkSum(){
       int total = open();       
       
       if(total < 17){
       return true;
       }else{
       return false;
       }
   }
    //引いたカードの合計値を出す。
    @Override
    public int open(){
        int total = 0;
        for(int value : myCards ){
            total += value;
        }
        return total;
    }
    


    
     
}
