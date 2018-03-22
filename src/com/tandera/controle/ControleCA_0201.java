/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tandera.controle;

import com.tandera.modelo.ModeloCA_0201;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author alex.lopes
 */
public class ControleCA_0201 {
    
    ConectaBanco conexao = new ConectaBanco();
    ModeloCA_0201 mod = new ModeloCA_0201();
    
    public void InserirCA_0201(ModeloCA_0201 mod) {
        conexao.conexao();
        try {
            PreparedStatement pst = conexao.conn.prepareStatement("insert into computador(descr_com, cp_com, pro_com, mac_com )values(?,?,?,?)");
            pst.setString(1,mod.getDescr());
            pst.setInt(2, mod.getCp());
            pst.setString(3, mod.getProc());
            pst.setString(4, mod.getMac());
            pst.execute();
            JOptionPane.showMessageDialog(null,"Dados Armazenados com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro na Inserção dos Dados. \n ERRO!"+ ex);
        }
        conexao.desconecta();     
    }
    
    public void AlteraCA_0201(ModeloCA_0201 mod){
        conexao.conexao();
        try {
            PreparedStatement pst = conexao.conn.prepareStatement("update computador set descr_com=?, cp_com=?, pro_com=?, mac_com=? where id_com=?");
            pst.setString(1,mod.getDescr());
            pst.setInt(2, mod.getCp());
            pst.setString(3, mod.getProc());
            pst.setString(4, mod.getMac());
            pst.setInt(5, mod.getCodigo());
            pst.execute();
            JOptionPane.showMessageDialog(null,"Dados Alterados com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro na alteração dos Dados. \n ERRO!"+ ex);
        }

    }
    
    public void ExcluirCA_0201 (ModeloCA_0201 mod){
        conexao.conexao();
        try {
            PreparedStatement pst = conexao.conn.prepareStatement("delete from computador where id_com= ?");
            pst.setInt(1, mod.getCodigo());
            pst.execute();
            JOptionPane.showMessageDialog(null,"Dados Excluidos com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro na exclusão dos Dados. \n ERRO!"+ ex);
        }
        conexao.desconecta();
    }
    
}
