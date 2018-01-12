/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package py.com.itx.aplicacion.ordentrabajodetalle;

/**
 *
 * @author hugo
 */


public class OrdenTrabajoDetalle {
    
    
    private Integer id;
    private Integer cantidad;
    private Integer cantidad_hoja;
    private String descripcion;
    private Long precio_unitario;
    private Long sub_total;
    private Integer orden;
    private Long porcentaje0;
    private Long porcentaje5;
    private Long porcentaje10;
    private Integer impuesto;
    private Integer unidad;
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
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

    public Long getPorcentaje10() {
        return porcentaje10;
    }

    public void setPorcentaje10(Long porcentaje10) {
        this.porcentaje10 = porcentaje10;
    }


    public Integer getUnidad() {
        return unidad;
    }

    public void setUnidad(Integer unidad) {
        this.unidad = unidad;
    }

    public Integer getCantidad_hoja() {
        return cantidad_hoja;
    }

    public void setCantidad_hoja(Integer cantidad_hoja) {
        this.cantidad_hoja = cantidad_hoja;
    }

    public Integer getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(Integer impuesto) {
        this.impuesto = impuesto;
    }
    
    
    
}
