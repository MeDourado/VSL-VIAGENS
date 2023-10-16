package principal.DAO;

import principal.Conexao;
import principal.FaleConosco;
import principal.Passagens;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FaleConoscoDAO {
    private Connection conexao;

    public FaleConoscoDAO() {
        try {
            conexao = Conexao.conectar();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void enviarMensagem(FaleConosco faleConosco) {
        String sql = "INSERT INTO fale_conosco (cliente,passagem,mensagem) values (?,?,?)";

        try(PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, faleConosco.getCliente().getClienteID());
            stmt.setInt(2,faleConosco.getPassagens().getPassagemID());
            stmt.setString(3, faleConosco.getMensagem());
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
