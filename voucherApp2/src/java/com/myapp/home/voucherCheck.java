/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.home;

import com.myapp.db.voucherDB;
import com.myapp.home.homeJB;
import com.myapp.home.homeJB;
import com.myapp.util.DBUtil;
import java.sql.Connection;

/**
 *
 * @author azmeerazehar
 */
public class voucherCheck {
    
    homeJB objhJB = new homeJB();
    
    public static boolean displayVoucher(String email,String voucherCode){
        homeJB jb = null;
        Connection conn = null;
        voucherDB vdb = null;
        try{
            jb = new homeJB();
            vdb = new voucherDB();
            conn = DBUtil.getConnection();
            
            if(email != null && !email.equals("")){
                jb.setEmail(email);
            }
            if(voucherCode != null && !voucherCode.equals("")){
                jb.setVoucherCode(voucherCode);
            }
            
            vdb.voucherDetails(jb,conn);
            
            
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }finally{
            DBUtil.close(conn);
        }     
        
        return true;
    }
    
    public static boolean displayVoucherList(String email,String voucherCode){
        homeJB jb = null;
        Connection conn = null;
        voucherDB vdb = null;
        try{
            jb = new homeJB();
            vdb = new voucherDB();
            conn = DBUtil.getConnection();
            
            if(email != null && !email.equals("")){
                jb.setEmail(email);
            }
            
            vdb.voucherDetailsList(jb,conn);
            
            
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }finally{
            DBUtil.close(conn);
        }  
        
        return true;
    }
    
    public static boolean displayVoucherList2(homeJB jb){
        //homeJB jb = null;
        Connection conn = null;
        voucherDB vdb = null;
        try{
            jb = new homeJB();
            vdb = new voucherDB();
            conn = DBUtil.getConnection();
            
            vdb.voucherDetailsList(jb,conn);
            
            
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }finally{
            DBUtil.close(conn);
        }     
        
        return true;
    }
    
    public static boolean redeemVoucher(String email,String voucherCode){
        homeJB jb = null;
        Connection conn = null;
        voucherDB vdb = null;
        try{
            jb = new homeJB();
            vdb = new voucherDB();
            conn = DBUtil.getConnection();
            
            if(email != null && !email.equals("")){
                jb.setEmail(email);
            }
             if(voucherCode != null && !voucherCode.equals("")){
                jb.setVoucherCode(voucherCode);
            }
            
            if(!vdb.redeemVoucher(jb,conn)){
                return false;
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }finally{
            DBUtil.close(conn);
        }    
        
        return true;
    }
    
}
