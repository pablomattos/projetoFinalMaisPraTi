package Funcoes;

import DataUsuarios.Data;
import usuarios.Aluno;
import usuarios.Pessoa;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class FuncoesUsuario {

    List<Pessoa> clientes = new ArrayList<>();
    List<Aluno> alunos = new ArrayList<>();


    public FuncoesUsuario() {
    }

    public List<Pessoa> getClientes() {
        return clientes;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public boolean criarUsuario() {
        String escolherUsuario = JOptionPane.showInputDialog("Deseja criar um usuario estudante ?" +
                "\n     (digite S p/ sim ou N p/ nao)");
        if(escolherUsuario.equalsIgnoreCase("S")) {
            Aluno estudante;
            try {

                estudante = new Aluno();

                String nomePessoa = JOptionPane.showInputDialog("NOME: ");
                estudante.setNome(nomePessoa);

                String tel = JOptionPane.showInputDialog("TELEFONE COM DDD: \n" +
                        "Exemplo: 051999888777");
                int tamanho = tel.length();

                while (!(tamanho == 12)){
                    tel = JOptionPane.showInputDialog("QUANTIDADE DE DIGITOS DIFERENTE DE 12,\n DIGITE" +
                            "  O TELEFONE COM DDD: \n" +
                            "Exemplo: 051999888777");
                    tamanho = tel.length();
                }

                estudante.setTelefone(tel);

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
                estudante.setDataNascimento(new Data(diaNasc, mesNasc, anoNasc));

                String dataCriacao = estudante.getDataCriacaoUsuario();
                JOptionPane.showMessageDialog(null, "DATA DA CRIACAO: " +
                        dataCriacao);

                String dataAtualizacao = estudante.getDataAtualicacaoUsuario();
                JOptionPane.showMessageDialog(null, "DATA DA ULTIMA" +
                        " ATUALIZACAO: " + dataAtualizacao);

                double notaFCurso = Double.parseDouble(JOptionPane.showInputDialog("Nota " +
                        "final do curso: " +
                        "\nObs.: Caso estudante nao seja aluno clique no botao OK"));
                    if(notaFCurso >= 0 && notaFCurso <= 10){
                        estudante.setNotaFinalCurso(notaFCurso);
                    }else if(notaFCurso < 0 || notaFCurso > 10){
                        JOptionPane.showMessageDialog(null,"Nota invalida," +
                                " digite uma nota entre 0 e 10.");
                    }
                alunos.add(estudante);
                JOptionPane.showMessageDialog(null, "Estudante "+
                        estudante.getNome()+" foi criado com sucesso!");
            } catch (Exception e) {
                return false;
            }

        }else if(escolherUsuario.equalsIgnoreCase("n")){
            Pessoa pessoa ;
            try {

                pessoa = new Pessoa();

                String nomePessoa = JOptionPane.showInputDialog("NOME COMPLETO: ");
                pessoa.setNome(nomePessoa);


                String tel = JOptionPane.showInputDialog("TELEFONE: ");
                int tamanho = tel.length();
                while (!(tamanho == 12)){
                    tel = JOptionPane.showInputDialog("QUANTIDADE DE DIGITOS DIFERENTE DE 12,\n DIGITE" +
                            "  O TELEFONE COM DDD: \n" +
                            "Exemplo: 051999888777");
                    tamanho = tel.length();
                }

                pessoa.setTelefone(tel);

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
                pessoa.setDataNascimento(new Data(diaNasc, mesNasc, anoNasc));

                String dataCriacao = pessoa.getDataCriacaoUsuario();
                JOptionPane.showMessageDialog(null, "DATA DA CRIACAO: " +
                        dataCriacao);

                String dataAtualizacao = pessoa.getDataAtualicacaoUsuario();
                JOptionPane.showMessageDialog(null, "DATA DA ULTIMA" +
                        " ATUALIZACAO: " +dataAtualizacao);

                clientes.add(pessoa);
                JOptionPane.showMessageDialog(null, "Estudante "+
                        pessoa.getNome()+" foi criado com sucesso!");
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

        String listaUsuariosEscolhida = JOptionPane.showInputDialog(null,
                "Qual lista de usuarios deseja visualizar?\n(Digite P p/ " +
                        "lista de pessoas ou E p/ lista de estudantes. ");

        if (listaUsuariosEscolhida.equalsIgnoreCase("P")) {
            JOptionPane.showMessageDialog(null,"Relacao de pessoas: ");
            for (Pessoa people : getClientes()) {
                if (!getClientes().isEmpty()) {
                    System.out.println(people);
                }
            }
        } else if (listaUsuariosEscolhida.equalsIgnoreCase("E")) {
            JOptionPane.showMessageDialog(null,"Relacao de estudantes: ");
            for (Pessoa people : getAlunos()) {
                if (!getAlunos().isEmpty()) {
                    System.out.println(people);
                }
            }
        }else{
            JOptionPane.showMessageDialog(null,"Letra invalida," +
                    " digite P p/ lista de pessoas \nou E p/ lista de estudantes. ");
            mostrarUsuario();
        }
    }
    public boolean deletarUsuario() {

        String usuarioEscolhido = JOptionPane.showInputDialog(null,
                "O usuario que deseja deletar eh estudante ?\n" +
                        " (Digite S p/ sim ou N p/ nao)");
        if (usuarioEscolhido.equalsIgnoreCase("n")){
            Pessoa pessoaDeletada;

            try{

                String usuarioADeletar = JOptionPane.showInputDialog("Digite o nome da " +
                        "pessoa a deletar: ");
                int i = 0;
                while(!clientes.get(i).getNome().equalsIgnoreCase(usuarioADeletar)){
                    i++;
                    if (!clientes.get(i).getNome().equalsIgnoreCase(usuarioADeletar)){
                        usuarioADeletar = JOptionPane.showInputDialog("Usuaria(o) inexistente," +
                                " digite um nome existente. ");

                    }
                }

                String resposta = JOptionPane.showInputDialog("Deseja realmente deletar" +
                        " este usuario?\n Digite S p/ sim ou N p/ nao.");

                if(resposta.equalsIgnoreCase("S")){
                    pessoaDeletada = clientes.get(i);
                    clientes.remove(pessoaDeletada);
                    JOptionPane.showMessageDialog(null, "Usuaria(o) "+
                            pessoaDeletada.getNome()+" foi deletado com sucesso!");
                }

            }catch (Exception e){
                return false;
            }
        }else if (usuarioEscolhido.equalsIgnoreCase("s")){
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
                    JOptionPane.showMessageDialog(null, "Estudante "+
                            pessoaDeletada.getNome()+" foi deletado com sucesso!");
                }

            }catch (Exception e){
                return false;
            }
        } else{
            JOptionPane.showMessageDialog(null,"Letra invalida,se for " +
                    "estudante\n digite S p/ sim ou N p/ nao.");
            deletarUsuario();

        }

        return true;
    }

    public boolean atualizarUsuario() {

        String usuarioEscolhido = JOptionPane.showInputDialog(null,
                "O usuario que deseja atualizar eh estudante ?\n" +
                        " (Digite S p/ sim ou N p/ nao)");

        if(usuarioEscolhido.equalsIgnoreCase("s")){
            Pessoa usuarioAAtualizar;

            try{
                String nomeUsuarioAtualizar = JOptionPane.showInputDialog("Digite o nome do usuario\n " +
                        "que deseja atualizar: ");
                int i = 0;
                while (!clientes.get(i).getNome().equalsIgnoreCase(nomeUsuarioAtualizar)){
                    i++;
                    if (!clientes.get(i).getNome().equalsIgnoreCase(nomeUsuarioAtualizar)){
                        nomeUsuarioAtualizar = JOptionPane.showInputDialog("Usuario inexistente,\n" +
                                " digite um nome existente. ");

                    }
                }
                usuarioAAtualizar = clientes.get(i);
                JOptionPane.showMessageDialog(null,"Atualizando dados do usuario");
                String nomePessoa = JOptionPane.showInputDialog("NOME: ");
                usuarioAAtualizar.setNome(nomePessoa);


                String tel = JOptionPane.showInputDialog("TELEFONE: ");
                usuarioAAtualizar.setTelefone(tel);

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
                usuarioAAtualizar.setDataNascimento(new Data(diaNasc, mesNasc, anoNasc));

                String dataCriacao = usuarioAAtualizar.getDataCriacaoUsuario();
                JOptionPane.showMessageDialog(null, "DATA DA CRIACAO: " +
                        dataCriacao);

                String dataAtualizacao = usuarioAAtualizar.getDataAtualicacaoUsuario();
                JOptionPane.showMessageDialog(null, "DATA DA ULTIMA" +
                        " ATUALIZACAO: " +dataAtualizacao);

                clientes.add(usuarioAAtualizar);
                JOptionPane.showMessageDialog(null, "Estudante "+
                        usuarioAAtualizar.getNome()+"\n foi atualizado com sucesso!");


            }catch (Exception e){
                return false;
            }
        }else if(usuarioEscolhido.equalsIgnoreCase("n")){
            Pessoa usuarioAAtualizar;
            try{
                String nomeUsuarioAtualizar = JOptionPane.showInputDialog("Digite o nome do usuario\n " +
                        "que deseja atualizar: ");
                int i = 0;
                while (!clientes.get(i).getNome().equalsIgnoreCase(nomeUsuarioAtualizar)){
                    i++;
                    if (!clientes.get(i).getNome().equalsIgnoreCase(nomeUsuarioAtualizar)){
                        nomeUsuarioAtualizar = JOptionPane.showInputDialog("Usuario inexistente,\n" +
                                " digite um nome existente. ");

                    }
                }
                usuarioAAtualizar = clientes.get(i);
                JOptionPane.showMessageDialog(null,"Atualizando dados do usuario");
                String nomePessoa = JOptionPane.showInputDialog("NOME: ");
                usuarioAAtualizar.setNome(nomePessoa);


                String tel = JOptionPane.showInputDialog("TELEFONE: ");
                usuarioAAtualizar.setTelefone(tel);

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
                usuarioAAtualizar.setDataNascimento(new Data(diaNasc, mesNasc, anoNasc));

                String dataCriacao = usuarioAAtualizar.getDataCriacaoUsuario();
                JOptionPane.showMessageDialog(null, "DATA DA CRIACAO: " +
                        dataCriacao);

                String dataAtualizacao = usuarioAAtualizar.getDataAtualicacaoUsuario();
                JOptionPane.showMessageDialog(null, "DATA DA ULTIMA" +
                        " ATUALIZACAO: " +dataAtualizacao);

                clientes.add(usuarioAAtualizar);
                JOptionPane.showMessageDialog(null, "Estudante "+
                        usuarioAAtualizar.getNome()+"\n foi atualizado com sucesso!");


            }catch (Exception e){
                return false;
            }
        }else{
            JOptionPane.showMessageDialog(null,"Letra invalida,se for " +
                    "estudante\n digite S p/ sim ou N p/ nao.");
            atualizarUsuario();
        }

        return true;
    }

}



