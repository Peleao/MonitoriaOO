/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.monitoriaoo;

/**
 *
 * @author Pedro Leão
 */
public abstract class Personagem {
    protected String nome;
    protected int vida;
    protected int ataque;
    protected int defesa;
    
    public Personagem(String nome, int vida, int ataque, int defesa) {
        this.nome = nome;
        this.vida = vida;
        this.ataque = ataque;
        this.defesa = defesa;

    }

    public abstract void atacar(Personagem alvo);
    
    public abstract void especial(Personagem alvo);

    public void receberDano(int dano) {
        this.vida = Math.max(0, this.vida - dano);
    }

    public boolean estaVivo() {
        return this.vida > 0;
    }

    public String getNome() {
        return nome; 
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
}
