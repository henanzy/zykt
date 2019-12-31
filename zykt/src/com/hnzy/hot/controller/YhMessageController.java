package com.hnzy.hot.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hnzy.hot.pojo.Rz;
import com.hnzy.hot.pojo.YhMessage;
import com.hnzy.hot.service.DataService;
import com.hnzy.hot.service.RzService;
import com.hnzy.hot.service.YhMessageService;
import com.hnzy.hot.util.JSONSerializer;

import net.sf.json.JSONObject;



@Controller
@RequestMapping("yhmsg")
public class YhMessageController {
	@Autowired
	private YhMessageService yhMessageService;
	
	@Autowired
	private RzService rzService;
	@Autowired
	private DataService dataService;
	private Rz rz;
	@RequestMapping("/findAll")
	public String findAll(HttpServletRequest request,HttpSession session){
		
		List<Map<String, String>> yhLsit = dataService.finds();
		String yhLsitSer=JSONSerializer.serialize(yhLsit);
		request.setAttribute("yhLsitSer", yhLsitSer);
		return"Xxgl/yhxx";
	}
	
	@RequestMapping("/addYh")
	public String addYh(YhMessage yhMessage,HttpServletRequest request,HttpSession session){
		
		yhMessageService.addYh(yhMessage);
		rz =new Rz();
		rz.setCz("添加用户"+yhMessage.getYhbh());
		rz.setCzr((String) session.getAttribute("UserName"));
		rz.setCzsj(new Date());
		rzService.Insert(rz);
		return "redirect:findAll.action";
	}
	
	@RequestMapping("/updateYh")
	public String updateYh(YhMessage yhMessage,HttpServletRequest request,HttpSession session){
		
		yhMessageService.updateYh(yhMessage);
		rz =new Rz();
		rz.setCz("修改用户"+yhMessage.getYhbh());
		rz.setCzr((String) session.getAttribute("UserName"));
		rz.setCzsj(new Date());
		rzService.Insert(rz);
		return"redirect:findAll.action";
	}
	
	@ResponseBody
	@RequestMapping("deleteYh")
	public JSONObject deleteGd(int id,HttpSession session){
		JSONObject json=new JSONObject();
		yhMessageService.deleteYh(id);
		rz =new Rz();
		rz.setCz("删除用户");
		rz.setCzr((String) session.getAttribute("UserName"));
		rz.setCzsj(new Date());
		rzService.Insert(rz);
		json.put("del","1");
		return json;
		
	}
	
	@ResponseBody
	@RequestMapping("findByTerm")
	public JSONObject findByTerm(String yhbh,String yhxm,String xqm,HttpSession session){
		JSONObject json=new JSONObject();
		
		
		json.put("yhLsitSer",yhMessageService.findByTerm(yhbh, yhxm, xqm));
		return json;
		
	}
	
	@ResponseBody
	@RequestMapping("findXqm")
	public JSONObject findXqm(String yhbh,String yhxm,String xqm,HttpSession session){
		JSONObject json=new JSONObject();
		json.put("findXqm",yhMessageService.findXqm());
		return json;
		
	}

}