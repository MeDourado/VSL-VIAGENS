package principal.DAO;

import principal.Cliente;
import principal.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

    public void atualizarCliente(Cliente cliente) {
        String sql = "UPDATE clientes SET nome = ?, email = ?, senha = ?, telefone = ?, cpf = ? WHERE clienteID = ?";
        try(PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1,cliente.getNome());
            stmt.setString(2, cliente.getEmail());
            stmt.setString(3, cliente.getSenha());
            stmt.setString(4,cliente.getTelefone());
            stmt.setString(5,cliente.getCpf());
            stmt.setInt(6,cliente.getClienteID());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public Cliente consultarCliente(int id) {
        Cliente cliente = null;
        String sql = "SELECT * FROM clientes WHERE clienteID = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet resultado = stmt.executeQuery();
            if (resultado.next()) {
                cliente = new Cliente();
                cliente.setClienteID(resultado.getInt("clienteId"));
                cliente.setNome(resultado.getString("nome"));
                cliente.setEmail(resultado.getString("email"));
                cliente.setSenha(resultado.getString("senha"));
                cliente.setTelefone(resultado.getString("telefone"));
                cliente.setCpf(resultado.getString("cpf"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    return cliente;
    }

    public void excluirCliente(int id) {
        String sql = "DELETE FROM clientes where clienteID = ?";

        try(PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1,id);
            stmt.executeUpdate();
        } catch (SQLException e) {
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
