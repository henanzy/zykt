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


<style>

	/* 固定表头 */
	.table-th-css {
		position: relative !important;
		top: 0;
	}
	
	/*修改按钮 */
	#xincreate_table_body .mws-table tbody .gradeX .xinjgd_show,
	#xincreate_table_body .mws-table tbody .gradeX .xinjgd_change,
	#xincreate_table_body .mws-table tbody .gradeX .xinjgd_del{
		border:none;
		background-color:rgb(60,61,61);
		height:24px;
		margin-right:6px;
		margin-top:2px;
		color:#fff;
		font-size: 12px;
		border-radius:4px;
	}
	
	/* 新增搜索DIV */
	.search{
		display:block;
		width:99.8%;
		height:40px;
		background-color:#ccc;
		margin:0px auto;
		font-size:12px;
	}
	
	.search p{
		height:30px;
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
	/* 新增按钮 */
	#increase_btn{
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
	#operation_one_btn,
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
	
	/* 新增修改弹出框 */
	#increase_word,
	#change_word{
		display:none;
		position: fixed;
		left: 0;
	    top:0;
	    right:0;
	    bottom:0;
	    z-index: 100; 
		background-color:rgba(0,0,0,0.6);
	}
	
	/* 新增修改弹出框关闭按钮 */
	#increase_word .close,
	#change_word .close{
		display:block;
		background-color:rgb(193,213,43);
		width:24px;
		height:24px;
		color: #fff;
    	border-radius: 13px;
		position:absolute;
		top:14px;
		right:20px;
		line-height: 24px;
   		text-align: center;
   		font-size: 18px;
	}
	#increase_word .close::before,
	#change_word .close::before {
	    content: "\2716";
	}
	
	/* 新增修改弹出框input */
	#increase_word .mws-form-row .increase_word_input,
	#change_word .mws-form-row .change_word_input {
		width:200px;
	}
	
	/* 新增修改弹出框label */
	#increase_word .mws-form-row label,
	#change_word .mws-form-row label{
		width:100px;
	}
	
	/* 新增修改弹出框确认按钮 */
	#increase_word #word_increase_btn,
	#change_word #word_change_btn{
		position:relative;
		top:10px;
		left:47%;
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
	
	@media screen and (max-width:1070px){
		.search{
			height:80px;
		}
		.search p{
			padding-top:8px;
			height:60px;
		}
	}
	
</style>
 <script type="text/javascript">
var cgLsit = ${cgLsit};


</script>

</head>
<body>

	<div id="increasedis" class="clearfix" style="overflow: hidden;height:1000px;">
	
		<div class="mws-panel grid_8 "
			style="width: 98%; padding-left: 12px; margin: 0px 0px 10px 0px; min-width:650px">
			<div class="mws-panel-header">
				<span class="mws-i-24 i-table-1">层管管理</span>
			</div>
			<div class="search">
			<p>
					<span>选择开关：
						<select id="kg">
							<option value="">--选择开关--</option>
							<option value="自动运行">自动运行</option>
							<option value="强制关闭">强制关闭</option>
						</select>
					</span>
					<span>选择是否计费：
						<select id="jf">
							<option value="">--是否计费--</option>
							<option value="允许计费">允许计费</option>
							<option value="禁止计费">禁止计费</option>
						</select>
					</span>
					<span>选择季节：
						<select id="jj">
							<option value="">--选择季节--</option>
							<option value="00">夏季</option>
							<option value="01">冬季</option>
						</select>
					</span>
					
					<input id="operation_one_btn" type="submit" value="某层群发" />
					<input id="operation_DY_btn" type="submit" value="某单元群发" />
					<input id="operation_all_btn" type="submit" value="某栋楼群发" />
					<input id="increase_btn" type="submit" value="新增" />
				</p>
				
			</div>
			<div id="xincreate_table_body" class="mws-panel-body"
				style="overflow:scroll !important; height: 590px;">
				<table class="mws-table" >
					<thead>
						<tr>
							<th class="table-th-css"></th>
							<th class="table-th-css">层管编号<span class="span-up"></span> <span class="span-down"></span></th>
							<th class="table-th-css">集中器net<span class="span-up"></span> <span class="span-down"></span></th>
							<th class="table-th-css">安装地址</th>
							<th class="table-th-css">备注<span class="span-up"></span> <span class="span-down"></span></th>	
							<th class="table-th-css">处理</th>						
						</tr>
					</thead>
					<tbody id="xinword_body">
						
				
					</tbody>
				</table>
			</div>
		</div>
		
		
		<nav style="width:100%;">
            <ul style="width:500px;display:flex;justify-content:space-between;margin:0 auto;" >
            	
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
                    </select>
                     
            </ul>
         </nav>
		
<div id="increase_word">
			<div class="mws-panel grid_4"
				style="width: 400px; min-width: 500px; margin: 100px 30%;">
				<div class="mws-panel-header">
					<span class="mws-i-24 i-pencil">新增</span> <span class="close"></span>
				</div>
				<div class="mws-panel-body" style="height: 380px;">
					<form class="mws-form" action="addCg.action" method="post">
						<div class="mws-form-inline">

						

							<div class="mws-form-row">
								<label>&emsp;&emsp;层管编号：</label>

								<div class="mws-form-item large">
									<input type="text" class="mws-textinput increase_word_input"
										name="cgbh" value="" />
								</div>
							</div>

							<div class="mws-form-row">
								<label>&emsp;集中器net：</label>

								<div class="mws-form-item large">
									<input type="text" class="mws-textinput increase_word_input"
										name="jzqnet" value="" />
								</div>
							</div>
							
							<div class="mws-form-row">
								<label>&emsp;&emsp;安装位置：</label>
								<div class="mws-form-item large">
									<input type="text" class="mws-textinput increase_word_input"
										name="azdz" value="" />
								</div>
							</div>
							<div class="mws-form-row">
								<label> &emsp;&emsp;备注：</label>
								<div class="mws-form-item large">
									<input type="text" class="mws-textinput increase_word_input" 
										id="bz" name="bz" value="" />
								</div>
							</div>
							

						</div>
						<input type="submit" id="word_increase_btn"
							class="mws-button black" value="新增" />
					</form>
				</div>
			</div>
		</div>
		
		
		<div id="change_word">
			<div class="mws-panel grid_4"
				style="width: 400px; min-width: 500px; margin: 100px 30%;">
				<div class="mws-panel-header">
					<span class="mws-i-24 i-pencil">修改</span> <span class="close"></span>
				</div>
				<div class="mws-panel-body" style="height: 380px;">
					<form class="mws-form" action="updateCg.action"  method="post">
						<div class="mws-form-inline">
						<input type="hidden" class="mws-textinput change_word_input"
							name="id" value="" />
						  
							<div class="mws-form-row">
								<label>&emsp;&emsp;层管编号：</label>

								<div class="mws-form-item large">
									<input type="text" class="mws-textinput change_word_input"
										name="cgbh" value="" />
								</div>
							</div>

							<div class="mws-form-row">
								<label>&emsp;集中器net：</label>

								<div class="mws-form-item large">
									<input type="text" class="mws-textinput change_word_input"
										name="jzqnet" value="" />
								</div>
							</div>
							
							<div class="mws-form-row">
								<label>&emsp;&emsp;安装位置：</label>
								<div class="mws-form-item large">
									<input type="text" class="mws-textinput change_word_input"
										name="azdz" value="" />
								</div>
							</div>
							<div class="mws-form-row">
								<label> &emsp;&emsp;备注：</label>
								<div class="mws-form-item large">
									<input type="text" class="mws-textinput change_word_input" 
										id="bz" name="bz" value="" />
								</div>
							</div>
							
							
							
							
  							
						</div>
						<input type="submit" id="word_change_btn"
							class="mws-button black" value="修改" />
					</form>
				</div>
			</div>
		</div>
		
		
		
	</div>
	
	 <script type="text/javascript">
           
    </script>
	
</body>
<script type="text/javascript" src="../js/cggl.js"></script>
</html>