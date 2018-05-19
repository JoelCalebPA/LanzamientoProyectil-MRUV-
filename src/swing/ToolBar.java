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
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author Caleb
 */
public class ToolBar extends JPanel {

    private static ToolBar INSTANCE;
    private JRadioButton rbtnCompleto;
    private JRadioButton rbtnSemi;
    private JCheckBox chkConservarTrayectoria;

    private ToolBar() {
        initComponents();
    }
    
    private void initComponents() {
        setLayout(new FlowLayout(FlowLayout.LEFT, 10, 0));
        setBorder(BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(), BorderFactory.createLoweredBevelBorder()));
        ButtonGroup group = new ButtonGroup();
        rbtnCompleto = new JRadioButton("Movimiento Parabólico Completo");
        rbtnSemi = new JRadioButton("Movimiento Semiparabólico");
        chkConservarTrayectoria = new JCheckBox("Conservar trayectoria");
        JTextField espacio = new JTextField();
        espacio.setPreferredSize(new Dimension(220, 40));
        espacio.setBackground(Color.LIGHT_GRAY);
        espacio.setBorder(null);
        espacio.setEnabled(false);
        group.add(rbtnCompleto);
        group.add(rbtnSemi);
        rbtnCompleto.setSelected(true);
        rbtnCompleto.setEnabled(false);
        rbtnSemi.setEnabled(false);
        add(rbtnCompleto);
        add(rbtnSemi);
        add(espacio);
        add(chkConservarTrayectoria);
    }

    public static ToolBar getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ToolBar();
        }
        return INSTANCE;
    }
    
    public JRadioButton getRbtnCompleto() {
        return rbtnCompleto;
    }

    public JRadioButton getRbtnSemi() {
        return rbtnSemi;
    }

    public JCheckBox getChkConservarTrayectoria() {
        return chkConservarTrayectoria;
    }
    
}
