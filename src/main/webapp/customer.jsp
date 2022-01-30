<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="fragment/header.jsp"%>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container">
        <span class="navbar-brand mb-0 h1">Book Management System - Customer Table</span>

        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
            <div class="navbar-nav ms-auto">

                <a class="nav-item nav-link active" href="${pageContext.request.contextPath}/book">
                    inventory  <i class="fas fa-box-open" style="color: white"></i>
                </a>

                <a class="nav-item nav-link active" href="${pageContext.request.contextPath}/customer">
                    customers  <i class="far fa-address-book" style="color: white"></i>
                </a>

                <a class="nav-item nav-link active" href="${pageContext.request.contextPath}/customer-save">
                    add customer <i class="fas fa-user-plus" style="color: white"></i>
                </a>

            </div>
        </div>
    </div>
</nav>

<div class="table-responsive">
    <table class="table table-hover">
        <thead class="table-light">
        <tr>
            <th scope="col">#</th>
            <th scope="col">Name</th>
            <th scope="col">Contact</th>
            <th scope="col">Address</th>
            <th scope="col">Email</th>
            <th scope="col">Actions</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach var="customer" items="${customers}">
            <tr>
                <td><c:out value="${customer.id}"/></td>
                <td><c:out value="${customer.customerName}"/></td>
                <td><c:out value="${customer.customerContact}"/></td>
                <td><c:out value="${customer.customerAddress}"/></td>
                <td><c:out value="${customer.customerEmail}"/></td>
                <td>
                    <a class="btn btn-edit"
                       href="${pageContext.request.contextPath}/customer-save?id=<c:out value="${customer.id}"/>">Edit</a>
                    <a class="btn btn-danger"
                       href="${pageContext.request.contextPath}/customer?id=<c:out value="${customer.id}"/>">
                        <i class=" far fa-trash-alt"></i>
                    </a>
                </td>
            </tr>
        </c:forEach>

        </tbody>

    </table>
</div>

<%@include file="fragment/footer.jsp"%>