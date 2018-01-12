/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.itx.aplicacion.facturaventa;


import java.util.Date;
import py.com.itx.aplicacion.cliente.Cliente;

/**
 *
 * @author hugo
 */


public class FacturaVenta {
    
    private Integer factura;
    private Long numero_factura;
    private Date fecha_factura;
    private Cliente cliente;
    private Long gravada0 ;
    private Long gravada5 ;
    private Long gravada10 ;
    private Long iva5 ;
    private Long iva10 ;
    private Long total_iva ;
    private Long monto_total ;
    private Integer usuario ;
    private String forma_pago ;
    private Integer orden_trabajo ;

    public Integer getFactura() {
        return factura;
    }

    public void setFactura(Integer factura) {
        this.factura = factura;
    }

    public Long getNumero_factura() {
        return numero_factura;
    }

    public void setNumero_factura(Long numero_factura) {
        this.numero_factura = numero_factura;
    }

    public Date getFecha_factura() {
        return fecha_factura;
    }

    public void setFecha_factura(Date fecha_factura) {
        this.fecha_factura = fecha_factura;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Long getGravada0() {
        return gravada0;
    }

    public void setGravada0(Long gravada0) {
        this.gravada0 = gravada0;
    }

    public Long getGravada5() {
        return gravada5;
    }

    public void setGravada5(Long gravada5) {
        this.gravada5 = gravada5;
    }

    public Long getGravada10() {
        return gravada10;
    }

    public void setGravada10(Long gravada10) {
        this.gravada10 = gravada10;
    }

    public Long getIva5() {
        return iva5;
    }

    public void setIva5(Long iva5) {
        this.iva5 = iva5;
    }

    public Long getIva10() {
        return iva10;
    }

    public void setIva10(Long iva10) {
        this.iva10 = iva10;
    }

    public Long getMonto_total() {
        return monto_total;
    }

    public void setMonto_total(Long monto_total) {
        this.monto_total = monto_total;
    }

    public Integer getUsuario() {
        return usuario;
    }

    public void setUsuario(Integer usuario) {
        this.usuario = usuario;
    }

    public String getForma_pago() {
        return forma_pago;
    }

    public void setForma_pago(String forma_pago) {
        this.forma_pago = forma_pago;
    }

    public Integer getOrden_trabajo() {
        return orden_trabajo;
    }

    public void setOrden_trabajo(Integer orden_trabajo) {
        this.orden_trabajo = orden_trabajo;
    }

    public Long getTotal_iva() {
        return total_iva;
    }

    public void setTotal_iva(Long total_iva) {
        this.total_iva = total_iva;
    }
    
    
}


