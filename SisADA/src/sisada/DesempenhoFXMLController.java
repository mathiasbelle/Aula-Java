/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisada;

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
        
        CategoryAxis xAxis = new CategoryAxis();      
        NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Disciplina");
        yAxis.setLabel("Minha Nota");
        
        Avaliacao avl = new Avaliacao();
        ArrayList<Avaliacao> lista = avl.obterListaAvaliacao();
        
        XYChart.Series m1 = new XYChart.Series();
        XYChart.Series m2 = new XYChart.Series();
        XYChart.Series m3 = new XYChart.Series();
        
        m1.setName("M1");
        m2.setName("M2");
        m3.setName("M3");        
                     
        for (int i = 0; i < lista.size(); i++) {
            for (int j = i; j < lista.size(); j++) {
                if (lista.get(j).getDisciplina().equals(lista.get(i).getDisciplina())) {
                    if (lista.get(j).getMedia().equals(" M1")) {
                        m1.getData().add(new XYChart.Data(lista.get(j).getDisciplina(), lista.get(j).getNota()));
                    } else if (lista.get(j).getMedia().equals(" M2")) {
                        m2.getData().add(new XYChart.Data(lista.get(j).getDisciplina(), lista.get(j).getNota()));
                    } else // M3
                        m3.getData().add(new XYChart.Data(lista.get(j).getDisciplina(), lista.get(j).getNota()));
                }
            }
        }
           
        grafico.getData().addAll(m1,m2,m3);
                    
    }
    
    public void VoltarDashboard(ActionEvent evento){
        GerenciadorJanela.obterInstancia().voltar();
    }
    
}
