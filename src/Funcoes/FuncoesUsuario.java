package Funcoes;

import DataUsuarios.Data;
import usuarios.Aluno;
import usuarios.Pessoa;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class FuncoesUsuario {

    List<Pessoa> usuarios;
    List<Aluno> usuarios02;

    public FuncoesUsuario() {
    }


    public boolean criarUsuario() {
        usuarios = new ArrayList<>();
        usuarios02 = new ArrayList<>();
        try {
            Pessoa usuario = new Pessoa();

            String nomePessoa = JOptionPane.showInputDialog("Nome: ");
            usuario.setNome(nomePessoa);

            System.out.print("Telefone: ");
            int tel = Integer.parseInt(JOptionPane.showInputDialog("Telefone: "));
            usuario.setTelefone(tel);

            JOptionPane.showMessageDialog(null, "DATA DE NASCIMENTO");

            int diaNasc = Integer.parseInt(JOptionPane.showInputDialog("Dia de nascimento: "));
            if(diaNasc < 0 || diaNasc > 31){
                diaNasc = Integer.parseInt(JOptionPane.showInputDialog("DIA INVALIDO," +
                        " DIGITE UM DIA VALIDO: "));
            }

            int mesNasc = Integer.parseInt(JOptionPane.showInputDialog("Mes de nascimento: "));
            if(mesNasc < 0 || mesNasc > 12){
                mesNasc = Integer.parseInt(JOptionPane.showInputDialog("MES INVALIDO, " +
                        "DIGITE O NUMERO DE UM MES VALIDO"));
            }

            int anoNasc = Integer.parseInt(JOptionPane.showInputDialog("Ano de nascimento: "));
            if(anoNasc < 0 || anoNasc > 2022){
                anoNasc = Integer.parseInt(JOptionPane.showInputDialog("ANO INVALIDO, " +
                        "DIGITE UM ANO VALIDO"));
            }
            usuario.setDataNascimento(new Data(diaNasc, mesNasc, anoNasc));

            String dataCriacao = usuario.getDataCriacaoUsuario();
            JOptionPane.showMessageDialog(null, "Data da criacao: " +
                    dataCriacao);

            String dataAtualizacao = usuario.getDataAtualicacaoUsuario();
            JOptionPane.showMessageDialog(null, "Data da ultima " +
                    "atualizacao: " +dataAtualizacao);

            double notaFinalCurso = Double.parseDouble(JOptionPane.showInputDialog("Nota " +
                    "final do curso: " +
                    "\nObs.: Case usuario nao seja aluno digite N"));
            String letra = "N";
            if(notaFinalCurso !=  Double.parseDouble(letra)){
                usuarios02.add((Aluno) usuario);
            }else {
                usuarios.add(usuario);
            }
        }catch (Exception e){
            return false;
        }
        return true;
    }


    public void mostrarUsuario() {
        for (Pessoa todasPessoas: usuarios ) {
            System.out.println(todasPessoas);
        }

    }


    public boolean atualizarUsuario() {
        return false;
    }


    public boolean deletarUsuario() {
        return false;
    }
}



