/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javatrabalhom1;

import java.util.ArrayList;

/**
 *
 * @author mathias
 */
public class Avaliacao {
    
    private String nome;
    private String disciplina;
    private double peso;
    private char[] media = new char[2];
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
    public char[] getMedia() {
        return media;
    }

    /**
     * @param media the media to set
     */
    public void setMedia(char[] media) {
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
    
    public void atualizar(){
        
    }
    
    public static ArrayList<Avaliacao> obterListaAvaliacao(){
        return null;
        
        
    }
    
    public double calcularMediaDaDisciplina(String disciplina, char[] media){
        
        double mediaDisciplina = Double.parseDouble(disciplina)/3;
        
        
        return mediaDisciplina;
        
        
    }
}
