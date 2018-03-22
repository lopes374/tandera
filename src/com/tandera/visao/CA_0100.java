/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tandera.visao;

import com.tandera.controle.ConectaBanco;
import com.tandera.controle.ControleCA_0100;
import com.tandera.modelo.ModeloTabela;
import com.tandera.modelo.ModeloCA_0100;
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
public class CA_0100 extends javax.swing.JInternalFrame {
    
    ConectaBanco conexao = new ConectaBanco();
    ConectaBanco conn = new ConectaBanco();
    ModeloCA_0100 modelo = new ModeloCA_0100();
    ControleCA_0100 control = new ControleCA_0100();
    int muda=1;

    /**
     * Creates new form CA_0100
     */
    public CA_0100() {
        initComponents();
        conexao.conexao();
        preencherTabela("select * from colaborador order by id_col");
        try {
            MaskFormatter telefone = new MaskFormatter("(##)####-####");
            jFormattedTextFieldTelefone.setFormatterFactory(new DefaultFormatterFactory(telefone));
            MaskFormatter admissao = new MaskFormatter("##/##/####");
            jFormattedTextFieldAdmissao.setFormatterFactory(new DefaultFormatterFactory(admissao));
            MaskFormatter nascimento = new MaskFormatter("##/##/####");
            jFormattedTextFieldNascimento.setFormatterFactory(new DefaultFormatterFactory(nascimento));
            MaskFormatter rg = new MaskFormatter("##.###.###-#");
            jFormattedTextFieldRG.setFormatterFactory(new DefaultFormatterFactory(rg));
            MaskFormatter cpf = new MaskFormatter("###.###.###-##");
            jFormattedTextFieldCPF.setFormatterFactory(new DefaultFormatterFactory(cpf));
        } catch (ParseException ex) {
            //Logger.getLogger(FrmFornecedor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void preencherComboSexo() {    
        conexao.executaSQL("select * from sexo order by descr_sexo");
        jComboBoxSexo.removeAllItems();// remove todos os itens da combobox
        try{
            conexao.rs.first();
            do {
                jComboBoxSexo.addItem(conexao.rs.getString("descr_sexo"));
            } while (conexao.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao preencher combobox:" + ex);
        }
        return;
    }
    
    public void preencherComboDepartamento() {    
        conexao.executaSQL("select * from departamento order by descr_departamento");
        jComboBoxDepartamento.removeAllItems();// remove todos os itens da combobox
        try{
            conexao.rs.first();
            do {
                jComboBoxDepartamento.addItem(conexao.rs.getString("descr_departamento"));
            } while (conexao.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao preencher combobox:" + ex);
        }
        return;
    }
    
    public void PesquisaSexo(int id) {  
        conn.executaSQL("select * from sexo order by descr_sexo");
        jComboBoxSexo.removeAllItems();// remove todos os itens da combobox
        int id_sexo, idx;
        idx = 0;
        try{
            conn.rs.first();
            do {
                jComboBoxSexo.addItem(conn.rs.getString("descr_sexo"));
                id_sexo = conn.rs.getInt("id_sexo");
                if ( id_sexo == id) {
                   idx = jComboBoxSexo.getItemCount() -1;
                }
            } while (conn.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao preencher combobox:" + ex);
        }
        jComboBoxSexo.setSelectedIndex(idx);
        
        return;
    }
    
    public void PesquisaDepartamento(int id) {  
        conn.executaSQL("select * from departamento order by descr_departamento");
        jComboBoxDepartamento.removeAllItems();// remove todos os itens da combobox
        int id_departamento, idx;
        idx = 0;
        try{
            conn.rs.first();
            do {
                jComboBoxDepartamento.addItem(conn.rs.getString("descr_departamento"));
                id_departamento = conn.rs.getInt("id_departamento");
                if ( id_departamento == id) {
                   idx = jComboBoxDepartamento.getItemCount() -1;
                }
            } while (conn.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao preencher combobox:" + ex);
        }
        jComboBoxDepartamento.setSelectedIndex(idx);
        
        return;
    }
    
    public void preencherComboSituacao() {    
        conexao.executaSQL("select * from situacao order by descr_sit");
        jComboBoxSituacao.removeAllItems();// remove todos os itens da combobox
        try{
            conexao.rs.first();
            do {
                jComboBoxSituacao.addItem(conexao.rs.getString("descr_sit"));
            } while (conexao.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao preencher combobox:" + ex);
        }
        return;
    }
    
    public void PesquisaSituacao(int id) {  
        conn.executaSQL("select * from situacao order by descr_sit");
        jComboBoxSituacao.removeAllItems();// remove todos os itens da combobox
        int id_sit, idx;
        idx = 0;
        try{
            conn.rs.first();
            do {
                jComboBoxSituacao.addItem(conn.rs.getString("descr_sit"));
                id_sit = conn.rs.getInt("id_sit");
                if ( id_sit == id) {
                   idx = jComboBoxSituacao.getItemCount() -1;
                }
            } while (conn.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao preencher combobox:" + ex);
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
        jTextFieldNome = new javax.swing.JTextField();
        jButtonIncluir = new javax.swing.JButton();
        jButtonAlterar = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();
        jButtonSair = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jComboBoxSexo = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldFuncao = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jComboBoxDepartamento = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldCracha = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jFormattedTextFieldTelefone = new javax.swing.JFormattedTextField();
        jFormattedTextFieldAdmissao = new javax.swing.JFormattedTextField();
        jFormattedTextFieldNascimento = new javax.swing.JFormattedTextField();
        jFormattedTextFieldRG = new javax.swing.JFormattedTextField();
        jFormattedTextFieldCPF = new javax.swing.JFormattedTextField();
        jTextFieldCtps = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jComboBoxSituacao = new javax.swing.JComboBox();

        setTitle("Cadastro de Colaboradores");

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

        jLabel2.setText("Nome:");

        jTextFieldNome.setDisabledTextColor(new java.awt.Color(0, 0, 51));
        jTextFieldNome.setEnabled(false);

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

        jLabel3.setText("Sexo:");

        jComboBoxSexo.setEnabled(false);
        jComboBoxSexo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxSexoActionPerformed(evt);
            }
        });

        jLabel4.setText("Telefone:");

        jLabel5.setText("Função:");

        jTextFieldFuncao.setDisabledTextColor(new java.awt.Color(0, 0, 51));
        jTextFieldFuncao.setEnabled(false);

        jLabel6.setText("Departamento");

        jComboBoxDepartamento.setEnabled(false);
        jComboBoxDepartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxDepartamentoActionPerformed(evt);
            }
        });

        jLabel7.setText("Cracha:");

        jTextFieldCracha.setDisabledTextColor(new java.awt.Color(0, 0, 51));
        jTextFieldCracha.setEnabled(false);

        jLabel8.setText("Data Admissão:");

        jLabel9.setText("Data Nascimento:");

        jLabel10.setText("RG:");

        jLabel11.setText("CPF:");

        jFormattedTextFieldTelefone.setDisabledTextColor(new java.awt.Color(0, 0, 51));
        jFormattedTextFieldTelefone.setEnabled(false);

        jFormattedTextFieldAdmissao.setDisabledTextColor(new java.awt.Color(0, 0, 51));
        jFormattedTextFieldAdmissao.setEnabled(false);

        jFormattedTextFieldNascimento.setDisabledTextColor(new java.awt.Color(0, 0, 51));
        jFormattedTextFieldNascimento.setEnabled(false);

        jFormattedTextFieldRG.setDisabledTextColor(new java.awt.Color(0, 0, 51));
        jFormattedTextFieldRG.setEnabled(false);

        jFormattedTextFieldCPF.setDisabledTextColor(new java.awt.Color(0, 0, 51));
        jFormattedTextFieldCPF.setEnabled(false);

        jTextFieldCtps.setDisabledTextColor(new java.awt.Color(0, 0, 51));
        jTextFieldCtps.setEnabled(false);

        jLabel12.setText("CTPS:");

        jLabel13.setText("Situação:");

        jComboBoxSituacao.setEnabled(false);

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
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jFormattedTextFieldAdmissao, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jFormattedTextFieldNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jFormattedTextFieldRG, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jFormattedTextFieldCPF)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(363, 363, 363)
                                        .addComponent(jLabel3))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jComboBoxSexo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextFieldFuncao, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel5))
                                        .addGap(6, 6, 6)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addComponent(jComboBoxDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(10, 10, 10)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel4)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextFieldCracha, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel7))
                                        .addGap(6, 6, 6)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel12)
                                            .addComponent(jTextFieldCtps, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)))
                                    .addComponent(jFormattedTextFieldTelefone))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldCod, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(135, 135, 135)
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
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13)
                        .addComponent(jComboBoxSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextFieldTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldFuncao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldCracha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldCtps, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFormattedTextFieldAdmissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextFieldNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextFieldRG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextFieldCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
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
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        String descr = ""+tabela.getValueAt(tabela.getSelectedRow(), 0);
        conexao.conexao();
        conn.conexao();
        conexao.executaSQL("select * from colaborador where id_col =" + descr);
        try {
            conexao.rs.first();
            jTextFieldCod.setText(String.valueOf(conexao.rs.getInt("id_col")));
            jTextFieldNome.setText(conexao.rs.getString("nome_col"));
            PesquisaSexo(conexao.rs.getInt("csexo"));
            jFormattedTextFieldTelefone.setText(conexao.rs.getString("tel_col"));
            jTextFieldFuncao.setText(conexao.rs.getString("fun_col"));
            PesquisaDepartamento(conexao.rs.getInt("cdepartamento"));
            jTextFieldCracha.setText(conexao.rs.getString("cracha_col"));
            jFormattedTextFieldAdmissao.setText(conexao.rs.getString("adm_col"));
            jFormattedTextFieldNascimento.setText(conexao.rs.getString("nas_col"));
            jFormattedTextFieldRG.setText(conexao.rs.getString("rg_col"));
            jFormattedTextFieldCPF.setText(conexao.rs.getString("cpf_col"));
            jTextFieldCtps.setText(conexao.rs.getString("ctps_col"));
            PesquisaSituacao(conexao.rs.getInt("csituacao"));
            jButtonAlterar.setEnabled(true);
            jButtonExcluir.setEnabled(true);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao selecionar os dados!\nERRO:" + ex);
        }
    }//GEN-LAST:event_tabelaMouseClicked

    private void jButtonNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoActionPerformed
        // TODO add your handling code here:
        preencherComboSexo();
        preencherComboDepartamento();
        preencherComboSituacao();
        muda = 1;
        jTextFieldCod.setText("");
        jTextFieldNome.setText("");
        jFormattedTextFieldTelefone.setText("");
        jTextFieldFuncao.setText("");
        jTextFieldCracha.setText("");
        jFormattedTextFieldAdmissao.setText("");
        jFormattedTextFieldNascimento.setText("");
        jFormattedTextFieldRG.setText("");
        jFormattedTextFieldCPF.setText("");
        jTextFieldCtps.setText("");
        jTextFieldNome.setEnabled(true);
        jComboBoxSexo.setEnabled(true);
        jComboBoxSituacao.setEnabled(true);
        jFormattedTextFieldTelefone.setEnabled(true);
        jTextFieldFuncao.setEnabled(true);
        jComboBoxDepartamento.setEnabled(true);
        jTextFieldCracha.setEnabled(true);
        jFormattedTextFieldAdmissao.setEnabled(true);
        jFormattedTextFieldNascimento.setEnabled(true);
        jFormattedTextFieldRG.setEnabled(true);
        jFormattedTextFieldCPF.setEnabled(true);
        jTextFieldCtps.setEnabled(true);
        jButtonAlterar.setEnabled(false);
        jButtonExcluir.setEnabled(false);
        jButtonIncluir.setEnabled(true);
        jButtonNovo.setEnabled(false);
    }//GEN-LAST:event_jButtonNovoActionPerformed

    private void jButtonIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIncluirActionPerformed
        if (muda==1){
            modelo.setNome(jTextFieldNome.getText());
            modelo.setCsexo((String)jComboBoxSexo.getSelectedItem());
            modelo.setTelefone(jFormattedTextFieldTelefone.getText());
            modelo.setFuncao(jTextFieldFuncao.getText());
            modelo.setCdepartamento((String)jComboBoxDepartamento.getSelectedItem());
            modelo.setCracha(jTextFieldCracha.getText());
            modelo.setAdmissao(jFormattedTextFieldAdmissao.getText());
            modelo.setNascimento(jFormattedTextFieldNascimento.getText());
            modelo.setRg(jFormattedTextFieldRG.getText());
            modelo.setCpf(jFormattedTextFieldCPF.getText());
            modelo.setHireDate(new java.sql.Timestamp(new java.util.Date().getTime()));
            modelo.setCtps(jTextFieldCtps.getText());
            modelo.setCsituacao((String)jComboBoxSituacao.getSelectedItem());
            control.InserirCA_0100(modelo);
            preencherTabela("select * from colaborador order by id_col");
        } else {
            modelo.setNome(jTextFieldNome.getText());
            modelo.setCsexo((String)jComboBoxSexo.getSelectedItem());
            modelo.setTelefone(jFormattedTextFieldTelefone.getText());
            modelo.setFuncao(jTextFieldFuncao.getText());
            modelo.setCdepartamento((String)jComboBoxDepartamento.getSelectedItem());
            modelo.setCracha(jTextFieldCracha.getText());
            modelo.setAdmissao(jFormattedTextFieldAdmissao.getText());
            modelo.setNascimento(jFormattedTextFieldNascimento.getText());
            modelo.setRg(jFormattedTextFieldRG.getText());
            modelo.setCpf(jFormattedTextFieldCPF.getText());
            modelo.setHireDate(new java.sql.Timestamp(new java.util.Date().getTime()));
            modelo.setCtps(jTextFieldCtps.getText());
            modelo.setCsituacao((String)jComboBoxSituacao.getSelectedItem());
            control.AlteraCA_0100(modelo);
            preencherTabela("select * from colaborador order by id_col");
        }
        jTextFieldCod.setText("");
        jTextFieldNome.setText("");
        jFormattedTextFieldTelefone.setText("");
        jTextFieldFuncao.setText("");
        jTextFieldCracha.setText("");
        jFormattedTextFieldAdmissao.setText("");
        jFormattedTextFieldNascimento.setText("");
        jFormattedTextFieldRG.setText("");
        jFormattedTextFieldCPF.setText("");
        jTextFieldCtps.setText("");
        jComboBoxSexo.removeAllItems();
        jComboBoxDepartamento.removeAllItems();
        jComboBoxSituacao.removeAllItems();
        jTextFieldNome.setEnabled(false);
        jComboBoxSexo.setEnabled(false);
        jFormattedTextFieldTelefone.setEnabled(false);
        jTextFieldFuncao.setEnabled(false);
        jComboBoxDepartamento.setEnabled(false);
        jComboBoxSituacao.setEnabled(false);
        jTextFieldCracha.setEnabled(false);
        jFormattedTextFieldAdmissao.setEnabled(false);
        jFormattedTextFieldNascimento.setEnabled(false);
        jFormattedTextFieldRG.setEnabled(false);
        jFormattedTextFieldCPF.setEnabled(false);
        jTextFieldCtps.setEnabled(true);
        jButtonAlterar.setEnabled(false);
        jButtonExcluir.setEnabled(false);
        jButtonIncluir.setEnabled(false);
        jButtonNovo.setEnabled(true);
    }//GEN-LAST:event_jButtonIncluirActionPerformed

    private void jButtonAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlterarActionPerformed
        try {
            // TODO add your handling code here:
            modelo.setCodigo(Integer.parseInt(jTextFieldCod.getText()));
            modelo.setNome(jTextFieldNome.getText());
            modelo.setCsexo((String)jComboBoxSexo.getSelectedItem());
            modelo.setTelefone(jFormattedTextFieldTelefone.getText());
            modelo.setFuncao(jTextFieldFuncao.getText());
            modelo.setCdepartamento((String)jComboBoxDepartamento.getSelectedItem());
            modelo.setCracha(jTextFieldCracha.getText());
            modelo.setAdmissao(jFormattedTextFieldAdmissao.getText());
            modelo.setNascimento(jFormattedTextFieldNascimento.getText());
            modelo.setRg(jFormattedTextFieldRG.getText());
            modelo.setCpf(jFormattedTextFieldCPF.getText());
            modelo.setHireDate(new java.sql.Timestamp(new java.util.Date().getTime()));
            modelo.setCtps(jTextFieldCtps.getText());
            modelo.setCsituacao((String)jComboBoxSituacao.getSelectedItem());
            muda = 2;
            PesquisaSexo(conexao.rs.getInt("csexo"));
            PesquisaDepartamento(conexao.rs.getInt("cdepartamento"));
            PesquisaSituacao(conexao.rs.getInt("csituacao"));
            jTextFieldNome.setEnabled(true);
            jComboBoxSexo.setEnabled(true);
            jFormattedTextFieldTelefone.setEnabled(true);
            jTextFieldFuncao.setEnabled(true);
            jComboBoxDepartamento.setEnabled(true);
            jComboBoxSituacao.setEnabled(true);
            jTextFieldCracha.setEnabled(true);
            jFormattedTextFieldAdmissao.setEnabled(true);
            jFormattedTextFieldNascimento.setEnabled(true);
            jFormattedTextFieldRG.setEnabled(true);
            jFormattedTextFieldCPF.setEnabled(true);
            jTextFieldCtps.setEnabled(true);
            jButtonAlterar.setEnabled(false);
            jButtonExcluir.setEnabled(false);
            jButtonIncluir.setEnabled(true);
            jButtonNovo.setEnabled(false);
            preencherTabela("select * from colaborador order by id_col");
        } catch (SQLException ex) {
            Logger.getLogger(CA_0100.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonAlterarActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        modelo.setCodigo(Integer.parseInt(jTextFieldCod.getText()));
        control.ExcluirCA_0100(modelo);
        preencherTabela("select * from colaborador order by id_col");
        jTextFieldCod.setText("");
        jTextFieldNome.setText("");
        jFormattedTextFieldTelefone.setText("");
        jTextFieldFuncao.setText("");
        jTextFieldCracha.setText("");
        jFormattedTextFieldAdmissao.setText("");
        jFormattedTextFieldNascimento.setText("");
        jFormattedTextFieldRG.setText("");
        jFormattedTextFieldCPF.setText("");
        jTextFieldCtps.setText("");
        jComboBoxSexo.removeAllItems();
        jComboBoxDepartamento.removeAllItems();
        jComboBoxSituacao.removeAllItems();
        jTextFieldNome.setEnabled(false);
        jComboBoxSexo.setEnabled(false);
        jFormattedTextFieldTelefone.setEnabled(false);
        jTextFieldFuncao.setEnabled(false);
        jComboBoxDepartamento.setEnabled(false);
        jComboBoxSituacao.setEnabled(false);
        jTextFieldCracha.setEnabled(false);
        jFormattedTextFieldAdmissao.setEnabled(false);
        jFormattedTextFieldNascimento.setEnabled(false);
        jFormattedTextFieldRG.setEnabled(false);
        jFormattedTextFieldCPF.setEnabled(false);
        jTextFieldCtps.setEnabled(false);
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

            String [] Colunas = new String[]{"Codigo","Nome", "Função", "Cracha", "CPF"};

            conexao.executaSQL(SQL);
            try {
                conexao.rs.first();
                do{
                    dados.add(new Object[]{conexao.rs.getInt("id_col"), conexao.rs.getString("nome_col"), 
                        conexao.rs.getString("fun_col"), conexao.rs.getString("cracha_col"), conexao.rs.getString("cpf_col")});
                }while(conexao.rs.next());
            } catch (SQLException ex) {
                //JOptionPane.showMessageDialog(null, "Erro ao Preencher o ArrayList!\nERRO:" +ex);
            }

            ModeloTabela modelo = new ModeloTabela (dados, Colunas);
            tabela.setModel (modelo);
            tabela.getColumnModel().getColumn(0).setPreferredWidth(48);
            tabela.getColumnModel().getColumn(0).setResizable(false);
            tabela.getColumnModel().getColumn(1).setPreferredWidth(200);
            tabela.getColumnModel().getColumn(1).setResizable(false);
            tabela.getColumnModel().getColumn(2).setPreferredWidth(200);
            tabela.getColumnModel().getColumn(2).setResizable(false);
            tabela.getColumnModel().getColumn(3).setPreferredWidth(50);
            tabela.getColumnModel().getColumn(3).setResizable(false);
            tabela.getColumnModel().getColumn(4).setPreferredWidth(125);
            tabela.getColumnModel().getColumn(4).setResizable(false);
            tabela.getTableHeader().setReorderingAllowed(false);
            tabela.setAutoResizeMode(tabela.AUTO_RESIZE_OFF);
            tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }//GEN-LAST:event_jButtonSairActionPerformed

    private void jComboBoxSexoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxSexoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxSexoActionPerformed

    private void jComboBoxDepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxDepartamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxDepartamentoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAlterar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonIncluir;
    private javax.swing.JButton jButtonNovo;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JComboBox jComboBoxDepartamento;
    private javax.swing.JComboBox jComboBoxSexo;
    private javax.swing.JComboBox jComboBoxSituacao;
    private javax.swing.JFormattedTextField jFormattedTextFieldAdmissao;
    private javax.swing.JFormattedTextField jFormattedTextFieldCPF;
    private javax.swing.JFormattedTextField jFormattedTextFieldNascimento;
    private javax.swing.JFormattedTextField jFormattedTextFieldRG;
    private javax.swing.JFormattedTextField jFormattedTextFieldTelefone;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField jTextFieldCod;
    private javax.swing.JTextField jTextFieldCracha;
    private javax.swing.JTextField jTextFieldCtps;
    private javax.swing.JTextField jTextFieldFuncao;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables
}
