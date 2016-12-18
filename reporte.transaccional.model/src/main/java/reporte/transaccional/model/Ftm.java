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

public class Ftm implements Serializable {

    private static final long serialVersionUID = 1L;

    private BigDecimal id_ftm;
    private String aprobadopor;
    private BigDecimal corporacion;
    private String creadopor;
    private String dependencia;
    private String estado;
    private String estadoavanzar;
    private Date fechacreacion;
    private Date fechaefectivo;
    private Date fechaprocesado;
    private String historialejecuccion;
    private BigDecimal idinstanciabpm;
    private BigDecimal idsolicitud;
    private String instrelaciona;
    private String moneda;
    private String nivelaprovacion;
    private String numlote;
    private String posteadopor;
    private String razondevolucion;
    private String revisadopor;
    private BigDecimal tasaeur;
    private BigDecimal tasausd;
    private String tipoerror;
    private String tipo_ftm;
    private BigDecimal totalcredito;
    private BigDecimal totaldebito;
    private String usuariob2000;
/**
 * 
 * @return 
 */
    public BigDecimal getId_ftm() {
        return id_ftm;
    }
/**
 * 
 * @param id_ftm 
 */
    public void setId_ftm(BigDecimal id_ftm) {
        this.id_ftm = id_ftm;
    }
/**
 * 
 * @return 
 */
    public String getAprobadoPor() {
        return aprobadopor;
    }
/**
 * 
 * @param aprobadopor 
 */
    public void setAprobadoPor(String aprobadopor) {
        this.aprobadopor = aprobadopor;
    }
/**
 * 
 * @return 
 */
    public BigDecimal getCorporacion() {
        return corporacion;
    }
/**
 * 
 * @param corporacion 
 */
    public void setCorporacion(BigDecimal corporacion) {
        this.corporacion = corporacion;
    }
/**
 * 
 * @return 
 */
    public String getCreadoPor() {
        return creadopor;
    }
/**
 * 
 * @param creadopor 
 */
    public void setCreadoPor(String creadopor) {
        this.creadopor = creadopor;
    }
/**
 * 
 * @return 
 */
    public String getDependencia() {
        return dependencia;
    }
/**
 * 
 * @param dependencia 
 */
    public void setDependencia(String dependencia) {
        this.dependencia = dependencia;
    }
/**
 * 
 * @return 
 */
    public String getEstado() {
        return estado;
    }
/**
 * 
 * @param estado 
 */
    public void setEstado(String estado) {
        this.estado = estado;
    }
/**
 * 
 * @return 
 */
    public String getEstadoavanzar() {
        return estadoavanzar;
    }
/**
 * 
 * @param estadoavanzar 
 */
    public void setEstadoavanzar(String estadoavanzar) {
        this.estadoavanzar = estadoavanzar;
    }
/**
 * 
 * @return 
 */
    public Date getFechacreacion() {
        return fechacreacion;
    }
/**
 * 
 * @param fechacreacion 
 */
    public void setFechacreacion(Date fechacreacion) {
        this.fechacreacion = fechacreacion;
    }
/**
 * 
 * @return 
 */
    public Date getFechaefectivo() {
        return fechaefectivo;
    }
/**
 * 
 * @param fechaefectivo 
 */
    public void setFechaefectivo(Date fechaefectivo) {
        this.fechaefectivo = fechaefectivo;
    }
/**
 * 
 * @return 
 */
    public Date getFechaprocesado() {
        return fechaprocesado;
    }
/**
 * 
 * @param fechaprocesado 
 */
    public void setFechaprocesado(Date fechaprocesado) {
        this.fechaprocesado = fechaprocesado;
    }
/**
 * 
 * 
 * @return 
 */
    public String getHistorialejecuccion() {
        return historialejecuccion;
    }
/**
 * 
 * @param historialejecuccion 
 */
    public void setHistorialejecuccion(String historialejecuccion) {
        this.historialejecuccion = historialejecuccion;
    }
/**
 * 
 * @return 
 */
    public BigDecimal getIdinstanciabpm() {
        return idinstanciabpm;
    }
/**
 * 
 * @param idinstanciabpm 
 */
    public void setIdinstanciabpm(BigDecimal idinstanciabpm) {
        this.idinstanciabpm = idinstanciabpm;
    }
/**
 * 
 * @return 
 */
    public BigDecimal getIdsolicitud() {
        return idsolicitud;
    }
/**
 * 
 * @param idsolicitud 
 */
    public void setIdsolicitud(BigDecimal idsolicitud) {
        this.idsolicitud = idsolicitud;
    }
/**
 * 
 * @return 
 */
    public String getInstrelaciona() {
        return instrelaciona;
    }
/**
 * 
 * @param instrelaciona 
 */
    public void setInstrelaciona(String instrelaciona) {
        this.instrelaciona = instrelaciona;
    }
/**
 * 
 * @return 
 */
    public String getMoneda() {
        return moneda;
    }
/**
 * 
 * @param moneda 
 */
    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }
/**
 * 
 * @return 
 */
    public String getNivelaprovacion() {
        return nivelaprovacion;
    }
/**
 * 
 * @param nivelaprovacion 
 */
    public void setNivelaprovacion(String nivelaprovacion) {
        this.nivelaprovacion = nivelaprovacion;
    }
/**
 * 
 * @return 
 */
    public String getNumlote() {
        return numlote;
    }
/**
 * 
 * @param numlote 
 */
    public void setNumlote(String numlote) {
        this.numlote = numlote;
    }
/**
 * 
 * @return 
 */
    public String getPosteadopor() {
        return posteadopor;
    }
/**
 * 
 * @param posteadopor 
 */
    public void setPosteadopor(String posteadopor) {
        this.posteadopor = posteadopor;
    }
/**
 * 
 * @return 
 */
    public String getRazondevolucion() {
        return razondevolucion;
    }
/**
 * 
 * @param razondevolucion 
 */
    public void setRazondevolucion(String razondevolucion) {
        this.razondevolucion = razondevolucion;
    }
/**
 * 
 * @return 
 */
    public String getRevisadopor() {
        return revisadopor;
    }
/**
 * 
 * @param revisadopor 
 */
    public void setRevisadopor(String revisadopor) {
        this.revisadopor = revisadopor;
    }
/**
 * 
 * @return 
 */
    public BigDecimal getTasaeur() {
        return tasaeur;
    }
/**
 * 
 * @param tasaeur 
 */
    public void setTasaeur(BigDecimal tasaeur) {
        this.tasaeur = tasaeur;
    }
/**
 * 
 * @return 
 */
    public BigDecimal getTasausd() {
        return tasausd;
    }
/**
 * 
 * @param tasausd 
 */
    public void setTasausd(BigDecimal tasausd) {
        this.tasausd = tasausd;
    }
/**
 * 
 * @return 
 */
    public String getTipoerror() {
        return tipoerror;
    }
/**
 * 
 * @param tipoerror 
 */
    public void setTipoerror(String tipoerror) {
        this.tipoerror = tipoerror;
    }
/**
 * 
 * @return 
 */
    public String getTipo_ftm() {
        return tipo_ftm;
    }
/**
 * 
 * @param tipo_ftm 
 */
    public void setTipo_ftm(String tipo_ftm) {
        this.tipo_ftm = tipo_ftm;
    }
/**
 * 
 * @return 
 */
    public BigDecimal getTotalcredito() {
        return totalcredito;
    }
/**
 * 
 * @param totalcredito 
 */
    public void setTotalcredito(BigDecimal totalcredito) {
        this.totalcredito = totalcredito;
    }
/**
 * 
 * @return 
 */
    public BigDecimal getTotaldebito() {
        return totaldebito;
    }
/**
 * 
 * @param totaldebito 
 */
    public void setTotaldebito(BigDecimal totaldebito) {
        this.totaldebito = totaldebito;
    }
/**
 * 
 * @return 
 */
    public String getUsuariob2000() {
        return usuariob2000;
    }
/**
 * 
 * @param usuariob2000 
 */
    public void setUsuariob2000(String usuariob2000) {
        this.usuariob2000 = usuariob2000;
    }
    
    
    

}
