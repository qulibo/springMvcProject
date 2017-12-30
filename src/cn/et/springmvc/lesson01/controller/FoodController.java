package cn.et.springmvc.lesson01.controller;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import cn.et.springmvc.lesson01.service.FoodService;
import cn.et.springmvc.lesson01.utils.PageTools;

@Controller
public class FoodController {
	@Autowired
	FoodService service;
	@RequestMapping(value="/showFood", method=RequestMethod.GET)
	public String queryFood(Integer curPage, String dname, Model model) throws Exception {
		if(curPage==null){
			curPage=1;
		}
		PageTools tableListPager = service.getTableListPager(dname,curPage);
		//request.setAttribute("","");
		model.addAttribute("foodList", tableListPager);
		return "/detail/foodList.jsp";
	}
	@RequestMapping(value="/food/{foodId}", method=RequestMethod.GET)
	public String queryFooodById(@PathVariable String foodId, Model model) {
		model.addAttribute("myfood", service.queryById(foodId));
		return "/detail/detailFood.ftl";
	}
	@RequestMapping(value="/updateFood/{foodId}", method=RequestMethod.POST)
	public String updateFood(@PathVariable String foodId,String foodName,String price,MultipartFile imageUrl,Model model) throws Exception {
		String fileName=imageUrl.getOriginalFilename();
		String absPath="D:\\5.JSP&SRV\\教学软件\\apache-tomcat-6.0.45\\webapps\\smp\\images";
		imageUrl.transferTo(new File(absPath+"\\"+fileName));
		service.updateFood(foodId, foodName, price,fileName);
		return queryFood(1,null,model);
	}
	@RequestMapping(value="/saveFood/", method=RequestMethod.POST)
	public String saveFood(String foodName,String price,MultipartFile imageUrl, Model model) throws Exception {
		String fileName=imageUrl.getOriginalFilename();
		if(fileName != null) {
			String absPath="D:\\5.JSP&SRV\\教学软件\\apache-tomcat-6.0.45\\webapps\\smp\\images";
			imageUrl.transferTo(new File(absPath+"\\"+fileName));
		}
		service.addFood(foodName, price, fileName);
		return queryFood(1,null,model);
	}
	@RequestMapping(value="/deleteFood/{foodId}", method=RequestMethod.GET)
	public String deleteFood(@PathVariable String foodId, Model model) throws Exception {
		service.deleteFood(foodId);
		return queryFood(1,null,model);
	}
	@RequestMapping(value="/download/", method=RequestMethod.GET)
	public ResponseEntity<byte[]> downFile(String imagePath, Model model) throws IOException {
		String absPath="D:\\5.JSP&SRV\\教学软件\\apache-tomcat-6.0.45\\webapps\\smp\\images\\"+imagePath;
		String fileName = imagePath;
		//需要下载的目标文件
        File file=new File(absPath);
        //设置响应头
        HttpHeaders hh=new HttpHeaders();
        //设置下载的文件的名称
        hh.setContentDispositionFormData("attachment", URLEncoder.encode(fileName, "UTF-8"));
        //读取目标文件为二进制数组
        byte[] fileByte=FileCopyUtils.copyToByteArray(file);
        //构建ResponseEntity对象
        ResponseEntity<byte[]> re=new ResponseEntity<byte[]>(fileByte, hh, HttpStatus.CREATED);
        return re;
	}
	
}
