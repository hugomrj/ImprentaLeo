


function OrdenTrabajoValores_agregar_Transaccion ( detalle_count )
{

    VentanaModal("3",  '../OrdenTrabajoValores/jspf/agregarTransaccion.jspx', 700 );
        
    OrdenTrabajoValores_basicform();
    CalculadoraDeCortes();



var table = document.getElementById( "otd_transaccion_tabla" ).getElementsByTagName('tbody')[0];
var otval_cantidad_pedido = document.getElementById('otval_cantidad_pedido');
otval_cantidad_pedido.value = (table.rows[ detalle_count-1 ].cells[0].innerHTML) 
        * (table.rows[ detalle_count-1 ].cells[1].innerHTML)  ;   






    
    var otval_aceptar = document.getElementById('otval_aceptar');
    otval_aceptar.addEventListener('click',
        function() 
        {            
            
                
            if (OrdenTrabajoValores_agregarTransaccion_validacion()){
                
                var form = document.getElementById("otval_form");            
                var accion =  form.getAttribute('action') ; 

                var control = AjaxPeticionURL( accion, getDataForm(form) );                
                
                
                if (!(isNaN(control)))
                {                       
                    AjaxPeticion('../OrdenTrabajoValores/Transaccion/Listar'
                                 ,'otvalores_transaccion_tabla');                        
                    
                    otval_cerrar.click();
                }
                else
                {    
                    alerta_error(control);
                }

            }

        }, 
        false
    );  
    
    
    
    
    var otval_cerrar = document.getElementById('otval_cerrar');   
    otval_cerrar.addEventListener('click',
        function()
        {
            VentanaModalCerrar("3");            
            OrdenTrabajoValores_tabla_registro("otvalores_transaccion_tabla");                
        },
        false
    );
    

       




}








