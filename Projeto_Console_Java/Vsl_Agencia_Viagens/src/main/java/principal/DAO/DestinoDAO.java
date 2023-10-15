package principal.DAO;

import principal.Conexao;
import java.sql.Connection;
import java.sql.SQLException;

public class DestinoDAO {
    private Connection conexao;

    public DestinoDAO() {
        try {
            conexao = Conexao.conectar();
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
