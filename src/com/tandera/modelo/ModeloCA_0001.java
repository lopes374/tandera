/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tandera.modelo;

import java.sql.Timestamp;
import java.util.Calendar;

/**
 *
 * @author alex.lopes
 */
public class ModeloCA_0001 {
    
    private int codigo;
    private String cgrupo;
    private String descr;
    private Timestamp hireDate;

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the cgrupo
     */
    public String getCgrupo() {
        return cgrupo;
    }

    /**
     * @param cgrupo the cgrupo to set
     */
    public void setCgrupo(String cgrupo) {
        this.cgrupo = cgrupo;
    }

    /**
     * @return the descr
     */
    public String getDescr() {
        return descr;
    }

    /**
     * @param descr the descr to set
     */
    public void setDescr(String descr) {
        this.descr = descr;
    }

    /**
     * @return the hireDate
     */
    public Timestamp getHireDate() {
        return hireDate;
    }

    /**
     * @param hireDate the hireDate to set
     */
    public void setHireDate(Timestamp hireDate) {
        this.hireDate = hireDate;
    }

    
    
}
