$(document).ready(function() {

    $("button.btn.delete-component").click(function() {
        var productId = this.getAttribute("data-product-id");
        var componentId = this.getAttribute("data-component-id");
        $("#modal-product-id").val(productId);
        $("#modal-component-id").val(componentId);
        $("#deleteComponent").modal("show");

    });

    $("div.modal button.confirm-yes").click(function() {
        var productId   = $("#modal-product-id").val();
        var componentId = $("#modal-component-id").val();

        $.ajax({
            type: "GET",
            contentType: "application/json",
            url: "/api/product/component/delete/" + productId + '/' + componentId,
            dataType: 'json',
            cache: false,
            timeout: 600000,
            success: function (data) {
                var json = JSON.stringify(data);
                console.log("JSON Result [DELETE]: " + json);

                var selector = "tr[data-item-id='"+ data.entity.id +"']";
                $(selector).remove();

                // If deleted the last row of the table, arrange the page to look properly.
                if (!$('table tbody tr').length) {
                    $('table').remove();
                    $('#expected-price').remove();
                    $('#no-results').show();
                }

                $('#deleteComponent').modal('hide');
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