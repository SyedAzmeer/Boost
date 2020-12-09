/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.myapp.home.LoginClass;
import com.myapp.home.voucherCheck;
import org.apache.struts.action.ActionRedirect;
/**
 *
 * @author azmeerazehar
 */
public class homeAction {
    
    public ActionForward submitLogin(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse httpServletResponse) {
        String email = "";
        String password = "";
        LoginClass lc = new LoginClass();
        
        try{
            if(request.getParameter("email") != null && request.getParameter("email") != ""){
                email = request.getParameter("email");
            }
            if(request.getParameter("password") != null && request.getParameter("password") != ""){
                password = request.getParameter("password");
            }
            
            lc.loginInformation(email, password);
            
            
        }catch (Exception e){
            System.out.println("Error occured with Login");
        }finally{
        }

        ActionRedirect redirect = new ActionRedirect(actionMapping.findForward("searchSuccessLogin"));
        redirect.addParameter("email", email);
        redirect.addParameter("password", password);
        return redirect;
        //return actionMapping.findForward("searchSuccessLogin");
    }
    
    public ActionForward checkVoucher(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse httpServletResponse) {
        String email = "";
        String voucherCode = "";
        voucherCheck vc = new voucherCheck();
        
        try{
            if(request.getParameter("email") != null && request.getParameter("email") != ""){
                email = request.getParameter("email");
            }
            if(request.getParameter("voucherCode") != null && request.getParameter("voucherCode") != ""){
                voucherCode = request.getParameter("voucherCode");
            }
            
            vc.displayVoucher(email, voucherCode);
            
            
        }catch (Exception e){
            System.out.println("Error occured with Voucher Checkig");
        }finally{
        
        }

        ActionRedirect redirect = new ActionRedirect(actionMapping.findForward("searchVoucherList"));
        redirect.addParameter("email", email);
        redirect.addParameter("voucherCode", voucherCode);
        return redirect;
        
    }
    
    public ActionForward checkVoucherList(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse httpServletResponse) {
        String email = "";
        String voucherCode = "";
        voucherCheck vc = new voucherCheck();
        
        try{
            if(request.getParameter("email") != null && request.getParameter("email") != ""){
                email = request.getParameter("email");
            }
            if(request.getParameter("voucherCode") != null && request.getParameter("voucherCode") != ""){
                voucherCode = request.getParameter("voucherCode");
            }
            
            vc.displayVoucherList(email, voucherCode);
            
            
        }catch (Exception e){
            System.out.println("Error occured with Voucher Checkig");
        }finally{
        
        }

        ActionRedirect redirect = new ActionRedirect(actionMapping.findForward("searchVoucherList"));
        redirect.addParameter("email", email);
        redirect.addParameter("voucherCode", voucherCode);
        return redirect;
        
    }
    
    public ActionForward redeemVoucher(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse httpServletResponse) {
        String email = "";
        String voucherCode = "";
        voucherCheck vc = new voucherCheck();
        
        try{
            if(request.getParameter("email") != null && request.getParameter("email") != ""){
                email = request.getParameter("email");
            }
            if(request.getParameter("voucherCode") != null && request.getParameter("voucherCode") != ""){
                voucherCode = request.getParameter("voucherCode");
            }
            
            vc.redeemVoucher(email, voucherCode);
            
            
        }catch (Exception e){
            System.out.println("Error occured with Voucher redemption");
        }finally{
        
        }

        ActionRedirect redirect = new ActionRedirect(actionMapping.findForward("searchVoucherList"));
        redirect.addParameter("email", email);
        redirect.addParameter("voucherCode", voucherCode);
        return redirect;
        
    }
    
    
}
