$(function () {
    $('#dg').datagrid({
        title:'已审出租房',
        url:'/admin/getPass',
        toolbar:'#tb',
        pagination:true,
        pageSize:3,
        queryParams:{"state":1},
        pageList:[3,5,10,15],
        columns:[[
            {field:'cb',checkbox:'true',width:100,align:'center'},
            {field:'id',title:'ID',width:100,align:'center'},
            {field:'title',title:'标题',width:100,align:'center'},
            {field:'floorage',title:'面积',width:100,align:'center'},
            {field:'contact',title:'电话',width:100,align:'center'},
            {field:'price',title:'价格',width:100,align:'center'},
            {field:'pubdate',title:'日期',width:100,align:'center',
                formatter: function(value,row,index){
                    var date = new Date(value);
                    return date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate();
                }

            },
            {field:'description',title:'描述',width:100,align:'center'},
            {field:'tname',title:'类型',width:100,align:'center'},
            {field:'dname',title:'区域',width:100,align:'center'},
            {field:'sname',title:'街道',width:100,align:'center'},
            {field:'cz',title:'操作',width:100,align:'center',
                formatter: function(value,row,index){
                    return "<a onclick='goPass("+row.id+")' href=''>取消审核</a>";
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
function goPass(id) {
    $.post(
        "/admin/goNoPass",
        {"id":id},
        function (data) {
            if(data){
                $("#dg").datagrid('reload');
            }else{
                $.messager.alert('提示','取消审核失败!','info');
            }
        }
    )
}