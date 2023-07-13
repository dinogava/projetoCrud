package repository;

import model.RedeSocial;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public final class RedeSocialDAO implements IGenericDAO<RedeSocial>{

    static List<RedeSocial> redeSociais = new ArrayList<>();


    @Override
    public void salvar(RedeSocial redeSocial) {
        RedeSocialRepository redeSocialRepository = new RedeSocialRepository();
        try {
            if (redeSocial.getId() != null) {
                redeSocialRepository.update(redeSocial);
            } else {
              //  redeSocial.setId(redeSocialRepository.proximoId().intValue());
                redeSocialRepository.insere(redeSocial);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        redeSociais.add(redeSocial);
    }

    @Override
    public void remover(RedeSocial redeSocial) throws SQLException, ClassNotFoundException {
        RedeSocialRepository redeSocialRepository = new RedeSocialRepository();
        redeSocialRepository.delete(redeSocial);
    }


    @Override
    public List<RedeSocial> buscarTodos() {
        System.out.println(redeSociais);

        RedeSocialRepository redeSocialRepository = new RedeSocialRepository();
        try {
            redeSociais = redeSocialRepository.busca();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return redeSociais;
    }

    @Override
    public List<RedeSocial> buscarPorNome(String nome) {
        List<RedeSocial> redesFiltradas = new ArrayList<>();
        for (RedeSocial redeSocial : redeSociais) {
            if (redeSocial.getDescricao().contains(nome)) {
                redesFiltradas.add(redeSocial);
            }
        }
        return redesFiltradas;
    }
    public Object[] findRedesSociaisInArray() {
        List<RedeSocial> redesSociais = buscarTodos();
        List<String> redesSociaisNomes = new ArrayList<>();

        for (RedeSocial redeSocial : redesSociais) {
            redesSociaisNomes.add(redeSocial.getDescricao());
        }

        return redesSociaisNomes.toArray();
    }

}
