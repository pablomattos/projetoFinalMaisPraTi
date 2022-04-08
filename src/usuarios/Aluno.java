package usuarios;

import DataUsuarios.Data;

import java.time.LocalDate;
import java.util.Date;

public class Aluno extends Pessoa{
    protected double notaFInalCurso;

    public Aluno(String nome, int telefone, Data dataNascimento,
                 LocalDate dataCriacaoUsuario, LocalDate dataAtualicacaoUsuario, double notaFInalCurso) {

        super(nome, telefone, dataNascimento, dataCriacaoUsuario, dataAtualicacaoUsuario);
        this.notaFInalCurso = notaFInalCurso;
    }

    public Aluno() {
    }

    @Override
    public String toString() {
        return
               "NOME: " + this.nome +
                "\nTELEFONE"+ this.telefone +
                "\nDATA DE NASCIMENTO: " + this.dataNascimento +
                "\nDATA DA CRIACAO DO USUARIO: " + this.dataCriacaoUsuario +
                "\nDATA DA ULTIMA ATUALIZACAO DO USUARIO: " + this.dataAtualicacaoUsuario +
                "\nNOTA FINAL DO CURSO: "+ this.notaFInalCurso;
    }
}
