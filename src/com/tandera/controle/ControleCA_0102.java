/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tandera.controle;

import com.tandera.modelo.ModeloCA_0102;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author alex.lopes
 */
public class ControleCA_0102 {
    
    ConectaBanco conexao = new ConectaBanco();
    ModeloCA_0102 mod = new ModeloCA_0102();
    int codGrupo;
    int codSgrupo;
    int codFornecedor;
    
    public void InserirCA_0102(ModeloCA_0102 mod) {
        achaGrupo(mod.getCgrupo());
        achaSgrupo(mod.getCsgrupo());
        achaFornecedor(mod.getCfornecedor());
        conexao.conexao();
        try {
            PreparedStatement pst = conexao.conn.prepareStatement("insert into produto(cgrupo, csgrupo, descr_pro, cfornecedor, pre_pro, qtd_pro,"
                    + " date_pro, cp_pro)values(?,?,?,?,?,?,?,?)");
            pst.setInt(1,codGrupo);
            pst.setInt(2,codSgrupo);
            pst.setString(3, mod.getDescr());
            pst.setInt(4, codFornecedor);
            pst.setFloat(5, mod.getPreco());
            pst.setInt(6, mod.getEstoque());
            pst.setTimestamp(7, mod.getHireDate());
            pst.setString(8, mod.getCp());
            pst.execute();
            JOptionPane.showMessageDialog(null,"Dados Armazenados com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro na Inserção dos Dados. \n ERRO!"+ ex);
        }
        conexao.desconecta();
        
    }
    
    public void AlteraCA_0102(ModeloCA_0102 mod){
        achaGrupo(mod.getCgrupo());
        achaSgrupo(mod.getCsgrupo());
        achaFornecedor(mod.getCfornecedor());
        conexao.conexao();
        try {
            PreparedStatement pst = conexao.conn.prepareStatement("update produto set cgrupo=?, csgrupo=?, descr_pro=?, cfornecedor=?,"
                    + " pre_pro=?, qtd_pro=?, date_pro=?, cp_pro=? where id_pro=?");
            pst.setInt(1, codGrupo);
            pst.setInt(2, codSgrupo);
            pst.setString(3, mod.getDescr());
            pst.setInt(4, codFornecedor);
            pst.setFloat(5, mod.getPreco());
            pst.setInt(6, mod.getEstoque());
            pst.setTimestamp(7, mod.getHireDate());
            pst.setString(8, mod.getCp());
            pst.setInt(9, mod.getCodigo());
            pst.execute();
            JOptionPane.showMessageDialog(null,"Dados Alterados com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro na alteração dos Dados. \n ERRO!"+ ex);
        }
    }
    
    public void ExcluirCA_0102 (ModeloCA_0102 mod){
        conexao.conexao();
        try {
            PreparedStatement pst = conexao.conn.prepareStatement("delete from produto where id_pro= ?");
            pst.setInt(1, mod.getCodigo());
            pst.execute();
            JOptionPane.showMessageDialog(null,"Dados Excluidos com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro na exclusão dos Dados. \n ERRO!"+ ex);
        }
        conexao.desconecta();
    }
    
    public void achaGrupo(String grupo){
        conexao.conexao(); 
        try {
            conexao.executaSQL("select * from grupos where descr_grupo='"+grupo+"'");
            conexao.rs.first();
            codGrupo = conexao.rs.getInt("id_grupo");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar codigo!\nERRO"+ ex);
        }
        conexao.desconecta();
    }
    
    public void achaSgrupo(String sgrupo){
        conexao.conexao(); 
        try {
            conexao.executaSQL("select * from sgrupos where descr_sgrupo='"+sgrupo+"'");
            conexao.rs.first();
            codSgrupo = conexao.rs.getInt("id_sgrupo");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar codigo!\nERRO"+ ex);
        }
        conexao.desconecta();
    }
    
    public void achaFornecedor(String fornecedor){
        conexao.conexao(); 
        try {
            conexao.executaSQL("select * from fornecedor where nom_for='"+fornecedor+"'");
            conexao.rs.first();
            codFornecedor = conexao.rs.getInt("id_for");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar codigo!\nERRO"+ ex);
        }
        conexao.desconecta();
    }
    
}
