/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reporte.transaccional.dao;

import java.text.SimpleDateFormat;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author MORREGO
 */
@Repository
public class FTMDAO {
    
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    public void setDataSource(DataSource dataSource){
        namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }
    
    /*
    public List<Ftm> getAllFtm() {
        
        String query = "select * from ftm";
        
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        
        List<Ftm> query1 = namedParameterJdbcTemplate.query(query, namedParameters, new BeanPropertyRowMapper(Ftm.class));
        
        return query1;
    }*/
    
    
}
