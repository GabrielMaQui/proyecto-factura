let token = $("meta[name='_csrf']").attr("content");
let header = $("meta[name='_csrf_header']").attr("content");
$(document).ajaxSend(function (e, xhr, options) {
    xhr.setRequestHeader(header, token);
});
$(document).on("click", "#btnagregar", function () {
    $("#txtnombre").val("");
    $("#txtapellido").val("");
    $("#txtusuario").val("");
    $("#hddidusuario").val("0");
    $("#switchusuario").hide();
    $("#cbactivo").prop("checked", false);
    $("#txtpassword").val("")
    $("#btnenviar").hide();
    $("#modalusuario").modal("show");
});
$(document).on("click", ".btnactualizar", function () {
    $.ajax({
        type: "GET",
        url: "/seguridad/usuario/" + $(this).attr("data-usuid"),
        dataType: "json",
        success: function (resultado) {
            $("#txtnombre").val(resultado.nombres);
            $("#txtapellido").val(resultado.apellidos);
            $("#txtusuario").val(resultado.nomusuario);
            $("#txtusuario").prop('readonly', true);
            $("#hddidusuario").val(resultado.idusuario);
            $("#switchusuario").show();
            $("#btnenviar").show();
            if (resultado.activo)
                $("#cbactivo").prop("checked", true);
            else
                $("#cbactivo").prop("checked", false);
        }
    })
    $("#modalusuario").modal("show");
})

$(document).on("click", "#btnguardar", function () {
    $.ajax({
        type: "POST",
        url: "/seguridad/usuario/registrar",
        contentType: "application/json",
        data: JSON.stringify({
            id: $("#hddidusuario").val(),
            username: $("#txtusuario").val(),
            nombres: $("#txtnombre").val(),
            apellidos: $("#txtapellido").val(),
            password: $("#txtpassword").val(),
            enabled: $("#cbactivo").prop("checked")
        }),
        success: function (resultado) {
            if (resultado.respuesta) {
                listarUsuarios()
            }
            alert(resultado.mensaje);
        }
    });
    $("#modalusuario").modal("hide");
});

function listarUsuarios() {
    $.ajax({
        type: "GET",
        url: "/seguridad/usuario/lista",
        dataType: "json",
        success: function (resultado) {
            $("#tblusuario > tbody").html("");
            $.each(resultado, function (index, value) {
                $("#tblusuario > tbody").append(`<tr>` +
                    `<td>${value.nombre}</td>` +
                    `<td>${value.apellido}</td>` +
                    `<td>${value.username}</td>` +
                    `<td>${value.enabled}</td>` +
                    `<td><button type='button' class='btn btn-primary btnactualizar' ` +
                    `data-usuid="${value.id}">Actualizar` +
                    `</button></td>` +
                    `</tr>`);
            });
        }
    });
}
