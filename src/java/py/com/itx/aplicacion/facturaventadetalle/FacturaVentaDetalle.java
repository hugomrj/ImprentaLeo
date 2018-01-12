/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.itx.aplicacion.facturaventadetalle;

/**
 *
 * @author hugo
 */

public class FacturaVentaDetalle {
    
    private Integer factura_detalle;
    private Integer factura;
    private String descripcion;
    private Integer cantidad;
    private Long precio_unitario;    
    private Long sub_total;
    private Long porcentaje0;
    private Long porcentaje5;
    private Long porcentaje10;
    private Long impuesto;
    private Integer cantidad_hoja;
    

    public Integer getFactura_detalle() {
        return factura_detalle;
    }

    public void setFactura_detalle(Integer factura_detalle) {
        this.factura_detalle = factura_detalle;
    }

    public Integer getFactura() {
        return factura;
    }

    public void setFactura(Integer factura) {
        this.factura = factura;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Long getPorcentaje0() {
        return porcentaje0;
    }

    public void setPorcentaje0(Long porcentaje0) {
        this.porcentaje0 = porcentaje0;
    }

    public Long getPorcentaje5() {
        return porcentaje5;
    }

    public void setPorcentaje5(Long porcentaje5) {
        this.porcentaje5 = porcentaje5;
    }

    public Long getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(Long impuesto) {
        this.impuesto = impuesto;
    }

    public Integer getCantidad_hoja() {
        return cantidad_hoja;
    }

    public void setCantidad_hoja(Integer cantidad_hoja) {
        this.cantidad_hoja = cantidad_hoja;
    }

    public Long getPorcentaje10() {
        return porcentaje10;
    }

    public void setPorcentaje10(Long porcentaje10) {
        this.porcentaje10 = porcentaje10;
    }

    public Long getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(Long precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    public Long getSub_total() {
        return sub_total;
    }

    public void setSub_total(Long sub_total) {
        this.sub_total = sub_total;
    }
    
    
}


