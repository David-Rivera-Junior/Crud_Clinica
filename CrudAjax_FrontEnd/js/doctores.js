$(document).ready(inicio);

function inicio() {
   cargarDatos(); 
   cargarEspecialidades();

   $("#guardarDoctor").click(guardar);

   $("#eliminarDoctor").click(eliminar);

   $("#modificarDoctor").click(modificar);
}

//cargar datos
function cargarDatos() {
    //peticion ajax para soliciytar datos de docctores
    $.ajax({
        url:"http://localhost:8080/doctores/all",
        method:"Get",
        data:null,
        success:procesarDatosTabla,
        error:errorPeticion
    });
}

//procesando datos de la peticion
function procesarDatosTabla(response) {
    $("#tDatos").html(""); //reseteando la tabla
    response.forEach(item => {
        $("#tDatos").append(""
        +"<tr>"
            +"<td>"
                +""+item.id
            +"</td>"
            +"<td>"
                +""+item.nombre
            +"</td>"
            +"<td>"
                +""+item.direccion
            +"</td>"
            +"<td>"
                +""+item.especialidad.especialidad
            +"</td>"
            +"<td>"
                +"<button onclick='preModificar("+item.id+");' class='btn btn-warning ml-2'>Modificar</button>"
                +"<button onclick='preEliminar("+item.id+");' class='btn btn-danger ml-2'>Eliminar</button>"
            +"</td>"
        +"</tr>"
        +"");
    });
    
}

function errorPeticion(response) {
    alert("Error al realizar la peticion: "+response);
    console.log("Error al realizar la peticion: "+response);
}

function cargarEspecialidades() {
    $.ajax({
        url:"http://localhost:8080/doctores/allEspecialidad",
        method:"Get",
        data:null,
        success: function(response){
            response.forEach(item => {
                $("#especialidad").append(""
                    +"<option value='"+item.id+"'>"+item.especialidad+"</option>"
                +"");

                $("#especialidad2").append(""
                +"<option value='"+item.id+"'>"+item.especialidad+"</option>"
            +"");
             });  
        },
        error:errorPeticion
    });
}

function guardar() {
    $.ajax({
        url:"http://localhost:8080/doctores/save",
        method:"Get",
        data:{
            nombre:$("#nombre").val(),
            direccion:$("#direccion").val(),
            idEspecialidad:$("#especialidad").val()
        },
        success:function(response){
            alert(response.mensaje);
            cargarDatos();
        },
        error:errorPeticion

    });
}

function preEliminar(id) {
  $("#idDoctor").val(id);
  $("#modalEliminarDoctor").modal();
}

function eliminar() {
    var id=$("#idDoctor").val();
    $.ajax({
        url:"http://localhost:8080/doctores/delete/"+id,
        method:"Get",
        data:null,
        success:function(response){
            alert(response.mensaje);
            cargarDatos();
        },
        error:errorPeticion

    });
}

function preModificar(id) {
    $("#modalModificarDoctor").modal();
    // alert(id);
    $.ajax({
        url:"http://localhost:8080/doctores/getDoctor/"+id,
        method:"Get",
        success:function(response){
            $("#id").val(response.id);
            $("#nombre2").val(response.nombre);
            $("#direccion2").val(response.direccion);
            $("#especialidad2").val(response.especialidad.id);
        },
        error:errorPeticion

    });
}

function modificar() {
    var id=$("#id").val();
    $.ajax({
        url:"http://localhost:8080/doctores/update/"+id,
        method:"Get",
        data:{
            id:id,
            nombre:$("#nombre2").val(),
            direccion:$("#direccion2").val(),
            idEspecialidad:$("#especialidad2").val()
        },
        success:function(response){
            alert(response.mensaje);
            cargarDatos();
        },
        error:errorPeticion

    });
}