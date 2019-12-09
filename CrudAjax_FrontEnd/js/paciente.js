$(document).ready(inicio);
function inicio() {
    cargarDatos();
    $("#btnGuardar").click(guardar);
    $("#modificarPaciente").click(modificar);
    $("#eliminarPaciente").click(eliminar);
}

//cargar datos
function cargarDatos() {
    //peticion ajax para soliciytar datos de docctores
    $.ajax({
        url: "http://localhost:8080/paciente/all",
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
            + item.nombre
            + "</td>"
            + "<td>"
            + item.direccion
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

//Funcion Guardar
function guardar() {
    $.ajax({
        url: "http://localhost:8080/paciente/save",
        method: "Get",
        data: {
            nombre: $("#nombre").val(),
            direccion: $("#direccion").val()
        },
        success: function(){
            cargarDatos();
        },
        error: function(){
            alert("Error en la Peticion"+ response)
        }
    })
}

//Funcion Editar
function cargarEditar(id){
    $.ajax({
        url: "http://localhost:8080/paciente/obtener/"+id,
        method: "Get",
        success: function (response) {  
            $("#id2").val(response.id),
            $("#nombre2").val(response.nombre)
            $("#direccion2").val(response.direccion)
        },
        error: errorPeticion
    })
}

//Funcion Modificar
function modificar(){
    var id = $("#id2").val()
    $.ajax({
    url: "http://localhost:8080/paciente/update/" + id,
    method: "Get",
    data: {
        id: id,
        nombre: $("#nombre2").val(),
        direccion: $("#direccion2").val()
    },
    success: function(response){
        cargarDatos();
    },
    error: errorPeticion
    })
}

//Funcion Eliminar
function preEliminar(id){
    $("#idPaciente").val(id);
    $("#eliminar").modal();
}
function eliminar() {
    var id = $("#idPaciente").val();
    $.ajax({
        url: "http://localhost:8080/paciente/delete/" + id,
        method: "Get",
        data: null,
        success: function (response) {
            alert(response.mensaje);
            cargarDatos();
        },
        error: errorPeticion
    });
  }