/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecuaciones;

/**
 *
 * @author LAB-USR-AQ265-A0108
 */
public abstract class Ecuaciones {

    /**
     * Constante de la gravedad en la tierra m/s^2.
     */
    private static final double GRAVEDAD = 9.80;

    /**
     *
     * @param velocidadInicial
     * @param angulo
     * @return altura = (v0^2*sen^2(θ))/2g
     *
     */
    public static double calcularAlturaMaxima(double velocidadInicial, int angulo) {
        return ((Math.pow(velocidadInicial, 2) * Math.pow(Math.sin(Math.toRadians(angulo)), 2)) / (2 * GRAVEDAD));
    }

    /**
     *
     * @param velocidadInicial
     * @param angulo
     * @return distancia = (v0^2*sen(2θ))/g
     */
    public static double calcularDistanciaRecorrida(double velocidadInicial, int angulo) {
        return ((Math.pow(velocidadInicial, 2) * Math.sin(Math.toRadians(angulo * 2))) / GRAVEDAD);
    }

    /**
     *
     * @param velocidadInicial
     * @param angulo
     * @return tiempo = ((v0*2)*senθ)/g
     */
    public static double calcularTiempoEnAire(double velocidadInicial, int angulo) {
        return (((velocidadInicial * 2) * Math.sin(Math.toRadians(angulo))) / GRAVEDAD);
    }

    /**
     * Para hallar la velocidad en X es necesario descomponer la velocidad
     * inicial. Esto se logra multiplicando la velocidad por el coseno del
     * angulo.
     *
     * @param velocidadInicial
     * @param angulo
     * @return v0x = velocidad*cosθ
     */
    public static double calcularVelocidadX(double velocidadInicial, int angulo) {
        return (velocidadInicial * Math.cos(Math.toRadians(angulo)));
    }

    /**
     * Para hallar la velocidad en Y es necesario descomponer la velocidad
     * inicial. Esto se logra multiplicando la velocidad por el seno del angulo.
     *
     * @param velocidadInicial
     * @param angulo
     * @return v0y = velocidad*senθ
     */
    public static double calcularVelocidadY(double velocidadInicial, int angulo) {
        return (velocidadInicial * Math.sin(Math.toRadians(angulo)));
    }

    /**
     *
     * @param v0x
     * @param tiempo
     * @return x = v0x * tiempo
     */
    public static double calcularPosicionX(double v0x, double tiempo) {
        return (v0x * tiempo);
    }

    /**
     *
     * @param v0y
     * @param tiempo
     * @return y = v0y.t - 1/2.GRAVEDAD.t^2
     */
    public static double calcularPosicionY(double v0y, double tiempo) {
        return ((v0y * tiempo) - 0.5 * GRAVEDAD * tiempo * tiempo);
    }

    /**
     *
     * @param v0x
     * @param distancia
     * @return tiempo = distancia/v0x
     */
    public static double calcularTiempo(double v0x, double distancia) {
        return (distancia / v0x);
    }

    /**
     * Calcula la velocidad en un tiempo determinado.
     *
     * @param v0y
     * @param tiempo
     * @return vy(t) = v0y - GRAVEDAD*tiempo
     */
    public static double calcularVelocidadTiempoY(double v0y, double tiempo) {
        return (v0y - GRAVEDAD * tiempo);
    }

    /**
     * Calcular el tiempo en la altura máxima
     * @param v0y
     * @return tiempo = v0y/GRAVEDAD
     */
    public static double calcularTiempoEnAlturaMaxima(double v0y) {
        return (v0y / GRAVEDAD);
    }

    public static double calcularVelocidadEnTiempo(double v0x, double v0y, double tiempo) {
        return Math.sqrt(Math.pow(v0x, 2) + Math.pow(calcularVelocidadTiempoY(v0y, tiempo), 2));
    }

}
