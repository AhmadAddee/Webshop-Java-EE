<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List" %>
<%@page import="ui.ProductInfo"%>


<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/style.css">
<meta charset="ISO-8859-1">
<title>IKOA - Login</title>
</head>
<body>

    <%-- <%@ include file="header.jsp"%> --%>
	<jsp:include page="header.jsp"></jsp:include>
	<!-- #home -->

	<section id="carts">
    	<div class="productContainer">
            <%
                List<String> carts = (ArrayList<String>) request.getSession().getAttribute("carts");
                if (carts == null){
                %>
                    <p>
                        There is no products in your shopping cart!
                    </p>
                <%
                } else {
                float totalPrice = 0;
                List<ProductInfo> products = (ArrayList) request.getAttribute("carts");
                Iterator<ProductInfo> iterator = products.iterator();
   				while (iterator.hasNext()) {
                ProductInfo product = iterator.next();
                totalPrice += product.getPrice();
            %>
            <div class="productContainerItem">
                <img id="pic1" src="<%=products.get(0).getImgUrl()%>">
                <input type="text" name="product" value="<%=product.getName()%>" disabled><br />
            <br />

            </div>
            <%
                }
            %>
            <div class="productContainerItem">
                <input type="text" name="product" value="Total: <%=totalPrice%>" disabled><br />
                <input type="submit" name="product" value="Check out">
            </div>
            <%
                }
            %>
        </div>

	</section>
	<!-- #products -->
</body>
</html>