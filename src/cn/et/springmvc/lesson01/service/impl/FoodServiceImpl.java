package cn.et.springmvc.lesson01.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import cn.et.springmvc.lesson01.dao.FoodDao;
import cn.et.springmvc.lesson01.service.FoodService;
import cn.et.springmvc.lesson01.utils.PageTools;
@Service
public class FoodServiceImpl implements FoodService {
	@Autowired
	FoodDao dao;
	
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.et.springmvc.lesson01.dao.impl.FoodDao#getTableListPager(java.lang
	 * .String)
	 */
	public PageTools getTableListPager(String name,int curPage)
			throws Exception {
		if (name == null) {
			name = "";
		}
		int totalCount=dao.getTableListCount(name);
		PageTools pt=new PageTools(curPage,totalCount,2);
		List<Map<String, Object>> tableListPager = dao.getTableListPager(name, pt.getStartIndex()-1, pt.getPageCount());
		pt.setData(tableListPager);
		return pt;
	}
	
	
	public void addFood(String foodName, String price, String imagePath) {
		dao.addFood(foodName, price, imagePath);
	}
	
	public void updateFood(String foodId, String foodName, String price, String imagePath) {
		dao.updateFood(foodId, foodName, price, imagePath);
	}
	
	public void deleteFood(String foodId) {
		dao.deleteFood(foodId);
	}

	public Map<String, Object> queryById(String foodId) {
		return dao.queryById(foodId);
	}
}
