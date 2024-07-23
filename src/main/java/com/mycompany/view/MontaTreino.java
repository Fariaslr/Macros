package com.mycompany.view;

import com.mycompany.dao.ExercicioDAO;
import com.mycompany.dao.TreinoDAO;
import com.mycompany.enums.DivisaoTreino;
import com.mycompany.resources.PDF;
import com.mycompany.models.Exercicio;
import com.mycompany.models.Treino;
import com.mycompany.models.TreinoExercicio;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class MontaTreino extends javax.swing.JFrame {

    Treino treino;
    ExercicioDAO exercicioDAO = new ExercicioDAO();
    List<Exercicio> exercicios = exercicioDAO.listarExercicios();
    List<TreinoExercicio> treinoExercicios = new ArrayList<>();
    TreinoDAO treinoDAO = new TreinoDAO();

    public MontaTreino() {
        initComponents();
        preencherComboExercicios();
        preecherComboDivisaoTreino();
    }

    public MontaTreino(Treino treino) {
        initComponents();
        preencherComboExercicios();
        preecherComboDivisaoTreino();
        this.treino = treino;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableTreino = new javax.swing.JTable();
        buttonAdicionar = new javax.swing.JButton();
        buttonEnviar = new javax.swing.JButton();
        labelExercicio = new javax.swing.JLabel();
        comboExercicios = new javax.swing.JComboBox<>();
        labelDivisaoTreino = new javax.swing.JLabel();
        comboDivisaoTreino = new javax.swing.JComboBox();
        labelSeries = new javax.swing.JLabel();
        labelRepeticoes = new javax.swing.JLabel();
        spinnerSeries = new javax.swing.JSpinner();
        spinnerRepeticoes = new javax.swing.JSpinner();
        labelCarga = new javax.swing.JLabel();
        labelIntervalo = new javax.swing.JLabel();
        spinnerIntervalo = new javax.swing.JSpinner();
        spinnerCarga = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tableTreino.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Exercício - Divisão", "Series x Repeticões", "Carga"
            }
        ));
        jScrollPane1.setViewportView(tableTreino);

        buttonAdicionar.setText("Adicionar Exercício");
        buttonAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAdicionarActionPerformed(evt);
            }
        });

        buttonEnviar.setText("Enviar");
        buttonEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEnviarActionPerformed(evt);
            }
        });

        labelExercicio.setText("Exercicio");

        comboExercicios.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        labelDivisaoTreino.setText("Divisão de treino");

        comboDivisaoTreino.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        labelSeries.setText("Series");

        labelRepeticoes.setText("Repetições");

        labelCarga.setText("Carga (kg)");

        labelIntervalo.setText("Intervalo(segundos)");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(comboDivisaoTreino, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(labelDivisaoTreino))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(labelSeries, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(spinnerSeries))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(labelRepeticoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(spinnerRepeticoes, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                                .addGap(7, 7, 7)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(spinnerIntervalo, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(spinnerCarga, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(labelIntervalo)
                                .addGap(18, 18, 18)
                                .addComponent(labelCarga)
                                .addGap(9, 9, 9))
                            .addComponent(comboExercicios, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelExercicio)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(buttonAdicionar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonEnviar)))
                .addGap(55, 55, 55))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelExercicio)
                    .addComponent(labelDivisaoTreino))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboExercicios, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboDivisaoTreino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelSeries)
                    .addComponent(labelRepeticoes)
                    .addComponent(labelCarga)
                    .addComponent(labelIntervalo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spinnerSeries, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spinnerRepeticoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spinnerIntervalo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spinnerCarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonAdicionar)
                    .addComponent(buttonEnviar))
                .addGap(37, 37, 37))
        );

        setSize(new java.awt.Dimension(536, 428));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAdicionarActionPerformed

        if (comboExercicios.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Exercício não selecionado", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
        } else if (comboDivisaoTreino.getSelectedIndex() == 0) {
            // Verificação de seleção da divisão de treino
            JOptionPane.showMessageDialog(this, "Divisão de Treino não selecionada", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
        } else {
            // Obtenção dos valores selecionados e digitados
            Exercicio exercicioSelecionado = (Exercicio) comboExercicios.getSelectedItem();
            DivisaoTreino divisaoTreinoSelecionada = (DivisaoTreino) comboDivisaoTreino.getSelectedItem();
            int series = (int) spinnerSeries.getValue();
            int repeticoes = (int) spinnerRepeticoes.getValue();
            float carga = ((Number) spinnerCarga.getValue()).floatValue();
            int intervalo = (int) spinnerIntervalo.getValue();

            // Criação do objeto TreinoExercicio
            TreinoExercicio treinoExercicio = new TreinoExercicio();
            treinoExercicio.setExercicio(exercicioSelecionado);
            treinoExercicio.setDivisao(divisaoTreinoSelecionada);
            treinoExercicio.setSeries(series);
            treinoExercicio.setRepeticoes(repeticoes);
            treinoExercicio.setCarga(carga);
            treinoExercicio.setIntervaloSerie(intervalo);

            treinoExercicios.add(treinoExercicio);
            treino.setTreinosExercicios(treinoExercicios);

            preencherTabelaExercicioTreinos(treinoExercicios);

        }
    }//GEN-LAST:event_buttonAdicionarActionPerformed

    private void buttonEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEnviarActionPerformed
        PDF pdf = new PDF();
        try {
            pdf.gerarPDF(treino);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MontaTreino.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buttonEnviarActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> {
            new MontaTreino().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAdicionar;
    private javax.swing.JButton buttonEnviar;
    private javax.swing.JComboBox comboDivisaoTreino;
    private javax.swing.JComboBox<Object> comboExercicios;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelCarga;
    private javax.swing.JLabel labelDivisaoTreino;
    private javax.swing.JLabel labelExercicio;
    private javax.swing.JLabel labelIntervalo;
    private javax.swing.JLabel labelRepeticoes;
    private javax.swing.JLabel labelSeries;
    private javax.swing.JSpinner spinnerCarga;
    private javax.swing.JSpinner spinnerIntervalo;
    private javax.swing.JSpinner spinnerRepeticoes;
    private javax.swing.JSpinner spinnerSeries;
    private javax.swing.JTable tableTreino;
    // End of variables declaration//GEN-END:variables

    private void preencherComboExercicios() {
        comboExercicios.removeAllItems();
        comboExercicios.addItem("");
        for (Exercicio e : exercicios) {
            comboExercicios.addItem(e);
        }
    }

    private void preecherComboDivisaoTreino() {
        comboDivisaoTreino.removeAllItems();
        comboDivisaoTreino.addItem("");
        for (DivisaoTreino divisao : DivisaoTreino.values()) {
            comboDivisaoTreino.addItem(divisao);
        }
    }

    private void preencherTabelaExercicioTreinos(List<TreinoExercicio> treinoExercicio) {
        DefaultTableModel dtmTreino = (DefaultTableModel) tableTreino.getModel();
        dtmTreino.setNumRows(0);

        for (TreinoExercicio t : treinoExercicios) {
            dtmTreino.addRow(new Object[]{
                t.getExercicio() + " " + t.getDivisao().getAGRUPAMENTO(),
                t.getSeries() + " x " + t.getRepeticoes(),
                t.getCarga()
            });
        }
    }
}
