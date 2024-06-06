package Prova_02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PosGraduacaoSQLiteDAO implements DAO<PosGraduacao> {

    private static final PosGraduacaoSQLiteDAO INSTANCE = new PosGraduacaoSQLiteDAO();

    public static PosGraduacaoSQLiteDAO getInstance() {
        return INSTANCE;
    }


    @Override
    public void save(PosGraduacao aluno) {
        String sql = "INSERT INTO alunoposgraduacao (id, nome, titulomonografia) VALUES (?,?,?)";
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:prova2.db"); PreparedStatement stmt = conn.prepareStatement(sql);) {
            stmt.setInt(1, aluno.getId());
            stmt.setString(2, aluno.getNome());
            stmt.setString(3, aluno.getTituloMonografia());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public PosGraduacao findById(int id) {
        String sql = "SELECT * FROM alunoposgraduacao WHERE id = ?";
        PosGraduacao aluno = null;
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:prova2.db"); PreparedStatement stmt = conn.prepareStatement(sql);) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                aluno = new PosGraduacao();
                aluno.setId(rs.getInt("id"));
                aluno.setNome(rs.getString("nome"));
                aluno.setTituloMonografia(rs.getString("titulomonografia"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return aluno;
    }

    @Override
    public List<PosGraduacao> findAll() {
        String sql = "SELECT * FROM alunoposgraduacao";
        List<PosGraduacao> lsAlunos = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:prova2.db"); PreparedStatement stmt = conn.prepareStatement(sql);) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                PosGraduacao aluno = new PosGraduacao();
                aluno.setId(rs.getInt("id"));
                aluno.setNome(rs.getString("nome"));
                aluno.setTituloMonografia(rs.getString("titulomonografia"));
                lsAlunos.add(aluno);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return lsAlunos;
    }

    public List<PosGraduacao> findByCurso(Curso curso) {
        String sql = "SELECT * FROM alunoposgraduacao WHERE curso = ?";
        List<PosGraduacao> lsAlunos = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:prova2.db"); PreparedStatement stmt = conn.prepareStatement(sql);) {
            stmt.setInt(1, curso.getId());
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                PosGraduacao aluno = new PosGraduacao();
                aluno.setId(rs.getInt("id"));
                aluno.setNome(rs.getString("nome"));
                aluno.setTituloMonografia(rs.getString("titulomonografia"));
                lsAlunos.add(aluno);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return lsAlunos;
    }

    public void setCurso(Aluno aluno, Curso curso) {
        String sql = "UPDATE alunoposgraduacao SET curso = ? WHERE id = ?";
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:prova2.db"); PreparedStatement stmt = conn.prepareStatement(sql);) {
            stmt.setInt(1, curso.getId());
            stmt.setInt(2, aluno.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
