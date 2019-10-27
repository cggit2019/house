<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/10/13
  Time: 18:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <title>district</title>
    <link rel="stylesheet" type="text/css" href="easyUI/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="easyUI/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="easyUI/css/demo.css">
    <script src="js/jquery-1.8.3.js"></script>
    <!--jquery.easyui.min.js包含了easyUI中的所有插件-->
    <script src="js/jquery.easyui.min.js"></script>
    <script type="text/javascript" language="JavaScript" src="js/house2.js">
    </script>
</head>
<body>
<table id="dg"></table>

<div id="tb">
    用户名: <input type="text" name="name" id="username">
    电话: <input type="text" name="telephone" id="usertel">
        <a href="javascript:searchUser()" class="easyui-linkbutton"
           iconCls="icon-search" plain="true">查询</a>
</div>
</body>
</html>
