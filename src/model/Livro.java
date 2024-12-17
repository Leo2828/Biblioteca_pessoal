package model;

public class Livro {
    private String nome;
    private String autor;
    private String genero;
    private int ano;

    public Livro(String nome, String autor, String genero, int ano) {
        this.nome = nome;
        this.autor = autor;
        this.genero = genero;
        this.ano = ano;
    }

    public Livro() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getAno() {
        return ano;
    }
    
    public void setAno(int ano) {
        this.ano = ano;
    }
}
