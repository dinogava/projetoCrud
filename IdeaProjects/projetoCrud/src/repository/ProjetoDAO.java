package repository;

import model.Projeto;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProjetoDAO implements IGenericDAO<Projeto>{

    static List <Projeto> projetos = new ArrayList<>();

    @Override
    public void salvar(Projeto projeto) {
        ProjetoRepository projetoRepository = new ProjetoRepository();
        try {
            if (projeto.getCodigo() != null) {
                projetoRepository.update(projeto);
            } else {
                projeto.setCodigo(projetoRepository.proximoId());
                projetoRepository.insere(projeto);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        projetos.add(projeto);
    }
    @Override
    public void remover(Projeto projeto) throws SQLException, ClassNotFoundException {
        ProjetoRepository projetoRepository = new ProjetoRepository();
        projetoRepository.delete(projeto);
    }


    @Override
    public List<Projeto> buscarTodos() {
        ProjetoRepository projetoRepository = new ProjetoRepository();
        try {
            projetos = projetoRepository.busca();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return projetos;
    }


    @Override
    public List<Projeto> buscarPorNome(String nome) {
        List<Projeto> filtradas = new ArrayList<>();
        for (Projeto projeto : projetos) {
            if (projeto.getNome().contains(nome)) {
                filtradas.add(projeto);
            }
        }
        return filtradas;
    }

    public Object[] findProjetosInArray() {
        List<Projeto> projetos1 = buscarTodos();
        List<String> projetosNomes = new ArrayList<>();

        for (Projeto projeto : projetos1) {
            projetosNomes.add(projeto.getNome());
        }

        return projetosNomes.toArray();
    }
}
