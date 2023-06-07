package org.example.controlador;

import org.example.modelo.Minerales;
import org.example.modelo.ModeloTabla;
import org.example.persistencia.ConexionSQL;
import org.example.vista.VentanaMinerales;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class ControladorMinerales extends MouseAdapter {
    private VentanaMinerales view;
    private ModeloTabla modelo;

    public ControladorMinerales(VentanaMinerales view) {
        this.view = view;
        modelo = new ModeloTabla();
        this.view.getBtnActuzalizar().addMouseListener(this);
        this.view.getBtnCargar().addMouseListener(this);
        this.view.getBtnEliminar().addMouseListener(this);
        this.view.getTabla().setModel(modelo);
        this.view.getBotonAdd().addMouseListener(this);
        this.view.getTabla().addMouseListener(this);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == this.view.getBtnCargar()) {
            modelo.cargar();
            this.view.getTabla().setModel(modelo);
            this.view.getTabla().updateUI();
            this.view.limpiar();
        }
        if (e.getSource() == view.getBotonAdd()) {
            System.out.println("Evento sobre boton add");
            Minerales minerales = new Minerales("Id, Nombre, Tipo, Color, Dureza, Url");
            minerales.setId(0);
            minerales.setId(Integer.parseInt(this.view.getTxtId().getText()));
            minerales.setNombre(this.view.getTxtNombre().getText());
            minerales.setTipo(this.view.getTxtTipo().getText());
            minerales.setColor(this.view.getTxtColor().getText());
            minerales.setDureza(this.view.getTxtDureza().getText());
            minerales.setUrl(this.view.getTxtUrl().getText());
            this.view.getTabla().updateUI();
            modelo.agrgarMineral(minerales);

            if (e.getSource() == this.view.getBtnActuzalizar()) {
                int respuesta = JOptionPane.showConfirmDialog(view, "¿Estas seguro de actuzalizar?", "Confirmar", JOptionPane.YES_NO_OPTION);
                if (e.getSource() == this.view.getBtnActuzalizar()) {
                    int resultado = JOptionPane.showConfirmDialog(view, "Actuzalizar registro", "!!", JOptionPane.YES_NO_OPTION);
                    if (resultado == 0) {
                        minerales.setId(Integer.parseInt((String) this.view.getTxtIdp4().getText()));
                        minerales.setNombre(this.view.getTxtNombrep4().getText());
                        minerales.setTipo(this.view.getTxtTipop4().getText());
                        minerales.setColor(this.view.getTxtColorp4().getText());
                        minerales.setDureza(this.view.getTxtDurezap4().getText());
                        minerales.setUrl(this.view.getTxtUrlp4().getText());
                        this.view.getTabla().updateUI();

                        this.view.limpiarp4();
                    } else {
                        this.view.limpiarp4();
                    }
                }
            }
            if (e.getSource() == this.view.getBtnEliminar()) {
                int respuesta = JOptionPane.showConfirmDialog(view, "Estas seguro de borrar el registro?",
                        "Confirmar", JOptionPane.YES_NO_OPTION);
                if (respuesta == 0) {
                    String sqlDelete = "DELETE FROM Campeones WHERE id=?;";
                    PreparedStatement pstm = null;
                    try {
                        pstm = ConexionSQL.getInstance("mineralesDB.db").getConexion().prepareStatement(sqlDelete);
                    } catch (SQLException sqle) {
                        throw new RuntimeException(sqle);
                    }
                    try {
                        pstm.setInt(1, Integer.parseInt(this.view.getTxtEliminarId().getText()));
                        this.view.getTabla().updateUI();
                        JOptionPane.showMessageDialog(view, "Se elimino", "aviso", JOptionPane.INFORMATION_MESSAGE);
                    } catch (NumberFormatException a) {
                        JOptionPane.showMessageDialog(view, "No se elimino", "aviso", JOptionPane.ERROR_MESSAGE);
                    } catch (SQLException ex) {
                        System.out.println(ex.getMessage());
                    }
                    try {
                        pstm.executeUpdate();
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(view, "Error de Id", "aviso", JOptionPane.INFORMATION_MESSAGE);
                        throw new RuntimeException(ex);
                    } finally {
                        this.view.limpiarp4();
                    }
                }
            }
            if (e.getSource() == view.getTabla()) {
                int index = this.view.getTabla().getSelectedRow();
                Minerales tmp = modelo.getMineralAtIndex(index);
                try {
                    this.view.getImagenMineral().setIcon(tmp.getImagen());
                } catch (MalformedURLException mfue) {
                    System.out.println(e.toString());


                }
            }
        }
    }
}
