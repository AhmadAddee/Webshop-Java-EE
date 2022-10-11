<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List" %>


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
                List<String> carts = (ArrayList<String>) request.getSession().getAttribute("cart");
                Iterator<String> iterator = carts.iterator();
   				while (iterator.hasNext()) {
                String s = iterator.next();

            %>
            <div class="productContainerItem">
            <input type="text" name="product" value="<%=s.toString()%>"><br />

            </div>
            <%
                }
            %>

        </div>

	</section>
	<!-- #products -->

</body>
</html>