import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexao {

    private static final String URL ="jdbc:mysql://localhost:3306/forms";
    private static final String USUARIO = "root";
    private static final String SENHA = "root";


    public static Connection conectar(){
        try {
            return DriverManager.getConnection(URL,USUARIO, SENHA);
        }catch (SQLException e){
            throw new RuntimeException("Erro ao conectar ao banco " + e.getMessage());
        }
    }

}
