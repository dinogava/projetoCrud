package repository;

import model.Instituicao;
import model.RedeSocial;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InstituicaoRepository extends Conectora {


    public void insere(Instituicao instituicao) throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();

        PreparedStatement stmt = connection.prepareStatement("insert into " +
                "instituicao values(null, ?, ?, ?, ?, ?,?)");
        stmt.setString(1, instituicao.getNome());
        stmt.setString(2, instituicao.getRua());
        stmt.setString(3, instituicao.getBairro());
        stmt.setString(4, instituicao.getNumero());
        stmt.setString(5, instituicao.getTelefone());
        stmt.setObject(6, instituicao.getCidade().getId());
       // stmt.setObject(7,  instituicao.getRedeSocial());

        int i = stmt.executeUpdate();
        System.out.println(i + " linhas inseridas");
        connection.close();
    }
    public List<Instituicao> buscaPorId(Integer codigo) throws SQLException, ClassNotFoundException {
        List<Instituicao> instituicoes = new ArrayList<>();
        Connection connection = getConnection();

        PreparedStatement stmt = connection.prepareStatement("select * from instituicao WHERE cd_instituicao = ?");
        stmt.setLong(1, codigo);
        ResultSet resultSet = stmt.executeQuery();

        while (resultSet.next()) {
            Instituicao instituicao = new Instituicao();
            instituicao.setCodigo(resultSet.getInt(1));

            instituicao.setNome(resultSet.getString(2));
            instituicao.setRua(resultSet.getString(3));
            instituicao.setBairro(resultSet.getString(4));
            instituicao.setNumero(resultSet.getString(5));
            instituicao.setTelefone(resultSet.getString(6));

            //FK
            CidadeRepository cidadeRepository = new CidadeRepository();
            instituicao.setCidade(cidadeRepository.buscaPorId(resultSet.getInt(7)).get(0));



            instituicoes.add(instituicao);
        }
        connection.close();
        return instituicoes;
    }
    public List<Instituicao> busca() throws SQLException, ClassNotFoundException {
        List<Instituicao> instituicoes = new ArrayList<>();
        Connection connection = getConnection();

        PreparedStatement stmt = connection.prepareStatement("select * from instituicao");
        ResultSet resultSet = stmt.executeQuery();

        while (resultSet.next()) {
            Instituicao instituicao = new Instituicao();
            instituicao.setCodigo(resultSet.getInt(1));

            instituicao.setNome(resultSet.getString(2));
            instituicao.setRua(resultSet.getString(3));
            instituicao.setBairro(resultSet.getString(4));
            instituicao.setNumero(resultSet.getString(5));
            instituicao.setTelefone(resultSet.getString(6));

            //FK
            CidadeRepository cidadeRepository = new CidadeRepository();
            instituicao.setCidade(cidadeRepository.buscaPorId(resultSet.getInt(7)).get(0));

            RedeSocialRepository redeSocialRepository = new RedeSocialRepository();
            List<RedeSocial> redeSocials = redeSocialRepository.buscaPorIstituicao(instituicao.getCodigo());

            instituicao.setRedesSociais(redeSocials);

            instituicoes.add(instituicao);
        }
        connection.close();
        return instituicoes;
    }
    public Integer proximoId() throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();
        PreparedStatement stmt = connection.prepareStatement("select max(cd_i) from instituicao");
        ResultSet resultSet = stmt.executeQuery();

        while (resultSet.next()) {
            return resultSet.getInt(1) + 1;
        }
        return 1;
    }
    public void update(Instituicao instituicao) throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();

        PreparedStatement stmt = connection.prepareStatement("update instituicao " +
                "SET nome = ?, rua = ?, bairro = ?, numero = ?, telefone = ?, cd_cidade = ? WHERE cd_instituicao = ?");
        stmt.setString(1, instituicao.getNome());
        stmt.setString(2, instituicao.getRua());
        stmt.setString(3, instituicao.getBairro());
        stmt.setString(4, instituicao.getNumero());
        stmt.setString(5, instituicao.getTelefone());
        stmt.setObject(6, instituicao.getCidade().getId());
        stmt.setInt(7, instituicao.getCodigo());


        int i = stmt.executeUpdate();
        System.out.println(i + " linhas atualizadas");
        connection.close();
    }
    public void delete(Instituicao instituicao) throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();
        PreparedStatement stmt = connection.prepareStatement("DELETE FROM instituicao" +
                " WHERE cd_instituicao = ?");
        stmt.setInt(1, instituicao.getCodigo());

        stmt.executeUpdate();
        connection.close();
    }


}
