/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.db;

import com.myapp.home.homeJB;
import com.myapp.util.CommonUtil;
import com.myapp.util.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author azmeerazehar
 */
public class voucherDB {
    
    public homeJB voucherDetails (homeJB jb,Connection conn){
        //ArrayList voucherDetailList = new ArrayList();
        StringBuffer sql;
        
        
        sql = new StringBuffer("SELECT * FROM voucher_detail v INNER JOIN recipient r ON (v.voucher_code=r.voucher_code) INNER JOIN offer o ON (v.voucher_code=o.vouche_code) ");
        sql.append("WHERE r.recipient_email = ? AND v.voucher_code=?");
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            ps = conn.prepareStatement(sql.toString());
            ps.clearParameters();
            
            ps.setString(1, jb.getEmail());
            ps.setString(2, jb.getVoucherCode());
            
            rs = ps.executeQuery();
            
            
            if(rs.next()){
                jb.setRecipientName(CommonUtil.nullToString(rs.getString("recipient_name")));
                jb.setVoucherCode(CommonUtil.nullToString(rs.getString("voucher_code")));
                jb.setVoucherExpiredDate(CommonUtil.nullToString(rs.getString("voucher_expired_date")));
                jb.setVoucherStatus(CommonUtil.nullToString(rs.getString("voucher_status")));
                //voucherDetailList.add(jb);
            }
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }finally{
            DBUtil.close(rs);
            DBUtil.close(ps);
        }
        return jb;
    }
    
    
    public ArrayList voucherDetailsList (homeJB jb,Connection conn){
        ArrayList voucherDetailList = new ArrayList();
        StringBuffer sql;
        
        
        sql = new StringBuffer("SELECT * FROM voucher_detail v INNER JOIN recipient r ON (v.voucher_code=r.voucher_code) INNER JOIN offer o ON (v.voucher_code=o.vouche_code) ");
        sql.append("WHERE r.recipient_email = ? AND v.voucher_status='1' ");
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            ps = conn.prepareStatement(sql.toString());
            ps.clearParameters();
            
            ps.setString(1, jb.getEmail());
            
            rs = ps.executeQuery();
            
            
            while (rs.next()){
                jb.setRecipientName(CommonUtil.nullToString(rs.getString("recipient_name")));
                jb.setVoucherCode(CommonUtil.nullToString(rs.getString("voucher_code")));
                jb.setVoucherExpiredDate(CommonUtil.nullToString(rs.getString("voucher_expired_date")));
                jb.setVoucherStatus(CommonUtil.nullToString(rs.getString("voucher_status")));
                jb.setOfferName(CommonUtil.nullToString(rs.getString("offer_name")));
                voucherDetailList.add(jb);
            }
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }finally{
            DBUtil.close(rs);
            DBUtil.close(ps);
        }
        
        
        return voucherDetailList;
    }
    
    
//    public ArrayList redeemVoucher (homeJB jb,Connection conn){
//        ArrayList voucherDetailList = new ArrayList();
//        StringBuffer sql;
//        
//        
//        sql = new StringBuffer("SELECT * FROM voucher_detail v INNER JOIN recipient r ON (v.voucher_code=r.voucher_code) INNER JOIN offer o ON (v.voucher_code=o.vouche_code) ");
//        sql.append("WHERE r.recipient_email = ?");
//        
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//        try{
//            ps = conn.prepareStatement(sql.toString());
//            ps.clearParameters();
//            
//            ps.setString(1, jb.getEmail());
//            
//            rs = ps.executeQuery();
//            
//            
//            while (rs.next()){
//                jb.setRecipientName(CommonUtil.nullToString(rs.getString("recipient_name")));
//                jb.setVoucherCode(CommonUtil.nullToString(rs.getString("voucher_code")));
//                jb.setVoucherExpiredDate(CommonUtil.nullToString(rs.getString("voucher_expired_date")));
//                jb.setVoucherStatus(CommonUtil.nullToString(rs.getString("voucher_status")));
//                jb.setOfferName(CommonUtil.nullToString(rs.getString("offer_name")));
//                voucherDetailList.add(jb);
//            }
//            
//        }catch(Exception e){
//            System.out.println(e.getMessage());
//        }
//        
//        
//        return voucherDetailList;
//    }
    
    public boolean redeemVoucher(homeJB jb, Connection connection) throws SQLException {
        String actionStatus = "";
        boolean errorFlag = false;
        


        StringBuilder sql = new StringBuilder(" UPDATE voucher_detail SET  ");
        
        
        sql.append("voucher_date_usage = 'NOW()' ");
        sql.append("voucher_status = '0' "); //1 - active, 0 - not active
        sql.append("updated_by = '" + DBUtil.encode(jb.getCreatedBy().toUpperCase()) + "', ");
        sql.append("updated_date = 'NOW()' ");
        sql.append(" where voucher_code = ?");
       
        PreparedStatement pStatement = null;
        try {
            pStatement = connection.prepareStatement(sql.toString());

            pStatement.clearParameters();
            pStatement.setString(1, jb.getVoucherCode());
            if (pStatement.executeUpdate() <= 0) {
                errorFlag = true;
                System.out.println("Error occured during updatevoucher_detail");
            }

            actionStatus = (errorFlag) ? "error" : "success";
            DBUtil.close(pStatement);
        } catch (SQLException sqle) {
            System.out.println(CommonUtil.convertException(sqle));
            errorFlag = true;
        } finally {
            DBUtil.close(pStatement);
        }
        return !errorFlag;
    }   
    
//     public homeJB voucherDetailsList2(homeJB jb,Connection conn){
//        ArrayList voucherDetailList = new ArrayList();
//        StringBuffer sql;
//        
//        
//        sql = new StringBuffer("SELECT * FROM voucher_detail v INNER JOIN recipient r ON (v.voucher_code=r.voucher_code) INNER JOIN offer o ON (v.voucher_code=o.vouche_code) ");
//        sql.append("WHERE r.recipient_email = ?");
//        
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//        try{
//            ps = conn.prepareStatement(sql.toString());
//            ps.clearParameters();
//            
//            ps.setString(1, jb.getEmail());
//            
//            rs = ps.executeQuery();
//            
//            
//            while (rs.next()){
//                jb.setRecipientName(CommonUtil.nullToString(rs.getString("recipient_name")));
//                jb.setVoucherCode(CommonUtil.nullToString(rs.getString("voucher_code")));
//                jb.setVoucherExpiredDate(CommonUtil.nullToString(rs.getString("voucher_expired_date")));
//                jb.setVoucherStatus(CommonUtil.nullToString(rs.getString("voucher_status")));
//                jb.setOfferName(CommonUtil.nullToString(rs.getString("offer_name")));
//                //voucherDetailList.add(jb);
//            }
//            
//        }catch(Exception e){
//            System.out.println(e.getMessage());
//        }
//        
//        
//        return jb;
//    }
    
}
