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
public class IUtility extends Eventos implements Utility{

    @Override
    public String disminuirDecimales(double num) {
        return String.format("%.2f", num);
    }

    @Override
    public double aDouble(String text) {
        return Double.parseDouble(text);
    }

    @Override
    public String aString(int num) {
        return String.valueOf(num);
    }

    @Override
    public int aInteger(double num) {
        return Integer.valueOf(disminuirDecimales(num));
    }

    @Override
    public String aString(double num) {
        return String.valueOf(num);
    }

    @Override
    public int aInteger(String txt) {
        return Integer.parseInt(txt);
    }
    
}
