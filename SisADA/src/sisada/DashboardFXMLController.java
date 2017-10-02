/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisada;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Mathias
 */
public class DashboardFXMLController extends InterfaceUsuario {

    /**
     * Initializes the controller class.
     */
    public DashboardFXMLController(){
        super("DashboardFXML.fxml");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void IrMinhasAvaliacoes(ActionEvent evento){
        MinhasAvaliacoesFXMLController minhasAvaliacoes = new MinhasAvaliacoesFXMLController();
        GerenciadorJanela.obterInstancia().abreJanela(minhasAvaliacoes);
        
    }
    
    public void IrDesempenho(ActionEvent evento){
        DesempenhoFXMLController desempenho = new DesempenhoFXMLController();
        GerenciadorJanela.obterInstancia().abreJanela(desempenho);
        
    }
    
}
