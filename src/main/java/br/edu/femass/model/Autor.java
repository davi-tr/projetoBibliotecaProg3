package br.edu.femass.model;

import java.util.Objects;

public class Autor {
    private String nome;
    private String sobreNome;
    private String nacionalidade;

    public Autor(){

    }

    public Autor(String nome, String sobreNome, String nacionalidade){
        this.nome = nome;
        this.sobreNome = sobreNome;
        this.nacionalidade = nacionalidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Autor autor = (Autor) o;

        if (!Objects.equals(nome, autor.nome)) return false;
        if (!Objects.equals(sobreNome, autor.sobreNome)) return false;
        return Objects.equals(nacionalidade, autor.nacionalidade);
    }

    @Override
    public String toString() {
        return (this.nome+" "+this.sobreNome+" "+this.nacionalidade);

    }
}
