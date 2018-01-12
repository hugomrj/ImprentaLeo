var id = getParametroValor("id");    

window.onload = function() {

    AjaxPeticion('../MenuPrincipal','nav');   
        
    Cliente_basicform_Json(id);    
    Cliente_basicform();
    Cliente_basicform_disabled();

    
    var clib_aceptar = document.getElementById('clib_aceptar');
    clib_aceptar.addEventListener('click',
        function() 
        {            
                
                var form = document.getElementById("clib_form");            
                var accion =  form.getAttribute('action') ; 
                
                var control = AjaxPeticionURL( accion, getDataForm(form) );                

                if (control.toString().trim() == "DeleteOK") {                       
                    window.location = "../Cliente/Lista.jspx";
                }
                else
                {    
                    alerta_error(control);
                }

        }, 
        false
    );  
        








    
    var clib_cancelar = document.getElementById('clib_cancelar');
    clib_cancelar.addEventListener('click',
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


