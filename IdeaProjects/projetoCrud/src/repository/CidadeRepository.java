package repository;

import model.Cidade;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class CidadeRepository extends Conectora {


    public void insere(Cidade cidade) throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();

        PreparedStatement stmt = connection.prepareStatement("insert into " +
                "cidade values(null, ?, ?)");

        stmt.setString(1, cidade.getNome());
        stmt.setString(2, cidade.getUf());

        int i = stmt.executeUpdate();
        System.out.println(i + " linhas inseridas");
        connection.close();
    }

    public List<Cidade> buscaPorId(Integer id) throws SQLException, ClassNotFoundException {
        List<Cidade> cidades = new ArrayList<>();
        List<Cidade> pessoas = new ArrayList<>();
        Connection connection = getConnection();

        PreparedStatement stmt = connection.prepareStatement("select * from cidade WHERE cd_cidade = ?");
        stmt.setInt(1, id);
        ResultSet resultSet = stmt.executeQuery();

        while (resultSet.next()) {

            Cidade cidade = new Cidade();
            cidade.setId(resultSet.getInt(1));
            cidade.setNome(resultSet.getString(2));
            cidade.setUf(resultSet.getString(3));

            cidades.add(cidade);


        }
        connection.close();
        return cidades;
    }

    public List<Cidade> busca() throws SQLException, ClassNotFoundException {
        List<Cidade> cidades = new ArrayList<>();
        List<Cidade> cidades1 = new ArrayList<>();
        Connection connection = getConnection();

        PreparedStatement stmt = connection.prepareStatement("select * from cidade");
        ResultSet resultSet = stmt.executeQuery();

        while (resultSet.next()) {

            Cidade cidade = new Cidade();
            cidade.setId(resultSet.getInt(1));
            cidade.setNome(resultSet.getString(2));
            cidade.setUf(resultSet.getString(3));

            cidades.add(cidade);

        }
        connection.close();
        return cidades;
    }


    public Integer proximoId() throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();
        PreparedStatement stmt = connection.prepareStatement("select max(id) from cidade");
        ResultSet resultSet = stmt.executeQuery();

        while (resultSet.next()) {
            return resultSet.getInt(1) + 1;
        }
        return 1;
    }


    public void update(Cidade cidade) throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();

        PreparedStatement stmt = connection.prepareStatement("update cidade " +
                "SET  nome = ?, uf = ? WHERE cd_cidade = ?");

        stmt.setString(1, cidade.getNome());
        stmt.setString(2, cidade.getUf());
        stmt.setInt(3, cidade.getId().intValue());


        int i = stmt.executeUpdate();
        System.out.println(i + " linhas atualizadas");
        connection.close();
    }


    public void delete(Cidade cidade) throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();
        PreparedStatement stmt = connection.prepareStatement("DELETE FROM cidade" +
                " WHERE cd_cidade = ?");
        stmt.setInt(1, cidade.getId().intValue());
        stmt.executeUpdate();
        System.out.println("removido");
        connection.close();
    }
}
