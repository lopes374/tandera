/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tandera.visao;

import com.tandera.controle.ConectaBanco;
import com.tandera.controle.ControleCR_0202;
import com.tandera.modelo.ModeloCR_0202;
import com.tandera.modelo.ModeloTabela;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

/**
 *
 * @author alex.lopes
 */
public class CR_0202 extends javax.swing.JInternalFrame {

    ConectaBanco conexao = new ConectaBanco();
    ConectaBanco conn = new ConectaBanco();
    ModeloCR_0202 modelo = new ModeloCR_0202();
    ControleCR_0202 control = new ControleCR_0202();
    int muda = 1;

    /**
     * Creates new form CR_0202
     */
    public CR_0202() {
        initComponents();
        conexao.conexao();
        conn.conexao();
        preencherTabela("select * from itens_col_com inner join colaborador "
            +"on colaborador.id_col = itens_col_com.ccolaborador inner join computador "
            +"on computador.id_com = itens_col_com.ccomputador order by id_cc");
    }

    public void preencherComboColaborador() {
        conexao.executaSQL("select * from colaborador order by nome_col");
        jComboBoxColaborador.removeAllItems();// remove todos os itens da combobox
        try {
            conexao.rs.first();
            do {
                jComboBoxColaborador.addItem(conexao.rs.getString("nome_col"));
            } while (conexao.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao preencher combobox:" + ex);
        }
        return;
    }

    public void preencherComboComputador() {
        conexao.executaSQL("select * from computador order by descr_com");
        jComboBoxComputador.removeAllItems();// remove todos os itens da combobox
        try {
            conexao.rs.first();
            do {
                jComboBoxComputador.addItem(conexao.rs.getString("descr_com"));
            } while (conexao.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao preencher combobox:" + ex);
        }
        return;
    }
    
    public void preencherComboSituacao() {
        conexao.executaSQL("select * from situacao order by descr_sit");
        jComboBoxSituacao.removeAllItems();// remove todos os itens da combobox
        try {
            conexao.rs.first();
            do {
                jComboBoxSituacao.addItem(conexao.rs.getString("descr_sit"));
            } while (conexao.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao preencher combobox:" + ex);
        }
        return;
    }

    public void PesquisaColaborador(int id) {
        conn.executaSQL("select * from colaborador order by nome_col");
        jComboBoxColaborador.removeAllItems();// remove todos os itens da combobox
        int codigo, idx;
        idx = 0;
        try {
            conn.rs.first();
            do {
                jComboBoxColaborador.addItem(conn.rs.getString("nome_col"));
                codigo = conn.rs.getInt("id_col");
                if (codigo == id) {
                    idx = jComboBoxColaborador.getItemCount() - 1;
                }
            } while (conn.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao preencher combobox impressora:" + ex);
        }
        jComboBoxColaborador.setSelectedIndex(idx);

        return;
    }

    public void PesquisaComputador(int id) {
        conn.executaSQL("select * from computador order by descr_com");
        jComboBoxComputador.removeAllItems();// remove todos os itens da combobox
        int codigo, idx;
        idx = 0;
        try {
            conn.rs.first();
            do {
                jComboBoxComputador.addItem(conn.rs.getString("descr_com"));
                codigo = conn.rs.getInt("id_com");
                if (codigo == id) {
                    idx = jComboBoxComputador.getItemCount() - 1;
                }
            } while (conn.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao preencher combobox impressora:" + ex);
        }
        jComboBoxComputador.setSelectedIndex(idx);

        return;
    }
    
    public void PesquisaSituacao(int id) {
        conn.executaSQL("select * from situacao order by descr_sit");
        jComboBoxSituacao.removeAllItems();// remove todos os itens da combobox
        int codigo, idx;
        idx = 0;
        try {
            conn.rs.first();
            do {
                jComboBoxSituacao.addItem(conn.rs.getString("descr_sit"));
                codigo = conn.rs.getInt("id_sit");
                if (codigo == id) {
                    idx = jComboBoxSituacao.getItemCount() - 1;
                }
            } while (conn.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao preencher combobox impressora:" + ex);
        }
        jComboBoxSituacao.setSelectedIndex(idx);

        return;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldCod = new javax.swing.JTextField();
        jButtonNovo = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButtonIncluir = new javax.swing.JButton();
        jButtonAlterar = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();
        jButtonSair = new javax.swing.JButton();
        jComboBoxColaborador = new javax.swing.JComboBox();
        jComboBoxComputador = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jComboBoxSituacao = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();

        setTitle("Relacionamento Colaborado Computador");

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
        tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tabela);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 226, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE))
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

        jLabel2.setText("Colaborador:");

        jButtonIncluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/1407784049_f0c7.png"))); // NOI18N
        jButtonIncluir.setText("Salvar");
        jButtonIncluir.setToolTipText("Salvar");
        jButtonIncluir.setEnabled(false);
        jButtonIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIncluirActionPerformed(evt);
            }
        });

        jButtonAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/1407783766_f040.png"))); // NOI18N
        jButtonAlterar.setText("Alterar");
        jButtonAlterar.setToolTipText("Editar");
        jButtonAlterar.setEnabled(false);
        jButtonAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAlterarActionPerformed(evt);
            }
        });

        jButtonExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/1407783681_f057.png"))); // NOI18N
        jButtonExcluir.setText("Excluir");
        jButtonExcluir.setToolTipText("Deletar");
        jButtonExcluir.setEnabled(false);
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });

        jButtonSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/1407783331_f090.png"))); // NOI18N
        jButtonSair.setText("Sair");
        jButtonSair.setToolTipText("Sair");
        jButtonSair.setPreferredSize(new java.awt.Dimension(47, 33));
        jButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSairActionPerformed(evt);
            }
        });

        jComboBoxColaborador.setEnabled(false);
        jComboBoxColaborador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBoxColaboradorMouseClicked(evt);
            }
        });
        jComboBoxColaborador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxColaboradorActionPerformed(evt);
            }
        });

        jComboBoxComputador.setEnabled(false);

        jLabel3.setText("Computador:");

        jComboBoxSituacao.setEnabled(false);

        jLabel4.setText("Situação:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldCod, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jComboBoxColaborador, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jComboBoxComputador, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jButtonIncluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonAlterar)
                        .addGap(10, 10, 10)
                        .addComponent(jButtonExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonSair, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldCod, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBoxSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4))
                    .addComponent(jLabel1))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxColaborador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxComputador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(jButtonSair, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButtonAlterar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jButtonIncluir, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addGap(6, 6, 6)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked
        // TODO add your handling code here:
        String descr = "" + tabela.getValueAt(tabela.getSelectedRow(), 0);
        conexao.conexao();
        conexao.executaSQL("select * from itens_col_com where id_cc =" + descr);
        try {
            conexao.rs.first();
            jTextFieldCod.setText(String.valueOf(conexao.rs.getInt("id_cc")));
            PesquisaColaborador(conexao.rs.getInt("ccolaborador"));
            PesquisaComputador(conexao.rs.getInt("ccomputador"));
            PesquisaSituacao(conexao.rs.getInt("csituacao"));
            jButtonAlterar.setEnabled(true);
            jButtonExcluir.setEnabled(true);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao selecionar os dados!\nERRO:" + ex);
        }
    }//GEN-LAST:event_tabelaMouseClicked

    private void jButtonNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoActionPerformed
        // TODO add your handling code here:
        preencherComboColaborador();
        preencherComboComputador();
        preencherComboSituacao();
        muda = 1;
        jTextFieldCod.setText("");
        jComboBoxColaborador.setEnabled(true);
        jComboBoxComputador.setEnabled(true);
        jComboBoxSituacao.setEnabled(true);
        jButtonAlterar.setEnabled(false);
        jButtonExcluir.setEnabled(false);
        jButtonIncluir.setEnabled(true);
        jButtonNovo.setEnabled(false);
    }//GEN-LAST:event_jButtonNovoActionPerformed

    private void jButtonIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIncluirActionPerformed
        if (muda == 1) {
            modelo.setCcolaborador((String) jComboBoxColaborador.getSelectedItem());
            modelo.setCcomputador((String) jComboBoxComputador.getSelectedItem());
            control.InserirRE_0202(modelo);
            preencherTabela("select * from itens_col_com inner join colaborador "
            +"on colaborador.id_col = itens_col_com.ccolaborador inner join computador "
            +"on computador.id_com = itens_col_com.ccomputador order by id_cc");
        } else {
            modelo.setCcolaborador((String) jComboBoxColaborador.getSelectedItem());
            modelo.setCcomputador((String) jComboBoxComputador.getSelectedItem());
            control.AlteraRE_0202(modelo);
            preencherTabela("select * from itens_col_com inner join colaborador "
            +"on colaborador.id_col = itens_col_com.ccolaborador inner join computador "
            +"on computador.id_com = itens_col_com.ccomputador order by id_cc");
        }
        jTextFieldCod.setText("");
        jComboBoxColaborador.removeAllItems();
        jComboBoxComputador.removeAllItems();
        jComboBoxColaborador.setEnabled(false);
        jComboBoxComputador.setEnabled(false);
        jButtonAlterar.setEnabled(false);
        jButtonExcluir.setEnabled(false);
        jButtonIncluir.setEnabled(false);
        jButtonNovo.setEnabled(true);
    }//GEN-LAST:event_jButtonIncluirActionPerformed

    private void jButtonAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlterarActionPerformed
        try {
            // TODO add your handling code here:
            modelo.setCodigo(Integer.parseInt(jTextFieldCod.getText()));
            modelo.setCcolaborador((String) jComboBoxColaborador.getSelectedItem());
            modelo.setCcomputador((String) jComboBoxComputador.getSelectedItem());
            muda = 2;
            PesquisaColaborador(conexao.rs.getInt("ccolaborador"));
            PesquisaComputador(conexao.rs.getInt("ccomputador"));
            jComboBoxColaborador.setEnabled(true);
            jComboBoxComputador.setEnabled(true);
            jButtonAlterar.setEnabled(false);
            jButtonExcluir.setEnabled(false);
            jButtonIncluir.setEnabled(true);
            jButtonNovo.setEnabled(false);
            preencherTabela("select * from itens_col_com inner join colaborador "
            +"on colaborador.id_col = itens_col_com.ccolaborador inner join computador "
            +"on computador.id_com = itens_col_com.ccomputador order by id_cc");
        } catch (SQLException ex) {
//            Logger.getLogger(CA_0102.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonAlterarActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        modelo.setCodigo(Integer.parseInt(jTextFieldCod.getText()));
        control.ExcluirRE_0202(modelo);
        preencherTabela("select * from itens_col_com inner join colaborador "
            +"on colaborador.id_col = itens_col_com.ccolaborador inner join computador "
            +"on computador.id_com = itens_col_com.ccomputador order by id_cc");
        jTextFieldCod.setText("");
        jComboBoxColaborador.removeAllItems();
        jComboBoxComputador.removeAllItems();
        jComboBoxColaborador.setEnabled(false);
        jComboBoxComputador.setEnabled(false);
        jButtonAlterar.setEnabled(false);
        jButtonExcluir.setEnabled(false);
        jButtonIncluir.setEnabled(false);
        jButtonNovo.setEnabled(true);
    }//GEN-LAST:event_jButtonExcluirActionPerformed

    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed
        // TODO add your handling code here:
        dispose();

    }

    public void preencherTabela(String SQL) {
        ArrayList dados = new ArrayList();

        String[] Colunas = new String[]{"Codigo", "Colaborador", "Computador"};

        conexao.executaSQL(SQL);
        try {
            conexao.rs.first();
            do {
                dados.add(new Object[]{conexao.rs.getInt("id_cc"), conexao.rs.getString("nome_col"), conexao.rs.getString("descr_com")});
            } while (conexao.rs.next());
        } catch (SQLException ex) {

        }

        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        tabela.setModel(modelo);
        tabela.getColumnModel().getColumn(0).setPreferredWidth(43);
        tabela.getColumnModel().getColumn(0).setResizable(false);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(233);
        tabela.getColumnModel().getColumn(1).setResizable(false);
        tabela.getColumnModel().getColumn(2).setPreferredWidth(233);
        tabela.getColumnModel().getColumn(2).setResizable(false);
        tabela.getTableHeader().setReorderingAllowed(false);
        tabela.setAutoResizeMode(tabela.AUTO_RESIZE_OFF);
        tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }//GEN-LAST:event_jButtonSairActionPerformed

    private void jComboBoxColaboradorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxColaboradorMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxColaboradorMouseClicked

    private void jComboBoxColaboradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxColaboradorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxColaboradorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAlterar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonIncluir;
    private javax.swing.JButton jButtonNovo;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JComboBox jComboBoxColaborador;
    private javax.swing.JComboBox jComboBoxComputador;
    private javax.swing.JComboBox jComboBoxSituacao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField jTextFieldCod;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables
}
