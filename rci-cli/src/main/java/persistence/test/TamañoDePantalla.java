package persistence.test;

import java.awt.Dimension;
import java.awt.Toolkit;
/**
 * @web http://jc-mouse.blogspot.com/
 * @author Mouse
 */
public class TamañoDePantalla {

    public static void main(String[] args) {
        // TODO code application logic here
        //Obtiene el tamaño de la pantalla
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        //obtiene la resolucion de la pantalla en PPP (Puntos por pulgada)
        int sr = Toolkit.getDefaultToolkit().getScreenResolution();
        //muestra la informacion por la consola de java
        System.out.println("Tamaño de pantalla: " + d.width + "x" + d.height + ", definición: " + sr + " ppp");
    }
}

