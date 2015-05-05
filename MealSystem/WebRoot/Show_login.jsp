<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
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
  <div align="center">
 <s:if test="#session.user!=null">
    <a href="modifyMyInfo.jsp">修改个人信息</a> | <a href="/Restrant/toMyOrders">我的订单</a> | 
    <a href="shopCart.jsp?">我的购物车</a> | <a href="/Restrant/logout?type=userlogout">注销</a>
    &nbsp;&nbsp;&nbsp;
    <font style="color:red">欢迎您：${sessionScope.user.trueName}</font>
 </s:if>
      <s:if test="#session.admin!=null">
      <a href="/Restrant/toAddMeal">添加餐品</a> | <a href="/Restrant/toMangerMeal">管理餐品</a> | 
      <a href="/Restrant/logout?type=adminlogout">注销</a>
       &nbsp;&nbsp;&nbsp;
 <font style="color:red">欢迎您：${sessionScope.admin.trueName}</font>
 </s:if>
 </div> 
 
   <!-- 菜系循环开始 -->
   <div align="left">
   <h1>菜系循环开始</h1>
   <s:iterator id="list" value="#request.mealSeriesList">
 <s:property value="list.seriesName"/>
  <a href="/toShowMeal?meal.mealseries.seriesId=${list.seriesId}">
   ${list.seriesName}</a><br>
</s:iterator>
   </div>
   <!-- 输入菜名查询 -->
   <div align="center">
    <h1>输入菜名查询</h1>
   <s:form theme="simple" method="post" action="toShowMeal">
   <s:label value="输入菜名"/><s:textfield name="meal.mealName"/>
   <!-- 通过隐藏表单保存用户选择菜系编号，可根据餐品名称和菜系名称组合查询 -->
   <s:hidden name="meal.mealseries.seriesId" value="%{#request.seriesId}"/>
   <s:submit value="查询"/>
   </s:form>
   </div>
   <!-- 循环列出所有餐品 -->
   <div align="center">
    <h1>循环列出所有餐品</h1>
   <s:iterator id="mealItem" value="#request.mealList" status="st">
   <s:if test="#st.getIndex()%3==0">
   <tr>
   </s:if>
   <td>
   <a href="/MealSystem/toShowDetails?mealId=${mealItem.mealId}">
   <img src="image/${mealItem.mealIamge}" width="148" height="126" border="0"></a>
   
   <div>
   ${mealItem.mealId}:${mealItem.mealName}<br />
   <span style="text-decoration: line-through;color: gray;">
   原价： 人民币${mealItem.mealPrice}元</span><br/>
    现价： 人民币${mealItem.mealPrice*0.9}元   
   </div>
   <a href="/MealSystem/toShowDetails?meal.mealseries.seriesId=${ mealSeriesList.seriesId}">
  <img src="/MealSystem/image/detail_cn.gif" width="60" height="20" border="0"></a>
  <a href="/MealSystem/addtoshopcart?meal.mealId=${ mealItem.mealId}">
  <img src="/MealSystem/image/buy_cn.gif" width="60" height="20" border="0"></a>
  </td>
  <s:if test="#st.getIndex()%3==2">
  </tr> </s:if>
   </s:iterator>
   </div>
   <!-- 餐品循环结束 -->
   <!-- 分页超链接开始 -->
   <div align="right">
   <h1>分页超链接开始</h1>
   <table align="right">
   <tr>
   <td width="130"></td>
   <td width="80">
   <s:if test="pager.curPage>1">
   <A href='/MealSystem/toShowMeal?pager.curPage=1&meal.mealseries.seriesId=${requestScope.seriesId}&
   meal.mealName=${requestScope.mealName}'>首页</A>&nbsp;&nbsp;
   <A href='/MealSystem/toShowMeal?pager.curPage=${pager.curPage-1}&meal.mealseries.seriesId=${requestScope.seriesId}&
   meal.mealName=${requestScope.mealName}'>上一页</A>
   </s:if>
   </td>
   <td width="80">
   <s:if test="pager.curPage<pager.pageCount">
   <A href='/MealSystem/toShowMeal?pager.curPage=${pager.curPage+1}&meal.mealseries.seriesId=${requestScope.seriesId}&
   meal.mealName=${requestScope.mealName}'>下一页</A>&nbsp;&nbsp;
   <A href='/MealSystem/toShowMeal?pager.curPage=${pager.curPage}&meal.mealseries.seriesId=${requestScope.seriesId}&
   meal.mealName=${requestScope.mealName}'>尾页</A>
   </s:if>
  </td>
  <td>共${pager.rowCount}记录,共${pager.curPage}/${pager.pageConut}页&nbsp;&nbsp;</td>
   </tr>
   </table>
   </div>
  </body>
</html>
