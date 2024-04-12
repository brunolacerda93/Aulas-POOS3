package Prova_01;

import java.util.ArrayList;
import java.util.List;

public class Instrutor extends Pessoa {

    private String matricula;
    private String telefone;
    private final List<Turma> lsTurmas = new ArrayList<>();

    public Instrutor(String nome, String cpf, String matricula, String telefone) {
        super(nome, cpf);
        this.matricula = matricula;
        this.telefone = telefone;
    }

    public List<Turma> getTurmas() {
        return lsTurmas;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public List<Curso> obterCursos() {
        List<Curso> lsCursos = new ArrayList<>();
        lsTurmas.forEach(turma -> lsCursos.add(turma.getCurso()));
        return lsCursos;
    }

    public boolean adicionaTurma(Turma turma) {
        try {
            lsTurmas.add(turma);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public boolean removeTurma(Turma turma) {
        try {
            lsTurmas.remove(turma);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
}
