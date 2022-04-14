package com.company;

import funcoes.FuncoesUsuario;

import javax.swing.*;

public class Main {


    public static void main(String[] args) {

        FuncoesUsuario operadorFuncoes = new FuncoesUsuario();

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
                    operadorFuncoes.criarUsuario();
                    break;

                case "2":
                    operadorFuncoes.mostrarUsuario();
                    break;

                case "3":
                    operadorFuncoes.deletarUsuario();
                    break;

                case "4":
                    operadorFuncoes.atualizarUsuario();
                    break;

                case "5":
                    System.exit(0);
                default:
                    JOptionPane.showMessageDialog(null,"Opcao invalida, digite uma opcao valida: " );

            }
        }




    }
}
