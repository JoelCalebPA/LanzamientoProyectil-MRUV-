/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Caleb
 */
public class VentanaPrincipal extends JFrame {

    private static final int ANCHO = 830;
    private static final int ALTO = 570;
    private static final String TITLE = "Lanzamiento de un Proyectil Virtual";

    private Contenedor contenedor;
    private ToolBar toolbar;

    private VentanaPrincipal() {
        initComponents();
    }

    public static VentanaPrincipal getInstance() {
        return VentanaPrincipalHolder.INSTANCE;
    }

    private static class VentanaPrincipalHolder {

        private static final VentanaPrincipal INSTANCE = new VentanaPrincipal();
    }

    private void initComponents() {
        contenedor = new Contenedor();
        toolbar = ToolBar.getInstance();
        setLayout(new BorderLayout());
        setSize(ANCHO, ALTO);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle(TITLE);
        add(contenedor, BorderLayout.CENTER);
        add(toolbar, BorderLayout.NORTH);
    }

    class Contenedor extends JPanel {

        PanelSimulacion panelSimulacion;
        PanelDatos panelDatos;
        PanelResultados panelResultados;

        public Contenedor() {
            initComponents();
        }

        private void initComponents() {
            panelSimulacion = PanelSimulacion.getInstance();
            panelDatos = PanelDatos.getInstance();
            panelResultados = PanelResultados.getInstance();
            setBorder(BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(),
                    BorderFactory.createLoweredBevelBorder()));
            setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
            add(panelSimulacion);
            add(panelDatos);
            add(panelResultados);
        }
    }

}
