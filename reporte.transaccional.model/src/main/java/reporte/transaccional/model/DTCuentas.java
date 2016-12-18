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
public class DTCuentas implements Serializable {
    
    private static final long serialVersionUID = 1L;
     
  private BigDecimal aplicacion;
  private BigDecimal numSerie;
  private BigDecimal NumCuenta;
  private String codTransaccion;
  private String descripcion;
  private BigDecimal centroCostos;
  private BigDecimal montoDebito;
  private BigDecimal montoCredito;

    public BigDecimal getAplicacion() {
        return aplicacion;
    }

    public void setAplicacion(BigDecimal aplicacion) {
        this.aplicacion = aplicacion;
    }

    public BigDecimal getNumSerie() {
        return numSerie;
    }

    public void setNumSerie(BigDecimal numSerie) {
        this.numSerie = numSerie;
    }

    public BigDecimal getNumCuenta() {
        return NumCuenta;
    }

    public void setNumCuenta(BigDecimal NumCuenta) {
        this.NumCuenta = NumCuenta;
    }

    public String getCodTransaccion() {
        return codTransaccion;
    }

    public void setCodTransaccion(String codTransaccion) {
        this.codTransaccion = codTransaccion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getCentroCostos() {
        return centroCostos;
    }

    public void setCentroCostos(BigDecimal centroCostos) {
        this.centroCostos = centroCostos;
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
