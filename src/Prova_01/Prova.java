package Prova_01;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Prova {

    public static void prova() {
        List<Pessoa> lsPessoas = new ArrayList<>();

        Aluno alunoA = new Aluno("Aluno A", "111.111.111-11", "email@email.com");
        Aluno alunoB = new Aluno("Aluno B", "222.222.222-22", "email@email.com" );

        lsPessoas.add(alunoA);
        lsPessoas.add(alunoB);

        Instrutor instrutorA = new Instrutor("Instrutor A", "333.333.333-33", "AA123", "(016) 9 9876-5432");
        lsPessoas.add(instrutorA);

        Categoria categoriaA = new Categoria("Categoria A");

        Curso cursoA = new Curso("Curso A", 2323.23, 100, categoriaA);
        Curso cursoB = new Curso("Curso B", 9393.93, 150, categoriaA);

        Turma turmaA = new Turma(cursoA, "1234", LocalDate.of(2024, 2, 6),
                LocalDate.of(2024, 5, 13));

        Turma turmaB = new Turma(cursoB, "2345", LocalDate.of(2024, 3, 13),
                LocalDate.of(2024, 6, 6));

        Matricula matriculaA = new Matricula(turmaA, 9.3, 93);
        Matricula matriculaB = new Matricula(turmaB, 6.3, 63);

        alunoA.adicionaMatricula(matriculaA);
        alunoB.adicionaMatricula(matriculaB);
        instrutorA.adicionaTurma(turmaA);
        instrutorA.adicionaTurma(turmaB);

        for (Pessoa pessoa : lsPessoas) {
            if (pessoa instanceof Aluno) {
                System.out.println("Aluno: " + pessoa.getNome());
                System.out.println("Total gasto: R$ " + ((Aluno) pessoa).calcularTotalGasto());
            } else if (pessoa instanceof Instrutor) {
                System.out.println("Instrutor: " + pessoa.getNome());
            }
            pessoa.obterCursos().forEach(curso -> System.out.println(curso.getNome()));
            System.out.println();
        }

        System.out.println("Cursos na Categoria [" + categoriaA.getNome() + "]");
        categoriaA.exibirCursosPorCategoria();
    }
}
