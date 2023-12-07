package unicesumar.ads.prog2.ae2.q02;

import java.sql.*;

public class Q02 {
    static final String URL = "jdbc:mysql://192.168.86.221:3306/q02?useSSL=FALSE";
    static final String USUARIO = "root";
    static final String PASS = "password";
    static final String SQL_INSERT = "INSERT INTO pessoas(id, nome) VALUES(?, ?)";
    static final String SQL_SELECT = "SELECT * FROM pessoas";

    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conexao = DriverManager.getConnection(URL, USUARIO, PASS);
        PreparedStatement statemant = conexao.prepareStatement(SQL_INSERT);

        statemant.setInt(1, 1);
        statemant.setString(2, "Lucas");
        statemant.executeUpdate();

        statemant.setInt(1, 2);
        statemant.setString(2, "Ronaldo");
        statemant.executeUpdate();

        Statement consulta = conexao.createStatement();
        ResultSet resultados = consulta.executeQuery(SQL_SELECT);

        while(resultados.next()) {
            System.out.println(resultados.getString("nome"));
        }
    }
}
