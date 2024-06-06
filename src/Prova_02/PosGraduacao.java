package Prova_02;

public class PosGraduacao extends Aluno{
    private String tituloMonografia;

    public String getTituloMonografia() {
        return tituloMonografia;
    }

    public void setTituloMonografia(String tituloMonografia) {
        this.tituloMonografia = tituloMonografia;
    }

    @Override
    public String toString() {
        return "PosGraduacao{" +
                "tituloMonografia='" + tituloMonografia + '\'' +
                ", id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
