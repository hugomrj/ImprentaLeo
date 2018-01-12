

function OrdenTrabajoValores_tabla_registro( tabla )
{
    var table = document.getElementById( tabla ).getElementsByTagName('tbody')[0];
    var rows = table.getElementsByTagName('tr');

    for (var i=0 ; i < rows.length; i++)
    {
        rows[i].onclick = function()
        {
                var id_transaccion = this.dataset.id_transaccion;   
                OrdenTrabajoValores_registro_Transaccion(id_transaccion);    
        };        
    }
    OrdenTrabajoValores_tabla_formato(tabla);

};



function  OrdenTrabajoValores_tabla_formato ( tabla ){
    

        var table = document.getElementById( tabla ).getElementsByTagName('tbody')[0];
        var rows = table.getElementsByTagName('tr');

        for (var i=0 ; i < rows.length; i++)
        {

            cell = table.rows[i].cells[0] ;                                  
            cell.innerHTML = fmtNum(cell.innerHTML); 

            cell = table.rows[i].cells[1] ;                                  
            cell.innerHTML = fmtNum(cell.innerHTML); 
            
            cell = table.rows[i].cells[5] ;                                  
            cell.innerHTML = fmtNum(cell.innerHTML);             
            
        }
        
    
}

