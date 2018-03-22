/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tandera.controle;

import com.tandera.modelo.ModeloCA_0100;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author alex.lopes
 */
public class ControleCA_0100 {
    
    ConectaBanco conexao = new ConectaBanco();
    ModeloCA_0100 mod = new ModeloCA_0100();
    int codSexo;
    int codDepartamento;
    int codSituacao;
    
    public void InserirCA_0100(ModeloCA_0100 mod) {
        achaSexo(mod.getCsexo());
        achaDepartamento(mod.getCdepartamento());
        achaSituacao(mod.getCsituacao());
        conexao.conexao();
        try {
            PreparedStatement pst = conexao.conn.prepareStatement("insert into colaborador"
                    + "(nome_col, csexo, tel_col, fun_col, cdepartamento, cracha_col, adm_col, nas_col, rg_col, cpf_col, date_col, ctps_col,"
                    + " csituacao)"
                    + "values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1,mod.getNome());
            pst.setInt(2,codSexo);
            pst.setString(3, mod.getTelefone());
            pst.setString(4, mod.getFuncao());
            pst.setInt(5, codDepartamento);
            pst.setString(6, mod.getCracha());
            pst.setString(7, mod.getAdmissao());
            pst.setString(8, mod.getNascimento());
            pst.setString(9, mod.getRg());
            pst.setString(10, mod.getCpf());
            pst.setTimestamp(11, mod.getHireDate());
            pst.setString(12, mod.getCtps());
            pst.setInt(13, codSituacao);
            pst.execute();
            JOptionPane.showMessageDialog(null,"Dados Armazenados com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro na Inserção dos Dados. \n ERRO!"+ ex);
        }
        conexao.desconecta();
        
    }
    
    public void AlteraCA_0100(ModeloCA_0100 mod){
        achaSexo((mod.getCsexo()));
        achaDepartamento((mod.getCdepartamento()));
        achaSituacao(mod.getCsituacao());
        conexao.conexao();
        try {
            PreparedStatement pst = conexao.conn.prepareStatement("update colaborador set "
                    + "nome_col=?, csexo=?, tel_col=?, fun_col=?, cdepartamento=?, cracha_col=?, adm_col=?, "
                    + "nas_col=?, rg_col=?, cpf_col=?, date_col=?, ctps_col=?, csituacao=? where id_col=?");
            pst.setString(1, mod.getNome());
            pst.setInt(2,codSexo);
            pst.setString(3, mod.getTelefone());
            pst.setString(4, mod.getFuncao());
            pst.setInt(5, codDepartamento);
            pst.setString(6, mod.getCracha());
            pst.setString(7, mod.getAdmissao());
            pst.setString(8, mod.getNascimento());
            pst.setString(9, mod.getRg());
            pst.setString(10, mod.getCpf());
            pst.setTimestamp(11, mod.getHireDate());
            pst.setString(12, mod.getCtps());
            pst.setInt(13, codSituacao);
            pst.setInt(14, mod.getCodigo());
            pst.execute();
            JOptionPane.showMessageDialog(null,"Dados Alterados com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro na alteração dos Dados. \n ERRO!"+ ex);
        }
    }
    
    public void ExcluirCA_0100 (ModeloCA_0100 mod){
        conexao.conexao();
        try {
            PreparedStatement pst = conexao.conn.prepareStatement("delete from colaborador where id_col=?");
            pst.setInt(1, mod.getCodigo());
            pst.execute();
            JOptionPane.showMessageDialog(null,"Dados Excluidos com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro na exclusão dos Dados. \n ERRO!"+ ex);
        }
        conexao.desconecta();
    }
    
    public void achaSexo(String sexo){
        conexao.conexao(); 
        try {
            conexao.executaSQL("select * from sexo where descr_sexo='"+sexo+"'");
            conexao.rs.first();
            codSexo = conexao.rs.getInt("id_sexo");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar codigo!\nERRO"+ ex);
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
    
    public void achaSituacao(String situacao){
        conexao.conexao(); 
        try {
            conexao.executaSQL("select * from situacao where descr_sit='"+situacao+"'");
            conexao.rs.first();
            codSituacao = conexao.rs.getInt("id_sit");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar codigo!\nERRO"+ ex);
        }
        conexao.desconecta();
    }
    
}
