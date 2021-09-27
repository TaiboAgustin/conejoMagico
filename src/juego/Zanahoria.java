package juego;

import java.awt.Image;
import entorno.Entorno;
import entorno.Herramientas;

public class Zanahoria {

    double x;
    double y;
    Image img1;
    boolean aparece;

    public Zanahoria(String img) {
        this.x = Math.floor(Math.random() * (700 - 100 + 1) + 100);
        this.y = 0;
        this.img1 = Herramientas.cargarImagen(img);
        aparece = true;

    }

    public void dibujarse(Entorno entorno) {
        if (aparece) {
            entorno.dibujarImagen(this.img1, this.x, this.y, 0, 0.07);
        }
    }

    public void comer() {
        aparece = false;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void moverAbajo(double velocidadAbajo) {
        this.y += velocidadAbajo;

    }

    public void arrancarArriba() {
        y = -200;
        this.x = Math.floor(Math.random() * (700 - 100 + 1) + 100);
        aparece = true;
    }
}
