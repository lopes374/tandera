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
public class ModeloMO_0100 {

    private int codigo;
    private String cdepartamento;
    private String cimpressora;
    private String ccartucho;
    private int qtd;
    private String data;
    private Timestamp hireDate;
    private float custo;

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
     * @return the cdepartamento
     */
    public String getCdepartamento() {
        return cdepartamento;
    }

    /**
     * @param cdepartamento the cdepartamento to set
     */
    public void setCdepartamento(String cdepartamento) {
        this.cdepartamento = cdepartamento;
    }

    /**
     * @return the cimpressora
     */
    public String getCimpressora() {
        return cimpressora;
    }

    /**
     * @param cimpressora the cimpressora to set
     */
    public void setCimpressora(String cimpressora) {
        this.cimpressora = cimpressora;
    }

    /**
     * @return the ccartucho
     */
    public String getCcartucho() {
        return ccartucho;
    }

    /**
     * @param ccartucho the ccartucho to set
     */
    public void setCcartucho(String ccartucho) {
        this.ccartucho = ccartucho;
    }

    /**
     * @return the qtd
     */
    public int getQtd() {
        return qtd;
    }

    /**
     * @param qtd the qtd to set
     */
    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    /**
     * @return the data
     */
    public String getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(String data) {
        this.data = data;
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

    /**
     * @return the custo
     */
    public float getCusto() {
        return custo;
    }

    /**
     * @param custo the custo to set
     */
    public void setCusto(float custo) {
        this.custo = custo;
    }

}
