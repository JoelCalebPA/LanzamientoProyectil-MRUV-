/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
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

    private static PanelResultados INSTANCE;

    private final String[] LABELS = {"Altura actual:", "Altura máxima alcanzada:", "Distancia recorrida:",
        "Tiempo en el aire:", "Tiempo en alcanzar altura máxima:", "Velocidad en tiempo dado:", "Posición en tiempo dado:"};

    private final JLabel lblAlturaMaxima = new JLabel(LABELS[1]);
    private final JLabel lblDistanciaRecorrida = new JLabel(LABELS[2]);
    private final JLabel lblTiempoEnAire = new JLabel(LABELS[3]);
    private final JLabel lblTiempoEnAlturaMaxima = new JLabel(LABELS[4]);
    private final JLabel lblVelocidadEnTiempo = new JLabel(LABELS[5]);
    private final JLabel lblPosicionEnTiempo = new JLabel(LABELS[6]);

    private final LeftPanel leftPanel = new LeftPanel();
    private final RightPanel rightPanel = new RightPanel();

    private TextField txtAlturaMaxima;
    private TextField txtDistanciaRecorrida;
    private TextField txtTiempoEnAire;
    private TextField txtTiempoEnAlturaMaxima;
    private TextField txtVelocidadEnTiempo;
    private TextField txtPosicionEnTiempo;

    private LabelDato lblDatoAlturaMaxima;
    private LabelDato lblDatoDistanciaRecorrida;
    private LabelDato lblDatoTiempoEnAire;
    private LabelDato lblDatoTiempoEnAlturaMaxima;
    private LabelDato lblDatoVelocidadEnTiempo;
    private LabelDato lblDatoPosicionEnTiempo;
    private final LabelDato[] lblsDatos = {lblDatoAlturaMaxima, lblDatoDistanciaRecorrida, lblDatoTiempoEnAire,
        lblDatoTiempoEnAlturaMaxima, lblDatoVelocidadEnTiempo, lblDatoPosicionEnTiempo};

    private PanelResultados() {
        initComponents();
    }

    private void initComponents() {
        setPreferredSize(new Dimension(795, 160));
        setBorder(new TitledBorder(BorderFactory.createLineBorder(Color.lightGray), "Resultados"));
        setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));
        add(leftPanel);
        add(rightPanel);
    }

    public static PanelResultados getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new PanelResultados();
        }
        return INSTANCE;
    }

    public TextField getTxtAlturaMaxima() {
        return txtAlturaMaxima;
    }

    public TextField getTxtDistanciaRecorrida() {
        return txtDistanciaRecorrida;
    }

    public TextField getTxtTiempoEnAire() {
        return txtTiempoEnAire;
    }

    public JLabel getLblAlturaMaxima() {
        return lblAlturaMaxima;
    }

    public TextField getTxtTiempoEnAlturaMaxima() {
        return txtTiempoEnAlturaMaxima;
    }

    public TextField getTxtVelocidadEnTiempo() {
        return txtVelocidadEnTiempo;
    }

    public TextField getTxtPosicionEnTiempo() {
        return txtPosicionEnTiempo;
    }

    public LabelDato getLblDatoAlturaMaxima() {
        return lblDatoAlturaMaxima;
    }

    public LabelDato getLblDatoDistanciaRecorrida() {
        return lblDatoDistanciaRecorrida;
    }

    public LabelDato getLblDatoTiempoEnAire() {
        return lblDatoTiempoEnAire;
    }

    public LabelDato getLblDatoTiempoEnAlturaMaxima() {
        return lblDatoTiempoEnAlturaMaxima;
    }

    public LabelDato getLblDatoVelocidadEnTiempo() {
        return lblDatoVelocidadEnTiempo;
    }

    public LabelDato getLblDatoPosicionEnTiempo() {
        return lblDatoPosicionEnTiempo;
    }

    public void setEventos(MouseListener ev) {
        for (LabelDato lblDato : lblsDatos) {
            lblDato.addMouseListener(ev);
        }
    }

    public LabelDato[] getLblsDatos() {
        return lblsDatos;
    }

    public class TextField extends JTextField {

        public TextField() {
            super.setPreferredSize(new Dimension(60, 20));
            super.setEditable(false);
        }

    }

    public final class LabelDato extends JLabel {

        private final ImageIcon icon = new ImageIcon(getClass().getResource("/imagenes/dato.png"));

        public LabelDato() {
            initComponents();
        }
        
        void initComponents() {
            setVisible(true);
            setIcon(icon);
        }
      
    }

    public final class LeftPanel extends JPanel {

        public LeftPanel() {
            initComponents();
        }

        void initComponents() {
            setPreferredSize(new Dimension(310, 130));
            setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
            txtAlturaMaxima = new TextField();
            txtDistanciaRecorrida = new TextField();
            txtTiempoEnAire = new TextField();
            txtTiempoEnAlturaMaxima = new TextField();
            lblDatoAlturaMaxima = new LabelDato();
            lblDatoDistanciaRecorrida = new LabelDato();
            lblDatoTiempoEnAire = new LabelDato();
            lblDatoTiempoEnAlturaMaxima = new LabelDato();

            add(lblDistanciaRecorrida);
            add(txtDistanciaRecorrida);
            add(lblDatoDistanciaRecorrida);
            add(lblAlturaMaxima);
            add(txtAlturaMaxima);
            add(lblDatoAlturaMaxima);
            add(lblTiempoEnAire);
            add(txtTiempoEnAire);
            add(lblDatoTiempoEnAire);
            add(lblTiempoEnAlturaMaxima);
            add(txtTiempoEnAlturaMaxima);
            add(lblDatoTiempoEnAlturaMaxima);
        }

    }

    public class RightPanel extends JPanel {

        public RightPanel() {
            initComponents();
        }

        void initComponents() {
            setPreferredSize(new Dimension(350, 130));
            setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
            txtVelocidadEnTiempo = new TextField();
            txtPosicionEnTiempo = new TextField();
            txtPosicionEnTiempo.setPreferredSize(new Dimension(150, 20));
            lblDatoVelocidadEnTiempo = new LabelDato();
            lblDatoPosicionEnTiempo = new LabelDato();
            add(lblVelocidadEnTiempo);
            add(txtVelocidadEnTiempo);
            add(lblDatoVelocidadEnTiempo);
            add(lblPosicionEnTiempo);
            add(txtPosicionEnTiempo);
            add(lblDatoPosicionEnTiempo);

        }
    }
    
}
