package Prova_01;

import java.time.LocalDate;

public class Turma {

    private Curso curso;
    private String codigo;
    private LocalDate dataInicio;
    private LocalDate dataTermino;

    public Turma(Curso curso, String codigo, LocalDate dataInicio, LocalDate dataTermino) {
        this.curso = curso;
        this.codigo = codigo;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(LocalDate dataTermino) {
        this.dataTermino = dataTermino;
    }
}
