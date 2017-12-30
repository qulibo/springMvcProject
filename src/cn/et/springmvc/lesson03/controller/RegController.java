package cn.et.springmvc.lesson03.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.et.springmvc.lesson03.entity.UserInfo;

@Controller
public class RegController {
	@RequestMapping(value="/reg", method=RequestMethod.POST)
	public String register(@ModelAttribute("user") @Valid UserInfo user, BindingResult error) {
		if(!user.getPassword().equals(user.getRePassword())){
			error.addError(new FieldError("user", "repassword", "两次密码不一致"));
		}
		/**
		if(user.getAge()==null || "".equals(user.getAge().trim())){
			error.addError(new FieldError("user", "age", "年龄不能为空"));
		}else{
			
			Integer age;
			try {
				age = Integer.parseInt(user.getAge());
				if(age<1 || age>100){
					error.addError(new FieldError("user", "age", "年龄必须在1-100之间"));
				}
			} catch (Exception e) {
				error.addError(new FieldError("user", "age", "年龄必须是数"));
			}
			
		}
		**/
		if(error.hasErrors()) {
			return "/lesson03/reg.jsp";
		}
		return "/lesson03/suc.jsp";
	}
}
