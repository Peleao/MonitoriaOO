/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.monitoriaoo;

import static java.lang.Math.random;

/**
 *
 * @author Pedro Leão
 */
public abstract class Personagem {
    protected String nome;
    protected int vida;
    protected int ataque;
    protected int defesa;
    protected int artefato;
    protected boolean congelado = false;
    protected boolean envenenado = false;
    public Personagem(String nome, int vida, int ataque, int defesa) {
        this.nome = nome;
        this.vida = vida;
        this.ataque = ataque;
        this.defesa = defesa;
        this.artefato = 0;
    }

    public abstract void atacar(Personagem alvo);
    
    public abstract void especial(Personagem alvo);
    
    public abstract void especialChefao(Personagem alvo);
    
    public void chanceCongelado(){
        double r = random();
        r = r *10;
        String ajuda = Double.toString(r);            
        String[] ajuda2 = ajuda.split("\\.");            
        int ur = Integer.parseInt(ajuda2[0]);
                
                switch(ur){
                    case 1 -> {
                        setCongelado(true);
                        System.out.println("Congelou o alvo");
                    }
                    default -> System.out.println("Nao congelou o alvo");
                }
    }
    
    public void chanceEnvenenado(){
        double r = random();
        r = r *10;
        String ajuda = Double.toString(r);            
        String[] ajuda2 = ajuda.split("\\.");            
        int ur = Integer.parseInt(ajuda2[0]);
                switch(ur){
                    case 1 -> {
                        setEnvenenado(true);
                        System.out.println("Envenenou o alvo");
                    }
                    default -> System.out.println("Nao envenenou alvo");
                }
    }
    
    
    public void receberDano(int dano) {
        this.vida = Math.max(0, this.vida - dano);
    }

    public boolean isEnvenenado() {
        return envenenado;
    }

    public void setEnvenenado(boolean envenenado) {
        this.envenenado = envenenado;
    }

    public boolean estaVivo() {
        return this.vida > 0;
    }

    public String getNome() {
        return nome; 
    }

    public boolean isCongelado() {
        return congelado;
    }

    public void setCongelado(boolean congelado) {
        this.congelado = congelado;
    }
    
    public void setNome(String nome) { 
        this.nome = nome; 
    }
    
    public int getVida() { 
        return vida; 
    }
    
    public void setVida(int vida) { 
        this.vida = vida; 
    }
    
    public int getAtaque() { 
        return ataque; 
    }
    
    public void setAtaque(int ataque) {
        this.ataque = ataque; 
    }
    
    public int getDefesa() { 
        return defesa; 
    }
    
    public void setDefesa(int defesa) { 
        this.defesa = defesa; 
    }

    public int getArtefato() {
        return artefato;
    }

    public void setArtefato(int artefato) {
        this.artefato = artefato;
    }

    
    
}
