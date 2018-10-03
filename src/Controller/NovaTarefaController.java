package Controller;

import Main.dao.ConnectionFactory;
import Main.dao.TaskDAO;
import Main.entity.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class NovaTarefaController {

    @FXML
    public TextField lblnewTask;
    @FXML
    public TextArea lblAreaTask;

    public void pressCriar(ActionEvent event) throws SQLException {

        String Titulo = lblnewTask.getText();
        String Area   = lblAreaTask.getText();

        TaskDAO dao = new TaskDAO();
        dao.inserir(Titulo, Area);

        /*System.out.println(sampleController.idSessionUser);
        Connection conn = ConnectionFactory.getConnection();
        Statement stat = conn.createStatement();
        ResultSet result = stat.executeQuery("SELECT UserID FROM users");
        Statement sqltarefa = conn.createStatement();
        ResultSet resulttarefa = sqltarefa.executeQuery("SELECT UserID,Nome,Tarefa FROM tarefas");*/


    }

    public void pressCancelar(ActionEvent event){
        Node closeItem = (Node) event.getSource();
        closeItem.getScene().getWindow().hide();
    }
}
