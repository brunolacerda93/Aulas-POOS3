package Prova_02;

import java.util.ArrayList;
import java.util.List;

public class Curso {
    private int id;
    private String nome;
    private String sigla;
    private final List<Aluno> lsAlunos = new ArrayList<Aluno>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }


    public void exibirAlunos() {
        lsAlunos.addAll(GraduacaoSQLiteDAO.getInstance().findByCurso(this));
        lsAlunos.addAll(PosGraduacaoSQLiteDAO.getInstance().findByCurso(this));
        System.out.println(lsAlunos);
    }

    public void incluirAluno(Aluno aluno) {
        if (aluno instanceof Graduacao) {
            GraduacaoSQLiteDAO.getInstance().setCurso(aluno, this);
        }
        else if (aluno instanceof PosGraduacao) {
            PosGraduacaoSQLiteDAO.getInstance().setCurso(aluno, this);
        }
        lsAlunos.add(aluno);
    }

    public void removerAluno(Aluno aluno) {
        lsAlunos.remove(aluno);
    }

    @Override
    public String toString() {
        return "Curso{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", sigla='" + sigla + '\'' +
                '}';
    }
}
