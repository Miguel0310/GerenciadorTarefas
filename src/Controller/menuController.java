package Controller;

import javafx.event.ActionEvent;
import javafx.scene.Node;

public class menuController {

    public void closeItem (ActionEvent actionEvent){
        Node closeItem = (Node) actionEvent.getSource();
        closeItem.getScene().getWindow().hide();
    }
}
