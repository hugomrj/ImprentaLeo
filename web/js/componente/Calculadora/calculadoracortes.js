
var maximo_pliego = 0;

function Calculadora_cortes ( ){





        
        var maximo_pliego_valores = document.getElementById('planopliego');    
        maximo_pliego = maximo_pliego_valores.clientWidth;

    
            var calc_tam_ancho = document.getElementById('calc_tam_ancho');
            calc_tam_ancho.value = "100";
            calc_tam_ancho.onblur = function() {
                Generador_cortes();
                document.getElementById('original').checked = true;
            }
            
            
    
            var calc_tam_largo = document.getElementById('calc_tam_largo');
            calc_tam_largo.value = "100";
            calc_tam_largo.onblur = function() {
                Generador_cortes();
                document.getElementById('original').checked = true;
            }            
    
        
        
    
            var calc_corte_ancho = document.getElementById('calc_corte_ancho');
            calc_corte_ancho.onblur = function() {
                
                calc_corte_ancho.value  = validaFloat(calc_corte_ancho.value);                   
                Generador_cortes();
                
                document.getElementById('original').checked = true;
            }            
    
    
            var calc_corte_largo = document.getElementById('calc_corte_largo');
            calc_corte_largo.onblur = function() {
                
                calc_corte_largo.value  = validaFloat(calc_corte_largo.value);                                                   
                Generador_cortes();                                
                document.getElementById('original').checked = true;
                
                
            }            
        
    
            
            Generador_cortes();
            
            var original = document.getElementById('original');      
            original.addEventListener('click',
                function(event) {
                    original_inverfido();                    
                },
                false
            );                

            var invertido = document.getElementById('invertido');      
            invertido.addEventListener('click',
                function(event) {
                    original_inverfido();                    
                },
                false
            );                




            var calc_aceptar = document.getElementById('calc_aceptar');
            calc_aceptar.addEventListener('click',
                function(event) {

                    var calc_corte_ancho = document.getElementById('calc_corte_ancho');
                    var calc_corte_largo = document.getElementById('calc_corte_largo');
                    
                    if (( Number(calc_corte_ancho.value) <= 0 )  || ( Number(calc_corte_largo.value) <= 0 ))  {
                        return;
                    }                        

                    var calc_tam_ancho = document.getElementById('calc_tam_ancho');
                    var calc_tam_largo = document.getElementById('calc_tam_largo');
                    
                    if (( Number(calc_tam_ancho.value) <= 0 )  || ( Number(calc_tam_largo.value) <= 0 ))  {
                        return;
                    }                        


                    var otval_corte_ancho = document.getElementById('otval_corte_ancho');
                    otval_corte_ancho.value = calc_corte_ancho.value;

                    var otval_corte_largo = document.getElementById('otval_corte_largo');
                    otval_corte_largo.value = calc_corte_largo.value;                 
                 
                    var otval_tam_ancho = document.getElementById('otval_tam_ancho');
                    otval_tam_ancho.value = calc_tam_ancho.value;

                    var otval_tam_largo = document.getElementById('otval_tam_largo');
                    otval_tam_largo.value = calc_tam_largo.value;


                    var numeros_pliegos = document.getElementById('numeros_pliegos');
                    var otval_sale = document.getElementById('otval_sale');
                    otval_sale.value = numeros_pliegos.innerHTML;
                    
                    
                    // aca hay que hacer el calculo                    
                    var otval_cantidad_pedido = document.getElementById('otval_cantidad_pedido');
                    var otval_pliegos = document.getElementById('otval_pliegos');
                    var parte_entera = Math.trunc(otval_cantidad_pedido.value / otval_sale.value) ;
                    var parte_completa = (otval_cantidad_pedido.value / otval_sale.value) ;
                    
                    if (parte_completa > parte_entera){
                        otval_pliegos.value = parte_entera + 1;
                    }
                    else{
                        otval_pliegos.value = parte_entera ;
                    }
                    
                    
                    document.getElementById('otval_descripcion').focus();
                    document.getElementById('otval_descripcion').select();

                    VentanaModalCerrar("4");
            
                },
                false
            );    
    
    






    
            var calc_cerrar = document.getElementById('calc_cerrar');
            calc_cerrar.addEventListener('click',
                function(event) {
                    VentanaModalCerrar("4");
                },
                false
            );    
    
    

}





function Generador_cortes ( ){
    
   
    var corte_ancho = document.getElementById('calc_corte_ancho');    
    var corte_largo = document.getElementById('calc_corte_largo');    
    

    if ( Number(corte_ancho.value) <= 0 ){
        return;
    }

    if ( Number(corte_largo.value) <= 0 ){
        return;
    }

    
    var pliego_ancho = document.getElementById('calc_tam_ancho');    
    var pliego_largo = document.getElementById('calc_tam_largo');    
    var pliego_valores = document.getElementById('planopliego');    
    pliego_valores.clientWidth;
    pliego_valores.clientHeight;
    
    
    // si largo es ancho es mayor
    if ( Number(pliego_ancho.value) > Number(pliego_largo.value) ) {
                
        pliego_valores.style.width = maximo_pliego;                
        var porcentaj = (  pliego_largo.value * 100) / pliego_ancho.value;        
        pliego_valores.style.height = (maximo_pliego * porcentaj ) / 100 ;
                
    }
        
    
    if ( Number(pliego_ancho.value) < Number(pliego_largo.value) ) {

        pliego_valores.style.height = maximo_pliego;                
        var porcentaj = (  pliego_ancho.value * 100) / pliego_largo.value;        
        pliego_valores.style.width = (maximo_pliego * porcentaj ) / 100 ;        
        
    }


    if ( Number(pliego_ancho.value) == Number(pliego_largo.value) ) {
      pliego_valores.style.width = maximo_pliego;
      pliego_valores.style.height = maximo_pliego;
    }

    
        
    //eliminar todos los hijos de un div
    var element = document.getElementById("planopliego");
    while (element.firstChild) {
        element.removeChild(element.firstChild);
    }
    
    
    




    // obtener pixeles reales de cortes
    
    var corte_ancho_px = 0;        
    corte_ancho_px = ( corte_ancho.value * pliego_valores.clientWidth ) / pliego_ancho.value ;
    corte_ancho_px = corte_ancho_px -1 ;
    
    
    
    var corte_largo_px = 0;        
    corte_largo_px = ( corte_largo.value * pliego_valores.clientHeight ) / pliego_largo.value ;
    corte_largo_px = corte_largo_px -1 ;
    
    
    var minimopx = 0;
    minimopx = corte_ancho_px;
    if (corte_ancho_px > corte_largo_px){
        minimopx = corte_largo_px;
    }
    minimopx = minimopx /2;
    
    var pliego_ancho_resto = 0;
    var pliego_largo_resto = 0;
    var corte_left = -1;
    var corte_top = -1;
    
    // inicio 
    var contador = 0;
    
    
    //pliego_ancho_resto = Number(pliego_ancho.value);
    pliego_largo_resto = Number(pliego_largo.value);

        var corte_top = 0;
        while ( pliego_largo_resto >= Number(corte_largo.value) ) {
            
            var corte_left = 0;
            pliego_ancho_resto = Number(pliego_ancho.value);
            while ( pliego_ancho_resto >= Number(corte_ancho.value)   ) {

                    var divC = document.createElement('div');    
                    divC.className = "corte";    
                    divC.style.width = corte_ancho_px;
                    divC.style.height = corte_largo_px;

                    divC.style.left = corte_left;
                    divC.style.top = corte_top;
                           
                    corte_left = corte_left +corte_ancho_px;
                    corte_left = corte_left + 1;
                    
                    contador ++;
                    divC.innerHTML=  '<p style="font-size: ' + (minimopx) + 'px; ">' + contador + '</p>' ;
                    planopliego.appendChild(divC);        

                    pliego_ancho_resto = pliego_ancho_resto - Number(corte_ancho.value) ;   
            }    
            
            corte_top = corte_top + corte_largo_px;
            corte_top = corte_top + 1;
            
            pliego_largo_resto = pliego_largo_resto - Number(corte_largo.value) ;   
            
        }


        // si sobra de ancho

        if ( pliego_ancho_resto >= Number(corte_largo.value) )
        {            

            while ( pliego_ancho_resto >=  Number(corte_largo.value) ) {            

                var corte_top = 0;
                pliego_largo_resto = Number(pliego_largo.value);            
                while ( pliego_largo_resto >= Number(corte_ancho.value)   ) {

                        var divC = document.createElement('div');    
                        divC.className = "corte";    

                        divC.style.width = corte_largo_px;
                        divC.style.height = corte_ancho_px;

                        divC.style.left = corte_left;
                        divC.style.top = corte_top;

                        corte_top = corte_top + corte_ancho_px;
                        corte_top = corte_top +1 

                        contador ++;
                        divC.innerHTML=  '<p style="font-size: ' + (minimopx) + 'px; ">' + contador + '</p>' ;
                        planopliego.appendChild(divC);        

                        pliego_largo_resto = pliego_largo_resto - Number(corte_ancho.value) ;   
                }                          

                corte_left = corte_left + corte_largo_px;
                corte_left = corte_left + 1;
            
                pliego_ancho_resto = pliego_ancho_resto - Number(corte_largo.value) ;   
        
            }
        }

     
     
     
        // si sobra de largo

        if ( pliego_largo_resto >= Number(corte_ancho.value) )
        {            

            while ( pliego_largo_resto >=  Number(corte_ancho.value) ) {            
                
                pliego_ancho_resto = Number(pliego_ancho.value);     
                
                var corte_left = 0;    
                while ( pliego_ancho_resto >= Number(corte_largo.value)   ) {

                        var divC = document.createElement('div');    
                        divC.className = "corte";    

                        divC.style.width = corte_largo_px;
                        divC.style.height = corte_ancho_px;

                        divC.style.left = corte_left;
                        divC.style.top = corte_top;
                        
                        corte_left = corte_left + corte_largo_px;
                        corte_left = corte_left + 1;                        

                        contador ++;
                        divC.innerHTML=  '<p style="font-size: ' + (minimopx) + 'px; ">' + contador + '</p>' ;
                        planopliego.appendChild(divC);        

                        pliego_ancho_resto = pliego_ancho_resto - Number(corte_largo.value) ;   
                }                          

                corte_top = corte_top + corte_ancho_px;
                corte_top = corte_top +1 

                pliego_largo_resto = pliego_largo_resto - Number(corte_ancho.value) ;   

            }
        }
     
     
     
     // etiquetas
     
     
         var numeros_pliegos = document.getElementById("numeros_pliegos");
         numeros_pliegos.innerHTML = contador;
     
        var papelutilizado = document.getElementById("papelutilizado");
        papelutilizado.innerHTML =  parseFloat(
                        (100 * ( corte_ancho.value * corte_largo.value ) * contador ) / 
                        (pliego_ancho.value * pliego_largo.value) 
                    ).toFixed(2) ;
     
        var desperdiciado = document.getElementById("desperdiciado");
        desperdiciado.innerHTML = parseFloat( 100 - papelutilizado.innerHTML  ).toFixed(2)
          
    // verficar si sobra espacio para seguir cortando

    //alert(pliego_largo_resto);

    
}


function original_inverfido ( ){    
    
    
    var c_ancho = document.getElementById("calc_corte_ancho").value;
    var c_largo = document.getElementById("calc_corte_largo").value;
        
    document.getElementById("calc_corte_ancho").value = c_largo;
    document.getElementById("calc_corte_largo").value = c_ancho;
        
    Generador_cortes();    
    
    
}






function CalculadoraDeCortes ( ){    
    
    var irCalculadora = document.getElementById('irCalculadora');   
    irCalculadora.addEventListener('click',
        function()
        {            
            VentanaModal("4",  '../Calculadora/jspf/cortes.jspx', 900 );            
            Calculadora_cortes();           
            
            document.getElementById('calc_tam_ancho').focus();
            document.getElementById('calc_tam_ancho').select();            
        },
        false
    );
    
    

    
    
}






















