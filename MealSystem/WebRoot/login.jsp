<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
  </head>
  
  <body>
    <s:if test="#parameters.role[0]=='user'">
    <form action="validateLogin?type=userlogin" method="post" name="ufrm">
    <table width="263"  cellspacing="0" cellpadding="4" align="center">
    <tr><s:textfield naem="user.loginName" label="用户名"/></tr>
    <tr> <s:password name="user.loginPwd" label="密    码"/></tr>
    <tr> <s:submit label="密    码"/></tr>
    </table>
    </form>
    </s:if>
    <s:if test="#parameters.role[0]=='admin'">
    <form action="validateLogin?type=adminlogin" method="post" name="afrm">
    <table width="263"  cellspacing="0" cellpadding="4" align="center">
    <tr><s:textfield naem="user.loginName" label="用户名"/></tr>
    <tr> <s:password name="user.loginPwd" label="密    码"/></tr>
    <tr> <s:submit label="密    码"/></tr>
    </table>
    </form>
    </s:if>
  </body>
</html>
