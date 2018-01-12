


function Usuario_ListaSimple ( elementoRetorno )
{

    var seleccionar_registro = function(  )
    {
        var tabla_qry = document.getElementById('tabla_qry_usuarios').getElementsByTagName('tbody')[0];
        var regs = tabla_qry.getElementsByTagName('tr');


        for (var i=0 ; i < regs.length; i++)
        {
           
            regs[i].addEventListener ( 'click',
                function() {

                    registroid = this.dataset.registro_id;    
                    
//alert(registroid);
                    
                    asignarValor( elementoRetorno, registroid );

                    document.getElementById(elementoRetorno).onblur();  

                    ocultarVentana('capa_oscura_segunda');
                    ocultarVentana('capa_clara_segunda');
                                
                },
                false
            );

        }

    };


    var busqueda_cerrar = function( )
    {

        var cerrar_busqueda = document.getElementById('cerrar_usuario_listasimple');
        cerrar_busqueda.addEventListener('click',
            function()
            {
                ocultarVentana('capa_oscura_segunda');
                ocultarVentana('capa_clara_segunda');
            },
            false
        );
    };


    AjaxPeticion('../Usuario/Coleccion/ListaSimple','capa_clara_segunda');    
    seleccionar_registro(  );
    busqueda_cerrar();

}



function valor_json_usuario ( elementoRetorno, valorcodigo )
{
        
        var descripcion = document.getElementById(elementoRetorno);        
        var jsonResponse = AjaxUrl( "../Usuario/Linea.json?idregistro="+valorcodigo.value );  
        
        if (jsonResponse.toString().trim() != "[]")
        {
            var objetoJson = JSON.parse(jsonResponse);                
            descripcion.innerHTML = objetoJson[0].cuenta ;
        }
        else
        {

            descripcion.innerHTML = "" ;
        }

        
}    