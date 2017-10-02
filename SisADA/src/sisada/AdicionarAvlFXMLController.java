/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisada;

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

        caixaDisc.getItems().addAll(
                "Ética Em Informática",
                "Matemática Computacional",
                "Algoritmos E Programação 1",
                "Álgebra 1",
                "Introdução Ao Cálculo",
                "Iniciação Técnico-Científica",
                "Introdução À Engenharia De Computação",
                "Introdução À Física",
                "Cálculo 1",
                "Algoritmos E Programação 2",
                "Circuitos Digitais",
                "Desenho Técnico",
                "Física Geral",
                "Álgebra 2",
                "Cálculo 2",
                "Estruturas De Dados",
                "Programação Orientada A Objetos 1",
                "Arquitetura De Computadores 1",
                "Física",
                "Química 1",
                "Arquitetura De Computadores 2",
                "Programação Orientada A Objetos 2",
                "Cálculo 3",
                "Análise De Circuitos Elétricos",
                "Química 2",
                "Ótica E Física Para Semicondutores",
                "Resistência Dos Materiais",
                "Banco De Dados",
                "Sistemas Operacionais",
                "Matemática Aplicada À Engenharia",
                "Engenharia De Software 1",
                "Probabilidade E Estatística",
                "Eletrônica Básica",
                "Interface Humano - Computador",
                "Engenharia De Software 2",
                "Redes De Computadores 1",
                "Cálculo Numerico",
                "Linguagens Formais",
                "Eletrônica Aplicada",
                "Análise E Controle De Processos",
                "Engenharia Econômica",
                "Redes De Computadores 2",
                "Grafos",
                "Controle Lógico De Sistemas",
                "Microcontroladores",
                "Projeto De Sistemas Digitais",
                "Inteligência Artificial",
                "Projeto De Sistemas Embarcados",
                "Sistemas Em Tempo Real",
                "Comunicação Digital",
                "Processador Digital De Sinais",
                "Sistemas Robóticos",
                "Simulação Discreta",
                "Gerência De Projetos",
                "Tópicos Especiais Em Engenharia De Computação",
                "Tópicos Especiais Em Hardware",
                "Administração De Negócios De Base Tecnológica",
                "Tóp. Especiais Em Integração Software Hardware",
                "Sistemas Distribuídos " 
        );
        
        caixaMedias.getItems().addAll("M1","M2","M3");
    }
    
    public void VoltarMinhasAvaliacoes(ActionEvent evento){
        GerenciadorJanela.obterInstancia().voltar();
        
    }
    
    public void SalvarAvaliacao(ActionEvent evento){
        String nome = NomeDisc.getText();
        String combo = caixaDisc.getValue().toString();
        Double peso = Double.parseDouble(pesoDisc.getText());
        String media = caixaMedias.getValue().toString();
        try {
            File aqrv = new File("dados_usuario.csv");
            FileWriter out = new FileWriter(aqrv, true);
            out.write(combo + ", " + media + ", " + nome + ", " + peso + "\n");

            out.close();
        } catch (Exception ec){}

        GerenciadorJanela.obterInstancia().voltar();
        
    }   
}
