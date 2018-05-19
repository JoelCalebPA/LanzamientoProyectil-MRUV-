/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;

import ecuaciones.Ecuaciones;
import java.awt.Color;
import java.awt.HeadlessException;
import javax.swing.BorderFactory;
import swing.DatoModal;
import swing.PanelDatos;
import swing.PanelResultados;
import swing.PanelSimulacion;
import swing.ToolBar;
import swing.VentanaPrincipal;
import utility.IUtility;

/**
 *
 * @author Caleb
 */
public class MainController extends IUtility {

//    "https://www.vexels.com/vectores/vista-previa/146200/avin-volando-silueta"
    private PanelSimulacion pS;
    private PanelDatos pD;
    private PanelResultados pR;
    private DatoModal dM;
    private ToolBar tB;

    private int angulo;
    private double tiemporEnAire;
    private double velocidadInicial;
    private double alturaMaxima;
    private double distanciaRecorrida;
    private double tiempoEnAlturaMaxima;
    private double velocidadEnTiempo;
    private double tiempo;

    private final double intervalo = 0.05;
    double temp = 0;

    int x = 0;
    int y = 0;
    double xT;
    double yT;
    double vx;
    double vy;

    private boolean velocidadOK = false;
    private boolean tiempoOK = false;
    private boolean anguloOK = false;

    public MainController() {
        initComponents();
    }

    private void initComponents() {
        pS = PanelSimulacion.getInstance();
        pD = PanelDatos.getInstance();
        pR = PanelResultados.getInstance();
        dM = new DatoModal();
        tB = ToolBar.getInstance();
        pD.getSliderAngulo().addChangeListener(this);
        pD.getSliderAngulo().addMouseListener(this);
        pD.getBtnIniciarAnimacion().addActionListener(this);
        pD.getTxtVelocidad().addKeyListener(this);
        pD.getTxtTiempo().addKeyListener(this);
        pD.getTxtAngulo().setText(angulo + ANGULO);
        pR.setEventos(this);
    }

    public void iniciarPrograma() {
        VentanaPrincipal vp = VentanaPrincipal.getInstance();
        vp.setLocationRelativeTo(null);
        vp.setVisible(true);
    }

    private void calcularResultados() {
        try {
            velocidadInicial = aDouble(pD.getTxtVelocidad().getText());
            angulo = pD.getSliderAngulo().getValue();
            vx = Ecuaciones.calcularVelocidadX(velocidadInicial, angulo);
            vy = Ecuaciones.calcularVelocidadY(velocidadInicial, angulo);
            alturaMaxima = Ecuaciones.calcularAlturaMaxima(velocidadInicial, angulo);
            distanciaRecorrida = Ecuaciones.calcularDistanciaRecorrida(velocidadInicial, angulo);
            tiemporEnAire = Ecuaciones.calcularTiempoEnAire(velocidadInicial, angulo);
            tiempoEnAlturaMaxima = Ecuaciones.calcularTiempoEnAlturaMaxima(vy);
            pR.getTxtAlturaMaxima().setText(disminuirDecimales(alturaMaxima) + M);
            pR.getTxtDistanciaRecorrida().setText(disminuirDecimales(distanciaRecorrida) + M);
            pR.getTxtTiempoEnAire().setText(disminuirDecimales(tiemporEnAire) + SEG);
            pR.getTxtTiempoEnAlturaMaxima().setText(disminuirDecimales(tiempoEnAlturaMaxima) + SEG);
            if (tiempoOK) {
                tiempo = aDouble(pD.getTxtTiempo().getText());
                velocidadEnTiempo = Ecuaciones.calcularVelocidadEnTiempo(vx, vy, tiempo);
                xT = Ecuaciones.calcularPosicionX(vx, tiempo);
                yT = Ecuaciones.calcularPosicionY(vy, tiempo);
                pR.getTxtVelocidadEnTiempo().setText(disminuirDecimales(velocidadEnTiempo) + VM);
                pR.getTxtPosicionEnTiempo().setText("X: " + disminuirDecimales(xT) + M + "   Y: " + disminuirDecimales(yT) + M);
            }
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource().equals(pD.getBtnIniciarAnimacion())) {
                x = 0;
                y = 0;
                temp = 0;
                calcularResultados();
                pS.reiniciarPosicionProyectil();
                pS.getProyectil().setMoving(true);
                new Thread(this).start();
            }
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        try {
            if (!pS.getProyectil().isMoving()) {
                anguloOK = true;
                pD.getTxtAngulo().setText(aString(pD.getSliderAngulo().getValue()) + ANGULO);
                calcularResultados();
            }
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        try {
            if (e.getSource().equals(pD.getSliderAngulo())) {
                if (!velocidadOK) {
                    JOptionPane.showMessageDialog(pD, "Ingrese velocidad");
                }
            }
        } catch (HeadlessException ex) {
            System.err.println(ex);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        try {
            if (!(e.getKeyCode() == 10)) {
                if (e.getSource().equals(pD.getTxtVelocidad())) {
                    String txt = pD.getTxtVelocidad().getText();
                    if (txt.matches(NUMREGEX) && txt.length() > 0) {
                        velocidadOK = true;
                        pD.getTxtVelocidad().setBorder(BorderFactory.createLineBorder(Color.GRAY));
                        if (anguloOK) {
                            calcularResultados();
                        }
                    } else {
                        velocidadOK = false;
                        pD.getTxtVelocidad().setBorder(BorderFactory.createLineBorder(Color.red, 2));
                        JOptionPane.showMessageDialog(pD, "Ingrese un número");
                        pD.getTxtVelocidad().setText(null);
                    }
                } else if (e.getSource().equals(pD.getTxtTiempo())) {
                    String txt = pD.getTxtTiempo().getText();
                    if (txt.matches(NUMREGEX) && txt.length() > 0) {
                        tiempoOK = true;
                        pD.getTxtTiempo().setBorder(BorderFactory.createLineBorder(Color.GRAY));
                        if (anguloOK && velocidadOK) {
                            calcularResultados();
                        }
                    } else {
                        tiempoOK = false;
                        pD.getTxtTiempo().setBorder(BorderFactory.createLineBorder(Color.red, 2));
                        JOptionPane.showMessageDialog(pD, "Ingrese un número");
                        pD.getTxtTiempo().setText(null);
                    }
                }
            }
        } catch (HeadlessException ex) {
            System.err.println(ex);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        try {
            if (e.getSource().equals(pR.getLblDatoAlturaMaxima())) {
                dM.setDato(1, e.getXOnScreen(), e.getYOnScreen());
                dM.setVisible(true);
            } else if (e.getSource().equals(pR.getLblDatoDistanciaRecorrida())) {
                dM.setDato(2, e.getXOnScreen(), e.getYOnScreen());
                dM.setVisible(true);
            } else if (e.getSource().equals(pR.getLblDatoTiempoEnAire())) {
                dM.setDato(3, e.getXOnScreen(), e.getYOnScreen());
                dM.setVisible(true);
            } else if (e.getSource().equals(pR.getLblDatoTiempoEnAlturaMaxima())) {
                dM.setDato(4, e.getXOnScreen(), e.getYOnScreen());
                dM.setVisible(true);
            } else if (e.getSource().equals(pR.getLblDatoVelocidadEnTiempo())) {

            } else if (e.getSource().equals(pR.getLblDatoPosicionEnTiempo())) {

            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    @Override
    public void mouseExited(MouseEvent e) {
        try {
            dM.setVisible(false);
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }

    @Override
    public void run() {
        try {
            pD.getSliderAngulo().setEnabled(false);
            pD.getBtnIniciarAnimacion().setEnabled(false);
            pD.getTxtVelocidad().setEnabled(false);
            if (!tB.getChkConservarTrayectoria().isSelected()) {
                pS.getPuntosX().clear();
                pS.getPuntosY().clear();
            }
            while (pS.getProyectil().isMoving()) {
                temp += intervalo;
                x = (int) Ecuaciones.calcularPosicionX(vx, temp);
                y = (int) Ecuaciones.calcularPosicionY(vy, temp);
                pS.getPuntosX().add(x + 20);
                pS.getPuntosY().add(270 - y);
                pD.getLblPosActualX().setText("Posición actual en X:   " + (pS.getProyectil().getPosX() - 20) + "m");
                pD.getLblPosActualY().setText("Posición actual en Y:   " + (270 - pS.getProyectil().getPosY()) + "m");
                pD.getLblVelActualX().setText("Velocidad actual en X:   " + disminuirDecimales(vx) + "m/s");
                pD.getLblVelActualY().setText("Velocidad actual en Y:   " + disminuirDecimales(Ecuaciones.calcularVelocidadTiempoY(vy, temp)) + "m/s");
                Thread.sleep(20);
                pS.getProyectil().mover((int) x, (int) y);
                pS.repaint();
            }
            pD.getSliderAngulo().setEnabled(true);
            pD.getBtnIniciarAnimacion().setEnabled(true);
            pD.getTxtVelocidad().setEnabled(true);
        } catch (InterruptedException ex) {
            System.err.println(ex);
        }
    }

}
