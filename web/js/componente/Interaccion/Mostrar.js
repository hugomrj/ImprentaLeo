

var modulo = 0;



window.onload = function() {



    modulo = getParametroValor("modulo");

   AjaxPeticion('../MenuPrincipal','nav');   
   
   
   
    AjaxPeticion('../Interaccion/Elemento/Modulo?modulo='+modulo,
        'ListaElementosModulo');      

};



