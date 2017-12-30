package cn.et.springmvc.lesson05.controller;

import java.io.OutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.et.springmvc.lesson05.dao.MoneyDaoImpl;

@Controller
public class InterController {
	@RequestMapping(value="/inter",method=RequestMethod.GET)
	public String reg(OutputStream os) throws Exception{
		os.write("hello".getBytes());
		return null;
	}
	
	@Autowired
	MoneyDaoImpl mdi;
	@RequestMapping(value="/tm",method=RequestMethod.GET)
	public String reg(Integer money,OutputStream os) throws Exception{
		mdi.trasnateMoney(money);
		os.write(("lostedmoney is:"+mdi.selectMoney()).getBytes());
		return null;
	}
}
