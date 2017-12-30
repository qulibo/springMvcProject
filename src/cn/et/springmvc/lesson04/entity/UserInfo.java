package cn.et.springmvc.lesson04.entity;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;


public class UserInfo {
	/**
	 * NotNull 属性名 !=null
	 * NotEmpty 属性名!=null &&  !属性名.equals("")
	 */
	@NotEmpty(message="{userError}")
	private String userName;
	@NotEmpty(message="密码不能为空")
	private String password;
	@NotEmpty(message="再次输入不能为空")
	private String rePassword;
	// lixin@126.com  
	@Pattern(message="邮箱格式错误",regexp=".+@.+\\..+")
	private String email;
	@NotEmpty(message="年龄不能为空")
	@Min(value=1,message="年龄必须大于1")
	@Max(value=100,message="年龄必须小于100")
	private String age;
	@Size(min=11, max=11,message="手机号码必须是11位")
	private String phone;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRePassword() {
		return rePassword;
	}
	public void setRePassword(String repassword) {
		this.rePassword = repassword;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	
}
