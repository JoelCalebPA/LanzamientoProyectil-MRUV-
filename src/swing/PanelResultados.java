/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Caleb
 */
public class PanelResultados extends JPanel {

    /* Instancia de la clase PanelResultados */
    private static PanelResultados INSTANCE;

    private final String[] LBLSVELOCIDAD = {"Distancia recorrida: ", "Altura máxima: ",
        "Tiempo en el aire: ", "Tiempo en altura máxima: "};
    private final String[] LBLSTIEMPO = {"Distancia recorrida: ", "Altura alcanzada: ", "Velocidad en X: ", "Velocidad en Y: ", "Velocidad: "};
    private final String[] LBLSDISTANCIA = {"Altura alcanzada: ", "Tiempo requerido: ", "Velocidad en X: ", "Velocidad en Y: ", "Velocidad: "};

    /* Dimension predeterminada para los paneles resultado(velocidad, tiempo, distancia) */
    private static final Dimension PANELDIM = new Dimension(264, 158);

    /* Declarando los paneles de resultados */
    private PanelVelocidad panelVelocidad;
    private PanelTiempo panelTiempo;
    private PanelDistancia panelDistancia;


    /* Labels del panel Velocidad */
    private LabelDato lblDistanciaRecorrida;
    private LabelDato lblAlturaMaxima;
    private LabelDato lblTiempoEnAire;
    private LabelDato lblTiempoEnAlturaMaxima;

    /* Labels del panel Tiempo */
    private LabelDato lblPosicionXEnTiempo;
    private LabelDato lblPosicionYEnTiempo;
    private LabelDato lblVelocidadYEnTiempo;
    private LabelDato lblVelocidadEnTiempo;

    /* Labels del panel Distancia */
    private LabelDato lblPosicionYEnDistancia;
    private LabelDato lblTiempoEnDistancia;
    private LabelDato lblVelocidadYEnDistancia;
    private LabelDato lblVelocidadEnDistancia;

    private PanelResultados() {
        initComponents();
    }

    private void initComponents() {
        setPreferredSize(new Dimension(795, 160));
        setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        panelVelocidad = new PanelVelocidad();
        panelTiempo = new PanelTiempo();
        panelDistancia = new PanelDistancia();

        add(panelVelocidad);
        add(panelTiempo);
        add(panelDistancia);
    }

    public static PanelResultados getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new PanelResultados();
        }
        return INSTANCE;
    }

    public void setEventos(MouseListener ev) {
        for (Component c : getComponents()) {
            if (c.getClass().equals(new JLabel().getClass())) {
                c.addMouseListener(ev);
            }
        }
    }

    public LabelDato[] getLblsDatos() {
        return null;
    }

    public class TextField extends JTextField {

        public TextField() {
            super.setPreferredSize(new Dimension(60, 20));
            super.setEditable(false);
        }

    }

    public final class LabelDato extends JLabel {

        private final ImageIcon icon = new ImageIcon(getClass().getResource("/imagenes/dato.png"));
        private final String string;
        
        public LabelDato(String text) {
            super.setText(text);
            super.setIcon(icon);
            string = getText();
        }
        
        public void append(String text) {
            setText(string + " " + text);
        }

    }

    public final class PanelVelocidad extends JPanel {

        public PanelVelocidad() {
            initComponents();
        }

        void initComponents() {
            setPreferredSize(PANELDIM);
            setLayout(new GridLayout(4, 1));
            setBorder(new TitledBorder(BorderFactory.createLineBorder(Color.lightGray), "Resultados Generales"));

            lblDistanciaRecorrida = new LabelDato(LBLSVELOCIDAD[0]);
            lblAlturaMaxima = new LabelDato(LBLSVELOCIDAD[1]);
            lblTiempoEnAire = new LabelDato(LBLSVELOCIDAD[2]);
            lblTiempoEnAlturaMaxima = new LabelDato(LBLSVELOCIDAD[3]);

            add(lblDistanciaRecorrida);
            add(lblAlturaMaxima);
            add(lblTiempoEnAire);
            add(lblTiempoEnAlturaMaxima);
        }
    }

    public final class PanelTiempo extends JPanel {

        public PanelTiempo() {
            initComponents();
        }

        void initComponents() {
            setPreferredSize(PANELDIM);
            setLayout(new GridLayout(4, 1));
            setBorder(new TitledBorder(BorderFactory.createLineBorder(Color.lightGray), "Resultados respecto al tiempo"));

            lblPosicionXEnTiempo = new LabelDato(LBLSTIEMPO[0]);
            lblPosicionYEnTiempo = new LabelDato(LBLSTIEMPO[1]);
            lblVelocidadYEnTiempo = new LabelDato(LBLSTIEMPO[3]);
            lblVelocidadEnTiempo = new LabelDato(LBLSTIEMPO[4]);

            add(lblPosicionXEnTiempo);
            add(lblPosicionYEnTiempo);
            add(lblVelocidadYEnTiempo);
            add(lblVelocidadEnTiempo);
        }
    }

    public final class PanelDistancia extends JPanel {

        public PanelDistancia() {
            initComponents();
        }

        void initComponents() {
            setPreferredSize(PANELDIM);
            setLayout(new GridLayout(4, 1));
            setBorder(new TitledBorder(BorderFactory.createLineBorder(Color.lightGray), "Resultados respecto a la distancia"));

            lblPosicionYEnDistancia = new LabelDato(LBLSDISTANCIA[0]);
            lblTiempoEnDistancia = new LabelDato(LBLSDISTANCIA[1]);
            lblVelocidadYEnDistancia = new LabelDato(LBLSDISTANCIA[3]);
            lblVelocidadEnDistancia = new LabelDato(LBLSDISTANCIA[4]);

            add(lblPosicionYEnDistancia);
            add(lblTiempoEnDistancia);
            add(lblVelocidadYEnDistancia);
            add(lblVelocidadEnDistancia);
        }
    }

    public LabelDato getLblDistanciaRecorrida() {
        return lblDistanciaRecorrida;
    }

    public LabelDato getLblAlturaMaxima() {
        return lblAlturaMaxima;
    }

    public LabelDato getLblTiempoEnAire() {
        return lblTiempoEnAire;
    }

    public LabelDato getLblTiempoEnAlturaMaxima() {
        return lblTiempoEnAlturaMaxima;
    }

    public LabelDato getLblPosicionXEnTiempo() {
        return lblPosicionXEnTiempo;
    }

    public LabelDato getLblPosicionYEnTiempo() {
        return lblPosicionYEnTiempo;
    }

    public LabelDato getLblVelocidadYEnTiempo() {
        return lblVelocidadYEnTiempo;
    }

    public LabelDato getLblVelocidadEnTiempo() {
        return lblVelocidadEnTiempo;
    }

    public LabelDato getLblPosicionYEnDistancia() {
        return lblPosicionYEnDistancia;
    }

    public LabelDato getLblTiempoEnDistancia() {
        return lblTiempoEnDistancia;
    }

    public LabelDato getLblVelocidadYEnDistancia() {
        return lblVelocidadYEnDistancia;
    }

    public LabelDato getLblVelocidadEnDistancia() {
        return lblVelocidadEnDistancia;
    }

    
    
}
