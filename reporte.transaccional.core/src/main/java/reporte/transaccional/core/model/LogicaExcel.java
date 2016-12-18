/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reporte.transaccional.core.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import reporte.transaccional.model.Aprobacion;
import reporte.transaccional.model.DTBancoPopular;
import reporte.transaccional.model.DatosSolicitud;
import reporte.transaccional.model.DTCuentas;
import reporte.transaccional.model.DTPopularBank;

/**
 *
 * @author MORREGO
 */
public class LogicaExcel implements Serializable {

    private static final long serialVersionUID = 1L;

    private HSSFWorkbook libroReporte;
    private HSSFFont headerFont;
    private HSSFCellStyle headerStyle;
    private HSSFFont contentFont;
    private HSSFCellStyle oddRowStyle;

    private int rowIndex;

    /**
     *
     * @param datosReporte
     * @return
     */
    public HSSFWorkbook libroReporte(ReporteTransaccion datosReporte) {

        libroReporte = new HSSFWorkbook();

        headerFont = createFont(HSSFColor.BLACK.index, (short) 10, true);
        contentFont = createFont(HSSFColor.BLACK.index, (short) 9, false);

        headerStyle = createStyle(headerFont, HSSFCellStyle.ALIGN_CENTER, HSSFColor.WHITE.index, true, HSSFColor.BLACK.index);
        oddRowStyle = createStyle(contentFont, HSSFCellStyle.ALIGN_LEFT, HSSFColor.WHITE.index, true, HSSFColor.BLACK.index);

        if (null != datosReporte.getDatosSolicitud()) {
            hojaDTSolcitud(libroReporte, datosReporte.getDatosSolicitud());
        }

        if (null != datosReporte.getdTCuentas()) {
            hojaCuentas(libroReporte, datosReporte.getdTCuentas());
        }

        if (null != datosReporte.getdTBancoPopular()) {
            hojaDTBancoPopular(libroReporte, datosReporte.getdTBancoPopular());
        }

        if (null != datosReporte.getdTPopularBank()) {
            hojaDTPopularBank(libroReporte, datosReporte.getdTPopularBank());
        }

        if (null != datosReporte.getAprobacion()) {
            hojaAprobacion(libroReporte, datosReporte.getAprobacion());
        }

        return libroReporte;

    }

    /**
     *
     * @param libroReporte
     * @param datosSolicitud
     * @return
     */
    private HSSFSheet hojaDTSolcitud(HSSFWorkbook libroReporte, List<DatosSolicitud> datosSolicitud) {

        rowIndex = 0;

        HSSFSheet hojaDTSolcitud = libroReporte.createSheet("Datos Solicitud");

        HSSFRow tablaDTSolcitud = hojaDTSolcitud.createRow(rowIndex++);

        List<String> valoresTabla = new ArrayList<String>();
        valoresTabla.add("Dependencia");
        valoresTabla.add("Fecha Creación");
        valoresTabla.add("Tipo FTM");
        valoresTabla.add("Moneda");
        valoresTabla.add("Tasa EUR");
        valoresTabla.add("Tasa USD");
        valoresTabla.add("Id Solicitud");
        valoresTabla.add("Fecha Procesado");
        valoresTabla.add("Fecha Eefectividad");
        valoresTabla.add("Corporación");
        valoresTabla.add("Usuario TC Banco Popular");
        valoresTabla.add("No Lote");

        HSSFCell headerCell = null;

        for (int i = 0; i < valoresTabla.size(); i++) {
            headerCell = tablaDTSolcitud.createCell(i);
            headerCell.setCellStyle(headerStyle);
            headerCell.setCellValue(valoresTabla.get(i));
        }

        HSSFRow contenidoFila = null;
        HSSFCell contenidoCelda = null;

        List<List<String>> contenidoTotal = getTablaDTSolicitud(datosSolicitud);

        for (List<String> rowValues : contenidoTotal) {

            contenidoFila = hojaDTSolcitud.createRow(rowIndex++);
            for (int i = 0; i < rowValues.size(); i++) {
                contenidoCelda = contenidoFila.createCell(i);
                contenidoCelda.setCellValue(rowValues.get(i));
                contenidoCelda.setCellStyle(oddRowStyle);

            }

        }
        /*Autoisize*/
        for (int i = 0; i < valoresTabla.size(); hojaDTSolcitud.autoSizeColumn(i++));
        return hojaDTSolcitud;

    }

    /**
     *
     * @param libroReporte
     * @param cuentas
     * @return
     */
    private HSSFSheet hojaCuentas(HSSFWorkbook libroReporte, List<DTCuentas> cuentas) {

        rowIndex = 0;

        HSSFSheet hojaCuentas = libroReporte.createSheet("Detalle Transacciones - Cuentas");

        HSSFRow tablahojaCuentas = hojaCuentas.createRow(rowIndex++);

        List<String> valoresTabla = new ArrayList<String>();
        valoresTabla.add("Aplicación");
        valoresTabla.add("No Serie");
        valoresTabla.add("No Cuenta");
        valoresTabla.add("Cod Transacción");
        valoresTabla.add("Descripción");
        valoresTabla.add("Centro de Costo");
        valoresTabla.add("Débito");
        valoresTabla.add("Crédito");

        HSSFCell headerCell = null;

        for (int i = 0; i < valoresTabla.size(); i++) {
            headerCell = tablahojaCuentas.createCell(i);
            headerCell.setCellStyle(headerStyle);
            headerCell.setCellValue(valoresTabla.get(i));
        }

        HSSFRow contenidoFila = null;
        HSSFCell contenidoCelda = null;

        List<List<String>> contenidoTotal = getTablaDTCuentas(cuentas);

        for (List<String> rowValues : contenidoTotal) {

            contenidoFila = hojaCuentas.createRow(rowIndex++);
            for (int i = 0; i < rowValues.size(); i++) {
                contenidoCelda = contenidoFila.createCell(i);
                contenidoCelda.setCellValue(rowValues.get(i));
                contenidoCelda.setCellStyle(oddRowStyle);

            }

        }
        /*Autoisize*/
        for (int i = 0; i < valoresTabla.size(); hojaCuentas.autoSizeColumn(i++));
        return hojaCuentas;

    }

    /**
     *
     * @param libroReporte
     * @param dTBancoPopular
     * @return
     */
    private HSSFSheet hojaDTBancoPopular(HSSFWorkbook libroReporte, List<DTBancoPopular> dTBancoPopular) {

        rowIndex = 0;

        HSSFSheet hojaDTBancoPopular = libroReporte.createSheet("DT - TC Banco Popular");

        HSSFRow tablahojaDTBancoPopular = hojaDTBancoPopular.createRow(rowIndex++);

        List<String> valoresTabla = new ArrayList<String>();
        valoresTabla.add("No Batch");
        valoresTabla.add("No tarjeta");
        valoresTabla.add("Cod Transacción");
        valoresTabla.add("Descripción");
        valoresTabla.add("Débito");
        valoresTabla.add("Crédito");

        HSSFCell headerCell = null;

        for (int i = 0; i < valoresTabla.size(); i++) {
            headerCell = tablahojaDTBancoPopular.createCell(i);
            headerCell.setCellStyle(headerStyle);
            headerCell.setCellValue(valoresTabla.get(i));
        }

        HSSFRow contenidoFila = null;
        HSSFCell contenidoCelda = null;

        List<List<String>> contenidoTotal = getTablaDTBancoPopular(dTBancoPopular);

        for (List<String> rowValues : contenidoTotal) {

            contenidoFila = hojaDTBancoPopular.createRow(rowIndex++);
            for (int i = 0; i < rowValues.size(); i++) {
                contenidoCelda = contenidoFila.createCell(i);
                contenidoCelda.setCellValue(rowValues.get(i));
                contenidoCelda.setCellStyle(oddRowStyle);

            }

        }
        /*Autoisize*/
        for (int i = 0; i < valoresTabla.size(); hojaDTBancoPopular.autoSizeColumn(i++));
        return hojaDTBancoPopular;

    }

    /**
     *
     * @param libroReporte
     * @param dTPopularBank
     * @return
     */
    private HSSFSheet hojaDTPopularBank(HSSFWorkbook libroReporte, List<DTPopularBank> dTPopularBank) {

        rowIndex = 0;

        HSSFSheet hojaDTPopularBank = libroReporte.createSheet("DT - TC Popular Bank");

        HSSFRow tablahojaDTPopularBank = hojaDTPopularBank.createRow(rowIndex++);

        List<String> valoresTabla = new ArrayList<String>();
        valoresTabla.add("No tarjeta");
        valoresTabla.add("Cod Transacción");
        valoresTabla.add("Descripción");
        valoresTabla.add("No Cuentas en Dólares");
        valoresTabla.add("Débito");
        valoresTabla.add("Crédito");

        HSSFCell headerCell = null;

        for (int i = 0; i < valoresTabla.size(); i++) {
            headerCell = tablahojaDTPopularBank.createCell(i);
            headerCell.setCellStyle(headerStyle);
            headerCell.setCellValue(valoresTabla.get(i));
        }

        HSSFRow contenidoFila = null;
        HSSFCell contenidoCelda = null;

        List<List<String>> contenidoTotal = getTablaDTPopularBank(dTPopularBank);

        for (List<String> rowValues : contenidoTotal) {

            contenidoFila = hojaDTPopularBank.createRow(rowIndex++);
            for (int i = 0; i < rowValues.size(); i++) {
                contenidoCelda = contenidoFila.createCell(i);
                contenidoCelda.setCellValue(rowValues.get(i));
                contenidoCelda.setCellStyle(oddRowStyle);

            }

        }
        /*Autoisize*/
        for (int i = 0; i < valoresTabla.size(); hojaDTPopularBank.autoSizeColumn(i++));
        return hojaDTPopularBank;

    }

    /**
     *
     * @param libroReporte
     * @param aprobacion
     * @return
     */
    private HSSFSheet hojaAprobacion(HSSFWorkbook libroReporte, List<Aprobacion> aprobacion) {

        rowIndex = 0;

        HSSFSheet hojaAprobacion = libroReporte.createSheet("Aprobación");

        HSSFRow tablahojaAprobacion = hojaAprobacion.createRow(rowIndex++);

        List<String> valoresTabla = new ArrayList<String>();
        valoresTabla.add("Nivel de aprobación");
        valoresTabla.add("Estado Avanzar");
        valoresTabla.add("Creado");
        valoresTabla.add("Revisado");
        valoresTabla.add("Aprobado");
        valoresTabla.add("Posteo");

        HSSFCell headerCell = null;

        for (int i = 0; i < valoresTabla.size(); i++) {
            headerCell = tablahojaAprobacion.createCell(i);
            headerCell.setCellStyle(headerStyle);
            headerCell.setCellValue(valoresTabla.get(i));
        }

        HSSFRow contenidoFila = null;
        HSSFCell contenidoCelda = null;

        List<List<String>> contenidoTotal = getTablaAprobacion(aprobacion);

        for (List<String> rowValues : contenidoTotal) {

            contenidoFila = hojaAprobacion.createRow(rowIndex++);
            for (int i = 0; i < rowValues.size(); i++) {
                contenidoCelda = contenidoFila.createCell(i);
                contenidoCelda.setCellValue(rowValues.get(i));
                contenidoCelda.setCellStyle(oddRowStyle);

            }

        }
        /*Autoisize*/
        for (int i = 0; i < valoresTabla.size(); hojaAprobacion.autoSizeColumn(i++));
        return hojaAprobacion;

    }

    /**
     *
     * @param datosSolicitud
     * @return
     */
    private List<List<String>> getTablaDTSolicitud(List<DatosSolicitud> datosSolicitud) {

        List<List<String>> contenido = new ArrayList<List<String>>();
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        List<String> row = null;
        for (int i = 0; i < datosSolicitud.size(); i++) {
            contenido.add(row = new ArrayList<String>());
            row.add(objetToStrig(datosSolicitud.get(i).getDependencia()));
            row.add(objetToStrig(df.format(datosSolicitud.get(i).getFechaCreacion())));
            row.add(objetToStrig(datosSolicitud.get(i).getTipo_ftm()));
            row.add(objetToStrig(datosSolicitud.get(i).getMoneda()));
            row.add(objetToStrig(datosSolicitud.get(i).getTasaEUR()));
            row.add(objetToStrig(datosSolicitud.get(i).getTasaUSD()));
            row.add(objetToStrig(datosSolicitud.get(i).getId_ftm()));
            row.add(objetToStrig(df.format(datosSolicitud.get(i).getFechaProcesado())));
            row.add(objetToStrig(df.format(datosSolicitud.get(i).getFechaEfectivo())));
            row.add(objetToStrig(datosSolicitud.get(i).getCorporacion()));
            row.add(objetToStrig(datosSolicitud.get(i).getUsuariob2000()));
            row.add(objetToStrig(datosSolicitud.get(i).getNumLote()));

        }

        return contenido;

    }

    /**
     *
     * @param dtCuentas
     * @return
     */
    private List<List<String>> getTablaDTCuentas(List<DTCuentas> dtCuentas) {

        List<List<String>> contenido = new ArrayList<List<String>>();

        List<String> row = null;
        for (int i = 0; i < dtCuentas.size(); i++) {
            contenido.add(row = new ArrayList<String>());
            row.add(objetToStrig(dtCuentas.get(i).getAplicacion()));
            row.add(objetToStrig(dtCuentas.get(i).getNumSerie()));
            row.add(objetToStrig(dtCuentas.get(i).getNumCuenta()));
            row.add(objetToStrig(dtCuentas.get(i).getCodTransaccion()));
            row.add(objetToStrig(dtCuentas.get(i).getDescripcion()));
            row.add(objetToStrig(dtCuentas.get(i).getCentroCostos()));
            row.add(objetToStrig(dtCuentas.get(i).getMontoDebito()));
            row.add(objetToStrig(dtCuentas.get(i).getMontoCredito()));

        }

        return contenido;

    }

    /**
     *
     * @param dTBancoPopular
     * @return
     */
    private List<List<String>> getTablaDTBancoPopular(List<DTBancoPopular> dTBancoPopular) {

        List<List<String>> contenido = new ArrayList<List<String>>();

        List<String> row = null;
        for (int i = 0; i < dTBancoPopular.size(); i++) {
            contenido.add(row = new ArrayList<String>());
            row.add(objetToStrig(dTBancoPopular.get(i).getNumBatch()));
            row.add(objetToStrig(dTBancoPopular.get(i).getNumTarjeta()));
            row.add(objetToStrig(dTBancoPopular.get(i).getCodTransaccion()));
            row.add(objetToStrig(dTBancoPopular.get(i).getDescripcion()));
            row.add(objetToStrig(dTBancoPopular.get(i).getMontoDebito()));
            row.add(objetToStrig(dTBancoPopular.get(i).getMontoCredito()));

        }

        return contenido;

    }

    /**
     *
     * @param dTPopularBank
     * @return
     */
    private List<List<String>> getTablaDTPopularBank(List<DTPopularBank> dTPopularBank) {

        List<List<String>> contenido = new ArrayList<List<String>>();

        List<String> row = null;
        for (int i = 0; i < dTPopularBank.size(); i++) {
            contenido.add(row = new ArrayList<String>());
            row.add(objetToStrig(dTPopularBank.get(i).getNumTarjeta()));
            row.add(objetToStrig(dTPopularBank.get(i).getCodTrasaccion()));
            row.add(objetToStrig(dTPopularBank.get(i).getDescripcion()));
            row.add(objetToStrig(dTPopularBank.get(i).getNumCuentaDolares()));
            row.add(objetToStrig(dTPopularBank.get(i).getMontoDebito()));
            row.add(objetToStrig(dTPopularBank.get(i).getMontoCredito()));

        }

        return contenido;

    }

    /**
     *
     * @param aprobacion
     * @return
     */
    private List<List<String>> getTablaAprobacion(List<Aprobacion> aprobacion) {

        List<List<String>> contenido = new ArrayList<List<String>>();

        List<String> row = null;
        for (int i = 0; i < aprobacion.size(); i++) {
            contenido.add(row = new ArrayList<String>());
            row.add(objetToStrig(aprobacion.get(i).getNivelAprobacion()));
            row.add(objetToStrig(aprobacion.get(i).getEstadoAvanzar()));
            row.add(objetToStrig(aprobacion.get(i).getCreadoPor()));
            row.add(objetToStrig(aprobacion.get(i).getRevisadoPor()));
            row.add(objetToStrig(aprobacion.get(i).getAprobadoPor()));
            row.add(objetToStrig(aprobacion.get(i).getPosteadoPor()));

        }

        return contenido;

    }

    /**
     *
     * @param obj
     * @return
     */
    private String objetToStrig(Object obj) {

        if (obj == null) {
            return "";
        } else {
            return obj.toString();
        }

    }

    /**
     *
     * @param font
     * @param cellAlign
     * @param cellColor
     * @param cellBorder
     * @param cellBorderColor
     * @return
     */
    private HSSFCellStyle createStyle(HSSFFont font, short cellAlign, short cellColor, boolean cellBorder, short cellBorderColor) {

        HSSFCellStyle style = libroReporte.createCellStyle();
        style.setFont(font);
        style.setAlignment(cellAlign);
        style.setFillForegroundColor(cellColor);
        style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

        if (cellBorder) {
            style.setBorderTop(HSSFCellStyle.BORDER_THIN);
            style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
            style.setBorderRight(HSSFCellStyle.BORDER_THIN);
            style.setBorderBottom(HSSFCellStyle.BORDER_THIN);

            style.setTopBorderColor(cellBorderColor);
            style.setLeftBorderColor(cellBorderColor);
            style.setRightBorderColor(cellBorderColor);
            style.setBottomBorderColor(cellBorderColor);
        }

        return style;
    }

    /**
     *
     * @param fontColor
     * @param fontHeight
     * @param fontBold
     * @return
     */
    private HSSFFont createFont(short fontColor, short fontHeight, boolean fontBold) {

        HSSFFont font = libroReporte.createFont();
        font.setBold(fontBold);
        font.setColor(fontColor);
        font.setFontName("Arial");
        font.setFontHeightInPoints(fontHeight);

        return font;
    }

}
