<%-- 
    Document   : homePage
    Created on : Dec 6, 2020, 12:02:48 AM
    Author     : azmeerazehar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<script language="JavaScript" type="text/javascript">
    function invoke(btn){
        //var email = document.myform.email.value;
        //var voucherCode = document.myform.voucherCode.value;
        
        if(btn == 1){
            window.location = '<%= request.getContextPath()%>/modules/voucher/voucherDetail.jsp?';
        }
        
         if(btn == 2){
           window.location = '<%= request.getContextPath()%>/modules/voucher/voucherList.jsp?';
        }
        
    }
</script>
<%
    String email = "";
    
    
    if(request.getParameter("email") != null && request.getParameter("email") != ""){
        email = request.getParameter("email");
    }




%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to the Voucher Pool App</title>
    </head>
    <body>
        <form id="myform">
            <table border=0 cellspacing="0" cellpadding="0" border="0" width="100%"> 
                <tr align="center">
                    <td>
                        <h2>Please click button below for voucher transaction </h2>
                    </td>
                </tr>
                <tr align="center">
                    <td>
                        <input type="button" id="btnSubmit" name="btnSubmit" onclick="invoke(1)" value="Validate Voucher"> <!-- edited by azmeer --> 
                    </td>
                </tr>
                <tr></tr>
                <tr align="center">
                    <td>
                        <input type="button" id="btnSubmit2" name="btnSubmit2" onclick="invoke(2)" value="Voucher List"> 
                    </td>
                </tr>
            </table>
            
            
        </form>
        
        
    </body>
</html>
