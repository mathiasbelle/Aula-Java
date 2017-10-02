/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javatrabalhom1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.ObservableList;

/**
 *
 * @author mathias
 */
public class Avaliacao {
    
    private String nome;
    private String disciplina;
    private double peso;
    private String media;
    private double nota;
    private int identificadorArquivo;

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the disciplina
     */
    public String getDisciplina() {
        return disciplina;
    }

    /**
     * @param disciplina the disciplina to set
     */
    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    /**
     * @return the peso
     */
    public double getPeso() {
        return peso;
    }

    /**
     * @param peso the peso to set
     */
    public void setPeso(double peso) {
        this.peso = peso;
    }

    /**
     * @return the media
     */
    public String getMedia() {
        return media;
    }

    /**
     * @param media the media to set
     */
    public void setMedia(String media) {
        this.media = media;
    }

    /**
     * @return the nota
     */
    public double getNota() {
        return nota;
    }

    /**
     * @param nota the nota to set
     */
    public void setNota(double nota) {
        this.nota = nota;
    }

    /**
     * @return the identificadorArquivo
     */
    public int getIdentificadorArquivo() {
        return identificadorArquivo;
    }

    /**
     * @param identificadorArquivo the identificadorArquivo to set
     */
    public void setIdentificadorArquivo(int identificadorArquivo) {
        this.identificadorArquivo = identificadorArquivo;
    }
    
    public void salvar(){
        
        
        
    }
    
//        private String nome;
//    private String disciplina;
//    private double peso;
//    private char[] media = new char[2];
//    private double nota;
//    private int identificadorArquivo;
    

    
    public void atualizar() throws IOException{         
        File f = new File("teste.csv");
        List<String> lines = Files.readAllLines(f.toPath());
        lines.remove(MinhasAvaliacoesFXMLController.index);
        lines.add(MinhasAvaliacoesFXMLController.index, this.disciplina + "," + this.getMedia() + "," + this.nome + "," + this.peso + "," + this.nota);
        Files.write(f.toPath(), lines, StandardCharsets.UTF_8);
        
    }
    
    public ArrayList<Avaliacao> obterListaAvaliacao(){
        
           //ObservableList<Avaliacao> listaAvl = null;
        Avaliacao aval = new Avaliacao();
        ArrayList<String> a1 = new ArrayList<>();
        ArrayList<Avaliacao> a2 = new ArrayList<>();
        a2.clear();
        
        BufferedReader br = null;
        FileReader fr = null;
        
        try{
        String stringTabela="";
        File arqv = new File("teste.csv");
        if(!arqv.exists())
            arqv.createNewFile();
//        BufferedReader br = null;
//        FileReader fr = null;
        

//        ArrayList<String> a1 = new ArrayList<>();
//        ArrayList<Avaliacao> a2 = new ArrayList<>();
        
            System.out.println("tamanho : "+arqv.length());
            //fr = new FileReader("teste.csv");
            if(arqv.length()!=0){
            
            br = new BufferedReader(new FileReader(arqv));
            while((stringTabela = br.readLine()) != null){
                a1.add(stringTabela);
            }
            System.out.println("StringTabela: "+stringTabela);
            
                System.out.println("Entrou");
            Avaliacao avl;
            for (int i = 0; i < a1.size(); i++) {
                
                String[] cortar = a1.get(i).split(",");
                
                avl = new Avaliacao();
                System.out.println("Cortar disc: "+cortar[0]);
                avl.setDisciplina(cortar[0]);
                avl.setMedia(cortar[1]);
                avl.setNome(cortar[2]);
                avl.setPeso(Double.parseDouble(cortar[3]));
                if(cortar.length>=5){
                    System.out.println("Nota nkwefnjenjwef: "+Double.parseDouble(cortar[4]) );
                    avl.setNota(Double.parseDouble(cortar[4]));
                    System.out.println("Nota efbhwefybewufbwue: "+Double.parseDouble(cortar[4]) );
                }else
                    avl.setNota(0.0);
                a2.add(avl);
            
            }
        }else
                return a2;
            

        } catch (IOException e) {
        } finally {
            try {
                if (br != null) {
                    br.close();
                }

                if (fr != null) {
                    fr.close();
                }

            } catch (IOException ex) {
            }

        } // FIM DO ARQUIVO
        
        return a2;
        
        
    }
    
    public double calcularMediaDaDisciplina(String disciplina, char[] media){
        
        double mediaDisciplina = Double.parseDouble(disciplina)/3;
        
        
        return mediaDisciplina;
        
        
    }
}
