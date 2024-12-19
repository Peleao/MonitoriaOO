/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.monitoriaoo;

/**
 *
 * @author Pedro Leão
 */
public class Pocao implements Usavel {
    private int cura;

    public Pocao(int cura) {
        this.cura = cura;
    }

    @Override
    public void usar(Personagem personagem) {
        personagem.setVida(personagem.getVida() + cura); 
        System.out.println(personagem.getNome() + " foi curado em " + cura + " pontos de vida.");
    }
}
