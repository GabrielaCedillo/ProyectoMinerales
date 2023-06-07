package org.example.modelo;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.ArrayList;

public class ModeloTabla implements TableModel {
    private ArrayList<Minerales> datos;
    public static final int COLS = 6;

    public ModeloTabla() {
        datos = new ArrayList<>();
    }

    public ModeloTabla(ArrayList<Minerales> datos) {
        this.datos = datos;
    }

    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return COLS;
    }

    @Override
    public String getColumnName(int columnIndex) {
        String nombreCol = "";
        switch (columnIndex){
            case 0:
                nombreCol = "Id";
                break;
            case 1:
                nombreCol = "Nombre";
                break;
            case 2:
                nombreCol = "Tipo";
                break;
            case 3:
                nombreCol = "Color";
                break;
            case 4:
                nombreCol = "Dureza";
                break;
            case 5:
                nombreCol = "Url";
                break;
            default:
                nombreCol = "";
        }

        return nombreCol;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return Integer.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
            case 3:
                return String.class;
            case 4:
                return String.class;
            case 5:
                return String.class;
            default:
                return String.class;

        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Minerales tmp = datos.get(rowIndex);
        switch (columnIndex){
            case 0 :
                return tmp.getId();
            case 1 :
                return tmp.getNombre();
            case 2 :
                return tmp.getTipo();
            case 3 :
                return tmp.getColor();
            case 4 :
                return tmp.getDureza();
            case 5 :
                return tmp.getUrl();
        }
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0:
                datos.get(rowIndex).setId((Integer) aValue);
                break;
            case 1:
                datos.get(rowIndex).setNombre((String) aValue);
                break;
            case 2:
                datos.get(rowIndex).setTipo((String) aValue);
                break;
            case 3:
                datos.get(rowIndex).setColor((String) aValue);
                break;
            case 4:
                datos.get(rowIndex).setDureza((String) aValue);
                break;
            case 5:
                datos.get(rowIndex).setUrl((String) aValue);
                break;
        }

    }

    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {

    }
    public void agrgarMineral(Minerales mineral){
        datos.add(mineral);
    }
    public  Minerales getMineralAtIndex (int idx){
        return datos.get(idx);
    }

    public void cargar() {
    }
}
