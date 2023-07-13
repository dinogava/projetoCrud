package repository;//ISTO SERÁ UMA ENUM

public enum Categoria {
    TECNOLOGIA(0, "Tecnologia"),
    ENGENHARIA(1, "Engenharia"),
    AGRONOMIA(2, "Agronomia"),
    SAUDE(3, "Saúde"),
    EDUCACAO(4, "Educação"),
    SOCIAL(5, "Social");

    private String descricaoCategoria;
    private Integer codigo;

    Categoria(Integer codigo, String descricaoCategoria) {
        this.codigo = codigo;
        this.descricaoCategoria = descricaoCategoria;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public static Categoria getCategoriaById(Integer opcao) {
        if (opcao == 0) {
            return TECNOLOGIA;
        } else if (opcao == 1) {
            return ENGENHARIA;
        } else if (opcao == 2) {
            return AGRONOMIA;
        } else if (opcao == 3) {
            return SAUDE;
        } else if (opcao == 4) {
            return EDUCACAO;
        } else if (opcao == 5) {
            return SOCIAL;
        } else {
            return null;
        }
    }

    public static String getEnumByString(String code) {
        for (Categoria e : Categoria.values()) {
            if (e.descricaoCategoria.equals(code)) {
                return e.name();
            }
        }
        return null;
    }

    public static void add(Categoria escolheCategoria) {

    }

    public String getDescricaoCategoria() {
        return descricaoCategoria;
    }
}