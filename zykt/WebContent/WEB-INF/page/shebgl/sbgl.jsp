<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<!-- Required Stylesheets -->
<link rel="stylesheet" type="text/css" href="../css/reset.css"
	media="screen" />
<link rel="stylesheet" type="text/css" href="../css/text.css"
	media="screen" />
<link rel="stylesheet" type="text/css"
	href="../css/fonts/ptsans/stylesheet.css" media="screen" />
<link rel="stylesheet" type="text/css" href="../css/fluid.css"
	media="screen" />

<link rel="stylesheet" type="text/css" href="../css/mws.style.css"
	media="screen" />
<link rel="stylesheet" type="text/css" href="../css/icons/icons.css"
	media="screen" />

<!-- Demo and Plugin Stylesheets -->
<link rel="stylesheet" type="text/css" href="../css/demo.css"
	media="screen" />

<link rel="stylesheet" type="text/css"
	href="../plugins/colorpicker/colorpicker.css" media="screen" />
<link rel="stylesheet" type="text/css"
	href="../plugins/jimgareaselect/css/imgareaselect-default.css"
	media="screen" />
<link rel="stylesheet" type="text/css"
	href="../plugins/fullcalendar/fullcalendar.css" media="screen" />
<link rel="stylesheet" type="text/css"
	href="../plugins/fullcalendar/fullcalendar.print.css" media="print" />
<link rel="stylesheet" type="text/css" href="../plugins/tipsy/tipsy.css"
	media="screen" />
<link rel="stylesheet" type="text/css"
	href="../plugins/sourcerer/Sourcerer-1.2.css" media="screen" />
<link rel="stylesheet" type="text/css"
	href="../plugins/jgrowl/jquery.jgrowl.css" media="screen" />
<link rel="stylesheet" type="text/css"
	href="../plugins/spinner/spinner.css" media="screen" />
<link rel="stylesheet" type="text/css" href="../css/jui/jquery.ui.css"
	media="screen" />

<!-- Theme Stylesheet -->
<link rel="stylesheet" type="text/css" href="../css/mws.theme.css"
	media="screen" />

<!-- JavaScript Plugins -->

<script type="text/javascript" src="../js/jquery-1.7.1.min.js"></script>

<script type="text/javascript"
	src="../plugins/jimgareaselect/jquery.imgareaselect.min.js"></script>
<script type="text/javascript"
	src="../plugins/jquery.dualListBox-1.3.min.js"></script>
<script type="text/javascript" src="../plugins/jgrowl/jquery.jgrowl.js"></script>
<script type="text/javascript" src="../plugins/jquery.filestyle.js"></script>
<script type="text/javascript"
	src="../plugins/fullcalendar/fullcalendar.min.js"></script>
<script type="text/javascript" src="../plugins/jquery.dataTables.js"></script>
<!--[if lt IE 9]>
<script type="text/javascript" src="../plugins/flot/excanvas.min.js"></script>
<![endif]-->
<script type="text/javascript" src="../js/layer/2.4/layer.js"></script>
<script type="text/javascript" src="../js/layui/layui.js"></script>
<script type="text/javascript" src="../js/layui/layui.all.js"></script>

<script type="text/javascript" src="../plugins/flot/jquery.flot.min.js"></script>
<script type="text/javascript" src="../js/layer/2.4/layer.js"></script>
<script type="text/javascript" src="../js/layui/layui.js"></script>
<script type="text/javascript" src="../js/layui/layui.all.js"></script>
<link rel="stylesheet" type="text/css" href="../js/layui/css/layui.css" media="screen" />
<script type="text/javascript"
	src="../plugins/flot/jquery.flot.pie.min.js"></script>
<script type="text/javascript"
	src="../plugins/flot/jquery.flot.stack.min.js"></script>
<script type="text/javascript"
	src="../plugins/flot/jquery.flot.resize.min.js"></script>
<script type="text/javascript"
	src="../plugins/colorpicker/colorpicker.js"></script>
<script type="text/javascript" src="../plugins/tipsy/jquery.tipsy.js"></script>
<script type="text/javascript"
	src="../plugins/sourcerer/Sourcerer-1.2.js"></script>
<script type="text/javascript" src="../plugins/jquery.placeholder.js"></script>
<script type="text/javascript" src="../plugins/jquery.validate.js"></script>
<script type="text/javascript" src="../plugins/jquery.mousewheel.js"></script>
<script type="text/javascript" src="../plugins/spinner/ui.spinner.js"></script>
<script type="text/javascript" src="../js/jquery-ui.js"></script>

<script type="text/javascript" src="../js/mws.js"></script>
<script type="text/javascript" src="../js/demo.js"></script>
<script type="text/javascript" src="../js/themer.js"></script>


<script type="text/javascript" src="../js/sbgl.js"></script>



<style>

	/* 固定表头 */
	.table-th-css {
		position: relative !important;
		top: 0;
	}
	
	
	
	/* 搜索DIV */
	.search{
		display:block;
		width:99.8%;
		height:100px;
		background-color:#ccc;
		margin:0px auto;
		font-size:12px;
	}
	
	.search p{
		height:30px;
	}
		#export_btn{
		margin-top:8px;
		margin-left:20px;
		border:none;
		background-color:rgb(60,61,61);
		width:60px;
		height:24px;
		margin-right:6px;
		color:#fff;
		border-radius:4px;
	}
	
	.search p select{
		width:120px;
		height:24px;
		border:none;
		border-radius:6px;
		padding-left:6px;
	}
	
	.search p span{
		color:#333;
		font-size:14px;
		margin-left:20px; 
	}
	.search span input{
		width:62px;
	} 
	/* 搜索按钮 */
	#search_btn,
	#search_status_btn{
		margin-top:8px;
		margin-left:20px;
		border:none;
		background-color:rgb(60,61,61);
		width:60px;
		height:24px;
		margin-right:6px;
		color:#fff;
		border-radius:4px;
	}
	
	/* 封盘按钮 */
	#operation_one_btn,#cbhall,#cbCall,#cball,#cbjzqall
	#operation_all_btn{
		margin-top:8px;
		margin-left:20px;
		border:none;
		background-color:rgb(60,61,61);
		width:100px;
		height:24px;
		margin-right:6px;
		color:#fff;
		border-radius:4px;
	}
	.btn{
		margin-top:8px;
		margin-left:20px;
		border:none;
		background-color:rgb(60,61,61);
		width:100px;
		height:24px;
		margin-right:6px;
		color:#fff;
		border-radius:4px;
	}

	
	/* thead排序按钮 */
	.span-up{
        border-style: solid;
        border-width: 0px 5px 5px 5px;
        border-color: transparent transparent black transparent;
        width: 0px;
        height: 0px;
        display: block;
        position: absolute;
        top: 14px;
       	right: 6px;
    }
    
    .span-down{
        border-style: solid;
        border-width: 5px 5px 0px 5px;
        border-color: black transparent transparent transparent;
        width: 0px;
        height: 0px;
        display: block;
        position: absolute;
        top: 20px;
        right: 6px;
    }
	
	nav li,
	select{
		width:50px;
		height:24px;
		line-height:24px;
		border-radius:4px;
		background-color:rgba(43,45,49,0.8);
		color:#fff;
		cursor:pointer;
		text-align:center;
	}
	#curpage{
		width:120px;
	}
	
	/* td悬停样式 */
	.blue {
		background: #ccc;
	}
	


	@media screen and (max-width:950px){
		.search{
			height:140px;
		}
		.search p{
			height:60px;
		}
	}
	
	
	
</style>
 <script type="text/javascript">
<%-- var YhList;
var yhNum;
var fpNum;


$.ajax({
		url : "<%=basePath%>Data/dataSbgls.action", 
		async : false,
		dataType : "json",
		data : {
			
		},
		success : function(data) {
			debugger;
			YhList=data.YhList;
			yhNum=data.yhNum;
			fpNum=data.fpNum;
			$("#yhNum").val(yhNum)
			
			$("#fpNum").html(value)
		}

	}); --%>

//集中器

function  cbjzqall() {

	var arr = [];
	var checkBox=  $("input[type='checkbox']:checked");
	if(checkBox.length != 1){
		alert("只能勾选一组信息");
		return;
	}
	checkBox.each(function(i, n){
		var tdarr = [];
		var td =  $(this).parent().parent().children();
		for(var i = 1; i < 5; i ++){
			tdarr.push(td[i].innerHTML);
		}
		arr.push(tdarr);
	});
   	 var yhbh=arr[0][1];
   	 var fpdz=arr[0][3];
	$.ajax({
		type:"POST",
		url : "QyjzqFp.action",
		async : false,
		dataType : "json",
		 traditional: true,
		data : {
			"yhbh" : yhbh,
			"fpdz" : fpdz,
		},
		success : function(data) {
			var msg = data.js
			if(msg==0){
				alert("查询成功");
			}else{
				alert("查询失败");
			}
			/*cb()*/
		}

		});
}
//楼栋
 
function  cball() {
	var arr = [];
	var checkBox=  $("input[type='checkbox']:checked");
	if(checkBox.length != 1){
		alert("只能勾选一组信息");
		return;
	}
	checkBox.each(function(i, n){
		var tdarr = [];
		var td =  $(this).parent().parent().children();
		for(var i = 1; i < 5; i ++){
			tdarr.push(td[i].innerHTML);
		}
		arr.push(tdarr);
	});
   	 var yhbh=arr[0][1];
   	 var fpdz=arr[0][3];
	$.ajax({
		type:"POST",
		url : "QyFp.action",
		async : false,
		dataType : "json",
		 traditional: true,
		data : {
			"yhbh" : yhbh,
			"fpdz" : fpdz,
		},
		success : function(data) {
			var msg = data.js
			if(msg==0){
				alert("查询成功");
			}else{
				alert("查询失败");
			}
			/*cb()*/
		}

		});
}
//整层发送
function cbCall() {
	var kg = $('#kg  option:selected').val();
	var jf = $('#jf  option:selected').val();
	var jj = $('#jj  option:selected').val();
	var arr = [];
	var checkBox=  $("input[type='checkbox']:checked");
	if(checkBox.length != 1){
		alert("只能勾选一组信息");
		return;
	}
	checkBox.each(function(i, n){
		var tdarr = [];
		var td =  $(this).parent().parent().children();
		for(var i = 1; i < 5; i ++){
			tdarr.push(td[i].innerHTML);
		}
		arr.push(tdarr);
	});

   	 var yhbh=arr[0][1];
   	 var fpdz=arr[0][3];
	$.ajax({
		type:"POST",
		url : "CxCState.action",
		async : false,
		dataType : "json",
		 traditional: true,
		data : {
			"yhbh" : yhbh,
			"fpdz" : fpdz,
			"kg" : kg,
			"jf" : jf,
			"jj" : jj,
		},
		success : function(data) {
			var msg = data.js
			if(msg==0){
				alert("查询成功");
			}else{
				alert("查询失败");
			}
			/*cb()*/
		}

		});
}
//某户发送
function cbhall() {
	var kg = $('#kg  option:selected').val();
	var jf = $('#jf  option:selected').val();
	var jj = $('#jj  option:selected').val();
	var arr = [];
	var checkBox=  $("input[type='checkbox']:checked");
	if(checkBox.length != 1){
		alert("只能勾选一组信息");
		return;
	}
	checkBox.each(function(i, n){
		var tdarr = [];
		var td =  $(this).parent().parent().children();
		for(var i = 1; i <5; i ++){
			tdarr.push(td[i].innerHTML);
		}
		arr.push(tdarr);
	});
   	 var yhbh=arr[0][1];
   	 var fpdz=arr[0][3];
	$.ajax({
		type:"POST",
		url : "CxHState.action",
		async : false,
		dataType : "json",
		 traditional: true,
		data : {
			"yhbh" : yhbh,
			"fpdz" : fpdz,
			"kg" : kg,
			"jf" : jf,
			"jj" : jj,
		},
		success : function(data) {
			var msg = data.js
			if(msg==0){
				alert("查询成功");
			}else{
				alert("查询失败");
			}
			/*cb()*/
		}

		});
}
//某层发送
function ChCb() {
	var arr = [];
	var checkBox=  $("input[type='checkbox']:checked");
	if(checkBox.length != 1){
		alert("只能勾选一组信息");
		return;
	}
	checkBox.each(function(i, n){
		var tdarr = [];
		var td =  $(this).parent().parent().children();
		for(var i = 1; i <5; i ++){
			tdarr.push(td[i].innerHTML);
		}
		arr.push(tdarr);
	});
   	 var yhbh=arr[0][1];
   	 var fpdz=arr[0][3];
	$.ajax({
		type:"POST",
		url : "ChCbState.action",
		async : false,
		dataType : "json",
		 traditional: true,
		data : {
			"yhbh" : yhbh,
			"fpdz" : fpdz,
		},
		success : function(data) {
			var msg = data.js
			if(msg==0){
				alert("查询成功");
			}else{
				alert("查询失败");
			}
			/*cb()*/
		}

		});
}


//查询某户存储信息
function ChCxx() {
	var arr = [];
	var checkBox=  $("input[type='checkbox']:checked");
	if(checkBox.length != 1){
		alert("只能勾选一组信息");
		return;
	}
	checkBox.each(function(i, n){
		var tdarr = [];
		var td =  $(this).parent().parent().children();
		for(var i = 1; i <5; i ++){
			tdarr.push(td[i].innerHTML);
		}
		arr.push(tdarr);
	});
   	 var yhbh=arr[0][1];
   	 var fpdz=arr[0][3];
	$.ajax({
		type:"POST",
		url : "ChCcxx.action",
		async : false,
		dataType : "json",
		 traditional: true,
		data : {
			"yhbh" : yhbh,
			"fpdz" : fpdz,
		},
		success : function(data) {
			var msg = data.js
			if(msg==0){
				var state=data.ccstate;
				alert(state)
			}else{
				alert("查询失败");
			}
			/*cb()*/
		}

		});
}

//某层设置周期
function cgzq() {
	var zq = $('#zq').val();
	 if(!(/(^[1-9]\d*$)/.test(zq))){
	    alert("只能输入正整数！");
	    return;
	} 
	/* var re =/^([1-9]\d*|[0]{1,1})$/;//含0正整数
	 if (!re.test(zq)) {
	       alert("请输入正整数！");
	       return false;
	    } */
	
	var arr = [];
	var checkBox=  $("input[type='checkbox']:checked");
	if(checkBox.length != 1){
		alert("只能勾选一组信息");
		return;
	}
	checkBox.each(function(i, n){
		var tdarr = [];
		var td =  $(this).parent().parent().children();
		for(var i = 1; i <5; i ++){
			tdarr.push(td[i].innerHTML);
		}
		arr.push(tdarr);
	});
   	 var yhbh=arr[0][1];
   	 var fpdz=arr[0][3];
	$.ajax({
		type:"POST",
		url : "cgzq.action",
		async : false,
		dataType : "json",
		 traditional: true,
		data : {
			"yhbh" : yhbh,
			"fpdz" : fpdz,
			"zq":zq,
		},
		success : function(data) {
			var msg = data.js
			if(msg==0){
				alert("查询成功");
			}else{
				alert("查询失败");
			}
			/*cb()*/
		}

		});
}
</script>

</head>
<body>

	<div id="increasedis" class="clearfix" style="overflow-x: hidden;height:1000px;">
		
		<div class="mws-panel grid_8 "
			style="width: 98%; padding-left: 12px; margin: 0px 0px 10px 0px; min-width:1450px">
			<div class="mws-panel-header">
				<span style="display:inline" class="mws-i-24 i-table-1">设备管理</span>
				&nbsp; &nbsp; &nbsp;<span id="xqspan" style="display:inline" ></span>
				&nbsp; &nbsp; &nbsp;<span style="display:inline">用户使用数量:</span><span id="yhNum" style="display:inline" ></span>
				&nbsp; &nbsp; &nbsp;<span style="display:inline">风盘使用数量:</span><span id="fpNum" style="display:inline" ></span>
			</div>
			<div class="search">
				<p>
					<span>选择小区：
						<select id="xq">
							<option value="">--小区名称--</option>
						</select>
					</span>
					<span>楼栋号：
						<select id="ldh">
							<option value="">--选择楼栋号--</option>
						</select>
					</span>
					<span>单元号：
						<select id="dyh">
							<option value="" >--选择单元号--</option>
						</select>
					</span>
					<span>户号：
						<input id="hh" type="text" value="" />
					</span>
					
					
					<input id="search_btn" type="submit" value="搜索" />

					层管抄表周期：<input size="5px" type="text" id="zq">
					 <input id="cgzq" class="btn" type="submit"  value="设置">
</p>
				<p>
				
							<input id="cbhall" type="submit" class="btn" value="对某户设置" />
					<input id="cbCall" type="submit"class="btn"  value="对某层设置" />
				
					
				
					<span>选择开关：
						<select id="kg">
							<option value="FF">--选择开关--</option>
							<option value="01">自动运行</option>
							<option value="00">强制关闭</option>
						</select>
					</span>
					<span>选择是否计费：
						<select id="jf">
							<option value="FF">--是否计费--</option>
							<option value="01">允许计费</option>
							<option value="00">禁止计费</option>
						</select>
					</span>
					<span>选择季节：
						<select id="jj">
							<option value="FF">--选择季节--</option>
							<option value="00">夏季</option>
							<option value="01">冬季</option>
						</select>
					</span>
				
					<input id="operation_one_btn" type="submit" value="单个设置" />
	</p>
				<p>
					<input id="search_status_btn" type="submit" value="单个抄表" />
						<input id="ChCb" class="btn"  type="submit" value="对某层抄表" />
		
					
					<input id="cball" type="submit" class="btn" value="对楼栋抄表" />
					<input id="cbjzqall" type="submit" class="btn" value="对集中器抄表" />
					<input id="ChCxx" class="btn" type="submit"  value="查询存储信息" />
						<input id="export_btn" type="button" value="导出" /></a>
				</p>
			</div>
			<div id="xincreate_table_body" class="mws-panel-body"

				style="overflow:scroll !important; height: 590px;">
				<table class="mws-table" style="width:150%;">

					<thead>
						<tr>
							<th class="table-th-css"></th>
							<th class="table-th-css">用户编号<span class="span-up"></span> <span class="span-down"></span></th>
							<th class="table-th-css">用户姓名<span class="span-up"></span> <span class="span-down"></span></th>
							<th class="table-th-css">地址</th>
							<th class="table-th-css">楼栋<span class="span-up"></span> <span class="span-down"></span></th>
							<th class="table-th-css">单元<span class="span-up"></span> <span class="span-down"></span></th>
							<th class="table-th-css">户号<span class="span-up"></span> <span class="span-down"></span></th>	
							<th class="table-th-css">缴费标识<span class="span-up"></span> <span class="span-down"></span></th>						
							<th class="table-th-css">设温<span class="span-up"></span> <span class="span-down"></span></th>
							<th class="table-th-css">出温<span class="span-up"></span> <span class="span-down"></span></th>							
							
							<th class="table-th-css">当量<span class="span-up"></span> <span class="span-down"></span></th>
							<th class="table-th-css">总金额<span class="span-up"></span> <span class="span-down"></span></th>
							<th class="table-th-css">已用金额<span class="span-up"></span> <span class="span-down"></span></th>
							<th class="table-th-css">剩余金额<span class="span-up"></span> <span class="span-down"></span></th>
							<th class="table-th-css">档位<span class="span-up"></span> <span class="span-down"></span></th>
							<th class="table-th-css">时间<span class="span-up"></span> <span class="span-down"></span></th>
							<th class="table-th-css">冷高<span class="span-up"></span> <span class="span-down"></span></th>
							<th class="table-th-css">冷中<span class="span-up"></span> <span class="span-down"></span></th>
							<th class="table-th-css">冷低<span class="span-up"></span> <span class="span-down"></span></th>
							<th class="table-th-css">热高<span class="span-up"></span> <span class="span-down"></span></th>
							<th class="table-th-css">热中<span class="span-up"></span> <span class="span-down"></span></th>
							<th class="table-th-css">热低<span class="span-up"></span> <span class="span-down"></span></th>
							
							<th class="table-th-css">面积<span class="span-up"></span> <span class="span-down"></span></th>
							<th class="table-th-css">电话<span class="span-up"></span> <span class="span-down"></span></th>
							<th class="table-th-css">计费状态<span class="span-up"></span> <span class="span-down"></span></th>
							<th class="table-th-css">运行状态<span class="span-up"></span> <span class="span-down"></span></th>
							<th class="table-th-css">状态<span class="span-up"></span> <span class="span-down"></span></th>
							
							<th class="table-th-css">备注<span class="span-up"></span> <span class="span-down"></span></th>
							
						</tr>
					</thead>
					<tbody id="xinword_body">
						
				
					</tbody>
				</table>
			</div>
		</div>
		
		
		<nav style="width:100%;">
            <ul style="width:600px;display:flex;justify-content:space-between;margin:0 auto;" >
            	
                <li id="first">首页</li>
                <li id="last">上一页</li>
                <li id="next">下一页</li>
                <li id="end">尾页</li>   
                <li id="curpage">当前第<span id="currentNum" ></span>页 /共<span id='pages'></span>页</li>
                <li>共<span id="num"></span></li>
                
                    <select name="" id="select" >
                        <option value="10">10</option>
                        <option value="15"  selected = "selected">15</option>
                        <option value="20" >20</option>
                        <option value="25">25</option>
                        <option value="30">30</option>
                        
 			<option value="500">500</option>
 			  <option value="1000">1000</option>
 			  <option value="2000">2000</option>
                    </select>
                     
            </ul>
         </nav>
		

		
		
		
	</div>
	<script type="text/javascript">
	var YhList;
	var yhNum;
	var fpNum;


	$.ajax({
			url : "<%=basePath%>Data/dataSbgls.action", 
			async : false,
			dataType : "json",
			data : {
				
			},
			success : function(data) {
				YhList=data.YhList;
				yhNum=data.yhNum;
				fpNum=data.fpNum;
				$("#yhNum").html(yhNum)
				
				$("#fpNum").html(fpNum)
			}

		});

	</script>
	
</body>
</html>