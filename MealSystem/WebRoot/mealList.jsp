<%@ page language="java" import="java.util.*,com.restrant.entity.*" pageEncoding="UTF-8"%>
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
   <!-- 菜系循环开始 -->
  <h1>菜系循环开始</h1>
   <s:iterator value="mealSeriesList1"><br>
   <s:property value="seriesName"/>
   </s:iterator>
   
<s:iterator id="list" value="#request.mealSeriesList">
 <s:property value="list.seriesName"/>
  <a href="/toShowMeal?meal.mealseries.seriesId=${list.seriesId}">
   ${list.seriesName}</a><br>
</s:iterator>
  </body>
</html>
