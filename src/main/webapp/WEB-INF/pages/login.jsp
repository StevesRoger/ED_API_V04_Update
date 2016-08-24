<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>
body {
	background: url(${pageContext.request.contextPath}/resources/image/bg.jpg) no-repeat center center fixed;
    -webkit-background-size: cover;
    -moz-background-size: cover;
    -o-background-size: cover;
    background-size: cover;
}
</style>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="viewport" content="width=1,initial-scale=1,user-scalable=1" />
	<title>API Expert Developer</title>
	
	<link href="http://fonts.googleapis.com/css?family=Lato:100italic,100,300italic,300,400italic,400,700italic,700,900italic,900" rel="stylesheet" type="text/css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/static/css/bootstrap.min.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/static/css/styles.css" />
	
	<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
	
	<section class="container">
	    <section class="login-form">
		
		<section>
			<img src="${pageContext.request.contextPath}/resources/image/logo.png" alt="" />
		</section>
		<div class="panel panel-default">
		  	<div class="panel-body">
		    	<form method="POST" action="login" role="login" id="frmLogin">
					<div class="form-group">
						<label>Username</label>
						<input type="text" required class="form-control" name="username" />
					</div>
					
					<div class="form-group">
						<label>Password</label>
						<input type="password" required class="form-control" name="password"/>
					</div>
					
					<input type="checkbox" name="remember" value="1" /> Remember me
					<button type="submit" class="btn btn-primary btn-block">Log in</button>
				</form>
		  	</div>
		  	<div class="panel-footer">
		  		<a href="#">Lost your password?</a>
		  	</div>
		</div>
		<!-- <section>
			<a href="#">&larr; Back to Dashboard</a>
		</section> -->
		
		</section>
	</section>
	
	<script src="${pageContext.request.contextPath}/resources/static/js/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/static/js/bootstrap.min.js"></script>
	<script>
		$(document).ready(function(){
			 $("#frmLogin").submit(function(e){
				e.preventDefault();
				$.ajax({
					url:"${pageContext.request.contextPath}/login",
					type:"POST",
					data:$("#frmLogin").serialize(),
					success:function(data){
						if(data == "User account is locked"){
	  	            		alert(data);
	  	            	}else if(data == "User is disabled"){
	  	            		alert(data);
	  	            	}else if(data == "Bad credentials"){
	  	            		alert(data);
	  	            	}else{
	  	            		console.log(data);
	  	            		//alert("Logined success.");
	  	            		location.href = "${pageContext.request.contextPath}/"+data;
	  	            	}
					},
					error:function(err){
						console.log(err);
					}
				});
			}); 
		});
	</script>
</body>
</html>