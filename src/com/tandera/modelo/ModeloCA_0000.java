/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tandera.modelo;

import java.sql.Timestamp;


/**
 *
 * @author alex.lopes
 */
public class ModeloCA_0000 {
    
    private int codigo;
    private String descr;
    private Timestamp hireData ;

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
     * @return the hireData
     */
    public Timestamp getHireData() {
        return hireData;
    }
    
    public void setHireData(Timestamp hireData) {
        this.hireData = hireData;
    }   
}
