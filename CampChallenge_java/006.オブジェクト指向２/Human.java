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
public abstract class Human {
    
     abstract public int open();
       
     abstract public void setCard(ArrayList<Integer> array);
   
     abstract public boolean checkSum();
      
     ArrayList<Integer> myCards = new ArrayList<Integer> ();
   
}


