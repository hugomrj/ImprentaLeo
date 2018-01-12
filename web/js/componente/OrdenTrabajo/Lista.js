

var page = 1;





window.onload = function() {

    page = getParametroValor('page'); 

   AjaxPeticion('../MenuPrincipal','nav');   

   
   
   OrdenTrabajo_tabla_lista ( );
   
   /*


   // darle funcionalidad a buscar
    var buscar = document.getElementById('buscar');
    buscar.addEventListener('keyup',
        function(event) {

            if(event.keyCode == 13)
            {

                Documento_tabla_lista ( );

                OrdenTrabajo_tabla_lista ( );

            }
        },
        false
    );

   */

   
   
    
    var otl_agergar = document.getElementById('otl_agergar');
    otl_agergar.addEventListener('click',
        function(event) {
            location.href="../OrdenTrabajo/Transaccion/Inicio";
            //location.href="/OrdenTrabajo/Transaccion/Inicio";
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









function OrdenTrabajo_tabla_lista ( ){

    
            AjaxPeticion('../OrdenTrabajo/Coleccion/Lista?buscar='
                +document.getElementById('buscar').value  
                +"&page="+page
                ,'tab_body');          

    
            // paginacion                                
            var totalregistros = document.getElementById("ordentra_tabla").dataset.totalregistros;  
            AjaxPeticion('../Paginacion?page='+page+"&totalregistros="+totalregistros
                +""
                ,'div_paginacion');     
                
                
            paginacionajax ( "OrdenTrabajo_tabla_lista();"  );            
            OrdenTrabajo_tabla_registro ('ordentra_tabla' );
        
    
    

                /*
            // paginacion                                
            var totalregistros = document.getElementById("doc_tabla").dataset.totalregistros;  
            AjaxPeticion('../Paginacion?page='+page+"&totalregistros="+totalregistros
                +"&lineas=10"
                ,'div_paginacion');                     
            paginacionajax ( "Documento_tabla_lista();"  );
            */
            
            
               /* 
            Documento_sub_Registro( );
            Formato_documento_lista_tabla();                
    */
    
}




