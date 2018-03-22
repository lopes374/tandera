/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tandera.controle;

import com.tandera.modelo.ModeloCA_0200;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author alex.lopes
 */
public class ControleCA_0200 {
    
    ConectaBanco conexao = new ConectaBanco();
    ModeloCA_0200 mod = new ModeloCA_0200();
    
    public void InserirCA_0200(ModeloCA_0200 mod) {
        conexao.conexao();
        try {
            PreparedStatement pst = conexao.conn.prepareStatement("insert into impressora(descr_imp, cp_imp, date_imp )values(?,?,?)");
            pst.setString(1,mod.getDescr());
            pst.setInt(2, mod.getCp());
            pst.setTimestamp(3, mod.getHireDate());
            pst.execute();
            JOptionPane.showMessageDialog(null,"Dados Armazenados com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro na Inserção dos Dados. \n ERRO!"+ ex);
        }
        conexao.desconecta();     
    }
    
    public void AlteraCA_0200(ModeloCA_0200 mod){
        conexao.conexao();
        try {
            PreparedStatement pst = conexao.conn.prepareStatement("update impressora set descr_imp=?, cp_imp=?, date_imp=? where id_imp=?");
            pst.setString(1,mod.getDescr());
            pst.setInt(2, mod.getCp());
            pst.setTimestamp(3, mod.getHireDate());
            pst.setInt(4, mod.getCodigo());
            pst.execute();
            JOptionPane.showMessageDialog(null,"Dados Alterados com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro na alteração dos Dados. \n ERRO!"+ ex);
        }

    }
    
    public void ExcluirCA_0200 (ModeloCA_0200 mod){
        conexao.conexao();
        try {
            PreparedStatement pst = conexao.conn.prepareStatement("delete from impressora where id_imp= ?");
            pst.setInt(1, mod.getCodigo());
            pst.execute();
            JOptionPane.showMessageDialog(null,"Dados Excluidos com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro na exclusão dos Dados. \n ERRO!"+ ex);
        }
        conexao.desconecta();
    }
    
}
