/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javatrabalhom1;

import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Mathias
 */
public class AdicionarAvlFXMLController extends InterfaceUsuario {
    
    final CategoryAxis xAxis = new CategoryAxis();
    final NumberAxis yAxis = new NumberAxis();
    
    @FXML
    private TextField NomeDisc;
    
    @FXML
    private ComboBox caixaDisc;
    
     @FXML
    private ComboBox caixaMedias;
    
    @FXML
    private TextField pesoDisc;
   

    public AdicionarAvlFXMLController() {
        super("AdicionarAvlFXML.fxml");
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       
        
        caixaDisc.getItems().addAll(
                "Algoritmos e programação 1",
                "Introdução eng",
                "Matéria do Luca",
                "Matéria que ngm fazia nada",
                "Materia que geral reprovou",
                "ÉTICA EM INFORMÁTICA",
                "MATEMÁTICA COMPUTACIONAL",
                "ALGORITMOS E PROGRAMAÇÃO 1",
                "ÁLGEBRA 1",
                "INTRODUÇÃO AO CÁLCULO",
                "INICIAÇÃO TÉCNICO-CIENTÍFICA",
                "INTRODUÇÃO A ENGENHARIA DE COMPUTAÇÃO",
                "INTRODUÇÃO À FÍSICA",
               "CÁLCULO 1",
                "ALGORITMOS E PROGRAMAÇÃO 2",
                "CIRCUITOS DIGITAIS",
                "DESENHO TÉCNICO",
                "FÍSICA GERAL",
                "ÁLGEBRA 2",
                "CÁLCULO 2",
                "ESTRUTURAS DE DADOS",
                "PROGRAMAÇÃO ORIENTADA A OBJETOS 1",
                "ARQUITETURA DE COMPUTADORES 1",
                "FÍSICA",
                "QUÍMICA 1",
                "ARQUITETURA DE COMPUTADORES 2",
                "PROGRAMAÇÃO ORIENTADA A OBJETOS 2",
                "CÁLCULO 3",
                "ANÁLISE DE CIRCUITOS ELÉTRICOS",
                "QUÍMICA 2",
                "ÓTICA E FÍSICA PARA SEMICONDUTORES",
                "RESISTÊNCIA DOS MATERIAIS",
                "BANCO DE DADOS",
                "SISTEMAS OPERACIONAIS",
                "MATEMÁTICA APLICADA À ENGENHARIA",
                "ENGENHARIA DE SOFTWARE 1",
                "PROBABILIDADE E ESTATÍSTICA",
                "ELETRÔNICA BÁSICA",
                "INTERFACE HUMANO - COMPUTADOR",
                "ENGENHARIA DE SOFTWARE 2",
                "REDES DE COMPUTADORES 1",
                "CÁLCULO NUMERICO",
                "LINGUAGENS FORMAIS",
                "ELETRÔNICA APLICADA",
                "ANÁLISE E CONTROLE DE PROCESSOS",
                "ENGENHARIA ECONÔMICA",
                "REDES DE COMPUTADORES 2",
                "GRAFOS",
                "CONTROLE LÓGICO DE SISTEMAS",
                "MICROCONTROLADORES",
                "PROJETO DE SISTEMAS DIGITAIS",
                "INTELIGÊNCIA ARTIFICIAL",
                "PROJETO DE SISTEMAS EMBARCADOS",
                "SISTEMAS EM TEMPO REAL",
                "COMUNICAÇÃO DIGITAL",
                "PROCESSADOR DIGITAL DE SINAIS",
                "SISTEMAS ROBÓTICOS",
                "SIMULAÇÃO DISCRETA",
                "GERÊNCIA DE PROJETOS",
                "TÓPICOS ESPECIAIS EM ENGENHARIA DE COMPUTAÇÃO",
                "TÓPICOS ESPECIAIS EM HARDWARE",
                "ADMINISTRAÇÃO DE NEGÓCIOS DE BASE TECNOLÓGICA",
                "TÓP. ESPECIAIS EM INTEGRAÇÃO SOFTWARE HARDWARE",
                "SISTEMAS DISTRIBUÍDOS "
                
        
        
        );
        
        caixaMedias.getItems().addAll("M1","M2","M3");
    }
    
    public void VoltarMinhasAvaliacoes(ActionEvent evento){
        GerenciadorJanela.obterInstancia().voltar();
        
    }
//    
//    public void construirGrafico(){
//        xAxis.setLabel("Disciplina");
//        yAxis.setLabel("Minha Nota");
//        
//        XYChart.Series m1 = new XYChart.Series();
//        m1.setName("M1");       
//        m1.getData().add(new XYChart.Data("Algorítmos 1", 10.00));
//        m1.getData().add(new XYChart.Data("Introdução a Engenharia de Computação", 10.00));
//        m1.getData().add(new XYChart.Data("Matéria do Luca", 10.00));
//        m1.getData().add(new XYChart.Data("Henri 'Terror dos Calouros' Stuker", 4.00));
//        m1.getData().add(new XYChart.Data("Célia S2", 10.00));      
//        
//        XYChart.Series m2 = new XYChart.Series();
//        m2.setName("M2");
//        m2.getData().add(new XYChart.Data("Algorítmos 1", 10.00));
//        m2.getData().add(new XYChart.Data("Introdução a Engenharia de Computação", 10.00));
//        m2.getData().add(new XYChart.Data("Matéria do Luca", 6.00));
//        m2.getData().add(new XYChart.Data("Henri 'Terror dos Calouros' Stuker", 4.00));
//        m2.getData().add(new XYChart.Data("Célia S2", 10.00));  
//        
//        XYChart.Series m3 = new XYChart.Series();
//        m3.setName("M3");
//        m3.getData().add(new XYChart.Data("Algorítmos 1", 10.00));
//        m3.getData().add(new XYChart.Data("Introdução a Engenharia de Computação", 10.00));
//        m3.getData().add(new XYChart.Data("Matéria do Luca", 0.00));
//        m3.getData().add(new XYChart.Data("Henri 'Terror dos Calouros' Stuker", 10.00));
//        m3.getData().add(new XYChart.Data("Célia S2", 10.00));  
//        
//        graficoDesempenho.getData().addAll(m1,m2,m3);
//        
//    }
    
    public void SalvarAvaliacao(ActionEvent evento){
        String nome = NomeDisc.getText();
        String combo = caixaDisc.getValue().toString();
        Double peso = Double.parseDouble(pesoDisc.getText());
        String media = caixaMedias.getValue().toString();
        System.out.println("Nome: "+nome+"\nDisciplina: "+combo);
        
        
        
                     try{
                
                    
                    File aqrv=new File("teste.csv");
                    FileWriter out=new FileWriter(aqrv, true);
                    //BufferedWriter bw = new BufferedWriter(out, true);
                    out.write(combo+", "+media+", "+nome+", "+peso+"\n");
                   
                    
                    out.close();
	  	}catch(Exception ec){}
        
        
        GerenciadorJanela.obterInstancia().voltar();
        
    }
    
    
}
