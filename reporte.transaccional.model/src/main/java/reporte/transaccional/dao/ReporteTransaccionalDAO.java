/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reporte.transaccional.dao;

import java.sql.Types;
import java.util.List;
import java.util.Date;
import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import reporte.transaccional.model.Aprobacion;
import reporte.transaccional.model.DTBancoPopular;
import reporte.transaccional.model.DTCuentas;
import reporte.transaccional.model.DTPopularBank;
import reporte.transaccional.model.DatosSolicitud;

/**
 *
 * @author MORREGO
 */
@Repository
public class ReporteTransaccionalDAO {

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    /**
     *
     * @param tipoAjuste
     * @param estado
     * @param fechaIni
     * @param fechaFin
     * @return
     */
    public List<DatosSolicitud> getDatosSolicitud(String tipoAjuste, String estado, Date fechaIni, Date fechaFin) {

        String query = "SELECT FTM.DEPENDENCIA, FTM.FECHACREACION, FTM.TIPO_FTM, FTM.MONEDA, FTM.TASAEUR, FTM.TASAUSD, FTM.ID_FTM, FTM.FECHAPROCESADO, FTM.FECHAEFECTIVO, FTM.CORPORACION, FTM.USUARIOB2000, FTM.NUMLOTE FROM FTM ";
        query += " WHERE TRIM(' ' FROM FTM.TIPO_FTM) = :tipoAjuste AND FTM.estado = :estado ";
        query += "AND FTM.FECHACREACION BETWEEN :fechaIni AND :fechaFin";

        MapSqlParameterSource namedParameters = new MapSqlParameterSource();

        namedParameters.addValue("tipoAjuste", tipoAjuste, Types.VARCHAR);
        namedParameters.addValue("estado", estado, Types.VARCHAR);
        namedParameters.addValue("fechaIni", fechaIni);
        namedParameters.addValue("fechaFin", fechaFin);

        List<DatosSolicitud> listDatosSolicitud = namedParameterJdbcTemplate.query(query, namedParameters, new BeanPropertyRowMapper<DatosSolicitud>(DatosSolicitud.class));

        return listDatosSolicitud;

    }

    /**
     *
     * @param tipoAjuste
     * @param estado
     * @param fechaIni
     * @param fechaFin
     * @return
     */
    public List<DTCuentas> getDTCuentas(String tipoAjuste, String estado, Date fechaIni, Date fechaFin) {

        String query = "SELECT TRA.APLICACION, TRA.NUMSERIE, TRA.NUMCUENTA, TRA.CODTRANSACCION, TRA.DESCRIPCION, TRA.CENTROCOSTOS, TRA.MONTODEBITO, TRA.MONTOCREDITO FROM FTM ";
        query += "INNER JOIN TRANSACCION TRA ON FTM.ID_FTM = TRA.ID_FTM";
        query += " WHERE TRIM(' ' FROM FTM.TIPO_FTM) = :tipoAjuste AND FTM.estado = :estado ";
        query += "AND FTM.FECHACREACION BETWEEN :fechaIni AND :fechaFin";

        MapSqlParameterSource namedParameters = new MapSqlParameterSource();

        namedParameters.addValue("tipoAjuste", tipoAjuste, Types.VARCHAR);
        namedParameters.addValue("estado", estado, Types.VARCHAR);
        namedParameters.addValue("fechaIni", fechaIni);
        namedParameters.addValue("fechaFin", fechaFin);

        List<DTCuentas> listDTCuentas = namedParameterJdbcTemplate.query(query, namedParameters, new BeanPropertyRowMapper<DTCuentas>(DTCuentas.class));

        return listDTCuentas;

    }

    /**
     *
     * @param tipoAjuste
     * @param estado
     * @param fechaIni
     * @param fechaFin
     * @return
     */
    public List<DTBancoPopular> getDTBancoPopular(String tipoAjuste, String estado, Date fechaIni, Date fechaFin) {

        String query = "SELECT TRA.NUMBATCH, TRA.NUMTARJETA, TRA.CODTRANSACCION, TRA.DESCRIPCION, TRA.MONTODEBITO, TRA.MONTOCREDITO FROM FTM ";
        query += "INNER JOIN TRANSACCION TRA ON FTM.ID_FTM = TRA.ID_FTM";
        query += " WHERE TRIM(' ' FROM FTM.TIPO_FTM) = :tipoAjuste AND FTM.estado = :estado ";
        query += "AND FTM.FECHACREACION BETWEEN :fechaIni AND :fechaFin";

        MapSqlParameterSource namedParameters = new MapSqlParameterSource();

        namedParameters.addValue("tipoAjuste", tipoAjuste, Types.VARCHAR);
        namedParameters.addValue("estado", estado, Types.VARCHAR);
        namedParameters.addValue("fechaIni", fechaIni);
        namedParameters.addValue("fechaFin", fechaFin);

        List<DTBancoPopular> listDTBancoPopular = namedParameterJdbcTemplate.query(query, namedParameters, new BeanPropertyRowMapper<DTBancoPopular>(DTBancoPopular.class));

        return listDTBancoPopular;

    }

    /**
     *
     * @param tipoAjuste
     * @param estado
     * @param fechaIni
     * @param fechaFin
     * @return
     */
    public List<DTPopularBank> getDTDTPopularBank(String tipoAjuste, String estado, Date fechaIni, Date fechaFin) {

        String query = "SELECT TRA.NUMTARJETA, TRA.CODTRANSACCION, TRA.DESCRIPCION, TRA.NUMCUENTADOLARES, TRA.MONTODEBITO, TRA.MONTOCREDITO FROM FTM ";
        query += "INNER JOIN TRANSACCION TRA ON FTM.ID_FTM = TRA.ID_FTM";
        query += " WHERE TRIM(' ' FROM FTM.TIPO_FTM) = :tipoAjuste AND FTM.estado = :estado ";
        query += "AND FTM.FECHACREACION BETWEEN :fechaIni AND :fechaFin";

        MapSqlParameterSource namedParameters = new MapSqlParameterSource();

        namedParameters.addValue("tipoAjuste", tipoAjuste, Types.VARCHAR);
        namedParameters.addValue("estado", estado, Types.VARCHAR);
        namedParameters.addValue("fechaIni", fechaIni);
        namedParameters.addValue("fechaFin", fechaFin);

        List<DTPopularBank> listDTPopularBank = namedParameterJdbcTemplate.query(query, namedParameters, new BeanPropertyRowMapper<DTPopularBank>(DTPopularBank.class));

        return listDTPopularBank;

    }

    /**
     *
     * @param tipoAjuste
     * @param estado
     * @param fechaIni
     * @param fechaFin
     * @return
     */
    public List<Aprobacion> getAprobacion(String tipoAjuste, String estado, Date fechaIni, Date fechaFin) {

        String query = "SELECT FTM.NIVELAPROBACION, FTM.ESTADOAVANZAR, FTM.CREADOPOR, FTM.REVISADOPOR, FTM.APROBADOPOR, FTM.POSTEADOPOR FROM FTM ";
        query += " WHERE TRIM(' ' FROM FTM.TIPO_FTM) = :tipoAjuste AND FTM.estado = :estado ";
        query += "AND FTM.FECHACREACION BETWEEN :fechaIni AND :fechaFin";

        MapSqlParameterSource namedParameters = new MapSqlParameterSource();

        namedParameters.addValue("tipoAjuste", tipoAjuste, Types.VARCHAR);
        namedParameters.addValue("estado", estado, Types.VARCHAR);
        namedParameters.addValue("fechaIni", fechaIni);
        namedParameters.addValue("fechaFin", fechaFin);

        List<Aprobacion> listAprobacion = namedParameterJdbcTemplate.query(query, namedParameters, new BeanPropertyRowMapper<Aprobacion>(Aprobacion.class));

        return listAprobacion;

    }
}
