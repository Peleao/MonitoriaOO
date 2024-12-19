/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.monitoriaoo;

/**
 *
 * @author Pedro Leão
 */
public class Monstro extends Personagem {
    public int usou;
    public Monstro(String nome, int vida, int ataque, int defesa) {
        super(nome, vida, ataque, defesa);
        this.usou = 0;
    }

    @Override
    public void atacar(Personagem alvo) {
        int dano = Math.max(0, this.ataque - alvo.getDefesa());
        alvo.receberDano(dano);
        System.out.println(this.nome + " ataca " + alvo.getNome() + " causando " + dano + " de dano.");
    }

    @Override
    public void especial(Personagem alvo) {
        if(this.usou == 0){
            System.out.println("O monstro morde o personagem e acaba por causar 50 de dano");
            this.usou = 1;
        }else{
            System.out.println("O especial já foi usado");
        }
    }
}
