<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="fragment/header.jsp"%>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container">
        <span class="navbar-brand mb-0 h1">Book Management System</span>

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

                <a class="nav-item nav-link active" href="${pageContext.request.contextPath}/book-save">
                    add book  <i class="fas fa-plus" style="color: white"></i>
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

    </table>
</div>

<%@include file="fragment/footer.jsp"%>