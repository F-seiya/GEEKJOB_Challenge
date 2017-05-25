/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.servlet;
import java.io.*;

/**
 *
 * @author seiya
 */
public class nomalclass09 {
    
    public static void main(String[] args) throws Exception{
    
        //ファイルオープン
        File fp = new File("test.txt");
        //ファイルから読み出し
        FileReader fr = new FileReader(fp);
        //読み出す為にBufferReader作成 
        BufferedReader br = new BufferedReader(fr);
        //一行読み出し
        System.out.print(br.readLine());
        
        br.close();
    }
}
