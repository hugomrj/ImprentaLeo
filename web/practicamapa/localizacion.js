/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


class Localizacion {
    
    
    constructor(callback){
        
        if (navigator.geolocation){
            // obteeber ubicacion
            navigator.geolocation.getCurrentPosition((position) =>{
                
                this.latitude = position.coords.latidude;
                this.longitude = position.coords.longitude;
            })
            
            
        }
        else
        {
            alert("no soporta geolocalizacion");
        }
    }



}