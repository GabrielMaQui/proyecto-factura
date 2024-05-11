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
            $("#txtnombre").val(resultado.nombre);
            $("#txtapellido").val(resultado.apellido);
            $("#txtusuario").val(resultado.username);
            $("#txtusuario").prop('readonly', true);
            $("#hddidusuario").val(resultado.id);
            $("#txtpassword").val(resultado.password);
            $("#txtNuevaContraseña").val("");
            $("#txtConfirmarContraseña").val("");

            $("#switchusuario").show();
            $("#btnenviar").show();
            if (resultado.enabled)
                $("#cbactivo").prop("checked", true);
            else
                $("#cbactivo").prop("checked", false);
        }
    })
    $("#modalusuario").modal("show");
})

$(document).on("click", "#btnguardar", function () {

    let nuevaContraseña = $("#txtNuevaContraseña").val();
    let confirmarContraseña = $("#txtConfirmarContraseña").val();

    if (nuevaContraseña !== confirmarContraseña) {
        alert("La nueva contraseña y la confirmación de contraseña no coinciden.");
        return;
    }
    if(nuevaContraseña == ""){
        nuevaContraseña = $("#txtpassword").val();
    }

    $.ajax({
        type: "POST",
        url: "/seguridad/usuario/registrar",
        contentType: "application/json",
        data: JSON.stringify({
            id: $("#hddidusuario").val(),
            username: $("#txtusuario").val(),
            nombres: $("#txtnombre").val(),
            apellidos: $("#txtapellido").val(),
            password: nuevaContraseña,
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
                let estado = value.enabled ? 'activo' : 'inactivo';
                $("#tblusuario > tbody").append(`<tr>` +
                    `<td>${value.nombre}</td>` +
                    `<td>${value.apellido}</td>` +
                    `<td>${value.username}</td>` +
                    `<td>${estado}</td>` +
                    `<td><button type='button' class='btn btn-primary btnactualizar' ` +
                    `data-usuid="${value.id}">Actualizar` +
                    `</button></td>` +
                    `</tr>`);
            });
        }
    });
}
