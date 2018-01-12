
var id = getParametroValor("id");   


window.onload = function() {

    AjaxPeticion('../MenuPrincipal','nav');   
    
    AjaxPeticion('../OrdenTrabajo/jspf/form.jspx'
                ,'form_body');          
    OrdenTrabajo_basicform();
    
    // ocultar botones
   document.getElementById('ordent_cliente_buscar').style.display = 'none';
   document.getElementById('ordent_cliente_agregar').style.display = 'none';
    
    //bloquear from
    OrdenTrabajo_form_disabled();
    
    OrdenTrabajo_Json(id);
    document.getElementById('ordent_cliente').onblur();
    
      
    AjaxPeticion('../OrdenTrabajoDetalle/Coleccion/Lista?orden='+id
                ,'tabla_orden_trabajo_detalle');              
    OrdenTrabajoDetalle_tabla_formato("otd_transaccion_tabla");



    AjaxPeticion('../OrdenTrabajoValores/Coleccion/Lista?orden='+id
             ,'tabla_orden_trabajo_valores');      
    OrdenTrabajoValores_tabla_formato("otvalores_transaccion_tabla");


    // botones de accion
    
    var otval_nuevo  = document.getElementById('otval_nuevo');
    otval_nuevo.addEventListener('click',
        function(event) {
            location.href="../OrdenTrabajo/Transaccion/Inicio";
        },
        false
    );    


    var otval_lista = document.getElementById('otval_lista');
    otval_lista.addEventListener('click',
        function(event) {
            location.href="../OrdenTrabajo/Lista.jspx";
        },
        false
    );    


    var otval_eliminar = document.getElementById('otval_eliminar');
    otval_eliminar.addEventListener('click',
        function(event) {
            location.href="../OrdenTrabajo/Borrar.jspx?id="+id;
        },
        false
    );    





};



window.onresize = function() {
    
    var nodeList = document.querySelectorAll('.fondo_oscuro');
    
    for (var i = 0; i < nodeList.length; ++i) {
        document.getElementById(nodeList[i].id).style.height = document.body.scrollHeight;        
    }

}



