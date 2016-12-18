/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reporte.transaccional.model;

import java.io.Serializable;

/**
 *
 * @author administrador
 */
public class Aprobacion implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nivelAprobacion;
    private String estadoAvanzar;
    private String creadoPor;
    private String revisadoPor;
    private String aprobadoPor;
    private String posteadoPor;

    public String getNivelAprobacion() {
        return nivelAprobacion;
    }

    public void setNivelAprobacion(String nivelAprobacion) {
        this.nivelAprobacion = nivelAprobacion;
    }

    public String getEstadoAvanzar() {
        return estadoAvanzar;
    }

    public void setEstadoAvanzar(String estadoAvanzar) {
        this.estadoAvanzar = estadoAvanzar;
    }

    public String getCreadoPor() {
        return creadoPor;
    }

    public void setCreadoPor(String creadoPor) {
        this.creadoPor = creadoPor;
    }

    public String getRevisadoPor() {
        return revisadoPor;
    }

    public void setRevisadoPor(String revisadoPor) {
        this.revisadoPor = revisadoPor;
    }

    public String getAprobadoPor() {
        return aprobadoPor;
    }

    public void setAprobadoPor(String aprobadoPor) {
        this.aprobadoPor = aprobadoPor;
    }

    public String getPosteadoPor() {
        return posteadoPor;
    }

    public void setPosteadoPor(String posteadoPor) {
        this.posteadoPor = posteadoPor;
    }

}
