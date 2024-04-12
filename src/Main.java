import Aula_01.ExerciciosAulaInicial;
import Prova_01.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void prova() {
        List<Aluno> lsAlunos = new ArrayList<>();
        List<Instrutor> lsInstrutores = new ArrayList<>();

        Aluno alunoA = new Aluno("Aluno A", "111.111.111-11", "email@email.com");
        Aluno alunoB = new Aluno("Aluno B", "222.222.222-22", "email@email.com" );

        lsAlunos.add(alunoA);
        lsAlunos.add(alunoB);

        Instrutor instrutorA = new Instrutor("Instrutor A", "333.333.333-33", "AA123", "(016) 9 9876-5432");
        lsInstrutores.add(instrutorA);

        Categoria categoriaA = new Categoria("Categoria A");

        Curso cursoA = new Curso("Curso A", 2323.23, 100, categoriaA);
        Curso cursoB = new Curso("Curso B", 9393.93, 150, categoriaA);

        categoriaA.getCursos().add(cursoA);
        categoriaA.getCursos().add(cursoB);

        Turma turmaA = new Turma(cursoA, "1234", LocalDate.of(2024, 2, 6),
                LocalDate.of(2024, 5, 13));

        Turma turmaB = new Turma(cursoB, "2345",LocalDate.of(2024, 3, 13),
                LocalDate.of(2024, 6, 6));

        Matricula matriculaA = new Matricula(turmaA, 9.3);
        Matricula matriculaB = new Matricula(turmaB, 6.3);

        alunoA.adicionaMatricula(matriculaA);
        alunoB.adicionaMatricula(matriculaB);
        instrutorA.adicionaTurma(turmaA);
        instrutorA.adicionaTurma(turmaB);

        System.out.println("Alunos:");
        for (Aluno aluno : lsAlunos) {
            System.out.println("Aluno: " + aluno.getNome());
            aluno.obterCursos().forEach(curso -> System.out.println(curso.getNome()));
            System.out.println("Total gasto: R$ " + aluno.calcularTotalGasto() + "\n");
        }

        System.out.println("Instrutores:");
        for (Instrutor instrutor : lsInstrutores) {
            System.out.println("Instrutor: " + instrutor.getNome());
            instrutor.obterCursos().forEach(curso -> System.out.println(curso.getNome()));
            System.out.println();
        }

        System.out.println("Cursos na Categoria [" + categoriaA.getNome() + "]");
        categoriaA.exibirCursosPorCategoria();
    }

    public static void main(String[] args) {
//        ExerciciosAulaInicial.AulaInicial();
        prova();
    }
}
