/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jums;

import base.DBManager;
import java.sql.*;

/**
 * DB接続は、 DBManager.javaで行う。 
 * DB処理(user_t)
 * ユーザー情報
 * @author seiya
 */
//インスタントオブジェクトを変換させてコードの簡略化
public class UserDataDAO {
    public static UserDataDAO getInstance(){
        return new UserDataDAO();
    }
    
    /**
     * ユーザーデータ挿入処理(新規登録)
     */
    public void insert(UserDataDTO udt) throws SQLException{
        
        Connection con = null;
        PreparedStatement st = null;
        
        try{
            //DB接続
            con = DBManager.getConnection();
            //SQL文の実行
            st = con.prepareStatement("INSERT INTO user_t(name, password, mail, address, total, newDate)VALUES(?,?,?,?,?,?)");
        
            st.setString(1, udt.getName());
            st.setString(2,udt.getPassword());
            st.setString(3, udt.getMail());
            st.setString(4, udt.getAddress());
            st.setInt(5, udt.getTotal());
            st.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
            
            st.executeUpdate();
            
            st.close();
        
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
               con.close();
            }
        }
    }
    
    /**
     * ユーザーデータ検索処理(ログイン時)
    */
    public UserDataDTO loginsearch(UserDataDTO uds) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        
        
        try{
            // DB接続
            con = DBManager.getConnection();
            
            //SQL文の実行
            st = con.prepareStatement("SELECT * FROM user_t WHERE name = ? AND password = ?");
            
            st.setString(1, uds.getName());
            st.setString(2, uds.getPassword());
            
            //DB内のデータを引っ張る。
            ResultSet rs = st.executeQuery();
            
            UserDataDTO searchUd = new UserDataDTO();
            
            while(rs.next()){
                searchUd.setUserID(rs.getInt("userID"));
                searchUd.setName(rs.getString("name"));
                searchUd.setPassword(rs.getString("password"));
                searchUd.setMail(rs.getString("mail"));
                searchUd.setAddress(rs.getString("address"));
                searchUd.setDeleteFlg(rs.getInt("deleteFlg"));
                
                if(rs.getInt("total")== 0){
                    searchUd.setTotal(0);
                }else{
                    searchUd.setTotal(rs.getInt("total"));
                }
                
                if(rs.getInt("deleteFlg")==0){
                    System.out.println("カラム情報取得");
                    return searchUd;
                }
                 
            }    
               return null;  
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
               con.close();
            }
        }
    }
    
    /**
     * ユーザーデータ更新処理
    */
    public void update(UserDataDTO ud)throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        
        try{
            con = DBManager.getConnection();
            
            st = con.prepareStatement("UPDATE user_t SET name=?, password=?, mail=?, address=?, newDate=? WHERE userID=?");
        
            st.setString(1, ud.getName());
            st.setString(2, ud.getPassword());
            st.setString(3, ud.getMail());
            st.setString(4, ud.getAddress());
            st.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
            st.setInt(6, ud.getUserID());
            
            st.executeUpdate();
            System.out.println("Update Completed");
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }
    }
    
    /**
     * ユーザーデータ削除(deleteFlgを"0"から"1"にする)処理
     */
    public void updateFlg(UserDataDTO ud)throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        
       try{
           
            con = DBManager.getConnection();
            st= con.prepareStatement("UPDATE user_t SET deleteFlg =? WHERE userID =?");
        
            st.setInt(1, 1);
            st.setInt(2, ud.getUserID());
        
            st.executeUpdate();
            System.out.println("deleteFlg Update");
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }    
    }
    
    /**
     * ユーザーデータ更新(総購入金額)
     */
    public void updateTotal(int total, int userID) throws SQLException {
        
        Connection con = null;
        PreparedStatement st = null;
    
        try{
            con = DBManager.getConnection();
            st = con.prepareStatement("UPDATE user_t SET total=? WHERE userID=?");
            
            st.setInt(1, total);
            st.setInt(2, userID);
            
            st.executeUpdate();
            System.out.println("Total Update");
        
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }    
    
    }
}
