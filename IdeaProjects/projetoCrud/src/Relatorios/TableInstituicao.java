package Relatorios;

import model.Instituicao;

import javax.swing.table.AbstractTableModel;
import java.util.Vector;

public class TableInstituicao extends AbstractTableModel {

    private static final long serialVersionUID = 1L;

    public static final int INDEX_CODIGO = 0;
    public static final int INDEX_NOME = 1;
    public static final int INDEX_RUA = 2;
    public static final int INDEX_BAIRRO = 3;
    public static final int INDEX_NUMERO = 4;
    public static final int INDEX_TELEFONE = 5;
    public static final int INDEX_REDES_SOCIAS = 6;
    public static final int INDEX_CIDADE = 7;
    public static final int INDEX_ESCONDIDO = 8;

    protected String[] nomeColunas;
    protected Vector<Instituicao> vetorDados;

    public TableInstituicao(String[] columnNames, Vector<Instituicao> vetorDados) {
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
        Instituicao registroInstituicao = (Instituicao) vetorDados.get(linha);
        switch (coluna) {
            case INDEX_CODIGO:
                return registroInstituicao.getCodigo();
            case INDEX_NOME:
                return registroInstituicao.getNome();
            case INDEX_RUA:
                return registroInstituicao.getRua();
            case INDEX_BAIRRO:
                return registroInstituicao.getBairro();
            case INDEX_NUMERO:
                return registroInstituicao.getNumero();
            case INDEX_TELEFONE:
                return registroInstituicao.getTelefone();
            case INDEX_REDES_SOCIAS:
                return registroInstituicao.getRedesSociais();
            case INDEX_CIDADE:
                return registroInstituicao.getCidade().getNome();
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
