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
					<a href="#home"><img src="https://static.wixstatic.com/media/8bc854_ad94fb8015c642c78b391952c84315b5~mv2.jpg/v1/fill/w_419,h_235,al_c,lg_1,q_80,enc_auto/ikea%20pick%20up%20and%20delivery.jpg"
						alt="Logo - H Plus Sports"></a>
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
		<!-- <div class="container tagline">
    <h1 class="headline">Our Mission</h1>
    <p>We support and encourage <em>active and healthy</em> lifestyles, by offering <em>ethically sourced</em> and <em>eco-friendly</em> nutritional products for the <em>performance-driven</em> athlete.</p>
  </div>container tagline -->
	</header>
	<!-- #home -->


	<section>
		<!-- displays date and time for today -->
		<%=displayDate()%>
	</section>
	<section id="login" class="section">
		<div class="container tagline">
			<%
				if (request.getAttribute("error") != null) {
			%>
			<%=request.getAttribute("error")%><br />
			<%
				}
			%>
			<em>LOGIN USER</em>
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


	<footer class="footer">
		<div class="container">

			<nav class="nav" role="navigation">
				<div class="container nav-elements">
					<div class="branding">
						<a href="#home"><img src="https://static.wixstatic.com/media/8bc854_ad94fb8015c642c78b391952c84315b5~mv2.jpg/v1/fill/w_419,h_235,al_c,lg_1,q_80,enc_auto/ikea%20pick%20up%20and%20delivery.jpg"
							alt="Logo - "></a>

					</div>
				</div>
			</nav>
			<p IKOA</p>
		</div>
		<!-- container -->
	</footer>
	<!-- footer -->
	<%!public String displayDate() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd hh:mm");
		Date date = Calendar.getInstance().getTime();
		return dateFormat.format(date);
	}%>
</body>
</html>