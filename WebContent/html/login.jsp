<!DOCTYPE html>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<html>
<head>
<link rel="stylesheet" href="css/style.css">
<meta charset="ISO-8859-1">
<title>IKOA - Login</title>

</head>
<body>
	<header id="home" class="header">
		<nav class="nav" role="navigation">
			<div class="container nav-elements">
				<div class="branding">
				</div>
				<!-- branding -->
				<ul class="navbar">
					<li><a href="home">home</a></li>
					<li><a href="registerUser">new user?</a></li>
				</ul>
				<!-- navbar -->
			</div>
			<!-- container nav-elements -->
		</nav>
	</header>
	<!-- #home -->


	<section>
		<!-- displays date and time for today -->
	</section>
	<section id="login" class="section">
		<div class="container tagline">
        <%
            if (request.getAttribute("error") != null){
        %>
            <%=request.getAttribute("error")%><br />
        <%
            }
        %>
			<em>LOGIN USER</em><br/><br/>
			<form action="login" method="post">
				<label>Username</label>
				<input type="text" name="username" id="username"><br/>
				<label>Password</label>
				<input type="password" name="password" id="password"><br/>
				<input type="submit" value="Login">
			</form>
		</div>
	</section>
	<!-- #products -->
</body>
</html>