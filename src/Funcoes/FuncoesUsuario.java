package Funcoes;

import DataUsuarios.Data;
import usuarios.Aluno;
import usuarios.Pessoa;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class FuncoesUsuario {

    List<Pessoa> clientes = new ArrayList<>();
    List<Aluno> usuarios02 = new ArrayList<>();

    public FuncoesUsuario() {
    }

    public List<Pessoa> getClientes() {
        return clientes;
    }

    public List<Aluno> getUsuarios02() {
        return usuarios02;
    }

    public boolean criarUsuario() {

        Pessoa usuario = new Pessoa();
        try {

            String nomePessoa = JOptionPane.showInputDialog("NOME: ");
            usuario.setNome(nomePessoa);


            int tel = Integer.parseInt(JOptionPane.showInputDialog("TELEFONE: "));
            usuario.setTelefone(tel);

            int diaNasc = Integer.parseInt(JOptionPane.showInputDialog("DIA DE NASCIMENTO: "));
            if(diaNasc < 0 || diaNasc > 31){
                diaNasc = Integer.parseInt(JOptionPane.showInputDialog("DIA INVALIDO," +
                        " DIGITE UM DIA VALIDO: "));
            }

            int mesNasc = Integer.parseInt(JOptionPane.showInputDialog("MES DE NASCIMENTO: "));
            if(mesNasc < 0 || mesNasc > 12){
                mesNasc = Integer.parseInt(JOptionPane.showInputDialog("MES INVALIDO, " +
                        "DIGITE O NUMERO DE UM MES VALIDO: "));
            }

            int anoNasc = Integer.parseInt(JOptionPane.showInputDialog("ANO DE NASCIMENTO: "));
            if(anoNasc < 0 || anoNasc > 2022){
                anoNasc = Integer.parseInt(JOptionPane.showInputDialog("ANO INVALIDO, " +
                        "DIGITE UM ANO VALIDO: "));
            }
            usuario.setDataNascimento(new Data(diaNasc, mesNasc, anoNasc));

            String dataCriacao = usuario.getDataCriacaoUsuario();
            JOptionPane.showMessageDialog(null, "DATA DA CRIACAO: " +
                    dataCriacao);

            String dataAtualizacao = usuario.getDataAtualicacaoUsuario();
            JOptionPane.showMessageDialog(null, "DATA DA ULTIMA" +
                    " ATUALIZACAO: " +dataAtualizacao);

            clientes.add(usuario);

            /*double notaFinalCurso = Double.parseDouble(JOptionPane.showInputDialog("Nota " +
                    "final do curso: " +
                    "\nObs.: Case usuario nao seja aluno digite N"));
            String letra = "N";
            if(notaFinalCurso !=  Double.parseDouble(letra)){
                usuarios02.add((Aluno) usuario);
            }else {
                usuarios.add(usuario);
            }*/
        }catch (Exception e){
            return false;
        }

        return true;
    }


    public void mostrarUsuario() {
            String criados = "USUARIOS";

            JOptionPane.showMessageDialog(null, "CLIQUE NO BOTAO OK \n" +
                    "PARA VISUALIZAR OS "+criados);
            for (Pessoa people: clientes){
                if(!clientes.isEmpty()){
                    System.out.println(people);
                }
            }
    }
    public boolean deletarUsuario() {

        Pessoa pessoaDeletada;

        try{

            String usuarioADeletar = JOptionPane.showInputDialog("Digite o nome do " +
                    "usuarío a deletar: ");
           int i = 0;
           while(!clientes.get(i).getNome().equalsIgnoreCase(usuarioADeletar)){
                i++;
               if (!clientes.get(i).getNome().equalsIgnoreCase(usuarioADeletar)){
                   usuarioADeletar = JOptionPane.showInputDialog("Usuario inexistente," +
                           " digite um nome existente. ");

               }
           }

                String resposta = JOptionPane.showInputDialog("Deseja realmente deletar" +
                        " este usuario? Digite S p/ sim ou N p/ nao.");

                if(resposta.equalsIgnoreCase("S")){
                    pessoaDeletada = clientes.get(i);
                    clientes.remove(pessoaDeletada);
                    String deletado = "deletado";
                    JOptionPane.showMessageDialog(null, "Usuario "+deletado);
                }

        }catch (Exception e){
            return false;
        }

        return true;
    }

    public boolean atualizarUsuario() {

        Pessoa usuarioAtualizado;
        try{
            String usuarioAtualizar = JOptionPane.showInputDialog("Digite o nome do usuario que deseja atualizar: ");
            int i = 0;
            while (!clientes.get(i).getNome().equalsIgnoreCase(usuarioAtualizar)){
                i++;
                if (!clientes.get(i).getNome().equalsIgnoreCase(usuarioAtualizar)){
                    usuarioAtualizar = JOptionPane.showInputDialog("Usuario inexistente," +
                            " digite um nome existente. ");

                }
            }
            String usuario = "usuario";
            usuarioAtualizado = clientes.get(i);
            JOptionPane.showMessageDialog(null,"Atualizando dados do"+usuario);
            String nomePessoa = JOptionPane.showInputDialog("NOME: ");
            usuarioAtualizado.setNome(nomePessoa);


            int tel = Integer.parseInt(JOptionPane.showInputDialog("TELEFONE: "));
            usuarioAtualizado.setTelefone(tel);

            int diaNasc = Integer.parseInt(JOptionPane.showInputDialog("DIA DE NASCIMENTO: "));
            if(diaNasc < 0 || diaNasc > 31){
                diaNasc = Integer.parseInt(JOptionPane.showInputDialog("DIA INVALIDO," +
                        " DIGITE UM DIA VALIDO: "));
            }

            int mesNasc = Integer.parseInt(JOptionPane.showInputDialog("MES DE NASCIMENTO: "));
            if(mesNasc < 0 || mesNasc > 12){
                mesNasc = Integer.parseInt(JOptionPane.showInputDialog("MES INVALIDO, " +
                        "DIGITE O NUMERO DE UM MES VALIDO: "));
            }

            int anoNasc = Integer.parseInt(JOptionPane.showInputDialog("ANO DE NASCIMENTO: "));
            if(anoNasc < 0 || anoNasc > 2022){
                anoNasc = Integer.parseInt(JOptionPane.showInputDialog("ANO INVALIDO, " +
                        "DIGITE UM ANO VALIDO: "));
            }
            usuarioAtualizado.setDataNascimento(new Data(diaNasc, mesNasc, anoNasc));

            String dataCriacao = usuarioAtualizado.getDataCriacaoUsuario();
            JOptionPane.showMessageDialog(null, "DATA DA CRIACAO: " +
                    dataCriacao);

            String dataAtualizacao = usuarioAtualizado.getDataAtualicacaoUsuario();
            JOptionPane.showMessageDialog(null, "DATA DA ULTIMA" +
                    " ATUALIZACAO: " +dataAtualizacao);

            clientes.add(usuarioAtualizado);


        }catch (Exception e){
            return false;
        }

        return true;
    }




}



