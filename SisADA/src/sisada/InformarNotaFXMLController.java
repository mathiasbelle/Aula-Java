/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisada;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Mathias
 */
public class InformarNotaFXMLController extends InterfaceUsuario {
    
    @FXML
    private Label lblNome;

    @FXML
    private Label lblDisc;
    
    @FXML
    private Label lblMedia;
    
    @FXML
    private TextField campoNota;
    
    public InformarNotaFXMLController() {
        super("InformarNotaFXML.fxml");
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        int i = MinhasAvaliacoesFXMLController.index;
        Avaliacao avl = new Avaliacao();
        ArrayList<Avaliacao> lista = avl.obterListaAvaliacao();
     
        lblNome.setText(lista.get(i).getNome());
        lblDisc.setText(lista.get(i).getDisciplina());
        lblMedia.setText(lista.get(i).getMedia());
     
    }    
    
    public void SalvarNota(ActionEvent evento) throws IOException{
  
        int i = MinhasAvaliacoesFXMLController.index;
        Avaliacao avl = new Avaliacao();
        ArrayList<Avaliacao> lista = avl.obterListaAvaliacao();
   
        lista.get(i).setNota(Double.parseDouble(campoNota.getText()));
        lista.get(i).atualizar();
        GerenciadorJanela.obterInstancia().voltar();
    }
    
    public void VoltarMinhasAvaliacoes(ActionEvent evento){
        GerenciadorJanela.obterInstancia().voltar();
    }
    
}
