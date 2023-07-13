package repository;

import model.Projeto;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProjetoRepository extends Conectora {


    public void insere(Projeto projeto) throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();

        PreparedStatement stmt = connection.prepareStatement("insert into " +
                "projeto values(null, ?, ?, ?, ?, ?,?)");

        stmt.setString(1, projeto.getNome());
        stmt.setString(2, projeto.getDescricao());
        stmt.setString(3, projeto.getCoordenacao());
        stmt.setInt(4, projeto.getTipo().ordinal());
        stmt.setInt(5, projeto.getCategoria().ordinal());
        stmt.setInt(6, projeto.getInstituicao().getCodigo());

        int i = stmt.executeUpdate();
        System.out.println(i + " linhas inseridas");
        connection.close();
    }
    public List<Projeto> buscaPorId(Integer codigo) throws SQLException, ClassNotFoundException {
        List<Projeto> projetos = new ArrayList<>();
        Connection connection = getConnection();

        PreparedStatement stmt = connection.prepareStatement("select * from projeto WHERE cd_projeto = ?");
        stmt.setInt(1, codigo);
        ResultSet resultSet = stmt.executeQuery();

        while (resultSet.next()) {
            Projeto projeto = new Projeto();
            projeto.setCodigo(resultSet.getInt(1));
            projeto.setNome(resultSet.getString(2));
            projeto.setDescricao(resultSet.getString(3));
            projeto.setCoordenacao(resultSet.getString(4));

            //FK
            InstituicaoRepository instituicaoRepository = new InstituicaoRepository();
            projeto.setInstituicao(instituicaoRepository.buscaPorId(resultSet.getInt(5)).get(0));
            projeto.setTipo(TipoProjeto.getTipoById(resultSet.getInt(6)));
            projeto.setCategoria(Categoria.getCategoriaById(resultSet.getInt(7)));


            projetos.add(projeto);
        }
        connection.close();
        return projetos;
    }
    public List<Projeto> busca() throws SQLException, ClassNotFoundException {
        List<Projeto> projetos = new ArrayList<>();
        Connection connection = getConnection();

        PreparedStatement stmt = connection.prepareStatement("select * from projeto");
        ResultSet resultSet = stmt.executeQuery();

        while (resultSet.next()) {
            Projeto projeto = new Projeto();
            projeto.setCodigo(resultSet.getInt(1));
            projeto.setNome(resultSet.getString(2));
            projeto.setDescricao(resultSet.getString(3));
            projeto.setCoordenacao(resultSet.getString(4));

            //FK
            InstituicaoRepository instituicaoRepository = new InstituicaoRepository();
            projeto.setTipo(TipoProjeto.getTipoById(resultSet.getInt(5)));
            projeto.setCategoria(Categoria.getCategoriaById(resultSet.getInt(6)));
            projeto.setInstituicao(instituicaoRepository.buscaPorId(resultSet.getInt(7)).get(0));

            projetos.add(projeto);
        }
        connection.close();
        return projetos;
    }
    public Integer proximoId() throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();
        PreparedStatement stmt = connection.prepareStatement("select max(cd_projeto) from projeto");
        ResultSet resultSet = stmt.executeQuery();

        while (resultSet.next()) {
           // return resultSet.getInt(1) + 1;
        }
        return 1;
    }
    public void update(Projeto projeto) throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();

        PreparedStatement stmt = connection.prepareStatement("update projeto " +
                "SET nome = ?, descricao = ?, coordenacao = ?, tipo = ?, categoria = ?, cd_instituicao = ? WHERE cd_projeto = ?");
        stmt.setString(1, projeto.getNome());
        stmt.setString(2, projeto.getDescricao());
        stmt.setString(3, projeto.getCoordenacao());
        stmt.setInt(4, projeto.getTipo().ordinal());
        stmt.setInt(5, projeto.getCategoria().ordinal());
        stmt.setInt(6, projeto.getInstituicao().getCodigo());
        stmt.setInt(7, projeto.getCodigo());

        int i = stmt.executeUpdate();
        System.out.println(i + " linhas atualizadas");
        connection.close();
    }
    public void delete(Projeto projeto) throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();
        PreparedStatement stmt = connection.prepareStatement("DELETE FROM projeto" +
                " WHERE cd_projeto = ?");
        stmt.setInt(1, projeto.getCodigo().intValue());
        stmt.executeUpdate();
        System.out.println("removido");
        connection.close();
    }



}

