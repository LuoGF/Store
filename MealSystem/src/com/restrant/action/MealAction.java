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
private Meal meal;//����meal�������ԡ����ڷ�װ������
 MealBiz mealBiz;
 MealSeriesBiz mealSeriesBiz;
 HttpServletRequest request=ServletActionContext.getRequest();
 private Pager pager;
/* Map<String, Object> request;
	public void setRequest(Map<String, Object> request) {
		// TODO Auto-generated method stub
		this.request=request;
	}*/
	//��ȡָ��ҳ�룬���ϲ�ѯ�����Ĳ�Ʒ�б���ת����Ʒ��ʾҳshow.jsp
	public String toShowMeal()throws Exception{
		System.out.println("*******");
		int curPage=1;
		if(pager!=null)
		curPage=pager.getCurPage();//��ô���ʾ��ҳ��
		List mealList=null; 
		                    //����pAGER�����еĴ���ʾҳ��
				pager.setCurPage(curPage);
				            //����ѯ��õ��б����request��Χ
				request.setAttribute("mealList", mealList);
				             //��ȡ��ϵ�б�����request��Χ
				List mealSeriesList=mealSeriesBiz.getMealSeries();
				request.setAttribute("mealSeriesList", mealSeriesList);
		if(meal!=null){           //meal��Ϊ�գ���ʾ���������˲�ѯ��������ʱ��÷�ȡָ��ҳ�룬���ϲ�ѯ�����Ĳ�Ʒ�б�
			mealList=mealBiz.getMealByCondition(getMeal(), curPage);
			pager=mealBiz.getPagerOfMeal(meal);//ͳ�Ʒ��ϲ�ѯ�����Ĳ�Ʒ��������ʼ����ҳ��Pager����
			                               //����pagerows��rowcount����
			if((meal.getMealseries()!=null)&&(meal.getMealseries().getSeriesId()!=null))
				request.setAttribute("seriesId",new Integer(meal.getMealseries().getSeriesId()));
			if((meal.getMealName()!=null)&&(!meal.getMealName().equals("")))
				request.setAttribute("MealName",meal.getMealName());
		}else{
			                         //meal Ϊ��ʱ ��ʾû��ָ����ѯ��������ʱ���ǻ�ȡָ��ҳ��Ĳͺ��б�
			mealList=mealBiz.getAllMeal(curPage);
			                         //��ȡ���в�Ʒ������������ʼ����ҳ��Pager���󡣲����á�һҳ��¼�����͡��ܼ�¼������������
			pager=mealBiz.getPagerOfAllMeal();
		}
		
		return "toShowMeal";
	
		
			
		}
	public String mealSeriesList(){
		System.out.println("************");
		List<Mealseries> mealSeriesList1=mealSeriesBiz.getMealSeries();
		System.out.println("action �ڵ�"+mealSeriesList1);
		
		request.setAttribute("mealSeriesList", mealSeriesList1);
		for(Mealseries s:mealSeriesList1){
			System.out.println(s.getSeriesName()+s.getSeriesId());
		}
		return "mealList";
	}

}
