let token = $("meta[name='_csrf']").attr("content");
let header = $("meta[name='_csrf_header']").attr("content");
$(document).ajaxSend(function(e, xhr, options) {
    xhr.setRequestHeader(header, token);
});
$(document).on("click", "#btnagregar",function () {
    $("#txtnomproduct").val(" ");
    $("#txtunitpriceproduct").val(" ")
    $("#txtfechacreacion").val(" ")
    $("#txtstock").val(" ")
    $("#switchproducto").hide();
    $("#cbdiscontinued").prop("checked", false);
    $("#hddprodcod").val("0")
    $("#modalproduct").modal("show");
});

$(document).on("click", ".btnactualizar", function () {
    $("#txtnomproduct").val($(this).attr("data-prodname"));
    $("#txtunitpriceproduct").val($(this).attr("data-produnit"));
    $("#txtfechacreacion").val($(this).attr("data-prodcreat"));
    $("#txtstock").val($(this).attr("data-prodstock"));
    $("#hddprodcod").val($(this).attr("data-prodcod"));
    $("#switchproducto").show();
    if ($(this).attr("data-proddiscont") == "true") {
        $("#cbdiscontinued").prop("checked", true);
    } else {
        $("#cbdiscontinued").prop("checked", false);
    }

    $("#modalproduct").modal("show");
});




$(document).on("click", "#btnguardar", function () {
    let create = convertirFechaStringADate($("#txtfechacreacion").val());
    $.ajax({
        type: "POST",
        url: "/producto/registrar",
        contentType: "application/json",
        data: JSON.stringify({
            id: $("#hddprodcod").val(),
            nombre: $("#txtnomproduct").val(),
            precio: $("#txtunitpriceproduct").val(),
            createAt: create,
            stock:  $("#txtstock").val(),
            activo: $("#cbdiscontinued").prop("checked")
        }),
        success: function (resultado) {
            if (resultado.respuesta) {
                listarProducto();
            }
            alert(resultado.mensaje);
        },
        error: function(xhr, status, error) {
            console.error("Error en la solicitud AJAX:", error);
            alert("Error en la solicitud AJAX. Por favor, inténtalo de nuevo más tarde.");
        }
    });
    $("#modalproduct").modal("hide");
});


$(document).on("click", ".btneliminar", function () {

    let productId = $(this).data("prodcod");

    if (confirm("¿Estás seguro de que deseas eliminar este producto?")) {
        // Enviar solicitud AJAX para eliminar el producto
        $.ajax({
            type: "POST",
            url: "/producto/delete/" + productId,

            success: function (resultado) {
                console.log(resultado);
                listarProducto();
            },
            error: function (xhr, status, error) {
                console.error("Error en la solicitud AJAX:", error);
                alert("Error en la solicitud AJAX. Por favor, inténtalo de nuevo más tarde.");
            }
        });
    }
});

function listarProducto() {
    $.ajax({
        type: "GET",
        url: "/producto/list",
        dataType: "json",
        success: function (resultado) {
            $("#tblproducto > tbody").html("");
            $.each(resultado, function (index, value) {
                $("#tblproducto > tbody").append(`<tr> ` +
                    `<td>${value.id} </td>` +
                    `<td>${value.nombre} </td>` +
                    `<td>${value.precio} </td>` +
                    `<td>${value.createAt} </td>` +
                    `<td>${value.stock} </td>` +
                    `<td><button type='button' class='btn btn-primary btnactualizar' ` +
                    `data-prodcod="${value.id}" ` +
                    `data-prodname="${value.nombre}" ` +
                    `data-produnit="${value.precio}" ` +
                    `data-prodcreat="${value.createAt}" ` +
                    `data-prodstock="${value.stock}" ` +
                    `data-proddiscont="${value.activo}">Actualizar` +
                    `</button><td><button type="button" class="btn btn-danger btneliminar"` +
                    `data-prodcod="${value.id}">Eliminar` +
                    `</button></td>`+
                    `</button></td>` +
                    `</tr>`);
            });
        }
    });
}

function convertirFechaStringADate(fechaString) {
    let partesFecha = fechaString.split("-");
    let fecha = new Date(partesFecha[0], partesFecha[1] - 1, partesFecha[2]); // Restar 1 al mes porque en JavaScript los meses empiezan desde 0
    return fecha;
}
