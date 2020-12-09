/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.util;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.activation.DataSource;
import javax.naming.NamingException;

/**
 *
 * @author azmeerazehar
 */
public class DBUtil {
    private static DataSource dataSource = null;
    
    public static Connection getConnection() throws NamingException,SQLException {
         Connection con = null;
         try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/voucher", "root", "");
        } catch (Exception ex) {
             System.out.println(ex.getMessage());
        }
        return con;
     }
    
    public static void getResultSet(String queryParam, ResultSet rs) throws java.
      sql.
      SQLException, Exception {

    try {

      System.out.println(queryParam);
      Connection conn = DBUtil.getConnection();
      Statement st = (Statement) conn.createStatement();
      //rs = st.executeQuery(queryParam);
    } catch (SQLException e) {
      e.printStackTrace();
      throw e;
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    }

  }
    
    public static void close(Connection con) {
    try {
      if (!con.getAutoCommit()){
        con.setAutoCommit(true);
      }
      //System.out.println("----- Close Connection (close(Connection con))-----");
      if (con!=null){
        con.close();
        //printPoolStatus();
      }
    } catch (Exception e) {
    }
  }

  public static void close(ResultSet rs) {
    try {
      if (rs!=null){
        rs.close();
      }
    } catch (Exception e) {
    }
  }
  
   public static void close(PreparedStatement ps) {
    try {
      if (ps!=null){
        ps.close();
      }
    } catch (Exception e) {
    }
  }

//  public static void close(Statement st) {
//    try {
//      if (st != null){
//        st.close();
//      }
//    } catch (Exception e) {
//    }
//  }

   public static String encode(String value) {
        if (value == null) {
            return "";
        }

        if(value.matches("\\\\")) {
            value = value.replaceAll("\\\\", "");
            return value;
        }

        StringBuffer encoded = new StringBuffer();
        char chars[] = value.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            switch (chars[i]) {
                case '\'':
                    encoded.append("&#39;"); //20120405: Replace encoded.append("''");
                    break;
                case '\r':
                    encoded.append(" ccc ");
                    break;
                case '\n':
                    encoded.append(" ddd ");
                    break;
                case '\\':
                    encoded.append("&#92;"); //20120403: Replace encoded.append("\\");
                    //20120403: Comment encoded.toString().replaceAll("\\", "");
                    break;
                default:
                    encoded.append(chars[i]);
                    break;
            }
        }
            return encoded.toString();
    }
   

     
}
