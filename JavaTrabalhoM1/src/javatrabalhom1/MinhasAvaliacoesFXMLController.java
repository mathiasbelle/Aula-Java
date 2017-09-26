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
public class MinhasAvaliacoesFXMLController extends InterfaceUsuario {

    public MinhasAvaliacoesFXMLController() {
        super("MinhasAvaliacoesFXML.fxml");
    }

    /**
     * Initializes the controller class.
     */
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void irInformarNota(ActionEvent evento){
        InformarNotaFXMLController informarNota = new InformarNotaFXMLController();
        GerenciadorJanela.obterInstancia().abreJanela(informarNota);
    }
    
    public void AdicionarAvaliacao(ActionEvent evento){
        AdicionarAvlFXMLController adicionar = new AdicionarAvlFXMLController();
        GerenciadorJanela.obterInstancia().abreJanela(adicionar);
    }
    
    public void VoltarDashboard(ActionEvent evento){
        GerenciadorJanela.obterInstancia().voltar();
    }
    
}
