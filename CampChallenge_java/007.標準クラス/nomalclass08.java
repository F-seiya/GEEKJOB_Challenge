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
public class nomalclass08 {
  
    public static void main(String[] args) throws Exception  {
        
        //あらかじめ"test.txt"をFinderで作成し、NetBeans内に入れる。

        // ファイルオープン
        File fp = new File("test.txt");

        // FileWriter作成
        FileWriter fw = new FileWriter(fp);
        // 書き込み
        fw.write("藤川誠也" + "京都出身" );
        // クローズ
        fw.close();
    }

}
