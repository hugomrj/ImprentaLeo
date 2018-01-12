



function Cliente_basicform (   )
{
    
    var cli_cedula = document.getElementById( 'cli_cedula');    
    cli_cedula.onblur  = function() {        
        cli_cedula.value  = fmtNum(cli_cedula.value);                 
    };     
    cli_cedula.onblur();
    
    //cli_cedula.focus();
    //cli_cedula.select();

}






function Cliente_basicform_Json(id)
{  
    var path = "../Cliente/Linea.json?id="+id 
    var jsonResponse = AjaxUrl( path );    
    
    if (jsonResponse.toString().trim() != "[]")
    {        
        var json = JSON.parse(jsonResponse);  

        document.getElementById('cli_cliente').value = VJson( json, "cliente", "N");
        document.getElementById('cli_cedula').value = VJson( json, "cedula", "N");
        document.getElementById('cli_nombre').value = VJson( json, "nombre");
        document.getElementById('cli_apellido').value = VJson( json, "apellido");
        document.getElementById('cli_email').value = VJson( json, "email");
        document.getElementById('cli_direccion').value = VJson( json, "direccion");
        document.getElementById('cli_ciudad').value = VJson( json, "ciudad");
        document.getElementById('cli_telefono').value = VJson( json, "telefono");
        document.getElementById('cli_ruc').value = VJson( json, "ruc");
       
    }
    else
    {        
        var json = JSON.parse(jsonResponse);  

        document.getElementById('cli_cliente').value = "0";
        document.getElementById('cli_cedula').value = "0";
        document.getElementById('cli_nombre').value = "";
        document.getElementById('cli_apellido').value = "";
        document.getElementById('cli_email').value = "";
        document.getElementById('cli_direccion').value = "";
        document.getElementById('cli_ciudad').value = "";
        document.getElementById('cli_telefono').value = "";
        document.getElementById('cli_ruc').value = "";
       
    }        
    
}



function Cliente_busqueda_Json(id)
{
            
    var path = "../Cliente/Linea.json?id="+id 
    var jsonResponse = AjaxUrl( path );    
   
    if (jsonResponse.toString().trim() != "[]")
    {        
        var json = JSON.parse(jsonResponse);    

        document.getElementById('ordent_cliente').value = VJson( json, "cliente","N");
        document.getElementById('vicClienteDescripcion').value = 
                VJson( json, "nombre") +" " +VJson( json, "apellido") ;        

        document.getElementById('vicRuc').value = VJson( json, "ruc"); 
        document.getElementById('vicTel').value = VJson( json, "telefono"); 
        document.getElementById('vidDireccion').value = VJson( json, "direccion"); 
        document.getElementById('vicCiudad').value = VJson( json, "ciudad"); 
        
  
    }  
    else    
    {        
        document.getElementById('ordent_cliente').value = 0;
        document.getElementById('vicClienteDescripcion').value = "";
        document.getElementById('vicRuc').value = "";
        document.getElementById('vicTel').value = "";
        document.getElementById('vidDireccion').value = "";
        document.getElementById('vicCiudad').value = "";
    }  
    
    
}






function Clientes_AgregarEditar_validacion (  ){


    var cli_cedula = document.getElementById('cli_cedula');      
    if ( parseInt(cli_cedula.value) <= 0 ) 
    {
        alerta_error("error en cedula");
        cli_cedula.focus();
        cli_cedula.select();
        return false;
    }

    return true;
    
}






function Cliente_basicform_disabled (   )
{
    
    document.getElementById( 'cli_cedula').disabled = true;
    document.getElementById( 'cli_nombre').disabled = true;
    document.getElementById( 'cli_apellido').disabled = true;
    document.getElementById( 'cli_email').disabled = true;
    document.getElementById( 'cli_direccion').disabled = true;
    document.getElementById( 'cli_ciudad').disabled = true;
    document.getElementById( 'cli_telefono').disabled = true;
    document.getElementById( 'cli_ruc').disabled = true;

}






function Cliente_modal_agregar ( dom )
{
    
    VentanaModal("4",  '../Cliente/jspf/agregarCliente.jspx', 800 );        
    Cliente_basicform();
    

    var clia_guardar = document.getElementById('clia_guardar');
    clia_guardar.addEventListener('click',
        function() 
        {
                      
            if (Clientes_AgregarEditar_validacion())
            {
                var form = document.getElementById("clia_form");            
                var accion =  form.getAttribute('action') ; 
                var control = AjaxPeticionURL( accion, getDataForm(form) );                

                if (!(isNaN(control))){                                          
                     //window.location = "../Cliente/Registro.jspx?id="+control.toString().trim();     
                     
                    linea_id = control;    
                    asignarValor(  dom , linea_id );
                    document.getElementById( dom ).onblur();  
                    clia_cerrar.click();

                     
                }
                else{                    
                    alerta_error(control);
                }
            }
        }, 
        false
    );  
    




    var clia_cerrar = document.getElementById('clia_cerrar');   
    clia_cerrar.addEventListener('click',
        function()
        {
            VentanaModalCerrar("4");
        },
        false
    );



}
