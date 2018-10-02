package Main.dao;

import Main.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe para obter/manipular os dados da tabela user
 */
public class UserDAO extends BaseDAO{

    // Insere um novo Usuário no Banco de dados
    //**
    // Atencao!
    // Jamais grave uma informação sigilosa como password sem utilizar alguma técnica de criptografia
    //**
    public void insert(User user){

        // try-with-resource
        // Fecha automaticamente o recurso quando finaliza o bloco try-catch
        try(
                //Obtem a conexao com o BD
                Connection connection = getConnection();
                // Prepara o comando SQL
                PreparedStatement preparedStatement = connection.prepareStatement("insert into user(User,Password,UserEmail) values(?,?,?)")
        ){
            // Substitiu o ? pela String
            preparedStatement.setString(1,user.getName());
            // Substitiu o segundo ? pela String
            preparedStatement.setString(2,user.getPassword());

            // Executa o comando SQL
            preparedStatement.execute();

        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }

    // Obtêm todos os usuários a tabela
    public List<User> getAll(){
        List<User> list = new ArrayList<>();

        //Obtem a conexao com o BD
        try(
                Connection connection = getConnection();
                Statement statement = connection.createStatement()
        ){
            // Executa a query
            ResultSet resultSet = statement.executeQuery("select user_id,name,password from user");

            // Para cada resultado da query
            while(resultSet.next()){
                // Cria um novo objeto usuario
                User user = new User();

                // Obtem os valores dos campos, deve ser na mesma ordem informada na query
                user.setId(resultSet.getLong(1));
                user.setName(resultSet.getString(2));
                user.setPassword(resultSet.getString(3));

                // Adiciona na lista
                list.add(user);
            }

        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return list;
    }

    // Obter um usuário pelo ID
    public User getById(long id){
        User user = null;
        //Obtem a conexao com o BD
        try(
                Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement("select user_id,name,password from user where user_id = ?")
        ){
            // Informa o user_id na query
            statement.setLong(1,id);

            // Executa a query
            ResultSet resultSet = statement.executeQuery();

            // Para cada resultado da query
            while(resultSet.next()){
                // Cria um novo objeto usuario
                user = new User();

                // Obtem os valores dos campos, deve ser na mesma ordem informada na query
                user.setId(resultSet.getLong(1));
                user.setName(resultSet.getString(2));
                user.setPassword(resultSet.getString(3));
            }

        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return user;
    }

    // Obter um usuário pelo nome
    public User getByName(String name){
        User user = null;
        //Obtem a conexao com o BD
        try(
                Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement("select user_id,name,password from user where name = ?")
        ){
            // Informa o user_id na query
            statement.setString(1,name);

            // Executa a query
            ResultSet resultSet = statement.executeQuery();

            // Para cada resultado da query
            while(resultSet.next()){
                // Cria um novo objeto usuario
                user = new User();

                // Obtem os valores dos campos, deve ser na mesma ordem informada na query
                user.setId(resultSet.getLong(1));
                user.setName(resultSet.getString(2));
                user.setPassword(resultSet.getString(3));
            }

        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return user;
    }

}
