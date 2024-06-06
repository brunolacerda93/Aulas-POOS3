package Prova_02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GraduacaoSQLiteDAO implements DAO<Graduacao> {

    private static final GraduacaoSQLiteDAO INSTANCE = new GraduacaoSQLiteDAO();

    public static GraduacaoSQLiteDAO getInstance() {
        return INSTANCE;
    }


    @Override
    public void save(Graduacao aluno) {
        String sql = "INSERT INTO alunograduacao (id, nome, ira) VALUES (?,?,?)";
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:prova2.db"); PreparedStatement stmt = conn.prepareStatement(sql);) {
            stmt.setInt(1, aluno.getId());
            stmt.setString(2, aluno.getNome());
            stmt.setDouble(3, aluno.getIra());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Graduacao findById(int id) {
        String sql = "SELECT * FROM alunograduacao WHERE id = ?";
        Graduacao aluno = null;
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:prova2.db"); PreparedStatement stmt = conn.prepareStatement(sql);) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                aluno = new Graduacao();
                aluno.setId(rs.getInt("id"));
                aluno.setNome(rs.getString("nome"));
                aluno.setIra(rs.getDouble("ira"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return aluno;
    }

    @Override
    public List<Graduacao> findAll() {
        String sql = "SELECT * FROM alunograduacao";
        List<Graduacao> lsAlunos = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:prova2.db"); PreparedStatement stmt = conn.prepareStatement(sql);) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Graduacao aluno = new Graduacao();
                aluno.setId(rs.getInt("id"));
                aluno.setNome(rs.getString("nome"));
                aluno.setIra(rs.getDouble("ira"));
                lsAlunos.add(aluno);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return lsAlunos;
    }

    public List<Graduacao> findByCurso(Curso curso) {
        String sql = "SELECT * FROM alunograduacao WHERE curso = ?";
        List<Graduacao> lsAlunos = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:prova2.db"); PreparedStatement stmt = conn.prepareStatement(sql);) {
            stmt.setInt(1, curso.getId());
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Graduacao aluno = new Graduacao();
                aluno.setId(rs.getInt("id"));
                aluno.setNome(rs.getString("nome"));
                aluno.setIra(rs.getDouble("ira"));
                lsAlunos.add(aluno);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return lsAlunos;
    }

    public void setCurso(Aluno aluno, Curso curso) {
        String sql = "UPDATE alunograduacao SET curso = ? WHERE id = ?";
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:prova2.db"); PreparedStatement stmt = conn.prepareStatement(sql);) {
            stmt.setInt(1, curso.getId());
            stmt.setInt(2, aluno.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
