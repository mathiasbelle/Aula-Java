/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javatrabalhom1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        
                 int i = MinhasAvaliacoesFXMLController.index;
        Avaliacao avl = new Avaliacao();
        ArrayList<Avaliacao> lista = avl.obterListaAvaliacao();
        String lena = "";
        String aux="";
        String[] corte;
        String[] corte2;
        //XYChart.Series m1 = new XYChart.Series();
        XYChart.Series m1;
        XYChart.Series outraM = new XYChart.Series();
         //m1.setName("M1");
         //m1.getData().add(new XYChart.Data(lista.get(0).getDisciplina(), 10));
        
        try {
            //File f = new File("teste.csv");
            FileReader arquivo = new FileReader(new File ("teste.csv"));
            
            BufferedReader br = new BufferedReader(arquivo);
            BufferedReader qwe = new BufferedReader(arquivo);
            
            while((lena = br.readLine()) != null){
                m1 = new XYChart.Series();
                System.out.println("Lena: "+lena);
                corte = lena.split(",");
                m1.setName(corte[1]);
                System.out.println("Corte posição 4: "+ corte[4]);
                m1.getData().add(new XYChart.Data(corte[0], Double.parseDouble(corte[4])));
                qwe = br;
//                while((aux = qwe.readLine()) != null){
//                    System.out.println("Aux: "+aux);
//                    corte2 = aux.split(",");
//                    if(corte2[0].equals(corte[0])){
//                        //corte = aux.split(",");
//                        System.out.println("Corte [0]: "+corte2[0]+"\nNota do corte: "+corte2[4]);
//                        m1.getData().add(new XYChart.Data(corte2[0], Double.parseDouble(corte2[4])));
//                    }
//                }
                grafico.getData().addAll(m1);
            }
            
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DesempenhoFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DesempenhoFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        

        
        
//         XYChart.Series m1 = new XYChart.Series();
//         m1.setName("M1");
//         m1.getData().add(new XYChart.Data(lista.get(0).getDisciplina(), 10));
        
              
//        XYChart.Series m1 = new XYChart.Series();
//        m1.setName("M1");       
//        m1.getData().add(new XYChart.Data("1", 10.00));
//        m1.getData().add(new XYChart.Data("2", 10.00));
//        m1.getData().add(new XYChart.Data("3", 10.00));
//        m1.getData().add(new XYChart.Data("4", 4.00));
//        m1.getData().add(new XYChart.Data("5", 10.00));      
//        
//        XYChart.Series m2 = new XYChart.Series();
//        m2.setName("M2");
//        m2.getData().add(new XYChart.Data("1", 10.00));
//        m2.getData().add(new XYChart.Data("2", 10.00));
//        m2.getData().add(new XYChart.Data("3", 6.00));
//        m2.getData().add(new XYChart.Data("4", 4.00));
//        m2.getData().add(new XYChart.Data("5", 10.00));  
//        
//        XYChart.Series m3 = new XYChart.Series();
//        m3.setName("M3");
//        m3.getData().add(new XYChart.Data("1", 10.00));
//        m3.getData().add(new XYChart.Data("2", 10.00));
//        m3.getData().add(new XYChart.Data("3", 0.00));
//        m3.getData().add(new XYChart.Data("4", 10.00));
//        m3.getData().add(new XYChart.Data("5", 10.00));         
//        grafico.getData().addAll(m1,m2,m3);
        
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
