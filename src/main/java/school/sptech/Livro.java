package school.sptech;

import school.sptech.exception.ArgumentoInvalidoException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Livro {
    private String titulo;
    private String autor;
    private LocalDate dataPublicacao;
    private List<Avaliacao>avaliacoes = new ArrayList<>();

    public Livro() {
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public List<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(List<Avaliacao> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

    public void adicionarAvaliacao(String descricao, Double qtdEstrelas){
       if (this.titulo == null){
           throw new ArgumentoInvalidoException("Argumento invalido");
       }
        if (this.autor == null){
            throw new ArgumentoInvalidoException("Argumento invalido");
        }
        if (this.dataPublicacao == null){
            throw new ArgumentoInvalidoException("Argumento invalido");
        }
        if (descricao ==  null){
            throw new ArgumentoInvalidoException("Argumento invalido");
        }
        if (descricao.isEmpty()){
           throw new ArgumentoInvalidoException("Argumento invalido");
       }

        if (descricao.equals(" ")){
            throw new ArgumentoInvalidoException("Argumento invalido");
        }
        if (qtdEstrelas == null){
            throw new ArgumentoInvalidoException("Argumento invalido");
        }

       if (qtdEstrelas < 0.0){
           throw new ArgumentoInvalidoException("Argumento invalido");
       }


       if (qtdEstrelas > 5.0){
           throw new ArgumentoInvalidoException("Argumento invalido");
       }

       Avaliacao novaAvaliacao = new Avaliacao();
       novaAvaliacao.setDescricao(descricao);
       novaAvaliacao.setQtdEstrelas(qtdEstrelas);
       avaliacoes.add(novaAvaliacao);
    }

    public Double calcularMediaAvaliacoes(){
        Double mediaAvaliacoes = 0.0;
        Double metricaAvaliacoes = 0.0;
        if (avaliacoes.isEmpty()){
            return 0.0;
        }
        for (int i = 0; i < avaliacoes.size(); i++) {
           metricaAvaliacoes = metricaAvaliacoes + avaliacoes.get(i).getQtdEstrelas();
        }
        mediaAvaliacoes = metricaAvaliacoes/avaliacoes.size();
        return mediaAvaliacoes;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", dataPublicacao=" + dataPublicacao +
                ", avaliacoes=" + avaliacoes +
                '}';
    }
}
