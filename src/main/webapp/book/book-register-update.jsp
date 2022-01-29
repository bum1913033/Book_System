<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../fragment/header.jsp"%>

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

        <input type="hidden" name="id" id="id" value="<c:out value='${book.id}' />"/>

        <div class="row">
            <div class="col-75">
                <input type="submit" value="<%=request.getAttribute("action")%>">
            </div>
        </div>

    </form>
</div>

<%@ include file="../fragment/footer.jsp"%>