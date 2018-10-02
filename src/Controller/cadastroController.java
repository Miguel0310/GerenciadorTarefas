package Controller;

import Main.dao.ConnectionFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class cadastroController {

    @FXML
    public TextField CadastroNome;
    @FXML
    public PasswordField CadastroSenha;
    @FXML
    public TextField CadastroEmail;

    public void pressCadastrarC(ActionEvent actionEvent) throws SQLException {

        String name     = CadastroNome.getText();
        String password = CadastroSenha.getText();
        String email    = CadastroEmail.getText();

        Connection conn = ConnectionFactory.getConnection();

        PreparedStatement stmt = conn.prepareStatement("INSERT INTO users(User,Password,UserEmail) VALUES(\'"+name+"\', \'"+password+"\', \'"+email+"\')");
        stmt.executeUpdate();

        CadastroNome.setText("");
        CadastroSenha.setText("");
        CadastroEmail.setText("");
        JOptionPane.showMessageDialog(null, "Cadastro foi efetuado com sucesso");
        conn.close();

        Node close = (Node) actionEvent.getSource();
        close.getScene().getWindow().hide();
    }
    public void pressCancelC(ActionEvent actionEvent){
        Node closeCancelar = (Node) actionEvent.getSource();
        closeCancelar.getScene().getWindow().hide();

    }
}
