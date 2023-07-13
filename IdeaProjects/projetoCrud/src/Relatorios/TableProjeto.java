package Relatorios;

import model.Projeto;

import javax.swing.table.AbstractTableModel;
import java.util.Vector;

public class TableProjeto extends AbstractTableModel {

    private static final long serialVersionUID = 1L;

    public static final int INDEX_CODIGO = 0;
    public static final int INDEX_NOME = 1;
    public static final int INDEX_DESCRICAO = 2;
    public static final int INDEX_COORDENACAO = 3;
    public static final int INDEX_INSTITUICAO = 4;
    public static final int INDEX_TIPO = 5;
    public static final int INDEX_CATEGORIA = 6;
    public static final int INDEX_ESCONDIDO = 7;

    protected String[] nomeColunas;
    protected Vector<Projeto> vetorDados;

    public TableProjeto(String[] columnNames, Vector<Projeto> vetorDados) {
        this.nomeColunas = columnNames;
        this.vetorDados = vetorDados;
    }

    @Override
    public String getColumnName(int column) {
        return nomeColunas[column];
    }

    @Override
    public boolean isCellEditable(int linha, int coluna) {
        if (coluna == INDEX_ESCONDIDO) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        Projeto registroInstituicao = (Projeto) vetorDados.get(linha);
        switch (coluna) {
            case INDEX_CODIGO:
                return registroInstituicao.getCodigo();
            case INDEX_NOME:
                return registroInstituicao.getNome();
            case INDEX_DESCRICAO:
                return registroInstituicao.getDescricao();
            case INDEX_COORDENACAO:
                return registroInstituicao.getCoordenacao();
            case INDEX_INSTITUICAO:
                return registroInstituicao.getInstituicao().getNome();
            case INDEX_TIPO:
                return registroInstituicao.getTipo();
            case INDEX_CATEGORIA:
                return registroInstituicao.getCategoria();
            default:
                return new Object();
        }
    }


    @Override
    public int getRowCount() {
        return vetorDados.size();
    }

    @Override
    public int getColumnCount() {
        return nomeColunas.length;
    }
}
