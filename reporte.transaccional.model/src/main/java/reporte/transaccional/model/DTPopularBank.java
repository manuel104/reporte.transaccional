/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reporte.transaccional.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author administrador
 */
public class DTPopularBank implements Serializable {

    private static final long serialVersionUID = 1L;

    private String numTarjeta;
    private String codTrasaccion;
    private String descripcion;
    private BigDecimal numCuentaDolares;
    private BigDecimal montoDebito;
    private BigDecimal montoCredito;

    public String getNumTarjeta() {
        return numTarjeta;
    }

    public void setNumTarjeta(String numTarjeta) {
        this.numTarjeta = numTarjeta;
    }

    public String getCodTrasaccion() {
        return codTrasaccion;
    }

    public void setCodTrasaccion(String codTrasaccion) {
        this.codTrasaccion = codTrasaccion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getNumCuentaDolares() {
        return numCuentaDolares;
    }

    public void setNumCuentaDolares(BigDecimal numCuentaDolares) {
        this.numCuentaDolares = numCuentaDolares;
    }

    public BigDecimal getMontoDebito() {
        return montoDebito;
    }

    public void setMontoDebito(BigDecimal montoDebito) {
        this.montoDebito = montoDebito;
    }

    public BigDecimal getMontoCredito() {
        return montoCredito;
    }

    public void setMontoCredito(BigDecimal montoCredito) {
        this.montoCredito = montoCredito;
    }

}
