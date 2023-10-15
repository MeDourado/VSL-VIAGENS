package principal.DAO;

import principal.Conexao;
import principal.Voos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VoosDAO {
    private Connection conexao;

    public VoosDAO() {
        try {
            conexao = Conexao.conectar();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void adicionarVoos(Voos voos) {
        String sql = "INSERT INTO voos (piloto, data_ida, data_volta) VALUES (?, ?,?)";

        try(PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1,voos.getPiloto());
            stmt.setTimestamp(2,new java.sql.Timestamp(voos.getData_ida().getTime()));
            stmt.setTimestamp(3,new java.sql.Timestamp(voos.getData_volta().getTime()));

            stmt.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public Voos consultarVoos(int id) {
        Voos voos = null;
        String sql = "SELECT * FROM voos WHERE vooID = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet resultado = stmt.executeQuery();
            if (resultado.next()) {
                voos = new Voos();
                voos.setPiloto(resultado.getString("piloto"));
                voos.setData_ida(resultado.getDate("data_ida"));
                voos.setData_volta(resultado.getDate("data_volta"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return voos;
    }

    public void fecharConexao() {
        try {
            if (conexao != null && !conexao.isClosed()) {
                conexao.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
