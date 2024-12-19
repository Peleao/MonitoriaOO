/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.monitoriaoo;

/**
 *
 * @author Pedro Leão
 */
public class Mago extends Personagem {
    private int mana;
    public int usou;

    public Mago(String nome, int vida, int ataque, int defesa, int mana) {
        super(nome, vida, ataque, defesa);
        this.mana = mana;
        this.usou = 0;
    }

    @Override
    public void atacar(Personagem alvo) {
        switch(this.artefato){
            case 0 -> {
                if (mana >= 5) {
                    int dano = this.ataque * 1;
                    alvo.receberDano(dano);
                    this.mana -= 5;
                    System.out.println(this.nome + " lanca um feitico contra " + alvo.getNome() + " causando " + dano + " de dano.");
                } else {
                    System.out.println(this.nome + " nao tem mana suficiente para atacar.");
                }
            }
            case 1 -> {
                if (mana >= 5) {
                    int dano = this.ataque + 5;
                    alvo.receberDano(dano);
                    this.mana -= 5;
                    System.out.println(this.nome + " lanca um feitico contra " + alvo.getNome() + " causando " + dano + " de dano.");
                } else {
                    System.out.println(this.nome + " nao tem mana suficiente para atacar.");
                }
            }
            case 2 -> {
                if (mana >= 5) {
                    int dano = this.ataque;
                    alvo.receberDano(dano);
                    this.mana -= 5;
                    alvo.chanceCongelado();
                    System.out.println(this.nome + " lanca um feitico contra " + alvo.getNome() + " causando " + dano + " de dano.");
                } else {
                    System.out.println(this.nome + " nao tem mana suficiente para atacar.");
                }
            }
            case 3 -> {
                if (mana >= 5) {
                    int dano = this.ataque;
                    alvo.receberDano(dano);
                    this.mana -= 5;
                    this.setVida(vida + (dano/10));
                    System.out.println(this.nome + " lanca um feitico contra " + alvo.getNome() + " causando " + dano + " de dano.");
                } else {
                    System.out.println(this.nome + " nao tem mana suficiente para atacar.");
                }
            }
            case 4 -> {
                if (mana >= 5) {
                    int dano = this.ataque;
                    alvo.receberDano(dano);
                    this.mana -= 5;
                    alvo.chanceEnvenenado();
                    System.out.println(this.nome + " lanca um feitico contra " + alvo.getNome() + " causando " + dano + " de dano.");
                } else {
                    System.out.println(this.nome + " nao tem mana suficiente para atacar.");
                }
            }
        }
        
        
    }
    
    @Override
    public void especial(Personagem alvo) {
        if(usou == 0){
            setMana(mana + 40);
            setVida(this.vida + 20);
            alvo.receberDano(mana);
            System.out.println(this.nome + " usou seu especial recebendo 40 de mana, se curando em 20 e causando " + mana + " de dano");
            this.usou = 1;
        }else{
            System.out.println("O especial ja foi usado");
        }
        
    }
    public void recuperarMana(){
        setMana(mana + 5);
    }
    public int getMana() {
        return mana; 
    }
    public void setMana(int mana) {
        this.mana = mana; 
    }

    @Override
    public void especialChefao(Personagem alvo) {
        setMana(mana + 40);
        setVida(this.vida + 20);
        alvo.receberDano(mana);
        System.out.println(this.nome + " usou seu especial recebendo 40 de mana, se curando em 20 e causando " + mana + " de dano");
    }

    
}
