package com.restrant.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.restrant.biz.MealBiz;
import com.restrant.biz.MealSeriesBiz;
import com.restrant.entity.Meal;
import com.restrant.entity.Mealseries;
import com.restrant.entity.Pager;

public class MealAction extends ActionSupport{
public MealBiz getMealBiz() {
		return mealBiz;
	}
	public void setMealBiz(MealBiz mealBiz) {
		this.mealBiz = mealBiz;
	}
	public MealSeriesBiz getMealSeriesBiz() {
		return mealSeriesBiz;
	}
	public void setMealSeriesBiz(MealSeriesBiz mealSeriesBiz) {
		this.mealSeriesBiz = mealSeriesBiz;
	}
	public Pager getPager() {
		return pager;
	}
	public void setPager(Pager pager) {
		this.pager = pager;
	}
public Meal getMeal() {
		return meal;
	}
	public void setMeal(Meal meal) {
		this.meal = meal;
	}
private Meal meal;//定义meal类型属性。用于封装表单参数
 MealBiz mealBiz;
 MealSeriesBiz mealSeriesBiz;
 HttpServletRequest request=ServletActionContext.getRequest();
 private Pager pager;
/* Map<String, Object> request;
	public void setRequest(Map<String, Object> request) {
		// TODO Auto-generated method stub
		this.request=request;
	}*/
	//获取指定页码，符合查询条件的餐品列表，再转到餐品显示页show.jsp
	public String toShowMeal()throws Exception{
		System.out.println("*******");
		int curPage=1;
		if(pager!=null)
		curPage=pager.getCurPage();//获得待显示的页数
		List mealList=null; 
		                    //设置pAGER对象中的带显示页码
				pager.setCurPage(curPage);
				            //将查询获得的列表存入request范围
				request.setAttribute("mealList", mealList);
				             //获取菜系列表，存入request范围
				List mealSeriesList=mealSeriesBiz.getMealSeries();
				request.setAttribute("mealSeriesList", mealSeriesList);
		if(meal!=null){           //meal不为空，表示表单中输入了查询条件。此时获得符取指定页码，符合查询条件的餐品列表
			mealList=mealBiz.getMealByCondition(getMeal(), curPage);
			pager=mealBiz.getPagerOfMeal(meal);//统计符合查询条件的餐品数量，初始化分页类Pager对象
			                               //设置pagerows和rowcount属性
			if((meal.getMealseries()!=null)&&(meal.getMealseries().getSeriesId()!=null))
				request.setAttribute("seriesId",new Integer(meal.getMealseries().getSeriesId()));
			if((meal.getMealName()!=null)&&(!meal.getMealName().equals("")))
				request.setAttribute("MealName",meal.getMealName());
		}else{
			                         //meal 为空时 表示没有指定查询条件，此时我们获取指定页码的餐号列表
			mealList=mealBiz.getAllMeal(curPage);
			                         //获取所有菜品数量，用来初始化分页类Pager对象。并设置“一页记录数”和“总记录数”两个属性
			pager=mealBiz.getPagerOfAllMeal();
		}
		
		return "toShowMeal";
	
		
			
		}
	public String mealSeriesList(){
		System.out.println("************");
		List<Mealseries> mealSeriesList1=mealSeriesBiz.getMealSeries();
		System.out.println("action 内的"+mealSeriesList1);
		
		request.setAttribute("mealSeriesList", mealSeriesList1);
		for(Mealseries s:mealSeriesList1){
			System.out.println(s.getSeriesName()+s.getSeriesId());
		}
		return "mealList";
	}

}
