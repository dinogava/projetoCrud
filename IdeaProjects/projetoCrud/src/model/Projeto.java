package model;

import model.Instituicao;
import repository.Categoria;
import repository.TipoProjeto;

public class Projeto {
    private Integer codigo;
    private String nome;
    private String descricao;
    private String coordenacao;
    private Instituicao instituicao;
    private TipoProjeto tipo;
    private Categoria categoria;

    public Projeto() {

    }

    public Projeto(String nome, String descricao, String coordenacao, Instituicao instituicao,
                   TipoProjeto tipo, Categoria categoria) {

        this.nome = nome;
        this.descricao = descricao;
        this.coordenacao = coordenacao;
        this.instituicao = instituicao;
        this.tipo = tipo;
        this.categoria = categoria;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCoordenacao() {
        return coordenacao;
    }

    public void setCoordenacao(String coordenacao) {
        this.coordenacao = coordenacao;
    }

    public Instituicao getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(Instituicao instituicao) {
        this.instituicao = instituicao;
    }

    public TipoProjeto getTipo() {
        return tipo;
    }

    public void setTipo(TipoProjeto tipo) {
        this.tipo = tipo;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "model.Projeto{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", coordenacao='" + coordenacao + '\'' +
                ", instituicao=" + instituicao +
                ", tipo=" + tipo +
                ", categoria=" + categoria +
                '}';
    }
}
