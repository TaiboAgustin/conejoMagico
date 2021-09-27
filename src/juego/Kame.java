package juego;

import java.awt.Image;
import entorno.Entorno;
import entorno.Herramientas;

public class Kame {
    double x;
    double y;
    Image img1;
    boolean aparece;

    public Kame(String img) {
        this.x = 0;
        this.y = 0;
        this.img1 = Herramientas.cargarImagen(img);
        aparece = false;
    }

    public void dibujarse(Entorno entorno) {
        if (aparece) {
            entorno.dibujarImagen(this.img1, this.x, this.y, 0, 0.5);
        }
    }

    public void explotar() {
        aparece = false;
    }

    public void disparar(double x, double y) {
        aparece = true;
        this.x = x;
        this.y = y - 30;
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

    public void moverArriba(double velocidadAbajo) {
        this.y -= velocidadAbajo;
        if (y < 0) {
            aparece = false;
        }

    }

}
