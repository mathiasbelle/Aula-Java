/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javacalculadora;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author mathias
 */
public class JavaCalculadora extends Application{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        System.out.println("O palco esta pronto.");
        VBox morricone =  new VBox();
        morricone.setSpacing(10);
        morricone.setStyle("-fx-background-color: #babaca;");
        
        TextField capital = new TextField("Valor do Capital: ");
        TextField taxa = new TextField("Valor da Taxa: ");
        TextField tempo = new TextField("Valor do Tempo: ");
        TextField montante = new TextField("Valor do Montante: ");
        TextField juros = new TextField("Valor do Juros: ");
        TextField resultado = new TextField("Resultado: ");
        
        Button calcJuros = new Button("Calcular Juros");
        
        calcJuros.setOnAction(new EventHandler<ActionEvent>() {
            
            
            public void handle(ActionEvent t) {
                resultado.setText(resultado.getText() + 
                  (Double.parseDouble(capital.getText()) * Double.parseDouble(taxa.getText()) * Double.parseDouble(tempo.getText()) ));
                
                
            }
        });
        
        
        

        
        
        
        
        
        morricone.getChildren().add(capital);
        morricone.getChildren().add(taxa);
        morricone.getChildren().add(tempo);
        morricone.getChildren().add(montante);
        morricone.getChildren().add(juros);
        morricone.getChildren().add(resultado);
        
        morricone.getChildren().add(calcJuros);
        
        
        
        Scene cena = new Scene(morricone, 800, 600);
        stage.setScene(cena);
        stage.setTitle("Calculadora de Econômica");
        stage.show();
        
        
        
    }
    
    
    
}
