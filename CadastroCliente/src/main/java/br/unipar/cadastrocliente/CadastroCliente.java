/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.cadastrocliente;

import javax.swing.JOptionPane;
/**
 *
 * @author maico
 */

public class CadastroCliente {
   
    private Lista clientes;
    private Lista clientesExcluidos;

    public CadastroCliente() {
        this.clientes = new Lista();
        this.clientesExcluidos = new Lista();
    }

   public void gravar(String idCliente, String nome, String dtNasc, String tel) {
  
    while (idCliente == null || idCliente.isEmpty() || !idCliente.matches("\\d+")) {
        idCliente = JOptionPane.showInputDialog("Erro: O código deve conter apenas números e não pode ficar vazio.\nDigite o código novamente:");
    }
    if (clientes.buscar(idCliente) != null) {
        JOptionPane.showMessageDialog(null, "Erro: Já existe um cliente com esse código.", "Erro", JOptionPane.ERROR_MESSAGE);
        return; 
    }

    while (nome == null || nome.isEmpty() || !nome.matches("[a-zA-Z]+")) {
        nome = JOptionPane.showInputDialog("Erro: O nome deve conter apenas letras e não pode ficar vazio.\nDigite o nome novamente:");
    }
    while (dtNasc == null || dtNasc.isEmpty()) {
        dtNasc = JOptionPane.showInputDialog("Erro: A data de nascimento não pode ficar vazia.\nDigite a data de nascimento novamente (DD/MM/AAAA):");
    }
    while (tel == null || tel.isEmpty()) {
        tel = JOptionPane.showInputDialog("Erro: O telefone não pode ficar vazio.\nDigite o telefone novamente:");
    }
    Cliente cli = new Cliente(idCliente, nome, dtNasc, tel);
    clientes.adicionar(cli);
    JOptionPane.showMessageDialog(null, "Cadastro realizado.");
}

    public void excluir(String idCliente) {
        Cliente cli = clientes.remover(idCliente);
        if (cli != null) {
            clientesExcluidos.adicionar(cli);
            JOptionPane.showMessageDialog(null, "Cadastro excluído: " + cli);
        } else {
            JOptionPane.showMessageDialog(null, "Erro: Código não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void alterar(String idCliente, String nome, String dtNasc, String tel) {
        Cliente cliExistente = clientes.buscar(idCliente);
        if (cliExistente != null) {
            Cliente cli = new Cliente(idCliente, nome, dtNasc, tel);
            clientes.remover(idCliente);
            clientes.adicionar(cli);
            JOptionPane.showMessageDialog(null, "Cadastro atualizado.");
        } else {
            JOptionPane.showMessageDialog(null, "Erro: Código não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void recuperar(String idCliente) {
        Cliente cli = clientes.buscar(idCliente);
        if (cli != null) {
            JOptionPane.showMessageDialog(null, "Cadastro encontrado: " + cli);
        } else {
            cli = clientesExcluidos.buscar(idCliente);
            if (cli != null) {
                JOptionPane.showMessageDialog(null, "Cadastro encontrado (excluído): " + cli);
            } else {
                JOptionPane.showMessageDialog(null, "Erro: Código não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public void recuperarExcluido(String idCliente) {
        Cliente cli = clientesExcluidos.remover(idCliente);
        if (cli != null) {
            clientes.adicionar(cli);
            JOptionPane.showMessageDialog(null, "Cadastro recuperado (excluído): " + cli);
        } else {
            JOptionPane.showMessageDialog(null, "Erro: Código não encontrado na lista de clientes excluídos.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
   public void mostrarTodos() {
    String todos = clientes.mostrarTodos();
    String excluidos = clientesExcluidos.mostrarTodos();

    if (todos.isEmpty() && excluidos.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Nenhum cadastro encontrado.");
    } else {
        String mensagem = "Todos os cadastros:\n" + todos;
        if (!excluidos.isEmpty()) {
            mensagem += "\nCadastros excluídos:\n" + excluidos;
        }
        JOptionPane.showMessageDialog(null, mensagem);
    }
   }}