package model;

public class RedeSocial {

    private Integer id;
    private String descricao;

    private Integer codigoInstituicao;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getCodigoInstituicao() {
        return codigoInstituicao;
    }

    public void setCodigoInstituicao(Integer codigoInstituicao) {
        this.codigoInstituicao = codigoInstituicao;
    }

    public RedeSocial() {

    }

    public RedeSocial(Integer id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public RedeSocial(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "RedeSocial{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", codigoInstituicao=" + codigoInstituicao +
                '}';
    }
}


