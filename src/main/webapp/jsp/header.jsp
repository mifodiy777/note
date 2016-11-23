<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<head>
    <title>Записная книжка</title>
    <meta http-equiv="Content-type" content="text/html; charset=utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" href="<c:url value="/img/ico-logo.ico"/>" type="image/x-icon"/>
    <link type="text/css" href="<c:url value='/css/bootstrap.min.css'/>" rel="stylesheet"/>
    <link type="text/css" href="<c:url value='/css/bootstrap.dataTable.css'/>" rel="stylesheet"/>
    <link type="text/css" href="<c:url value='/css/dataTables.bootstrap.css'/>" rel="stylesheet"/>
    <link type="text/css" href="<c:url value='/css/note.css'/>" rel="stylesheet"/>
    <script type="text/javascript" src="<c:url value='/js/jquery.min.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/js/bootstrap.min.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/js/jquery.form.min.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/js/jquery.validate.min.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/js/jquery.dataTables.min.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/js/dataTables.bootstrap.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/js/validate.customMethod.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/js/localization/validate.messages_ru.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/js/note.js'/>"></script>


    <script type="text/javascript">

        $(document).ajaxStart(function () {
            $('html').css({'cursor': 'wait'});
        });

        $(document).ajaxStop(function () {
            $('html').css({'cursor': 'default'});
        });

        $(document).ajaxError(function (event, jqxhr, settings, thrownError) {
            if (jqxhr.status == 401) {
                document.location.reload();
            }
        });

        $.extend($.fn.dataTable.defaults, {
            "language": {
                "url": '<c:url value="/js/localization/dataTablesRu.json"/>'
            }
        });

    </script>
</head>
<nav>
    <div class="navbar navbar-custom navbar-static-top">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                        data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Блокнот</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="<c:url value="/"/>"><h1 class="logo-img">Блокнот</h1></a>
            </div>

            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <a href="logout" title="Выйти">
                            <span class="glyphicon glyphicon-off" aria-hidden="true"></span>
                        </a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</nav>
<div id="messages" class="alert alert-success fade in " style="display: none"></div>

