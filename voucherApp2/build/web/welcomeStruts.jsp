<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<script type="text/javascript">
    
    function invoke(btn){
        if(btn == 1){
            var email = document.myform.email.value;
            var password = document.myform.password.value;
            
            document.myform.action = '<%= request.getContextPath() %>/modules/home/home.do?action=submitLogin&email='+email + '&password=' + password;
            document.myform.submit();
        }
    }
    
</script>
<html:html lang="true">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><bean:message key="welcome.title"/></title>
        <html:base/>
    </head>
    <body style="background-color: white">
        
        <logic:notPresent name="org.apache.struts.action.MESSAGE" scope="application">
            <div  style="color: red">
                ERROR:  Application resources not loaded -- check servlet container
                logs for error messages.
            </div>
        </logic:notPresent>
        <form id="myform">
            <table align="center">
                <tr></tr>
                <tr></tr>
                <tr></tr>
                <tr></tr>
                <tr></tr>
                <tr>
                    <td>
                        <h3>VOUCHER POOL</h3>
                    </td>
                    
                </tr>
                
            </table>
            
            <table align="center">
                <tr>
                    <td>Email:</td>
                    <td><input type="text" id="email" name="text" value="">
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><input type="password" id="password" name="password" value="">
                </tr>
                <tr>
                    <td align="right" colspan="2">
                        <input type="button" id="loginBtn" name="loginBtn" onClick="invoke(1)" value="Login">
                        <input type="button" id="loginRegister" name="loginRegister" onClick="invoke(2)" value="Register">
                    </td>
                </tr>
                
            </table>
            
        </form> 
        
        
        
    </body>
</html:html>
