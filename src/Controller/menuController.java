package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;


public class menuController {

    @FXML
    public Label bemvindo;
    @FXML
    private MenuItem closeItem;

    @FXML
    public void pressLogout(ActionEvent event) {
        Node closeItem = (Node) event.getSource();
        closeItem.getScene().getWindow().hide();
    }
    public void pressNew(ActionEvent event) throws IOException {
        System.out.println(sampleController.idSessionUser);

        Parent menu = FXMLLoader.load(getClass().getResource("NovaTarefa.fxml"));
        Scene scene = new Scene(menu);
        Stage newTask = new Stage();
        newTask.setScene(scene);
        newTask.setTitle("Criar nova tarefa");
        Image applicationIcon = new Image(getClass().getResourceAsStream("/img/icons8-overwolf-64.png"));
        newTask.setResizable(false);
        newTask.getIcons().add(applicationIcon);
        newTask.show();

    }
}
