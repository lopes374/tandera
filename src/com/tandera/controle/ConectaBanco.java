/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tandera.controle;

import com.tandera.dao.DaoHelper;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author alex.lopes
 */
public class ConectaBanco {
    
    public Statement stm;// responsável por preparar e realizar pesquisas no banco de dados
    public ResultSet rs;// responsável por armazenar o resultado de uma pesquisa passada para statement
    private String driver = "org.postgresql.Driver";// responsável por identificar o serviço de banco de dados
    private String caminho = "jdbc:postgresql://localhost:5432/sistemadado";// responsável por setar o local de bando de dados
    private String usuario = "postgres";
    private String senha = "101530";
    public Connection conn;// responsável por realizar a conexão com o banco de dados
    private DaoHelper dao;
    
    ConectaBanco(){
        dao = new DaoHelper();
    }

    public void conexao(){//método responsavel por realizar a conexão com o banco
        try {// tentativa inicial
            
            conn = dao.getConnection();
        } catch (SQLException ex) {//excessão
            JOptionPane.showMessageDialog(null, "Erro de conexão!\n Erro:" + ex.getMessage());
        }
    }
    
    public void executaSQL(String sql){
        try {
            stm = conn.createStatement(rs.TYPE_SCROLL_INSENSITIVE,rs.CONCUR_READ_ONLY);
            rs = stm.executeQuery(sql);
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, "Erro no ExecutaSQL!\n Erro:" + ex.getMessage());   
        }
    }
    
    public void desconecta(){// método para fechar a conexão com o banco de dados
        try {
            conn.close();// fecha a conexão
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao fecha a conexão!\n Erro:" + ex.getMessage());
        }
    }
}
