<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page pageEncoding="UTF-8" contentType="text/html; UTF-8" language="java"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<!-- saved from url=(0044)http://localhost:8080/HouseRent/page/add.jsp -->
<HTML xmlns="http://www.w3.org/1999/xhtml"><HEAD><TITLE>青鸟租房 -发布房屋信息</TITLE>
<META content="text/html; charset=utf-8" http-equiv=Content-Type><LINK 
rel=stylesheet type=text/css href="../css/style.css">
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
                $("#type_id").val(${typeId});
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
                $("#street").val(${streetId})
            },"json"
        )
    })
</script>
<BODY>

<DIV id=header class=wrap>
<DIV id=logo><IMG src="../images/logo.gif"></DIV>
<DIV class=search>
<FORM method=post><INPUT class=text type=text name=keywords id="title">
 <LABEL class="ui-green searchs"><a onclick="javascript:searchHouse()" href="" target="_blank">搜索房屋</a></LABEL>
</FORM></DIV></DIV>
<DIV id=navbar class=wrap>
<DL class="search clearfix">
  <FORM id=sform method=post action=/page/getExHousesBySome>
  <DT>
      <UL>
          <LI class=bold>房屋信息</LI>
          <LI>标题：<INPUT class=text type=text name=title value="${title}"> <LABEL class=ui-blue><INPUT value=搜索房屋 type=submit name=search></LABEL>
          </LI></UL></DT>
  <DD>
  <UL>
    <LI class=first>价格 </LI>
    <LI><SELECT id=price name=price> <OPTION selected value="">不限</OPTION> 
      <OPTION value=0-100>100元以下</OPTION> <OPTION 
      value=100-200>100元—200元</OPTION> <OPTION 
    value=200-1000000>200元以上</OPTION></SELECT> </LI></UL></DD>
  <DD>
      <UL>
          <LI class=first>房屋位置</LI>
          <LI><SELECT id=street name=streetId> <OPTION selected value="">不限</OPTION></SELECT>
          </LI></UL></DD>
  <DD>
      <UL>
          <LI class=first>房型</LI>
          <LI><SELECT name=typeId id="type_id"> <OPTION selected value="">不限</OPTION></SELECT>
          </LI></UL></DD>
  <DD>
  <UL>
    <LI class=first>面积 </LI>
    <LI><SELECT id=floorage name=floorage> <OPTION selected 
      value="">不限</OPTION> <OPTION value=0-40>40以下</OPTION> <OPTION 
      value=40-500>40-500</OPTION> <OPTION 
    value=500-1000000>500以上</OPTION></SELECT> </LI></UL></DD></FORM></DL></DIV>
<DIV id=position class=wrap>当前位置：青鸟租房网 - 浏览房源</DIV>
<DIV id=view class="main wrap">
<DIV class=intro>
<DIV class=lefter>
<H1>${house.title}</H1>
<DIV class=subinfo><c:formatDate value="${house.pubdate}" pattern="yyyy-MM-dd HH:mm:ss"></c:formatDate></DIV>
<DIV class=houseinfo>
<P>户　　型：<SPAN>${house.tname}</SPAN></P>
<P>面　　积：<SPAN>${house.floorage}m<SUP>2</SUP></SPAN></P>
<P>位　　置：<SPAN>${house.dname}区${house.sname}</SPAN></P>
<P>联系方式：<SPAN>${house.contact}</SPAN></P></DIV></DIV>
<DIV class=side>
<P><A class=bold href="http://localhost:8080/House-2/#">北京青鸟房地产经纪公司</A></P>
<P>资质证书：有</P>
<P>内部编号:1000</P>
<P>联 系 人：</P>
<P>联系电话：<SPAN></SPAN></P>
<P>手机号码：<SPAN>暂无</SPAN></P></DIV>
<DIV class=clear></DIV>
<DIV class=introduction>
<H2><SPAN><STRONG>房源详细信息</STRONG></SPAN></H2>
<DIV class=content>
<P>${house.description}</P></DIV></DIV></DIV></DIV>
<DIV id=footer class=wrap>
<DL>
  <DT>青鸟租房 © 2018 北大青鸟 京ICP证1000001号</DT>
  <DD>关于我们 · 联系方式 · 意见反馈 · 帮助中心</DD></DL></DIV>
</BODY>
<script language="JavaScript" src="../scripts/jquery-1.8.3.js"></script>
<script language="JavaScript">
    function searchHouse() {
        var title = $("#title").val();
        location.href="${pageContext.request.contextPath}/page/getExHousesBySome?title="+title;
    }
</script>
</HTML>
