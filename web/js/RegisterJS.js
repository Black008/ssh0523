/**
 * Created by Administrator on 18-3-27.
 */
function f(id) {
    return document.getElementById(id);
}
/*时间的设定*/
function onDisplay() {
    var today = new Date();
    var y =today.getFullYear();
    var M =today.getMonth()+1;
    var d =today.getDay();
    var h =today.getHours();
    var m =today.getMinutes();
    var s =today.getSeconds();
    M=checkTime(M);
    d=checkTime(d);
    h=checkTime(h);
    m=checkTime(m);
    s=checkTime(s);
    f("CurrentDate").innerHTML=y+"-"+M+"-"+d+" "+h+":"+m+":"+s;
    t=setTimeout("onDisplay()",1000);
}
function checkTime(i) {
    if(i<10){
        i="0"+i;
    }
    return i;
}


/*验证正则*/
function changenote() {
    if(f("namenum").validity.valueMissing){
        f("demo").innerHTML="输入用户名！";
        return;
    }
    else {
        f("demo").innerHTML="";
    }
    if(f("namenum").validity.patternMismatch){
        f("demo").innerHTML="不符合正则！";
        return
    }
    else {
        /*判断用户是否存在*/
        $.post("checkUserisexist",{
            'tuser.user':$("#namenum").val()
        },function (data) {
            /*如果用户不存在点击提交按钮就插入同时自动跳转到登陆界面*/
            if(data=="可以注册"){
                $("#clicksubmit").click(function () {
                    $.post("regsubmit",{
                        'tuser.user':$("#namenum").val(),
                        'tuser.pwd':$("#pas1").val()
                    },function (data) {
                        /*密码验证*/
                            if(f("pas1").value != f("pas2").value){
                                /*f("demo2").setCustomValidity("密码两次输入不一致！");*/
                                $("#demo2").html("两次输入不一致");

                            }else{

                                if(data=="注册成功请登录"){
                                    alert("注册成功请登录");
                                    window.location.href="centerlogin.jsp";
                                }
                            }
                    },"json");
                })
            }
            $("#demo").html(data);
            },"json");
    }
}
/*var i = 5;
function onTime() {
    /!*var sec = document.getElementById("second");
    sec.innerHTML = i;
    sec.innerHTML="倒计时"+ i-- +"秒后跳转";*!/
    setInterval("onTime()",1000);
}*/
function changenote1() {
    if(f("pas1").validity.valueMissing){
        f("demo1").innerHTML="请输入密码！";
        return;
    }
    else {
        f("demo1").innerHTML="";
    }
    if(f("pas1").validity.patternMismatch || f("pas1").value.length>8){
        f("demo1").innerHTML="不符合正则！";
        return
    }
    else {
        f("demo1").innerHTML="";
    }
}

function changenote2() {
    if(f("pas2").validity.valueMissing){
        f("demo2").innerHTML="确认输入密码！";
        return;
    }
    else {
        f("demo2").innerHTML="";
    }
    if(f("pas2").validity.patternMismatch || f("pas2").value.length>8){
        f("demo2").innerHTML="不符合正则！";
        return
    }
    else {

        f("demo2").innerHTML="";
    }
}

/*淡入淡出*/
$(document).ready(function () {
    $(".boxnav2").click(function () {
        $(".boxlg").fadeIn(500);
    })

    $(".boxlg").mouseleave(function () {
        $(".boxlg").fadeOut(500);
    })

    $(".imgchange").hover(function () {
        $(".imgchange").attr("src","img/up.png");
    })
    $(".imgchange").mouseleave(function () {
        $(".imgchange").attr("src","img/down.png");
    })

})

/*点击添加按钮和查询提示请登录*/
$("#qreg").click(function () {
    alert("请登录")
})
$("#qqreg").click(function () {
    alert("请登录")
})




/*function clicksubmit(){

    $("#clicksubmit").click(function () {
        window.location.href="/BusinessMS/centerlogin.jsp";
    })
}*/




