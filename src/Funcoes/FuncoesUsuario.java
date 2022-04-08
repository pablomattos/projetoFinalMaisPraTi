package Funcoes;

import DataUsuarios.Data;
import usuarios.Aluno;
import usuarios.Pessoa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FuncoesUsuario {

    List<Pessoa> usuarios = new ArrayList<Pessoa>();
    List<Aluno> usuarios02 = new ArrayList<Aluno>();

    public FuncoesUsuario() {
    }

    public boolean criarUsuario() {
        try {
            Pessoa usuario = new Pessoa();
            Scanner dadosPessoa = new Scanner(System.in);

            System.out.print("Nome: ");
            String nomePessoa = dadosPessoa.nextLine();
            usuario.setNome(nomePessoa);

            System.out.print("Telefone: ");
            int tel = dadosPessoa.nextInt();
            usuario.setTelefone(tel);

            System.out.print("Data de nascimento ");

            System.out.print("\ndia: ");
            int diaNasc = dadosPessoa.nextInt();
            if(diaNasc < 0 || diaNasc > 31){
                System.out.println("DIA INVALIDO, DIGITE UM DIA VALIDO");
                diaNasc = dadosPessoa.nextInt();
            }

            System.out.printf("mes: ");
            int mesNasc = dadosPessoa.nextInt();
            if(mesNasc < 0 || mesNasc > 12){
                System.out.println("MES INVALIDO, DIGITE O NUMERO DE UM MES VALIDO");
                mesNasc = dadosPessoa.nextInt();
            }

            System.out.printf("ano: ");
            int anoNasc = dadosPessoa.nextInt();
            if(anoNasc < 0 || anoNasc > 2022){
                System.out.println("ANO INVALIDO, DIGITE UM ANO VALIDO");
                anoNasc = dadosPessoa.nextInt();
            }

            usuario.setDataNascimento(new Data(diaNasc, mesNasc, anoNasc));

            System.out.println("Data da criacao: "+usuario.getDataCriacaoUsuario());
            System.out.println("Data da atualizacao: "+usuario.getDataAtualicacaoUsuario());

            System.out.println("Nota final do curso: ");
            double notaFinalCurso = dadosPessoa.nextFloat();
            if(notaFinalCurso >= 0){
                usuarios02.add((Aluno) usuario);
            }else{
                usuarios.add(usuario);
            }
        }catch (Exception e){
            return false;
        }
        return true;

    }


    public List<Pessoa> mostrarUsuario() {
        return null;
    }


    public boolean atualizarUsuario() {
        return false;
    }


    public boolean deletarUsuario() {
        return false;
    }


    public boolean encerrarPrograma() {
        return false;
    }
}
