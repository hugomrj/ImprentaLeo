
var id = 0;
var id = getParametroValor("id");    

window.onload = function() {

    AjaxPeticion('../MenuPrincipal','nav');   
    
    Cliente_basicform_Json(id);    
    Cliente_basicform();


    var cli_cedula = document.getElementById('cli_cedula');
    cli_cedula.focus();
    cli_cedula.select();
    
    
    var clie_aceptar = document.getElementById('clie_aceptar');
    clie_aceptar.addEventListener('click',
        function()
        {
            var id = getParametroValor("id");    
            
            
            
            if (Clientes_AgregarEditar_validacion())
            {
                var form = document.getElementById("clie_form");            
                var accion =  form.getAttribute('action') ; 
                var control = AjaxPeticionURL( accion, getDataForm(form) );                

                if (!(isNaN(control)))
                {   
                   //alert("es numero");                        
                    window.location = "../Cliente/Registro.jspx?id="+control.toString().trim();                    
                }
                else
                {    
                    alerta_error(control);
                }
                
                
            }        
            
        },
        false
    );        

    
    
    
    
    
    
    
    var clie_cancelar = document.getElementById('clie_cancelar');
    clie_cancelar.addEventListener('click',
        function()
        {
            var id = getParametroValor("id");    
            window.location = "../Cliente/Registro.jspx?id="+id;
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


