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
        capitalLabel.setFont(Font.font("Times New Roman", 50));

        Label montanteLabel = new Label("Valor do Montante: ");
        montanteLabel.setFont(Font.font("Curlz MT", 50));

        Label taxaLabel = new Label("Valor da Taxa: ");
        taxaLabel.setFont(Font.font("Jokerman", 50));

        Label tempoLabel = new Label("Valor do Tempo: ");
        tempoLabel.setFont(Font.font("Times New Roman", 50));

        Label resultadoLabel = new Label("Resultado: ");
        tempoLabel.setFont(Font.font("Arial", 50));




        janelaPrincipal.setSpacing(10);


        TextField capital = new TextField();
        capital.setFont(Font.font("Arial", 25));
        TextField taxa = new TextField();
        taxa.setFont(Font.font("Times New Roman", 25));
        TextField tempo = new TextField();
        tempo.setFont(Font.font("Jokerman", 25));
        TextField montante = new TextField();
        montante.setFont(Font.font("Curlz MT", 25));
        TextField juros = new TextField();
        juros.setFont(Font.font("Times New Roman", 25));
        TextField resultado = new TextField();



        //Image fotoBotao = new Image(getClass().getResourceAsStream("wrong.png"));
        //Button calcJuros = new Button("Calcular Juros", new ImageView(fotoBotao));
        Button calcJuros = new Button("Calcular Juros");
        calcJuros.setMinSize(150, 20);
        calcJuros.setFont(Font.font("BankGothic Lt Bt", 80));




        /* BOTÃO DE IMAGENS ALEARÓTIAS
        */
        Button imagemAleatoria = new Button("Clique para gerar uma\n imagem aleatória");
        Tooltip tip = new Tooltip("Random Stuff");
        tip.setStyle("-fx-base: #AE3522; "
                        + "-fx-text-fill: orange; ");
        tip.setFont(Font.font("Times New Roman", 30));

        imagemAleatoria.setTooltip(tip);
        imagemAleatoria.setMinSize(150, 20);
        imagemAleatoria.setFont(Font.font("Gigi", 80));

        Random rand = new Random();

        imagemAleatoria.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent t) {

                Stage aleatorio = new Stage();
                VBox random = new VBox();
                //Image imagem = new Image(getClass().getResourceAsStream((rand.nextInt(5)+1)+".jpg"));

                //Label foto = new Label("", new ImageView(imagem));

                ImageView imagem = new ImageView(new Image(getClass().getResourceAsStream((rand.nextInt(5)+1)+".jpg")));
                random.getChildren().add(imagem);
               //random.getChildren().add(scroll);

                ScrollPane scroll = new ScrollPane(random);
                scroll.setFitToHeight(true);

                BorderPane border = new BorderPane(scroll);
                border.setPadding(new Insets(15));

                //scroll.setMin(0);
                //scroll.setOrientation(Orientation.VERTICAL);

//                random.getChildren().add(foto);
//                random.getChildren().add(scroll);

                //Scene cena2 = new Scene(random, 900, 700);
                Scene cena2 = new Scene(border, 900, 700);
                aleatorio.setTitle("Imagem Aleatória");
                aleatorio.setScene(cena2);
                aleatorio.show();

            }
        } );

        // FIM DO BOTÃO DE IMAGENS ALEATÓRIAS



        // BOTÃO DE CALCULAR
        calcJuros.setOnAction(new EventHandler<ActionEvent>() {


            public void handle(ActionEvent t) {
                try{
                resultado.setText("" + (Double.parseDouble(capital.getText()) * Double.parseDouble(taxa.getText()) * Double.parseDouble(tempo.getText()) ));
                
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
                    //Image fotoErro = new Image(getClass().getResourceAsStream("ballottin.jpg"));
                    ImageView a = new ImageView(new Image(getClass().getResourceAsStream("ballottin.jpg")));
                    terrorElizandro.getChildren().addAll(endereco, a);

                    //Image erroFoto = new Image(getClass().getResourceAsStream("wrong.png"));
                    ImageView fotoBotao = new ImageView(new Image(getClass().getResourceAsStream("wrong.png")));
                    Button mostrarFoto = new Button();
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



                    Scene cenaErro = new Scene(mensagemErro, 800, 700);
                    stageErro.setScene(cenaErro);
                    stageErro.setTitle("Erro!");
                    stageErro.show();







                    // USANDO VBOX
//                    Stage erro = new Stage();
//                    VBox mensagemErro = new VBox();
//                    Label colocaDouble = new Label("Erro!!\nNão é um número. Por favor, insira um número.\nAtenciosamente, o Programador");
//                    colocaDouble.setFont(Font.font("ALGERIAN", 20));
//                    Image imagem = new Image(getClass().getResourceAsStream("wrong.png"));
//                    //Label fotinha = new Label("Erro", new ImageView(imagem));
//                    Label fotinha = new Label("",new ImageView(imagem));
//                    //fotinha.setGraphic(new ImageView(imagem));
//
//                    Button botaoSair = new Button("Sair");
//                    botaoSair.setMinSize(200, 50);
//
//                    mensagemErro.getChildren().add(colocaDouble);
//
//                    mensagemErro.getChildren().add(fotinha);
//                     mensagemErro.getChildren().add(botaoSair);
//                    Scene erroCena = new Scene(mensagemErro, 600, 800);
//                    erro.setScene(erroCena);
//                    erro.setTitle("Erro!");
//                    erro.show();
//
//                    botaoSair.setOnAction(new EventHandler<ActionEvent>() {
//                        public void handle(ActionEvent t) {
//                            erro.close();
//                        }
//                    });
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
                      
                      System.out.println(stringHistorico);
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
                
                //scrollHistorico.setFitToHeight(true);
                 scrollHistorico.setHbarPolicy(ScrollBarPolicy.NEVER);
                 scrollHistorico.setVbarPolicy(ScrollBarPolicy.ALWAYS);
                
//                BorderPane border = new BorderPane(scrollHistorico);
//                border.setPadding(new Insets(15));



                Scene cenaHistorico =  new Scene(scrollHistorico, 250, 500);
                stageHistorico.setScene(cenaHistorico);
                stageHistorico.setTitle("Histórico");
                stageHistorico.show();
                
            }
        });


        hboxCapital.getChildren().addAll(capitalLabel, capital);
        hboxMontante.getChildren().addAll(montanteLabel, montante);
        hboxTaxa.getChildren().addAll(taxaLabel, taxa);
        hboxTempo.getChildren().addAll(tempoLabel, tempo);
        hboxResultado.getChildren().addAll(resultadoLabel, resultado);



        janelaPrincipal.getChildren().addAll(hboxCapital, hboxMontante, hboxTaxa, hboxTempo, hboxResultado);
//        janelaPrincipal.getChildren().add(taxa);
//        janelaPrincipal.getChildren().add(tempo);
//        janelaPrincipal.getChildren().add(montante);
//        janelaPrincipal.getChildren().add(juros);
//        janelaPrincipal.getChildren().add(resultado);

        janelaPrincipal.getChildren().add(calcJuros);
        janelaPrincipal.getChildren().add(imagemAleatoria);
        janelaPrincipal.getChildren().add(historico);

        Scene cenaPrincipal = new Scene(janelaPrincipal, 1200, 900);
        stage.setScene(cenaPrincipal);
        stage.setTitle("Calculadora de Econômica");
        stage.show();



    }



}
