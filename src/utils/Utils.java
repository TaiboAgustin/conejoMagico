package utils;

import java.awt.Rectangle;
import juego.Conejo;
import juego.Obstaculo;

public class Utils {
    private Utils() {

    }

    public static boolean randomDerechaOIzquierda() {
        return Math.random() < 0.5;
    }

    public static double randomVelocidad(double velocidad) {
        return Math.floor(Math.random() * ((velocidad + 3) - velocidad) + velocidad);
    }

    public static boolean colisionKame(int xKame, int yKame, int xAuto, int yAuto) {
        Rectangle Kame = new Rectangle(xKame - 3, yKame - 3, 6, 6);
        Rectangle Auto = new Rectangle(xAuto - 60, yAuto - 20, 120, 40);
        return Kame.intersects(Auto);
    }

    public static boolean colisionAuto(int xConejo, int yConejo, int xAuto, int yAuto) {
        Rectangle Conejo = new Rectangle(xConejo - 20, yConejo - 20, 40, 40);
        Rectangle Auto = new Rectangle(xAuto - 60, yAuto - 15, 120, 30);
        return Conejo.intersects(Auto);
    }

    public static boolean colisionZanahoria(int xConejo, int yConejo, int xZanahoria, int yZanahoria) {
        Rectangle Conejo = new Rectangle(xConejo - 5, yConejo - 5, 10, 10);
        Rectangle Zanahoria = new Rectangle(xZanahoria - 5, yZanahoria - 5, 10, 10);
        return Conejo.intersects(Zanahoria);
    }

    public static boolean colisionObstaculo(Conejo conejo, Obstaculo obstaculo) {
        Rectangle Conejo = new Rectangle((int) conejo.getX() - 5, (int) conejo.getY() - 10, 10, 10);
        Rectangle Obstaculo = new Rectangle((int) obstaculo.getX() - 40, (int) obstaculo.getY() - 30, 130, 30);
        return Obstaculo.intersects(Conejo);
    }
}
