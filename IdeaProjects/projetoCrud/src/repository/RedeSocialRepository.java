package repository;

import model.RedeSocial;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RedeSocialRepository extends Conectora {


    public void insere(RedeSocial redeSocial) throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();

        PreparedStatement stmt = connection.prepareStatement("insert into " +
                "rede_social  values(null,?,?)");

        stmt.setString(1, redeSocial.getDescricao());
        stmt.setInt(2, redeSocial.getCodigoInstituicao());

        int i = stmt.executeUpdate();
        System.out.println(i + " linhas inseridas");
        connection.close();
    }

    public List<RedeSocial> buscaPorId(Long id) throws SQLException, ClassNotFoundException {
        List<RedeSocial> redesSociais = new ArrayList<>();
        Connection connection = getConnection();

        PreparedStatement stmt = connection.prepareStatement("select * from rede_social WHERE id = ?");
        stmt.setLong(1, id);
        ResultSet resultSet = stmt.executeQuery();

        while (resultSet.next()) {

            RedeSocial redeSocial = new RedeSocial();
            redeSocial.setId(resultSet.getInt(1));
            redeSocial.setDescricao(resultSet.getString(2));
            redeSocial.setCodigoInstituicao(resultSet.getInt(3));
            redesSociais.add(redeSocial);


        }
        connection.close();
        return redesSociais;
    }

    public List<RedeSocial> busca() throws SQLException, ClassNotFoundException {
        List<RedeSocial> redesSociais = new ArrayList<>();
        Connection connection = getConnection();

        PreparedStatement stmt = connection.prepareStatement("select * from rede_social");
        ResultSet resultSet = stmt.executeQuery();

        while (resultSet.next()) {

            RedeSocial redeSocial = new RedeSocial();
            redeSocial.setId(resultSet.getInt(1));
            redeSocial.setDescricao(resultSet.getString(2));
            redeSocial.setCodigoInstituicao(resultSet.getInt(3));
            redesSociais.add(redeSocial);


        }
        connection.close();
        return redesSociais;
    }

    public List<RedeSocial> buscaPorIstituicao(Integer idInstituicao) throws SQLException, ClassNotFoundException {
        List<RedeSocial> redesSociais = new ArrayList<>();
        Connection connection = getConnection();

        PreparedStatement stmt = connection.prepareStatement("select * from rede_social where cd_instituicao = ?");
        stmt.setInt(1, idInstituicao);

        ResultSet resultSet = stmt.executeQuery();


        while (resultSet.next()) {

            RedeSocial redeSocial = new RedeSocial();
            redeSocial.setId(resultSet.getInt(1));
            redeSocial.setDescricao(resultSet.getString(2));
            redeSocial.setCodigoInstituicao(resultSet.getInt(3));
            redesSociais.add(redeSocial);


        }
        connection.close();
        return redesSociais;
    }

    public Integer proximoId() throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();
        PreparedStatement stmt = connection.prepareStatement("select max(id) from rede_social");
        ResultSet resultSet = stmt.executeQuery();

        while (resultSet.next()) {
            return resultSet.getInt(1) + 1;
        }
        return 1;
    }

    public void update(RedeSocial redeSocial) throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();

        PreparedStatement stmt = connection.prepareStatement("update rede_social " +
                "SET nm_rede = ? WHERE cd_rede_social = ?");
        stmt.setString(1, redeSocial.getDescricao());
        stmt.setInt(2, redeSocial.getId());

        int i = stmt.executeUpdate();
        System.out.println(i + " linhas atualizadas");
        connection.close();
    }

    public void delete(RedeSocial redeSocial) throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();
        PreparedStatement stmt = connection.prepareStatement("DELETE FROM rede_social" +
                " WHERE cd_rede_social = ?");
        stmt.setInt(1, redeSocial.getId().intValue());
        stmt.executeUpdate();
        connection.close();
    }

}





