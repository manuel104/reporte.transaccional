/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reporte.transaccional.core.model;

import java.io.Serializable;

/**
 *
 * @author MORREGO
 */
public class TipoAjuste implements Serializable {

    private static final long serialVersionUID = 1L;

    public static enum DTAjustes {
        Unknown(new String("")), TC_Banco_Popular(new String("TC Banco Popular")), TC_Popular_Bank(new String("TC Popular Bank")), Cuentas(new String("Cuentas"));

        private final String dtAjustes;

        DTAjustes(String dtAjustes) {
            this.dtAjustes = dtAjustes;
        }

        public String getDTAjustes() {
            return dtAjustes;
        }
    }

    public static DTAjustes getDTAjustes(String dtAjustes) {

        if (dtAjustes == null) {
            return DTAjustes.Unknown;
        }

        for (DTAjustes t : DTAjustes.values()) {
            if (t.getDTAjustes().compareTo(dtAjustes) == 0) {
                return t;
            }
        }
        return DTAjustes.Unknown;
    }

}
