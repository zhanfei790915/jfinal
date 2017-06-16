var UA = navigator.userAgent.toLowerCase();
var browerKernel = {
	isIE : function() {
		if (/msie/i.test(UA) && !/opera/.test(UA))
			return true;
		else
			return false;
	},
	isFirefox : function() {
		if (/firefox/i.test(UA))
			return true;
		else
			return false;
	},
	isChrome : function() {
		if (/chrome/i.test(UA) && /webkit/i.test(UA) && /mozilla/i.test(UA))
			return true;
		else
			return false;
	},
	isOpera : function() {
		if (/opera/i.test(UA))
			return true;
		else
			return false;
	},
	isSafari : function() {
		if (/webkit/i.test(UA)
				&& !(/chrome/i.test(UA) && /webkit/i.test(UA) && /mozilla/i
						.test(UA)))
			return true;
		else
			return false;
	}
};
function getURL(url) {
	var xmlHttp;
	try {
		xmlHttp = new XMLHttpRequest();
	} catch (e) {
		try {
			xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
		} catch (e) {
			try {
				xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (e) {
				alert("您的浏览器不支持AJAX！");
				return false;
			}
		}
	}
	if (xmlHttp) {
		xmlHttp.open("GET", url, false);
		xmlHttp.send();
		if (xmlHttp.readyState == 4) {
			if (xmlHttp.status != 200)
				alert("不存在");
			return xmlHttp.status == 200;
		}
	}
}
function submitForm() {
	$.messager.progress(); // 显示进度条
	$('#loginform').form('submit', {
				url : "/toLogin",
				method : "post",
				onSubmit : function(param) {
					var isValid = $(this).form('validate');
					if (!isValid) {
						$.messager.progress('close'); // 如果表单是无效的则隐藏进度条
					}
					return isValid; // 返回false终止表单提交
				},
				success : function() {
					$.messager.progress('close'); // 如果提交成功则隐藏进度条
					this.submit();
				}
			});
}
// 提交表单的另一种写法，不推荐
function submitForm_b() {
	var ajaxhtml = $("#loginbtn").html();
	$("#loginbtn").html("Loading....");
	$("#loginbtn").attr("disabled", "disabled");
	$("#loginform").submit();
}
//用户注册
function registeForm(){
	loginform.action = "/toRegist";
	loginform.submit();
}

if (!browerKernel.isIE() && !browerKernel.isFirefox()
		&& !browerKernel.isChrome() && !browerKernel.isOpera()
		&& !browerKernel.isSafari()) {
	alert("您当前浏览器无法兼容本系统！\n推荐使用本机指定的客户端访问工具！\n\n其它兼容浏览器：\nIE浏览器\n火狐浏览器3\nChrome浏览器\n其它浏览器请自测");
} else {
	// getURL("/ui/js/plugins/jquery-easyui-1.5.1/jquery.min.js");
	$(document).ready(function() {
				$('#loginid').textbox('textbox').keydown(function(e) {
							if (e.keyCode == 13) {
								$('#loginpwd').textbox('textbox').focus();
							}
						});
				$("#loginbtn").click(function() {
							submitForm();
						});
				$("#registbtn").click(function(){
							registeForm();
						});
			});
}