package Controller;

import Main.dao.TaskDAO;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import javax.swing.JOptionPane;

public class ApagarTarefaController {

    public TextField txtApagar;

    @FXML
    public void pressDeletar(){

        try {

            String Titulo = txtApagar.getText();

            TaskDAO dao = new TaskDAO();
            dao.deletar(Titulo);
            JOptionPane.showMessageDialog(null, "Tarefa deletada com sucesso!");
        }catch (Exception e){
            
        }
    }

}
