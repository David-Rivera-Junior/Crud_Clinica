let paciente = { id: 0, nombre: "" };

let doctor = {
    id: 0,
    nombre: ""
};

$(document).ready(function () {
    // alert("hola");
    console.log("inicio");
    resetDetalles();
    cargarPacientes();
    cargarDoctores();
    $("#agregarDetalle").click(agregarDetalle);


    $("body").on('click', '.agregarPaciente', function () {

        agregarPaciente($(this).parent().parent().children('td:eq(0)').text(), $(this).parent().parent().children('td:eq(1)').text());
    });

    //$('#tPaciente').DataTable();


    $("body").on('click', '.agregarDoctor', function () {
        agregarDoctor($(this).parent().parent().children('td:eq(0)').text(), $(this).parent().parent().children('td:eq(1)').text());
    });
});



function cargarPacientes() {
    console.log("cargar pacientes");
    $("#tablePacientes").DataTable({

        "ajax": {
            "url": "http://localhost:8080/consultas/getPacientes",
            "method": "Get"
        },
        "columns": [
            {
                "data": "id",
                "width": "5%"
            },
            {
                "data": "nombre",
                "width": "30%"
            },
            {
                "data": "direccion",
                "width": "40%"
            },
            {
                "data": "operacion",
                "width": "10%"
            }
        ],
        "scrollY": 200,
        "language": {
            "lengthMenu": "Mostrar _MENU_ ",
            "zeroRecords": "Datos no encontrados",
            "info": "Mostar páginas _PAGE_ de _PAGES_",
            "infoEmpty": "Datos no encontrados",
            "infoFiltered": "(Filtrados por _MAX_ total registros)",
            "search": "Buscar:",
            "paginate": {
                "first": "Primero",
                "last": "Anterior",
                "next": "Siguiente",
                "previous": "Anterior"
            }
        }
    });
}

/*  */
function cargarDoctores() {
    $("#tablaDoctores").DataTable({
        "ajax": {
            "url": "http://localhost:8080/consultas/getDoctores",
            "method": "Get"
        },
        "columns": [{
            "data": "id",
            "width": "5%"
        },
        {
            "data": "nombre",
            "width": "30%"
        },
        {
            "data": "direccion",
            "width": "30%"
        },
        {
            "data": "especialidad",
            "width": "30%"
        },
        {
            "data": "operacion",
            "width": "5%"
        }
        ],
        "scrollY": 200,
        "language": {
            "lengthMenu": "Mostrar _MENU_ ",
            "zeroRecords": "Datos no encontrados",
            "info": "Mostar páginas _PAGE_ de _PAGES_",
            "infoEmpty": "Datos no encontrados",
            "infoFiltered": "(Filtrados por _MAX_ total registros)",
            "search": "Buscar:",
            "paginate": {
                "first": "Primero",
                "last": "Anterior",
                "next": "Siguiente",
                "previous": "Anterior"
            }
        }
    });
}

function resetDetalles() {
    console.log("reseteo de detalles");
    $.ajax({
        url: "http://localhost:8080/consultas/resetDetalles",
        method: "Post"

    });
}

function agregarDetalle() {
    console.log("agregar detalle");
    $.ajax({
        url: "http://localhost:8080/consultas/agregarDetalle",
        method: "Post",
        data: {
            sintoma: $("#sintoma").val()
        },
        success: function (response) {
            console.log(response);
            cargarDetalles();
            $("#sintoma").val("");
        },
        error: errorPeticion
    });
}

function cargarDetalles() {
    console.log("cargar detalles");
    $.ajax({
        url: "http://localhost:8080/consultas/detalles",
        method: "Get",
        success: function (response) {
            $("#tDetalles").html(""); //reseteando datos

            //cargando datos en la tabla
            response.forEach(i => {
                $("#tDetalles").append(""
                    + "<tr>"
                    + "<td>" + i.sintoma + "</td>"
                    + "<td><button class='btn btn-danger'>eliminar</button></td>"
                    + "</tr>");
            });
        },
        error: errorPeticion
    });
}

function errorPeticion(response) {
    console.log(response);
}

function agregarPaciente(id, nombre) {
    paciente.id = id;
    paciente.nombre = nombre;

    $("#paciente").val(nombre);

    console.log(paciente);
}

function agregarDoctor(id, nombre) {
    doctor.id = id;
    doctor.nombre = nombre;

    $("#doctor").val(nombre);
}
