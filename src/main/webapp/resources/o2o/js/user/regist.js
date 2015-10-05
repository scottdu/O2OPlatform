$(document).ready(function(){
	$("#submit_btn").click(function(){
		
		var $this = $(this),
		theme = $this.jqmData("theme") || $.mobile.loader.prototype.options.theme,
		msgText = $this.jqmData("msgtext") || $.mobile.loader.prototype.options.text,
		textVisible = $this.jqmData("textvisible") || $.mobile.loader.prototype.options.textVisible,
		textonly = !!$this.jqmData("textonly");
		html = $this.jqmData("html") || "";
		$.mobile.loading("show", {
			text: msgText,
			textVisible: textVisible,
			theme: theme,
			textonly: textonly,
			html: html
		});
		setTimeout(function(){
			doSubmit();
		},1000);
	});
	
	function doSubmit() {

		var jsonStr = "{";
		jsonStr += "'username':'"+$("#username").val()+"',";
		jsonStr += "'password':'"+$("#password").val()+"',";
		jsonStr += "'re_password':'"+$("#re_password").val()+"',";
		jsonStr += "'gender':'"+$("#gender").val()+"',";
		jsonStr += "'email':'"+$("#email").val()+"',";
		jsonStr += "'mobile':'"+$("#mobile").val()+"',";
		jsonStr += "'user_type':'"+$("#user_type").val()+"',";
		jsonStr += "'fix_phone_no':'"+$("#fix_phone_no").val()+"',";
		jsonStr += "'country':'"+$("#country").val()+"',";
		jsonStr += "'province':'"+$("#province").val()+"',";
		jsonStr += "'city':'"+$("#city").val()+"',";
		jsonStr += "'street':'"+$("#street").val()+"',";
		jsonStr += "'work_address':'"+$("#work_address").val()+"'";
		jsonStr += "}";
		
		//alert(jsonStr);
		
		$.ajax({
			type:"POST",
			url:contextPath+"/user/regist",
			data:jsonStr,
			contentType:"application/json;charset=utf-8",
			datatype:"json",
			beforeSend:function() { //loading... 
				//alert("loading.........");
			},
			success:function(data){
		   		var resultCode = data.resultCode;
		   		var resultDesc = data.resultDesc;
		   		if("0" == resultCode) {
		   			//alert("注册成功");
		   			$.mobile.loading("hide");
		   			window.location.href=contextPath+"/index.jsp";
		   		}
		   		else {
		   			$.mobile.loading("hide");
		   			alert(resultDesc);
		   		}
		    },
		    error:function() {
		    	//alert("error.......");
		    }
		});
	}
	
});