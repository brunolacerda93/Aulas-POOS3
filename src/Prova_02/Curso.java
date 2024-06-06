package Prova_02;

public class Curso {
    private int id;
    private String nome;
    private String sigla;

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
        System.out.println(GraduacaoSQLiteDAO.getInstance().findByCurso(this));
        System.out.println(PosGraduacaoSQLiteDAO.getInstance().findByCurso(this));
    }

    public void incluirAluno(Aluno aluno) {
        if (aluno instanceof Graduacao) {
            GraduacaoSQLiteDAO.getInstance().setCurso(aluno, this);
        }
        else if (aluno instanceof PosGraduacao) {
            PosGraduacaoSQLiteDAO.getInstance().setCurso(aluno, this);
        }
    }

    public void removerAluno(Aluno aluno) {

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
