/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Caleb
 */
public class PanelDatos extends JPanel {

    private static PanelDatos INSTANCE;

    private final int ANCHO = 235;
    private final int ALTO = 290;

    private JButton btnIniciarAnimacion;

    private JTextField txtVelocidad;
    private JTextField txtTiempo;
    private JTextField txtAngulo;
    private JTextField txtDistancia;

    private JComboBox<String> cbVelocidad;
    private JComboBox<String> cbTiempo;
    private JComboBox<String> cbDistancia;
    private JComboBox<String> cbAngulo;

    private SliderAngulo sliderAngulo;

    private final String[] LABELS = {"Distancia:", "Velocidad:", "Tiempo:", "Ángulo:"};
    private final String[] CBVELOCIDAD = {"m/s"};
    private final String[] CBTIEMPO = {"s"};
    private final String[] CBDISTANCIA = {"m", "km"};
    private final String[] CBANGULO = {"°", "rad"};

    private final Dimension txtDim = new Dimension(60, 20);
    private final Dimension cbDim = new Dimension(60, 20);

    private JLabel lblPosActualX;
    private JLabel lblPosActualY;
    private JLabel lblVelActualX;
    private JLabel lblVelActualY;

    public PanelDatos() {
        initComponents();
    }

    public static PanelDatos getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new PanelDatos();
        }
        return INSTANCE;
    }

    private void initComponents() {
        setLayout(new FlowLayout(FlowLayout.LEFT, 10, 5));
        setPreferredSize(new Dimension(ANCHO, ALTO));
        setBorder(new TitledBorder(BorderFactory.createLineBorder(Color.lightGray), "Datos"));
        sliderAngulo = new SliderAngulo();

        btnIniciarAnimacion = new JButton("Iniciar animación");

        JLabel lblVelocidad = new JLabel(LABELS[1]);
        JLabel lblTiempo = new JLabel(LABELS[2]);
        JLabel lblAngulo = new JLabel(LABELS[3]);
        JLabel lblDistancia = new JLabel(LABELS[0]);

        txtVelocidad = new JTextField();
        txtTiempo = new JTextField();
        txtAngulo = new JTextField();
        txtDistancia = new JTextField();

        txtVelocidad.setPreferredSize(txtDim);
        txtTiempo.setPreferredSize(txtDim);
        txtAngulo.setPreferredSize(txtDim);
        txtDistancia.setPreferredSize(txtDim);

        cbVelocidad = new JComboBox<>();
        cbTiempo = new JComboBox<>();
        cbDistancia = new JComboBox<>();
        cbAngulo = new JComboBox<>();

        cbVelocidad.setPreferredSize(cbDim);
        cbTiempo.setPreferredSize(cbDim);
        cbDistancia.setPreferredSize(cbDim);
        cbAngulo.setPreferredSize(cbDim);

        cbVelocidad.addItem(CBVELOCIDAD[0]);
        cbTiempo.addItem(CBTIEMPO[0]);
        cbDistancia.addItem(CBDISTANCIA[0]);
        cbAngulo.addItem(CBANGULO[0]);

        lblVelocidad.setLabelFor(txtVelocidad);
        lblTiempo.setLabelFor(txtTiempo);
        lblAngulo.setLabelFor(txtAngulo);

        lblPosActualX = new JLabel("Posición actual en X: ");
        lblPosActualY = new JLabel("Posición actual en Y: ");
        lblVelActualX = new JLabel("Velocidad actual en X: ");
        lblVelActualY = new JLabel("Velocidad actual en Y: ");

        add(lblVelocidad);
        add(txtVelocidad);
        add(cbVelocidad);
        add(lblTiempo);
        add(txtTiempo);
        add(cbTiempo);
        add(lblDistancia);
        add(txtDistancia);
        add(cbDistancia);
        add(lblAngulo);
        add(txtAngulo);
        add(cbAngulo);
        add(sliderAngulo);
        add(btnIniciarAnimacion);
        add(lblPosActualX);
        add(lblPosActualY);
        add(lblVelActualX);
        add(lblVelActualY);
    }

    public JTextField getTxtVelocidad() {
        return txtVelocidad;
    }

    public JTextField getTxtTiempo() {
        return txtTiempo;
    }

    public JTextField getTxtAngulo() {
        return txtAngulo;
    }

    public JTextField getTxtDistancia() {
        return txtDistancia;
    }

    public SliderAngulo getSliderAngulo() {
        return sliderAngulo;
    }

    public JButton getBtnIniciarAnimacion() {
        return btnIniciarAnimacion;
    }

    public JLabel getLblPosActualX() {
        return lblPosActualX;
    }

    public JLabel getLblPosActualY() {
        return lblPosActualY;
    }

    public JLabel getLblVelActualX() {
        return lblVelActualX;
    }

    public JLabel getLblVelActualY() {
        return lblVelActualY;
    }

    public class SliderAngulo extends JSlider {

        private static final int SMIN = 0;
        private static final int SMAX = 90;
        private static final int SVALUE = 0;
        private static final int MINTSPACING = 1;
        private static final int MAXTSPACING = 15;
        private static final String TOOLTIP = "Mueve el slider para obtener resultados";

        public SliderAngulo() {
            super.setOrientation(JSlider.HORIZONTAL);
            super.setMinimum(SMIN);
            super.setMaximum(SMAX);
            super.setValue(SVALUE);
            super.setMinorTickSpacing(MINTSPACING);
            super.setMajorTickSpacing(MAXTSPACING);
            super.setPaintLabels(true);
            super.setPaintTicks(true);
            super.setToolTipText(TOOLTIP);
        }

    }

}
