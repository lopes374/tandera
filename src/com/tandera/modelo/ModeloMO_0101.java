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
public class ModeloMO_0101 {
    
    private int codigo;
    private String cmovimentacao;
    private String cfornecedor;
    private String cproduto;
    private int qtd;
    private String data;
    private Timestamp hireDate;
    private float preco;
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
     * @return the cmovimentacao
     */
    public String getCmovimentacao() {
        return cmovimentacao;
    }

    /**
     * @param cmovimentacao the cmovimentacao to set
     */
    public void setCmovimentacao(String cmovimentacao) {
        this.cmovimentacao = cmovimentacao;
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
     * @return the cproduto
     */
    public String getCproduto() {
        return cproduto;
    }

    /**
     * @param cproduto the cproduto to set
     */
    public void setCproduto(String cproduto) {
        this.cproduto = cproduto;
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
    
}
