


function OrdenTrabajoDetalle_agregar_Transaccion (  )
{

    VentanaModal("1",  '../OrdenTrabajoDetalle/jspf/agregarTransaccion.jspx', 800 );
        
    OrdenTrabajoDetalle_basicform();

    
    var otdat_aceptar = document.getElementById('otdat_aceptar');
    otdat_aceptar.addEventListener('click',
        function() 
        {            
            
            /*
            session = AjaxUrl ("../Usuario/Session") ;
            if (session == null){
                window.location = "../";    
                return;
            }
            */           
            
            
            if (OrdenTrabajoDetalle_agregarTransaccion_validacion()){
                
                var form = document.getElementById("otdat_form");            
                var accion =  form.getAttribute('action') ; 
                var control = AjaxPeticionURL( accion, getDataForm(form) );                
                
                if (!(isNaN(control)))
                {   
                    AjaxPeticion('../OrdenTrabajoDetalle/Transaccion/Listar'
                                 ,'tabla_orden_trabajo_detalle');                        
                    
                    otdat_cerrar.click();
                }
                else
                {    
                    //alerta_error(control);
                }



            }

        }, 
        false
    );  
    
    
    
      
    
    
    var otdat_cerrar = document.getElementById('otdat_cerrar');   
    otdat_cerrar.addEventListener('click',
        function()
        {
            VentanaModalCerrar("1");
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









