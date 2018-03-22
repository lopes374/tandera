/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tandera.controle;

import com.tandera.modelo.ModeloMO_0100;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author alex.lopes
 */
public class ControleMO_0100 {

    int codProd;
    int codDep;
    int codImp;

    ConectaBanco conexao = new ConectaBanco();
    ModeloMO_0100 mod = new ModeloMO_0100();

    public void adicionaItem(ModeloMO_0100 mod) throws SQLException {
        achaCodigoProduto(mod.getCcartucho());
        conexao.conexao();
        try {
            PreparedStatement pst = conexao.conn.prepareStatement("insert into itens_sai_car(csai_car, cproduto, quantidade_produto, data_car) values (?,?,?,?) ");
            pst.setInt(1, mod.getCodigo());
            pst.setInt(2, codProd);
            pst.setInt(3, mod.getQtd());
            pst.setTimestamp(4, mod.getHireDate());
            pst.execute();
            // baixa de estoque
            int quant = 0, resul = 0;
            conexao.executaSQL("select * from produto where descr_pro='" + mod.getCcartucho() + "'");
            conexao.rs.first();
            quant = conexao.rs.getInt("qtd_pro");
            resul = quant - mod.getQtd();
            pst = conexao.conn.prepareStatement("update produto set qtd_pro=? where descr_pro=?");
            pst.setInt(1, resul);
            pst.setString(2, mod.getCcartucho());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Produto Adicionado!");
            conexao.desconecta();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir" + ex);
            conexao.desconecta();
        }

    }

    public void fechaSaida(ModeloMO_0100 mod) {
        achaDepartamento(mod.getCdepartamento());
        achaImpressora(mod.getCimpressora());
        conexao.conexao();
        try {
            PreparedStatement pst = conexao.conn.prepareStatement("update saida_cartucho set cdepartamento=?, cimpressora=?, data_car=?, custo=? where id_car=?");
            pst.setInt(1, codDep);
            pst.setInt(2, codImp);
            pst.setString(3, mod.getData());
            pst.setFloat(4, mod.getCusto());
            pst.setInt(5, mod.getCodigo());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Saida Finalizada");
        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(null, "Erro ao fechar" + ex);
        }
        conexao.desconecta();
    }

    public void cancelaSaida() {
        conexao.conexao();
        PreparedStatement pst;
        conexao.executaSQL("select * from saida_cartucho inner join itens_sai_car "
                + "on saida_cartucho.id_car = itens_sai_car.csai_car inner join produto "
                + "on itens_sai_car.cproduto = produto.id_pro where custo=0");
        try {
            conexao.rs.first();
            do {
                int qtdProd = conexao.rs.getInt("qtd_pro");
                int qtdVend = conexao.rs.getInt("quantidade_produto");
                int soma = qtdProd + qtdVend;
                pst = conexao.conn.prepareStatement("update produto set qtd_pro=? where id_pro=?");
                pst.setInt(1, soma);
                pst.setInt(2, conexao.rs.getInt("id_pro"));
                pst.execute();
                pst = conexao.conn.prepareStatement("delete from itens_sai_car where csai_car=?");
                pst.setInt(1, conexao.rs.getInt("id_car"));
                pst.execute();
            } while (conexao.rs.next());
            pst = conexao.conn.prepareStatement("delete from saida_cartucho where custo=?");
            pst.setInt(1, 0);
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cancelar a venda!\nErro:" + ex);
        }
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

    public void achaDepartamento(String departamento) {
        conexao.conexao();
        try {
            conexao.executaSQL("select * from departamento where descr_departamento='" + departamento + "'");
            conexao.rs.first();
            codDep = conexao.rs.getInt("id_departamento");
            conexao.desconecta();
        } catch (SQLException ex) {
            conexao.desconecta();
            JOptionPane.showMessageDialog(null, "Erro ao achar departamento" + ex);
        }
    }

    public void achaImpressora(String impressora) {
        conexao.conexao();
        try {
            conexao.executaSQL("select * from impressora where descr_imp='" + impressora + "'");
            conexao.rs.first();
            codImp = conexao.rs.getInt("id_imp");
            conexao.desconecta();
        } catch (SQLException ex) {
            conexao.desconecta();
            JOptionPane.showMessageDialog(null, "Erro ao achar Impressora" + ex);
        }
    }
}
