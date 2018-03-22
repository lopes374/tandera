/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tandera.controle;

import com.tandera.modelo.ModeloCA_0001;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author alex.lopes
 */
public class ControleCA_0001 {
    
    ConectaBanco conexao = new ConectaBanco();
    ConectaBanco connGrupo = new ConectaBanco();
    ModeloCA_0001 mod = new ModeloCA_0001();
    int codGrupo;
    String nomeGrupo;
    
    public void InserirCA_0001(ModeloCA_0001 mod) {
        achaGrupo(mod.getCgrupo());
        conexao.conexao();
        try {
            PreparedStatement pst = conexao.conn.prepareStatement("insert into sgrupos(cgrupo, descr_sgrupo, date_sgrupo)values(?,?,?)");
            pst.setInt(1,codGrupo);
            pst.setString(2,mod.getDescr());
            pst.setTimestamp(3, mod.getHireDate());
            pst.execute();
            JOptionPane.showMessageDialog(null,"Dados Armazenados com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro na Inserção dos Dados. \n ERRO!"+ ex);
        }
        conexao.desconecta();
        
    }
    
    public void AlteraCA_0001(ModeloCA_0001 mod){
        achaGrupo((mod.getCgrupo()));
        conexao.conexao();
        try {
            PreparedStatement pst = conexao.conn.prepareStatement("update sgrupos set cgrupo=?, descr_sgrupo=?, date_sgrupo=? where id_sgrupo=?");
            pst.setInt(1, codGrupo);
            pst.setString(2,mod.getDescr());
            pst.setTimestamp(3, mod.getHireDate());
            pst.setInt(4, mod.getCodigo());
            pst.execute();
            JOptionPane.showMessageDialog(null,"Dados Alterados com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro na alteração dos Dados. \n ERRO!"+ ex);
        }
    }
    
    public void ExcluirCA_0001 (ModeloCA_0001 mod){
        conexao.conexao();
        try {
            PreparedStatement pst = conexao.conn.prepareStatement("delete from sgrupos where id_sgrupo= ?");
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
            JOptionPane.showMessageDialog(null, "Erro ao buscar codigo do Grupo!\nERRO"+ ex);
        }
        conexao.desconecta();
    }
    
}
