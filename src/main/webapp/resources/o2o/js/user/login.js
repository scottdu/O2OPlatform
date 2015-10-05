$(document).ready(function(){
	
	$("#regist_btn").click(function(){
		window.location.href=contextPath+"/user/regist";
	});
	
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
	function doSubmit()
	{
		var jsonStr = "{";
		jsonStr += "'password':'"+$("#password").val()+"',";
		jsonStr += "'email':'"+$("#username").val()+"',";
		jsonStr += "'mobile':'"+$("#username").val()+"'";
		jsonStr += "}";
		
		//alert(jsonStr);
		
		$.ajax({
			type:"POST",
			url:contextPath+"/user/login",
			data:jsonStr,
			contentType:"application/json;charset=utf-8",
			datatype:"json",
			beforeSend:function() { //loading... 
				
			},
			success:function(data){
		   		var resultCode = data.resultCode;
		   		var resultDesc = data.resultDesc;
		   		if("0" == resultCode) {
		   			$.mobile.loading("hide");
		   			window.location.href=contextPath+"/user/main";
		   		}
		   		else {
		   			$.mobile.loading("hide");
		   			alert(resultDesc);
		   		}
		    },
		    error:function() {
		    }
		});
	}
	
});