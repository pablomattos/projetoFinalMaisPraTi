package usuarios;

import DataUsuarios.Data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Pessoa {
    protected String nome;
    protected int telefone;
    protected Data dataNascimento;
    protected LocalDate dataCriacaoUsuario;
    protected LocalDate dataAtualicacaoUsuario;

    public Pessoa(String nome, int telefone, Data dataNascimento,
                  LocalDate dataCriacaoUsuario, LocalDate dataAtualicacaoUsuario) {
        this.nome = nome;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.dataCriacaoUsuario = dataCriacaoUsuario;
        this.dataAtualicacaoUsuario = dataAtualicacaoUsuario;
    }

    public Pessoa(){

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public Data getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Data dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getDataCriacaoUsuario() {
        DateTimeFormatter dataCriacao = DateTimeFormatter.ofPattern("dd/MM/uuuu");
        dataCriacaoUsuario = LocalDate.now();
        return dataCriacao.format(dataCriacaoUsuario);
    }

     public String getDataAtualicacaoUsuario() {
         DateTimeFormatter dataAtualizacao = DateTimeFormatter.ofPattern("dd/MM/uuuu");
         dataAtualicacaoUsuario = LocalDate.now();
         return dataAtualizacao.format(dataAtualicacaoUsuario);

    }

    @Override
    public String toString() {
        return "NOME: "+this.nome +
                "\nTELEFONE: "+ this.telefone +
                "\nDATA DE NASCIMENTO: "+ this.dataNascimento +
                "\nDATA DA CRIACAO: "+ this.dataCriacaoUsuario +
                "\nDATA DA ULTIMA ATUALIZACAO: "+this.dataAtualicacaoUsuario;
    }
}
