/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tandera.controle;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import com.tandera.modelo.ModeloCA_0103;


/**
 *
 * @author alex.lopes
 */
public class ControleCA_0103 {
    
    ConectaBanco conexao = new ConectaBanco();
    int codColaborador;
    int codPermissao;
    
    public void InserirCA_0103(ModeloCA_0103 mod) {
        achaColaborador(mod.getCcolaborador());
        achaPermissao(mod.getCpermissao());
        conexao.conexao();
        try {
            PreparedStatement pst = conexao.conn.prepareStatement("insert into usuarios(login_usuario, ccolaborador, senha_usuario, cpermissao "
                    + "values(?,?,?,?)");
            pst.setString(1,mod.getUsuario());
            pst.setInt(2,codColaborador);
            pst.setString(3, mod.getSenha());
            pst.setInt(4, codPermissao);
            pst.execute();
            JOptionPane.showMessageDialog(null,"Dados Armazenados com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro na Inserção dos Dados. \n ERRO!"+ ex);
        }
        conexao.desconecta();
        
    }
    
    public void AlteraCA_0103(ModeloCA_0103 mod){
        achaColaborador(mod.getCcolaborador());
        achaPermissao(mod.getCpermissao());
        conexao.conexao();
        try {
            PreparedStatement pst = conexao.conn.prepareStatement("update usuarios set login_usuario=?, ccolaborador=?, senha_usuario=?, cpermissao=?,"
                    + " where id_usuario=?");
            pst.setString(1, mod.getUsuario());
            pst.setInt(2, codColaborador);
            pst.setString(3, mod.getSenha());
            pst.setInt(4, codPermissao);
            pst.setInt(5, mod.getCodigo());
            pst.execute();
            JOptionPane.showMessageDialog(null,"Dados Alterados com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro na alteração dos Dados. \n ERRO!"+ ex);
        }
    }
    
    public void ExcluirCA_0103 (ModeloCA_0103 mod){
        conexao.conexao();
        try {
            PreparedStatement pst = conexao.conn.prepareStatement("delete from usuarios where id_usuario= ?");
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
    
    public void achaPermissao(String permissao){
        conexao.conexao(); 
        try {
            conexao.executaSQL("select * from permissao_usu where descr_permissao='"+permissao+"'");
            conexao.rs.first();
            codPermissao = conexao.rs.getInt("id_permissao");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar codigo!\nERRO"+ ex);
        }
        conexao.desconecta();
    }
    
}
