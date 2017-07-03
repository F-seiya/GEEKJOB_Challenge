package jums;

import base.DBManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * ユーザー情報を格納するテーブルに対しての操作処理を包括する
 * DB接続系はDBManagerクラスに一任
 * 基本的にはやりたい1種類の動作に対して1メソッド
 * @author hayashi-s
 */
public class UserDataDAO {
    
    //インスタンスオブジェクトを返却させてコードの簡略化
    public static UserDataDAO getInstance(){
        return new UserDataDAO();
    }
    
    /**
     * データの挿入処理を行う。現在時刻は挿入直前に生成
     * @param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー 
     */
    public void insert(UserDataDTO ud) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            st =  con.prepareStatement("INSERT INTO user_t(name,birthday,tell,type,comment,newDate) VALUES(?,?,?,?,?,?)");
            st.setString(1, ud.getName());
            st.setDate(2, new java.sql.Date(ud.getBirthday().getTime()));//指定のタイムスタンプ値からSQL格納用のDATE型に変更
            st.setString(3, ud.getTell());
            st.setInt(4, ud.getType());
            st.setString(5, ud.getComment());
            st.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
            st.executeUpdate();
            System.out.println("insert completed");
            
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
     * データの検索処理を行う。
     * @param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー 
     * @return 検索結果
     */
    
    public ArrayList<UserDataDTO> search(UserDataDTO ud) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            
            //
            String sql = "SELECT * FROM user_t";
            boolean flag = false;
            if (!ud.getName().equals("")) {
                sql += " WHERE name like ?";
                flag = true;
            }
            if (ud.getBirthday()!=null) {
                if(!flag){
                    sql += " WHERE birthday like ?";
                    flag = true;
                }else{
                    sql += " AND birthday like ?";
                }
            }
            if (ud.getType()!=0) {
                if(!flag){
                    sql += " WHERE type like ?";
                }else{
                    sql += " AND type like ?";
                }
            }
            
            st =  con.prepareStatement(sql);
//          search.jspで入力した項目の数に応じて条件分岐(綺麗なコードが思いつかないので保留)
            
        //入力した値が一つ
            if(!ud.getName().equals("") && ud.getBirthday() ==null && ud.getType()==0){
                st.setString(1, "%"+ud.getName()+"%");
                
            }else if(ud.getName().equals("") && ud.getBirthday() !=null && ud.getType()==0){
                st.setString(1, "%"+ new SimpleDateFormat("yyyy").format(ud.getBirthday())+"%");
                
            }else if(ud.getName().equals("") && ud.getBirthday() ==null && ud.getType()!=0){
                st.setInt(1, ud.getType());
                
        //入力した値が二つ
            }else if(!ud.getName().equals("") && ud.getBirthday() !=null && ud.getType()==0){
                st.setString(1, "%"+ud.getName()+"%");
                st.setString(2, "%"+ new SimpleDateFormat("yyyy").format(ud.getBirthday())+"%");
                
            }else if(!ud.getName().equals("") && ud.getBirthday() ==null && ud.getType()!=0){
                st.setString(1, "%"+ud.getName()+"%");
                st.setInt(2, ud.getType());
                
            }else if(ud.getName().equals("") && ud.getBirthday() != null && ud.getType()!=0){
                st.setString(1, "%"+ new SimpleDateFormat("yyyy").format(ud.getBirthday())+"%");
                st.setInt(2, ud.getType());
                
        //入力した値が三つ
            }else if(!ud.getName().equals("") && ud.getBirthday() != null && ud.getType()!=0){
                st.setString(1, "%"+ud.getName()+"%");
                st.setString(2, "%"+ new SimpleDateFormat("yyyy").format(ud.getBirthday())+"%");
                st.setInt(3, ud.getType());
            }

            
            
            ResultSet rs = st.executeQuery();
            

//           複数の検索データを格納・表示する為にArryListを作成(全件表示する為)
            ArrayList<UserDataDTO> udata = new ArrayList<UserDataDTO>();
               
                while(rs.next()){
                UserDataDTO resultUd = new UserDataDTO();
                resultUd.setUserID(rs.getInt(1));
                resultUd.setName(rs.getString(2));
                resultUd.setBirthday(rs.getDate(3));
                resultUd.setTell(rs.getString(4));
                resultUd.setType(rs.getInt(5));
                resultUd.setComment(rs.getString(6));
                resultUd.setNewDate(rs.getTimestamp(7));
                //一人のユーザーのデータをまとめてArrayListに追加
                udata.add(resultUd);
                }
                
            System.out.println("search completed");
            return udata;


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
     * ユーザーIDによる1件のデータの検索処理を行う。
     * @param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー 
     * @return 検索結果
     */
    public UserDataDTO searchByID(UserDataDTO ud) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            
            String sql = "SELECT * FROM user_t WHERE userID = ?";
            
            st =  con.prepareStatement(sql);
            st.setInt(1, ud.getUserID());
            
            ResultSet rs = st.executeQuery();
            
            UserDataDTO resultUd = new UserDataDTO();
            
            rs.next();
                resultUd.setUserID(rs.getInt(1));
                resultUd.setName(rs.getString(2));
                resultUd.setBirthday(rs.getDate(3));
                resultUd.setTell(rs.getString(4));
                resultUd.setType(rs.getInt(5));
                resultUd.setComment(rs.getString(6));
                resultUd.setNewDate(rs.getTimestamp(7));
                
            System.out.println("searchByID completed");

            return resultUd;
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
     * ユーザーのデータの更新処理を行う
     */
     public void update(UserDataDTO ud) throws SQLException{
         Connection con = null;
         PreparedStatement st =null; 
         
         try{
             con = DBManager.getConnection();
             
             st = con.prepareStatement("UPDATE user_t SET name=?, birthday=?, tell=?, type=?, comment=?, newDate=? WHERE userID = ?" );
             
             st.setString(1, ud.getName());
             st.setDate(2, new java.sql.Date(ud.getBirthday().getTime()));
             st.setString(3, ud.getTell());
             st.setInt(4, ud.getType());
             st.setString(5, ud.getComment());
             st.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
             st.setInt(7, ud.getUserID());

             st.executeUpdate();
             System.out.println("update completed");

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
     * ユーザーのデータの削除処理を行う
     */
     public void delete(UserDataDTO ud) throws SQLException{
         Connection con = null;
         PreparedStatement st = null;
         
         try{
             con = DBManager.getConnection();
            
             st = con.prepareStatement("DELETE FROM user_t WHERE userID = ? ");
             
             st.setInt(1, ud.getUserID());
             
             st.executeUpdate();
             System.out.println("delete completed");
         
         
         } catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
         }finally{
            if(con != null){
                con.close();
            }
         }
         
         
     
     
     }
}
