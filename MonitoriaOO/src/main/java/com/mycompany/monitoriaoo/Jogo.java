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
        System.out.println("");
        configurarMonstros();
        lutarContraMonstros();
        System.out.println("");
        visitarLoja2();
        System.out.println("");
        receberRecompensa();
        System.out.println("");
        configurarChefao();
        lutarContraChefao();
    }

    private void escolherPersonagem() {
        System.out.println("Escolha seu personagem: 1 - Guerreiro | 2 - Mago");
        int escolha = scanner.nextInt();
        switch (escolha) {
            case 1 -> {
                personagens.add(new Guerreiro("Skanderbeg", 100, 15, 5));
                personagens.add(new Guerreiro("Skanderbeg", 150, 25, 8));
            }
            case 2 -> {
                personagens.add(new Mago("Ryze", 80, 12, 2, 70));
                personagens.add(new Mago("Ryze", 120, 18, 3, 100));
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
                System.out.println("");
                visitarLoja();
            }
            
            if (!personagens.get(0).estaVivo()) {
                System.out.println("Game Over! Voce foi derrotado.");
                return;
            }
        }
        System.out.println("Parabens! Voce derrotou todos os monstros! seu personagem sobe de nivel e aumenta todos os atributos");
    }

    private void combater(Monstro monstro) {
        while (personagens.get(0).estaVivo() && monstro.estaVivo()) {     
            System.out.println("");
            System.out.println("");
            System.out.println(personagens.get(0).getNome() + " possui " + personagens.get(0).getVida() + " de vida\n O monstro possui " + monstro.getVida() + " de vida");
            System.out.println("O que voce deseja fazer: 1-Atacar 2-Especial 3-Usar pocao");
            int escolha = scanner.nextInt();
            switch(escolha) {
                case 1 -> personagens.get(0).atacar(monstro);
                case 2 -> personagens.get(0).especial(monstro);
                case 3 -> usarPocao(personagens.get(0));
                default -> System.out.println("O valor inserido nao eh valido, perdeu o turno");
            }
            if (monstro.estaVivo()) {
                double r = random();
                r = r *100;
                String ajuda = Double.toString(r);            
                String[] ajuda2 = ajuda.split("\\.");            
                int ur = Integer.parseInt(ajuda2[0]);
                switch(ur){
                    case 1 -> monstro.especial(personagens.get(0));
                    default -> monstro.atacar(personagens.get(0));
                }
                
            }
        }
    }
    
    private void usarPocao(Personagem alvo){
        if(!inventario.isEmpty()){
            inventario.getFirst().usar(alvo);
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
    private void visitarLoja2() {
        System.out.println("Bem-vindo a Loja!\n Como recompensa por derrotar todos os monstros voce ganhou 1 grarnde pocao! \n volte sempre!");
        Pocao pocao = new Pocao(75);
        inventario.add(pocao);
        
        
    }
    

    private void receberRecompensa() {
        System.out.println("Como recompensa por derrotar os monstros voce tem direito a escolher um artefato dentre os seguintes:");
        System.out.println("1 - Espada do rei Arthur (concede mais 5 de dano para o seu personagem) ");  
        System.out.println("2 - Cetro de Rylai (sempre que seu personagem atacar existe uma chance pequena de congelar o alvo por 1 turno)");
        System.out.println("3 - Espirito urso (voce cria um link com um espirito urso que lhe concede 10% de roubo de vida)");
        System.out.println("4 - Adagas de Valeera Sanguinar (sempre que seu personagem atacar existe uma chance pequena de envenenar o alvo pelo resto do combate");
        int escolha = scanner.nextInt();
        if(escolha > 4 || escolha < 0){
            escolha = 1;
        }
        personagens.get(1).setArtefato(escolha);
        
        
    
}

    private void lutarContraChefao() {
        while (personagens.get(1).estaVivo() && personagens.get(2).estaVivo()) {            
            System.out.println(personagens.get(1).getNome() + " possui " + personagens.get(1).getVida() + " de vida\n O chefao possui " + personagens.get(2).getVida() + " de vida");
            System.out.println("O que voce deseja fazer: 1-Atacar 2-Especial 3-Usar pocao");
            int escolha = scanner.nextInt();
            switch(escolha) {
                case 1 -> personagens.get(1).atacar(personagens.get(2));
                case 2 -> personagens.get(1).especial(personagens.get(2));
                case 3 -> usarPocao(personagens.get(1));
                default -> System.out.println("O valor inserido nao eh valido, perdeu o turno");
            }
            if (personagens.get(2).estaVivo() && !personagens.get(2).congelado) {
                double r = random();
                int ur = (int) r * 10;
                switch(ur){
                    case 1 -> personagens.get(2).especialChefao(personagens.get(1));
                    default -> personagens.get(2).atacar(personagens.get(1));
                }
                
            }
            if(personagens.get(2).congelado){
                personagens.get(2).setCongelado(false);
            }
            if(personagens.get(2).envenenado){
                personagens.get(2).setVida(personagens.get(2).getVida() - 5);
            }
            if(!personagens.get(1).estaVivo()){
                System.out.println("Game over! O chefao lhe derrotou!");
            }
            if(!personagens.get(2).estaVivo()){
                System.out.println("Parabens voce derrotou o chefao!");
            }
        }
    }

    private void configurarChefao() {
        Guerreiro chefao = new Guerreiro("Julio Cesar",200,30,10);
        personagens.add(chefao);
    }
}