$(function () {
    $("input[name='username']").val(getCookie("username"));
    if(getCookie("username")!=""){
        $($("input[type=checkbox]").get(0)).attr("checked","checked");
    }

    $("input[name='username']").blur(function () {
        // refresh("username");
        checkNull("username","用户名不能为空");
    });
    $("input[name='password']").blur(function () {
        // refresh("password");
        checkNull("password","密码不能为空");
    });
    
    $(".form-horizontal").submit(function () {
        var username = $("#loginUsername").val();
        var password = $("#loginPassword").val();
        password=window.btoa(password);
        var rem = $("input[type=checkbox]").get(0).checked;
        $.post("/user/doLogin/"+username+"/" + password,function (result) {
            if(result.status==200){
                if(rem){//"记住我"打勾
                    setCookie("username",username,30*24);
                }else{
                    delCookie("username");
                }
                window.location.href="/index.html";
            }else if(result.status==201){
                alert(result.msg);
            }else{
                alert("登录失败,请重试")
            }
        });
        return false;
    });
});

// function refresh(name) {
//     $("input[name="+name+"]").next("span").text("");
// }

function checkNull(name, msg) {
    var value = $("input[name="+name+"]").val();
    setMsg(name,"");
    if($.trim(value)==""){
        setMsg(name,msg);
        return false;
    }
    return true;
}

function setMsg(name, msg) {
    $("input[name="+name+"]").next("span").html(msg).css("color","red");
}

function checkLoginForm() {
    var flag = true;
    flag=checkNull("username","用户名不能为空")&&flag;
    flag=checkNull("password","密码不能为空")&&flag;
    return flag;
}

function register() {
    return location.href="/page/register.html";
}

function index() {
    return location.href="/index.html";
}