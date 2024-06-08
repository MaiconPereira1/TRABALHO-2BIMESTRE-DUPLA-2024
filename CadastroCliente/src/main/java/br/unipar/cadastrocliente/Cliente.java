/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.cadastrocliente;

/**
 *
 * @author maico
 */
public class Cliente {
    private String idCliente;
    private String nome;
    private String dtNasc;
    private String tel;

    public Cliente(String idCliente, String nome, String dtNasc, String tel) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.dtNasc = dtNasc;
        this.tel = tel;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public String getNome() {
        return nome;
    }

    public String getDtNasc() {
        return dtNasc;
    }

    public String getTel() {
        return tel;
    }

    
   @Override
    public String toString() {
    return "\nDados do cliente:\n" +
        "Código: " + idCliente + "\n" +
        "Nome: " + nome + "\n" +
        "Data de Nascimento: " + dtNasc + "\n" +
        "Telefone: " + tel;

    }
}
