package cn.et.springmvc.lesson04.controller;

import java.io.OutputStream;
import java.util.Locale;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.et.springmvc.lesson04.entity.UserInfo;

@Controller
public class ViewController {
	/**
	 * 通过messagesource 在action中获取消息
	 */
	@Autowired
	MessageSource ms;
	@RequestMapping(value="/nation",method=RequestMethod.GET)
	public String nation(HttpServletResponse response,OutputStream os,Locale locale) throws Exception{
		response.setContentType("text/html;charset=UTF-8");
		os.write(ms.getMessage("key", null, locale).getBytes("UTF-8"));
		return null;
	}
	
	@RequestMapping(value="/mid",method=RequestMethod.GET)
	public String mid() throws Exception{
		return "/lesson04/reg.jsp";
	}
	@RequestMapping(value="/myreg",method=RequestMethod.POST)
	public String mid(@ModelAttribute("user") @Valid UserInfo user,BindingResult result) throws Exception{
		if(result.hasErrors()){
			return "/lesson04/reg.jsp";
		}
		return null;
	}
	
}
