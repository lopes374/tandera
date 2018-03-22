/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tandera.controle;

import com.tandera.modelo.ModeloMO_0101;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author alex.lopes
 */
public class ControleMO_0101 {
    
    int codProd;
    int codMov;
    int codFor;

    ConectaBanco conexao = new ConectaBanco();
    ModeloMO_0101 mod = new ModeloMO_0101();

    public void adicionaItem(ModeloMO_0101 mod) throws SQLException {
        achaCodigoProduto(mod.getCproduto());
        conexao.conexao();
        try {
            PreparedStatement pst = conexao.conn.prepareStatement("insert into itens_ent_pro(cent_pro, cproduto, quantidade_produto, data_sai, pre_ent) "
                    + "values (?,?,?,?,?) ");
            pst.setInt(1, mod.getCodigo());
            pst.setInt(2, codProd);
            pst.setInt(3, mod.getQtd());
            pst.setTimestamp(4, mod.getHireDate());
            pst.setFloat(5, mod.getPreco());
            pst.execute();
            // baixa de estoque
            int quant = 0, resul = 0;
            conexao.executaSQL("select * from produto where descr_pro='" + mod.getCproduto()+ "'");
            conexao.rs.first();
            quant = conexao.rs.getInt("qtd_pro");
            resul = quant + mod.getQtd();
            pst = conexao.conn.prepareStatement("update produto set qtd_pro=? where descr_pro=?");
            pst.setInt(1, resul);
            pst.setString(2, mod.getCproduto());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Produto Adicionado!");
            conexao.desconecta();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir" + ex);
            conexao.desconecta();
        }
        
    }
    
    public void cancelaSaida() {
        conexao.conexao();
        PreparedStatement pst;
        conexao.executaSQL("select * from entrada_produto inner join itens_ent_pro "
                + "on entrada_produto.id_ent = itens_ent_pro.cent_pro inner join produto "
                + "on itens_ent_pro.cproduto = produto.id_pro where custo=0");
        try {
            conexao.rs.first();
            do {
                int qtdProd = conexao.rs.getInt("qtd_pro");
                int qtdVend = conexao.rs.getInt("quantidade_produto");
                int subtracao = qtdProd - qtdVend;
                pst = conexao.conn.prepareStatement("update produto set qtd_pro=? where id_pro=?");
                pst.setInt(1, subtracao);
                pst.setInt(2, conexao.rs.getInt("id_pro"));
                pst.execute();
                pst = conexao.conn.prepareStatement("delete from itens_ent_pro where cent_pro=?");
                pst.setInt(1, conexao.rs.getInt("id_ent"));
                pst.execute();
            } while (conexao.rs.next());
            pst = conexao.conn.prepareStatement("delete from entrada_produto where custo=?");
            pst.setInt(1, 0);
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cancelar a venda!\nErro:" + ex);
        }
    }
    
    public void fechaSaida(ModeloMO_0101 mod) {
        achaMovimentacao(mod.getCmovimentacao());
        achaFornecedor(mod.getCfornecedor());
        conexao.conexao();
        try {
            PreparedStatement pst = conexao.conn.prepareStatement("update entrada_produto set ctipo=?, cfornecedor=?, data_ent=?, custo=? "
                    + "where id_ent=?");
            pst.setInt(1, codMov);
            pst.setInt(2, codFor);
            pst.setString(3, mod.getData());
            pst.setFloat(4, mod.getCusto());
            pst.setInt(5, mod.getCodigo());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Entrada Finalizada");
        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(null, "Erro ao fechar" + ex);
        }
        conexao.desconecta();
    }
        
        public void achaCodigoProduto(String nome) {
        conexao.conexao();
        conexao.executaSQL("select * from produto where descr_pro='" + nome + "'");
        try {
            conexao.rs.first();
            codProd = conexao.rs.getInt("id_pro");
            conexao.desconecta();
        } catch (SQLException ex) {
            conexao.desconecta();
            JOptionPane.showMessageDialog(null, "ERRO");
        }
    }
        
    public void achaMovimentacao(String movimentacao) {
        conexao.conexao();
        try {
            conexao.executaSQL("select * from tipos_movimentacao where descr_mov='" + movimentacao + "'");
            conexao.rs.first();
            codMov = conexao.rs.getInt("id_mov");
            conexao.desconecta();
        } catch (SQLException ex) {
            conexao.desconecta();
            JOptionPane.showMessageDialog(null, "Erro ao achar departamento" + ex);
        }
    }  
    
    public void achaFornecedor(String fornecedor) {
        conexao.conexao();
        try {
            conexao.executaSQL("select * from fornecedor where nom_for='" + fornecedor + "'");
            conexao.rs.first();
            codFor = conexao.rs.getInt("id_for");
            conexao.desconecta();
        } catch (SQLException ex) {
            conexao.desconecta();
            JOptionPane.showMessageDialog(null, "Erro ao achar departamento" + ex);
        }
    }    
    
}
