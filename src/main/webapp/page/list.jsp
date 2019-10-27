<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<!-- saved from url=(0030)http://localhost:8080/House-2/ -->
<HTML xmlns="http://www.w3.org/1999/xhtml"><HEAD><TITLE>青鸟租房 - 首页</TITLE>
<META content="text/html; charset=utf-8" http-equiv=Content-Type>
<LINK rel=stylesheet type=text/css href="../css/style.css">
<META name=GENERATOR content="MSHTML 8.00.7601.17514"></HEAD>
<script language="JavaScript" src="../scripts/jquery-1.8.3.js"></script>
<script language="JavaScript">
  $(function () {
      $.post(
          "/page/getTypes",
          null,
          function (data) {
              $(data).each(function (i, e) {
                  $("#type_id").append(
                      "<option value='"+e.id+"'>"+e.name+"</option>"
                  )
              })
              $("#type_id").val(${selHouse.typeId});
          },"json"
      )
      $.post(
          "/page/selectStreets",
          null,
          function (data) {
              $(data).each(function (i, e) {
                  $("#street").append(
                      "<option value='"+e.id+"'>"+e.name+"</option>"
                  )
              })
              $("#street").val(${selHouse.streetId})
          },"json"
      )
  })
</script>
<BODY>
<DIV id=header class=wrap>
<DIV id=logo><IMG src="../images/logo.gif"></DIV></DIV>
<DIV id=navbar class=wrap>
<DL class="search clearfix">
  <form id="myForm" method="post" action="${pageContext.request.contextPath}/page/getExHousesBySome">
    <input type="hidden" name="page" id="setPage">
    标题:<input type="text" name="title" value="${selHouse.title}">
    街道:<select id="street" name="streetId"><option selected value="">不限</option></select>
    房型:<select name="typeId" id="type_id"> <option selected value="">不限</option></select>
    价格:<input type="text" name="lowPrice" value="${selHouse.lowPrice}" width="30">-<input type="text" name="topPrice" value="${selHouse.topPrice}" width="30">
    <LABEL class=ui-blue><input value="搜索房屋" type="submit" name="search"></LABEL>
  </form></DL></DIV>
<DIV class="main wrap">
<TABLE class=house-list>
  <TBODY>
  <TR>
    <c:forEach items="${houses.list}" var="h">
    <TD class=house-thumb><span><A onclick="javascript:toDetails(${h.id})" href="" target="_blank"><img src="http://localhost:80/${h.path}" width="100" height="75" alt=""></a></span></TD>
    <TD>
      <DL>
        <DT><A onclick="javascript:toDetails(${h.id})" href="" target="_blank">${h.title}</A></DT>
        <DD>${h.dname}区${h.sname},${h.floorage}平米<BR>联系方式：${h.contact} </DD></DL></TD>
    <TD class=house-type>${h.tname}</TD>
    <TD class=house-price><SPAN>${h.price}</SPAN>元/月</TD></TR>
  </c:forEach>
  <TR></TR></TBODY></TABLE>
<DIV class=pager>
<UL>
  <LI class=current><A href="javascript:toPage(1)">首页</A></LI>
  <LI><A href="javascript:toPage(${houses.prePage==0?1:houses.prePage})">上一页</A></LI>
  <LI><A href="javascript:toPage(${houses.nextPage==0?houses.pages:houses.nextPage})">下一页</A></LI>
  <LI><A href="javascript:toPage(${houses.pages})">末页</A></LI></UL><SPAN
class=total>${houses.pageNum}/${houses.pages}页</SPAN> </DIV></DIV>
<DIV id=footer class=wrap>
<DL>
  <DT>青鸟租房 © 2018 北大青鸟 京ICP证1000001号</DT>
  <DD>关于我们 · 联系方式 · 意见反馈 · 帮助中心</DD></DL></DIV></BODY>
<script language="JavaScript" src="../scripts/jquery-1.8.3.js"></script>
<script language="JavaScript">
    function toDetails(id) {
        location.href="${pageContext.request.contextPath}/page/getDetails?id="+id;
    }
    function toPage(page) {
        $("#setPage").val(page);
        $("#myForm").submit();
    }
</script>
</HTML>
