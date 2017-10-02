/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javatrabalhom1;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author Mathias
 */
public class JavaTrabalhoM1 extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Eu queria mt coisa");
        primaryStage.setMinWidth(1024);
        primaryStage.setMinHeight(768);
        DashboardFXMLController janelaPrincipal = new DashboardFXMLController();
        GerenciadorJanela.obterInstancia().inicializaPalco(primaryStage, janelaPrincipal);
    }
    
}
