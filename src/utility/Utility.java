/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

/**
 *
 * @author Caleb
 */
public interface Utility {
    
    public static final String KM = "km";
    public static final String M = "m";
    public static final String CM = "cm";
    public static final String SEG = "s";
    public static final String HORA = "h";
    public static final String VKM = "km/h";
    public static final String VM = "m/s";
    public static final String ANGULO = "°";
    public static final String NUMREGEX = "^(\\d*\\.?\\d*)$";
    
    public String disminuirDecimales(double num);

    public double aDouble(String text);
    
    public int aInteger(double num);
    
    public int aInteger(String txt);

    public String aString(int num);
    
    public String aString(double num);
    
}
