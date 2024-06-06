package Prova_02;

public class Prova {

    public static void prova() {
        Graduacao alunoGrad = new Graduacao();
        alunoGrad.setId(1);
        alunoGrad.setNome("AlunoGradA");
        alunoGrad.setIra(7.3);

        GraduacaoSQLiteDAO.getInstance().save(alunoGrad);

        PosGraduacao alunoPosGrad = new PosGraduacao();
        alunoPosGrad.setId(1);
        alunoPosGrad.setNome("AlunoPosGradA");
        alunoPosGrad.setTituloMonografia("titulo monografia");

        PosGraduacaoSQLiteDAO.getInstance().save(alunoPosGrad);

        Curso curso = new Curso();
        curso.setId(1);
        curso.setNome("CursoA");
        curso.setSigla("CA");

        CursoSQLiteDAO.getInstance().save(curso);

        curso.incluirAluno(alunoGrad);
        curso.incluirAluno(alunoPosGrad);

        System.out.println(CursoSQLiteDAO.getInstance().findById(curso.getId()));
        CursoSQLiteDAO.getInstance().findById(curso.getId()).exibirAlunos();

        System.out.println("=================================================");
        System.out.println(GraduacaoSQLiteDAO.getInstance().findByCurso(curso));
        System.out.println(PosGraduacaoSQLiteDAO.getInstance().findByCurso(curso));
    }
}
