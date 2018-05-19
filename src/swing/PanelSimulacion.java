/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Caleb
 */
public class PanelSimulacion extends JPanel {

    private static PanelSimulacion INSTANCE;

    private static final int ANCHO = 550;
    private static final int ALTO = 290;

    private static final int[] XFLECHA1 = {15, 25, 20};
    private static final int[] YFLECHA1 = {20, 20, 10};
    private static final int[] XFLECHA2 = {530, 530, 540};
    private static final int[] YFLECHA2 = {265, 275, 270};
    private static final int LINEAS = 3;
    private static final int[] PL1 = {20, 10, 20, 285};
    private static final int[] PL2 = {5, 270, 535, 270};
    private final Image IMGFONDO = new ImageIcon(getClass().getResource("/imagenes/fondo.png")).getImage();
    private final Image IMGPUNTO = new ImageIcon(getClass().getResource("/imagenes/punto.png")).getImage();

    private ArrayList<Integer> puntosX;
    private ArrayList<Integer> puntosY;

    private Proyectil proyectil;
    private boolean movCompleto = true;

    private PanelSimulacion() {
        initComponents();
    }

    public static PanelSimulacion getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new PanelSimulacion();
        }
        return INSTANCE;
    }

    private void initComponents() {
        setPreferredSize(new Dimension(ANCHO, ALTO));
        setBackground(Color.white);
        setBorder(BorderFactory.createLineBorder(Color.lightGray));
        setDoubleBuffered(true);
        proyectil = new Proyectil();
        reiniciarPosicionProyectil();
        puntosX = new ArrayList<>();
        puntosY = new ArrayList<>();
    }

    public void reiniciarPosicionProyectil() {
        if (movCompleto) {
            proyectil.setPosicionInicial(20, 270);
        } else {
            proyectil.setPosicionInicial(50, 20);
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        try {
            g.drawImage(IMGFONDO, 0, 0, null);
            g.setColor(Color.black);
            g.setFont(new Font("Serif", Font.BOLD, 18));
            if (puntosX.size() > 0) {
                proyectil.dibujar(g);
                for (int i = 0; i < puntosX.size(); i++) {
                    if (i % 6 == 0) {
                        g.drawImage(IMGPUNTO, puntosX.get(i) - IMGPUNTO.getWidth(null) / 2, puntosY.get(i) - IMGPUNTO.getHeight(null) / 2, null);
                    }
                }
            }

        } catch (Exception ex) {
            System.err.println(ex);
        }

    }

    private void dibujarCoordenadas(Graphics g) {
        g.drawLine(PL1[0], PL1[1], PL1[2], PL1[3]);
        g.drawLine(PL2[0], PL2[1], PL2[2], PL2[3]);

        g.fillPolygon(XFLECHA1, YFLECHA1, LINEAS);
        g.drawString("Y", 25, 20);
        g.fillPolygon(XFLECHA2, YFLECHA2, LINEAS);
        g.drawString("X", 528, 262);
    }

    public void dibujarPosicion(int x, int y) {
        if (x != 0) {

        }
    }

    public Proyectil getProyectil() {
        return proyectil;
    }

    public boolean isMovCompleto() {
        return movCompleto;
    }

    public void setMovCompleto(boolean movCompleto) {
        this.movCompleto = movCompleto;
    }

    public ArrayList<Integer> getPuntosX() {
        return puntosX;
    }

    public ArrayList<Integer> getPuntosY() {
        return puntosY;
    }

}
