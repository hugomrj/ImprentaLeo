





function OrdenTrabajoDetalle_basicform (   )
{

        
    var otdat_cantidad = document.getElementById('otdat_cantidad');
    
    var otdat_cantidad = document.getElementById( 'otdat_cantidad');
    otdat_cantidad.onblur  = function() {        
        otdat_cantidad.value  = fmtNum(otdat_cantidad.value);   
        calcular_subtotal();
    };     
    otdat_cantidad.onblur();


    var otdat_cantidad_hoja = document.getElementById( 'otdat_cantidad_hoja');
    otdat_cantidad_hoja.onblur  = function() {        
        otdat_cantidad_hoja.value  = fmtNum(otdat_cantidad_hoja.value);         
        calcular_subtotal();
    };     
    otdat_cantidad_hoja.onblur();

              
    var otdat_precio_unitario = document.getElementById( 'otdat_precio_unitario');
    otdat_precio_unitario.onblur  = function() {        
        otdat_precio_unitario.value  = fmtNum(otdat_precio_unitario.value);         
        calcular_subtotal();
    };     
    otdat_precio_unitario.onblur();


    

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





function OrdenTrabajoDetalle_basicform_Json(path)
{
  
    var jsonRestOTD = AjaxUrl( path );    
    
    if (jsonRestOTD.toString().trim() != "[]")
    {        
        var json = JSON.parse(jsonRestOTD);    
            
        var otdat_id = document.getElementById('otdat_id');       
        otdat_id.value =  (json[0].id);       
        
        var otdat_cantidad = document.getElementById('otdat_cantidad');       
        otdat_cantidad.value =  (json[0].cantidad);       
        
        var otdat_cantidad_hoja = document.getElementById('otdat_cantidad_hoja');       
        otdat_cantidad_hoja.value =  (json[0].cantidad_hoja);       
        
        var otdat_descripcion = document.getElementById('otdat_descripcion');       
        otdat_descripcion.value =  (json[0].descripcion);       

        var otdat_precio_unitario = document.getElementById('otdat_precio_unitario');       
        otdat_precio_unitario.value =  (json[0].precio_unitario);       
        
        var otdat_precio_unitario = document.getElementById('otdat_precio_unitario');       
        otdat_precio_unitario.value =  (json[0].precio_unitario);       
        
    }  
    
    OrdenTrabajoDetalle_basicform();

    
}





function OrdenTrabajoDetalle_agregarTransaccion_validacion (  ){



    var otdat_cantidad = document.getElementById('otdat_cantidad');      
    if ( parseInt(otdat_cantidad.value) <= 0 ) 
    {
        alerta_error("error cantidad");
        otdat_cantidad.focus();
        otdat_cantidad.select();
        return false;
    }

    
    var otdat_cantidad_hoja = document.getElementById('otdat_cantidad_hoja');      
    if ( parseInt(otdat_cantidad_hoja.value) <= 0 ) 
    {
        alerta_error("error cantidad hojas");
        otdat_cantidad_hoja.focus();
        otdat_cantidad_hoja.select();
        return false;
    }
    
        
    var otdat_descripcion = document.getElementById('otdat_descripcion');       
    if ( (otdat_descripcion.value).toString().trim().length == 0 ) 
    {
        alerta_error("error descripcion");
        otdat_descripcion.focus();
        otdat_descripcion.select();
        return false;
    }
        

    var otdat_precio_unitario = document.getElementById('otdat_precio_unitario');       
    if ( parseInt(otdat_precio_unitario.value) <= 0 ) 
    {
        alerta_error("error precio");
        otdat_precio_unitario.focus();
        otdat_precio_unitario.select();
        return false;
    }
            

    return true;
    
    
    
}

