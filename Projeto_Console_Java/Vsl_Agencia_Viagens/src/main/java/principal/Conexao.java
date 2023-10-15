package principal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static final String URL = "jdbc:mysql://localhost:3306/vsl";
    private static final String USUARIO = "root";
    private static final String SENHA = "123456";

    public static Connection conectar() throws SQLException {
        Connection conexao;
        try {
            conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (SQLException e) {

            e.printStackTrace();
            throw new SQLException("Falha ao conectar ao banco de dados.");
        }
        return conexao;
    }

    public static void fecharConexao(Connection conexao) {
        if (conexao != null) {
            try {
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
