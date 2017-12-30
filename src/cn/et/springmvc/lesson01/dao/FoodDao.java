package cn.et.springmvc.lesson01.dao;

import java.util.List;
import java.util.Map;

public interface FoodDao {
	
	public Integer getTableListCount(String name) throws Exception;
	
	public List<Map<String, Object>> getTableListPager(String name,int startIndex,int length) throws Exception;
	
	public abstract void addFood(String foodName, String price, String imagePath);

	public abstract void updateFood(String foodId, String foodName,
			String price, String imagePath);

	public abstract void deleteFood(String foodId);
	
	public abstract Map<String, Object> queryById(String foodId);
}