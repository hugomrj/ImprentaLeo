/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package py.com.itx.aplicacion.ordentrabajovalores;


/**
 *
 * @author hugo
 */


public class OrdenTrabajoValores {
    
    
    private Integer id;
    private Integer orden;
    private Integer tam_ancho;
    private Integer tam_largo;
    private Float  corte_ancho;
    private Float  corte_largo;
    private String descripcion;
    private Integer pliegos;
    private Integer sale;
    private Integer cantidad_pedido;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    public Integer getTam_ancho() {
        return tam_ancho;
    }

    public void setTam_ancho(Integer tam_ancho) {
        this.tam_ancho = tam_ancho;
    }

    public Integer getTam_largo() {
        return tam_largo;
    }

    public void setTam_largo(Integer tam_largo) {
        this.tam_largo = tam_largo;
    }

    public Float getCorte_ancho() {
        return corte_ancho;
    }

    public void setCorte_ancho(Float corte_ancho) {
        this.corte_ancho = corte_ancho;
    }

    public Float getCorte_largo() {
        return corte_largo;
    }

    public void setCorte_largo(Float corte_largo) {
        this.corte_largo = corte_largo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getPliegos() {
        return pliegos;
    }

    public void setPliegos(Integer pliegos) {
        this.pliegos = pliegos;
    }

    public Integer getSale() {
        return sale;
    }

    public void setSale(Integer sale) {
        this.sale = sale;
    }

    public Integer getCantidad_pedido() {
        return cantidad_pedido;
    }

    public void setCantidad_pedido(Integer cantidad_pedido) {
        this.cantidad_pedido = cantidad_pedido;
    }
    
    
}
