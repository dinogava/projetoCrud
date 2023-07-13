package repository;//ISTO SERÁ UMA ENUM

public enum TipoProjeto {
    PESQUISA(0,"Pesquisa"),
    EXTENSAO(1,"Extensão"),
    GRADUACAO(2,"Graduação"),
    POS_GRADUACAO(3,"Pós graduação"),
    MESTRADO(4,"Mestrado"),
    DOUTORADO(5,"Doutorado"),
    STARTUP(6,"Startup");

    private String descricaoTipo;
    private Integer codigo;

    TipoProjeto(Integer codigo ,String descricaoTipo) {
        this.codigo = codigo;
        this.descricaoTipo = descricaoTipo;
    }

    public static String getEnumByString(String code) {
        for (TipoProjeto e : TipoProjeto.values()) {
            if (e.descricaoTipo.equals(code)) {
                return e.name();
            }
        }
        return null;
    }
    public static void add(TipoProjeto escolheTipo) {

    }

    public Integer getCodigo() {
        return codigo;
    }

    public static TipoProjeto getTipoById(Integer opcao) {
        if (opcao == 0) {
            return PESQUISA;
        } else if (opcao == 1) {
            return EXTENSAO;
        }  else if (opcao == 2) {
            return GRADUACAO;
        }  else if (opcao == 3) {
             return POS_GRADUACAO;
        }  else if (opcao == 4) {
             return MESTRADO;
        }  else if (opcao == 5) {
             return DOUTORADO;
            } else if (opcao == 6){
            return STARTUP;
        }else {
            return null;
        }
    }

    public String getDescricao() {
        return descricaoTipo;
    }
}
