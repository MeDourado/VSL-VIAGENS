package principal.DAO;

import principal.Conexao;
import principal.Destino;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DestinoDAO {
    private Connection conexao;

    public DestinoDAO() {
        try {
            conexao = Conexao.conectar();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void adicionarDestino(Destino destino) {
        String sql = "INSERT INTO destinos (nomeDestino) values (?);";
        try(PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1,destino.getNomeDestino());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<Destino> listarDestinos() {
        List<Destino> Destinos = new ArrayList<>();
        String sql = "SELECT * FROM destinos";
        try(PreparedStatement stmt = conexao.prepareStatement(sql)){
            ResultSet resultado = stmt.executeQuery();
            while(resultado.next()) {
                Destino destino = new Destino();
                destino.setDestinoID(resultado.getInt("destinoID"));
                destino.setNomeDestino(resultado.getString("nomeDestino"));
                Destinos.add(destino);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return Destinos;
    }

    public Destino buscarDestino(int destinoID) {
        String sql = "SELECT * FROM destinos WHERE destinoID = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, destinoID);
            ResultSet resultado = stmt.executeQuery();
            if (resultado.next()) {
                Destino destino = new Destino();
                destino.setDestinoID(resultado.getInt("destinoID"));
                destino.setNomeDestino(resultado.getString("nomeDestino"));
                return destino;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
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
