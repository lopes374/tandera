/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tandera.controle;

import com.tandera.modelo.ModeloCR_0200;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author alex.lopes
 */
public class ControleCR_0200 {
    
    ConectaBanco conexao = new ConectaBanco();
    ModeloCR_0200 mod = new ModeloCR_0200();
    int codDepartamento;
    int codImpressora;
    
    public void InserirRE_0200(ModeloCR_0200 mod) {
        achaDepartamento(mod.getCdepartamento());
        achaImpressora(mod.getCimpressora());
        conexao.conexao();
        try {
            PreparedStatement pst = conexao.conn.prepareStatement("insert into itens_imp_dep (id_impressora, id_departamento)values(?,?)");
            pst.setInt(1,codImpressora);
            pst.setInt(2,codDepartamento);
            pst.execute();
            JOptionPane.showMessageDialog(null,"Dados Armazenados com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro na Inserção dos Dados. \n ERRO!"+ ex);
        }
        conexao.desconecta();
        
    }
    
    public void AlteraRE_0200(ModeloCR_0200 mod){
        achaDepartamento((mod.getCdepartamento()));
        achaImpressora((mod.getCimpressora()));
        conexao.conexao();
        try {
            PreparedStatement pst = conexao.conn.prepareStatement("update itens_imp_dep set id_impressora=?, id_departamento=? where id_id=?");
            pst.setInt(1, codImpressora);
            pst.setInt(2, codDepartamento);
            pst.setInt(3, mod.getCodigo());
            pst.execute();
            JOptionPane.showMessageDialog(null,"Dados Alterados com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro na alteração dos Dados. \n ERRO!"+ ex);
        }
    }
    
    public void ExcluirRE_0200 (ModeloCR_0200 mod){
        conexao.conexao();
        try {
            PreparedStatement pst = conexao.conn.prepareStatement("delete from itens_imp_dep where id_id= ?");
            pst.setInt(1, mod.getCodigo());
            pst.execute();
            JOptionPane.showMessageDialog(null,"Dados Excluidos com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro na exclusão dos Dados. \n ERRO!"+ ex);
        }
        conexao.desconecta();
    }
    
    public void achaDepartamento(String departamento){
        conexao.conexao(); 
        try {
            conexao.executaSQL("select * from departamento where descr_departamento='"+departamento+"'");
            conexao.rs.first();
            codDepartamento = conexao.rs.getInt("id_departamento");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar codigo!\nERRO"+ ex);
        }
        conexao.desconecta();
    }
    
    public void achaImpressora(String impressora){
        conexao.conexao(); 
        try {
            conexao.executaSQL("select * from impressora where descr_imp='"+impressora+"'");
            conexao.rs.first();
            codImpressora = conexao.rs.getInt("id_imp");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar codigo!\nERRO"+ ex);
        }
        conexao.desconecta();
    }
    
}
