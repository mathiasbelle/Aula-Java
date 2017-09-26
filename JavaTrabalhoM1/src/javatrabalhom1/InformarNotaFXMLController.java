/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javatrabalhom1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Mathias
 */
public class InformarNotaFXMLController extends InterfaceUsuario {

    public InformarNotaFXMLController() {
        super("InformarNotaFXML.fxml");
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void SalvarNota(ActionEvent evento){
        // salvar
        GerenciadorJanela.obterInstancia().voltar();
    }
    
    public void VoltarMinhasAvaliacoes(ActionEvent evento){
        GerenciadorJanela.obterInstancia().voltar();
    }
    
}
