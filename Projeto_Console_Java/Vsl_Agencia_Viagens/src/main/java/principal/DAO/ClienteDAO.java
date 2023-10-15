package principal.DAO;

import principal.Cliente;
import principal.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClienteDAO {
    private Connection conexao;

    public ClienteDAO() {
        try {
            conexao = Conexao.conectar();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void cadastrarCliente(Cliente cliente) {
        String sql = "INSERT INTO clientes (nome,email,senha,telefone,cpf) VALUES (?,?,?,?,?)";

        try(PreparedStatement stmt = conexao.prepareStatement(sql)) {
        stmt.setString(1,cliente.getNome());
        stmt.setString(2,cliente.getEmail());
        stmt.setString(3,cliente.getSenha());
        stmt.setString(4,cliente.getTelefone());
        stmt.setString(5,cliente.getCpf());

        stmt.executeUpdate();


        }catch (SQLException e) {
            e.printStackTrace();
        }
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
