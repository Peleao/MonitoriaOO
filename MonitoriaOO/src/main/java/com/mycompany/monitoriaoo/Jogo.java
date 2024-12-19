/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.monitoriaoo;

/**
 *
 * @author Pedro Leão
 */
import static java.lang.Math.random;
import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Jogo {
    private List<Personagem> personagens = new ArrayList<>();
    private List<Monstro> monstros = new ArrayList<>();
    private List<Usavel> inventario = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    
    public void iniciar() {
        escolherPersonagem();
        configurarMonstros();
        lutarContraMonstros();
    }

    private void escolherPersonagem() {
        System.out.println("Escolha seu personagem: 1 - Guerreiro | 2 - Mago");
        int escolha = scanner.nextInt();
        switch (escolha) {
            case 1 -> personagens.add(new Guerreiro("Skanderbeg", 100, 15, 5));
            case 2 -> {
                personagens.add(new Mago("Ryze", 80, 12, 2, 70));
                
            }
            default -> {
                System.out.println("Escolha invalida, selecionando Guerreiro por padrao.");
                personagens.add(new Guerreiro("Skanderbeg", 100, 10, 5));
            }
        }
    }

    private void configurarMonstros() {
        monstros.add(new Monstro("Monstro Fraco", 30, 10, 2));
        monstros.add(new Monstro("Monstro Medio", 50, 15, 2));
        monstros.add(new Monstro("Monstro Forte", 100, 20, 2)); 
    }

    private void lutarContraMonstros() {
        for (int i = 0; i < monstros.size(); i++) {
            Monstro monstro = monstros.get(i);
            System.out.println("Voce enfrenta " + monstro.getNome() + "!");
            combater(monstro);
            
            if (i < monstros.size() - 1) {
                visitarLoja();
            }
            
            if (!personagens.get(0).estaVivo()) {
                System.out.println("Game Over! Voce foi derrotado.");
                return;
            }
        }
        System.out.println("Parabens! Voce derrotou todos os monstros! Fim de jogo");
    }

    private void combater(Monstro monstro) {
        while (personagens.get(0).estaVivo() && monstro.estaVivo()) {            
            System.out.println(personagens.get(0).getNome() + " possui " + personagens.get(0).getVida() + " de vida\n O monstro possui " + monstro.getVida() + " de vida");
            System.out.println("O que voce deseja fazer: 1-Atacar 2-Especial 3-Usar pocao");
            int escolha = scanner.nextInt();
            switch(escolha) {
                case 1 -> personagens.get(0).atacar(monstro);
                case 2 -> personagens.get(0).especial(monstro);
                case 3 -> usarPocao();
                default -> System.out.println("O valor inserido nao eh valido, perdeu o turno");
            }
            if (monstro.estaVivo()) {
                double r = random();
                int ur = (int) r * 100;
                switch(ur){
                    case 1 -> monstro.especial(personagens.get(0));
                    default -> monstro.atacar(personagens.get(0));
                }
                
            }
        }
    }
    
    private void usarPocao(){
        if(!inventario.isEmpty()){
            inventario.getFirst().usar(personagens.get(0));
            inventario.remove(0);
        }else{
            System.out.println("Nao ha pocoes no inventario");
        }
    }

    private void visitarLoja() {
        System.out.println("Bem-vindo a Loja!\n Como recompensa por derrotar o monstro voce ganhou 1 pocao! \n volte sempre!");
        Pocao pocao = new Pocao(50);
        inventario.add(pocao);
        
        
    }
    
    

}