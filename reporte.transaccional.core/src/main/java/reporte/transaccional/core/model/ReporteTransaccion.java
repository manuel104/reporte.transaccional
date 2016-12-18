/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reporte.transaccional.core.model;

import java.io.Serializable;
import java.util.List;
import reporte.transaccional.model.Aprobacion;
import reporte.transaccional.model.DTBancoPopular;
import reporte.transaccional.model.DTCuentas;
import reporte.transaccional.model.DTPopularBank;
import reporte.transaccional.model.DatosSolicitud;

/**
 *
 * @author MORREGO
 */
public class ReporteTransaccion implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<DatosSolicitud> datosSolicitud;
    private List<DTCuentas> dTCuentas;
    private List<DTBancoPopular> dTBancoPopular;
    private List<DTPopularBank> dTPopularBank;
    private List<Aprobacion> aprobacion;

    public List<DatosSolicitud> getDatosSolicitud() {
        return datosSolicitud;
    }

    public void setDatosSolicitud(List<DatosSolicitud> datosSolicitud) {
        this.datosSolicitud = datosSolicitud;
    }

    public List<DTCuentas> getdTCuentas() {
        return dTCuentas;
    }

    public void setdTCuentas(List<DTCuentas> dTCuentas) {
        this.dTCuentas = dTCuentas;
    }

    public List<DTBancoPopular> getdTBancoPopular() {
        return dTBancoPopular;
    }

    public void setdTBancoPopular(List<DTBancoPopular> dTBancoPopular) {
        this.dTBancoPopular = dTBancoPopular;
    }

    public List<DTPopularBank> getdTPopularBank() {
        return dTPopularBank;
    }

    public void setdTPopularBank(List<DTPopularBank> dTPopularBank) {
        this.dTPopularBank = dTPopularBank;
    }

    public List<Aprobacion> getAprobacion() {
        return aprobacion;
    }

    public void setAprobacion(List<Aprobacion> aprobacion) {
        this.aprobacion = aprobacion;
    }

}
