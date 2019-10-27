$(function () {
    $('#dg').datagrid({
        title:'用户信息管理',
        url:'/admin/getUsers',
        toolbar:'#tb',
        pagination:true,
        pageSize:3,
        pageList:[3,5,10,15],
        columns:[[
            {field:'cb',checkbox:'true',width:100,align:'center'},
            {field:'id',title:'ID',width:100,align:'center'},
            {field:'name',title:'用户名',width:100,align:'center'},
            {field:'telephone',title:'电话',width:100,align:'center'}
        ]],
        // rowStyler: function(index,row){
        //     if (index%2==0){
        //         return 'background-color:#6293BB;color:#fff;';
        //     }
        // },
    });
});
function searchUser() {
    var username = $("#username").val();
    var usertel = $("#usertel").val();
    $("#dg").datagrid("load",{"name":username,"telephone":usertel});
}