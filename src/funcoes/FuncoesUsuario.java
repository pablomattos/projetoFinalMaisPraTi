package funcoes;

import dataUsuarios.Data;
import usuarios.Aluno;
import usuarios.Pessoa;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class FuncoesUsuario {

    List<Pessoa> pessoas = new ArrayList<>();
    List<Aluno> alunos = new ArrayList<>();


    public FuncoesUsuario() {
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public boolean criarUsuario() {
        String escolherUsuario = JOptionPane.showInputDialog("Deseja criar uma pessoa ou alun@ ?" +
                "\n     (digite A p/ aluno ou P p/ pessoa)");

        if(escolherUsuario.equalsIgnoreCase("A")) {
            Aluno aluno;
            try {
                aluno = new Aluno();

                String nomeAluno = JOptionPane.showInputDialog("NOME COMPLETO: ");
                if(!alunos.isEmpty()){

                    for (int i = 0; i < alunos.size(); i++){
                        while (alunos.get(i).getNome().equalsIgnoreCase(nomeAluno)){

                            JOptionPane.showMessageDialog(null,"O NOME DESTE ALUN@ JA" +
                                    " ESTA CADASTRADO, \n  CRIE UM NOME DE USUARIO DIFERENTE: ");
                            nomeAluno = JOptionPane.showInputDialog("NOME COMPLETO: ");

                        }
                    }
                }
                aluno.setNome(nomeAluno);

                String tel = JOptionPane.showInputDialog("TELEFONE COM DDD: \n" +
                        "Exemplo: 051999888777");
                int tamanho = tel.length();

                while (!(tamanho == 12)){
                    tel = JOptionPane.showInputDialog("QUANTIDADE DE DIGITOS DIFERENTE DE 12,\n DIGITE" +
                            "  O TELEFONE COM DDD: \n" +
                            "Exemplo: 051999888777");
                    tamanho = tel.length();
                }

                aluno.setTelefone(tel);

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
                aluno.setDataNascimento(new Data(diaNasc, mesNasc, anoNasc));

                String dataCriacao = aluno.getDataCriacaoUsuario();
                JOptionPane.showMessageDialog(null, "DATA DA CRIACAO: " +
                        dataCriacao);

                String dataAtualizacao = aluno.getDataAtualicacaoUsuario();
                JOptionPane.showMessageDialog(null, "DATA DA ULTIMA" +
                        " ATUALIZACAO: " + dataAtualizacao);

                double notaFCurso = Double.parseDouble(JOptionPane.showInputDialog("Nota " +
                        "final do curso: "));
                while(notaFCurso < 0 || notaFCurso > 10){
                    notaFCurso = Double.parseDouble(JOptionPane.showInputDialog("Nota invalida," +
                            " digite uma nota entre 0 e 10."));
                }
                aluno.setNotaFinalCurso(notaFCurso);
                alunos.add(aluno);
                JOptionPane.showMessageDialog(null, "Alun@ "+
                        aluno.getNome()+" foi criad@ com sucesso!");
            } catch (Exception e) {
                return false;
            }

        }else if(escolherUsuario.equalsIgnoreCase("P")){
            Pessoa pessoa ;
            try {

                pessoa = new Pessoa();

                String nomePessoa = JOptionPane.showInputDialog("NOME COMPLETO: ");
                if(!pessoas.isEmpty()){

                    for(int i = 0; i < pessoas.size(); i ++){
                        while (pessoas.get(i).getNome().equalsIgnoreCase(nomePessoa)){
                            nomePessoa = JOptionPane.showInputDialog("O NOME DESTA PESSOA JA" +
                                    " ESTA CADASTRADO, \n  CRIE UM NOME DE USUARIO DIFERENTE: ");
                        }

                    }

                }
                pessoa.setNome(nomePessoa);

                String tel = JOptionPane.showInputDialog("TELEFONE COM DDD: \n" +
                        "Exemplo: 051999888777");
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

                pessoas.add(pessoa);
                JOptionPane.showMessageDialog(null, "Usuario "+
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
                        "lista de pessoas ou A p/ lista de alun@s. ");

        if (listaUsuariosEscolhida.equalsIgnoreCase("P")) {
            if(pessoas.isEmpty()){
                JOptionPane.showMessageDialog(null,"Nao ha pessoas na lista! ");

            }else{
                JOptionPane.showMessageDialog(null,"Relacao de pessoas: ");
                for (Pessoa people : getPessoas()) {
                    if (!getPessoas().isEmpty()) {
                        System.out.println(people);
                    }
                }
            }

        } else if (listaUsuariosEscolhida.equalsIgnoreCase("A")) {
            if(alunos.isEmpty()){
                JOptionPane.showMessageDialog(null,"Nao ha alun@s na lista! ");

            }else{
                JOptionPane.showMessageDialog(null,"Relacao de alun@s: ");
                for (Aluno people : getAlunos()) {
                    if (!getAlunos().isEmpty()) {
                        System.out.println(people);
                    }
                }
            }

        }else{
            JOptionPane.showMessageDialog(null,"Letra invalida," +
                    " digite P p/ lista de pessoas \nou E p/ lista de alun@s. ");
            mostrarUsuario();
        }
    }
    public boolean deletarUsuario() {

        String usuarioEscolhido = JOptionPane.showInputDialog(null,
                "Deseja deletar um alun@ ou uma pessoa?\n" +
                        " (Digite A p/ aluno ou P p/ pessoa)");
        if (usuarioEscolhido.equalsIgnoreCase("p")){
            Pessoa pessoaDeletada;

            try{

                String pessoaADeletar = JOptionPane.showInputDialog("Digite o nome da " +
                        "pessoa a deletar: ");
                if(pessoas.isEmpty()){
                    JOptionPane.showMessageDialog(null,"         Nao ha " +
                            "pessoas cadastradas\n para deletar,cadastre uma pessoa no criar usuario.");

                }else if (!pessoas.isEmpty()) {

                    for(int i = 0; i < pessoas.size(); i++) {

                        if(!(pessoas.get(i).getNome().equalsIgnoreCase(pessoaADeletar)) && i == pessoas.size()){

                            pessoaADeletar = JOptionPane.showInputDialog("Usuari@ inexistente," +
                                    " digite um nome existente,ou cancele para escolher outra funcao. ");

                        }else if(pessoas.get(i).getNome().equalsIgnoreCase(pessoaADeletar)){
                            String resposta = JOptionPane.showInputDialog("Deseja realmente deletar" +
                                    " esta pessoa?\n Digite S p/ sim ou N p/ nao.");

                            if (resposta.equalsIgnoreCase("S")) {
                                pessoaDeletada = pessoas.get(i);
                                pessoas.remove(pessoaDeletada);
                                JOptionPane.showMessageDialog(null, "Usuari@ " +
                                        pessoaDeletada.getNome() + " foi deletado com sucesso!");
                                break;
                            }else if(resposta.equalsIgnoreCase("N")){
                                JOptionPane.showMessageDialog(null,"ESCOLHA OUTRO " +
                                        "USUARIO QUE DESEJA DELETAR.");
                                deletarUsuario();

                            }else{
                                while(resposta.equalsIgnoreCase("s")||resposta.equalsIgnoreCase("n")){
                                    resposta = JOptionPane.showInputDialog("Digito invalido p/ deletar,\n" +
                                            "digite S p/ sim ou N p/ nao. ");
                                }
                            }
                        }
                    }
                }
            }catch (Exception e){
                return false;
            }
        }else if (usuarioEscolhido.equalsIgnoreCase("a")){
            Aluno alunoDeletado;

            try{
                String nomeAlunADeletar = JOptionPane.showInputDialog("Digite o nome de \num " +
                        "alun@ a deletar: ");
                if(alunos.isEmpty()){
                    JOptionPane.showMessageDialog(null,"             Nao ha alun@s " +
                            "cadastradas\n para deletar, cadastre uma pessoa no criar usuario");

                }
                else if(!alunos.isEmpty()){

                    for(int i = 0; i <= alunos.size(); i++){

                        if (!(alunos.get(i).getNome().equalsIgnoreCase(nomeAlunADeletar))&& i == alunos.size()){

                            nomeAlunADeletar = JOptionPane.showInputDialog("Alun@ inexistente," +
                                    " digite um nome existente,\n ou cancele para escolher outra funcao. ");


                        }else if((alunos.get(i).getNome().equalsIgnoreCase(nomeAlunADeletar))){
                            String resposta = JOptionPane.showInputDialog("Deseja realmente deletar" +
                                    " este alun@ ? \n      Digite S p/ sim ou N p/ nao.");

                            if(resposta.equalsIgnoreCase("S")){
                                alunoDeletado = alunos.get(i);
                                alunos.remove(alunoDeletado);
                                JOptionPane.showMessageDialog(null, "Alun@ "+
                                        alunoDeletado.getNome()+" foi deletad@ com sucesso!");
                            }else if(resposta.equalsIgnoreCase("N")){
                                JOptionPane.showMessageDialog(null,"ESCOLHA OUTRO " +
                                        "USUARIO QUE DESEJA DELETAR.");
                                deletarUsuario();

                            }else{
                                while(resposta.equalsIgnoreCase("s")||resposta.equalsIgnoreCase("n")){
                                    resposta = JOptionPane.showInputDialog("Digito invalido p/ deletar,\n" +
                                            "digite S p/ sim ou N p/ nao. ");
                                }
                            }

                        }
                    }
                }

            }catch (Exception e){
                return false;
            }
        } else{
            JOptionPane.showMessageDialog(null,"Letra invalida,se for " +
                    "alun@\n digite S p/ sim ou N p/ nao.");
            deletarUsuario();

        }

        return true;
    }

    public boolean atualizarUsuario() {


        String usuarioEscolhido = JOptionPane.showInputDialog(null,
                "Deseja atualizar uma pessoa ou alun@ ?\n" +
                        " (Digite P p/ pessoa ou A p/ alun@)");

        if(usuarioEscolhido.equalsIgnoreCase("A")){

            try{
                Aluno alunAtualizar = new Aluno();
                String nomeAlunAtualizar = JOptionPane.showInputDialog("Digite o nome do alun@\n " +
                        "que deseja atualizar: ");

                if(alunos.isEmpty()){
                    JOptionPane.showMessageDialog(null,"Nao eh possivel atualizar " +
                            "pois nao ha\n alun@s criad@s, cadastre um no criar usuario.");


                }else if (!alunos.isEmpty()){
                    for(int i = 0; i <= alunos.size(); i++){

                        if ((!alunos.get(i).getNome().equalsIgnoreCase(nomeAlunAtualizar))&& i == alunos.size()){

                            nomeAlunAtualizar = JOptionPane.showInputDialog("Alun@ inexistente," +
                                    " digite um nome existente,\n ou cancele para escolher outra funcao. ");


                        }else if((alunos.get(i).getNome().equalsIgnoreCase(nomeAlunAtualizar))){
                            alunos.set(i,alunAtualizar);

                            JOptionPane.showMessageDialog(null,
                                    "Vamos atualizar os dados d@ "+ nomeAlunAtualizar);
                            String nomeAluno = JOptionPane.showInputDialog("NOME D@ ALUN@: ");
                            alunAtualizar.setNome(nomeAluno);

                            String tel = JOptionPane.showInputDialog("TELEFONE COM DDD: \n" +
                                    "Exemplo: 051999888777");
                            int tamanho = tel.length();
                            while (!(tamanho == 12)){
                                tel = JOptionPane.showInputDialog("QUANTIDADE DE DIGITOS DIFERENTE DE 12,\n DIGITE" +
                                        "  O TELEFONE COM DDD: \n" +
                                        "Exemplo: 051999888777");
                                tamanho = tel.length();
                            }
                            alunAtualizar.setTelefone(tel);

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
                            alunAtualizar.setDataNascimento(new Data(diaNasc, mesNasc, anoNasc));

                            String dataCriacao = alunAtualizar.getDataCriacaoUsuario();
                            JOptionPane.showMessageDialog(null, "DATA DA CRIACAO: " +
                                    dataCriacao);

                            String dataAtualizacao = alunAtualizar.getDataAtualicacaoUsuario();
                            JOptionPane.showMessageDialog(null, "DATA DA ULTIMA" +
                                    " ATUALIZACAO: " +dataAtualizacao);

                            double notaFCurso = Double.parseDouble(JOptionPane.showInputDialog("Nota " +
                                    "final do curso: "));
                            if(notaFCurso >= 0 && notaFCurso <= 10){
                                alunAtualizar.setNotaFinalCurso(notaFCurso);
                            }else if(notaFCurso < 0 || notaFCurso > 10){
                                JOptionPane.showMessageDialog(null,"Nota invalida,\n" +
                                        " digite uma nota entre 0 e 10.");
                            }

                            JOptionPane.showMessageDialog(null, "Alun@ "+
                                    alunAtualizar.getNome()+"\n foi atualizad@ com sucesso!");
                            break;
                        }
                    }

                }

            }catch (Exception e){
                return false;
            }
        }else if(usuarioEscolhido.equalsIgnoreCase("P")){

            try{
                Pessoa pessoaAtualizar = new Pessoa();
                String nomePessoaAtualizar = JOptionPane.showInputDialog("Digite o nome de uma pessoa\n " +
                        "que deseja atualizar: ");

                if(pessoas.isEmpty()){
                    JOptionPane.showMessageDialog(null,"Nao eh possivel atualizar " +
                            "pois nao ha\n pessoas criadas, cadastre uma no criar usuario.");

                }else if(!pessoas.isEmpty()){
                    for(int i = 0; i < pessoas.size(); i++){

                        if(!(pessoas.get(i).getNome().equalsIgnoreCase(nomePessoaAtualizar)) && i == pessoas.size()){
                            nomePessoaAtualizar = JOptionPane.showInputDialog(null,
                                    " Nome inexistente, digite o nome completo\n      " +
                                            "ou cancel e escolha outra funcao. ");

                        }else if((pessoas.get(i).getNome().equalsIgnoreCase(nomePessoaAtualizar))){
                            JOptionPane.showMessageDialog(null,
                                    "Vamos atualizar os dados d@ "+nomePessoaAtualizar);
                            pessoas.set(i,pessoaAtualizar);

                            String nomePessoa = JOptionPane.showInputDialog("NOME: ");
                            pessoaAtualizar.setNome(nomePessoa);

                            String tel = JOptionPane.showInputDialog("TELEFONE COM DDD: \n" +
                                    "Exemplo: 051999888777");
                            pessoaAtualizar.setTelefone(tel);

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
                            pessoaAtualizar.setDataNascimento(new Data(diaNasc, mesNasc, anoNasc));

                            String dataCriacao = pessoaAtualizar.getDataCriacaoUsuario();
                            JOptionPane.showMessageDialog(null, "DATA DA CRIACAO: " +
                                    dataCriacao);

                            String dataAtualizacao = pessoaAtualizar.getDataAtualicacaoUsuario();
                            JOptionPane.showMessageDialog(null, "DATA DA ULTIMA" +
                                    " ATUALIZACAO: " +dataAtualizacao);

                            JOptionPane.showMessageDialog(null, "Usuario "+
                                    pessoaAtualizar.getNome()+"\n foi atualizado com sucesso!");
                            break;
                        }
                    }
                }
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



