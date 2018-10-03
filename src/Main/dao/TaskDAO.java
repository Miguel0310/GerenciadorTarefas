package Main.dao;

import Main.entity.Task;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static Main.dao.ConnectionFactory.getConnection;

public class TaskDAO {

    public void inserir(String Titulo, String tarefa) {

    }

    public void deletar(String nome) {

    }

    public void atualizar(Task task) {

    }

    public List<Task> pegaTodos(Integer id) {
        try(
                //Obtem a conexao com o BD
                Connection connection = getConnection();
                // Prepara o comando SQL
                PreparedStatement preparedStatement = connection.prepareStatement("select * from tarefas where userid = ?")
        ){
            // Substitiu o ? pela String
            preparedStatement.setInt(1, id);
            // Executa o comando SQL
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Task> tarefas = new ArrayList<Task>();

            while (resultSet.next()) {
                Task t = new Task();
                t.setUserId(resultSet.getInt("userid"));
                t.setNome(resultSet.getString("nome"));
                t.setTexto(resultSet.getString("tarefa"));
                tarefas.add(t);
            }

            return tarefas;

        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

}
