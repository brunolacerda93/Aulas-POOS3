package Prova_01;

import java.util.ArrayList;
import java.util.List;

public class Categoria {

    private String nome;
    private final List<Curso> lsCursos = new ArrayList<>();

    public Categoria(String nome) {
        this.nome = nome;
    }

    public List<Curso> getCursos() {
        return lsCursos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void exibirCursosPorCategoria() {
        lsCursos.forEach(curso -> System.out.println(curso.getNome()));
    }
}
