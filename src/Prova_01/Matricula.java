package Prova_01;

public class Matricula {

    private Turma turma;
    private double nota;

    public Matricula(Turma turma, double nota) {
        this.turma = turma;
        this.nota = nota;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
}
