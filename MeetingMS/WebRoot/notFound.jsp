<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!doctype html>
<html>
<head>
    <title>404</title>
    <meta charset="UTF-8" />
    <link rel="stylesheet" href="css/404.css">

    <script src="js/jquery-2.2.4.min.js"></script>
    <script src="js/404_scriptalizer.js" type="text/javascript"></script>
    
    <script type="text/javascript">
        $(function(){
            $('#parallax').jparallax({});
        });
    </script>
	
</head>
<body>

<div id="parallax">
    <div class="error1">
        <img src="img/404/wand.jpg" alt="Mauer" />
    </div>
    <div class="error2">
        <img src="img/404/licht.png" alt="Licht" />
    </div>
    <div class="error3">
        <img src="img/404/halo1.png" alt="Halo1" />
    </div>
    <div class="error4">
        <img src="img/404/halo2.png" alt="Halo2" />
    </div>
    <div class="error5">
        <img src="img/404/batman-404.png" alt="Batcave 404" />
    </div>
</div>
<div style="text-align:center;">

</div>
 
</body>
</html>


