/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tandera.controle;

import com.tandera.modelo.ModeloCR_0202;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author alex.lopes
 */
public class ControleCR_0202 {
    
    ConectaBanco conexao = new ConectaBanco();
    ModeloCR_0202 mod = new ModeloCR_0202();
    int codColaborador;
    int codComputador;
    
    public void InserirRE_0202(ModeloCR_0202 mod) {
        achaColaborador(mod.getCcolaborador());
        achaComputador(mod.getCcomputador());
        conexao.conexao();
        try {
            PreparedStatement pst = conexao.conn.prepareStatement("insert into itens_col_com (ccolaborador, ccomputador)values(?,?)");
            pst.setInt(1,codColaborador);
            pst.setInt(2,codComputador);
            pst.execute();
            JOptionPane.showMessageDialog(null,"Dados Armazenados com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro na Inserção dos Dados. \n ERRO!"+ ex);
        }
        conexao.desconecta();
        
    }
    
    public void AlteraRE_0202(ModeloCR_0202 mod){
        achaColaborador(mod.getCcolaborador());
        achaComputador(mod.getCcomputador());
        conexao.conexao();
        try {
            PreparedStatement pst = conexao.conn.prepareStatement("update itens_col_com set ccolaborador=?, ccomputador=? where id_cc=?");
            pst.setInt(1, codColaborador);
            pst.setInt(2, codComputador);
            pst.setInt(3, mod.getCodigo());
            pst.execute();
            JOptionPane.showMessageDialog(null,"Dados Alterados com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro na alteração dos Dados. \n ERRO!"+ ex);
        }
    }
    
    public void ExcluirRE_0202 (ModeloCR_0202 mod){
        conexao.conexao();
        try {
            PreparedStatement pst = conexao.conn.prepareStatement("delete from itens_col_com where id_cc= ?");
            pst.setInt(1, mod.getCodigo());
            pst.execute();
            JOptionPane.showMessageDialog(null,"Dados Excluidos com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro na exclusão dos Dados. \n ERRO!"+ ex);
        }
        conexao.desconecta();
    }
    
    public void achaColaborador(String colaborador){
        conexao.conexao(); 
        try {
            conexao.executaSQL("select * from colaborador where nome_col='"+colaborador+"'");
            conexao.rs.first();
            codColaborador = conexao.rs.getInt("id_col");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar codigo!\nERRO"+ ex);
        }
        conexao.desconecta();
    }
    
    public void achaComputador(String computador){
        conexao.conexao(); 
        try {
            conexao.executaSQL("select * from computador where descr_com='"+computador+"'");
            conexao.rs.first();
            codComputador = conexao.rs.getInt("id_com");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar codigo!\nERRO"+ ex);
        }
        conexao.desconecta();
    }
    
}
