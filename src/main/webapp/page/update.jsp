<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
                $("#type_id").val(${house.typeId})
            },"json"
        )
        $.post(
            "/page/queryDistricts",
            null,
            function (data) {
                $(data).each(function (i, e) {
                    $("#district_id").append(
                        "<option value='"+e.id+"'>"+e.name+"</option>"
                    )
                })
                $("#district_id").val(${house.did});
                changeStreet();
            },"json"
        )
        $("#district_id").change(function () {
            changeStreet();
        })
        function changeStreet() {
            $("#street_id>option:gt(0)").remove();
            var districtId = $("#district_id").val();
            $.post(
                "/page/queryStreets",
                {"districtId":districtId},
                function (data) {
                    $(data).each(function (i, e) {
                        $("#street_id").append(
                            "<option value='"+e.id+"'>"+e.name+"</option>"
                        )
                    })
                    $("#street_id").val(${house.streetId})
                },"json"
            )
        }

    })
</script>
<BODY>
<DIV id=header class=wrap>
<DIV id=logo><IMG src="../images/logo.gif"></DIV></DIV>
<DIV id=regLogin class=wrap>
<DIV class=dialog>
<DL class=clearfix>
  <DT>新房屋信息发布</DT>
  <DD class=past>填写房屋信息</DD></DL>
<DIV class=box>
<FORM id=add_action method=post name=add.action 
action=/page/updateHouse enctype="multipart/form-data" onsubmit="return checkForm()">
<DIV class=infos>
<TABLE class=field>
  <TBODY>
  <TR>
    <input type="hidden" name="id" value="${house.id}">
    <TD class=field>标　　题：</TD>
    <TD><INPUT id=title class=text type=text name=title value="${house.title}"> </TD></TR>
  <TR>
    <TD class=field>户　　型：</TD>
    <TD><SELECT class=text name=typeId id="type_id"><OPTION selected
        >--请选择--</OPTION></SELECT></TD></TR>
  <TR>
    <TD class=field>面　　积：</TD>
    <TD><INPUT id=floorage class=text type=text value="${house.floorage}"
name=floorage></TD></TR>
  <TR>
    <TD class=field>价　　格：</TD>
    <TD><INPUT id=price class=text type=text name=price value="${house.price}"> </TD></TR>
  <TR>
    <TD class=field>房产证日期：</TD>
    <TD><INPUT class=text type=Date name=pubdate id="pubdate" value="<fmt:formatDate value='${house.pubdate}' pattern='yyyy-MM-dd'></fmt:formatDate>"></TD></TR>
  <TR>
    <TD class=field>位　　置：</TD>
    <TD>区：<SELECT class=text name=district_id id="district_id"><OPTION selected
        >--请选择--</OPTION></SELECT> 街：<SELECT class=text
        name=streetId id="street_id"><OPTION selected>--请选择--</OPTION></SELECT> </TD></TR><!--
						<tr>
							<td class="field">坐  标：</td>
							<td><input type="text" class="text" name="point" />
							</td>
						</tr>
						--><!--  <tr>
							<td class="field">Y 坐  标：</td>
							<td><input type="text" class="text" name="point.y" /></td>
						</tr>-->
  <TR>
    <TD class=field>联系方式：</TD>
    <TD><INPUT id=contact class=text type=text name=contact value="${house.contact}"> </TD></TR>
  <TR>
    <TD class=field>详细信息：</TD>
    <TD><TEXTAREA name=description id=description>${house.description}</TEXTAREA></TD></TR>
  <TR>
    <TD class=field>图　　片：</TD>
    <input type="hidden" name="oldPath" value="${house.path}">
    <TD><INPUT id=pfile class=text type=file name=pfile><img src="http://localhost:80/${house.path}" height="30" width="50"> </TD></TR>
  </TBODY></TABLE>
<DIV class=buttons><INPUT value=修改 type=submit>
</DIV></DIV></FORM></DIV></DIV></DIV>
<DIV id=footer class=wrap>
<DL>
  <DT>青鸟租房 © 2018 北大青鸟 京ICP证1000001号</DT>
  <DD>关于我们 · 联系方式 · 意见反馈 · 帮助中心</DD></DL></DIV></BODY>
<script language="JavaScript" src="../scripts/jquery-1.8.3.js"></script>
<script language="JavaScript">
  function checkForm() {
      var title = $("#title").val();
      var typeId = $("#type_id").val();
      var floorage = $("#floorage").val();
      var price = $("#price").val();
      var pubdate = $("#pubdate").val();
      var street_id = $("#street_id").val();
      var contact = $("#contact").val();
      var description = $("#description").val();
      var pfile = $("#pfile").val();

  }

</script>
</HTML>
