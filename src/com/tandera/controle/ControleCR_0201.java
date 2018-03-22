/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tandera.controle;

import com.tandera.modelo.ModeloCR_0201;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author alex.lopes
 */
public class ControleCR_0201 {
    
    ConectaBanco conexao = new ConectaBanco();
    ModeloCR_0201 mod = new ModeloCR_0201();
    int codImpressora;
    int codCartucho;
    
    public void InserirRE_0201(ModeloCR_0201 mod) {
        achaImpressora(mod.getCimpressora());
        achaCartucho(mod.getCproduto());
        conexao.conexao();
        try {
            PreparedStatement pst = conexao.conn.prepareStatement("insert into itens_imp_car (cimpressora, cproduto)values(?,?)");
            pst.setInt(1,codImpressora);
            pst.setInt(2,codCartucho);
            pst.execute();
            JOptionPane.showMessageDialog(null,"Dados Armazenados com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro na Inserção dos Dados. \n ERRO!"+ ex);
        }
        conexao.desconecta();
        
    }
    
    public void AlteraRE_0201(ModeloCR_0201 mod){
        achaImpressora(mod.getCimpressora());
        achaCartucho(mod.getCproduto());
        conexao.conexao();
        try {
            PreparedStatement pst = conexao.conn.prepareStatement("update itens_imp_car set cimpressora=?, cproduto=? where id_ic=?");
            pst.setInt(1, codImpressora);
            pst.setInt(2, codCartucho);
            pst.setInt(3, mod.getCodigo());
            pst.execute();
            JOptionPane.showMessageDialog(null,"Dados Alterados com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro na alteração dos Dados. \n ERRO!"+ ex);
        }
    }
    
    public void ExcluirRE_0201 (ModeloCR_0201 mod){
        conexao.conexao();
        try {
            PreparedStatement pst = conexao.conn.prepareStatement("delete from itens_imp_car where id_ic= ?");
            pst.setInt(1, mod.getCodigo());
            pst.execute();
            JOptionPane.showMessageDialog(null,"Dados Excluidos com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro na exclusão dos Dados. \n ERRO!"+ ex);
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
    
    public void achaCartucho(String cartucho){
        conexao.conexao(); 
        try {
            conexao.executaSQL("select * from produto where descr_pro='"+cartucho+"'");
            conexao.rs.first();
            codCartucho = conexao.rs.getInt("id_pro");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar codigo!\nERRO"+ ex);
        }
        conexao.desconecta();
    }
    
}
