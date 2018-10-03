package Controller;

import Main.dao.ConnectionFactory;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class sampleController {

    @FXML
    public TextField txtUsuario;
    @FXML
    public PasswordField txtSenha;

    public static String idSessionUser;

    public void pressLogin(ActionEvent event) throws SQLException,IOException {

        Connection conn = ConnectionFactory.getConnection();
        Statement stat = conn.createStatement();
        ResultSet result = stat.executeQuery("SELECT UserID,User,Password,UserEmail FROM users");

        //Login
        while (result.next()){
            String usuarioID = result.getString("UserID");
            String email = result.getString("UserEmail");
            String senha = result.getString("Password");
            if (((email.equals(txtUsuario.getText())) || usuarioID.equals(txtUsuario.getText())) && (senha.equals(txtSenha.getText()))){ //Compara o ID ou email do usuario e a senha.
                idSessionUser = usuarioID;
                Parent menu = FXMLLoader.load(getClass().getResource("Menu.fxml"));
                Scene scene = new Scene(menu);
                Stage inicioM = new Stage();
                inicioM.setScene(scene);
                inicioM.setTitle("Menu");
                Image applicationIcon = new Image(getClass().getResourceAsStream("/img/icons8-overwolf-64.png"));
                inicioM.setResizable(false);
                inicioM.getIcons().add(applicationIcon);
                inicioM.show();
                break;
            }
            else{
            }
        }
        conn.close();
    }

    public void pressCadastrar() throws IOException{

        Parent root = FXMLLoader.load(getClass().getResource("Cadastro.fxml"));
        Scene scene = new Scene(root);
        Stage inicio = new Stage();
        inicio.setScene(scene);
        inicio.setTitle("Cadastro");
        Image applicationIcon = new Image(getClass().getResourceAsStream("/img/icons8-overwolf-64.png"));
        inicio.getIcons().add(applicationIcon);
        inicio.setResizable(false);
        inicio.show();

    }
}
