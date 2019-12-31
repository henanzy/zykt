package com.hnzy.hot.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.hnzy.hot.pojo.User;
import com.hnzy.hot.service.DataService;
import com.hnzy.hot.service.UserService;
import com.hnzy.hot.util.JSONSerializer;
import com.hnzy.hot.util.MD5Util;
import com.hnzy.hot.util.StringUtil;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("user")
public class UserController {
	
	@Autowired
	private DataService dataService;
//	@Autowired
//	private YhInfoService yhInfoService;
//	@Autowired
//	private KfgdService kfgdService;
	@Autowired
	private UserService userServer;
//	@Autowired
//	private CellService callService;
//	public List<YhInfo> YhInfoList;
	
	
	
	//跳转到登录页面
		@RequestMapping("/toLogin")
		public String tologin(){
			return"index";
		}
//	@RequestMapping("/toLogin")
//	public String tologin(){
//		return"navi";
//	}
	
	//跳转到主页面
		@RequestMapping("ZHome")
		public String ZHome(){
			return "navi";
		}
		
		
		
//		//来电弹屏和首页
		@RequestMapping("/home" )
    	public String home(String mobile,HttpServletRequest request,HttpSession session,String fl){

    		List<Map<String, Object>> YhList=dataService.find(null,null,null,null);
    		request.setAttribute("YhList", JSONSerializer.serialize(YhList));
    		request.setAttribute("fl",fl);
    		return "home";
    	}

    	
    	@RequestMapping("/left")
    	public String left(HttpServletRequest reqeust,String fl){
    		reqeust.setAttribute("fl",fl);
    		return "left";
    	}
    	/*@RequestMapping("/index")
    	public String index(){
    		return "index";
    	}*/
    	@RequestMapping("/error")
    	public String error(){
    		return "error";
    	}
    	
    	//缁熻鍒嗘瀽
    	@RequestMapping("/tongjfx2")
    	public String tongjfx2(){
    		return "Kefu/tongjfx2";
    	}
 
    	//宸ュ崟瀹℃牳
    	@RequestMapping("/gongdsh")
    	public String gongdsh(){
    		return "Kefu/gongdsh";
    	}
    	//宸ュ崟鐩戞帶
    	@RequestMapping("/gongdjk")
    	public String gongdjk(){
    		return "Kefu/gongdjk";
    	}
    	//鍙傛暟璁剧疆
    	@RequestMapping("/canssz")
    	public String canssz(){
    		return "Kefu/canssz";
    	}
    	//鎹㈢儹绔欒繍琛岀鐞�
    	@RequestMapping("/yunxgl2")
    	public String yunxgl2(){
    		return "huanre/yunxgl2";
    	}
    	@ResponseBody
    	@RequestMapping("/login")
		public JSONObject login(HttpSession session,String username,String password,HttpServletRequest request) throws UnsupportedEncodingException{
			JSONObject jsonObject= new JSONObject();
			if (StringUtil.isNoEmpty(username) && StringUtil.isNoEmpty(password)) {
				username=new String(username.getBytes("ISO-8859-1"),"utf-8")+"";
				password=new String(password.getBytes("ISO-8859-1"),"utf-8")+"";
				password=MD5Util.string2MD5(password);
				User info = userServer.findUserByNameAndMD5(username, password);			
				if(info!=null){
					
					request.getSession().setAttribute("admins", info);
					request.getSession().setAttribute("UserName", info.getUserName());
					request.getSession().setAttribute("PassWord", info.getPassWord());
					request.getSession().setAttribute("ID", info.getID());
					jsonObject.put("UserName", info.getUserName());
					jsonObject.put("msg","0");
					
				
			}else {

					jsonObject.put("msg", "1"); 
				}
//
			}
			return jsonObject;
		}
//    	
    	@RequestMapping("updapwd")
    	@ResponseBody
    	public String updapwd(HttpSession session,HttpServletRequest request,String oldpassword ,String newpassword,String username) throws UnsupportedEncodingException {
//    		JSONObject jsonObject=new JSONObject();
    		       username=new String(username.getBytes("ISO-8859-1"),"utf-8");
    				
    				String password11=MD5Util.string2MD5(oldpassword);
    				String password12=MD5Util.string2MD5(newpassword);	
    				String msg="";
    				Integer ID=(Integer) session.getAttribute("ID");
//    				System.out.println(ID);
//    				System.out.println(password11);
//    				System.out.println(userServer.findUserPass(ID));
						if (password11.equals(userServer.findUserPass(ID))) {  
							User user =new User();
							user.setID(ID);
							user.setUserName(username);
							user.setPassWord(password12);
							userServer.update(user);
							msg="0";
						}else{
							msg="1";
						} 

    				return msg;
    	}

    	/*企业条例*/
    	@RequestMapping("/qiytl")
    	public String qiytl(){
    		return "zhishiku/qiytl";
    	}
    	/*企业条例新增文章*/
    	@RequestMapping("/qiytlwz")
    	public String qiytlwz(){
    		return "zhishiku/qiytlwz";
    	}
    	
    	//新增登录用户
    	@ResponseBody
    	@RequestMapping("addYh")
    	public JSONObject addYh(HttpServletRequest request,String username,String password) throws UnsupportedEncodingException{
    		 username=new String(username.getBytes("ISO-8859-1"),"utf-8");
    		JSONObject json=new JSONObject();
    		 //根据用户名字查找用户是否存在
    		 User user=userServer.findByName(username);
    		 if(user!=null){
    			 //用户名称已存在
    			 json.put("msg","0");
    		 }else{
    			  password=MD5Util.string2MD5(password);
    			 userServer.InsUsePass(username, password);
    			 json.put("msg","1");
    		 }
    		 
			return json;
    		
    	}	
    	
    	
    	/*企业条例国家法规*/
    	@RequestMapping("/guojfg")
    	public String guojfg(){
    		return "zhishiku/guojfg";
    	}
    	
    	/*企业条例行业知识*/
    	@RequestMapping("/hangyzs")
    	public String hangyzs(){
    		return "zhishiku/hangyzs";
    	}
    	
    	/*企业条例行业知识*/
    	@RequestMapping("/xitsm")
    	public String xitsm(){
    		return "zhishiku/xitsm";
    	}
    	
    	/*企业条例行业知识*/
    	@RequestMapping("/wentjd")
    	public String wentjd(){
    		return "zhishiku/wentjd";
    	}
    	

    	/*员工定位*/
    	@RequestMapping("/shisdw")
    	public String shisdw(){
    		return "dingwei/shisdw";
    	}
    	/*历史轨迹*/
    	@RequestMapping("/lisgj")
    	public String lisgj(){
    		return "dingwei/lisgj";
    	}
    	
    	/*设备管理*/
    	@RequestMapping("/sbgl")
    	public String sbgl(){
    		return "shebgl/sbgl";
    	}
    	
    	/*缴费管理*/
    	@RequestMapping("/jfgl")
    	public String jfgl(){
    		return "/jfgl";
    	}
    	
    	/*树状栏跳转页面*/
    	@RequestMapping("/szt")
    	public String szt(){
    		return "/szt";
    	}


}