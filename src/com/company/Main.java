package com.company;

import Funcoes.FuncoesUsuario;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        FuncoesUsuario funcoesUsuario = new FuncoesUsuario();

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
                    funcoesUsuario.criarUsuario();
                    break;

                case "2":
                    funcoesUsuario.mostrarUsuario();

                case "3":
                    funcoesUsuario.atualizarUsuario();
                    break;

                case "4":
                    funcoesUsuario.deletarUsuario();

                case "5":
                    System.exit(0);
                default:
                    System.out.println("OPCAO INVALIDA, SELECIONE UMA OPCAO VALIDA:");
            }
        }




    }
}
