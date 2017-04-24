<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="springForm" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

        <c:url var="home" value="/" scope="request" />

        <title>Spiral Matrix</title>
        <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
        <link href="<c:url value="/resources/css/bootstrap-theme.min.css" />" rel="stylesheet">

        <style>
            #matrix > tbody > tr > td {
                color: blue;
            }
            .error {
                color: #ff0000;
                font-style: italic;
            }
        </style>
    </head>
    <body style="background-image: url(<c:url value="/resources/img/background.png" />);">
        <div id="main-content" class="col-lg-12">
            <div class="container">
                <br/>
                <div class="well">
                    <springForm:form method="POST" class="navbar-form" commandName="matrix" action="${home}create_matrix.htm">
                        <div class="col-lg-7">
                            <springForm:input path="row" cssClass="form-control" placeholder="Row (min 2)" />
                            <springForm:errors path="row" cssClass="error" />
                            <springForm:input path="column" cssClass="form-control" placeholder="Column (min 2)" />
                            <springForm:errors path="column" cssClass="error" />
                            <input type="submit" value="Create matrix" class="btn btn-primary" style="/*float:right;*/">

                        </div>
                        <div class="col-lg-5">
                            <label class="radio-inline"><input type="radio" name="clockwise" value="1" checked>clockwise</label>
                            <label class="radio-inline"><input type="radio" name="clockwise" value="2">counter-clockwise</label>

                            <span id="run-spiral" href="#" class="btn btn-primary">Display spiral elements</span>
                        </div>
                    </springForm:form>
                    <div class="clearfix"></div>
                </div>

                <c:if test="${not empty matrix.row}">
                    <table id="matrix" class="table table-bordered">
                        <c:forEach var="row" begin="1" end="${matrix.row}">
                            <tr>
                                <c:forEach var="col" begin="1" end="${matrix.column}">
                                    <c:set var="count" value="${count + 1}" scope="page"/>
                                    <td style="width: 30px !important; text-align: center"><b>${count}</b></td>
                                </c:forEach>
                            </tr>
                        </c:forEach>
                    </table>
                </c:if>
            </div>
        </div>
    </div>

    <script src="<c:url value="/resources/js/jquery-3.2.0.min.js" />"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
    <script src="<c:url value="/resources/js/index.js" />"></script>

</body>
</html>
