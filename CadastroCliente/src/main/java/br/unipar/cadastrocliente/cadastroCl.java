/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.unipar.cadastrocliente;

import javax.swing.JOptionPane;

/**
 *
 * @author maico
 */
public class cadastroCl {

    public static void main(String[] args) {
    
        CadastroCliente app = new CadastroCliente();

        while (true) {
        String escolha = JOptionPane.showInputDialog(
            "Escolha uma opção:\n" +
            "1. Gravar cadastro\n" +
            "2. Excluir cadastro\n" +
            "3. Alterar cadastro\n" +
            "4. Recuperar cadastro\n" +
            "5. Mostrar todos cadastros\n" +
            "6. Sair"
        );

        if (escolha == null || escolha.equals("6"))
            break;

        switch (escolha) {
            case "1": 
                cadastrarCliente(app);
                break;
            case "2": 
                excluirCliente(app);
                break;
            case "3": 
                alterarCliente(app);
                break;
            case "4": 
                recuperarCliente(app);
                break;
            case "5": 
                app.mostrarTodos();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opção inválida.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    }

    private static void cadastrarCliente(CadastroCliente app) {
        String idCliente = JOptionPane.showInputDialog("Código:");
        String nome = JOptionPane.showInputDialog("Nome:");
        String dtNasc = JOptionPane.showInputDialog("Data Nasc (DD/MM/AAAA):");
        String tel = JOptionPane.showInputDialog("Telefone:");
        app.gravar(idCliente, nome,dtNasc, tel);
    }

    private static void excluirCliente(CadastroCliente app) {
        String idCliente = JOptionPane.showInputDialog("Código:");
        app.excluir(idCliente);
    }

    private static void alterarCliente(CadastroCliente app) {
        String idCliente = JOptionPane.showInputDialog("Código:");
        String nome = JOptionPane.showInputDialog("Nome:");
        String dtNasc = JOptionPane.showInputDialog("Data Nasc (DD/MM/AAAA):");
        String tel = JOptionPane.showInputDialog("Telefone:");
        app.alterar(idCliente, nome, dtNasc, tel);
    }

    private static void recuperarCliente(CadastroCliente app) {
        String idCliente = JOptionPane.showInputDialog("Código:");
        app.recuperar(idCliente);
    }
}