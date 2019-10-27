$(function () {
    $('#dg').datagrid({
        title:'类型管理',
        url:'/admin/getType',
        toolbar:'#tb',
        pagination:true,
        pageSize:3,
        pageList:[3,5,10,15],
        columns:[[
            {field:'cb',checkbox:'true',width:100,align:'center'},
            {field:'id',title:'ID',width:100,align:'center'},
            {field:'name',title:'类型名',width:100,align:'center'},
            {field:'cz',title:'操作',width:100,align:'center',
                formatter: function(value,row,index){
                    return "<a href='javascript:del("+row.id+")'>删除</a>";
                }

            }
        ]],
        // rowStyler: function(index,row){
        //     if (index%2==0){
        //         return 'background-color:#6293BB;color:#fff;';
        //     }
        // },
    });
});
function del(id) {
    $.messager.confirm('删除类型', '确定删除该类型吗?', function(r){
        if (r){
            $.post(
                "/admin/delType",
                {"id":id},
                function (data) {
                    $.messager.alert('删除',data,'info');
                    $("#dg").datagrid('reload');
                },"text"
            );
        }
    });
}
function Add() {
    $("#AddDialog").dialog("open"); //打开窗口
};
function CloseDialog(dialogId) {
    $("#"+dialogId).dialog("close"); //关闭窗口
};
function SaveDialog() {
    // var $districtName = $("#districtName").val();
    // $.post(
    //     "/admin/add",
    //     {"name":$districtName},
    //     function (data) {
    //         alert(data);
    //     },"text"
    //
    // )
    $("#addForm").form('submit', {
        url:"/admin/addType",
        success:function (data) {
            $("#AddDialog").dialog("close");
            $.messager.alert('添加',data,'info');
            $("#dg").datagrid("reload");
        }
    })
}
function ModifyBySelect() {
    // $.post(
    //     "/admin/queryDistrict",
    //     {"id":$("#dg").datagrid('getSelected').id},
    //     function (data) {
    //         $("#id").val(data.id);
    //         $("#name").val(data.name);
    //     },"json"
    // )
    var selectRow = $("#dg").datagrid('getSelections');
    if(selectRow.length!=1){
        $.messager.alert('提示消息','你没有选择行或者选择了多行数据!','warning');
    }else{
        $.post(
            "/admin/queryType",
            {"id":selectRow[0].id},
            function (data) {
                $("#upForm").form('load',data);
            },"json"
        )
        $("#upDialog").dialog("open"); //打开窗口
    }
};
function updateDialog() {
    $("#upForm").form('submit',{
        url:"/admin/upType",
        success:function (data) {
            $("#upDialog").dialog("close");
            $.messager.alert('提示消息',data,'info');
            $("#dg").datagrid("reload");
        }
    })
}
function DeleteByFruitName() {
    var idList=[];
    var selectRows = $("#dg").datagrid('getSelections');
    for (var i = 0; i < selectRows.length; i++) {
        idList.push(selectRows[i].id);
    }
    var idLists = idList.join(",");
    if(selectRows.length==0){
        $.messager.alert('提示消息','请先选择一行或多行数据!','warning');
    }else{
        $.messager.confirm('删除区域', '确定删除这<font color=red>'+selectRows.length+'</font>条区域记录吗?', function(r){
            if (r){
                $.post(
                    "/admin/delTypes",
                    {"idList":idLists},
                    function (data) {
                        $.messager.alert('删除区域',data,'info');
                        $("#dg").datagrid("reload");
                    },"text"
                )
            }
        });
    }
};