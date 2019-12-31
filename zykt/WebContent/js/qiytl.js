$(document).ready(function() {

	//轮播图

	var slideBox = $(".slideBox");
	var ul = slideBox.find("ul");
	var oneWidth = slideBox.find("ul li").eq(0).width();
	var number = slideBox.find(".spanBox span"); //注意分号 和逗号的用法
	var timer = null;
	var sw = 0;
	//每个span绑定click事件，完成切换颜色和动画，以及读取参数值
	number.on("click", function() {
		$(this).addClass("active").siblings("span").removeClass("active");
		sw = $(this).index();
		ul.animate({
			"right" : oneWidth * sw, //ul标签的动画为向左移动；
		});
	});
	//左右按钮的控制效果
	$(".next").stop(true, true).click(function() {
		sw++;
		if (sw == number.length) {
			sw = 0
		}
		;
		number.eq(sw).trigger("click");
	});
	$(".prev").stop(true, true).click(function() {
		sw--;
		if (sw == number.length) {
			sw = 0
		}
		;
		number.eq(sw).trigger("click");
	});
	//定时器的使用，自动开始
	timer = setInterval(function() {
		sw++;
		if (sw == number.length) {
			sw = 0
		}
		;
		number.eq(sw).trigger("click");
	}, 2000);
	//hover事件完成悬停和，左右图标的动画效果
	slideBox.hover(function() {
		$(".next,.prev").animate({
			"opacity" : 1,
		}, 200);
		clearInterval(timer);
	}, function() {
		$(".next,.prev").animate({
			"opacity" : 0.5,
		}, 500);
		timer = setInterval(function() {
			sw++;
			if (sw == number.length) {
				sw = 0
			}
			;
			number.eq(sw).trigger("click");
		}, 2000);
	})
	
	
	

	var newsList = [];
	function jsArrChange(json){
		for (var i = 0 ; i < json.length ; i ++) {
			var arr1 = [];
			arr1[0] = json[i].title;
			arr1[1] = json[i].contents;
			arr1[2] = json[i].author;
			arr1[3] = json[i].tm;
			arr1[4] = json[i].id;
			
			newsList.push(arr1);
		};
	}
	jsArrChange(zskList);
	


	
	var newsTbody = document.getElementById("news_body");
	for(var i = 0;i < newsList.length;i ++){
		var newsTr = document.createElement("tr");
		if(i%2 == 1){
			newsTr.className = "gradeX odd";
		}else if(i%2 == 0){
			newsTr.className = "gradeX even";
		}
		newsTr.innerHTML += "<td><input type='checkbox' value='"+newsList[i][4]+"' name='check'/></td>";

		
		for(var j = 0;j < newsList[i].length;j ++){

		

			newsList[i][j] = newsList[i][j]+"";
//			if(newsList[i][j].length > 15){
//				var new_newsList = newsList[i][j].slice(0,14);
//				newsTr.innerHTML += "<td>" + new_newsList + "···</td>";
//			}else{
//				newsTr.innerHTML += "<td>" + newsList[i][j] + "</td>";
//			}

			if(j == 0){
				newsTr.innerHTML += "<td><a href='#'>" + newsList[i][j] + "</a></td>";
				continue;
			}

			if(j == 1||j==4){

				newsTr.innerHTML += "<td style='display:none;'>" + newsList[i][j] + "</td>";
				//console.log(newsList[i][j]);
				continue;
			}
			
			newsTr.innerHTML += "<td>" + newsList[i][j] + "</td>";
		
		}
		newsTr.innerHTML += "<td><input class='del_btn qiy_del'  type='button' value='删除' /><input class='mod_btn' type='button' value='修改' /></td>";
		newsTbody.appendChild(newsTr);
	
	}
	//全选
	var allCheck = $(".all_option input[name='check']");

	allCheck.click(function(){
		$("input[type='checkbox']").prop("checked",$(this).prop("checked"));

	});
	
	//删除按钮
	$(".del_btn").click(function(){
		var xintr = $(this).parent().parent().children();
		var id=xintr[5].innerHTML
		 layer.confirm('确认删除么', function(index) {
			                 $.ajax({
			                     type: "post",
			                    url: "deleteZsk.action",
			                      dataType:'json',
			                  	data:{	
			      					"id":id,
			      					"type":"企业条例",
			      				},
			                     dataType: "json",
			                      success: function (data) {
			                    	   layer.close(index);
			                          window.location.reload();
			                     },
			  
			                 })
			              });
	});
	$("#option_del").click(function(){

		 layer.confirm('确认删除么', function(index) {
			 $('input[name="check"]:checked').each(function (index, item) {
				          console.log($(this).val())
				          $.ajax({
			                     type: "post",
			                    url: "deleteZsk.action",
			                      dataType:'json',
			                  	data:{	
			      					"id":$(this).val(),
			      					"type":"企业条例",
			      				},
			                     dataType: "json",
			                      success: function (data) {
			                    	   
			                     },
			  
			                 })
			                 
				    });
			 layer.close(index);
             window.location.reload();
			              });
	});
	
	//新增文章
	$("#option_cr").click(function(){
		$(".wz_crea").show();
		var nowTime = getTime();
		$(".wz_crea input[name='tm']").val(nowTime);
	});
	
	//修改文章
	$(".mod_btn").click(function(){
		wz_change(this)
	});

	//关闭修改
	$(".wz_modify .close").click(function(){
		$(".wz_modify").hide();
	});
	$(".wz_crea .close").click(function(){
		$(".wz_crea").hide();
	});
	$(".wz_look .close").click(function(){
		$(".wz_look").hide();
	});
	
	//修改文章
	$("td a").click(function(){
		wz_look(this)
	});

})   

function wz_change(p){
	$(".wz_modify").show();
	var xintd = $(p).parent().parent().children();
	//修改数据
	var changenewsList = [];
	for(var x = 1 ; x < 6; x ++){
		if(x == 1){
			changenewsList.push(xintd[x].childNodes[0].innerHTML);
			continue;
		}
		changenewsList.push(xintd[x].innerHTML);
	}
	
	var changeInput = $(".wz_modify .wz_modify_input");
	for(var i = 0;i < changeInput.length;i ++){
		changeInput[i].value = changenewsList[i];
	}
}

function wz_look(p){
	$(".wz_look").show();
	var xintd = $(p).parent().parent().children();
	//修改数据
	var changenewsList = [];
	for(var x = 1 ; x < 5 ; x ++){
		if(x == 1){
			changenewsList.push(xintd[x].childNodes[0].innerHTML);
			continue;
		}
		changenewsList.push(xintd[x].innerHTML);
	}
	$(".wz_look_title").html(changenewsList[0]);
	$(".wz_look_content").html(changenewsList[1]);
	$(".wz_look_autor").html(changenewsList[2]);
	$(".wz_look_time").html(changenewsList[3]);
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