package Prova_02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CursoSQLiteDAO implements DAO<Curso> {

    private static final CursoSQLiteDAO INSTANCE = new CursoSQLiteDAO();

    public static CursoSQLiteDAO getInstance() {
        return INSTANCE;
    }


    @Override
    public void save(Curso curso) {
        String sql = "INSERT INTO curso (id, nome, sigla) VALUES (?,?,?)";
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:prova2.db"); PreparedStatement stmt = conn.prepareStatement(sql);) {
            stmt.setInt(1, curso.getId());
            stmt.setString(2, curso.getNome());
            stmt.setString(3, curso.getSigla());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Curso findById(int id) {
        String sql = "SELECT * FROM curso WHERE id = ?";
        Curso curso = null;
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:prova2.db"); PreparedStatement stmt = conn.prepareStatement(sql);) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                curso = new Curso();
                curso.setId(rs.getInt("id"));
                curso.setNome(rs.getString("nome"));
                curso.setSigla(rs.getString("sigla"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return curso;
    }

    @Override
    public List<Curso> findAll() {
        String sql = "SELECT * FROM curso";
        List<Curso> lsCursos = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:prova2.db"); PreparedStatement stmt = conn.prepareStatement(sql);) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Curso curso = new Curso();
                curso.setId(rs.getInt("id"));
                curso.setNome(rs.getString("nome"));
                curso.setSigla(rs.getString("sigla"));
                lsCursos.add(curso);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return lsCursos;
    }
}
