<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="fragment/header.jsp"%>

<nav class="navbar navbar-dark bg-dark">
    <div class="container-fluid">
        <span class="navbar-brand mb-0 h1">Book Management System</span>
        <ul class="navbar-brand list-unstyled">
            <li>
                <a href="${pageContext.request.contextPath}/book-save">
                    <i class="fas fa-plus" style="color: white"></i>
<%--                    <img src="./assets/images/plus.png" alt="add" style="width: 20px;height: 20px;">--%>
                </a>
            </li>
        </ul>
    </div>
</nav>

<div class="table-responsive">
    <table class="table table-hover">
        <thead class="table-light">
        <tr>
            <th scope="col">#</th>
            <th scope="col">ISBN</th>
            <th scope="col">Book Name</th>
            <th scope="col">Book Author</th>
            <th scope="col">Stock</th>
            <th scope="col">Actions</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach var="book" items="${books}">
            <tr>
                <td><c:out value="${book.id}"/></td>
                <td><c:out value="${book.isbn}"/></td>
                <td><c:out value="${book.bookName}"/></td>
                <td><c:out value="${book.bookAuthor}"/></td>
                <td><c:out value="${book.stock}"/></td>
                <td>
                    <a class="btn btn-edit"
                       href="${pageContext.request.contextPath}/book-save?id=<c:out value="${book.id}"/>">Edit</a>
                    <a class="btn btn-danger"
                       href="${pageContext.request.contextPath}/book?id=<c:out value="${book.id}"/>">
                        <i class="far fa-trash-alt"></i>
                    </a>
                </td>
            </tr>
        </c:forEach>

        </tbody>
        <!-- <caption>Record of Books</caption> -->
    </table>
</div>

<%@include file="fragment/footer.jsp"%>