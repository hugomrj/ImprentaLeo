
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
    var otEval_aceptar = document.getElementById('otEval_aceptar');
    otEval_aceptar.addEventListener('click',
        function(event) {
            
                var form = document.getElementById("ordent_form");                        
                var accion =  "../OrdenTrabajo/Controlador/Borrar" ;             

                var control = AjaxPeticionURL( accion, getDataForm(form) );                

                if (control.toString().trim() == "DeleteOK"){                       
                    window.location = "../OrdenTrabajo/Lista.jspx";
                }
                else
                {    
                    alerta_error(control);
                }
        },
        false
    );    


    var otEval_cancelar = document.getElementById('otEval_cancelar');
    otEval_cancelar.addEventListener('click',
        function(event) {
            location.href="../OrdenTrabajo/Registro.jspx?id="+id;
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


