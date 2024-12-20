/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.monitoriaoo;

/**
 *
 * @author Pedro Leão
 */

    public class Guerreiro extends Personagem {    
        public int usou;
        
    public Guerreiro(String nome, int vida, int ataque, int defesa) {
        super(nome, vida, ataque, defesa);        
        this.usou = 0;
    }

    @Override
    public void atacar(Personagem alvo) {
        switch(this.artefato){
            case 0 -> {
                int dano = Math.max(0, this.ataque - alvo.getDefesa());
                alvo.receberDano(dano);
                System.out.println(this.nome + " ataca " + alvo.getNome() + " causando " + dano + " de dano.");
            }
            case 1 -> {
                int dano = Math.max(0, (this.ataque + 5) - alvo.getDefesa());
                alvo.receberDano(dano);
                System.out.println(this.nome + " ataca " + alvo.getNome() + " causando " + dano + " de dano.");
            }
            case 2 -> {
                int dano = Math.max(0, this.ataque - alvo.getDefesa());
                alvo.receberDano(dano);
                alvo.chanceCongelado();
                System.out.println(this.nome + " ataca " + alvo.getNome() + " causando " + dano + " de dano.");
            }
            case 3 -> {
                int dano = Math.max(0, this.ataque - alvo.getDefesa());
                this.setVida(vida + (dano/10));
                alvo.receberDano(dano);                
                System.out.println(this.nome + " ataca " + alvo.getNome() + " causando " + dano + " de dano.");
            }
            case 4 -> {
                int dano = Math.max(0, this.ataque - alvo.getDefesa());
                this.setVida(vida + (dano/10));
                alvo.receberDano(dano);
                alvo.chanceEnvenenado();
                System.out.println(this.nome + " ataca " + alvo.getNome() + " causando " + dano + " de dano.");
            }
        }
    }

    @Override
    public void especial(Personagem alvo) {
        if(usou == 0){
            alvo.receberDano(this.ataque + this.defesa);
            System.out.println(this.nome + " usa seu especial e causa " + (this.ataque + this.defesa) + " de dano ");
            this.usou = 1;
        }else{
            System.out.println("O especial já foi usado");
        }
    }

    @Override
    public void especialChefao(Personagem alvo) {
        alvo.receberDano(this.ataque + this.defesa);
        System.out.println(this.nome + " usa seu especial e causa " + (this.ataque + this.defesa) + " de dano ");
            
    }

    
}

