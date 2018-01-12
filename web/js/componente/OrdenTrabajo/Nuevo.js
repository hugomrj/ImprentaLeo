


window.onload = function() {

    AjaxPeticion('../MenuPrincipal','nav');   
    
    
    AjaxPeticion('../OrdenTrabajo/jspf/form.jspx'
                ,'form_body');          
    OrdenTrabajo_basicform();
      
      
      
    AjaxPeticion('../OrdenTrabajoDetalle/Transaccion/Listar'
                ,'tabla_orden_trabajo_detalle');              
    OrdenTrabajoDetalle_tabla_registro("otd_transaccion_tabla");

    AjaxPeticion('../OrdenTrabajoValores/Transaccion/Listar'
             ,'tabla_orden_trabajo_valores');      
     OrdenTrabajoValores_tabla_registro("otvalores_transaccion_tabla");                

    

    var date = new Date();
    document.getElementById("ordent_fecha_recepcion").value = 
            date.getFullYear() + "-" + (date.getMonth()<10?'0':'') + (date.getMonth() + 1) + "-" + (date.getDate()<10?'0':'') + date.getDate();


    var otd_agregar_trasanccion = document.getElementById('otd_agregar_trasanccion');   
    otd_agregar_trasanccion.addEventListener('click',
        function()
        {
            OrdenTrabajoDetalle_agregar_Transaccion();     
        },
        false
    );


    var otval_agregar_trasanccion = document.getElementById('otval_agregar_trasanccion');   
    otval_agregar_trasanccion.addEventListener('click',
        function()
        {
           
            
            var detalle_count = 0;    
            detalle_count = AjaxUrl('../OrdenTrabajoDetalle/Transaccion/Count');    
            if ( parseInt(detalle_count) == 0 ) 
            {
                alerta_error("Se tiene que cargar primero las cantidad del pedido");
                return false;
            }
            
            OrdenTrabajoValores_agregar_Transaccion( detalle_count );     
        },
        false
    );

    
    var otval_guardar_orden = document.getElementById('otval_guardar_orden');   
    otval_guardar_orden.addEventListener('click',
        function()
        {


            var dataform = ""
            dataform = dataform +"&off_set=";
            if ( document.getElementById("chk_offset").checked == true ){
                dataform = dataform + "1";
            }
            else{
                dataform = dataform + "0";
            }
            
            
            dataform = dataform +"&tipografica=";
            if ( document.getElementById("chk_tipografia").checked == true ){
                dataform = dataform + "1";
            }
            else{
                dataform = dataform + "0";
            }
            
            
            if (OrdenTrabajoNuevo_validacion())
            {
                var form = document.getElementById("ordent_form");            
                var accion =  form.getAttribute('action') ; 
                var control = AjaxPeticionURL( accion, getDataForm(form)+dataform  );                


                if (!(isNaN(control))){                                          

                    location.href="../OrdenTrabajo/Registro.jspx?id="+control;
                }
                else{                    
                    alerta_error(control);
                }
                
            }            
            
        },
        false
    );



    var otval_cancelar_orden = document.getElementById('otval_cancelar_orden');
    otval_cancelar_orden.addEventListener('click',
        function(event) {
            location.href="../OrdenTrabajo/Lista.jspx";
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










function OrdenTrabajoNuevo_validacion (  ){


    // controlar las cuadriculas estas cargadas
    var detalle_count = 0;    
    detalle_count = AjaxUrl('../OrdenTrabajoDetalle/Transaccion/Count');    
    if ( parseInt(detalle_count) == 0 ) 
    {
        alerta_error("Faltan valores del pedido");
        return false;
    }
    
    var valores_count = 0;    
    valores_count = AjaxUrl('../OrdenTrabajoValores/Transaccion/Count');   
    if ( parseInt(valores_count) == 0 ) 
    {
        alerta_error("Faltan cargar los valores de corte del pedido");
        return false;
    }

   
    var ordent_fecha_recepcion = document.getElementById('ordent_fecha_recepcion');    
    if (ordent_fecha_recepcion.value == '') {
        alerta_error("La fecha de recepcion esta vacia");
        ordent_fecha_recepcion.focus();
        return false;
    }    
        

    var ordent_fecha_entrega = document.getElementById('ordent_fecha_entrega');    
    if (ordent_fecha_entrega.value == '') {
        alerta_error("La fecha de entrega esta vacia");
        ordent_fecha_entrega.focus();
        return false;
    }    
        

    var fe1 = parseInt(ordent_fecha_recepcion.value.toString().replace(/-/g, ""));
    var fe2 = parseInt(ordent_fecha_entrega.value.toString().replace(/-/g, ""));    
    var diff = (fe2 - fe1);
    if (diff < 0){
        alerta_error("La fecha de entrega no puede ser menor a la recepcion");
        return false;        
    }
            

    return true;
    
    
    
    
}

