/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Caleb
 */
public class Proyectil {

    private Image imagen;
    private static final String IMGPROYECTIL = "/imagenes/proyectil.png";
    private static final String IMGEXPLOSION = "/imagenes/explosion.png";
    private int posX;
    private int posY;
    private static final int LIMITEX = 550;
    private static final int LIMITEINFY = 270;
    private boolean moving;

    public Proyectil() {
        imagen = new ImageIcon(getClass().getResource(IMGPROYECTIL)).getImage();
    }

    public void setPosicionInicial(int posX, int posY) {
        this.posX = posX - (imagen.getWidth(null) / 2);
        this.posY = posY - (imagen.getHeight(null) / 2);
        imagen = new ImageIcon(getClass().getResource(IMGPROYECTIL)).getImage();
    }

    public synchronized void mover(int posX, int posY) {
        setPosX(posX);
        setPosY(posY);
        if (getPosY() > LIMITEINFY) {
            moving = false;
            imagen = new ImageIcon(getClass().getResource(IMGEXPLOSION)).getImage();
        } else if (getPosX() > LIMITEX) {
            moving = false;
            imagen = new ImageIcon(getClass().getResource(IMGEXPLOSION)).getImage();
        }
    }

    public void dibujar(Graphics g) {
        g.drawImage(imagen, posX, posY, null);
    }

    public int getPosX() {
        return posX + (imagen.getWidth(null) / 2);
    }

    public int getPosY() {
        return posY + (imagen.getHeight(null) / 2);
    }

    public void setPosX(int posX) {
        this.posX = (20 - (imagen.getWidth(null) / 2)) + posX;
    }

    public void setPosY(int posY) {
        this.posY = (270 - (imagen.getHeight(null) / 2)) - posY;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    
    
}
