/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javatrabalhom1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Mathias
 */
public class DesempenhoFXMLController extends InterfaceUsuario {
       
    @FXML
    private BarChart grafico;
    
    @FXML
    private Label labelAs;

    public DesempenhoFXMLController() {
        super("DesempenhoFXML.fxml");
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Disciplina");
        yAxis.setLabel("Minha Nota");
        
        BarChart d;
        d = new BarChart<>(xAxis, yAxis);
        
        XYChart.Series m1 = new XYChart.Series();
        m1.setName("M1");       
        m1.getData().add(new XYChart.Data("Algorítmos 1", 10.00));
        m1.getData().add(new XYChart.Data("Introdução a Engenharia de Computação", 10.00));
        m1.getData().add(new XYChart.Data("Matéria do Luca", 10.00));
        m1.getData().add(new XYChart.Data("Henri 'Terror dos Calouros' Stuker", 4.00));
        m1.getData().add(new XYChart.Data("Célia S2", 10.00));      
        
        XYChart.Series m2 = new XYChart.Series();
        m2.setName("M2");
        m2.getData().add(new XYChart.Data("Algorítmos 1", 10.00));
        m2.getData().add(new XYChart.Data("Introdução a Engenharia de Computação", 10.00));
        m2.getData().add(new XYChart.Data("Matéria do Luca", 6.00));
        m2.getData().add(new XYChart.Data("Henri 'Terror dos Calouros' Stuker", 4.00));
        m2.getData().add(new XYChart.Data("Célia S2", 10.00));  
        
        XYChart.Series m3 = new XYChart.Series();
        m3.setName("M3");
        m3.getData().add(new XYChart.Data("Algorítmos 1", 10.00));
        m3.getData().add(new XYChart.Data("Introdução a Engenharia de Computação", 10.00));
        m3.getData().add(new XYChart.Data("Matéria do Luca", 0.00));
        m3.getData().add(new XYChart.Data("Henri 'Terror dos Calouros' Stuker", 10.00));
        m3.getData().add(new XYChart.Data("Célia S2", 10.00));  
        
        d.getData().addAll(m1,m2,m3);
        grafico = d;
        Stage novo = new Stage();
        
        Scene cena = new Scene(d);
        novo.setScene(cena);
        novo.show();
        labelAs.setText("Fez");
        System.out.println("Fez");
        
    } 
    
    
    
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
    
    public void VoltarDashboard(ActionEvent evento){
        GerenciadorJanela.obterInstancia().voltar();
    }
    
}
