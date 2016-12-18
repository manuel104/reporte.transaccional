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
 * @author MORREGO
 */
public class DTBancoPopular implements Serializable {

    private static final long serialVersionUID = 1L;

    private BigDecimal numBatch;
    private String numTarjeta;
    private String CodTransaccion;
    private String descripcion;
    private BigDecimal montoDebito;
    private BigDecimal montoCredito;

    public BigDecimal getNumBatch() {
        return numBatch;
    }

    public void setNumBatch(BigDecimal numBatch) {
        this.numBatch = numBatch;
    }

    public String getNumTarjeta() {
        return numTarjeta;
    }

    public void setNumTarjeta(String numTarjeta) {
        this.numTarjeta = numTarjeta;
    }

    public String getCodTransaccion() {
        return CodTransaccion;
    }

    public void setCodTransaccion(String CodTransaccion) {
        this.CodTransaccion = CodTransaccion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
