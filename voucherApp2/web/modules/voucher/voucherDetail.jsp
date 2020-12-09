<%-- 
    Document   : voucherDetail
    Created on : Dec 8, 2020, 3:08:42 PM
    Author     : azmeerazehar
--%>

<%@page import="com.myapp.home.homeJB"%>
<%@page import="com.myapp.action.homeAction"%>
<%@page import="com.myapp.process.voucherProcess"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%!
    private ArrayList voucherList = new ArrayList();
    
    private int countVoucherList = 0;
    


%>
<%
    homeAction ha = new homeAction();
    voucherProcess pro = new voucherProcess();
    homeJB jb = null;
    
    String email = "";
    String voucherCode = "";
    if(request.getParameter("email") != null && request.getParameter("email") != ""){
        email = request.getParameter("email");
    }
    if(request.getParameter("voucherCode") != null && request.getParameter("voucherCode") != ""){
        voucherCode = request.getParameter("voucherCode");
    }
    
    if ((email != null && !email.equals("")) && (voucherCode != null && !voucherCode.equals(""))) {
        if (!pro.checkVoucherDetail(email,voucherCode)) {
            System.out.println("Failed to display detail");
        }else{
            if(pro.getObjhJB() != null){
                jb = pro.getObjhJB();
            }
        }
    }
    
    
    
%>
<script language="JavaScript" type="text/javascript">
    function invoke(btn){
        if(btn == 1){
            var email = document.myform.txtemail.value;
            var voucherCode = document.myform.txtvoucherCode.value;
            
            if(email == null || email == ""){
                alert("Please enter email");
                return;
            }
            if(voucherCode == null || voucherCode == ""){
                alert("Please enter voucher code");
                return;
            }
            window.location = '<%= request.getContextPath()%>/modules/voucher/voucherDetail.jsp?email='+email+'&voucherCode='+voucherCode;
        }
        
        if(btn == 2){
            var answer = confirm("Do you want to redeem this voucher code?");
            if(answer){
                document.myform.action = '<%= request.getContextPath() %>/modules/home/home.do?action=redeemVoucher&email=<%= email%>&voucherCode=<%= voucherCode %>';
                document.myform.submit();
            }
            
        }
    }
    
</script>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Voucher Detail</title>
    </head>
    <body>
        <form id="myform" name="myform" method="post">
           <table>
               <tr>
                   <td>
                       <label>Email: <b></b></label>
                   </td>
                    <td>
                       <input type="text" id="txtemail" name="txtemail" value="">
                   </td>
               </tr>
               <tr>
                   <td>
                       <label>Voucher Code: <b></b></label>
                   </td>
                   <td>
                       <input type="text" id="txtvoucherCode" name="txtvoucherCode" value="">
                   </td>
               </tr>
               <tr>
                   <td>
                       <input type="button" id="btnSubmit" name="btnSubmit" onclick="invoke(1)" value="Submit">
                   </td>
               </tr>
           </table>
            <%
             if(jb != null){
            %>
            <table>
                <tr>
                    <td>Email:<%= email%></td>
                </tr>
                 <tr>
                    <td>Voucher Code:<%= voucherCode %></td>
                </tr>
            </table>
            <table>
                <tr>
                    <td>Percentage Discount:</td>
                    <td><%= jb.getOfferDiscountRate() %></td>
                </tr>
<!--                <tr>
                    <td>Date of Usage:</td>
                    <td></td>
                </tr>-->
                <tr>
                    <td>
                        <input type="button" id="btnRedeem" name="btnRedeem" onclick="invoke(2)" value="Redeem">
                    </td>
                </tr>
            </table>
            <%
                       }
            %>
           
       </form>
    </body>
</html>
