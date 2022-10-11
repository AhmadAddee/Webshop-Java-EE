<!DOCTYPE html>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="beans.Product"%>
<%@page import="java.util.List"%>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>IKOA</title>
<link rel="stylesheet" href="css/style.css">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>

    <%-- <%@ include file="header.jsp"%> --%>
	<jsp:include page="header.jsp"></jsp:include>
	<!-- #home -->

	<section id="products" class="section">
		<div class="container">
		    <%
        	    if (session.getAttribute("cart") != null) {
        	%>
        	<p>
        		<span id="size" title="<%=((ArrayList) session.getAttribute("cart"))%>">
        		    Items in Cart: <%=((ArrayList) session.getAttribute("cart")).size()%>
        		</span>
        	</p>
        	<%
        		} else {
        	%>
        	<span id="size">Items in Cart :0</span>
        		<%
        			}
        		%>
			<h2 class="headline">Products</h2>
			<p>
				We have the best furniture in the north. <em>Save 15% when you register yourself as a new IKOA Family member</em>
			</p>
		</div>


		<div class="productContainer">
			<%
				List<Product> products = (ArrayList) request.getAttribute("products");
				Iterator<Product> iterator = products.iterator();
				while (iterator.hasNext()) {
					Product product = iterator.next();
			%>
			<form action="addProducts" method="get">
				<div class="productContainerItem">
					<img id="pic1" src="<%=product.getImgUrl()%>">
					<input type="text" name="product" value="<%=product.getName()%>"/>
					<input type="text" name="product" value="<%=product.getPrice()%> $"/>
					<br />
					<button>Add to Cart</button>
				</div>
			</form>
			<%
				}
			%>
		</div>
	</section>
	<!-- #products -->

	<br />
	<br />

	<section id="search" class="section">
		<header class="imageheader"></header>
		<div class="container">
			<h2 class="headline">Search Products</h2>
			<form action="search" method="get">
				<label class="card-title">Search your product</label>
				<input type="search" name="search"> <input type="submit" value="Search">
			</form>
		</div>
	</section>
	<!-- guarantee -->
</body>
</html>