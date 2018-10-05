package Controller;

import Main.dao.TaskDAO;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import javax.swing.JOptionPane;

public class NovaTarefaController {

    public TextField txtTitulo;
    public TextArea txtArea;

    public void pressCriar() {

        String Titulo = txtTitulo.getText();
        String Area   = txtArea.getText();

        TaskDAO dao = new TaskDAO();
        dao.inserir(Titulo, Area);
        JOptionPane.showMessageDialog(null, "Tarefa foi efetuada com sucesso");


    }

    public void pressCancelar(ActionEvent event){
        Node closeItem = (Node) event.getSource();
        closeItem.getScene().getWindow().hide();
    }
}
