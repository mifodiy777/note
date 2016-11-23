<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp"/>
<script type="text/javascript">
    $(document).ready(function () {
        $('#recordsTable').on('error.dt', function (e, settings, techNote, message) {
            showErrorMessage(message);
        }).DataTable({
            "ajax": {
                "url": "allRecords",
                "type": "POST"
            },
            "columns": [
                {"data": "surname", 'title': 'Фамилия'},
                {"data": "name", 'title': 'Имя'},
                {"data": "phone", 'title': 'Телефон'},
                {"data": "address", 'title': 'Адрес'},
                {
                    data: "id", "searchable": false, "render": function (data, type, full) {
                    return '<a href="#" class="btn btn-warning" onclick=\"editRecord(' + full.id +
                            ');\"><span class=\"glyphicon glyphicon-pencil\"/></span></a>';
                }
                },
                {
                    data: "id", "searchable": false, "render": function (data, type, full) {
                    return '<a href="#" class="btn btn-danger deleteButton" onclick=\"deleteRecord(' + full.id +
                            ');\"><span class=\"glyphicon glyphicon-trash\"/></span></a>';
                }
                }
            ]
        });
    });
</script>


<div class="container">

    <button class="btn btn-success addBtn" onclick="addRecord()">
        <span class="glyphicon glyphicon-plus"></span> Добавить запись
    </button>
    <div id="formPanel"></div>
    <div class="panel panel-primary">
        <div class="panel-heading">
            <h4>Контакты</h4>
        </div>
        <div class="panel-body">
            <table id="recordsTable" class="table table-striped table-bordered" cellspacing="0"
                   width="100%"></table>
        </div>
    </div>
</div>
<jsp:include page="footer.jsp"/>
