/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reporte.transaccional.ws.business;

import java.util.Date;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reporte.transaccional.core.model.ReporteTransaccion;
import reporte.transaccional.core.service.business.ReporteTransaccionalService;

/**
 *
 * @author MORREGO
 */
@WebService(serviceName = "ReporteTransaccionalService", targetNamespace = "http://reporte.transaccional.ws")
public class ReporteTransaccionalWs {

    /**
     * The logger.
     */
    private static Logger LOGGER = LoggerFactory.getLogger(ReporteTransaccionalWs.class);

    private ReporteTransaccionalService reporteTransaccionalService;

    public ReporteTransaccionalWs(ReporteTransaccionalService reporteTransaccionalService) {
        this.reporteTransaccionalService = reporteTransaccionalService;
    }

    /**
     *
     * @param tipoAjuste
     * @param estado
     * @param fechaIni
     * @param fechaFin
     * @return
     * @throws Exception
     */
    @WebMethod(operationName = "retrieveTransactionalReport")
    @WebResult(name = "transactionalReport")
    public ReporteTransaccion retrieveTransactionalReport(@WebParam(name = "tipoAjuste") String tipoAjuste,
            @WebParam(name = "estado") String estado,
            @WebParam(name = "fechaIni") Date fechaIni,
            @WebParam(name = "fechaFin") Date fechaFin) throws Exception {

        ReporteTransaccion reporteTransaccion = null;
        try {

            reporteTransaccion = reporteTransaccionalService.retrieveTransactionalReport(tipoAjuste, estado, fechaIni, fechaFin);

        } catch (Exception e) {

            LOGGER.error(e.getMessage(), e);

        }
        return reporteTransaccion;

    }

    /**
     * 
     * @param tipoAjuste
     * @param estado
     * @param fechaIni
     * @param fechaFin
     * @return
     * @throws Exception 
     */
    @WebMethod(operationName = "retrieveDataUrlSheme")
    @WebResult(name = "dataUrlSheme")
    public String retrieveDataUrlSheme(@WebParam(name = "tipoAjuste") String tipoAjuste,
            @WebParam(name = "estado") String estado,
            @WebParam(name = "fechaIni") Date fechaIni,
            @WebParam(name = "fechaFin") Date fechaFin) throws Exception {

        String cadenaOut = null;
        try {

            ReporteTransaccion retrieveTransactionalReport = reporteTransaccionalService.retrieveTransactionalReport(tipoAjuste, estado, fechaIni, fechaFin);
            cadenaOut = reporteTransaccionalService.retrieveDataUrlSheme(retrieveTransactionalReport);

        } catch (Exception e) {

            LOGGER.error(e.getMessage(), e);

        }
        return cadenaOut;

    }
}
