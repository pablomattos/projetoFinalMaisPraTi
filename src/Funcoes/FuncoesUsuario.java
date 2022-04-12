package Funcoes;

import DataUsuarios.Data;
import usuarios.Aluno;
import usuarios.Pessoa;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class FuncoesUsuario {

    List<Pessoa> clientes = new ArrayList<>();
    List<Aluno> alunos = new ArrayList<Aluno>();


    public FuncoesUsuario() {
    }

    public List<Pessoa> getClientes() {
        return clientes;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public boolean criarUsuario() {
        String escolherUsuario = JOptionPane.showInputDialog("Voce eh estudante ? (digite S p/ sim ou N p/ N)");
        if(escolherUsuario.equalsIgnoreCase("S")) {
            Aluno usuario;
            try {

                usuario = new Aluno();

                String nomePessoa = JOptionPane.showInputDialog("NOME: ");
                usuario.setNome(nomePessoa);


                int tel = Integer.parseInt(JOptionPane.showInputDialog("TELEFONE: "));
                usuario.setTelefone(tel);

                int diaNasc = Integer.parseInt(JOptionPane.showInputDialog("DIA DE NASCIMENTO: "));
                if (diaNasc < 0 || diaNasc > 31) {
                    diaNasc = Integer.parseInt(JOptionPane.showInputDialog("DIA INVALIDO," +
                            " DIGITE UM DIA VALIDO: "));
                }

                int mesNasc = Integer.parseInt(JOptionPane.showInputDialog("MES DE NASCIMENTO: "));
                if (mesNasc < 0 || mesNasc > 12) {
                    mesNasc = Integer.parseInt(JOptionPane.showInputDialog("MES INVALIDO, " +
                            "DIGITE O NUMERO DE UM MES VALIDO: "));
                }

                int anoNasc = Integer.parseInt(JOptionPane.showInputDialog("ANO DE NASCIMENTO: "));
                if (anoNasc < 0 || anoNasc > 2022) {
                    anoNasc = Integer.parseInt(JOptionPane.showInputDialog("ANO INVALIDO, " +
                            "DIGITE UM ANO VALIDO: "));
                }
                usuario.setDataNascimento(new Data(diaNasc, mesNasc, anoNasc));

                String dataCriacao = usuario.getDataCriacaoUsuario();
                JOptionPane.showMessageDialog(null, "DATA DA CRIACAO: " +
                        dataCriacao);

                String dataAtualizacao = usuario.getDataAtualicacaoUsuario();
                JOptionPane.showMessageDialog(null, "DATA DA ULTIMA" +
                        " ATUALIZACAO: " + dataAtualizacao);

                double notaFCurso = Double.parseDouble(JOptionPane.showInputDialog("Nota " +
                        "final do curso: " +
                        "\nObs.: Caso usuario nao seja aluno clique no botao OK"));
                    if(notaFCurso >= 0 && notaFCurso <= 10){
                        usuario.setNotaFinalCurso(notaFCurso);
                    }else if(notaFCurso < 0 || notaFCurso > 10){
                        JOptionPane.showMessageDialog(null,"Nota invalida," +
                                " digite uma nota entre 0 e 10.");
                    }
                alunos.add(usuario);
            } catch (Exception e) {
                return false;
            }

            return true;

        }else if(escolherUsuario.equalsIgnoreCase("n")){
            Aluno usuario ;
            try {

                usuario = new Aluno();

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
            }catch (Exception e){
                return false;
            }

            return true;
        }else{
            JOptionPane.showMessageDialog(null,"Voce digitou uma opcao invalida");
            criarUsuario();
        }
        return false;
    }


    public void mostrarUsuario() {
        String usuarioVisualizar = JOptionPane.showInputDialog(null,
                "Qual lista de usuarios deseja visualizar?\n(Digite P p/ " +
                        "lista de pessoas ou E p/ lista de pessoas. ");
        if (usuarioVisualizar.equalsIgnoreCase("P")) {
            for (Pessoa people : getClientes()) {
                if (!getClientes().isEmpty()) {
                    System.out.println(people);
                }
            }
        } else if (usuarioVisualizar.equalsIgnoreCase("E")) {
            for (Pessoa people : getAlunos()) {
                if (!getAlunos().isEmpty()) {
                    System.out.println(people);
                }
            }
        }else{
            JOptionPane.showMessageDialog(null,"Letra invalida," +
                    " digite P p/ lista de pessoas ou E p/ lista de pessoas. ");
            mostrarUsuario();
        }
    }
    public boolean deletarUsuario() {

        String escolhePessoaDeletar = JOptionPane.showInputDialog(null,
                "Deseja deletar uma pessoa ou estudante?\n(Digite P p/ pessoa E p/ estudante.");
        if (escolhePessoaDeletar.equalsIgnoreCase("p")){
            Pessoa pessoaDeletada;

            try{

                String usuarioADeletar = JOptionPane.showInputDialog("Digite o nome da " +
                        "pessoa a deletar: ");
                int i = 0;
                while(!clientes.get(i).getNome().equalsIgnoreCase(usuarioADeletar)){
                    i++;
                    if (!clientes.get(i).getNome().equalsIgnoreCase(usuarioADeletar)){
                        usuarioADeletar = JOptionPane.showInputDialog("Usuario inexistente," +
                                " digite um nome existente. ");

                    }
                }

                String resposta = JOptionPane.showInputDialog("Deseja realmente deletar" +
                        " este usuario?\n Digite S p/ sim ou N p/ nao.");

                if(resposta.equalsIgnoreCase("S")){
                    pessoaDeletada = clientes.get(i);
                    clientes.remove(pessoaDeletada);
                    JOptionPane.showMessageDialog(null, "Usuaria(o) "+pessoaDeletada.getNome()+" foi deletado!");
                }

            }catch (Exception e){
                return false;
            }
        }else if (escolhePessoaDeletar.equalsIgnoreCase("e")){
            Aluno pessoaDeletada;

            try{

                String usuarioADeletar = JOptionPane.showInputDialog("Digite o nome de um " +
                        "aluna(o) a deletar: ");
                int i = 0;
                while(!alunos.get(i).getNome().equalsIgnoreCase(usuarioADeletar)){
                    i++;
                    if (!alunos.get(i).getNome().equalsIgnoreCase(usuarioADeletar)){
                        usuarioADeletar = JOptionPane.showInputDialog("Usuario inexistente," +
                                " digite um nome existente. ");

                    }
                }

                String resposta = JOptionPane.showInputDialog("Deseja realmente deletar" +
                        " este estudante? Digite S p/ sim ou N p/ nao.");

                if(resposta.equalsIgnoreCase("S")){
                    pessoaDeletada = alunos.get(i);
                    alunos.remove(pessoaDeletada);
                    JOptionPane.showMessageDialog(null, "Estudante deletado");
                }

            }catch (Exception e){
                return false;
            }
        } else{
            JOptionPane.showMessageDialog(null,"Letra invalida,\n digite P " +
                    "p/ deletar uma pessoa ou E p/ estudante");
            deletarUsuario();

        }

        return true;
    }

    public boolean atualizarUsuario() {

        Pessoa usuarioAtualizado;
        try{
            String usuarioAtualizar = JOptionPane.showInputDialog("Digite o nome do usuario " +
                    "que deseja atualizar: ");
            int i = 0;
            while (!clientes.get(i).getNome().equalsIgnoreCase(usuarioAtualizar)){
                i++;
                if (!clientes.get(i).getNome().equalsIgnoreCase(usuarioAtualizar)){
                    usuarioAtualizar = JOptionPane.showInputDialog("Usuario inexistente," +
                            " digite um nome existente. ");

                }
            }
            usuarioAtualizado = clientes.get(i);
            JOptionPane.showMessageDialog(null,"Atualizando dados do usuario");
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



