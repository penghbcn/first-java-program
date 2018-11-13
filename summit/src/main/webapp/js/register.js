$(function () {

    $("input[name='username']").blur(function () {
        // refresh("username");
        checkNull("username","用户名不能为空");
    });
    $("input[name='password1']").blur(function () {
        // refresh("password1");
        checkNull("password1","密码不能为空");
    });
    $("input[name='password2']").blur(function () {
        // refresh("password2");
        checkNull("password2","确认密码不能为空");

        var password1 = $("#registerPassword1").val();
        var password2 = $("#registerPassword2").val();
        if(password1!==password2){
            setMsg("password2","确认密码与密码不一致");
        }
    });

    $("#registerForm").submit(function () {
        var username = $("#registerUsername").val();
        var password = $("#registerPassword1").val();
         password=window.btoa(password);
        var rem = $("input[type=checkbox]").get(0).checked;
        alert(username+" "+password+" "+rem);
        if (rem) {
            $.post("/user/doRegister/" + username + "/" + password, function (result) {
                if (result.status == 200) {
                        setCookie("username", username, 30 * 24);
                        alert("注册成功！")
                    window.location.href = "/index.html";
                } else if (result.status == 201) {
                    alert(result.msg);
                } else {
                    alert("注册失败。。。")
                }
            });
        }
        return false;
    });

    $("#userAgreementN").click(function () {
        $("#userAgreementCheckBox").removeAttr("checked");
    })

    $("#userAgreementY").click(function () {
        $("#userAgreementCheckBox").attr("checked","checked");
    })
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

function checkRegisterForm() {
        var flag = true;
        flag=checkNull("username","用户名不能为空")&&flag;
        flag=checkNull("password1","密码不能为空")&&flag;
        flag=checkNull("password2","确认密码不能为空")&&flag;
        return flag;
}

function login() {
    return location.href="/page/login.html";
}

function index() {
    return location.href="/index.html";
}