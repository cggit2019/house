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
    <script type="text/javascript" language="JavaScript" src="js/district.js">
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
<div id="AddDialog" class="easyui-dialog" title="添加区域" buttons="#AddDialogButtons"
     style="width: 280px; height: 250px; padding: 10px 20px;" closed="true" data-options="modal:true">
    <form id="addForm" method="post">
        <table>
            <tr>
                <td>添加区域:</td>
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
<div id="upDialog" class="easyui-dialog" title="修改区域" buttons="#upDialogButtons"
     style="width: 280px; height: 250px; padding: 10px 20px;" closed="true" data-options="modal:true">
    <form id="upForm" method="post">
        <table>
            <input type="hidden" name="id" id="id">
            <tr>
                <td>区域:</td>
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

<%--街道--%>
<div id="queryStreetDialog" class="easyui-dialog" title="街道信息" buttons="#streDialogButtons"
     style="width: 600px; height: 400px; padding: 10px 50px;" closed="true" data-options="resizable:true,modal:true">
    <table id="street"></table>
</div>

<div id="streDialogButtons">
    <a href="javascript:CloseDialog('queryStreetDialog')"
                                   class="easyui-linkbutton" iconCls="icon-cancel">返回</a>
</div>

<div id="toolbar" hidden="hidden">
    <a href="javascript:AddStreet()" class="easyui-linkbutton"
       iconCls="icon-add" plain="true">添加</a> <a
        href="javascript:ModifyStreetBySelect()" class="easyui-linkbutton"
        iconCls="icon-edit" plain="true">修改</a> <a
        href="javascript:DeleteStreetByFruitName()" class="easyui-linkbutton"
        iconCls="icon-remove" plain="true">删除</a>
</div>

<%--添加街道--%>
<div id="AddStreetDialog" class="easyui-dialog" title="添加街道" buttons="#AddStreetDialogButtons"
     style="width: 280px; height: 250px; padding: 10px 20px;" closed="true" data-options="modal:true">
    <form id="addStreetForm" method="post">
        <input type="hidden" name="districtId" id="">
        <table>
            <tr>
                <td>添加街道:</td>
                <td><input type="text" name="name"/></td>
            </tr>
        </table>
    </form>
</div>

<div id="AddStreetDialogButtons">
    <a href="javascript:SaveStreetDialog()" class="easyui-linkbutton"
       iconCls="icon-ok">保存</a> <a href="javascript:CloseDialog('AddStreetDialog')"
                                   class="easyui-linkbutton" iconCls="icon-cancel">取消</a>
</div>

<%--修改街道--%>
<div id="upStreetDialog" class="easyui-dialog" title="修改街道" buttons="#upStreetDialogButtons"
     style="width: 280px; height: 250px; padding: 10px 20px;" closed="true" data-options="modal:true">
    <form id="upStreetForm" method="post">
        <table>
            <input type="hidden" name="id" id="streetId">
            <tr>
                <td>街道:</td>
                <td><input type="text" name="name" id="streetName"/></td>
            </tr>
            <tr>
                <td>区域编号:</td>
                <td><input type="text" name="districtId" id="districtId"></td>
            </tr>
        </table>
    </form>
</div>

<div id="upStreetDialogButtons">
    <a href="javascript:updateStreetDialog()" class="easyui-linkbutton"
       iconCls="icon-ok">修改</a> <a href="javascript:CloseDialog('upStreetDialog')"
                                   class="easyui-linkbutton" iconCls="icon-cancel">取消</a>
</div>
</body>
</html>
