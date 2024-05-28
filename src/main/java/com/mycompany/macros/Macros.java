package com.mycompany.macros;

import java.text.*;
import java.util.*;
import com.mycompany.enums.*;
import com.mycompany.models.*;
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
        ScriptExercicios exerciciosScriptExercicios = new ScriptExercicios();

        Endereco endereco = macros.buscarCep("4280708s");

        Paciente paciente = new Paciente(new SimpleDateFormat("dd/MM/yyyy").parse("21/11/2001"), "Lucas", "Farias", Sexo.MASCULINO);
        paciente.setTelefone("71 99915-8408");
        paciente.setEndereco(endereco);

        EducadorFisico educadorFisico = new EducadorFisico("12456/BA", "Aleffe", "Santana", Sexo.MASCULINO);

        Plano plano = new Plano(paciente, new Date(), Objetivo.HIPERTROFIA, NivelAtividadeFisica.ALTAMENTE_ATIVO, educadorFisico);

        Consulta consulta = new Consulta(plano, new Date(), 86f, 184, educadorFisico);

        List<Exercicio> exercicios = exerciciosScriptExercicios.listaExercicios();
        List<TreinoExercicio> treinosExercicios = new ArrayList<>();

        Treino treino = new Treino(new Date(), consulta, educadorFisico, treinosExercicios);

        TreinoExercicio treinoExercicio;

        for (int i = 0; i < 6; i++) {
            if (i < 3) {
                treinoExercicio = new TreinoExercicio(exercicios.get(i), DivisaoTreino.DIVISAO_A, 4, 12, 5, 60);
                treinosExercicios.add(treinoExercicio);
            } else {
                treinoExercicio = new TreinoExercicio(exercicios.get(i), DivisaoTreino.DIVISAO_B, 4, 12, 5, 30);
                treinosExercicios.add(treinoExercicio);
            }
        }

        PDF pdf = new PDF();

        pdf.gerarPDF(treino);
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
