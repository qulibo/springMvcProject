package cn.et.springmvc.lesson01.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cn.et.springmvc.lesson01.dao.FoodDao;
@Repository
public class FoodDaoImpl implements FoodDao {
	@Autowired
	JdbcTemplate template;
	
	
	
	public Integer getTableListCount(String name) throws Exception{
        if(name==null){
            name="";
        }
        String sql="select count(*) as cr from food where foodname like '%"+name+"%'";
        List<Map<String, Object>> result=template.queryForList(sql);
        return Integer.parseInt(result.get(0).get("cr").toString());
    }

	/* (non-Javadoc)
	 * @see cn.et.springmvc.lesson01.dao.impl.FoodDao#getTableListPager(java.lang.String)
	 */
	public List<Map<String, Object>> getTableListPager(String name,int startIndex,int length) throws Exception{
	   String sql="select * from food t  where t.foodname like '%"+name+"%' limit  "+startIndex+","+length;
	   List<Map<String, Object>> result=template.queryForList(sql);
	   return result;
	}
	/* (non-Javadoc)
	 * @see cn.et.springmvc.lesson01.dao.impl.FoodDao#addFood(java.lang.String, java.lang.String, java.lang.String)
	 */
	public void addFood(String foodName, String price, String imagePath) {
		String sql = "insert into food(foodname, price, imagepath) values('"+foodName+"','"+price+"', '"+imagePath+"' );";
		template.execute(sql);
	}
	/* (non-Javadoc)
	 * @see cn.et.springmvc.lesson01.dao.impl.FoodDao#updateFood(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	public void updateFood(String foodId, String foodName, String price, String imagePath) {
		String sql = "update food set foodname = '"+foodName+"', price = '"+price+"', imagepath = '"+imagePath+"' where foodid = '"+foodId+"';";
		template.execute(sql);
	}
	/* (non-Javadoc)
	 * @see cn.et.springmvc.lesson01.dao.impl.FoodDao#deleteFood(java.lang.String)
	 */
	public void deleteFood(String foodId) {
		String sql = "delete from food where foodid = '"+foodId+"';";
		template.execute(sql);
	}
	public Map<String, Object> queryById(String foodId) {
		String sql = "select * from food where foodid = "+foodId+";";
		List<Map<String, Object>> result = template.queryForList(sql);
		return result.get(0);
	}
	
}
