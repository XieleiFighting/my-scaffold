<#assign base=request.contextPath />
<#import "../common/spring.ftl" as spring/>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title><@spring.message "application.name"/></title>

    <link href="${base}/comp/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="${base}/comp/metisMenu/metisMenu.min.css" rel="stylesheet">
    <link href="${base}/css/sb-admin-2.css" rel="stylesheet">
    <link href="${base}/comp/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <#--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
    <div class="container">
    	<a href="?lang=en_US"> 英语</a>  
    	<a href="?lang=zh_CN"> 中文</a>
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">Please Sign In</h3>
                    </div>
                    <div class="panel-body">
                        <form role="form" method="post" action="/login">
                            <fieldset>
                                <div class="form-group">
                                    <input class="form-control" placeholder="E-mail" name="email" type="email" autofocus>
                                </div>
                                <div class="form-group">
                                    <input class="form-control" placeholder="Password" name="password" type="password" value="">
                                </div>
                                <div class="checkbox">
                                    <label>
                                        <input name="remember" type="checkbox" value="Remember Me">Remember Me
                                    </label>
                                </div>
                                <#-- Change this to a button or input when using this as a form -->
								<button>登录</button>
                                <a href="index.html" class="btn btn-lg btn-success btn-block"><@spring.message "common.login" /></a>
                            </fieldset>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="${base}/comp/jquery/jquery.min.js"></script>
    <script src="${base}/comp/bootstrap/js/bootstrap.min.js"></script>
    <script src="${base}/comp/metisMenu/metisMenu.min.js"></script>
    <script src="${base}/js/sb-admin-2.js"></script>
</body>
</html>
