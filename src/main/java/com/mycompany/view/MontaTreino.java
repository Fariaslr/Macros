package com.mycompany.view;

import com.mycompany.dao.ExercicioDAO;
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

    public MontaTreino() {
        initComponents();
        preencherComboExercicios();
        preecherComboDivisaoTreino();
        this.treino = new Treino();
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
        buttonGerarPDF = new javax.swing.JButton();
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
        buttonMoverCima = new javax.swing.JButton();
        buttonMoverBaixo = new javax.swing.JButton();

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

        buttonGerarPDF.setText("GERAR PDF");
        buttonGerarPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGerarPDFActionPerformed(evt);
            }
        });

        labelExercicio.setText("Exercicio");

        comboExercicios.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        labelDivisaoTreino.setText("Divisão de treino");

        comboDivisaoTreino.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        labelSeries.setText("Series");

        labelRepeticoes.setText("Repetições");

        spinnerSeries.setModel(new javax.swing.SpinnerNumberModel(0, 0, 5, 1));

        spinnerRepeticoes.setModel(new javax.swing.SpinnerNumberModel(0, 0, 30, 1));

        labelCarga.setText("Carga (kg)");

        labelIntervalo.setText("Intervalo(segundos)");

        spinnerIntervalo.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        spinnerCarga.setModel(new javax.swing.SpinnerNumberModel(0.0f, 0.0f, null, 1.0f));

        buttonMoverCima.setText("Cima");
        buttonMoverCima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMoverCimaActionPerformed(evt);
            }
        });

        buttonMoverBaixo.setText("Baixo");
        buttonMoverBaixo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMoverBaixoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(buttonAdicionar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonGerarPDF))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buttonMoverCima, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonMoverBaixo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spinnerCarga, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelCarga)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(labelSeries, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(spinnerSeries))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(labelRepeticoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(spinnerRepeticoes, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                                .addGap(42, 42, 42))
                            .addComponent(comboDivisaoTreino, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelDivisaoTreino))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(labelIntervalo)
                                    .addComponent(spinnerIntervalo, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addComponent(labelExercicio)))
                        .addGap(144, 144, 144))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(comboExercicios, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelDivisaoTreino)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboDivisaoTreino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelSeries)
                            .addComponent(labelRepeticoes))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(spinnerSeries, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spinnerRepeticoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelExercicio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboExercicios, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelCarga, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelIntervalo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(spinnerIntervalo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spinnerCarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(buttonMoverCima)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonMoverBaixo)))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonAdicionar)
                    .addComponent(buttonGerarPDF))
                .addGap(28, 28, 28))
        );

        setSize(new java.awt.Dimension(582, 417));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAdicionarActionPerformed

        if (comboExercicios.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Exercício não selecionado", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
        } else if (comboDivisaoTreino.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Divisão de Treino não selecionada", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
        } else {
            treinoExercicios.add(new TreinoExercicio(
                    (Exercicio) comboExercicios.getSelectedItem(),
                    (DivisaoTreino) comboDivisaoTreino.getSelectedItem(),
                    (int) spinnerSeries.getValue(),
                    (int) spinnerRepeticoes.getValue(),
                    ((Number) spinnerCarga.getValue()).floatValue(),
                    (int) spinnerIntervalo.getValue()
            ));
            preencherTabelaExercicioTreinos(treinoExercicios);
        }
    }//GEN-LAST:event_buttonAdicionarActionPerformed

    private void buttonGerarPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGerarPDFActionPerformed
        PDF pdf = new PDF();
        treino.setTreinosExercicios(treinoExercicios);
        try {
            pdf.gerarPDF(treino);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MontaTreino.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buttonGerarPDFActionPerformed

    private void buttonMoverBaixoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMoverBaixoActionPerformed
        if (tableTreino.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Selecione uma linha");
        } else if (tableTreino.getSelectedRow() == tableTreino.getRowCount() || treinoExercicios.size() < 2) {
            JOptionPane.showMessageDialog(this, "Movimento inválido");
        } else {
            treino.setTreinosExercicios(treinoExercicios);
            treino.moverExercicioParaBaixo(tableTreino.getSelectedRow());
            preencherTabelaExercicioTreinos(treinoExercicios);
        }
    }//GEN-LAST:event_buttonMoverBaixoActionPerformed

    private void buttonMoverCimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMoverCimaActionPerformed
        if (tableTreino.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Selecione uma linha");
        } else if (tableTreino.getSelectedRow() == 0 || treinoExercicios.size() < 2) {
            JOptionPane.showMessageDialog(this, "Movimento inválido");
        } else {
            treino.setTreinosExercicios(treinoExercicios);
            treino.moverExercicioParaCima(tableTreino.getSelectedRow());
            preencherTabelaExercicioTreinos(treinoExercicios);
        }

    }//GEN-LAST:event_buttonMoverCimaActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> {
            new MontaTreino().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAdicionar;
    private javax.swing.JButton buttonGerarPDF;
    private javax.swing.JButton buttonMoverBaixo;
    private javax.swing.JButton buttonMoverCima;
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
                t.getExercicio().getNome() + " - " + t.getDivisao().getAGRUPAMENTO(),
                t.getSeries() + " x " + t.getRepeticoes(),
                t.getCarga()
            });
        }
    }

}
