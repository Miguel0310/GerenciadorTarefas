package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;


public class menuController {

    public void pressLogout(ActionEvent event) {
        Node closeItem = (Node) event.getSource();
        closeItem.getScene().getWindow().hide();
    }

    @FXML
    public void pressNew() throws IOException {

        /*System.out.println(sampleController.idSessionUser);*/
        Parent Novatarefa = FXMLLoader.load(getClass().getResource("NovaTarefa.fxml"));
        Scene scene = new Scene(Novatarefa);
        Stage newTask = new Stage();
        newTask.setScene(scene);
        newTask.setTitle("Criar nova tarefa");
        Image applicationIcon = new Image(getClass().getResourceAsStream("/img/icons8-overwolf-64.png"));
        newTask.getIcons().add(applicationIcon);
        newTask.setResizable(false);
        newTask.show();
    }

    @FXML
    public void pressApagarMenu()throws IOException{
        Parent ApagarTarefa = FXMLLoader.load(getClass().getResource("ApagarTarefa.fxml"));
        Scene scene = new Scene(ApagarTarefa);
        Stage deleteTask = new Stage();
        deleteTask.setScene(scene);
        deleteTask.setTitle("Apagar Tarefa");
        Image applicationIcon = new Image(getClass().getResourceAsStream("/img/icons8-overwolf-64.png"));
        deleteTask.getIcons().add(applicationIcon);
        deleteTask.setResizable(false);
        deleteTask.show();
    }
}