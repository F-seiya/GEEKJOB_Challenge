/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jums;

import base.DBManager;
import java.sql.*;
import java.util.ArrayList;

/**
 * DB接続は、DBManager.javaで行う
 * DB処理(buy_t)
 * 購入情報
 * @author seiya
 */
public class BuyDataDAO {
    public static BuyDataDAO getInstance(){
            return new BuyDataDAO();
    }
    
    /**
     * 購入処理(insert)
     */
    public void buyinsert(BuyDataDTO bdd) throws SQLException {
        
        Connection con = null;
        PreparedStatement st = null;
        
        try{
            
            con = DBManager.getConnection();
            st = con.prepareStatement("INSERT INTO buy_t(userID, itemCode, type, buyDate)VALUES(?,?,?,?)");
            
            st.setInt(1, bdd.getUserID());
            st.setString(2, bdd.getItemCode());
            st.setInt(3, bdd.getType());
            st.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
            
            st.executeUpdate();
            
            st.close();
            
            System.out.println("購入データ 入力");
            
        }catch(SQLException se){
            System.out.println(se.getMessage());
            throw new SQLException(se);
        }finally{
            if(con!= null){
               con.close();
            }
        }
    }
    
    /**
     * 購入履歴閲覧(select)
    */
    public ArrayList<ItemBeans> select(int userID) throws SQLException{
        
        Connection con = null;
        PreparedStatement st = null;
        
        try{
            
            con = DBManager.getConnection();
            st = con.prepareStatement("SELECT * FROM buy_t WHERE userID=?");
            
            st.setInt(1, userID);
            
            ResultSet rs = st.executeQuery();
            
            ArrayList<ItemBeans> boughtArray = new ArrayList<ItemBeans>();
            
                while (rs.next()) {
                    ItemBeans ib = new ItemBeans();
                    ib.setCode(rs.getString("itemCode"));
                    ib.setDeliveryType(rs.getInt("type"));
                    ib.setBuyDate(rs.getDate("buyDate"));

                    //購入履歴のデータをArrayListに追加
                    boughtArray.add(ib);
                }
                System.out.println("購入履歴 取得");
                return boughtArray;
         
        }catch(SQLException se){
            System.out.println(se.getMessage());
            throw new SQLException(se);
        }finally{
            if(con!= null){
               con.close();
            }
        }
    
    }
    
}
