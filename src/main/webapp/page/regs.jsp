<%@ page pageEncoding="utf-8" language="java" contentType="text/html;utf-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<!-- saved from url=(0049)http://localhost:8080/HouseRent/page/register.jsp -->
<HTML xmlns="http://www.w3.org/1999/xhtml"><HEAD><TITLE>青鸟租房 - 用户注册</TITLE>
<META content="text/html; charset=utf-8" http-equiv=Content-Type><LINK 
rel=stylesheet type=text/css href="../css/style.css">
<META name=GENERATOR content="MSHTML 8.00.7601.17514">
  <script language="JavaScript" src="../scripts/jquery-1.8.3.js"></script>
  <script language="JavaScript">
     $(function(){  //jquery加载事件
         $("#txtName").blur(function () {
             $("#notice").text("");
             var name = $("#txtName").val();
             if(name==null||name.trim()==''){
                 $("#notice").text("用户名不能为空!").css("color","red");
             }else{
                 //发送异步请求
                 $.post("/page/checkName",{"name":name},function(data){
                     if(data){
                         $("#notice").text("用户名可用!").css("color","green");
                     }else{
                         $("#notice").text("用户名不可用!").css("color","red");
                     }
                 },"json");
             }
         });

     });
  </script>
</HEAD>
<BODY>
<DIV id=header class=wrap>
<DIV id=logo><IMG src="../images/logo.gif"></DIV></DIV>
<DIV id=regLogin class=wrap>
<DIV class=dialog>
<DL class=clearfix>
  <DT>新用户注册</DT>
  <DD class=past>填写个人信息</DD></DL>
<DIV class=box>
<FORM action="/page/regs"  method="post" name="form1" onsubmit="return checkTxt()">
<DIV class=infos>
<TABLE class=field>
  <TBODY>
  <TR>
    <TD class=field>用 户 名：</TD>
    <TD><INPUT class=text id="txtName" type=text name=name><span id="notice"></span></TD></TR>
  <TR>
    <TD class=field>密　　码：</TD>
    <TD><INPUT class=text type=password name=password id="txtPwd"><span id="pwdnotice"></span></TD></TR>
  <TR>
    <TD class=field>确认密码：</TD>
    <TD><INPUT class=text type=password name=repassword id="txtRepwd"><span id="repwdnotice"></span></TD></TR>
  <TR>
    <TD class=field>电　　话：</TD>
    <TD><INPUT class=text type=text name=telephone id="txtTel"><span id="telnotice"></span> </TD></TR>
  <TR>
    <TD class=field>年龄：</TD>
    <TD><INPUT class=text type=text name=age id="txtAge"> </TD></TR></TBODY></TABLE>
<DIV class=buttons>
<INPUT  name="adduser" value=立即注册 type="submit">
</DIV></DIV></FORM></DIV></DIV></DIV>
<DIV id=footer class=wrap>
<DL>
  <DT>青鸟租房 © 2018 北大青鸟 京ICP证1000001号</DT>
  <DD>关于我们 · 联系方式 · 意见反馈 · 帮助中心</DD></DL></DIV></BODY>
<script language="JavaScript" src="../scripts/jquery-1.8.3.js"></script>
<script language="JavaScript">
  $("#txtRepwd").blur(function () {
      $("#pwdnotice").text("");
      $("#repwdnotice").text("");
      var pwd = $("#txtPwd").val();
      var repwd = $("#txtRepwd").val();
      if(pwd==null||pwd.trim()==''){
          $("#pwdnotice").text("密码不能为空!").css("color","red");
      }else if (pwd.trim() != repwd.trim()) {
          $("#repwdnotice").text("两次密码不一致!").css("color","red");
      }
  })
  $("#txtTel").blur(function () {
      $("#telnotice").text("");
      var tel = $("#txtTel").val();
      if(tel==null||tel.trim()==''){
          $("#telnotice").text("电话不能为空!").css("color","red");
      }
  })
  function checkTxt() {
      var txtName = $("#txtName").val();
      var txtPwd = $("#txtPwd").val();
      var txtRepwd = $("#txtRepwd").val();
      var txtTel = $("#txtTel").val();
      var txtAge = $("#txtAge").val();

      //var reg=/"^(\d{3,4}-)\d{7,8}$"/;
      var reg=/^1[3578]\d{9}$/;
      //var reg=/\d+/;

      if(txtName==null||txtName.trim()==''){
          alert("用户名为空!");
          return false;
      }
      if(txtPwd==null||txtPwd.trim()==''){
          alert("密码为空!");
          return false;
      }
      if(txtPwd.trim()!=txtRepwd.trim()){
          alert("两次密码不一致!");
          return false;
      }
      if(txtTel==null||txtTel.trim()==''){
          alert("电话为空!");
          return false;
      }else if(!reg.test(txtTel)){
          alert("电话格式不正确!应为11位的数字!");
          return false;
      }
      return true;
  }
</script>
</HTML>
