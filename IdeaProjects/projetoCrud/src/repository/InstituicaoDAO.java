package repository;

import model.Instituicao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public final class InstituicaoDAO implements IGenericDAO<Instituicao> {

    static List<Instituicao> instituicoes = new ArrayList<>();

    @Override
    public void salvar(Instituicao instituicao) {
        InstituicaoRepository instituicaoRepository = new InstituicaoRepository();
        try {
            if (instituicao.getCodigo() != null) {
                instituicaoRepository.update(instituicao);
            } else {
                instituicaoRepository.insere(instituicao);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        instituicoes.add(instituicao);
    }

    @Override
    public void remover(Instituicao instituicao) throws SQLException, ClassNotFoundException {
        InstituicaoRepository instituicaoRepository = new InstituicaoRepository();
        instituicaoRepository.delete(instituicao);
    }


    @Override
    public List<Instituicao> buscarTodos() {
        InstituicaoRepository instituicaoRepository = new InstituicaoRepository();
        try {
            instituicoes = instituicaoRepository.busca();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return instituicoes;
    }

    public List<Instituicao> buscarPorId(Integer codigo) throws SQLException, ClassNotFoundException {
        InstituicaoRepository instituicaoRepository = new InstituicaoRepository();
        List<Instituicao> instituicoes = instituicaoRepository.buscaPorId(codigo);
        return instituicoes;
    }


    @Override
    public List<Instituicao> buscarPorNome(String nome) {
        List<Instituicao> filtradas = new ArrayList<>();
        for (Instituicao instituicao : instituicoes) {
            if (instituicao.getNome().contains(nome)) {
                filtradas.add(instituicao);
            }
        }
        return filtradas;
    }
    public Object[] findInstituicaoInArray() {
        List<Instituicao> instituicoes = buscarTodos();
        List<String> instituicoesNomes = new ArrayList<>();

        for (Instituicao instituicao : instituicoes) {
            instituicoesNomes.add(instituicao.getNome().toString());
        }

        return instituicoesNomes.toArray();
    }


}
