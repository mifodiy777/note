function validPlaceError(error, element) {
    $(element).parent().addClass("has-error");
    $(element).parent().children(".help-block").text($(error).text());
}

function validPlaceSuccess(label, element) {
    $(element).parent().removeClass("has-error");
    $(element).parent().children(".help-block").empty();
}

function showSuccessMessage(html) {
    $("#messages").removeClass("alert-danger");
    $("#messages").addClass("alert-info");
    $("#messages").html(html).show(800).delay(4000).hide(1000);
}

function showErrorMessage(html) {
    $("#messages").removeClass("alert-info");
    $("#messages").addClass("alert-danger");
    $("#messages").html(html).show(800).delay(4000).hide(1000);
}

function addRecord() {
    $.get("recordForm", function (html) {
        $("#formPanel").html(html).show();
        $(".addBtn").hide();
    }).fail(function (xhr) {
        if (xhr.status == 409) {
            showErrorMessage(xhr.responseText);
        }
    })
}

function editRecord(id) {
    $.get("recordForm/" + id, function (html) {
        $("#formPanel").html(html).show();
        $(".addBtn").hide();
    }).fail(function (xhr) {
        if (xhr.status == 409) {
            showErrorMessage(xhr.responseText);
        }
    })
}

function deleteRecord(id) {
    $.ajax({
        url: "deleteRecord/" + id,
        type: "post",
        success: function (html) {
            showSuccessMessage(html);
            $('#recordsTable').DataTable().ajax.reload(null, false);
        },
        error: function (xhr) {
            if (xhr.status == 409) {
                showErrorMessage(xhr.responseText);
            }
        }
    });
}

function closeForm() {
    $("#formPanel").hide();
    $(".addBtn").show();
}
