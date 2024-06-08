/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.cadastrocliente;

/**
 *
 * @author maico
 */
public class Lista {
    private Nodo inicio;
    private Nodo fim;

    public Lista() {
        this.inicio = null;
        this.fim = null;
    }

    public void adicionar(Cliente dado) {
        Nodo novoNodo = new Nodo(dado);
        if (inicio == null) {
            inicio = novoNodo;
            fim = novoNodo;
        } else {
            fim.prox = novoNodo;
            novoNodo.ant = fim;
            fim = novoNodo;
        }
    }

    public Cliente remover(String IdCliente) {
    Nodo atual = inicio;
    while (atual != null) {
        if (atual.dado.getIdCliente().equals(IdCliente)) {
        if (atual.ant != null) {
            atual.ant.prox = atual.prox;
        } else {
            inicio = atual.prox;
        }
        if (atual.prox != null) {
            atual.prox.ant = atual.ant;
        } else {
            fim = atual.ant;
        }
        return atual.dado; 
        }
        atual = atual.prox;
    }
    return null;
}

    public Cliente buscar(String IdCliente) {
        Nodo atual = inicio;
        while (atual != null) {
            if (atual.dado.getIdCliente().equals(IdCliente)) {
                return atual.dado;
            }
            atual = atual.prox;
        }
        return null;
    }

    public String mostrarTodos() {
        String todos = "";
        Nodo atual = inicio;
        while (atual != null) {
            todos += atual.dado + "\n";
            atual = atual.prox;
        }
        return todos;
    }
}