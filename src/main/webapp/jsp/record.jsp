<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<script type="text/javascript">
    $(document).ready(function () {
        $("#addRecordForm").validate({
            submitHandler: function (form) {
                $(form).ajaxSubmit({
                    success: function (html) {
                        $("#recordsTable").DataTable().ajax.reload(null, false);
                        showSuccessMessage(html);
                        closeForm();
                        return false;
                    },
                    error: function (xhr) {
                        if (xhr.status == 409) {
                            showErrorMessage(xhr.responseText);
                        }
                    }
                });
            },
            errorPlacement: function (error, element) {
                validPlaceError(error, element);
            },
            success: function (label, element) {
                validPlaceSuccess(label, element);
            }
        });
        $("#addRecordForm").submit(function (e) {
            e.preventDefault();
            $(this).valid();
            return false;
        });
    })
</script>
<div class="panel panel-default">
    <div class="panel-heading">
        <p class="panel-title">Добавление записи</p>
    </div>
    <div class="panel-body">
        <div class="col-md-8">
            <form:form modelAttribute="record" id="addRecordForm" method="post" action="saveRecord">
                <form:hidden path="id"/>
                <form:hidden path="user"/>
                <form:hidden path="version"/>
                <div class="form-group">
                    <label class="control-label">Фамилия: </label>
                    <form:input path="surname" id="surname" cssClass="required form-control"/>
                    <span class="help-block"></span>
                </div>
                <div class="form-group">
                    <label class="control-label">Имя: </label>
                    <form:input path="name" id="name" cssClass="required form-control"/>
                    <span class="help-block"></span>
                </div>
                <div class="form-group">
                    <label class="control-label">Телефон: </label>
                    <form:input path="phone" id="phone" cssClass="required form-control"/>
                    <span class="help-block"></span>
                </div>
                <div class="form-group">
                    <label class="control-label">Адрес: </label>
                    <form:input path="address" id="address" cssClass="form-control"/>
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-success">Сохранить</button>
                    <button type="button" onclick="closeForm()" class="btn btn-default">Отмена</button>
                </div>
            </form:form>
        </div>
    </div>
</div>
