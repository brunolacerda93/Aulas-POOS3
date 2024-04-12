package Prova_01;

import java.util.ArrayList;
import java.util.List;

public class Aluno extends Pessoa {

    private String email;
    private double total;
    private final List<Matricula> lsMatriculas = new ArrayList<>();
    private final List<Curso> lsCursos = new ArrayList<>();

    public Aluno(String nome, String cpf, String email) {
        super(nome, cpf);
        this.email = email;
    }

    public List<Matricula> getMatriculas() {
        return lsMatriculas;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public List<Curso> obterCursos() {
        return lsCursos;
    }

    public double calcularTotalGasto() {
        total = 0.0;
        lsCursos.forEach(curso -> total += curso.getValor());
        return total;
    }

    public boolean adicionaMatricula(Matricula matricula) {
        try {
            lsMatriculas.add(matricula);
            lsCursos.add(matricula.getTurma().getCurso());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public boolean removeMatricula(Matricula matricula) {
        try {
            lsMatriculas.remove(matricula);
            lsCursos.remove(matricula.getTurma().getCurso());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
}
