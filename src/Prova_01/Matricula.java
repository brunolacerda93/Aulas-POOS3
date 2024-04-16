package Prova_01;

public class Matricula {

    private Turma turma;
    private double nota;
    private int frequencia;

    public Matricula(Turma turma, double nota, int frequencia) {
        this.turma = turma;
        this.nota = nota;
        this.frequencia = frequencia;
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

    public int getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(int frequencia) {
        this.frequencia = frequencia;
    }
}
