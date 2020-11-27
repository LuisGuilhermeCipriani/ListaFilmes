package br.ufjf.dcc196.luisguilhermecipriani.filmes;

public class Filme {

    private String titulo;
    private String ano;
    private String estilo;
    private String diretor;
    private Boolean assistido = false;

    public Filme(String titulo, String ano, String estilo, String diretor, Boolean assistido) {
        this.titulo = titulo;
        this.ano = ano;
        this.estilo = estilo;
        this.diretor = diretor;
        this.assistido = assistido;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public Boolean getAssistido() {
        return assistido;
    }

    public void setAssistido(Boolean assistido) {
        this.assistido = assistido;
    }
}
