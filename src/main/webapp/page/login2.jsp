<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="utf-8" language="java" contentType="text/html;utf-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<!-- saved from url=(0032)http://localhost:8080/HouseRent/ -->
<HTML xmlns="http://www.w3.org/1999/xhtml"><HEAD><TITLE>青鸟租房 - 用户登录</TITLE>
<META content="text/html; charset=utf-8" http-equiv=Content-Type><LINK 
rel=stylesheet type=text/css href="../css/style.css">
<META name=GENERATOR content="MSHTML 8.00.7601.17514"></HEAD>
<script language="JavaScript">
  <c:if test="${msg=='fail'}">
    alert("验证码错误!")
  </c:if>
</script>
<BODY>
<DIV id=header class=wrap>
<DIV id=logo><IMG src="../images/logo.gif"></DIV></DIV>
<DIV id=regLogin class=wrap>
<DIV class=dialog>
<DIV class=box>
  <a href="login.jsp" target="_self"><H4>用户登录</H4></a><h4>电话登陆</h4>
<FORM id=user method=post name=user action="/page/login2">
<DIV class=infos>
<TABLE class=field>
  <TBODY>
  <TR>
    <TD colSpan=2></TD></TR>
  <TR>
    <TD class=field>手 机 号：</TD>
    <TD><!-- <input type="text" class="text" name="name" /> --><INPUT 
      id=telephone class=text type=text name=telephone> </TD></TR>
  <TR>
    <TD class=field>验 证 码：</TD>
    <TD><!-- <input type="password" class="text" name="password" /> --><INPUT 
      id=code class=text type=password name=code width="50"><input type="button" onclick="getCode()" value="获取验证码"> </TD></TR><!--
						<tr>
							<td class="field">验 证 码：</td>
							<td><input type="text" class="text verycode" name="veryCode" /></td>
						</tr>
						--></TBODY></TABLE>
<DIV class=buttons> <INPUT value=登陆 type=submit name="sub"> <INPUT onclick='document.location="${pageContext.request.contextPath}/page/regs.jsp"' value=注册 type=button>
</DIV></DIV></FORM></DIV></DIV></DIV>
<DIV id=footer class=wrap>
<DL>
  <DT>青鸟租房 © 2019 武汉青鸟 京ICP证1000001号</DT>
  <DD>关于我们 · 联系方式 · 意见反馈 · 帮助中心</DD></DL></DIV></BODY>
<script language="JavaScript" src="../scripts/jquery-1.8.3.js"></script>
<script language="JavaScript">
  function getCode() {
      var telephone = $("#telephone").val();
      $.post(
          "/page/getCode",
          {"telephone":telephone},
          function (data) {
              if(data.tel==false){
                  alert("手机号不存在!");
              }else{
                  if(data.sendCode){
                      alert("验证码发送成功!");
                  }else{
                      alert("验证码发送失败!");
                  }
              }
          }
      )
  }
</script>
</HTML>
