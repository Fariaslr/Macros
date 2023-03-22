/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;

import Pessoa.Nutricionista;
import Pessoa.Paciente;
import dao.PacienteDAO;
import dao.PacienteDAOJDBC;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Pichau
 */
public class CadastraPaciente extends javax.swing.JFrame {

    private MaskFormatter Databr;
    private MaskFormatter CEPbr;
    private MaskFormatter CPFbr;

    /**
     * Creates new form Paciente
     *
     * @throws java.text.ParseException
     */
    public CadastraPaciente() throws ParseException {
        Databr = new MaskFormatter("##/##/####");
        CEPbr = new MaskFormatter("#####-###");
        CPFbr = new MaskFormatter("###.###.###-##");
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelScreenPaciente = new javax.swing.JPanel();
        jLabelPaciente = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jTextNome = new javax.swing.JTextField();
        jTextSobrenome = new javax.swing.JTextField();
        jTextDataDeNascimento = new javax.swing.JFormattedTextField(Databr);
        jTextBairro = new javax.swing.JTextField();
        jTextCPF = new javax.swing.JFormattedTextField(CPFbr);
        jTextEstado = new javax.swing.JTextField();
        jTextLogradouro = new javax.swing.JTextField();
        jTextNumero = new javax.swing.JTextField();
        jTextComplemento = new javax.swing.JTextField();
        jComboBoxSexo = new javax.swing.JComboBox<>();
        jTextCidade = new javax.swing.JTextField();
        jTextCEP = new javax.swing.JFormattedTextField(CEPbr);
        buttonEnviar = new javax.swing.JButton();
        jLabelEndereco = new javax.swing.JLabel();
        jLabelDadosPessoais = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanelScreenPaciente.setBackground(new java.awt.Color(109, 181, 130));

        jLabelPaciente.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabelPaciente.setForeground(new java.awt.Color(255, 255, 255));
        jLabelPaciente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPaciente.setText("Paciente");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jTextNome.setBorder(javax.swing.BorderFactory.createTitledBorder("Nome"));
        jTextNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextNomeActionPerformed(evt);
            }
        });

        jTextSobrenome.setBorder(javax.swing.BorderFactory.createTitledBorder("Sobrenome"));
        jTextSobrenome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextSobrenomeActionPerformed(evt);
            }
        });

        jTextDataDeNascimento.setBorder(javax.swing.BorderFactory.createTitledBorder("Data de Nascimento"));
        jTextDataDeNascimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextDataDeNascimentoActionPerformed(evt);
            }
        });

        jTextBairro.setBorder(javax.swing.BorderFactory.createTitledBorder("Bairro"));
        jTextBairro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextBairroActionPerformed(evt);
            }
        });

        jTextCPF.setBorder(javax.swing.BorderFactory.createTitledBorder("CPF"));
        jTextCPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextCPFActionPerformed(evt);
            }
        });

        jTextEstado.setBorder(javax.swing.BorderFactory.createTitledBorder("Estado"));
        jTextEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextEstadoActionPerformed(evt);
            }
        });

        jTextLogradouro.setBorder(javax.swing.BorderFactory.createTitledBorder("Logradouro"));
        jTextLogradouro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextLogradouroActionPerformed(evt);
            }
        });

        jTextNumero.setBorder(javax.swing.BorderFactory.createTitledBorder("Nº"));
        jTextNumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextNumeroActionPerformed(evt);
            }
        });

        jTextComplemento.setBorder(javax.swing.BorderFactory.createTitledBorder("Complemento"));
        jTextComplemento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextComplementoActionPerformed(evt);
            }
        });

        jComboBoxSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Feminino", " " }));
        jComboBoxSexo.setBorder(javax.swing.BorderFactory.createTitledBorder("Sexo"));
        jComboBoxSexo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxSexoActionPerformed(evt);
            }
        });

        jTextCidade.setBorder(javax.swing.BorderFactory.createTitledBorder("Cidade"));
        jTextCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextCidadeActionPerformed(evt);
            }
        });

        jTextCEP.setBorder(javax.swing.BorderFactory.createTitledBorder("CEP"));
        jTextCEP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextCEPActionPerformed(evt);
            }
        });

        buttonEnviar.setText("Enviar");
        buttonEnviar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonEnviarMouseClicked(evt);
            }
        });

        jLabelEndereco.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelEndereco.setText("Endereço");

        jLabelDadosPessoais.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelDadosPessoais.setText("Dados pessoais");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextEstado, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                            .addComponent(jTextCEP)
                            .addComponent(jTextComplemento))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(236, 236, 236)
                                .addComponent(buttonEnviar, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextLogradouro)
                                    .addComponent(jTextNumero))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextCidade))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(16, 16, 16)
                                        .addComponent(jTextBairro))))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextCPF)
                            .addComponent(jTextNome))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jTextSobrenome)
                                .addGap(18, 18, 18)
                                .addComponent(jTextDataDeNascimento))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jComboBoxSexo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelDadosPessoais)
                            .addComponent(jLabelEndereco))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabelDadosPessoais)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextSobrenome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextDataDeNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(jLabelEndereco)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextCEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonEnviar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelScreenPacienteLayout = new javax.swing.GroupLayout(jPanelScreenPaciente);
        jPanelScreenPaciente.setLayout(jPanelScreenPacienteLayout);
        jPanelScreenPacienteLayout.setHorizontalGroup(
            jPanelScreenPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelScreenPacienteLayout.createSequentialGroup()
                .addContainerGap(89, Short.MAX_VALUE)
                .addGroup(jPanelScreenPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelScreenPacienteLayout.createSequentialGroup()
                        .addComponent(jLabelPaciente)
                        .addGap(295, 295, 295))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelScreenPacienteLayout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56))))
        );
        jPanelScreenPacienteLayout.setVerticalGroup(
            jPanelScreenPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelScreenPacienteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelScreenPaciente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelScreenPaciente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonEnviarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonEnviarMouseClicked
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        Paciente pacienteInserido = new Paciente();

        try {
            pacienteInserido.setNome(jTextNome.getText());
            pacienteInserido.setSobrenome(jTextSobrenome.getText());
            pacienteInserido.setDataDeNascimento(formatador.parse(jTextDataDeNascimento.getText()));
            pacienteInserido.setCpf(jTextCPF.getText());
            String s = (String) jComboBoxSexo.getSelectedItem();
            pacienteInserido.setSexo(s.substring(0, 1));
            pacienteInserido.setLongradouro(jTextLogradouro.getText());
            pacienteInserido.setComplemento(jTextComplemento.getText());
            pacienteInserido.setNumero(jTextNumero.getColumns());
            pacienteInserido.setBairro(jTextBairro.getText());
            pacienteInserido.setBairro(jTextBairro.getText());
            pacienteInserido.setCidade(jTextCidade.getText());
            pacienteInserido.setEstado(jTextEstado.getText());
            pacienteInserido.setCep(jTextCEP.getText());
            
        } catch (ParseException ex) {
            Logger.getLogger(CadastraPaciente.class.getName()).log(Level.SEVERE, null, ex);
        }

        PacienteDAO pacienteDAO = new PacienteDAOJDBC();

        int linha = pacienteDAO.inserir(pacienteInserido);
        if (linha > 0) {
            JOptionPane.showMessageDialog(this, "Contato inserido com sucesso!");
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao inserir Contato.");
        }
    }//GEN-LAST:event_buttonEnviarMouseClicked

    private void jTextCEPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextCEPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextCEPActionPerformed

    private void jTextCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextCidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextCidadeActionPerformed

    private void jComboBoxSexoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxSexoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxSexoActionPerformed

    private void jTextComplementoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextComplementoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextComplementoActionPerformed

    private void jTextNumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextNumeroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextNumeroActionPerformed

    private void jTextLogradouroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextLogradouroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextLogradouroActionPerformed

    private void jTextEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextEstadoActionPerformed

    private void jTextCPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextCPFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextCPFActionPerformed

    private void jTextBairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextBairroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextBairroActionPerformed

    private void jTextDataDeNascimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextDataDeNascimentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextDataDeNascimentoActionPerformed

    private void jTextSobrenomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextSobrenomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextSobrenomeActionPerformed

    private void jTextNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextNomeActionPerformed

    /**
     * @param args the command line arguments
     */
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonEnviar;
    private javax.swing.JComboBox<String> jComboBoxSexo;
    private javax.swing.JLabel jLabelDadosPessoais;
    private javax.swing.JLabel jLabelEndereco;
    private javax.swing.JLabel jLabelPaciente;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelScreenPaciente;
    private javax.swing.JTextField jTextBairro;
    private javax.swing.JTextField jTextCEP;
    private javax.swing.JTextField jTextCPF;
    private javax.swing.JTextField jTextCidade;
    private javax.swing.JTextField jTextComplemento;
    private javax.swing.JTextField jTextDataDeNascimento;
    private javax.swing.JTextField jTextEstado;
    private javax.swing.JTextField jTextLogradouro;
    private javax.swing.JTextField jTextNome;
    private javax.swing.JTextField jTextNumero;
    private javax.swing.JTextField jTextSobrenome;
    // End of variables declaration//GEN-END:variables
}
