package com.hnzy.hot.controller;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hnzy.hot.pojo.Rz;
import com.hnzy.hot.service.JfService;
import com.hnzy.hot.service.RzService;
import com.hnzy.hot.service.YhMessageService;

import net.sf.json.JSONObject;



@Controller
@RequestMapping("jf")
public class JfController {
	
	@Autowired
	private JfService jfService;
	
	@Autowired
	private RzService rzService;
	@Autowired
	private YhMessageService yhMessageService;
	private Rz rz;
	
	
	
	//更新缴费及合计金额
		@RequestMapping("update")
		
		public String update(HttpSession session,Integer byf,String yzbh, String syje,String jfje,String hjje,Integer type,String grsj){
			String userName=(String)session.getAttribute("UserName");
			JSONObject jsonObject =new JSONObject();
			if( hjje!=null&&yzbh!=null&& jfje!=null &&hjje!=null ){
			double hj=Double.parseDouble(jfje)+Double.parseDouble(hjje);
			
			double sy=Double.parseDouble(syje)+Double.parseDouble(jfje);
			System.out.println("jfje--"+jfje+"syje--"+sy+"hjje--"+hj);
			String[] times=grsj.split("~");
			String startTime=times[0];
			String endTime=times[0];
			//更新缴费表
			jfService.updateJfHjje(yzbh, jfje,String.valueOf(sy), String.valueOf(hj),new Date(),userName,type, startTime, endTime);
			//插入缴费历史表        outtradeno订单
			String outtradeno= System.currentTimeMillis()+yzbh; // 1000
			jfService.InsertJfHistory(yzbh,jfje,Double.toString(sy),Double.toString(hj), new Date(), userName,type, startTime, endTime,outtradeno);
			rz =  new Rz();
			rz.setCz(yzbh+"用户缴费,缴费金额："+jfje+" 剩余金额:"+sy+" 合计金额"+hj);
			rz.setCzr(userName);
			rz.setCzsj(new Date());
			rzService.Insert(rz);
			jsonObject.put("js","success");
			}else{
				jsonObject.put("js","error");
			}
			return "redirect:jfgl.action";
		}
		
		
				//更新缴费及合计金额
				@SuppressWarnings("unused")
				@RequestMapping("updatejf")
				@ResponseBody
				public JSONObject updatejf(String arr[],HttpSession session){
					String userName=(String)session.getAttribute("UserName");
					System.out.println("userNAME---"+userName);
					JSONObject jsonObject =new JSONObject();
					String byf=arr[0];
					String yzbh=arr[1];
					String grsj=arr[2];
					String syje=arr[3];
					String jfje=arr[4];
					String hjje=arr[5];
					String types=arr[6];
					System.out.println("jfje--"+jfje);
					if( hjje!=""&&yzbh!=""&& jfje!="" &&hjje!=""&& types!="" &&userName!=null){
						Integer type=Integer.valueOf(types);
					double hj=Double.parseDouble(jfje)+Double.parseDouble(hjje);
					double sy=Double.parseDouble(syje)+Double.parseDouble(jfje);
					System.out.println("jfje--"+jfje+"syje--"+sy+"hjje--"+hj);
					String[] times=grsj.split("~");
					String startTime=times[0];
					String endTime=times[0];
					//更新缴费表
					jfService.updateJfHjje(yzbh, jfje,String.valueOf(sy), String.valueOf(hj),new Date(),userName,type, startTime, endTime);
					//插入缴费历史表        outtradeno订单
					String outtradeno= System.currentTimeMillis()+yzbh; // 1000
					jfService.InsertJfHistory(yzbh,jfje,Double.toString(sy),Double.toString(hj), new Date(), userName,type, startTime, endTime,outtradeno);
					rz =  new Rz();
					rz.setCz(yzbh+"用户缴费,缴费金额："+jfje+" 剩余金额:"+sy+" 合计金额"+hj);
					rz.setCzr(userName);
					rz.setCzsj(new Date());
					rzService.Insert(rz);
					jsonObject.put("js","0");
					}else{
						jsonObject.put("js","2");
					}
					return jsonObject;
				}
		
		@RequestMapping("Search")
		@ResponseBody
		public JSONObject Search(String xqm,String ldh,String dyh,String hh,Integer type) throws UnsupportedEncodingException{
			if(xqm!=null&&("").equals(xqm)==false){
				xqm=new String(xqm.getBytes("ISO-8859-1"),"utf-8")+"";
			}
			
			JSONObject jsonObject=new JSONObject();
			
			List<Map<String, String>> jfs;
			jfs=jfService.find(xqm, ldh, dyh, hh,type);
			jsonObject.put("jfs",jfs);
			jsonObject.put("jrbs",jfService.findJfbs());
			jsonObject.put("jfje",jfService.findJfzje());
			jsonObject.put("bzjrbs",jfService.findBzJfbs());
			jsonObject.put("bzjfje",jfService.findBzJfzje());
			jsonObject.put("dj",jfService.findDj());
			return jsonObject;
			
		}
		
		@RequestMapping("SearchJf")
		@ResponseBody
		public JSONObject SearchJf(String xqm,String ldh,String dyh,String hh,Integer type) throws UnsupportedEncodingException{
			if(xqm!=null&&("").equals(xqm)==false){
				xqm=new String(xqm.getBytes("ISO-8859-1"),"utf-8")+"";
			}
			
			JSONObject jsonObject=new JSONObject();
			
			List<Map<String, String>> jfs;
			jfs=jfService.find(xqm, ldh, dyh, hh,type);
			jsonObject.put("jfs",jfs);
			return jsonObject;
			
		}
		
		//首页
		@ResponseBody
		@RequestMapping("findXqm")
		public JSONObject findXqm(String yhbh,String yhxm,String xqm,HttpSession session){
			JSONObject json=new JSONObject();
			json.put("findXqm",yhMessageService.findXqm());
			return json;
			
		}
		
		//查询楼栋
			@RequestMapping("findLd")
			@ResponseBody
			public JSONObject findLd( String xqm) throws UnsupportedEncodingException{
				JSONObject json=new JSONObject();
				xqm=new String(xqm.getBytes("ISO-8859-1"),"utf-8");
				json.put("Ld", yhMessageService.findLd(xqm));
				return json;
			}
			
			

			@RequestMapping("findDy")
			@ResponseBody
			public JSONObject findDy(String xqm,String ldh) throws UnsupportedEncodingException{
				JSONObject json=new JSONObject();
				xqm=new String(xqm.getBytes("ISO-8859-1"),"utf-8");
				json.put("Dy", yhMessageService.findDy(xqm,ldh));
				return json;
			}
		
		@RequestMapping("/jfgl")
    	public String jfgl(){
    		return "/jfgl";
    	}
		
		@RequestMapping("/jfls")
    	public String jfls(){
    		return "/jfls";
    	}
		
		@RequestMapping("findJfls")
		@ResponseBody
		public JSONObject findJfls() throws UnsupportedEncodingException{
			
			
			JSONObject jsonObject=new JSONObject();
			
			List<Map<String, String>> jfs;
			jfs=jfService.findHistory();
			jsonObject.put("jfs",jfs);

			return jsonObject;
			
		}
}