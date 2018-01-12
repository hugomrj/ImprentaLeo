/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.itx.aplicacion.ordentrabajo;

import java.util.Date;

/**
 *
 * @author hugo
 */


public class OrdenTrabajo {
    
    private Integer orden_trabajo;
    private Date fecha_recepcion;
    private Date fecha_entrega;
    private Integer cliente;
    private Integer off_set;
    private Integer tipografica;
    private Integer factura;

    public Integer getOrden_trabajo() {
        return orden_trabajo;
    }

    public void setOrden_trabajo(Integer orden_trabajo) {
        this.orden_trabajo = orden_trabajo;
    }

    public Date getFecha_recepcion() {
        return fecha_recepcion;
    }

    public void setFecha_recepcion(Date fecha_recepcion) {
        this.fecha_recepcion = fecha_recepcion;
    }

    public Date getFecha_entrega() {
        return fecha_entrega;
    }

    public void setFecha_entrega(Date fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }

    public Integer getCliente() {
        return cliente;
    }

    public void setCliente(Integer cliente) {
        this.cliente = cliente;
    }

    public Integer getOff_set() {
        return off_set;
    }

    public void setOff_set(Integer off_set) {
        this.off_set = off_set;
    }

    public Integer getTipografica() {
        return tipografica;
    }

    public void setTipografica(Integer tipografica) {
        this.tipografica = tipografica;
    }

    public Integer getFactura() {
        return factura;
    }

    public void setFactura(Integer factura) {
        this.factura = factura;
    }
    
    
}



