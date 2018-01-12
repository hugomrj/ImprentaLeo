


function OrdenTrabajoValores_basicform (   )
{
          
    
    var otval_cantidad_pedido = document.getElementById( 'otval_cantidad_pedido');
    otval_cantidad_pedido.onblur  = function() {        
        otval_cantidad_pedido.value  = fmtNum(otval_cantidad_pedido.value);                 
    };     
    
    
    var otval_pliegos = document.getElementById( 'otval_pliegos');
    otval_pliegos.onblur  = function() {        
        otval_pliegos.value  = fmtNum(otval_pliegos.value);                 
    };     
        


}





function OrdenTrabajoValores_basicform_Json(path)
{
  
    var jsonRestOTD = AjaxUrl( path );    
    
    if (jsonRestOTD.toString().trim() != "[]")
    {        
        var json = JSON.parse(jsonRestOTD);    
            
        var otval_id = document.getElementById('otval_id');       
        otval_id.value =  (json[0].id);       
        
        
        var otval_tam_ancho = document.getElementById('otval_tam_ancho');       
        otval_tam_ancho.value =  (json[0].tam_ancho);       
        
        var otval_tam_largo = document.getElementById('otval_tam_largo');       
        otval_tam_largo.value =  (json[0].tam_largo);       
        
        var otval_corte_ancho = document.getElementById('otval_corte_ancho');       
        otval_corte_ancho.value =  (json[0].corte_ancho);       

        var otval_corte_largo = document.getElementById('otval_corte_largo');       
        otval_corte_largo.value =  (json[0].corte_largo);       



        var otval_cantidad_pedido = document.getElementById('otval_cantidad_pedido');       
        otval_cantidad_pedido.value =  (json[0].cantidad_pedido);       
        
        var otval_pliegos = document.getElementById('otval_pliegos');       
        otval_pliegos.value =  (json[0].pliegos);       
        
        var otval_descripcion = document.getElementById('otval_descripcion');       
        otval_descripcion.value =  (json[0].descripcion);       
        
        var otval_sale = document.getElementById('otval_sale');       
        otval_sale.value =  (json[0].sale);  
        
        
        
    }  
    
    OrdenTrabajoValores_basicform();

    
}




function OrdenTrabajoValores_agregarTransaccion_validacion (  ){


    var otval_tam_ancho = document.getElementById('otval_tam_ancho');      
    if ( parseInt(otval_tam_ancho.value) <= 0 ) 
    {
        alerta_error("error en valores de corte");
        return false;
    }


    var otval_tam_largo = document.getElementById('otval_tam_largo');      
    if ( parseInt(otval_tam_largo.value) <= 0 ) 
    {
        alerta_error("error en valores de corte");
        return false;
    }


    var otval_corte_ancho = document.getElementById('otval_corte_ancho');      
    if ( parseFloat(otval_corte_ancho.value) <= 0 ) 
    {
        alerta_error("error en valores de corte");
        return false;
    }

    var otval_corte_largo = document.getElementById('otval_corte_largo');      
    if ( parseFloat(otval_corte_largo.value) <= 0 ) 
    {
        alerta_error("error en valores de corte");
        return false;
    }


    var otval_sale = document.getElementById('otval_sale');      
    if ( parseInt(otval_sale.value) <= 0 ) 
    {
        alerta_error("error en cantidad que sale por pliego");
        return false;
    }



    var otval_cantidad_pedido = document.getElementById('otval_cantidad_pedido');      
    if ( parseInt(otval_cantidad_pedido.value) <= 0 ) 
    {
        alerta_error("falta la cantidad pedido");
        otval_cantidad_pedido.focus();
        otval_cantidad_pedido.select();
        return false;
    }
    

    var otval_pliegos = document.getElementById('otval_pliegos');      
    if ( parseInt(otval_pliegos.value) <= 0 ) 
    {
        alerta_error("falta numeros de pliegos");
        otval_pliegos.focus();
        otval_pliegos.select();
        return false;
    }
    

    var otval_descripcion = document.getElementById('otval_descripcion');       
    if ( (otval_descripcion.value).toString().trim().length == 0 ) 
    {
        alerta_error("error descripcion");
        otval_descripcion.focus();
        otval_descripcion.select();
        return false;
    }


    return true;
    
    
    
}

