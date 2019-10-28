var a=-1;
$(function () {
    $('#dg').datagrid({
        title:'区域管理',
        url:'/admin/getDistrict',
        toolbar:'#tb',
        pagination:true,
        pageSize:3,
        pageList:[3,5,10,15],
        columns:[[
            {field:'cb',checkbox:'true',width:100,align:'center'},
            {field:'id',title:'ID',width:100,align:'center'},
            {field:'name',title:'区域名',width:100,align:'center'},
            {field:'cz',title:'操作',width:100,align:'center',
                formatter: function(value,row,index){
                    return "<a href='javascript:del("+row.id+")'>删除</a> <a href='javascript:queryStreet("+row.id+")'>街道详情</a>";
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
    $.messager.confirm('删除区域', '确定删除该区域吗?', function(r){
        if (r){
            $.post(
                "/admin/delDistrict",
                {"id":id},
                function (data) {
                    $.messager.alert('删除',data,'info');
                    $("#dg").datagrid('reload');
                },"text"
            );
        }
    });
};
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
        url:"/admin/addDistrict",
        success:function (data) {
            $("#AddDialog").dialog("close");
            $.messager.alert('添加',data,'info');
            $("#dg").datagrid("reload");
        }
    })
};
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
            "/admin/queryDistrict",
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
        url:"/admin/upDistrict",
        success:function (data) {
            $("#upDialog").dialog("close");
            $.messager.alert('提示消息',data,'info');
            $("#dg").datagrid("reload");
        }
    })
};
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
                    "/admin/delDistricts",
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


//查询街道详情
function queryStreet(id) {
    a=id;
    $("#queryStreetDialog").dialog('open');
    $('#street').datagrid({
        title:'街道管理',
        url:'/admin/getStreet',
        queryParams:{"districtId":id},
        toolbar:'#toolbar',
        pagination:true,
        pageSize:3,
        pageList:[3,5,10,15],
        columns:[[
            {field:'cb',checkbox:'true',width:100,align:'center'},
            {field:'id',title:'ID',width:100,align:'center'},
            {field:'name',title:'街道名',width:100,align:'center'},
            {field:'districtId',title:'区域号',width:100,align:'center'},
            {field:'cz',title:'操作',width:100,align:'center',
                formatter: function(value,row,index){
                    return "<a href='javascript:delStreet("+row.id+")'>删除</a>";
                }
            }
        ]]
    });
};

function AddStreet() {
    $("#AddStreetDialog").dialog('open');
    $("#district_id").val(a);
}

function SaveStreetDialog() {
    $("#addStreetForm").form('submit', {
        url:"/admin/addStreet",
        success:function (data) {
            $("#AddStreetDialog").dialog("close");
            $.messager.alert('添加',data,'info');
            $("#street").datagrid("reload");
        }
    })
}

function ModifyStreetBySelect() {
    var selectRow = $("#street").datagrid('getSelections');
    if(selectRow.length!=1){
        $.messager.alert('提示消息','你没有选择行或者选择了多行数据!','warning');
    }else{
        $.post(
            "/admin/queryStreet",
            {"id":selectRow[0].id},
            function (data) {
                $("#upStreetForm").form('load',data);
            },"json"
        )
        $("#upStreetDialog").dialog("open"); //打开窗口
    }
}
function updateStreetDialog() {
    $("#upStreetForm").form('submit',{
        url:"/admin/upStreet",
        success:function (data) {
            $("#upStreetDialog").dialog("close");
            $.messager.alert('提示消息',data,'info');
            $("#street").datagrid("reload");
        }
    })
};
function DeleteStreetByFruitName() {
    var idList=[];
    var selectRows = $("#street").datagrid('getSelections');
    for (var i = 0; i < selectRows.length; i++) {
        idList.push(selectRows[i].id);
    }
    var idLists = idList.join(",");
    if(selectRows.length==0){
        $.messager.alert('提示消息','请先选择一行或多行数据!','warning');
    }else{
        $.messager.confirm('删除街道', '确定删除这<font color=red>'+selectRows.length+'</font>条区域记录吗?', function(r){
            if (r){
                $.post(
                    "/admin/delStreets",
                    {"idList":idLists},
                    function (data) {
                        $.messager.alert('删除街道',data,'info');
                        $("#street").datagrid("reload");
                    },"text"
                )
            }
        });
    }
};
function delStreet(id) {
    $.messager.confirm('删除街道', '确定删除该街道吗?', function(r){
        if (r){
            $.post(
                "/admin/delStreet",
                {"id":id},
                function (data) {
                    $.messager.alert('删除',data,'info');
                    $("#street").datagrid('reload');
                },"text"
            );
        }
    });
};


