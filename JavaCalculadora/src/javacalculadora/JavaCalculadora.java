/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javacalculadora;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
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
    public void start(Stage stage) throws FileNotFoundException, IOException {
        System.out.println("O palco esta pronto.");

        VBox janelaPrincipal =  new VBox();
        janelaPrincipal.setStyle("-fx-background-color: #babaca;" + "-fx-base: #AE3522; "
                        + "-fx-text-fill: orange; ");
        
        janelaPrincipal.setAlignment(Pos.CENTER);

        HBox hboxCapital = new HBox();
        hboxCapital.setSpacing(3);
        hboxCapital.setAlignment(Pos.CENTER);

        HBox hboxMontante = new HBox();
        hboxMontante.setSpacing(3);
        hboxMontante.setAlignment(Pos.CENTER);

        HBox hboxTaxa = new HBox();
        hboxTaxa.setSpacing(3);
        hboxTaxa.setAlignment(Pos.CENTER);

        HBox hboxTempo = new HBox();
        hboxTempo.setSpacing(3);
        hboxTempo.setAlignment(Pos.CENTER);

        HBox hboxResultado = new HBox();
        hboxResultado.setSpacing(3);
        hboxResultado.setAlignment(Pos.CENTER);

        Label capitalLabel = new Label("Valor do Capital: ");
        capitalLabel.setFont(Font.font("Times New Roman", 35));

        Label montanteLabel = new Label("Valor do Montante: ");
        montanteLabel.setFont(Font.font("Curlz MT", 35));

        Label taxaLabel = new Label("Valor da Taxa: ");
        taxaLabel.setFont(Font.font("Jokerman", 35));

        Label tempoLabel = new Label("Valor do Tempo: ");
        tempoLabel.setFont(Font.font("Times New Roman", 35));

        Label resultadoLabel = new Label("Resultado: ");
        resultadoLabel.setFont(Font.font("Arial", 35));




        janelaPrincipal.setSpacing(10);


        TextField capital = new TextField();
        capital.setFont(Font.font("Arial", 15));
        TextField taxa = new TextField();
        taxa.setFont(Font.font("Times New Roman", 15));
        TextField tempo = new TextField();
        tempo.setFont(Font.font("Jokerman", 15));
        TextField montante = new TextField();
        montante.setFont(Font.font("Curlz MT", 15));
        TextField juros = new TextField();
        juros.setFont(Font.font("Times New Roman", 15));
        TextField resultado = new TextField();


        /* BOTÃO DE IMAGENS ALEARÓTIAS
        */
        Button imagemAleatoria = new Button("Clique para gerar uma imagem aleatória");
        Tooltip tip = new Tooltip("Random Stuff");
        tip.setStyle("-fx-base: #AE3522; "
                        + "-fx-text-fill: orange; ");
        tip.setFont(Font.font("Times New Roman", 15));

        imagemAleatoria.setTooltip(tip);
        imagemAleatoria.setMinSize(150, 20);
        imagemAleatoria.setFont(Font.font("Gigi", 35));

        Random rand = new Random();

        imagemAleatoria.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent t) {

                Stage aleatorio = new Stage();
                VBox random = new VBox();

                ImageView imagem = new ImageView(new Image(getClass().getResourceAsStream((rand.nextInt(4)+1)+".jpg")));
                random.getChildren().add(imagem);

                ScrollPane scroll = new ScrollPane(random);
                scroll.setFitToHeight(true);

                BorderPane border = new BorderPane(scroll);
                border.setPadding(new Insets(15));

                Scene cena2 = new Scene(border, 1024, 768);
                aleatorio.setTitle("Imagem Aleatória");
                aleatorio.setScene(cena2);
                aleatorio.show();

            }
        } );

        // FIM DO BOTÃO DE IMAGENS ALEATÓRIAS


        Button calcJuros = new Button("Calcular Juros");
        calcJuros.setMinSize(150, 20);
        calcJuros.setFont(Font.font("BankGothic Lt Bt", 35));
        
        // BOTÃO DE CALCULAR
        calcJuros.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent t) {
                try{
                resultado.setText("" + (Double.parseDouble(capital.getText()) * Double.parseDouble(taxa.getText()) * Double.parseDouble(tempo.getText()) ));
                
                // Escrita no arquivo do histórico
                    try{              
                    File arqv = new File("historico.txt");
                    
                    if(arqv.exists()!=true)
                        arqv.createNewFile();
                    
                    FileWriter arquivoEscrever = new FileWriter(arqv, true);
                    BufferedWriter bw = new BufferedWriter(arquivoEscrever);
                    bw.write("=========================\n");
                    bw.write("Capital = "+capital.getText()+"\n");
                    bw.write("Taxa = "+taxa.getText()+"\n");
                    bw.write("Tempo = "+tempo.getText()+"\n");
                    bw.write("Montante = "+montante.getText()+"\n");
                    bw.write("Resultado = "+resultado.getText()+"\n");
                    bw.write("=========================\n");                   
                    bw.close();
	  	}catch(Exception e){}
                
                
                }catch(Exception e){
                    // Caso o usuário insira uma letra como entrada
                    // USANDO BORDERPANE
                    Stage stageErro = new Stage();
                    BorderPane mensagemErro = new BorderPane();      
                    try{
                        
                        File arqv = new File("historico.txt");

                        if(arqv.exists()!=true)
                            arqv.createNewFile();

                        FileWriter arquivoEscrever = new FileWriter(arqv, true);
                        BufferedWriter bw = new BufferedWriter(arquivoEscrever);
                        bw.write("=========================\n");
                        bw.write("Capital = "+capital.getText()+"\n");
                        bw.write("Taxa = "+taxa.getText()+"\n");
                        bw.write("Tempo = "+tempo.getText()+"\n");
                        bw.write("Montante = "+montante.getText()+"\n");
                        bw.write("Resultado = ERRO\n");
                        bw.write("=========================\n");
                        bw.close();
                        
                    }catch(Exception b){}

                    Label colocaDouble = new Label("\tErro!!\n\tNão é um número. Por favor, insira um número.\n\t\tAtenciosamente, o Programador");
                    colocaDouble.setFont(Font.font("ALGERIAN", 20));
                    colocaDouble.setStyle("-fx-text-fill: blue; ");

                    VBox terrorElizandro = new VBox();
                    Label endereco = new Label("\tMuda o endereço de memória vacilão!");
                    ImageView a = new ImageView(new Image(getClass().getResourceAsStream("ballottin.jpg")));
                    
                    
                    terrorElizandro.getChildren().addAll(endereco, a);

                    ImageView fotoBotao = new ImageView(new Image(getClass().getResourceAsStream("wrong.png")));

                    Button mostrarFoto = new Button();
                    mostrarFoto.setMaxSize(50, 50);
                    mostrarFoto.setGraphic(fotoBotao);
                                  
                    Tooltip tipFechar = new Tooltip("Clique para fechar");
                    tipFechar.setFont(Font.font(20));
                    mostrarFoto.setTooltip(tipFechar);
                   
                    mostrarFoto.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent t) {
                            stageErro.close();
                        }
                    });
                    
                    mensagemErro.setCenter(mostrarFoto);
                    mensagemErro.setRight(terrorElizandro);
                    mensagemErro.setTop(colocaDouble);

                    Scene cenaErro = new Scene(mensagemErro, 850, 700);
                    stageErro.setScene(cenaErro);
                    stageErro.setTitle("Erro!");
                    stageErro.show();
                }

            }
        });

        // FIM DO BOTÃO DE CALCULAR
        

        Button historico = new Button("Histórico");
        Tooltip dicaHistorico = new Tooltip("Ele sabe o que você fez ( ͡° ͜ʖ ͡°)");
        dicaHistorico.setStyle("-fx-text-fill: orange; ");
        dicaHistorico.setFont(Font.font("Source Code Pro", 25));
        historico.setTooltip(dicaHistorico);

        historico.setMinSize(50,60);
         // INÍCIO DO BOTÃO DE HISTÓRICO
        historico.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                Stage stageHistorico = new Stage();

                VBox boxHistorico = new VBox();
                Label mostarHistorico = new Label();

                String stringHistorico = "";
                String lena = "";
                  BufferedReader br = null;
                FileReader fr = null;
                System.out.println(stringHistorico);

                try{
                   fr = new FileReader("historico.txt");
                   br = new BufferedReader(fr);
                 

                  while ( (lena= br.readLine()) != null) {
                      stringHistorico+="\n" +lena;
                      mostarHistorico.setText(mostarHistorico.getText()+"\n"+lena);
                  }

                }catch(IOException e){
                  }finally{
                      try{
                          if(br!=null)
                              br.close();
                          
                          if(fr!=null)
                              fr.close();
                          
                      }catch(IOException ex){}

              } // FIM DO ARQUIVO

                mostarHistorico.setText(stringHistorico);
                boxHistorico.getChildren().add(mostarHistorico);
                
                ScrollPane scrollHistorico = new ScrollPane(boxHistorico);
                             
                scrollHistorico.setHbarPolicy(ScrollBarPolicy.NEVER);
                scrollHistorico.setVbarPolicy(ScrollBarPolicy.ALWAYS);

                Scene cenaHistorico =  new Scene(scrollHistorico, 250, 500);
                stageHistorico.setScene(cenaHistorico);
                stageHistorico.setTitle("Histórico");
                stageHistorico.show();
                
            }
        });
        // FIM DO BOTÃO DE HISTÓRICO


        hboxCapital.getChildren().addAll(capitalLabel, capital);
        hboxMontante.getChildren().addAll(montanteLabel, montante);
        hboxTaxa.getChildren().addAll(taxaLabel, taxa);
        hboxTempo.getChildren().addAll(tempoLabel, tempo);
        hboxResultado.getChildren().addAll(resultadoLabel, resultado);

        janelaPrincipal.getChildren().addAll(hboxCapital, hboxMontante, hboxTaxa, hboxTempo, hboxResultado);

        janelaPrincipal.getChildren().add(calcJuros);
        janelaPrincipal.getChildren().add(imagemAleatoria);
        janelaPrincipal.getChildren().add(historico);

        Scene cenaPrincipal = new Scene(janelaPrincipal, 800, 600);
        stage.setScene(cenaPrincipal);
        stage.setTitle("Calculadora de Econômica");
        stage.show();

    }

}
