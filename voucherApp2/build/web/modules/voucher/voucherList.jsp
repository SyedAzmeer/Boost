<%-- 
    Document   : voucherList
    Created on : Dec 8, 2020, 3:02:07 PM
    Author     : azmeerazehar
--%>

<%@page import="com.myapp.home.homeJB"%>
<%@page import="com.myapp.process.voucherProcess"%>
<%@page import="com.myapp.action.homeAction"%>
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
    String email = "";
    if(request.getParameter("email") != null && request.getParameter("email") != ""){
        email = request.getParameter("email");
    }
    
    if (email != null && !email.equals("")) {
        if (!pro.checkVoucherList(email)) {
            System.out.println("Failed to display detail");
        }else{
            if(pro.getVoucherList() != null){
                voucherList = pro.getVoucherList();
            }
        }
    }
    
    

%>
<script>
    function invoke(btn){
        
        if(btn == 1){
            var email = document.myform.email.value;
            
            if(email == null || email == ""){
                alert("Please enter email");
                return;
            }
            
            window.location = '<%= request.getContextPath()%>/modules/voucher/voucherList.jsp?email='+email;
        }
    }
    
</script>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Voucher List</title>
    </head>
    <body>
       <form id="myform">
           <table>
               <tr>
                   <td>
                       <label>Email: <b></b></label>
                   </td>
                   <td>
                       <input type="text" id="email" name="email" value="">
                   </td>
                   <td>
                       <input type="button" id="btnSubmit" name="btnSubmit" onclick="invoke(1)" value="Submit">
                   </td>
               </tr>
           </table>
           <table>
               <%
                if(voucherList.size() > 0 ){
               %>
               <tr>
                    <td>
                        <div align="center">Email:<%= email %></div>
                    </td>
               </tr>
               <tr>
                   <td><div align="center">No</div></td>
                   <td><div align="center">Voucher Code</div></td>
                   <td><div align="center">Special Offer Name</div></td>
                   <td><div align="center">Offer Discount Rate</div></td>
               </tr>
               <%
                    int iRcd = 1;
                    for(int i=0;i < voucherList.size();i++){
                        homeJB obj = (homeJB) voucherList.get(i);
                
                %>
                <tr>
                    <td><div align="center"><%= iRcd%></div></td>
                    <td><div align="center"><%= obj.getVoucherCode() %></div></td>
                    <td><div align="center"><%= obj.getOfferName() %></div></td>
                    <td><div align="center"><%= obj.getOfferDiscountRate() %></div></td>
                </tr>   
                <%
                }
                    }%>
           </table>
           
       </form>
    </body>
</html>
