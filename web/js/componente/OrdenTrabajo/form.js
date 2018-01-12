




function OrdenTrabajo_basicform (   )
{

    
    var ordent_orden_trabajo = document.getElementById( 'ordent_orden_trabajo');
    ordent_orden_trabajo.onblur  = function() {        
        ordent_orden_trabajo.value  = fmtNum(ordent_orden_trabajo.value);           
    };     
    ordent_orden_trabajo.onblur();

    
    
    var ordent_cliente = document.getElementById( 'ordent_cliente');
    ordent_cliente.onblur  = function() {        
        ordent_cliente.value  = fmtNum(ordent_cliente.value);           
        
        // llamr a jsom
        var idcliente = ordent_cliente.value;
        Cliente_busqueda_Json( idcliente );    
        
    };     
    ordent_cliente.onblur();


    var ordent_cliente_buscar = document.getElementById( 'ordent_cliente_buscar');
    ordent_cliente_buscar.addEventListener('click',
        function()
        {   
            VentanaModalBusqueda('3',  '../Cliente/jspf/busqueda.jspx', "Cliente", "ordent_cliente" , "clientes_tabla", 850 );                                        
        },
        false
    );    
      
      
    var ordent_cliente_agregar = document.getElementById( 'ordent_cliente_agregar');
    ordent_cliente_agregar.addEventListener('click',
        function()
        {          
            Cliente_modal_agregar( "ordent_cliente" );
        },
        false
    );    
      
      

}





function OrdenTrabajo_Json(id)
{
            
    var path = "../OrdenTrabajo/Linea.json?id="+id 
    var jsonResponse = AjaxUrl( path );    
   
    if (jsonResponse.toString().trim() != "[]")
    {        
        var json = JSON.parse(jsonResponse);    

        document.getElementById('ordent_orden_trabajo').value = VJson( json, "orden_trabajo","N");
        document.getElementById('ordent_cliente').value = VJson( json, "cliente","N");
        
        
        document.getElementById('ordent_fecha_recepcion').type = 'TEXT';
        document.getElementById('ordent_fecha_recepcion').value = VJson( json, "fecha_recepcion","D");
        
        document.getElementById('ordent_fecha_entrega').type = 'TEXT';
        document.getElementById('ordent_fecha_entrega').value = VJson( json, "fecha_entrega","D");
        
        if (json[0]['off_set'] == '1'){
            document.getElementById("chk_offset").checked = true;
        }        
        else{
            document.getElementById("chk_offset").checked = false;
        }
        
        
        if (json[0]['tipografica'] == '1'){
            document.getElementById("chk_tipografia").checked = true;
        }        
        else{
            document.getElementById("chk_tipografia").checked = false;
        }
        // 
        
    }  
    else    
    {        
        document.getElementById('ordent_orden_trabajo').value = 0;
        document.getElementById('ordent_cliente').value = 0;
        document.getElementById("chk_offset").checked = false;
        
        document.getElementById('ordent_fecha_recepcion').type = 'TEXT';
        document.getElementById('ordent_fecha_recepcion').value = "";        

        document.getElementById('ordent_fecha_entrega').type = 'TEXT';
        document.getElementById('ordent_fecha_entrega').value = "";

    }  
    
    
}





function OrdenTrabajo_form_disabled (   )
{
    
    document.getElementById( 'ordent_fecha_recepcion').disabled = true;
    document.getElementById( 'ordent_fecha_entrega').disabled = true;
    document.getElementById( 'ordent_cliente').disabled = true;
    
    document.getElementById( 'chk_offset').disabled = true;
    document.getElementById( 'chk_tipografia').disabled = true;
    
}

