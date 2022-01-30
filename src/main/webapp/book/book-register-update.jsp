<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../fragment/header.jsp"%>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container">
        <span class="navbar-brand mb-0 h1">Book Management System - Customer Registration</span>

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

            </div>
        </div>
    </div>
</nav>

<div class="container form-container">
    <form action="${pageContext.request.contextPath}/book-save" method="POST">
        <div class="row">
            <div class="col-25">
                <label for="isbn">ISBN: </label>
            </div>
            <div class="col-75">
                <input id="isbn" name="isbn" required type="text"
                       value="<c:out value='${book.isbn}'/>"/>
            </div>
        </div>

        <div class=" row">
            <div class="col-25">
                <label for="bookName">Book Name: </label>
            </div>
            <div class="col-75">
                <input id="bookName" name="bookName" required type="text" value="<c:out value='${book.bookName}'/>"/>
            </div>
        </div>

        <div class="row">
            <div class="col-25">
                <label for="bookAuthor">Book Author: </label>
            </div>
            <div class="col-75">
                <input id="bookAuthor" name="bookAuthor" required type="text" value="<c:out value='${book.bookAuthor}'/>"/>
            </div>
        </div>

        <div class="row">
            <div class="col-25">
                <label for="stock">Stock: </label>
            </div>
            <div class="col-75">
                <input id="stock" name="stock" required type="text"
                       value="<c:out value='${book.stock}'/>"/>
            </div>
        </div>

        <input type="hidden" name="id" id="id" value="<c:out value='${book.id}' />"/>

        <div class="row">
            <div class="col-75">
                <input type="submit" value="<%=request.getAttribute("action")%>">
            </div>
        </div>

    </form>
</div>

<%@ include file="../fragment/footer.jsp"%>