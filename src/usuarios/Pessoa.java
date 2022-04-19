package usuarios;

import dataUsuarios.Data;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Pessoa {
    protected String nome;
    protected String telefone ;
    protected Data dataNascimento;
    protected LocalDate dataCriacaoUsuario;
    protected LocalDate dataAtualicacaoUsuario;

    public Pessoa(String nome, String telefone, Data dataNascimento,
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Data getDataNascimento() {
        return dataNascimento;
    }


    public void setDataNascimento(Data dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getDataCriacaoUsuario() {

        dataCriacaoUsuario = LocalDate.now();
        DateTimeFormatter dataCriacao = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataCriacaoFormatada = dataCriacaoUsuario.format(dataCriacao);
        return dataCriacaoFormatada;
    }

     public String getDataAtualicacaoUsuario() {

         dataAtualicacaoUsuario = LocalDate.now();
         DateTimeFormatter dataAtualizacao = DateTimeFormatter.ofPattern("dd/MM/yyyy");
         String dataAtualizacaoFormatada = dataAtualicacaoUsuario.format(dataAtualizacao);
        return dataAtualizacaoFormatada;
    }

    @Override
    public String toString() {
        return "\nNOME: "+this.nome +
                "\nTELEFONE: "+ this.telefone +
                "\nDATA DE NASCIMENTO: "+ this.dataNascimento +
                "\nDATA DA CRIACAO: "+ getDataCriacaoUsuario() +
                "\nDATA DA ULTIMA ATUALIZACAO: "+getDataAtualicacaoUsuario()+
                "\n__________________________________________________________";
    }


}
