package school.sptech;

import school.sptech.exception.ArgumentoInvalidoException;
import school.sptech.exception.LivroNaoEncontradoException;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
private String nome;
private List<Livro>livros = new ArrayList<>();

    public Biblioteca(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Biblioteca() {}

    public void adicionarLivro(Livro livro){
    if (livro == null){
        throw new ArgumentoInvalidoException("Livro nulo");
    }
    if (livro.getAutor()== null){
        throw new ArgumentoInvalidoException("Autor nulo");
    }
    if (livro.getAutor().isBlank()){
        throw new ArgumentoInvalidoException("Autor nulo");
    }
    if (livro.getTitulo()== null){
        throw new ArgumentoInvalidoException("Titulo nulo");
    }
    if (livro.getTitulo().isBlank()){
        throw new ArgumentoInvalidoException("Titulo nulo");
    }
    if (livro.getDataPublicacao() == null){
        throw new ArgumentoInvalidoException("Data nula");
    }

    livros.add(livro);
    }

    public void removerLivroPorTitulo(String titulo){
    Integer livroNaoEncontrado = 0;
    if (titulo == null){
        throw new ArgumentoInvalidoException("Titulo Nulo");
    }
    if (titulo.isEmpty()) {
        throw new ArgumentoInvalidoException("Titulo Nulo");
    }
    if (titulo.equals(" ")){
        throw new ArgumentoInvalidoException("Titulo Nulo");
    }
    for (int i = 0; i < livros.size(); i++) {
        if(titulo.equalsIgnoreCase(livros.get(i).getTitulo())){
            livroNaoEncontrado = 1;
            livros.remove(livros.get(i));
        }
    }
    if (livroNaoEncontrado == 0){
        throw new LivroNaoEncontradoException("Livro não encontrado");
    }
    }

    public Livro buscarLivroPorTitulo(String titulo){
    Integer livroNaoEncontrado = 0;
    Livro livroCorreto = null;
    if (titulo == null){
        throw new ArgumentoInvalidoException("Titulo Nulo");
    }
    if (titulo.isEmpty()) {
        throw new ArgumentoInvalidoException("Titulo Nulo");
    }
    if (titulo.equals(" ")){
        throw new ArgumentoInvalidoException("Titulo Nulo");
    }
    for (int i = 0; i < livros.size(); i++) {
        if(titulo.equalsIgnoreCase(livros.get(i).getTitulo())){
            livroNaoEncontrado = 1;
            livroCorreto = livros.get(i);
            }
        }
    if (livroNaoEncontrado == 0){
        throw new LivroNaoEncontradoException("Livro não encontrado");
    }
    return livroCorreto;
    }

    public Integer contarLivros(){
    Integer livrosTotais = 0;
    for (int i = 0; i < livros.size(); i++) {
        livrosTotais = livrosTotais + 1;
    }
    return livrosTotais;
    }

    public List<Livro> obterLivrosAteAno(Integer ano){
    List<Livro> livrosDesseAno = new ArrayList<>();
    for (int i = 0; i < livros.size(); i++) {
        if (livros.get(i).getDataPublicacao().getYear() <= ano){
            livrosDesseAno.add(livros.get(i));
        }
    }
    return livrosDesseAno;
    }

    public List<Livro> retornarTopCincoLivros(){
        List<Livro> cleber = new ArrayList<>();
        return cleber;
    }


}
