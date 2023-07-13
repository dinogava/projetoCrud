package repository;

import model.Cidade;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public final class CidadeDAO implements IGenericDAO<Cidade> {

    //static List<Cidade> cidades = new ArrayList<>();


    public CidadeDAO() {
        super();
    }

    @Override
    public void salvar(Cidade cidade) {
        CidadeRepository cidadeRepository = new CidadeRepository();
        try {
            if (cidade.getId() != null) {
                cidadeRepository.update(cidade);
            } else {
                // cidade.setId(cidadeRepository.proximoId());
                cidadeRepository.insere(cidade);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        //  cidades.add(cidade);

    }

    @Override
    public void remover(Cidade cidade) throws SQLException, ClassNotFoundException {
        CidadeRepository cidadeRepository = new CidadeRepository();
        cidadeRepository.delete(cidade);
    }

    @Override
    public List<Cidade> buscarTodos() {
        List<Cidade> cidades = new ArrayList<>();
        System.out.println(cidades);

        CidadeRepository cidadeRepository = new CidadeRepository();
        try {
            cidades = cidadeRepository.busca();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return cidades;
    }

    @Override
    public List<Cidade> buscarPorNome(String nome) {
        List<Cidade> cidades = buscarTodos();
        List<Cidade> cidadesFiltradas = new ArrayList<>();
        for (Cidade cidade : cidades) {
            if (cidade.getNome().contains(nome)) {
                cidadesFiltradas.add(cidade);
            }
        }
        return cidadesFiltradas;
    }

    public Object[] findCidadesInArray() {
        List<Cidade> cidades1 = buscarTodos();
        List<String> cidadesNomes = new ArrayList<>();

        for (Cidade cidade : cidades1) {
            cidadesNomes.add(cidade.getNome());
        }

        return cidadesNomes.toArray();
    }
}
