/* Cargar todos los elementos  */
$(document).ready(inicio);
function inicio() {
    cargarDatos();
    cargarDoctor();
    cargarPaciente();
    cargarPaciente2();
    cargarDoctor2();
    $("#modificarConsulta").click(modificar);
    $("#eliminarConsulta").click(eliminar);
    $("#btnguardar").click(guardar);
}

/* Metodo para cargar datos con peticion ajax */
function cargarDatos() {
    $.ajax({
        url: "http://localhost:8080/consulta/all",
        method: "Get",
        data: null,
        success: function (response) {
            $("#tDatos").html("");
    /* Recorrer los elementos del array y retornar la respuesta de la peticion */
            for (let i = 0; i < response.length; i++) {
                $("#tDatos").append(
                    "<tr>" +
                    "<td>" + response[i].id + "</td>" +
                    "<td>" + response[i].fecha + "</td>" +
                    "<td>" + response[i].sintomas + "</td>" +
                    "<td>" + response[i].diagnostico + "</td>" +
                    "<td>" + response[i].doctor.nombre + "</td>" +
                    "<td>" + response[i].paciente.nombre + "</td>" +
                    "<td>"
                    + "<button onclick='preModificar(" + response[i].id + ");' class='btn btn-warning ml-2' data-toggle='modal' data-target='#modalModificarConsulta'>Modificar</button>"
                    + "<button onclick='preEliminar(" + response[i].id + ");' class='btn btn-danger ml-2' data-toggle='modal' data-target='#modalEliminarConsulta'>Eliminar</button>"
                    + "</td>" +
                    "</tr>")
            }
        },
        error: errorPeticion
    });
};

function errorPeticion(response) {
    alert("Error al realizar la peticion: " + response);
    console.log("Error al realizar la peticion: " + response);
}


// Cargar la funcion Para Aguardar doctor en el select
function cargarDoctor() {
    $.ajax({
        url: "http://localhost:8080/doctores/all",
        method: "Get",
        data: null,
        success: function (response) {
            response.forEach(item => {
                $("#doctor").append(""
                    + "<option value='" + item.id + "'>" + item.nombre + "</option>"
                    + "");
            });
        },
        error: errorPeticion
    });
}

//Funcion para cargar 
function cargarPaciente() {
    $.ajax({
        url: "http://localhost:8080/paciente/all",
        method: "Get",
        data: "null",
        success: function (response) {
            response.forEach(item => {
                $("#paciente").append(""
                    + "<option value='" + item.id + "'>" + item.nombre + "</option>"
                    + "");
            });
        },
        error: errorPeticion
    });
}

//Moficicar el elemento de la tabla
function preModificar(id) {
    $.ajax({
        url: "http://localhost:8080/consulta/getConsulta/" + id,
        method: "Get",
        success: function (response) {
            $("#id2").val(response.id);
            $("#fecha2").val(response.fecha);
            $("#sintomas2").val(response.sintomas);
            $("#diagnostico2").val(response.diagnostico);
            $("#doctor2").val(response.doctor.id);
            $("#paciente2").val(response.paciente.id);
        },
        error: errorPeticion

    });
}

//Moficicar el elemento de la tabla
function modificar() {
    var id = $("#id2").val();
    $.ajax({
        url: "http://localhost:8080/consulta/update/" + id,
        method: "Get",
        data: {
            id: id,
            fecha: $("#fecha2").val(),
            sintomas: $("#sintomas2").val(),
            diagnostico: $("#diagnostico2").val(),
            idDoctor: $("#doctor2").val(),
            idPaciente: $("#paciente2").val()
        },
        success: function (response) {
            alert(response.mensaje);
            cargarDatos();
        },
        error: function (response) {
            alert("Error en la peticion " + response);
        }
    });
} 

//Funcion Cargar Doctor en el select de Modificar
function cargarDoctor2() {
    $.ajax({
        url: "http://localhost:8080/doctores/all",
        method: "Get",
        data: "null",
        success: function (response) {
            response.forEach(item => {
                $("#doctor2").append(""
                    + "<option value='" + item.id + "'>" + item.nombre + "</option>"
                    + "");
            });
        },
        error: errorPeticion
    });
}
//Funcion Cargar Paciente en el select de Modificar
function cargarPaciente2() {
    $.ajax({
        url: "http://localhost:8080/paciente/all",
        method: "Get",
        data: "null",
        success: function (response) {
            response.forEach(item => {
                $("#paciente2").append(""
                    + "<option value='" + item.id + "'>" + item.nombre + "</option>"
                    + "");
            });
        },
        error: errorPeticion
    });
}

//Funcion Eliminar de la Tabla
function preEliminar(id) {
    $("#idConsulta").val(id);
}

//Funcion Eliminar de la Tabla
function eliminar() {
    var id = $("#idConsulta").val();
    $.ajax({
        url: "http://localhost:8080/consulta/delete/" + id,
        method: "Get",
        data: null,
        success: function (response) {
            alert(response.mensaje);
            cargarDatos();
        },
        error: errorPeticion

    });
}

//Moficicar el elemento de la tabla
function preModificar(id) {
    $.ajax({
        url: "http://localhost:8080/consulta/getConsulta/" + id,
        method: "Get",
        success: function (response) {
            $("#id2").val(response.id);
            $("#fecha2").val(response.fecha);
            $("#sintomas2").val(response.sintomas);
            $("#diagnostico2").val(response.diagnostico);
            $("#doctor2").val(response.doctor.id);
            $("#paciente2").val(response.paciente.id);
        },
        error: errorPeticion

    });
}

//Funcion datos en la tabla Guardar
function guardar() {
    $.ajax({
        url: "http://localhost:8080/consulta/save",
        method: "Get",
        data: {
            fecha: $("#fecha").val(),
            sintomas: $("#sintomas").val(),
            diagnostico: $("#diagnostico").val(),
            idDoctor: $("#doctor").val(),
            idPaciente: $("#paciente").val()
        },
        success: function (response) {
            //reset();
            cargarDatos();
        },
        error: function (response) {
            alert("Error en la peticion " + response);
        }
    })
}