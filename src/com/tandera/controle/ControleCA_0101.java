/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tandera.controle;

import com.tandera.modelo.ModeloCA_0101;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author alex.lopes
 */
public class ControleCA_0101 {
    
    ConectaBanco conexao = new ConectaBanco();
    ModeloCA_0101 mod = new ModeloCA_0101();
    int codEstado;
    int codCidade;
    
    public void InserirCA_0101(ModeloCA_0101 mod) {
        achaEstado(mod.getCestado());
        achaCidade(mod.getCcidade());
        conexao.conexao();
        try {
            PreparedStatement pst = conexao.conn.prepareStatement("insert into fornecedor(nom_for, end_for, num_for, bai_for, cestado, ccidade, cep_for, pais_for, cnpj_for, est_for, mun_for, tel_for, email_for, date_for)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1,mod.getNome());
            pst.setString(2,mod.getEndereco());
            pst.setString(3, mod.getNum());
            pst.setString(4, mod.getBairro());
            pst.setInt(5, codEstado);
            pst.setInt(6, codCidade);
            pst.setString(7, mod.getCep());
            pst.setString(8, mod.getPais());
            pst.setString(9, mod.getCnpj());
            pst.setString(10, mod.getEstadual());
            pst.setString(11, mod.getMunicipal());
            pst.setString(12, mod.getTelefone());
            pst.setString(13, mod.getEmail());
            pst.setTimestamp(14, mod.getHireDate());
            pst.execute();
            JOptionPane.showMessageDialog(null,"Dados Armazenados com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro na Inserção dos Dados. \n ERRO!"+ ex);
        }
        conexao.desconecta();
        
    }
    
    public void AlteraCA_0101(ModeloCA_0101 mod){
        achaEstado((mod.getCestado()));
        achaCidade((mod.getCcidade()));
        conexao.conexao();
        try {
            PreparedStatement pst = conexao.conn.prepareStatement("update fornecedor set nom_for=?, end_for=?, num_for=?, bai_for=?, cestado=?, ccidade=?, cep_for=?, pais_for=?, cnpj_for=?, est_for=?, mun_for=?, tel_for=?, email_for=?, date_for=? where id_for=?");
            pst.setString(1, mod.getNome());
            pst.setString(2,mod.getEndereco());
            pst.setString(3, mod.getNum());
            pst.setString(4, mod.getBairro());
            pst.setInt(5, codEstado);
            pst.setInt(6, codCidade);
            pst.setString(7, mod.getCep());
            pst.setString(8, mod.getPais());
            pst.setString(9, mod.getCnpj());
            pst.setString(10, mod.getEstadual());
            pst.setString(11, mod.getMunicipal());
            pst.setString(12, mod.getTelefone());
            pst.setString(13, mod.getEmail());
            pst.setTimestamp(14, mod.getHireDate());
            pst.setInt(15, mod.getCodigo());
            pst.execute();
            JOptionPane.showMessageDialog(null,"Dados Alterados com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro na alteração dos Dados. \n ERRO!"+ ex);
        }
    }
    
    public void ExcluirCA_0101 (ModeloCA_0101 mod){
        conexao.conexao();
        try {
            PreparedStatement pst = conexao.conn.prepareStatement("delete from fornecedor where id_for= ?");
            pst.setInt(1, mod.getCodigo());
            pst.execute();
            JOptionPane.showMessageDialog(null,"Dados Excluidos com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro na exclusão dos Dados. \n ERRO!"+ ex);
        }
        conexao.desconecta();
    }
    
    public void achaEstado(String estado){
        conexao.conexao(); 
        try {
            conexao.executaSQL("select * from estado where descr_estado='"+estado+"'");
            conexao.rs.first();
            codEstado = conexao.rs.getInt("id_estado");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar codigo!\nERRO"+ ex);
        }
        conexao.desconecta();
    }
    
    public void achaCidade(String cidade){
        conexao.conexao(); 
        try {
            conexao.executaSQL("select * from cidade where descr_cidade='"+cidade+"'");
            conexao.rs.first();
            codCidade = conexao.rs.getInt("id_cidade");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar codigo!\nERRO"+ ex);
        }
        conexao.desconecta();
    }
    
}
