/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jums;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Map;
import javax.xml.parsers.ParserConfigurationException;
import jdk.internal.org.xml.sax.SAXException;
import net.arnx.jsonic.JSON;


/**
 * YahooAPIに関する処理をまとめたjavaクラス
 * @author seiya
 */
public class YahooAPI {
    
  /**
   * "top.jsp"から値を受け取り、API(json形式)の情報を返す
   * @param word
   */
  public static ArrayList<ItemBeans> connectSearch (String word) throws SAXException, ParserConfigurationException, IOException  {
    
    //アプリケーションID
    String appid = "dj00aiZpPWx6WmxWTjZPZm52dyZzPWNvbnN1bWVyc2VjcmV0Jng9Yzg-";
    
    //商品検索のURL ”appid”は　アプリケーションID, "query"は検索クエリの必須パラメーター
    String uri ="https://shopping.yahooapis.jp/ShoppingWebService/V1/json/itemSearch?appid="+ appid +"&query="+ word;
    
      
        URL url = new URL(uri);
        //URL接続
        HttpURLConnection ucon = (HttpURLConnection)url.openConnection();
        ucon.connect();
          
        InputStream is = ucon.getInputStream();
        //ファイル読み込み
        InputStreamReader isr = new InputStreamReader(is);
          
        //ファイル効率よく読み込み "BufferedReader"
        BufferedReader br  = new BufferedReader(isr);
        //処理を実行している文字列バッファとだけ同期化するクラス
        StringBuffer sb = new StringBuffer();
          
        while(true){
           //一行読み出し
           String line = br.readLine();
              
           if(line ==null){
              break;
           }
           //文字列を追加
           sb.append(line);
        }
           
        br.close();
        
        //取得したjsonテキストを文字列に変換
        String jsontext = sb.toString();
        return parse(jsontext);
  }
  
  /**
   * 必要な情報パラメーターを取得する
   */
  
  private static ArrayList<ItemBeans>parse(String jtext){
      //必要なデータを取り出す為、デコードする。
      Map<String, Map<String, Object>>json = JSON.decode(jtext);
      
      //検索ヒット数が0の時
      if (json.get("ResultSet").get("totalResultsReturned").equals("0")) {
            return null;
      }
      
      //１つ1つのの商品データを格納するためのrrayList
      ArrayList<ItemBeans> itemarray = new ArrayList<ItemBeans>();
      
      
      //検索表示20件表示のため
      for(int i = 0; i<20; i++){
          ItemBeans item = new ItemBeans();
          //必要なデータを分けて取り出す為の処理( " で囲まれた値は、APIの key または value)
          Map<String, Object> result = ((Map<String, Object>) ((Map<String, Map<String, Object>>) json.get("ResultSet").get("0")).get("Result").get(String.valueOf(i)));
          //各パラメータを取得し、各要素に格納
          item.setName(result.get("Name").toString());
          item.setDescription(result.get("Description").toString());
          item.setCode(result.get("Code").toString());
          item.setImage(((Map<String, Object>)result.get("Image")).get("Medium").toString());
          item.setPrice(((Map<String, Object>)result.get("Price")).get("_value").toString());
          item.setReviewAverage(((Map<String, Object>)result.get("Review")).get("Rate").toString());          
          
          //各要素をまとめた(一つの商品データ)をArrayListに追加
          itemarray.add(item);
      } 
      
        ItemBeans tra = new ItemBeans();
        //検索結果数の取得
        tra.setTotalResultsAvailable((String) json.get("ResultSet").get("totalResultsAvailable"));
      
        itemarray.add(tra);
     
      return itemarray;
  }
  
  /**
   * "cart.jsp"から商品コードを受け取り、API(json形式)の情報を返す
   * "MyHistory"(購入履歴閲覧)にて商品コードを受け取り、商品情報を取得
   */
  public static ItemBeans connectItemDescription(String itemcode)throws SAXException, ParserConfigurationException, IOException {
      
    //アプリケーションID
    String appid = "dj00aiZpPWx6WmxWTjZPZm52dyZzPWNvbnN1bWVyc2VjcmV0Jng9Yzg-";
    
    //商品コード検索(商品詳細)URL ”appid”はアプリケーションID, "itemcode"は商品検索クエリの必須パラメーター
    String uri ="https://shopping.yahooapis.jp/ShoppingWebService/V1/json/itemLookup?appid="+ appid +"&itemcode="+ itemcode
            +"&responsegroup=medium";
    //"responsegroup" を "medium"に指定しないと商品詳細情報が取得できない為。
    
   
    
      URL url = new URL(uri);
      //URL接続
      HttpURLConnection ucon = (HttpURLConnection) url.openConnection();
      ucon.connect();

      InputStream is = ucon.getInputStream();
      //ファイル読み込み
      InputStreamReader isr = new InputStreamReader(is);

      //ファイル効率よく読み込み "BufferedReader"
      BufferedReader br = new BufferedReader(isr);
      //処理を実行している文字列バッファとだけ同期化するクラス
      StringBuffer sb = new StringBuffer();

      while (true) {
          //一行読み出し
          String line = br.readLine();

          if (line == null) {
              break;
          }
          //文字列を追加
          sb.append(line);
      }

      br.close();

      //取得したjsonテキストを文字列に変換
      String jsontext = sb.toString();
      return itemparse(jsontext);
  }
  
  /**
   * 必要なパラメーターを取得
   */
  private static ItemBeans itemparse(String jtext){
    //必要なデータを取り出す為、デコードする。
    Map<String, Map<String, Object>> json = JSON.decode(jtext);
      
    ItemBeans cartib = new ItemBeans();
    //必要なデータを分けて取り出す為の処理
    Map<String, Object> c_item =((Map<String, Object>)((Map<String, Map<String, Object>>)json.get("ResultSet").get("0")).get("Result").get("0"));
    
    cartib.setName(c_item.get("Name").toString());
    cartib.setDescription(c_item.get("Description").toString());
    cartib.setImage(((Map<String,Object>)c_item.get("Image")).get("Medium").toString());
    cartib.setPrice(((Map<String,Object>)c_item.get("Price")).get("_value").toString());
    cartib.setReviewAverage(((Map<String,Object>)c_item.get("Review")).get("Rate").toString());
    
    return cartib;  
  } 
 
  
}
