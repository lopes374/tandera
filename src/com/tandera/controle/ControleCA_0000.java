/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tandera.controle;

import com.tandera.modelo.ModeloCA_0000;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author alex.lopes
 */
public class ControleCA_0000 {
    
    ConectaBanco conexao = new ConectaBanco();
    ModeloCA_0000 mod = new ModeloCA_0000();
    
    public void InserirCA_0000(ModeloCA_0000 mod) {
        conexao.conexao();
        try {
            PreparedStatement pst = conexao.conn.prepareStatement("insert into grupos(descr_grupo, date_grupo)values(?,?)");
            pst.setString(1,mod.getDescr());
            pst.setTimestamp(2, mod.getHireData());
            pst.execute();
            JOptionPane.showMessageDialog(null,"Dados Armazenados com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro na Inserção dos Dados. \n ERRO!"+ ex);
        }
        conexao.desconecta();     
    }
    
    public void AlteraCA_0000(ModeloCA_0000 mod){
        conexao.conexao();
        try {
            PreparedStatement pst = conexao.conn.prepareStatement("update grupos set descr_grupo=?, date_grupo=? where id_grupo=?");
            pst.setString(1,mod.getDescr());
            pst.setTimestamp(2, mod.getHireData());
            pst.setInt(3, mod.getCodigo());
            pst.execute();
            JOptionPane.showMessageDialog(null,"Dados Alterados com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro na alteração dos Dados. \n ERRO!"+ ex);
        }

    }
    
    public void ExcluirCA_0000 (ModeloCA_0000 mod){
        conexao.conexao();
        try {
            PreparedStatement pst = conexao.conn.prepareStatement("delete from grupos where id_grupo= ?");
            pst.setInt(1, mod.getCodigo());
            pst.execute();
            JOptionPane.showMessageDialog(null,"Dados Excluidos com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro na exclusão dos Dados. \n ERRO!"+ ex);
        }
        conexao.desconecta();
    }
    
}
    
  
  
