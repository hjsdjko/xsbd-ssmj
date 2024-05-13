<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/1/29
  Time: 17:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>

</head>
<body>
<div style="display: inline-block">
    <select id="selector">
        <option value="-1">请选择</option>
    </select>
</div>

<div style="display: inline-block">
    <select id="selector2">
        <option value="-1">请选择</option>
    </select>
</div>
<button type="button" onclick="test()">点击弹出值</button>
</body>
<script type="text/javascript"  src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.min.js" ></script>

<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/jquery.searchableSelect.css" type="text/css">
<script type="text/javascript"  src="${pageContext.request.contextPath}/resources/js/jquery.searchableSelect.js" ></script>

<script>
    $(function () {
        $('#selector').searchableSelect();
        $('#selector2').searchableSelect();
    });

    for (let i = 0; i < 20; i++) {
        $("#selector").append("<option value="+i+">"+i+"name"+"</option>");
    }
    for (let i = 0; i < 10; i++) {
        $("#selector2").append("<option value="+i+i+">"+i+"name第二个"+"</option>");
    }

    // $("#selector").change(function () {
    //     _id = $("#selector").val();
    //     console.log("第一个：" + _id);
    //     $("#selector2").empty();
    //     $("#selector2").append("<option value='-1'>请选择</option>");
    //
    //
    //     $('#selector2').searchableSelect();
    // });

    $("#selector2").change(function () {
        _id = $("#selector2").val();
        if(_id!=-1){
            console.log("第二个：" + _id);
        }
    });
    function test() {
        var a = $("#selector").val();
        var b = $("#selector2").val();
        alert("a:"+a+"   "+"b:"+b);

    }

</script>
</html>
