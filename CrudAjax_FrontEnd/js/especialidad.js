$(document).ready(inicio);
function inicio() {
    cargarDatos();
    cargarSelectEspecialidad();
    $("#btnGuardar").click(guardar);
    $("#modificarEspecialidad").click(modificar);
    $("#eliminarEspecialidad").click(eliminar);
}

//cargar datos
function cargarDatos() {
    //peticion ajax para soliciytar datos de docctores
    $.ajax({
        url: "http://localhost:8080/especialidades/all",
        method: "Get",
        data: null,
        success: procesarDatosTabla,
        error: errorPeticion
    });
}

//procesando datos de la peticion
function procesarDatosTabla(response) {
    $("#tDatos").html(""); //reseteando la tabla
    response.forEach(item => {
        $("#tDatos").append(
            "<tr>"
            + "<td>"
            + item.id
            + "</td>"
            + "<td>"
            + item.especialidad
            + "</td>"
            + "<td>"
            + "<button onclick='cargarEditar(" + item.id + ");' class='btn btn-warning ml-2' data-toggle='modal' data-target='#editar'>Modificar</button>"
            + "<button onclick='preEliminar(" + item.id + ");' class='btn btn-danger ml-2' data-toggle='modal' data-target='#eliminar'>Eliminar</button>"
            + "</td>"
            + "</tr>");
    });

}

function errorPeticion(response) {
    alert("Error al realizar la peticion: " + response);
    console.log("Error al realizar la peticion: " + response);
}

/* Cargara Select de Especialidades */
function cargarSelectEspecialidad() {
    $.ajax({
        url: "http://localhost:8080/especialidades/all",
        method: "Get",
        data: null,
        success: function (response) {
            response.forEach(item => {
                $("#especialidad").append(""
                    + "<option value='" + item.id + "'>" + item.especialidad + "</option>"
                    + "");
            });
        },
        error: errorPeticion
    });
}

function guardar() {
    $.ajax({
        url: "http://localhost:8080/especialidades/save",
        method: "Get",
        data: {
            especialidad: $("#especialidad").val()
        },
        success: function () {
            cargarDatos();
        },
        error: function () {
            alert("Error " + response)
        }
    })
}

function cargarEditar(id) {
    $.ajax({
        url: "http://localhost:8080/especialidades/obtener/" + id,
        method: "Get",
        success: function (response) {
            $("#id").val(response.id),
                $("#especialidad2").val(response.especialidad)
        },
        error: errorPeticion
    });
}

function modificar() {
    var id = $("#id").val()
    $.ajax({
        url: "http://localhost:8080/especialidades/update/" + id,
        method: "Get",
        data: {
            id: id,
            especialidad: $("#especialidad2").val()
        },
        success: function (response) {
            cargarDatos();
        },
        error: errorPeticion
    })
}

function preEliminar(id) {
    $("#idEspecialidad").val(id);
    $("#eliminar").modal();
}

function eliminar() {
    var id = $("#idEspecialidad").val();
    $.ajax({
        url: "http://localhost:8080/especialidades/delete/" + id,
        method: "Get",
        data: null,
        success: function (response) {
            alert(response.mensaje);
            cargarDatos();
        },
        error: errorPeticion
    });
}