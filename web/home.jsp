<%-- 
    Document   : home
    Created on : May 22, 2021, 10:05:11 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>
    <c:if test="${sessionScope.LOGIN_USER != null}">
        <h2 style="color:black">Welcome: ${sessionScope.LOGIN_USER.name}</h2>
    </c:if>
    <body>
        <form action="SearchController?index=1">
            <input type="text" name="search" />
            <input type="submit" name="action" value="Search"/>
        </form>

        <table border="1">
            <thead>
                <tr>
                    <th>Product ID</th>
                    <th>Product Name</th>
                    <th>Price</th>
                    <th>Quantity</th>
                    <th>Color</th>
                    <th>Category ID</th>
                    <th>Action</th>
                    <th>Duration</th>
                </tr>
            </thead>
            <form action="BookingController" method="get"> 
               <c:forEach items="${requestScope.LIST}" var="t">
                <tbody>
                    <tr>
                        <td>${t.productID}</td>
                        <td>${t.productName}</td>
                        <td>${t.price}</td>
                        <td>${t.quantity}</td>
                        <td>${t.color}</td>
                        <td>${t.categoryID}</td>
                        <td><a href="BookingController?productID=${t.productID}">Booking</a></td>
                        <td><input type="text" name="duration"/></td>
                    </tr>
                </tbody>
            </c:forEach> 
            </form>
            

        </table>
        <a href="LogoutController"/>Logout</a>

</body>
</html>
