


function OrdenTrabajoDetalle_registro_Transaccion ( id_transaccion  )
{


    VentanaModal("2",  '../OrdenTrabajoDetalle/jspf/registroTransaccion.jspx', 800 );
        
    OrdenTrabajoDetalle_basicform();
    
    
    // jsom
    var pathjson = "../OrdenTrabajoDetalle/Transaccion.json?id="+id_transaccion;
    OrdenTrabajoDetalle_basicform_Json(pathjson);
    
    
    
    var otdat_editar = document.getElementById('otdat_editar');
    otdat_editar.addEventListener('click',
        function() 
        {            
            
                
            if (OrdenTrabajoDetalle_agregarTransaccion_validacion()){
                
                    var otdat_id = document.getElementById('otdat_id');       
                    otdat_id.value ;    


                    var form = document.getElementById("otdat_form");            
                    var accion =  '../OrdenTrabajoDetalle/Transaccion/Editar?id='+id_transaccion ; 
                    var control = AjaxPeticionURL( accion, getDataForm(form) );          

                    if (control != null)
                    {
                        AjaxPeticion('../OrdenTrabajoDetalle/Transaccion/Listar'
                                     ,'tabla_orden_trabajo_detalle');                       

                        OrdenTrabajoDetalle_tabla_registro("otd_transaccion_tabla");
                    }

                    otdat_cerrar.click();                
  
            }            


        }, 
        false
    );  
    
    
    
    
    
    
        
    var otdat_borrar = document.getElementById('otdat_borrar');
    otdat_borrar.addEventListener('click',
        function() 
        {            
            
            var otdat_id = document.getElementById('otdat_id');       
            otdat_id.value ;    

            var control = AjaxUrl('../OrdenTrabajoDetalle/Transaccion/Borrar?id='+id_transaccion);
            
            if (control == null)
            {
                AjaxPeticion('../OrdenTrabajoDetalle/Transaccion/Listar'
                             ,'tabla_orden_trabajo_detalle');                       

                OrdenTrabajoDetalle_tabla_registro("otd_transaccion_tabla");
            }

            otdat_cerrar.click();

        }, 
        false
    );  
    
    
    
    var otdat_cerrar = document.getElementById('otdat_cerrar');   
    otdat_cerrar.addEventListener('click',
        function()
        {
            VentanaModalCerrar("2");
            OrdenTrabajoDetalle_tabla_registro("otd_transaccion_tabla");
        },
        false
    );
    
    
    
    var otdat_cantidad = document.getElementById('otdat_cantidad');
    otdat_cantidad.focus();
    otdat_cantidad.select();

}



function calcular_subtotal (  ){

    
    
    var otdat_cantidad = document.getElementById( 'otdat_cantidad');              
    var otdat_precio_unitario = document.getElementById( 'otdat_precio_unitario');
    
    
    var calculo = NumQP(otdat_cantidad.value) * NumQP(otdat_precio_unitario.value);
    
    var otdat_sub_total_label = document.getElementById( 'otdat_sub_total_label');
    var otdat_sub_total = document.getElementById( 'otdat_sub_total');
    
    if(!isNaN(calculo))
    {  
        otdat_sub_total_label.innerHTML = calculo;    
        otdat_sub_total_label.innerHTML  = fmtNum(otdat_sub_total_label.innerHTML).trim();         
        otdat_sub_total.value = calculo;
    }
    else
    {
        otdat_sub_total_label.innerHTML = "0";    
        otdat_sub_total.value = 0;
    }
    
    
}



