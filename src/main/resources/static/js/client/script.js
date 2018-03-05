$(document).ready(function() {

    $("button.btn.delete-client").click(function() {
        var clientDetailId = this.getAttribute("client-detail-id");
        $("#modal-value").val(clientDetailId);
        $("#deleteClient").modal("show");

    });

    $("div.modal button.confirm-yes").click(function() {
        var clientDetailId = $("#modal-value").val();

        $.ajax({
            type: "GET",
            contentType: "application/json",
            url: "/api/client/deleteByDetails/" + clientDetailId,
            dataType: 'json',
            cache: false,
            timeout: 600000,
            success: function (data) {
                var json = JSON.stringify(data);
                console.log("JSON Result [DELETE]: " + json);

                var selector = "tr[data-item-id='"+ data.entity.id +"']";
                $(selector).remove();

                $('#deleteClient').modal('hide');
            },
            error: function (e) {
                var json = "<h4>Ajax Response</h4><pre>"
                    + e.responseText + "</pre>";
                $('#ajax-result').html(json);

                console.log("ERROR : ", e);
                $("#trigger-ajax").prop("disabled", false);
            }
        });
    });

});