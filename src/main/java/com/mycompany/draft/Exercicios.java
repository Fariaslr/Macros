package com.mycompany.draft;

import com.mycompany.dao.ExercicioDAO;
import com.mycompany.models.Exercicio;

import com.mycompany.resources.CenterRenderer;
import com.mycompany.resources.ImageRender;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.*;

public class Exercicios extends javax.swing.JFrame {

    ExercicioDAO exercicioDAO = new ExercicioDAO();
    List<Exercicio> exercicios = exercicioDAO.listarExercicios();

    public Exercicios() {
        initComponents();
        initTableExercicios();        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableExercicios = new javax.swing.JTable();
        btnAdicionarExercicio = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        tableExercicios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Imagem", "Exercício"
            }
        ));
        tableExercicios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableExerciciosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableExercicios);

        btnAdicionarExercicio.setText("Adicionar Exercício");
        btnAdicionarExercicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarExercicioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAdicionarExercicio)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(btnAdicionarExercicio)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tableExerciciosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableExerciciosMouseClicked
        // Definir as opções do menu
        String[] opcoes = {"Editar", "Excluir", "Info"};

        // Obter a linha selecionada
        int linhaSelecionada = tableExercicios.getSelectedRow();

        if (linhaSelecionada != -1) {
            Exercicio exercicioSelecionado = exercicios.get(linhaSelecionada);

            // Mostrar o menu de opções
            int escolha = JOptionPane.showOptionDialog(
                    this,
                    "Nome: " + exercicioSelecionado.getNome(),
                    "Opções",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    opcoes,
                    opcoes[0]
            );

            // Executar a ação com base na opção escolhida
            switch (escolha) {
                case 0 -> // Editar
                    new EditExercicio(exercicioSelecionado, true).setVisible(true);
                case 1 -> {
                    // Excluir
                    int confirmacao = JOptionPane.showConfirmDialog(
                            this,
                            "Você realmente deseja excluir este exercício?",
                            "Confirmação de Exclusão",
                            JOptionPane.YES_NO_OPTION
                    );
                    if (confirmacao == JOptionPane.YES_OPTION) {
                        exercicioDAO.removerExercicio(exercicioSelecionado.getId());
                        exercicios.remove(linhaSelecionada);
                        ((DefaultTableModel) tableExercicios.getModel()).removeRow(linhaSelecionada);
                    }
                }
                case 2 -> // Info
                    JOptionPane.showMessageDialog(
                            this,
                            "Nome: \n" + exercicioSelecionado.getNome()
                            + "\nDescrição: \n" + exercicioSelecionado.getDescricao()
                            + "\nGrupo Muscular: \n" + exercicioSelecionado.getGrupoMuscular().getNome()
                            + "\nURL: \n" + exercicioSelecionado.getUrlFoto(),
                            "Informações do Exercício\n",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                default -> {
                }
            }
            // Nenhuma ação padrão
        }
    }//GEN-LAST:event_tableExerciciosMouseClicked

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        exercicios = exercicioDAO.listarExercicios();
        initTableExercicios();
    }//GEN-LAST:event_formWindowGainedFocus

    private void btnAdicionarExercicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarExercicioActionPerformed
        new EditExercicio().setVisible(true);
    }//GEN-LAST:event_btnAdicionarExercicioActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> {
            new Exercicios().setVisible(true);
        });
    }

    private void initTableExercicios() {

        DefaultTableModel dtmExercicio = (DefaultTableModel) tableExercicios.getModel();
        dtmExercicio.setNumRows(0);

        TableCellRenderer centerRenderer = new CenterRenderer();

        tableExercicios.setRowHeight(100);
        tableExercicios.setDefaultRenderer(Object.class, centerRenderer);
        tableExercicios.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        tableExercicios.getColumnModel().getColumn(0).setCellRenderer(new ImageRender());

        for (Exercicio exercicio : exercicios) {
            dtmExercicio.addRow(new Object[]{
                exercicio.getUrlFoto(),
                exercicio.getNome() + " (" + exercicio.getGrupoMuscular().getNome() + ")"
            });

        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionarExercicio;
    private javax.swing.JScrollPane jScrollPane1;
    javax.swing.JTable tableExercicios;
    // End of variables declaration//GEN-END:variables
}
