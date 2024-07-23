package com.mycompany.view;

import com.mycompany.dao.ExercicioDAO;
import com.mycompany.enums.GrupoMuscular;
import com.mycompany.models.Exercicio;
import javax.swing.JOptionPane;

public class EditExercicio extends javax.swing.JFrame {

    Exercicio exercicio;
    ExercicioDAO exercicioDAO = new ExercicioDAO();
    boolean modoEdicao = false;

    public EditExercicio() {
        initComponents();
        initComboBox();
    }

    public EditExercicio(Exercicio exercicio, boolean modoEdicao) {
        initComponents();
        initComboBox();

        this.exercicio = exercicio;
        this.modoEdicao = modoEdicao;
        preecherCamposExercicio();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        comboGrupoMuscular = new javax.swing.JComboBox<>();
        labelGrupoMuscular = new javax.swing.JLabel();
        labelNomeExercicio = new javax.swing.JLabel();
        txtNomeExercicio = new javax.swing.JTextField();
        labelDescricao = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescricao = new javax.swing.JTextArea();
        labelURL = new javax.swing.JLabel();
        txtUrl = new javax.swing.JTextField();
        btnEnviar = new javax.swing.JButton();

        labelGrupoMuscular.setText("Grupo Muscular");

        labelNomeExercicio.setText("Nome Exercício");

        labelDescricao.setText("Descrição");

        txtDescricao.setColumns(20);
        txtDescricao.setRows(5);
        jScrollPane1.setViewportView(txtDescricao);

        labelURL.setText("URL foto");

        btnEnviar.setText("Enviar");
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelURL)
                    .addComponent(labelDescricao)
                    .addComponent(jScrollPane1)
                    .addComponent(txtUrl)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNomeExercicio, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelNomeExercicio))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelGrupoMuscular)
                            .addComponent(comboGrupoMuscular, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(29, 29, 29))
            .addGroup(layout.createSequentialGroup()
                .addGap(153, 153, 153)
                .addComponent(btnEnviar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelGrupoMuscular)
                    .addComponent(labelNomeExercicio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboGrupoMuscular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNomeExercicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelDescricao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelURL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUrl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEnviar)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
        if (modoEdicao) {
            GrupoMuscular grupoMuscularSelecionado = (GrupoMuscular) comboGrupoMuscular.getSelectedItem();

            exercicio.setGrupoMuscular(grupoMuscularSelecionado);
            exercicio.setNome(txtNomeExercicio.getText());
            exercicio.setDescricao(txtDescricao.getText());
            exercicio.setUrlFoto(txtUrl.getText());

            exercicioDAO.atualizarExercicio(exercicio);
            modoEdicao = !modoEdicao;
            JOptionPane.showMessageDialog(this, "Exercício atualizado com sucesso.");
            this.dispose();
            
        } else {
            GrupoMuscular grupoMuscularSelecionado = (GrupoMuscular) comboGrupoMuscular.getSelectedItem();
            exercicio = new Exercicio();
            exercicio.setGrupoMuscular(grupoMuscularSelecionado);
            exercicio.setNome(txtNomeExercicio.getText());
            exercicio.setDescricao(txtDescricao.getText());
            exercicio.setUrlFoto(txtUrl.getText());
            exercicioDAO.adicionarExercicio(exercicio);
            JOptionPane.showMessageDialog(this, "Exercício atualizado com sucesso.");
            this.dispose();
        }

    }//GEN-LAST:event_btnEnviarActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> {
            new EditExercicio().setVisible(true);
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnviar;
    private javax.swing.JComboBox<Object> comboGrupoMuscular;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelDescricao;
    private javax.swing.JLabel labelGrupoMuscular;
    private javax.swing.JLabel labelNomeExercicio;
    private javax.swing.JLabel labelURL;
    private javax.swing.JTextArea txtDescricao;
    private javax.swing.JTextField txtNomeExercicio;
    private javax.swing.JTextField txtUrl;
    // End of variables declaration//GEN-END:variables

    private void initComboBox() {
        comboGrupoMuscular.addItem("");
        for (GrupoMuscular grupo : GrupoMuscular.values()) {
            comboGrupoMuscular.addItem(grupo);
        }
    }

    private void preecherCamposExercicio() {
        comboGrupoMuscular.setSelectedItem(exercicio.getGrupoMuscular());
        txtNomeExercicio.setText(exercicio.getNome());
        txtDescricao.setText(exercicio.getDescricao());
        txtUrl.setText(exercicio.getUrlFoto());
    }
}
