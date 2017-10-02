/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisada;

import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Mathias
 */
public class MinhasAvaliacoesFXMLController extends InterfaceUsuario {
    
    
    @FXML
    private TableColumn<Avaliacao, String> colunaNome;
    @FXML
    private TableColumn<Avaliacao, String> colunaDisc;
    @FXML
    private TableColumn<Avaliacao, String> colunaMedia;
    @FXML
    private TableColumn<Avaliacao, Double> colunaPeso;
    @FXML
    private TableColumn<Avaliacao, Double> colunaNota;
    
    @FXML
    private TableView tabela;
    
    private ObservableList dados;
    public static int index;

    public MinhasAvaliacoesFXMLController() {
        super("MinhasAvaliacoesFXML.fxml");
    }
    
    private ObservableList dadosTabela(){
        Avaliacao a1 = new Avaliacao();
        
        ArrayList<Avaliacao> lista = a1.obterListaAvaliacao();
        ObservableList dados = FXCollections.observableArrayList(lista);
        return dados;
        
    }

    public void retornar () {
        initialize(null, null);
    }
    /**
     * Initializes the controller class.
     */
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        Avaliacao a1 = new Avaliacao();
        ArrayList<Avaliacao> lista = a1.obterListaAvaliacao();
        ObservableList dados1 = FXCollections.observableArrayList(lista);
        
        this.dados=dados1;
        tabela.setItems(dados);
        
        colunaNome.setCellValueFactory(new PropertyValueFactory("nome"));
        colunaDisc.setCellValueFactory(new PropertyValueFactory("disciplina"));
        colunaPeso.setCellValueFactory(new PropertyValueFactory("peso"));
        colunaMedia.setCellValueFactory(new PropertyValueFactory("media"));
        colunaNota.setCellValueFactory(new PropertyValueFactory("nota"));
        
    }

    public void irInformarNota(ActionEvent evento){
        
        index=tabela.getSelectionModel().getSelectedIndex();
        // Caso não tenha selecionado uma matéria
        if(index!=-1){
        InformarNotaFXMLController informarNota = new InformarNotaFXMLController();
        GerenciadorJanela.obterInstancia().abreJanela(informarNota);
        }else{
            Stage erro = new Stage();
            VBox caixa =  new VBox();
            
            Label msgErro = new Label("Você não selecionou uma matéria para adicionar a nota!");
            Button retornarAvls = new Button("Voltar");
            
            retornarAvls.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent t) {
                    erro.close();
                }
            });
            caixa.getChildren().addAll(msgErro, retornarAvls);
            Scene cenaErro = new Scene(caixa);
            erro.setScene(cenaErro);
            erro.show();        
        }
    
    }
    
    public void AdicionarAvaliacao(ActionEvent evento){
        AdicionarAvlFXMLController adicionar = new AdicionarAvlFXMLController();
        GerenciadorJanela.obterInstancia().abreJanela(adicionar);
    }
    
    public void VoltarDashboard(ActionEvent evento){
        GerenciadorJanela.obterInstancia().voltar();
    }

    /**
     * @return the dados
     */
    public ObservableList getDados() {
        return dados;
    }

    /**
     * @param dados the dados to set
     */
    public void setDados(ObservableList dados) {
        this.dados = dados;
    }
    

}
