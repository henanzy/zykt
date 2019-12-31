package com.hnzy.hot.controller;

 
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.hnzy.hot.pojo.Data;
import com.hnzy.hot.pojo.Rz;
import com.hnzy.hot.pojo.YhMessage;
import com.hnzy.hot.service.DataService;
import com.hnzy.hot.service.RzService;
import com.hnzy.hot.service.YhMessageService;
import com.hnzy.socket.server.ServerSessionMap;
import com.hnzy.socket.util.CzUtil;
import com.hnzy.socket.util.MapUtilsDf;
 
@Controller
@RequestMapping("/Data")
public class DataController {
	 
	@Autowired
	private DataService dataService;
 
	@Autowired
	private RzService rzService;
	@Autowired
	private YhMessageService yhMessageService;
	
	public String fs;
	private static Log log = LogFactory.getLog(DataController.class);
	public List<Data> YhList;
	public List<Data> BjList;//报警
	Data jszl=new Data();
	String  fpdzS;
	 String kgString="";
	 String jfString="";
	 String jjString="";
	 String ja ;
	   YhMessage yh;
		//层管地址
		String cgbh;
		String cg;
		String ip;
		String port;
		boolean sessionmap;
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
		
		//设备管理
		@RequestMapping("/dataSbgls")
		@ResponseBody
		public JSONObject Sbgls(HttpServletRequest request,String xqm,String ldh,String dyh,
				String hh) throws UnsupportedEncodingException  {
			//yhInfoList=yhMessageService.findXqName();
			if(xqm!=null&&("").equals(xqm)==false){
				xqm=new String(xqm.getBytes("ISO-8859-1"),"utf-8")+"";
			}
			JSONObject jsonObject=new JSONObject();
//			Integer d=dataService.findFpNum(xqm);
//			Integer dd=dataService.findYhNum(xqm);
			jsonObject.put("fpNum",dataService.findFpNum(xqm));
			jsonObject.put("yhNum",dataService.findYhNum(xqm));
//			List<Map<String, String>> y=dataService.finds();
			jsonObject.put("YhList",dataService.finds());
			return jsonObject;
		}
		
	
	//设备管理
	@RequestMapping("/dataSbgl")
	@ResponseBody
	public JSONObject Sbgl(HttpServletRequest request,String xqm,String ldh,String dyh,
			String hh) throws UnsupportedEncodingException  {
		//yhInfoList=yhMessageService.findXqName();
		if(xqm!=null&&("").equals(xqm)==false){
			xqm=new String(xqm.getBytes("ISO-8859-1"),"utf-8")+"";
		}
		
		
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("fpNum",dataService.findFpNum(xqm));
		jsonObject.put("yhNum",dataService.findYhNum(xqm));
//	List<Map<String, Object>> s=	dataService.find(xqm, ldh, dyh, hh);
		jsonObject.put("YhList",dataService.find(xqm, ldh, dyh, hh));
		return jsonObject;
	}
	
	//风盘使用的数
	@RequestMapping("/findYhSy")
	@ResponseBody
	public JSONObject findYhSy(HttpServletRequest request,String xqm,String ldh,String dyh,
			String hh) throws UnsupportedEncodingException  {
		//yhInfoList=yhMessageService.findXqName();
		if(xqm!=null&&("").equals(xqm)==false){
			xqm=new String(xqm.getBytes("ISO-8859-1"),"utf-8")+"";
		}
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("fpNum",dataService.findFpNum(xqm));
		jsonObject.put("yhNum",dataService.findYhNum(xqm));
//	List<Map<String, Object>> s=	dataService.find(xqm, ldh, dyh, hh);
		jsonObject.put("YhList",dataService.findYhSy(xqm));
		return jsonObject;
	}
		
	
	//搜索并显示
	@RequestMapping("searchInfo")
	@ResponseBody
	public JSONObject searchInfo(HttpServletRequest request,String xqm,String ldh,
					String dyh,String hh,String time1,String time2) throws UnsupportedEncodingException{
		JSONObject jsonObject=new JSONObject();
		if(xqm!=null&&("").equals(xqm)==false){
			xqm=new String(xqm.getBytes("ISO-8859-1"),"utf-8")+"";
		}
		
	   List<Map<String, String>> list=dataService.searchInfo(xqm, ldh, dyh, hh, time1,time2);
			 
			jsonObject.put("list",list);

		
			return jsonObject;		
		}
	
	//单个抄表
	@RequestMapping("CxState")
	@ResponseBody
	public JSONObject CxState(HttpSession session,String yhbh,String fpdz,String kg,String jf,String jj){
		String	fp=Integer.toHexString(Integer.valueOf(fpdz));
		if(fp.length()==1){
		  fpdzS="0"+fp;
		}
		MapUtilsDf.getMapUtils().add("cbfs",yhbh);
		MapUtilsDf.getMapUtils().add("cbstate",null);
		 yh=yhMessageService.findch(yhbh, fpdz);
		 
		String ld= Integer.toHexString(Integer.valueOf(yh.getLdh()));
		String dy=Integer.toHexString(Integer.valueOf(yh.getDyh()));
		if(dy.length()==1){
			dy="0"+dy;
		}
		if(ld.length()==1){
			ld="0"+ld;
		}
		//根据用户编码和风盘地址查找层管编号
		System.out.println(kg);
//		Rz rz=new Rz();
		 if(kg.equals("00")){
			 kgString="强关";
		 }else if(kg.equals("01")){
			 kgString="自动"; 
		 }else{
			 kgString="";  
		 }
		 if(jf.equals("00")){
			 jfString="禁止计费";
		 }else if(jf.equals("01")){
			 jfString="允许计费";
		 }
		 if(jj.equals("00")){
			 jjString="夏季";
		 }else if(jj.equals("01")){
			 jjString="冬季";
		 }
			
		
		//用户小区号
		String xqh=yh.getXqh();
		//用户编号
		 String yhbhs = Integer.toHexString(Integer.valueOf(yhbh));//16进制  
		if(xqh!=null){
			//层管地址
			 cg=Integer.toHexString(Integer.valueOf(yh.getCh()));
			 if(cg.length()==1){
				 cg="0"+cg;
			 }
			 ip=yh.getJzqip();
			 port=yh.getJzqport();
			
			xqh = Integer.toHexString(Integer.valueOf(xqh));//16进制  
			if(xqh.length()==1){
				xqh=0+xqh;
			}
			 ja ="F014B5"+xqh+ld+"00"+ld+dy+cg+yhbhs+fpdzS+kg+jf+jj+"FFFF";//起始到结束  01终端	
			 System.out.println("新小区一户发送指令："+ja);
//			 rz.setCz("对某户 楼栋号："+ld+"单元号："+dy+"风盘地址:"+fpdzS+"开关"+kgString+"计费"+jfString+"季节"+jjString+"操作发送指令");
			 String pt = "/" + ip + ":" + port; 
			System.out.println("ja--抄表发送数据-----"+pt);
			 sessionmap = czs(ja, pt);
		}else{
			 yh=yhMessageService.findCg(yhbh, fpdz);
			//层管地址
			 cgbh=yh.getCgbh();
			 cg=cgbh.substring(4);
			 ip=yh.getJzqip();
			 port=yh.getJzqport();
			 ja =ld+dy+"F010B5"+cg+""+yhbhs+fpdzS+ld+dy+"FFFFFFFF";//起始到结束  01终端	
			 System.out.println("一户："+ja);
//			 rz.setCz("对某户 楼栋号："+ld+"单元号："+dy+"风盘地址:"+fpdzS+"操作发送指令");
			 String pt = "/" + ip + ":" + port; 
			 System.out.println("ja--抄表发送数据-----"+ja);
			 sessionmap = cz(ja, pt);
		}
		
//		rz.setCzr((String)session.getAttribute("UserName"));
//		rz.setCzsj(new Date());
//		rzService.Insert(rz);
		
		 log.info("抄表发送数据---："+ja);
		 try {
			 	Thread.sleep(4000);
			 } catch (InterruptedException e) {
			 	e.printStackTrace();
			 }
		JSONObject js=new JSONObject();
		if(sessionmap==true&&null!=MapUtilsDf.getMapUtils().get("cbstate")&& MapUtilsDf.getMapUtils().get("cbstate").equals(yhbh)){
			MapUtilsDf.getMapUtils().add("cbstate",null);
			MapUtilsDf.getMapUtils().add("cbfs",null);
			js.put("js", 0);
		}else if(sessionmap==false){
			js.put("js", 2);
		}else{
			MapUtilsDf.getMapUtils().add("cbstate",null);
			MapUtilsDf.getMapUtils().add("cbfs",null);
			js.put("js",1);
		}
	  return js;
	}
	
	
	
	//对层抄表
		@RequestMapping("ChCbState")
		@ResponseBody
		public JSONObject ChCbState(HttpSession session,String yhbh,String fpdz){

			String	fp=Integer.toHexString(Integer.valueOf(fpdz));
			if(fp.length()==1){
			  fpdzS="0"+fp;
			}
			MapUtilsDf.getMapUtils().add("cbfs",yhbh);
			MapUtilsDf.getMapUtils().add("cbstate",null);
			 yh=yhMessageService.findch(yhbh, fpdz);
			 
			String ld= Integer.toHexString(Integer.valueOf(yh.getLdh()));
			String dy=Integer.toHexString(Integer.valueOf(yh.getDyh()));
			if(dy.length()==1){
				dy="0"+dy;
			}
			if(ld.length()==1){
				ld="0"+ld;
			}
			//根据用户编码和风盘地址查找层管编号
//			Rz rz=new Rz();
			//用户小区号
			String xqh=yh.getXqh();
			System.out.println("-------xqh----------"+xqh);
			//用户编号
			if(xqh!=null){
				//层管地址
				 cg=Integer.toHexString(Integer.valueOf(yh.getCh()));
				 if(cg.length()==1){
					 cg="0"+cg;
				 }
				 System.out.println("-------------cg--"+cg);
				 ip=yh.getJzqip();
				 port=yh.getJzqport();
				
				xqh = Integer.toHexString(Integer.valueOf(xqh));//16进制  
				if(xqh.length()==1){
					xqh=0+xqh;
				}
				 ja ="F010B7"+xqh+ld+"00"+ld+dy+cg+"FFFFFFFFFF";//起始到结束01终端	
				 System.out.println("新小区层抄表发送指令："+ja);
//				 rz.setCz("新小区层抄表发送指令");
				 String pt = "/" + ip + ":" + port; 
				System.out.println("ja--新小区层抄表发送数据-----"+pt);
				 sessionmap = czs(ja, pt);
			}
			
//			rz.setCzr((String)session.getAttribute("UserName"));
//			rz.setCzsj(new Date());
//			rzService.Insert(rz);
			
			 log.info("层抄表发送数据---："+ja);
			 try {
				 	Thread.sleep(5000);
				 } catch (InterruptedException e) {
				 	e.printStackTrace();
				 }
			JSONObject js=new JSONObject();
			if(sessionmap==true&&null!=MapUtilsDf.getMapUtils().get("cbstate")){
				MapUtilsDf.getMapUtils().add("cbstate",null);
				MapUtilsDf.getMapUtils().add("cbfs",null);
				js.put("js", 0);
			}else{
				MapUtilsDf.getMapUtils().add("cbstate",null);
				MapUtilsDf.getMapUtils().add("cbfs",null);
				js.put("js",1);
			}
		  return js;
		}
		
		
		
		
		//单个风盘存储
				@RequestMapping("ChCcxx")
				@ResponseBody
				public JSONObject ChCcxx(HttpSession session,String yhbh,String fpdz){

					String	fp=Integer.toHexString(Integer.valueOf(fpdz));
					if(fp.length()==1){
					  fpdzS="0"+fp;
					}
					MapUtilsDf.getMapUtils().add("ccfs",yhbh);
					MapUtilsDf.getMapUtils().add("ccstate",null);
					 yh=yhMessageService.findch(yhbh, fpdz);
					 
					String ld= Integer.toHexString(Integer.valueOf(yh.getLdh()));
					String dy=Integer.toHexString(Integer.valueOf(yh.getDyh()));
					if(dy.length()==1){
						dy="0"+dy;
					}
					if(ld.length()==1){
						ld="0"+ld;
					}
					//根据用户编码和风盘地址查找层管编号
//					Rz rz=new Rz();
					//用户小区号
					String xqh=yh.getXqh();
					System.out.println("-------xqh----------"+xqh);
					if(xqh!=null){
						//层管地址
						 cg=Integer.toHexString(Integer.valueOf(yh.getCh()));
						 if(cg.length()==1){
							 cg="0"+cg;
						 }
						 System.out.println("-------------cg--"+cg);
						 ip=yh.getJzqip();
						 port=yh.getJzqport();
						
						xqh = Integer.toHexString(Integer.valueOf(xqh));//16进制  
						if(xqh.length()==1){
							xqh=0+xqh;
						}
						//出厂编号
						 String ccbh=Integer.toHexString(Integer.valueOf(yh.getCcbh()));
						 
						 ja ="F014B6"+xqh+ld+"00"+ld+dy+cg+"00"+ccbh+yhbh+fpdz+"FF";//起始到结束01终端	
//						 rz.setCz("新小区单个风盘存储发送指令");
						 String pt = "/" + ip + ":" + port; 
						System.out.println("ja--新小区单个风盘存储发送数据-----"+pt);
						 sessionmap = czs(ja, pt);
					}
					
//					rz.setCzr((String)session.getAttribute("UserName"));
//					rz.setCzsj(new Date());
//					rzService.Insert(rz);
					
					 log.info("单个风盘存储发送数据---："+ja);
					 try {
						 	Thread.sleep(4000);
						 } catch (InterruptedException e) {
						 	e.printStackTrace();
						 }
					JSONObject js=new JSONObject();
					if(sessionmap==true&&null!=MapUtilsDf.getMapUtils().get("ccstate")){
						MapUtilsDf.getMapUtils().add("cbfs",null);
						String ccstate=MapUtilsDf.getMapUtils().get("ccstate");
						js.put("ccstate",ccstate);
						js.put("js", 0);
					}else{
						MapUtilsDf.getMapUtils().add("ccstate",null);
						MapUtilsDf.getMapUtils().add("cbfs",null);
						js.put("js",1);
					}
				  return js;
				}
		
		
		//对层更改周期
			@RequestMapping("cgzq")
			@ResponseBody
			public JSONObject cgzq(HttpSession session,String yhbh,String fpdz,String zq){

				String	fp=Integer.toHexString(Integer.valueOf(fpdz));
				if(fp.length()==1){
				  fpdzS="0"+fp;
				}
				 yh=yhMessageService.findch(yhbh, fpdz);
				String ld= Integer.toHexString(Integer.valueOf(yh.getLdh()));
				String dy=Integer.toHexString(Integer.valueOf(yh.getDyh()));
				if(dy.length()==1){
					dy="0"+dy;
				}
				if(ld.length()==1){
					ld="0"+ld;
				}
				
				if(zq.length()==1){
					zq="0"+zq;
				}
				MapUtilsDf.getMapUtils().add("zqfs",zq);
				MapUtilsDf.getMapUtils().add("zqstate",null);
				//根据用户编码和风盘地址查找层管编号
				Rz rz=new Rz();
				//用户小区号
				String xqh=yh.getXqh();
				System.out.println("-------xqh----------"+xqh);
				//用户编号
				if(xqh!=null){
					//层管地址
					 cg=Integer.toHexString(Integer.valueOf(yh.getCh()));
					 if(cg.length()==1){
						 cg="0"+cg;
					 }
					 System.out.println("-------------cg--"+cg);
					 ip=yh.getJzqip();
					 port=yh.getJzqport();
					
					xqh = Integer.toHexString(Integer.valueOf(xqh));//16进制  
					if(xqh.length()==1){
						xqh=0+xqh;
					}
					 ja ="F010B7"+xqh+ld+"00"+ld+dy+cg+"FF"+zq+"FFFFFF";//起始到结束01终端	
					 System.out.println("新对层更改周期发送指令："+ja);
					 rz.setCz("新对层更改周期发送指周期为："+zq);
					 String pt = "/" + ip + ":" + port; 
					System.out.println("ja--新对层更改周期发送指据-----"+pt);
					 sessionmap = czs(ja, pt);
				}
				
				rz.setCzr((String)session.getAttribute("UserName"));
				rz.setCzsj(new Date());
				rzService.Insert(rz);
				
				 log.info("新对层更改周期发送指据---："+ja);
				 try {
					 	Thread.sleep(4000);
					 } catch (InterruptedException e) {
					 	e.printStackTrace();
					 }
				JSONObject js=new JSONObject();
				if(sessionmap==true&&null!=MapUtilsDf.getMapUtils().get("zqstate")&& MapUtilsDf.getMapUtils().get("zqstate").equals(zq)){
					MapUtilsDf.getMapUtils().add("zqstate",null);
					MapUtilsDf.getMapUtils().add("zqfs",null);
					js.put("js", 0);
				}else{
					MapUtilsDf.getMapUtils().add("zqstate",null);
					MapUtilsDf.getMapUtils().add("zqfs",null);
					js.put("js",1);
				}
			  return js;
			}
		
		
	
	//某户所有设置
		@RequestMapping("CxHState")
		@ResponseBody
		public JSONObject CxHState(HttpSession session,String yhbh,String fpdz,String kg,String jf,String jj){
			MapUtilsDf.getMapUtils().add("kgstate",null);
			MapUtilsDf.getMapUtils().add("kgfs",yhbh);
			 yh=yhMessageService.findch(yhbh, fpdz);
			String ld= Integer.toHexString(Integer.valueOf(yh.getLdh()));
			String dy=Integer.toHexString(Integer.valueOf(yh.getDyh()));
			if(dy.length()==1){
				dy="0"+dy;
			}
			if(ld.length()==1){
				ld="0"+ld;
			}
			//根据用户编码和风盘地址查找层管编号
			System.out.println(kg);
			Rz rz=new Rz();
			 if(kg.equals("00")){
				 kgString="强关";
			 }else if(kg.equals("01")){
				 kgString="自动"; 
			 }else{
				 kgString="";  
			 }
			 if(jf.equals("00")){
				 jfString="禁止计费";
			 }else if(jf.equals("01")){
				 jfString="允许计费";
			 }
			 if(jj.equals("00")){
				 jjString="夏季";
			 }else if(jj.equals("01")){
				 jjString="冬季";
			 }
			
			//用户小区号
			String xqh=yh.getXqh();
			System.out.println("-------xqh----------"+xqh);
			//用户编号
			 String yhbhs = Integer.toHexString(Integer.valueOf(yhbh));//16进制  
			if(xqh!=null){
				//层管地址
				 cg=Integer.toHexString(Integer.valueOf(yh.getCh()));
				 if(cg.length()==1){
					 cg="0"+cg;
				 }
				 System.out.println("-------------cg--"+cg);
				 ip=yh.getJzqip();
				 port=yh.getJzqport();
				
				xqh = Integer.toHexString(Integer.valueOf(xqh));//16进制  
				if(xqh.length()==1){
					xqh=0+xqh;
				}
				 ja ="F014B1"+xqh+ld+"00"+ld+dy+cg+yhbhs+"FF"+kg+jf+jj+"FFFF";
				 System.out.println("新小区一户所有户发送指令："+ja);
				 rz.setCz("对某户 楼栋号："+ld+"单元号："+dy+"风盘地址:"+fpdzS+"开关"+kgString+"计费"+jfString+"季节"+jjString+"操作发送指令");
				 String pt = "/" + ip + ":" + port; 
				System.out.println("ja--抄表发送数据-----"+pt);
				 sessionmap = czs(ja, pt);
			}else{
				 yh=yhMessageService.findCg(yhbh, fpdz);
				//层管地址
				 cgbh=yh.getCgbh();
				 cg=cgbh.substring(4);
				 ip=yh.getJzqip();
				 port=yh.getJzqport();
				 ja =ld+dy+"F010B1"+cg+""+yhbhs+"FF"+""+kg+""+jf+""+jj+ld+dy+"FF";
				 System.out.println("一户："+ja);
				 rz.setCz("对某户 楼栋号："+ld+"单元号："+dy+"风盘地址:"+fpdzS+"操作发送指令");
				 String pt = "/" + ip + ":" + port; 
				 System.out.println("ja--抄表发送数据-----"+ja);
				 sessionmap = cz(ja, pt);
			}
			
			rz.setCzr((String)session.getAttribute("UserName"));
			rz.setCzsj(new Date());
			rzService.Insert(rz);
			
			 log.info("抄表发送数据---："+ja);
			 try {
				 	Thread.sleep(5000);
				 } catch (InterruptedException e) {
				 	e.printStackTrace();
				 }
//			 SimpleDateFormat Sdate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//			  	jszl.setTime(Sdate.format(new Date()));
			JSONObject js=new JSONObject();
			if(sessionmap==true&&null!=MapUtilsDf.getMapUtils().get("kgstate")&& MapUtilsDf.getMapUtils().get("kgstate").equals(yhbh)){
				MapUtilsDf.getMapUtils().add("kgstate",null);
				MapUtilsDf.getMapUtils().add("kgfs",null);
				js.put("js", 0);
			}else{
				MapUtilsDf.getMapUtils().add("kgstate",null);
				MapUtilsDf.getMapUtils().add("kgfs",null);
				js.put("js",1);
			}
		  return js;
		}
	// ---------------------单个风盘操作开关---------
	  	@RequestMapping("DCxZx")
		@ResponseBody
		public JSONObject DCxZx(HttpSession session,String yhbh,String fpdz,String kg,String jf,String jj){
			MapUtilsDf.getMapUtils().add("kgstate",null);
			MapUtilsDf.getMapUtils().add("kgfs",yhbh);
			// 根据用户编码和风盘地址查找用户
			String	fp=Integer.toHexString(Integer.valueOf(fpdz));
			if(fp.length()==1){
			  fpdzS="0"+fp;
			}
			yh=yhMessageService.findch(yhbh, fpdz);
			String ld=yh.getLdh();
			String dy=yh.getDyh();
			if(dy.length()==1){
				dy="0"+dy;
			}
			if(ld.length()==1){
				ld="0"+ld;
			}
		
			//用户小区号
			String xqh=yh.getXqh();
			System.out.println("小区号---------"+xqh);
			//用户编号
			String yhbhs = Integer.toHexString(Integer.valueOf(yhbh));//16进制  
			//根据小区号分类
			if(xqh!=null){
				//层管地址
				 cg=Integer.toHexString(Integer.valueOf(yh.getCh()));
				 if(cg.length()==1){
					 cg="0"+cg;
				 }
				 if(xqh.length()==1){
					 xqh="0"+xqh;
				 }
				 ip=yh.getJzqip();
				 port=yh.getJzqport();
			    ja ="F014B1"+xqh+ld+"00"+ld+dy+cg+yhbhs+fpdzS+kg+jf+jj+"FFFF";
				System.out.println("新开关指令---"+ja); 
				System.out.println("ja--单个风盘开关-------"+ja);
				 // IP地址和端口号
				 String pt = "/" + ip + ":" + port;
				  sessionmap = czs(ja, pt);	
				    try {
					 	Thread.sleep(1000);
					 } catch (InterruptedException e) {
					 	e.printStackTrace();
					 }
				    //抄表
				  ja ="F014B5"+xqh+ld+"00"+ld+dy+cg+yhbhs+fpdzS+"FFFFFFFFFF";//起始到结束  01终端
				  sessionmap = czs(ja, pt);	
			}else{
				
				 yh=yhMessageService.findCg(yhbh, fpdz);
				//层管地址
				 cgbh=yh.getCgbh();
				 cg=cgbh.substring(4);
				 ip=yh.getJzqip();
				 port=yh.getJzqport();
			 //空调状态
			  ja =ld+dy+"F010B1"+cg+""+yhbhs+fpdzS+""+kg+""+jf+""+jj+ld+dy+"FF";
			  System.out.println("老指令："+ja);
			  System.out.println("ja--单个风盘开关-------"+ja);
				// IP地址和端口号
			  String pt = "/" + ip + ":" + port;
			  sessionmap = cz(ja, pt);	
			}
			 log.info("对某户单个 风盘开关计费季节操作发送指令 ："+ja);
			//日志
			 if(kg.equals("00")){
				 kgString="强关";
			 }else if(kg.equals("01")){
				 kgString="自动"; 
			 }else{
				 kgString="";  
			 }
			 if(jf.equals("00")){
				 jfString="禁止计费";
			 }else if(jf.equals("01")){
				 jfString="允许计费";
			 }
			 if(jj.equals("00")){
				 jjString="夏季";
			 }else if(jj.equals("01")){
				 jjString="冬季";
			 }
			 
			    try {
				 	Thread.sleep(3000);
				 } catch (InterruptedException e) {
				 	e.printStackTrace();
				 }
				 SimpleDateFormat Sdate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			  	jszl.setTime(Sdate.format(new Date()));
				Rz rz=new Rz();
				rz.setCz("对单户 风盘开关计费季节操作,楼栋号："+ld+",单元号："+dy+",风盘地址："+fpdz+",开关:"+kgString+",计费："+jfString+",季节："+jjString);
				rz.setCzr((String)session.getAttribute("UserName"));
				rz.setCzsj(new Date());
				rzService.Insert(rz);
				JSONObject js=new JSONObject();
				if(sessionmap==true&&null!=MapUtilsDf.getMapUtils().get("kgstate")&& MapUtilsDf.getMapUtils().get("kgstate").equals(yhbh)){
					MapUtilsDf.getMapUtils().add("kgstate",null);
					MapUtilsDf.getMapUtils().add("kgfs",null);
					js.put("js", 0);
				}else{
					MapUtilsDf.getMapUtils().add("kgstate",null);
					MapUtilsDf.getMapUtils().add("kgfs",null);
					js.put("js",1);
				}
			  return js;
	    	} 
	  	
	  	
	  //某层开关
		@RequestMapping("CxCState")
		@ResponseBody
		public JSONObject CxCState(HttpSession session,String yhbh,String fpdz,String kg,String jf,String jj){
			String	fp=Integer.toHexString(Integer.valueOf(fpdz));
			if(fp.length()==1){
			  fpdzS="0"+fp;
			}
			 yh=yhMessageService.findch(yhbh, fpdz);
			MapUtilsDf.getMapUtils().add("kgstate",null);
			MapUtilsDf.getMapUtils().add("kgfs",yhbh);
			String ld= Integer.toHexString(Integer.valueOf(yh.getLdh()));
			String dy=Integer.toHexString(Integer.valueOf(yh.getDyh()));
			if(dy.length()==1){
				dy="0"+dy;
			}
			if(ld.length()==1){
				ld="0"+ld;
			}
			//根据用户编码和风盘地址查找层管编号
			System.out.println(kg);
			Rz rz=new Rz();
			 if(kg.equals("00")){
				 kgString="强关";
			 }else if(kg.equals("01")){
				 kgString="自动"; 
			 }else{
				 kgString="";  
			 }
			 if(jf.equals("00")){
				 jfString="禁止计费";
			 }else if(jf.equals("01")){
				 jfString="允许计费";
			 }
			 if(jj.equals("00")){
				 jjString="夏季";
			 }else if(jj.equals("01")){
				 jjString="冬季";
			 }
			//用户小区号
			String xqh=yh.getXqh();
			System.out.println("-------xqh----------"+xqh);
			//用户编号
			if(xqh!=null){
				//层管地址
				 cg=Integer.toHexString(Integer.valueOf(yh.getCh()));
				 if(cg.length()==1){
					 cg="0"+cg;
				 }
				 ip=yh.getJzqip();
				 port=yh.getJzqport();
				
				xqh = Integer.toHexString(Integer.valueOf(xqh));//16进制  
				if(xqh.length()==1){
					xqh=0+xqh;
				}
				ja ="F014B1"+xqh+ld+"00"+ld+dy+cg+"F0F0F0FF"+kg+jf+jj+"FFFF";
				 System.out.println("新小区一户发送指令："+ja);
				 rz.setCz("对某层  楼栋号："+ld+"单元号："+dy+"风盘地址:"+fpdzS+"开关"+kgString+"计费"+jfString+"季节"+jjString+"操作发送指令");
				 String pt = "/" + ip + ":" + port; 
				System.out.println("ja--抄表发送数据-----"+pt);
				 sessionmap = czs(ja, pt);
			}else{
				 yh=yhMessageService.findCg(yhbh, fpdz);
					//层管地址
					 cgbh=yh.getCgbh();
					 cg=cgbh.substring(4);
					 ip=yh.getJzqip();
					 port=yh.getJzqport();
				 //空调状态
//				  ja =ld+dy+"F010B1"+cg+""+yhbhs+fpdzS+""+kg+""+jf+""+jj+ld+dy+"FF";
				  String ja =ld+dy+"F010B1"+cg+"F0F0F0FF"+kg+""+jf+""+jj+ld+dy+"FF";
				  System.out.println("老指令："+ja);
				  System.out.println("ja--某层风盘开关-------"+ja);
					// IP地址和端口号
				  String pt = "/" + ip + ":" + port;
				  sessionmap = cz(ja, pt);	
				
			}
			
			rz.setCzr((String)session.getAttribute("UserName"));
			rz.setCzsj(new Date());
			rzService.Insert(rz);
			
			 log.info("某层设置发送数据---："+ja);
			 try {
				 	Thread.sleep(5000);
				 } catch (InterruptedException e) {
				 	e.printStackTrace();
				 }
			JSONObject js=new JSONObject();
			if(sessionmap==true&&null!=MapUtilsDf.getMapUtils().get("ch")&& MapUtilsDf.getMapUtils().get("ch").equals(cg)){
				MapUtilsDf.getMapUtils().add("kgstate",null);
				MapUtilsDf.getMapUtils().add("kgfs",null);
				js.put("js", 0);
			}else{
				MapUtilsDf.getMapUtils().add("kgstate",null);
				MapUtilsDf.getMapUtils().add("kgfs",null);
				js.put("js",1);
			}
		  return js;
		}
		
		      //对集中器抄表
				@RequestMapping("QyjzqFp")
				@ResponseBody
			 	public JSONObject QyjzqFp(HttpSession session,String yhbh,String fpdz){
					String	fp=Integer.toHexString(Integer.valueOf(fpdz));
					if(fp.length()==1){
					  fpdzS="0"+fp;
					}
					MapUtilsDf.getMapUtils().add("cbfs",yhbh);
					MapUtilsDf.getMapUtils().add("cbstate",null);

					 yh=yhMessageService.findch(yhbh, fpdz);
					String ld= Integer.toHexString(Integer.valueOf(yh.getLdh()));
					String dy=Integer.toHexString(Integer.valueOf(yh.getDyh()));
					if(dy.length()==1){
						dy="0"+dy;
					}
					if(ld.length()==1){
						ld="0"+ld;
					}
						
					//用户小区号
					String xqh=yh.getXqh();
					//用户编号
					if(xqh!=null){
						//层管地址
						 cg=Integer.toHexString(Integer.valueOf(yh.getCh()));
						 if(cg.length()==1){
							 cg="0"+cg;
						 }
						 ip=yh.getJzqip();
						 port=yh.getJzqport();
						
						xqh = Integer.toHexString(Integer.valueOf(xqh));//16进制  
						if(xqh.length()==1){
							xqh=0+xqh;
						}
						 ja ="F014B5"+xqh+"FF00FFFFFFFFFFFFFFFFFFFFFFFF";//起始到结束  01终端
						 System.out.println("新小区集中器发送指令："+ja);
						 String pt = "/" + ip + ":" + port; 
						System.out.println("ja--集中器抄表发送数据-----"+pt);
						 sessionmap = czs(ja, pt);
					}
					 log.info("集中器抄表发送数据---："+ja);
					 try {
						 	Thread.sleep(7000);
						 } catch (InterruptedException e) {
						 	e.printStackTrace();
						 }
					JSONObject js=new JSONObject();
					if(sessionmap==true&&null!=MapUtilsDf.getMapUtils().get("cbstate")){
						MapUtilsDf.getMapUtils().add("cbstate",null);
						MapUtilsDf.getMapUtils().add("cbfs",null);
						js.put("js", 0);
					}else{
						MapUtilsDf.getMapUtils().add("cbstate",null);
						MapUtilsDf.getMapUtils().add("cbfs",null);
						js.put("js",1);
					}
				  return js;
			     	} 
	  	
	//对楼栋所有风盘抄表
		@RequestMapping("QyFp")
		@ResponseBody
	 	public JSONObject SCxZx(HttpSession session,String yhbh,String fpdz){
			String	fp=Integer.toHexString(Integer.valueOf(fpdz));
			if(fp.length()==1){
			  fpdzS="0"+fp;
			}
			MapUtilsDf.getMapUtils().add("cbfs",yhbh);
			MapUtilsDf.getMapUtils().add("cbstate",null);
			 yh=yhMessageService.findch(yhbh, fpdz);
			String ld= Integer.toHexString(Integer.valueOf(yh.getLdh()));
			String dy=Integer.toHexString(Integer.valueOf(yh.getDyh()));
			if(dy.length()==1){
				dy="0"+dy;
			}
			if(ld.length()==1){
				ld="0"+ld;
			}
			//用户小区号
			String xqh=yh.getXqh();
			System.out.println("-------xqh----------"+xqh);
			//用户编号
			if(xqh!=null){
				//层管地址
				 cg=Integer.toHexString(Integer.valueOf(yh.getCh()));
				 if(cg.length()==1){
					 cg="0"+cg;
				 }
				 System.out.println("-------------cg--"+cg);
				 ip=yh.getJzqip();
				 port=yh.getJzqport();
				
				xqh = Integer.toHexString(Integer.valueOf(xqh));//16进制  
				if(xqh.length()==1){
					xqh=0+xqh;
				}
				 ja ="F014B5"+xqh+ld+"00"+ld+"FFFFFFFFFFFFFFFFFFFFFF";//起始到结束  01终端	
				 System.out.println("新小区楼栋发送指令："+ja);
				 String pt = "/" + ip + ":" + port; 
				System.out.println("ja--楼栋抄表发送数据-----"+pt);
				 sessionmap = czs(ja, pt);
			}else{
				 yh=	yhMessageService.findCg(yhbh, fpdz);
				//层管地址
				 cgbh=yh.getCgbh();
				 cg=cgbh.substring(4);
				 ip=yh.getJzqip();
				 port=yh.getJzqport();
				 //发送数据
		 		 String ja =ld+dy+"F010B1FFF0F0F0FFFFFFFF"+ld+dy+"FF";
//		 		 String ja =ld+dy+"F010B1FFF0F0F0FF"+""+kg+""+jf+""+jj+ld+dy+"FF";
				 String pt = "/" + ip + ":" + port; 
				 System.out.println("ja--楼栋抄表发送数据-----"+ja);
				 sessionmap = cz(ja, pt);
			}
			 log.info("楼栋抄表发送数据---："+ja);
			 try {
				 	Thread.sleep(7000);
				 } catch (InterruptedException e) {
				 	e.printStackTrace();
				 }
			JSONObject js=new JSONObject();
			if(sessionmap==true&&null!=MapUtilsDf.getMapUtils().get("cbstate")){
				MapUtilsDf.getMapUtils().add("cbstate",null);
				MapUtilsDf.getMapUtils().add("cbfs",null);
				js.put("js", 0);
			}else{
				MapUtilsDf.getMapUtils().add("cbstate",null);
				MapUtilsDf.getMapUtils().add("cbfs",null);
				js.put("js",1);
			}
		  return js;
	     	} 
	// 抽取相同部分
				public boolean cz(String ja, String pt) {
					// 把十六进制数，转换为十进制相加
					int jia = CzUtil.FsZh(ja);
					// 十进制转换为十六进制
					String hex = Integer.toHexString(jia);
					// 截取相加结果后两位
					String je =  hex.charAt(hex.length() - 2) + "" + hex.charAt(hex.length() - 1);
					String[] keys = new String[] { pt };
					String mString =ja+je+"FF";
					System.out.println("发送数据--"+mString);
					// 解码
					byte[] b = CzUtil.jm(mString);
					ServerSessionMap sessionMap = ServerSessionMap.getInstance();
					boolean sessionmap = sessionMap.sendMessage(keys, b);
					return sessionmap;
				}
				
				// 抽取相同部分
				public boolean czs(String ja, String pt) {
					// 把十六进制数，转换为十进制相加
					int jia = CzUtil.FsZhS(ja);
					// 十进制转换为十六进制
					String hex = Integer.toHexString(jia);
					// 截取相加结果后两位
					String je= hex.charAt(hex.length() - 2) + "" + hex.charAt(hex.length() - 1);
					String[] keys = new String[] { pt };
					String mString =ja+je+"FF";
					System.out.println("发送数据-------"+mString);
					// 解码
					byte[] b = CzUtil.jm(mString);
					ServerSessionMap sessionMap = ServerSessionMap.getInstance();
					boolean sessionmap = sessionMap.sendMessage(keys, b);
					return sessionmap;
				}		
	@RequestMapping("/sjbb")
	public String sjbb(HttpServletRequest request)  {
		return "shebgl/sjbb";
	}
	
	@RequestMapping("/sbgl")
	public String sbgl(HttpServletRequest request)  {
		return "shebgl/sbgl";
	}
	@RequestMapping("/yhsy")
	public String yhsy(HttpServletRequest request)  {
		return "shebgl/yhsy";
	}

	public String getFs() {
		return fs;
	}

	public void setFs(String fs) {
		this.fs = fs;
	}}
