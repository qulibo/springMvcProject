package cn.et.springmvc.lesson01.service;

import java.util.List;
import java.util.Map;

import cn.et.springmvc.lesson01.utils.PageTools;

public interface FoodService {
	
	public PageTools getTableListPager(String name,int curPage) throws Exception;
	

	public abstract void addFood(String foodName, String price, String imagePath);

	public abstract void updateFood(String foodId, String foodName,
			String price, String imagePath);

	public abstract void deleteFood(String foodId);
	
	public abstract Map<String, Object> queryById(String foodId);

}