


function OrdenTrabajoValores_registro_Transaccion ( id_transaccion  )
{


    VentanaModal("2",  '../OrdenTrabajoValores/jspf/registroTransaccion.jspx', 800 );
        
    
    OrdenTrabajoValores_basicform();
    CalculadoraDeCortes();
    
  
    // jsom
    var pathjson = "../OrdenTrabajoValores/Transaccion.json?id="+id_transaccion;    
    OrdenTrabajoValores_basicform_Json(pathjson);
  
   
    
   
   
   
    var otvtr_editar = document.getElementById('otvtr_editar');
    otvtr_editar.addEventListener('click',
        function() 
        {            
            
            if (OrdenTrabajoValores_agregarTransaccion_validacion()){
                
                    var otdat_id = document.getElementById('otval_id');       
                    otdat_id.value ;    

                    var form = document.getElementById("otvtr_form");            
                    var accion =  '../OrdenTrabajoValores/Transaccion/Editar?id='+id_transaccion ; 
                    var control = AjaxPeticionURL( accion, getDataForm(form) );          

                    if (control != null)
                    {  
                        
                        AjaxPeticion('../OrdenTrabajoValores/Transaccion/Listar'
                                    ,'tabla_orden_trabajo_valores');      
                        OrdenTrabajoValores_tabla_registro("otvalores_transaccion_tabla");                               
  
                    }
                    otvtr_cerrar.click();                
            }            

        }, 
        false
    );  
    
       
   
   
        
    var otvtr_borrar = document.getElementById('otvtr_borrar');
    otvtr_borrar.addEventListener('click',
        function() 
        {            

            var otdat_id = document.getElementById('otval_id');       
            otdat_id.value ;    

            var control = AjaxUrl('../OrdenTrabajoValores/Transaccion/Borrar?id='+id_transaccion);            
            if (control == null)
            {
                        AjaxPeticion('../OrdenTrabajoValores/Transaccion/Listar'
                                    ,'tabla_orden_trabajo_valores');      
                        OrdenTrabajoValores_tabla_registro("otvalores_transaccion_tabla");       
            }
            otvtr_cerrar.click();

        }, 
        false
    );  
    
   
   
   
   
   
    var otvtr_cerrar = document.getElementById('otvtr_cerrar');   
    otvtr_cerrar.addEventListener('click',
        function()
        {
            VentanaModalCerrar("2");
            OrdenTrabajoValores_tabla_registro("otd_transaccion_tabla");
        },
        false
    );
    
    



}

