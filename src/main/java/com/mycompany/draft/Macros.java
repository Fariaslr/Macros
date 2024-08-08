package com.mycompany.draft;

import com.mycompany.dao.ExercicioDAO;
import java.text.*;
import java.util.*;
import com.mycompany.enums.*;
import com.mycompany.models.*;
import com.mycompany.resources.PDF;
import java.awt.HeadlessException;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.JOptionPane;
import org.dom4j.*;
import org.dom4j.io.*;

public class Macros {

    public static void main(String[] args) throws ParseException, FileNotFoundException {
        Macros macros = new Macros();

        ExercicioDAO exercicioDAO = new ExercicioDAO();

        Pessoa paciente = new Paciente(new SimpleDateFormat("dd/MM/yyyy").parse("02/11/2003"), "R", "F", Sexo.MASCULINO);
        paciente.setTelefone("71 99329-5049");

        EducadorFisico educadorFisico = new EducadorFisico("12456/BA", new SimpleDateFormat("dd/MM/yyyy").parse("18/06/2001"), "Aleffe", "Santana", Sexo.MASCULINO);

        Plano plano = new Plano((Paciente) paciente, new Date(), Objetivo.HIPERTROFIA, NivelAtividadeFisica.ALTAMENTE_ATIVO, educadorFisico);

        Consulta consulta = new Consulta(plano, new Date(), 100f, 194, educadorFisico);

        List<TreinoExercicio> treinosExercicios = new ArrayList<>();

        Treino treino = new Treino(new Date(), consulta, educadorFisico, treinosExercicios);

        for (Exercicio e : exercicioDAO.listarExercicios()) {
            treinosExercicios.add(new TreinoExercicio(e, DivisaoTreino.DIVISAO_A, 4, 12, 2.5f,75 ));
        }

        PDF pdf = new PDF();
        try {
            pdf.gerarPDF(treino);
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

        //new MontaTreino(treino).setVisible(true);
    }

    private Endereco buscarCep(String cep) {

        String logradouro = "";

        try {
            URL url = new URL("http://cep.republicavirtual.com.br/web_cep.php?cep=" + cep + "&formato=xml");
            SAXReader xml = new SAXReader();
            Document documento = xml.read(url);
            Element root = documento.getRootElement();

            Endereco endereco = new Endereco();
            endereco.setCep(cep);

            for (Iterator<Element> it = root.elementIterator(); it.hasNext();) {
                Element element = it.next();
                if (element.getQualifiedName().equals("cidade")) {
                    endereco.setCidade(element.getText());
                }
                if (element.getQualifiedName().equals("bairro")) {
                    endereco.setBairro(element.getText());
                }
                if (element.getQualifiedName().equals("uf")) {
                    endereco.setEstado(element.getText());
                }
                if (element.getQualifiedName().equals("tipo_logradouro")) {
                    logradouro = element.getText();
                }
                if (element.getQualifiedName().equals("logradouro")) {
                    endereco.setLogradouro(logradouro + " " + element.getText());
                }
                if (element.getQualifiedName().equals("resultado")) {
                    if (!element.getText().equals("1")) {
                        JOptionPane.showMessageDialog(null, "CEP não encontrado");
                        return null;
                    }
                }
            }
            return endereco;
        } catch (HeadlessException | MalformedURLException | DocumentException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e);
            return null;
        }
    }

}
