/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tandera.controle;

import com.tandera.modelo.ModeloCA_0002;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author alex.lopes
 */
public class ControleCA_0002 {
    
    ConectaBanco conexao = new ConectaBanco();
    ModeloCA_0002 mod = new ModeloCA_0002();
    
    public void InserirCA_0002(ModeloCA_0002 mod) {
        conexao.conexao();
        try {
            PreparedStatement pst = conexao.conn.prepareStatement("insert into departamento(descr_departamento)values(?)");
            pst.setString(1,mod.getDescr());
            pst.execute();
            JOptionPane.showMessageDialog(null,"Dados Armazenados com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro na Inserção dos Dados. \n ERRO!"+ ex);
        }
        conexao.desconecta();     
    }
    
    public void AlteraCA_0002(ModeloCA_0002 mod){
        conexao.conexao();
        try {
            PreparedStatement pst = conexao.conn.prepareStatement("update departamento set descr_departamento=? where id_departamento=?");
            pst.setString(1,mod.getDescr());
            pst.setInt(2, mod.getCodigo());
            pst.execute();
            JOptionPane.showMessageDialog(null,"Dados Alterados com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro na alteração dos Dados. \n ERRO!"+ ex);
        }

    }
    
    public void ExcluirCA_0002 (ModeloCA_0002 mod){
        conexao.conexao();
        try {
            PreparedStatement pst = conexao.conn.prepareStatement("delete from departamento where id_departamento= ?");
            pst.setInt(1, mod.getCodigo());
            pst.execute();
            JOptionPane.showMessageDialog(null,"Dados Excluidos com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro na exclusão dos Dados. \n ERRO!"+ ex);
        }
        conexao.desconecta();
    }
    
}
