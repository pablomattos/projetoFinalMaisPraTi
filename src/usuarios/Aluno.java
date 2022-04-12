package usuarios;

import DataUsuarios.Data;

import java.time.LocalDate;


public class Aluno extends Pessoa{
    protected double notaFinalCurso;

    public Aluno(String nome, int telefone, Data dataNascimento,
                 LocalDate dataCriacaoUsuario, LocalDate dataAtualicacaoUsuario, double notaFInalCurso) {

        super(nome, telefone, dataNascimento, dataCriacaoUsuario, dataAtualicacaoUsuario);
        this.notaFinalCurso = notaFInalCurso;
    }

    public double getNotaFinalCurso(double notaFinalCurso) {
        return this.notaFinalCurso;
    }

    public void setNotaFinalCurso(double notaFinalCurso) {
        this.notaFinalCurso = notaFinalCurso;
    }

    public Aluno() {
    }

    @Override
    public String toString() {
        return
                "\n\n NOME: " + this.nome +
                "\nTELEFONE: "+ this.telefone +
                "\nDATA DE NASCIMENTO: " + this.dataNascimento +
                "\nDATA DE CRIACAO DO USUARIO: " + this.dataCriacaoUsuario +
                "\nDATA DA ULTIMA ATUALIZACAO DO USUARIO: " + this.dataAtualicacaoUsuario +
                "\nNOTA FINAL DO CURSO: "+ this.notaFinalCurso;
    }
}
