/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tandera.visao;

import com.tandera.controle.ConectaBanco;
import com.tandera.controle.ControleCA_0102;
import com.tandera.modelo.ModeloTabela;
import com.tandera.modelo.ModeloCA_0102;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

/**
 *
 * @author alex.lopes
 */
public class CA_0102 extends javax.swing.JInternalFrame {
    
    ConectaBanco conexao = new ConectaBanco();
    ConectaBanco conn = new ConectaBanco();
    ModeloCA_0102 modelo = new ModeloCA_0102();
    ControleCA_0102 control = new ControleCA_0102();
    int muda=1;

    /**
     * Creates new form CA_0102
     */
    public CA_0102() {
        initComponents();
        conexao.conexao();
        conn.conexao();
        preencherTabela("select * from produto order by id_pro");
        tabela.setAutoCreateRowSorter(true);
    }
    
    public void preencherComboGrupo() {    
  
          conexao.executaSQL("select * from grupos order by descr_grupo");
        jComboBoxGrupo.removeAllItems();// remove todos os itens da combobox
        try{
            conexao.rs.first();
            do {
                jComboBoxGrupo.addItem(conexao.rs.getString("descr_grupo"));
            } while (conexao.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao preencher combobox Grupo:" + ex);
        }
        return;
    }
    public void preencherComboSgrupo() {
        conexao.executaSQL("select sgrupos.descr_sgrupo "
                    + "        from grupos "
                    + "       inner join sgrupos "
                    + "          on sgrupos.cgrupo = grupos.id_grupo "
                    + "       where grupos.descr_grupo='"+ jComboBoxGrupo.getSelectedItem()+"'"
                    + "       order by sgrupos.descr_sgrupo");
        jComboBoxSgrupo.removeAllItems();
        try {
            conexao.rs.first();
          do{
              jComboBoxSgrupo.addItem("" + conexao.rs.getString("descr_sgrupo"));
            }while(conexao.rs.next());
        } catch (SQLException ex) {
           //JOptionPane.showMessageDialog(rootPane, "Erro ao preencher combobox Sub-Grupo:" + ex);
        }  
        return;
    }
    
    public void preencherComboFornecedor() {    
        conexao.executaSQL("select * from fornecedor order by nom_for");
        jComboBoxFornecedor.removeAllItems();// remove todos os itens da combobox
        try{
            conexao.rs.first();
            do {
                jComboBoxFornecedor.addItem(conexao.rs.getString("nom_for"));
            } while (conexao.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao preencher combobox Fornecedor:" + ex);
        }
        return;
    }
    
    public void PesquisaGrupo(int id) {  
        conn.executaSQL("select * from grupos order by descr_grupo");
        jComboBoxGrupo.removeAllItems();// remove todos os itens da combobox
        int id_grupo, idx;
        idx = 0;
        try{
            conn.rs.first();
            do {
                jComboBoxGrupo.addItem(conn.rs.getString("descr_grupo"));
                id_grupo = conn.rs.getInt("id_grupo");
                if ( id_grupo == id) {
                   idx = jComboBoxGrupo.getItemCount() -1;
                }
            } while (conn.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao preencher combobox Grupo:" + ex);
        }
        jComboBoxGrupo.setSelectedIndex(idx);
        
        return;
    }
    
    public void PesquisaSgrupo(int id) {  
        conn.executaSQL("select * from sgrupos where id_sgrupo=" + id);
        jComboBoxSgrupo.removeAllItems();// remove todos os itens da combobox
        try{
            conn.rs.first();
            do {
                jComboBoxSgrupo.addItem(conn.rs.getString("descr_sgrupo"));
            } while (conn.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao preencher combobox Sub-grupo:" + ex);
        }
        return;
    }
    
    public void PesquisaFornecedor(int id) {  
        conn.executaSQL("select * from fornecedor order by nom_for");
        jComboBoxFornecedor.removeAllItems();// remove todos os itens da combobox
        int id_fornecedor, idx;
        idx = 0;
        try{
            conn.rs.first();
            do {
                jComboBoxFornecedor.addItem(conn.rs.getString("nom_for"));
                id_fornecedor = conn.rs.getInt("id_for");
                if ( id_fornecedor == id) {
                   idx = jComboBoxFornecedor.getItemCount() -1;
                }
            } while (conn.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao preencher combobox:" + ex);
        }
        jComboBoxFornecedor.setSelectedIndex(idx);
        
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        jPanel4 = new javax.swing.JPanel();
        jTabbedPaneComposicao = new javax.swing.JTabbedPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tabela1 = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jTextField1 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldCod = new javax.swing.JTextField();
        jButtonNovo = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButtonIncluir = new javax.swing.JButton();
        jButtonAlterar = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();
        jButtonSair = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jComboBoxGrupo = new javax.swing.JComboBox();
        jComboBoxSgrupo = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldDescr = new javax.swing.JTextField();
        jComboBoxFornecedor = new javax.swing.JComboBox();
        jTextFieldPreco = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldEstoque = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldCp = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();

        jScrollPane1.setViewportView(jEditorPane1);

        setTitle("Cadastro de Produtos");

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

        jTabbedPaneComposicao.addTab("Produtos", jScrollPane4);

        tabela1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tabela1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabela1MouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tabela1);

        jLabel7.setText("Produto:");

        jLabel9.setText("Situação:");

        jLabel11.setText("QTD:");

        jButton1.setText("V. Estoque");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Desativar");

        jButton3.setText("Adicionar");

        jLabel12.setText("Motivo:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jTextField2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(0, 26, Short.MAX_VALUE))
                            .addComponent(jTextField1)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9)
                    .addComponent(jLabel11))
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(jLabel12)
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(115, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addGap(0, 96, Short.MAX_VALUE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jTabbedPaneComposicao.addTab("Composição", jPanel2);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jTabbedPaneComposicao)
                .addGap(0, 0, 0))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPaneComposicao, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
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

        jLabel2.setText("Grupo");

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

        jLabel5.setText("Descrição:");

        jLabel8.setText("Fornecedor:");

        jComboBoxGrupo.setEnabled(false);
        jComboBoxGrupo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBoxGrupoMouseClicked(evt);
            }
        });
        jComboBoxGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxGrupoActionPerformed(evt);
            }
        });

        jComboBoxSgrupo.setEnabled(false);

        jLabel3.setText("Sub-Grupo");

        jTextFieldDescr.setDisabledTextColor(new java.awt.Color(0, 0, 51));
        jTextFieldDescr.setEnabled(false);

        jComboBoxFornecedor.setEnabled(false);

        jTextFieldPreco.setDisabledTextColor(new java.awt.Color(0, 0, 51));
        jTextFieldPreco.setEnabled(false);

        jLabel4.setText("Preço Compra:");

        jTextFieldEstoque.setDisabledTextColor(new java.awt.Color(0, 0, 51));
        jTextFieldEstoque.setEnabled(false);

        jLabel6.setText("Estoque:");

        jTextFieldCp.setDisabledTextColor(new java.awt.Color(0, 0, 51));
        jTextFieldCp.setEnabled(false);

        jLabel10.setText("CP:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldCod, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jComboBoxGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jComboBoxSgrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jComboBoxFornecedor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jTextFieldPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jTextFieldEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldDescr, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jTextFieldCp)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jButtonIncluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonAlterar)
                        .addGap(10, 10, 10)
                        .addComponent(jButtonExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonSair, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10))
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
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxSgrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, 0)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldDescr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldCp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButtonExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addComponent(jButtonSair, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButtonAlterar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jButtonIncluir, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel10))
                .addGap(11, 11, 11))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoActionPerformed
        // TODO add your handling code here:
        preencherComboGrupo();
        preencherComboSgrupo();
        preencherComboFornecedor();
        muda = 1;
        jTextFieldCod.setText("");
        jTextFieldDescr.setText("");
        jTextFieldPreco.setText("");
        jTextFieldEstoque.setText("");
        jTextFieldCp.setText("");
        jComboBoxGrupo.setEnabled(true);
        jComboBoxSgrupo.setEnabled(true);
        jTextFieldDescr.setEnabled(true);
        jComboBoxFornecedor.setEnabled(true);
        jTextFieldPreco.setEnabled(true);
        jTextFieldCp.setEnabled(true);
        jButtonAlterar.setEnabled(false);
        jButtonExcluir.setEnabled(false);
        jButtonIncluir.setEnabled(true);
        jButtonNovo.setEnabled(false);
    }//GEN-LAST:event_jButtonNovoActionPerformed

    private void jButtonIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIncluirActionPerformed
        if (muda==1){
            modelo.setCgrupo((String)jComboBoxGrupo.getSelectedItem());
            modelo.setCsgrupo((String)jComboBoxSgrupo.getSelectedItem());
            modelo.setDescr(jTextFieldDescr.getText());
            modelo.setCfornecedor((String)jComboBoxFornecedor.getSelectedItem());
            modelo.setPreco(Float.parseFloat(jTextFieldPreco.getText()));
            modelo.setHireDate(new java.sql.Timestamp(new java.util.Date().getTime()));
            modelo.setCp(jTextFieldCp.getText());
            control.InserirCA_0102(modelo);
            preencherTabela("select * from produto order by id_pro");
        } else {
            modelo.setCgrupo((String)jComboBoxGrupo.getSelectedItem());
            modelo.setCsgrupo((String)jComboBoxSgrupo.getSelectedItem());
            modelo.setDescr(jTextFieldDescr.getText());
            modelo.setCfornecedor((String)jComboBoxFornecedor.getSelectedItem());
            modelo.setPreco(Float.parseFloat(jTextFieldPreco.getText()));
            modelo.setEstoque(Integer.parseInt(jTextFieldEstoque.getText()));
            modelo.setHireDate(new java.sql.Timestamp(new java.util.Date().getTime()));
            modelo.setCp(jTextFieldCp.getText());
            control.AlteraCA_0102(modelo);
            preencherTabela("select * from produto order by id_pro");
        }
        jTextFieldCod.setText("");
        jTextFieldDescr.setText("");
        jTextFieldPreco.setText("");
        jTextFieldEstoque.setText("");
        jTextFieldCp.setText("");
        jComboBoxGrupo.removeAllItems();
        jComboBoxSgrupo.removeAllItems();
        jComboBoxFornecedor.removeAllItems();
        jComboBoxGrupo.setEnabled(false);
        jComboBoxSgrupo.setEnabled(false);
        jTextFieldDescr.setEnabled(false);
        jComboBoxFornecedor.setEnabled(false);
        jTextFieldPreco.setEnabled(false);
        jTextFieldCp.setEnabled(false);
        jButtonAlterar.setEnabled(false);
        jButtonExcluir.setEnabled(false);
        jButtonIncluir.setEnabled(false);
        jButtonNovo.setEnabled(true);
    }//GEN-LAST:event_jButtonIncluirActionPerformed

    private void jButtonAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlterarActionPerformed
        try {
            // TODO add your handling code here:
            modelo.setCodigo(Integer.parseInt(jTextFieldCod.getText()));
            modelo.setCgrupo((String)jComboBoxGrupo.getSelectedItem());
            modelo.setCsgrupo((String)jComboBoxSgrupo.getSelectedItem());
            modelo.setDescr(jTextFieldDescr.getText());
            modelo.setCfornecedor((String)jComboBoxFornecedor.getSelectedItem());
            modelo.setPreco(Float.parseFloat(jTextFieldPreco.getText()));
            modelo.setHireDate(new java.sql.Timestamp(new java.util.Date().getTime()));
            modelo.setCp(jTextFieldCp.getText());
            muda = 2;
            PesquisaGrupo(conexao.rs.getInt("cgrupo"));
            PesquisaSgrupo(conexao.rs.getInt("csgrupo"));
            PesquisaFornecedor(conexao.rs.getInt("cfornecedor"));
            jComboBoxGrupo.setEnabled(true);
            jComboBoxSgrupo.setEnabled(true);
            jTextFieldDescr.setEnabled(true);
            jComboBoxFornecedor.setEnabled(true);
            jTextFieldPreco.setEnabled(true);
            jTextFieldCp.setEnabled(true);
            jButtonAlterar.setEnabled(false);
            jButtonExcluir.setEnabled(false);
            jButtonIncluir.setEnabled(true);
            jButtonNovo.setEnabled(false);
            preencherTabela("select * from produto order by id_pro");
        } catch (SQLException ex) {
            Logger.getLogger(CA_0102.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonAlterarActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        modelo.setCodigo(Integer.parseInt(jTextFieldCod.getText()));
        control.ExcluirCA_0102(modelo);
        preencherTabela("select * from produto order by id_pro");
        jTextFieldCod.setText("");
        jTextFieldDescr.setText("");
        jTextFieldPreco.setText("");
        jTextFieldEstoque.setText("");
        jTextFieldCp.setText("");
        jComboBoxGrupo.removeAllItems();
        jComboBoxSgrupo.removeAllItems();
        jComboBoxFornecedor.removeAllItems();
        jComboBoxGrupo.setEnabled(false);
        jComboBoxSgrupo.setEnabled(false);
        jTextFieldDescr.setEnabled(false);
        jComboBoxFornecedor.setEnabled(false);
        jTextFieldPreco.setEnabled(false);
        jTextFieldCp.setEnabled(false);
        jButtonAlterar.setEnabled(false);
        jButtonExcluir.setEnabled(false);
        jButtonIncluir.setEnabled(false);
        jButtonNovo.setEnabled(true);
    }//GEN-LAST:event_jButtonExcluirActionPerformed

    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed
        // TODO add your handling code here:
        dispose();

        }

        public void preencherTabela(String SQL){
            ArrayList dados = new ArrayList();

            String [] Colunas = new String[]{"Codigo","Descrição", "Estoque"};

            conexao.executaSQL(SQL);
            try {
                conexao.rs.first();
                do{
                    dados.add(new Object[]{conexao.rs.getInt("id_pro"), conexao.rs.getString("descr_pro"), conexao.rs.getString("qtd_pro")});
                }while(conexao.rs.next());
            } catch (SQLException ex) {
                
            }

            ModeloTabela modelo = new ModeloTabela (dados, Colunas);
            tabela.setModel (modelo);
            tabela.getColumnModel().getColumn(0).setPreferredWidth(48);
            tabela.getColumnModel().getColumn(0).setResizable(false);
            tabela.getColumnModel().getColumn(1).setPreferredWidth(405);
            tabela.getColumnModel().getColumn(1).setResizable(false);
            tabela.getColumnModel().getColumn(2).setPreferredWidth(50);
            tabela.getColumnModel().getColumn(2).setResizable(false);
            tabela.getTableHeader().setReorderingAllowed(false);
            tabela.setAutoResizeMode(tabela.AUTO_RESIZE_OFF);
            tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }//GEN-LAST:event_jButtonSairActionPerformed

    private void jComboBoxGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxGrupoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxGrupoActionPerformed

    private void jComboBoxGrupoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxGrupoMouseClicked
        // TODO add your handling code here:
        preencherComboSgrupo();
    }//GEN-LAST:event_jComboBoxGrupoMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tabela1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabela1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tabela1MouseClicked

    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked
        // TODO add your handling code here:
        String descr = ""+tabela.getValueAt(tabela.getSelectedRow(), 0);
        conexao.conexao();
        conexao.executaSQL("select * from produto where id_pro =" + descr);
        try {
            conexao.rs.first();
            jTextFieldCod.setText(String.valueOf(conexao.rs.getInt("id_pro")));
            PesquisaGrupo(conexao.rs.getInt("cgrupo"));
            PesquisaSgrupo(conexao.rs.getInt("csgrupo"));
            jTextFieldDescr.setText(conexao.rs.getString("descr_pro"));
            PesquisaFornecedor(conexao.rs.getInt("cfornecedor"));
            jTextFieldPreco.setText(conexao.rs.getString("pre_pro"));
            jTextFieldEstoque.setText(conexao.rs.getString("qtd_pro"));
            jTextFieldCp.setText(conexao.rs.getString("cp_pro"));
            jButtonAlterar.setEnabled(true);
            jButtonExcluir.setEnabled(true);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao selecionar os dados!\nERRO:" + ex);
        }
    }//GEN-LAST:event_tabelaMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButtonAlterar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonIncluir;
    private javax.swing.JButton jButtonNovo;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBoxFornecedor;
    private javax.swing.JComboBox jComboBoxGrupo;
    private javax.swing.JComboBox jComboBoxSgrupo;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPaneComposicao;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextFieldCod;
    private javax.swing.JTextField jTextFieldCp;
    private javax.swing.JTextField jTextFieldDescr;
    private javax.swing.JTextField jTextFieldEstoque;
    private javax.swing.JTextField jTextFieldPreco;
    private javax.swing.JTable tabela;
    private javax.swing.JTable tabela1;
    // End of variables declaration//GEN-END:variables
}
