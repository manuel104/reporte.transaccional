/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reporte.transaccional.core.service.business.impl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reporte.transaccional.core.service.business.ReporteTransaccionalService;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reporte.transaccional.core.model.LogicaExcel;
import reporte.transaccional.core.model.ReporteTransaccion;
import reporte.transaccional.core.model.TipoAjuste;
import reporte.transaccional.core.util.Base64Codec;
import reporte.transaccional.dao.ReporteTransaccionalDAO;
import reporte.transaccional.model.Aprobacion;
import reporte.transaccional.model.DTBancoPopular;
import reporte.transaccional.model.DTCuentas;
import reporte.transaccional.model.DTPopularBank;
import reporte.transaccional.model.DatosSolicitud;

/**
 *
 * @author MORREGO
 */
@Service
public class DefaultReporteTransaccionalService implements ReporteTransaccionalService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultReporteTransaccionalService.class);

    private LogicaExcel logicaExcel;
    private Base64Codec base64Codec;

    @Autowired
    private ReporteTransaccionalDAO reporteTransaccionalDAO;

    public DefaultReporteTransaccionalService() {

        logicaExcel = new LogicaExcel();

        base64Codec = new Base64Codec();

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
    @Override
    @Cacheable("transaccional")
    public ReporteTransaccion retrieveTransactionalReport(String tipoAjuste, String estado, Date fechaIni, Date fechaFin) throws Exception {

        List<DatosSolicitud> datosSolicitud = null;
        List<DTCuentas> dTCuentas = null;
        List<DTBancoPopular> dTBancoPopular = null;
        List<DTPopularBank> dTPopularBank = null;
        List<Aprobacion> aprobacion = null;

        ReporteTransaccion reporteTransaccion = new ReporteTransaccion();

        if (tipoAjuste != null || estado != null || fechaIni != null || fechaFin != null) {
            datosSolicitud = reporteTransaccionalDAO.getDatosSolicitud(tipoAjuste, estado, fechaIni, fechaFin);
            if (datosSolicitud != null) {
                reporteTransaccion.setDatosSolicitud(datosSolicitud);
            }
            aprobacion = reporteTransaccionalDAO.getAprobacion(tipoAjuste, estado, fechaIni, fechaFin);
            if (aprobacion != null) {
                reporteTransaccion.setAprobacion(aprobacion);
            }
            switch (TipoAjuste.getDTAjustes(tipoAjuste)) {
                case TC_Banco_Popular:

                    dTBancoPopular = reporteTransaccionalDAO.getDTBancoPopular(tipoAjuste, estado, fechaIni, fechaFin);
                    if (dTBancoPopular != null) {
                        reporteTransaccion.setdTBancoPopular(dTBancoPopular);
                    }
                    break;
                case TC_Popular_Bank:

                    dTPopularBank = reporteTransaccionalDAO.getDTDTPopularBank(tipoAjuste, estado, fechaIni, fechaFin);
                    if (dTPopularBank != null) {
                        reporteTransaccion.setdTPopularBank(dTPopularBank);
                    }
                    break;
                case Cuentas:

                    dTCuentas = reporteTransaccionalDAO.getDTCuentas(tipoAjuste, estado, fechaIni, fechaFin);
                    if (dTCuentas != null) {
                        reporteTransaccion.setdTCuentas(dTCuentas);
                    }
                    break;

                default:

                    LOGGER.info("No existe Tipo de Ajuste: " + tipoAjuste);

            }
        }

        return reporteTransaccion;
    }

    /**
     *
     * @param retrieveTransactionalReport
     * @return
     * @throws Exception
     */
    @Transactional
    @Override
    public String retrieveDataUrlSheme(ReporteTransaccion retrieveTransactionalReport) throws Exception {

        HSSFWorkbook libroReporteGenerado = null;

        libroReporteGenerado = logicaExcel.libroReporte(retrieveTransactionalReport);

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            libroReporteGenerado.write(byteArrayOutputStream);
            byteArrayOutputStream.flush();
            byteArrayOutputStream.close();
        } catch (IOException e) {

            System.err.println("Error");
            e.printStackTrace();
        }

        String encodeBase64String = base64Codec.encodeToString(byteArrayOutputStream.toByteArray(), true);

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("data:application/vnd.ms-excel;base64,")
                .append(encodeBase64String);

        return stringBuilder.toString();
    }


    /*Inicializar DAO's*/
    /**
     *
     * @return
     */
    public ReporteTransaccionalDAO getReporteTransaccionalDAO() {
        return reporteTransaccionalDAO;
    }

    /**
     *
     * @param reporteTransaccionalDAO
     */
    public void setReporteTransaccionalDAO(ReporteTransaccionalDAO reporteTransaccionalDAO) {
        this.reporteTransaccionalDAO = reporteTransaccionalDAO;
    }
}
