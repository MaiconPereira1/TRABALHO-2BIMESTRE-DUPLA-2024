/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.cadastrocliente;

/**
 *
 * @author maico
 */
public class Nodo {
    Cliente dado;
    Nodo prox;
    Nodo ant;

    public Nodo(Cliente dado) {
        this.dado = dado;
        this.prox = null;
        this.ant = null;
    }
}
