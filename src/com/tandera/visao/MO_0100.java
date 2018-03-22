/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tandera.visao;

import com.tandera.controle.ConectaBanco;
import com.tandera.controle.ControleMO_0100;
import com.tandera.modelo.ModeloTabela;
import com.tandera.modelo.ModeloMO_0100;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author alex.lopes
 */
public class MO_0100 extends javax.swing.JInternalFrame {

    ConectaBanco conexao = new ConectaBanco();
    ConectaBanco conn = new ConectaBanco();
    ModeloMO_0100 modelo = new ModeloMO_0100();
    ControleMO_0100 control = new ControleMO_0100();
    int codSaida;
    float total;

    /**
     * Creates new form MO_0100
     */
    public MO_0100() {
        initComponents();
        conexao.conexao();
        conn.conexao();

        try {
            MaskFormatter data = new MaskFormatter("##/##/####");
            jFormattedTextFieldData.setFormatterFactory(new DefaultFormatterFactory(data));
        } catch (ParseException ex) {
            //Logger.getLogger(FrmFornecedor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void preencherComboDepartamento() {
        conexao.executaSQL("select * from departamento order by descr_departamento");
        jComboBoxDepartamento.removeAllItems();// remove todos os itens da combobox
        try {
            conexao.rs.first();
            do {
                jComboBoxDepartamento.addItem(conexao.rs.getString("descr_departamento"));
            } while (conexao.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao preencher combobox Grupo:" + ex);
        }
        return;
    }

    public void preencherComboImpressora() {
        conexao.executaSQL("select impressora.descr_imp "
                + "        from itens_imp_dep "
                + "       inner join impressora "
                + "          on itens_imp_dep.id_impressora = impressora.id_imp "
                + "       inner join departamento"
                + "          on itens_imp_dep.id_departamento = departamento.id_departamento"
                + "       where departamento.descr_departamento='" + jComboBoxDepartamento.getSelectedItem() + "'"
                + "       order by impressora.descr_imp");
        jComboBoxImpressora.removeAllItems();
        try {
            conexao.rs.first();
            do {
                jComboBoxImpressora.addItem("" + conexao.rs.getString("descr_imp"));
            } while (conexao.rs.next());
        } catch (SQLException ex) {
        }
        return;
    }

    public void preencherComboCartucho() {
        conexao.executaSQL("select produto.descr_pro "
                + "from itens_imp_car "
                + "inner join produto "
                + "on itens_imp_car.cproduto = produto.id_pro "
                + "inner join impressora "
                + "on itens_imp_car.cimpressora = impressora.id_imp "
                + "inner join itens_imp_dep "
                + "on itens_imp_dep.id_impressora = impressora.id_imp "
                + "inner join departamento "
                + "on departamento.id_departamento = itens_imp_dep.id_departamento "
                + "where impressora.descr_imp='" + jComboBoxImpressora.getSelectedItem() + "'"
                + "and departamento.descr_departamento='" + jComboBoxDepartamento.getSelectedItem() + "'"
                + "       order by produto.descr_pro");
        jComboBoxCartucho.removeAllItems();
        try {
            conexao.rs.first();
            do {
                jComboBoxCartucho.addItem("" + conexao.rs.getString("descr_pro"));
            } while (conexao.rs.next());
        } catch (SQLException ex) {
        }
        return;
    }

    public void SomaCusto() {
        total = 0;
        int qtd = 0;
        float valor = 0;
        conn.executaSQL("select * from itens_sai_car inner join produto "
                + "on itens_sai_car.cproduto = produto.id_pro "
                + "where csai_car=" + codSaida);
        try {
            while (conn.rs.next()) {
                qtd = conn.rs.getInt("quantidade_produto");
                valor = conn.rs.getFloat("pre_pro");
                total = total + conn.rs.getFloat("pre_pro") * conn.rs.getInt("quantidade_produto");
            }
            jTextFieldCusto.setText(String.valueOf(total));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao somar!" + ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jButtonSair = new javax.swing.JButton();
        jButtonFinalizar = new javax.swing.JButton();
        jTextFieldCusto = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldCod = new javax.swing.JTextField();
        jButtonNovo = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButtonIncluir = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jComboBoxCartucho = new javax.swing.JComboBox();
        jComboBoxDepartamento = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldQuantidade = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jComboBoxImpressora = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jFormattedTextFieldData = new javax.swing.JFormattedTextField();

        jButton2.setText("jButton2");

        setTitle("Saída no Estoque / Cartucho");

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane4.setViewportView(tabela);

        jButtonSair.setText("Cancelar");
        jButtonSair.setToolTipText("Sair");
        jButtonSair.setPreferredSize(new java.awt.Dimension(47, 33));
        jButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSairActionPerformed(evt);
            }
        });

        jButtonFinalizar.setText("Finalizar");
        jButtonFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFinalizarActionPerformed(evt);
            }
        });

        jTextFieldCusto.setDisabledTextColor(new java.awt.Color(255, 0, 0));
        jTextFieldCusto.setEnabled(false);

        jLabel7.setText("Custo:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldCusto, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(232, 232, 232)
                .addComponent(jButtonFinalizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonSair, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(205, 205, 205)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSair, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldCusto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jButtonFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 36, Short.MAX_VALUE)))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setText("Código:");

        jTextFieldCod.setDisabledTextColor(new java.awt.Color(0, 0, 51));
        jTextFieldCod.setEnabled(false);

        jButtonNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/1407783863_f016.png"))); // NOI18N
        jButtonNovo.setText("Novo Registro");
        jButtonNovo.setToolTipText("Novo");
        jButtonNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovoActionPerformed(evt);
            }
        });

        jLabel2.setText("Cartucho:");

        jButtonIncluir.setText("Adicionar");
        jButtonIncluir.setToolTipText("Salvar");
        jButtonIncluir.setEnabled(false);
        jButtonIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIncluirActionPerformed(evt);
            }
        });

        jLabel5.setText("Departamento:");

        jComboBoxCartucho.setEnabled(false);

        jComboBoxDepartamento.setEnabled(false);
        jComboBoxDepartamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBoxDepartamentoMouseClicked(evt);
            }
        });

        jLabel3.setText("Impressora:");

        jTextFieldQuantidade.setDisabledTextColor(new java.awt.Color(0, 0, 51));
        jTextFieldQuantidade.setEnabled(false);

        jLabel6.setText("Quantidade:");

        jComboBoxImpressora.setEnabled(false);
        jComboBoxImpressora.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBoxImpressoraMouseClicked(evt);
            }
        });

        jLabel4.setText("Data:");

        jFormattedTextFieldData.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jComboBoxDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jComboBoxImpressora, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldCod, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel5)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jComboBoxCartucho, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel4)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jTextFieldQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jFormattedTextFieldData))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(395, 395, 395)
                        .addComponent(jButtonIncluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldCod, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3))
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxImpressora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6)
                    .addComponent(jLabel4))
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxCartucho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextFieldData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(jButtonIncluir, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoActionPerformed
        // TODO add your handling code here:
        preencherComboDepartamento();
        jTextFieldCod.setText("");
        jTextFieldQuantidade.setText("");
        jFormattedTextFieldData.setText("");
        jComboBoxCartucho.setEnabled(true);
        jComboBoxDepartamento.setEnabled(true);
        jComboBoxImpressora.setEnabled(true);
        jTextFieldQuantidade.setEnabled(true);
        jFormattedTextFieldData.setEnabled(true);
        jButtonIncluir.setEnabled(true);
        jButtonNovo.setEnabled(false);
        try {
            PreparedStatement pst = conn.conn.prepareStatement("insert into saida_cartucho (custo) values (?)");
            pst.setFloat(1, 0);
            pst.execute();
            conn.executaSQL("select currval('saida_cartucho_id_car_seq') id_car");
            conn.rs.first();
            codSaida = conn.rs.getInt("id_car");
        } catch (SQLException ex) {
            Logger.getLogger(MO_0100.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonNovoActionPerformed

    private void jButtonIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIncluirActionPerformed
        try {
            int quantidade = 0;
            conn.conexao();
            conn.executaSQL("select * from produto where descr_pro='" + jComboBoxCartucho.getSelectedItem() + "'");
            conn.rs.first();
            quantidade = conn.rs.getInt("qtd_pro");
            if (quantidade >= Integer.parseInt(jTextFieldQuantidade.getText())) {
                modelo.setCcartucho((String) jComboBoxCartucho.getSelectedItem());
                modelo.setQtd(Integer.parseInt(jTextFieldQuantidade.getText()));
                modelo.setCodigo(codSaida);
                modelo.setHireDate(new java.sql.Timestamp(new java.util.Date().getTime()));
                control.adicionaItem(modelo);
                preencherTabela("select * from produto inner join itens_sai_car "
                        + "on produto.id_pro = itens_sai_car.cproduto inner join saida_cartucho "
                        + "on saida_cartucho.id_car = itens_sai_car.csai_car where saida_cartucho.id_car=" + codSaida);
            } else {
                JOptionPane.showMessageDialog(rootPane, "A quantidade desejada não está disponivel no estoque!");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao Incluir" + ex);
        }
    }//GEN-LAST:event_jButtonIncluirActionPerformed

    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed
        // TODO add your handling code here:
        control.cancelaSaida();
        dispose();

    }

    public void preencherTabela(String SQL) {
        ArrayList dados = new ArrayList();

        String[] Colunas = new String[]{"Cartucho", "Quantidade"};

        conexao.executaSQL(SQL);
        try {
            conexao.rs.first();
            do {
                dados.add(new Object[]{conexao.rs.getString("descr_pro"), conexao.rs.getString("quantidade_produto")});
            } while (conexao.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(rootPane, "Erro" + ex);

        }

        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        tabela.setModel(modelo);
        tabela.getColumnModel().getColumn(0).setPreferredWidth(464);
        tabela.getColumnModel().getColumn(0).setResizable(false);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(77);
        tabela.getColumnModel().getColumn(1).setResizable(false);
        tabela.getTableHeader().setReorderingAllowed(false);
        tabela.setAutoResizeMode(tabela.AUTO_RESIZE_OFF);
        tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        SomaCusto();
    }//GEN-LAST:event_jButtonSairActionPerformed

    private void jComboBoxDepartamentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxDepartamentoMouseClicked
        // TODO add your handling code here:
        preencherComboImpressora();

    }//GEN-LAST:event_jComboBoxDepartamentoMouseClicked

    private void jComboBoxImpressoraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxImpressoraMouseClicked
        // TODO add your handling code here:
        preencherComboCartucho();
    }//GEN-LAST:event_jComboBoxImpressoraMouseClicked

    private void jButtonFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFinalizarActionPerformed
        modelo.setCodigo(codSaida);
        modelo.setCdepartamento((String) jComboBoxDepartamento.getSelectedItem());
        modelo.setCimpressora((String) jComboBoxImpressora.getSelectedItem());
        modelo.setData(jFormattedTextFieldData.getText());
        modelo.setCusto(Float.parseFloat(jTextFieldCusto.getText()));
        control.fechaSaida(modelo);
        JOptionPane.showMessageDialog(rootPane, "Saida finalizada com Sucesso!");
        dispose();
    }//GEN-LAST:event_jButtonFinalizarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonFinalizar;
    private javax.swing.JButton jButtonIncluir;
    private javax.swing.JButton jButtonNovo;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JComboBox jComboBoxCartucho;
    private javax.swing.JComboBox jComboBoxDepartamento;
    private javax.swing.JComboBox jComboBoxImpressora;
    private javax.swing.JFormattedTextField jFormattedTextFieldData;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField jTextFieldCod;
    private javax.swing.JTextField jTextFieldCusto;
    private javax.swing.JTextField jTextFieldQuantidade;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables
}
