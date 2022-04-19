package usuarios;

import dataUsuarios.Data;

import java.time.LocalDate;


public class Aluno extends Pessoa{
    protected double notaFinalCurso = 0;

    public Aluno(String nome, String telefone, Data dataNascimento,
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
                "\n\nNOME DO ALUNO: " + this.nome +
                "\nTELEFONE: "+ this.telefone +
                "\nDATA DE NASCIMENTO: " + this.dataNascimento +
                "\nDATA DE CRIACAO DO USUARIO: " + getDataCriacaoUsuario()+
                "\nDATA DA ULTIMA ATUALIZACAO DO USUARIO: " + getDataAtualicacaoUsuario() +
                "\nNOTA FINAL DO CURSO: "+ this.notaFinalCurso+
                "\n________________________________________________________________________";
    }
}
