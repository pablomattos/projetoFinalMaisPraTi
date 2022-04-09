package com.company;

import Funcoes.FuncoesUsuario;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        FuncoesUsuario criar = new FuncoesUsuario();
        FuncoesUsuario mostrar = new FuncoesUsuario();
        FuncoesUsuario deletar = new FuncoesUsuario();
        FuncoesUsuario atualizar = new FuncoesUsuario();

        String opcao;
        while (true){
            opcao = JOptionPane.showInputDialog("Escolha a funcao a realizar:" +
                    "\n1 - Criar usuario" +
                    "\n2 - Mostrar usuarios" +
                    "\n3 - Deletar usuario por nome" +
                    "\n4 - Atualizar usuario por nome" +
                    "\n5 - Encerrar programa");

            switch (opcao){
                case "1":
                    criar.criarUsuario();
                    break;

                case "2":
                    mostrar.mostrarUsuario();
                    break;

                case "3":
                    atualizar.atualizarUsuario();
                    break;

                case "4":
                    deletar.deletarUsuario();

                case "5":
                    System.exit(0);
                default:
                    JOptionPane.showInputDialog("Opcao invalida, digite uma opcao valida: " );

            }
        }




    }
}
