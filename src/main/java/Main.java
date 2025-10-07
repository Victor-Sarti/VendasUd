

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/bdvendas"; // nome do banco
        String usuario = "root";
        String senha = "Sarti007@"; // substitua pela sua senha

        try (Connection conexao = DriverManager.getConnection(url, usuario, senha)) {
            System.out.println("✅ Conectado ao banco com sucesso!");
        } catch (SQLException e) {
            System.out.println("❌ Erro ao conectar: " + e.getMessage());
        }
    }
}