package cn.et.springmvc.lesson03.controller;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import cn.et.springmvc.lesson01.helloworld.User;
/**
 * springmvc中Model相关对象 是处理和数据相关的对象
 *  @ModelAttribute 重命名 参数数据
 * Model(ModelMap|Map)传递数据到视图(request.setAttribute)
 * ModelAndView 绑定数据到视图 （ModelMap用于传递数据 View对象用于跳转）
 * @author Administrator
 *
 */
@SessionAttributes("user")
@Controller
public class SessionController {
	
	@ModelAttribute("user")
	public User getUser(){
		User user = new User();
		return user;
	}
	

	
	/**
	 * http://localhost:8080/s/s1?id=1
	 * 请求转发 forward: 不需要任何处理
	 * 请求重定向 redirect: 使用SessionAttribute方式 用于在重定向中传至  将值存储在session中 【用完记住清除】
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/s1",method=RequestMethod.GET)
	public String case1(@ModelAttribute("user") User user) throws Exception{
		return "redirect:/s2";
	}
	
	
	@RequestMapping(value="/s2",method=RequestMethod.GET)
	public String case2(Map map,HttpServletResponse res,SessionStatus sessionStatus) throws Exception{
		User user=(User)map.get("user");
		res.getWriter().println(user.getId());
		sessionStatus.setComplete();
		return null;
	}
	
}
