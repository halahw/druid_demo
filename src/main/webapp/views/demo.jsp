<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>

    <title>Druid</title>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
    <link href="../static/plugins/easyui/1.4/themes/bootstrap/easyui.css" rel="stylesheet" type="text/css"/>
    <link href="../static/plugins/easyui/1.4/themes/icon.css" rel="stylesheet" type="text/css"/>
    <link href="../static/plugins/easyui/1.4/themes/demo.css" rel="stylesheet" type="text/css"/>
</head>
<body>

<div align="center">
    <h1>Hello World !</h1>
    <input name="username" id="search" value="请输入账户进行搜索"/> <input type="button" value="搜索" onclick="search()"/>
    <br>
    <br>
    <table id="userTable" title="用户列表" style="width: 800px; height: 495px">
        <thead>
        <tr>
            <th data-options="field:'id',checkbox:true"></th>
            <th data-options="field:'username',width:100">账号</th>
            <th data-options="field:'password',width:100">密码</th>
            <th data-options="field:'salt',width:100">盐</th>
            <th data-options="field:'locked',width:100">是否锁住</th>
        </tr>
        </thead>
    </table>
</div>

<script src="../static/plugins/jquery/jquery-1.11.3.min.js" type="text/javascript"></script>
<script src="../static/plugins/easyui/1.4/jquery.easyui.min.js" type="text/javascript"></script>
<script src="../static/plugins/easyui/1.4/locale/easyui-lang-zh_CN.js" type="text/javascript"></script>
<script type="text/javascript">
    $(function () {
        $('#userTable').datagrid({
            url: '${pageContext.request.contextPath}/list',
            fitColumns: true,
            rownumbers: true,
            scrollbarSize: 0,
            pagination: true,
            pageList: [10, 20, 50],
            toolbar: [{
                text: '批量删除',
                iconCls: 'icon-remove',
                handler: function () {
                    if (confirm("真的都要删除吗")) {
                        removeUsers();
                    }
                }
            }]
        });
    });

    function removeUsers() {
        var sr = $("#userTable").datagrid("getChecked");
        var ids = new Array();
        if (sr.length != 0) {
            for (var i = 0; i < sr.length; i++) {
                ids.push(sr[i].id);
            }
            location = "${pageContext.request.contextPath}/deletebybatch?array=" + ids;
        }
    }

    function search() {
        var name = $("#search").val();
        $('#userTable').datagrid(
                'reload',
                {username : username}
        );
    }


</script>

</body>
</html>