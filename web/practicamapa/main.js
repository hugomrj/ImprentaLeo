/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


 


function initMap(){
    
    const ubicacion = new Localizacion(()=>{
        
        
            const options = {
                
                center: {
                    
                    lat : ubicacion.latitude,
                    lng: ubicacion.longitude
                },
                
                zoom: 15
            }
        
            var map = document.getElementById("map");
            
            const mapa = new google.maps.Map(map, options);
        
        
    })
    
    
}