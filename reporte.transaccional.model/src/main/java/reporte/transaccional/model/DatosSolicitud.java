/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reporte.transaccional.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author MORREGO
 */
public class DatosSolicitud implements Serializable {

    private static final long serialVersionUID = 1L;

    private String dependencia;
    private Date fechaCreacion;
    private String tipo_ftm;
    private String moneda;
    private BigDecimal tasaEUR;
    private BigDecimal tasaUSD;
    private BigDecimal id_ftm;
    private Date fechaProcesado;
    private Date fechaEfectivo;
    private BigDecimal corporacion;
    private String usuariob2000;
    private String numLote;

    public String getDependencia() {
        return dependencia;
    }

    public void setDependencia(String dependencia) {
        this.dependencia = dependencia;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getTipo_ftm() {
        return tipo_ftm;
    }

    public void setTipo_ftm(String tipo_ftm) {
        this.tipo_ftm = tipo_ftm;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public BigDecimal getTasaEUR() {
        return tasaEUR;
    }

    public void setTasaEUR(BigDecimal tasaEUR) {
        this.tasaEUR = tasaEUR;
    }

    public BigDecimal getTasaUSD() {
        return tasaUSD;
    }

    public void setTasaUSD(BigDecimal tasaUSD) {
        this.tasaUSD = tasaUSD;
    }

    public BigDecimal getId_ftm() {
        return id_ftm;
    }

    public void setId_ftm(BigDecimal id_ftm) {
        this.id_ftm = id_ftm;
    }

    public Date getFechaProcesado() {
        return fechaProcesado;
    }

    public void setFechaProcesado(Date fechaProcesado) {
        this.fechaProcesado = fechaProcesado;
    }

    public Date getFechaEfectivo() {
        return fechaEfectivo;
    }

    public void setFechaEfectivo(Date fechaEfectivo) {
        this.fechaEfectivo = fechaEfectivo;
    }

    public BigDecimal getCorporacion() {
        return corporacion;
    }

    public void setCorporacion(BigDecimal corporacion) {
        this.corporacion = corporacion;
    }

    public String getUsuariob2000() {
        return usuariob2000;
    }

    public void setUsuariob2000(String usuariob2000) {
        this.usuariob2000 = usuariob2000;
    }

    public String getNumLote() {
        return numLote;
    }

    public void setNumLote(String numLote) {
        this.numLote = numLote;
    }
    
    

}
