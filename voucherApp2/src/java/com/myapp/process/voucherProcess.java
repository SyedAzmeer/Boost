/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.process;

import com.myapp.db.voucherDB;
import com.myapp.home.homeJB;
import com.myapp.home.voucherCheck;
import com.myapp.util.DBUtil;
import java.sql.Connection;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionRedirect;

/**
 *
 * @author azmeerazehar
 */
public class voucherProcess {
    
   private homeJB objhJB= null;
   private ArrayList voucherList= new ArrayList();
   
   public boolean checkVoucherDetail(String email,String voucherCode) {
        email = "";
        voucherCode = "";
        //voucherCheck vc = new voucherCheck();
        this.setObjhJB(new homeJB());
        
        if(email != null && !email.equals("")){
            this.getObjhJB().setEmail(email);
        } 
         if(voucherCode != null && !voucherCode.equals("")){
            this.getObjhJB().setVoucherCode(voucherCode);
        } 
        
        if(!this.displayVoucherDetail(objhJB)){
            return false;
        }
        
        return true;
    }
    
   public boolean checkVoucherList(String email) {
        email = "";
        String voucherCode = "";
        //voucherCheck vc = new voucherCheck();
        this.setObjhJB(new homeJB());
        
        if(email != null && !email.equals("")){
            this.getObjhJB().setEmail(email);
        } 
        
        if(!this.displayVoucherList(objhJB)){
            return false;
        }
        
        return true;
    }
    
    public boolean displayVoucherList(homeJB jb){
        //homeJB jb = null;
        Connection conn = null;
        voucherDB vdb = null;
        try{
            jb = new homeJB();
            vdb = new voucherDB();
            conn = DBUtil.getConnection();
            
            this.setVoucherList(vdb.voucherDetailsList(jb,conn));
            
            
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }finally{
            DBUtil.close(conn);
        }     
        
        return true;
    }
    
    public boolean displayVoucherDetail(homeJB jb){
        //homeJB jb = null;
        Connection conn = null;
        voucherDB vdb = null;
        try{
            jb = new homeJB();
            vdb = new voucherDB();
            conn = DBUtil.getConnection();
            
            this.setObjhJB(vdb.voucherDetails(jb,conn));
            
            
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }finally{
            DBUtil.close(conn);
        }     
        
        return true;
    }

    /**
     * @return the objhJB
     */
    public homeJB getObjhJB() {
        return objhJB;
    }

    /**
     * @param objhJB the objhJB to set
     */
    public void setObjhJB(homeJB objhJB) {
        this.objhJB = objhJB;
    }

    /**
     * @return the voucherList
     */
    public ArrayList getVoucherList() {
        return voucherList;
    }

    /**
     * @param voucherList the voucherList to set
     */
    public void setVoucherList(ArrayList voucherList) {
        this.voucherList = voucherList;
    }
}
