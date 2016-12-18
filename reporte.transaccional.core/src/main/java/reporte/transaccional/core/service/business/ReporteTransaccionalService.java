/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reporte.transaccional.core.service.business;

import java.util.Date;
import reporte.transaccional.core.model.ReporteTransaccion;

/**
 *
 * @author MORREGO
 */
public interface ReporteTransaccionalService {

    /**
     *
     * @param tipoAjuste
     * @param estado
     * @param fechaIni
     * @param fechaFin
     * @return
     * @throws Exception
     */
    public ReporteTransaccion retrieveTransactionalReport(String tipoAjuste, String estado, Date fechaIni, Date fechaFin) throws Exception;

   /**
    * 
    * @param retrieveTransactionalReport
    * @return
    * @throws Exception 
    */
    public String retrieveDataUrlSheme(ReporteTransaccion retrieveTransactionalReport) throws Exception;

}
