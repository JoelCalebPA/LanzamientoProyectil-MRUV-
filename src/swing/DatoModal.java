/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JDialog;

/**
 *
 * @author Caleb
 */
public class DatoModal extends JDialog {

    private Image formula;

    public DatoModal() {
        initComponents();
    }

    private void initComponents() {
        setUndecorated(true);
        setFocusableWindowState(false);
    }

    public void setDato(int numImg, int posX, int posY) {
        formula = new ImageIcon(getClass().getResource("/imagenes/" + numImg + ".png")).getImage();
        setSize(new Dimension(formula.getWidth(null), formula.getHeight(null)));
        setLocation(posX, posY - formula.getHeight(null)/2);
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(formula, 0, 0, null);
    }

}
