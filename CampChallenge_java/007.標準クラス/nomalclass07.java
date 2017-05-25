/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.servlet;

/**
 *
 * @author seiya
 */
public class nomalclass07 {
    
    public static void main(String[] args){
    
        String word = "きょUはぴIえIちぴIのくみこみかんすUのがくしゅUをしてIます";
        
            word = word.replace("U", "う");
        
            word = word.replace("I", "い");
            
            System.out.print(word);
            
          
    }
    
}
