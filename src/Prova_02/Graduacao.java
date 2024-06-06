package Prova_02;

public class Graduacao extends Aluno {
    private double ira;

    public double getIra() {
        return ira;
    }

    public void setIra(double ira) {
        this.ira = ira;
    }

    @Override
    public String toString() {
        return "Graduacao{" +
                "ira=" + ira +
                ", id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
