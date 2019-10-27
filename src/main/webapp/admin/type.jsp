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
    <script type="text/javascript" language="JavaScript" src="js/type.js">
    </script>
</head>
<body>
<table id="dg"></table>

<div id="tb">
        <a href="javascript:Add()" class="easyui-linkbutton"
           iconCls="icon-add" plain="true">添加</a> <a
            href="javascript:ModifyBySelect()" class="easyui-linkbutton"
            iconCls="icon-edit" plain="true">修改</a> <a
            href="javascript:DeleteByFruitName()" class="easyui-linkbutton"
            iconCls="icon-remove" plain="true">删除</a>
</div>
<%--添加--%>
<div id="AddDialog" class="easyui-dialog" title="添类型" buttons="#AddDialogButtons"
     style="width: 280px; height: 250px; padding: 10px 20px;" closed="true" data-options="modal:true">
    <form id="addForm" method="post">
        <table>
            <tr>
                <td>添加类型:</td>
                <td><input type="text" name="name"/></td>
            </tr>
        </table>
    </form>
</div>

<div id="AddDialogButtons">
    <a href="javascript:SaveDialog()" class="easyui-linkbutton"
       iconCls="icon-ok">保存</a> <a href="javascript:CloseDialog('AddDialog')"
                                   class="easyui-linkbutton" iconCls="icon-cancel">取消</a>
</div>

<%--修改--%>
<div id="upDialog" class="easyui-dialog" title="修改类型" buttons="#upDialogButtons"
     style="width: 280px; height: 250px; padding: 10px 20px;" closed="true" data-options="modal:true">
    <form id="upForm" method="post">
        <table>
            <input type="hidden" name="id" id="id">
            <tr>
                <td>类型:</td>
                <td><input type="text" name="name" id="name"/></td>
            </tr>
        </table>
    </form>
</div>

<div id="upDialogButtons">
    <a href="javascript:updateDialog()" class="easyui-linkbutton"
       iconCls="icon-ok">修改</a> <a href="javascript:CloseDialog('upDialog')"
                                   class="easyui-linkbutton" iconCls="icon-cancel">取消</a>
</div>
</body>
</html>
