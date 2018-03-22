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
public class ModeloCA_0102 {
    
    private int codigo;
    private String cgrupo;
    private String csgrupo;
    private String descr;
    private String cfornecedor;
    private float preco;
    private int estoque;
    private Timestamp hireDate;
    private String cp;

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
     * @return the csgrupo
     */
    public String getCsgrupo() {
        return csgrupo;
    }

    /**
     * @param csgrupo the csgrupo to set
     */
    public void setCsgrupo(String csgrupo) {
        this.csgrupo = csgrupo;
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
     * @return the cfornecedor
     */
    public String getCfornecedor() {
        return cfornecedor;
    }

    /**
     * @param cfornecedor the cfornecedor to set
     */
    public void setCfornecedor(String cfornecedor) {
        this.cfornecedor = cfornecedor;
    }

    /**
     * @return the preco
     */
    public float getPreco() {
        return preco;
    }

    /**
     * @param preco the preco to set
     */
    public void setPreco(float preco) {
        this.preco = preco;
    }

    /**
     * @return the estoque
     */
    public int getEstoque() {
        return estoque;
    }

    /**
     * @param estoque the estoque to set
     */
    public void setEstoque(int estoque) {
        this.estoque = estoque;
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
     * @return the cp
     */
    public String getCp() {
        return cp;
    }

    /**
     * @param cp the cp to set
     */
    public void setCp(String cp) {
        this.cp = cp;
    }

    
}
