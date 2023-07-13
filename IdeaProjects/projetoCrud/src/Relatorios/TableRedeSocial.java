package Relatorios;

import model.RedeSocial;

import javax.swing.table.AbstractTableModel;
import java.util.Vector;

public class TableRedeSocial extends AbstractTableModel {

    private static final long serialVersionUID = 1L;

    public static final int INDEX_ID = 0;
    public static final int INDEX_DESCRICAO = 1;
    public static final int INDEX_CODIGO_INSTITUICAO = 2;
    public static final int INDEX_ESCONDIDO = 3;

    protected String[] nomeColunas;
    protected Vector<RedeSocial> vetorDados;

    public TableRedeSocial(String[] columnNames, Vector<RedeSocial> vetorDados) {
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
        RedeSocial registroRedeSocial = (RedeSocial) vetorDados.get(linha);
        switch (coluna) {
            case INDEX_ID:
                return registroRedeSocial.getId();
            case INDEX_DESCRICAO:
                return registroRedeSocial.getDescricao();
            case INDEX_CODIGO_INSTITUICAO:
                return registroRedeSocial.getCodigoInstituicao();
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
