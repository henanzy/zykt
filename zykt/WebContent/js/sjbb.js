
$(document).ready(function() {
	 $.ajax({
         type: "post",
         url: "findXqm.action",
         dataType: "json",
         success: function(data){
           var html ;
           for(var i=0;i<data.findXqm.length;i++){
        	   html +='<option value="'+data.findXqm[i].xqm+'">'+data.findXqm[i].xqm+'</option>';
           }
           $('#xq').append(html);
          
        }
     });
	 $("#xq").change(function(){
		 $.ajax({
				url : "findLd.action", 
				async : false,
				dataType : "json",
				data : {
					"xqm" : $("#xq").val(),
				},
				success : function(data) {
					$("#ldh option:gt(0)").remove();
					$("#dyh option:gt(0)").remove();
					var ld=data.Ld;
					for(var i=0; i<ld.length; i++){
						
						$("#ldh").append("<option value='"+ld[i].ldh+"'>"+ld[i].ldh+"</option>");
					}	
				}

			});
		});
	 
	 $("#ldh").change(function(){
		 $.ajax({
				url : "findDy.action", 
				async : false,
				dataType : "json",
				data : {
					"xqm" : $("#xq").val(),
					"ldh" : $("#ldh").val(),
				},
				success : function(data) {
					$("#dyh option:gt(0)").remove();
					var dy=data.Dy;
					for(var i=0; i<dy.length; i++){
						
						$("#dyh").append("<option value='"+dy[i].dyh+"'>"+dy[i].dyh+"</option>");
					}	
				}

			});
			
			
		});
	 
	//表头固定 
		var xincreatetableCont = $('#xincreate_table_body table tr th'); //获取th
		var xincreatetableScroll = $('#xincreate_table_body'); //获取滚动条同级
		xincreatetableScroll.on('scroll', scrollHandlexincreate);

		function scrollHandlexincreate() {
			var scrollTop = xincreatetableScroll.scrollTop();
			// 当滚动距离大于0时设置top及相应的样式
			if (scrollTop > 0) {
				xincreatetableCont.css({
					"top" : scrollTop + 'px',
					"marginTop" : "-1px",
					"backgroundColor" : "#EBEBEB"
				})
			} else { // 当滚动距离小于0时设置top及相应的样式 
				xincreatetableCont.css({
					"top" : scrollTop + 'px',
					"marginTop" : "0",
					"backgroundColor" : "#EBEBEB"
				})
			}
		}
		
		var xinwordList = [];
		var drList = [];
		
		function jsArrChange(json){
			for (var i = 0 ; i < json.length ; i ++) {
				var arr1 = [];
				arr1[0] = json[i].id;
				arr1[1] = json[i].yhbh;
				arr1[2] = json[i].yhxm;
				arr1[3] = json[i].fpdz;
				arr1[4] = json[i].ldh;
				arr1[5] = json[i].dyh;
				arr1[6] = json[i].hh;
				arr1[7] = json[i].sdwd;
				arr1[8] = json[i].snwd;
				if(json[i].ms=="01"){
					arr1[9]="制热"
				}else{
					arr1[9]="制冷"
				}
				
				arr1[10] = json[i].yydl;
				arr1[11] = json[i].syje;
				if(json[i].dw=="03"){
					arr1[12]="高档"
				}
				if(json[i].dw=="02"){
					arr1[12]="中档"
				}
				if(json[i].dw=="01"){
					arr1[12]="低档"
				}
				if(json[i].dw=="00"){
					arr1[12]="停止"
				}
				arr1[13] = json[i].gdtime;
				arr1[14] = json[i].zdtime;
				arr1[15] = json[i].ddtime;
				arr1[16] = json[i].dgdtime;
				arr1[17] = json[i].dzdtime;
				arr1[18] = json[i].dddtime;
				
				arr1[19] = json[i].time;
				arr1[20] = json[i].mj;
				arr1[21] = json[i].lxdh;
				if(json[i].jf=="01"){
					arr1[22]="允许计费"
				}
				if(json[i].jf=="00"){
					arr1[22]="禁止计费"
				}
				
				
				
				if(json[i].kg=="01"){
					arr1[23]="自动运行"
				}
				if(json[i].kg=="00"){
					arr1[23]="强制关闭"
				}
				if(json[i].bj=="00"){
					arr1[24]="正常"
				}else if(json[i].bj=="01"){
					arr1[24]="开盖"
				}else if(json[i].bj=="03"){
					arr1[24]="盗热嫌疑"
				}else if(json[i].bj=="04"){
					arr1[24]="通讯异常"
				}else{
					arr1[24]=""
				}
				if(json[i].jj=="00"){
					arr1[25]="夏季"
				}else if(json[i].jj=="01"){
					arr1[25]="冬季"
				}else{
					arr1[25]=""
				}
				arr1[26] = json[i].xqm;
				/*arr1[27] = json[i].bz;*/
				xinwordList.push(arr1);
				drList.push(arr1);
			};
		}
		jsArrChange(list);
		
		var opt = [];
		//表格写入函数
		tbodydis("",xinwordList,opt);

		
		//分页样式
		$("nav li").click(function(){
			$("nav li").css("color","");
			$(this).css("color","#C5D52B");
			
		});

		
		//工单搜索
		$("#search_btn").click(function(){
		
			var xq = $('#xq').val();
			var ld = $('#ldh').val();
			var dy = $('#dyh').val();
			var hh = $('#hh').val();
			var startTime = $('#startTime').val();
			var endTime = $('#endTime').val();
			var compareWordList = [];
			$('#xqspan').html(xq);
			var compareWordList = [];
			
			compareWord(xq,ld,dy,hh,startTime,endTime,xinwordList,j,compareWordList);
			
			drList=compareWordList;
			$("#xinword_body").empty();

			for(var x = 0;x < compareWordList.length;x ++){
				
				var newWordElemnet = "";
				if(x%2 == 1){
					newWordElemnet = "<tr class='gradeX odd'>";
				}else if(x%2 == 0){
					newWordElemnet = "<tr class='gradeX even'>";
				}
				
				for(var y = 0;y < compareWordList[x].length;y ++){
					
					if(y==0||y==26){

						newWordElemnet += "<td style='display:none;'>" + compareWordList[x][y] + "</td>";
    					continue;
    				}else{

    					newWordElemnet += "<td>" + compareWordList[x][y] + "</td>"
    				}
				}
				
				
				$("#xinword_body").append(newWordElemnet);
				
			}
			
			tbodydis(xinwordList,compareWordList,opt);

		});
		
});
//		查询状态
		$("#search_status_btn").click(function(){
			var arr = [];
			var checkBox=  $("input[type='checkbox']:checked");
			if(checkBox.length == 0){
				alert("请勾选信息");
				return;
			}
			checkBox.each(function(i, n){
				var tdarr = [];
				var td =  $(this).parent().parent().children();
				for(var i = 1; i < td.length-1; i ++){
					tdarr.push(td[i].innerHTML);
				}
				arr.push(tdarr);
			});

			console.log(arr);
		});
		
		//排序
		var tableObject = $('#xincreate_table_body table'); //获取id为xincreate_table_body的table对象
		var tbHead = tableObject.children('thead'); //获取table对象下的thead
		var tbHeadTh = tbHead.find('tr th'); //获取thead下的tr下的th
		var tbBody = tableObject.children('tbody'); //获取table对象下的tbody
		var tbBodyTr = tbBody.find('tr'); //获取tbody下的tr
		
		var sortIndex = 1;
		
		tbHeadTh.each(function() { //遍历thead的tr下的th
			var thisIndex = tbHeadTh.index($(this)); //获取th所在的列号

			var type ="";
			$(this).click(function() { //给当前表头th增加点击事件
				tbHeadTh.find("span").show();
				if(sortIndex%2 == 1){//奇数偶数显示
					$(this).find(".span-up").show();
					$(this).find(".span-down").hide();
				}else{
					$(this).find(".span-up").hide();
					$(this).find(".span-down").show();
				}
				var table = $('table'); 
				var body = table.children('tbody'); 
				var bodytr = body.find('tr');
				checkColumnValue(thisIndex,table,bodytr);
			});
			
		});

		//对表格排序
		function checkColumnValue(index,table,bodytr) {
			var trsValue = new Array();
			bodytr.each(function() {
				var tds = $(this).find('td');
				//获取行号为index列的某一行的单元格内容与该单元格所在行的行内容添加到数组trsValue中
				var data = $(tds[index]).html();//parseFloat($(tds[index]).html()) || 
				if(isNaN(data)&&!isNaN(Date.parse(data))){
				type = "string";
				}else if (parseFloat(data)) {
					type = "number";
				}else{
					type = "string";
				}
				trsValue.push(type + ".separator" + $(tds[index]).html() + ".separator" + $(this).html());
				$(this).html("");
			});

			var len = trsValue.length;

			if(sortIndex%2 == 0) {
				//如果已经排序了则直接倒序
				trsValue.reverse();
			} else {
				for(var i = 0; i < len; i++) {
					//split() 方法用于把一个字符串分割成字符串数组
					//获取每行分割后数组的第一个值,即此列的数组类型,定义了字符串\数字\Ip
					type = trsValue[i].split(".separator")[0];
					for(var j = i + 1; j < len; j++) {
						//获取每行分割后数组的第二个值,即文本值
						value1 = trsValue[i].split(".separator")[1];
						//获取下一行分割后数组的第二个值,即文本值
						value2 = trsValue[j].split(".separator")[1];
						//接下来是数字\字符串等的比较
						if(type == "number") {
							value1 = value1 == "" ? 0 : value1;
							value2 = value2 == "" ? 0 : value2;
							if(parseFloat(value1) > parseFloat(value2)) {
								var temp = trsValue[j];
								trsValue[j] = trsValue[i];
								trsValue[i] = temp;
							}
						} else {
							if(value1.localeCompare(value2) > 0) { //该方法不兼容谷歌浏览器
								var temp = trsValue[j];
								trsValue[j] = trsValue[i];
								trsValue[i] = temp;
							}
						}
					}
				}
			}

			for(var i = 0; i < len; i++) {
				table.find("tbody tr:eq(" + i + ")").html(trsValue[i].split(".separator")[2]);
			}

			sortIndex += 1;
			
		}


function getTime() {  
	var nS = new Date();
    var year=nS.getFullYear(); 
    var mon = nS.getMonth()+1; 
    if(mon < 10){
    	mon = "0"+mon;
    }
    var day = nS.getDate(); 
    if(day < 10){
    	day = "0"+day;
    }
    var hours = nS.getHours(); 
    if(hours < 10){
    	hours = "0"+hours;
    }
    var minu = nS.getMinutes(); 
    if(minu < 10){
    	minu = "0"+minu;
    }
    var sec = nS.getSeconds(); 
    if(sec < 10){
    	sec = "0"+sec;
    }
     
    return year+'-'+mon+'-'+day+' '+hours+':'+minu+':'+sec; 
} 


var drList = [];
function compareWord(xq,ld,dy,hh,startTime,endTime,wordList,j,compareWordList){
	var json;
	compareWordList.length=0;
	
	$.ajax({
		url : "searchInfo.action", 
		async : false,
		dataType : "json",
		data : {
			"xqm":xq,
			"ldh":ld,
			"dyh":dy,
			"hh":hh,
			"time1":startTime,
			"time2":endTime,
		},
		success : function(data) {
		 json=data.list;
	
		}
		
	
	});

	for (var i = 0 ; i < json.length ; i ++) {
		var arr1 = [];
		arr1[0] = json[i].id;
		arr1[1] = json[i].yhbh;
		arr1[2] = json[i].yhxm;
		arr1[3] = json[i].fpdz;
		arr1[4] = json[i].ldh;
		arr1[5] = json[i].dyh;
		arr1[6] = json[i].hh;
		arr1[7] = json[i].sdwd;
		arr1[8] = json[i].snwd;
		if(json[i].ms=="01"){
			arr1[9]="制热"
		}else{
			arr1[9]="制冷"
		}
		
		arr1[10] = json[i].yydl;
		arr1[11] = json[i].syje;
		if(json[i].dw=="03"){
			arr1[12]="高档"
		}
		if(json[i].dw=="02"){
			arr1[12]="中档"
		}
		if(json[i].dw=="01"){
			arr1[12]="低档"
		}
		if(json[i].dw=="00"){
			arr1[12]="停止"
		}
		arr1[13] = json[i].gdtime;
		arr1[14] = json[i].zdtime;
		arr1[15] = json[i].ddtime;
		arr1[16] = json[i].dgdtime;
		arr1[17] = json[i].dzdtime;
		arr1[18] = json[i].dddtime;
		
		arr1[19] = json[i].time;
		arr1[20] = json[i].mj;
		arr1[21] = json[i].lxdh;
		if(json[i].jf=="01"){
			arr1[22]="允许计费"
		}
		if(json[i].jf=="00"){
			arr1[22]="禁止计费"
		}
		
		
		
		if(json[i].kg=="01"){
			arr1[23]="自动运行"
		}
		if(json[i].kg=="00"){
			arr1[23]="强制关闭"
		}
		if(json[i].bj=="00"){
			arr1[24]="正常"
		}else if(json[i].bj=="01"){
			arr1[24]="开盖"
		}else if(json[i].bj=="03"){
			arr1[24]="盗热嫌疑"
		}else if(json[i].bj=="04"){
			arr1[24]="通讯异常"
		}else{
			arr1[24]=""
		}
		if(json[i].jj=="00"){
			arr1[25]="夏季"
		}else if(json[i].jj=="01"){
			arr1[25]="冬季"
		}else{
			arr1[25]=""
		}
		arr1[26] = json[i].xqm;
		/*arr1[27] = json[i].bz;*/
		/*xinwordList.push(arr1);*/
		drList.push(arr1);
		compareWordList.push(arr1);
	};
};






//导出
var wordExport = document.getElementById("export_btn");
wordExport.onclick = function(){
	var aID =  this.parentNode.getAttribute("id");
	tableToExcel();
}

  
//base64转码
var base64 = function (s) {
    return window.btoa(unescape(encodeURIComponent(s)));
};
//替换table数据和worksheet名字
var format = function (s, c) {
    return s.replace(/{(\w+)}/g,
        function (m, p) {
            return c[p];
        });
}
function tableToExcel(){
    //要导出的json数据
  
    //列标题
    let str = '<tr><td>用户编码</td><td>用户姓名</td><td>风盘地址</td>'+
    '<td>楼栋</td><td>单元</td><td>户号</td>'+
    '<td>设定温度</td><td>出风温度</td><td>模式</td>'+
    '<td>已用当量</td><td>剩余费用</td><td>档位</td>'+
    '<td>制冷高档</td><td>制冷中档</td><td>制冷抵挡</td>'+
    '<td>制热高档</td><td>制热中档</td><td>制热抵挡</td>'+
    '<td>采集时间</td><td>用户面积</td><td>用户电话</td><td>计费状态</td><td>运行状态</td>'+
    '<td>报警信息</td><td>季节</td><td>小区名称</td>'+
    '</tr>';
    //循环遍历，每行加入tr标签，每个单元格加td标签
    for(let i = 0 ; i < drList.length ; i++ ){
    	
      str+='<tr>';
     
      for(let item in drList[i]){
          //增加\t为了不让表格显示科学计数法或者其他格式
    	  if(item!=0){
    		  str+=`<td>${ drList[i][item] + '\t'}</td>`;
    	  }
      }
      str+='</tr>';
    	
    }
    //Worksheet名
    let worksheet = 'Sheet1'
    let uri = 'data:application/vnd.ms-excel;base64,';

    //下载的表格模板数据
    let template = `<html xmlns:o="urn:schemas-microsoft-com:office:office" 
    xmlns:x="urn:schemas-microsoft-com:office:excel" 
    xmlns="http://www.w3.org/TR/REC-html40">
    <head><!--[if gte mso 9]><xml><x:ExcelWorkbook><x:ExcelWorksheets><x:ExcelWorksheet>
      <x:Name>${worksheet}</x:Name>
      <x:WorksheetOptions><x:DisplayGridlines/></x:WorksheetOptions></x:ExcelWorksheet>
      </x:ExcelWorksheets></x:ExcelWorkbook></xml><![endif]-->
      </head><body><table>${str}</table></body></html>`;
    //下载模板
    window.location.href = uri + base64(template)
  }
  //输出base64编码
  function base64 (s) { return window.btoa(unescape(encodeURIComponent(s))) }

  
  
  
  
  //表格写入函数
function tbodydis(oldlist,newlist,opt){

	var current = 1;

	function pageInit(currentPage, pagesize) {
		current = currentPage; //将当前页存储全局变量
		pageCount = Math.ceil(newlist.length / pagesize); //一共分多少页
		currentNum.innerHTML = currentPage;
		num.innerHTML = newlist.length + "条";
		pages.innerHTML = pageCount;
		var startRow = (currentPage - 1) * pagesize; //开始显示的行
		var endRow = currentPage * pagesize - 1; //结束显示的行
		var endRow = (endRow > newlist.length) ? newlist.length : endRow; //如果结束行数大于总数目，显示总数目，否则结束行
		
		var html = "";
		
		for(var i = 0; i < newlist.length; i++) {
			if(i >= startRow && i <= endRow) { //通过间隔分隔数组
				if(i%2 == 1){
					html += "<tr class='gradeX odd'>";
				}else if(i%2 == 0){
					html += "<tr class='gradeX even'>";
				}
				

				for (var j = 0 ; j <newlist[i].length ; j ++) {
					if( opt.indexOf(newlist[i][26]) == -1){
						opt.push(newlist[i][26]);
					}
					if(j==0||j==26||j==27){

                    	html += "<td style='display:none;'>" + newlist[i][j] + "</td>";
    				}else{

                        html += "<td>" + newlist[i][j] + "</td>"
    				}
				}
			
			}
		}
		
		xinword_body.innerHTML = html;

		

		if(oldlist == ""){
			oldlist = newlist;
			for(var i = 0; i < oldlist.length; i++) {
				for (var j = 0 ; j <oldlist[i].length ; j ++) {
					if(j == 26 && opt.indexOf(oldlist[i][26]) == -1){
						opt.push(oldlist[i][26]);
					} 
				}
			}
			for(var i = 0; i < opt.length; i++) {
				$("#xq").append("<option>"+opt[i]+"</option>");
			}
		}
		
		

		
		var classname = "";
		$("table tbody td").hover(function() {
			classname = $(this).parent().attr("class");
			$(this).parent().removeClass(classname).addClass("blue");
			$("table tbody tr").find('td:eq(' + $(this).index() + ')').addClass('blue')
		}, function() {
			$(this).parent().removeClass("blue").addClass(classname);
			$("table tbody tr").find('td:eq(' + $(this).index() + ')').removeClass('blue')
		});

	}
	
	select.onchange = function(ev) {
		pageInit(1, this.value)
	}
	first.onclick = function() {
		pageInit(1, select.value)
	}
	end.onclick = function() {
		pageInit(pageCount, select.value)
	}

	next.onclick = function() {
		var curr = current + 1;
		if(curr > pageCount) {
			return
		}
		pageInit(curr, select.value)
	}

	last.onclick = function() {
		var curr = current - 1;
		if(curr < 1) {
			return
		}
		pageInit(curr, select.value)
	}
	pageInit(1, 15);

}