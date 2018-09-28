package Main;
import Main.dao.ConnectionFactory;
import Main.dao.UserDAO;
import javafx.event.ActionEvent;
import Main.entity.User;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.sql.*;

public class Controller {



    @FXML
    public TextField txtUsuario;
    @FXML
    public PasswordField txtSenha;
    User c = new User();
    UserDAO ud = new UserDAO();

    public void pressLogin(ActionEvent event) throws SQLException {

        Connection conn = ConnectionFactory.getConnection();
        Statement stat = conn.createStatement();
        ResultSet result = stat.executeQuery("SELECT UserID,User,Password FROM users");

        while (result.next()){
            String nome = result.getString("UserID");
            String senha = result.getString("Password");
            if ((nome.equals(txtUsuario.getText())) && (senha.equals(txtSenha.getText()))){
                System.out.println("Logeado!");
            }
            else{
                System.out.println("Erro no Login");
            }

        }
    }
    public void pressCadastrar(ActionEvent event){
        System.out.println();

    }
}
