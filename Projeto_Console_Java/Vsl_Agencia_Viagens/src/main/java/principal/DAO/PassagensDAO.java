package principal.DAO;

import principal.Conexao;
import principal.Passagens;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PassagensDAO {
    private Connection conexao;
    ClienteDAO clienteDAO = new ClienteDAO();
    DestinoDAO destinoDAO = new DestinoDAO();

    VoosDAO voosDAO = new VoosDAO();

    public PassagensDAO() {
        try {
            conexao = Conexao.conectar();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void comprarPassagem(Passagens passagens) {
        String sql = "INSERT INTO passagens (cliente,local_partida,destino,voo,valor) values (?,?,?,?,?)";

        try(PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, passagens.getCliente().getClienteID());
            stmt.setString(2, passagens.getLocal_partida());
            stmt.setInt(3,passagens.getDestino().getDestinoID());
            stmt.setInt(4, passagens.getVoos().getVooID());
            stmt.setInt(5,passagens.getValor());
            stmt.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Passagens buscarPassagem(int passagemID) {
        Passagens passagem = null;
        String sql = "SELECT * FROM passagens WHERE passagemID = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, passagemID);
            ResultSet resultSet = stmt.executeQuery();

            if (resultSet.next()) {
                passagem = new Passagens();
                passagem.setPassagemID(resultSet.getInt("passagemID"));
                passagem.setCliente(clienteDAO.consultarCliente(resultSet.getInt("cliente")));
                passagem.setLocal_partida(resultSet.getString("local_partida"));
                passagem.setDestino(destinoDAO.buscarDestino(resultSet.getInt("destino")));
                passagem.setVoos(voosDAO.consultarVoos(resultSet.getInt("voo")));
                passagem.setValor(resultSet.getInt("valor"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return passagem;
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
