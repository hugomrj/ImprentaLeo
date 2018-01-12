

window.onload = function() {

    AjaxPeticion( getRutaAbsoluta()+ '/MenuPrincipal','nav');   
          
    Cliente_basicform();
    
    var cli_cedula = document.getElementById( 'cli_cedula');
    cli_cedula.focus();
    cli_cedula.select();
    



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
                     window.location = "../Cliente/Registro.jspx?id="+control.toString().trim();        
                }
                else{                    
                    alerta_error(control);
                }
            }
        }, 
        false
    );  
    
    
    var clia_cancelar = document.getElementById('clia_cancelar');
    clia_cancelar.addEventListener('click',
        function()
        {
            window.location = "../Cliente/Lista.jspx";
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


