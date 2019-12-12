

$(document).ready(inicio);

function inicio() {
    $("#agregarDetalle").click(agregarDetalle);
    resetDetalles();

}

function resetDetalles() {
    $.ajax({
        url:"http://localhost:8080/consultas/resetDetalles",
        method:"Post"

    });
}
function agregarDetalle() {
    $.ajax({
        url:"http://localhost:8080/consultas/agregarDetalle",
        method:"Post",
        data:{
            sintoma:$("#sintoma").val()
        },
        success:function(response){
            console.log(response);
            cargarDetalles();
            $("#sintoma").val("");
        },
        error:errorPeticion
    });
}

function cargarDetalles() {
    $.ajax({
        url:"http://localhost:8080/consultas/detalles",
        method:"Get",
        success:function(response){
            $("#tDetalles").html(""); //reseteando datos

            //cargando datos en la tabla
            response.forEach(i => {
                $("#tDetalles").append(""
                +"<tr>"
                    +"<td>"+i.sintoma+"</td>"
                    +"<td><button class='btn btn-danger'>eliminar</button></td>"
                +"</tr>");
            });
        },
        error:errorPeticion
    });
}
function errorPeticion(response) {
    console.log(response);
}