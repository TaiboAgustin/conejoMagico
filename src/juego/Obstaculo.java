package juego;

import java.awt.Image;
import entorno.Entorno;
import entorno.Herramientas;

public class Obstaculo {

    double x;
    double y;
    Image img1;

    public Obstaculo(String img) {
        this.x = Math.floor(Math.random() * (700 - 100 + 1) + 100);
        this.y = Math.floor(Math.random() * (400 - 1 + 1) + 1);
        this.img1 = Herramientas.cargarImagen(img);

    }

    public void dibujarse(Entorno entorno) {

        entorno.dibujarImagen(this.img1, this.x, this.y, 0, 0.15);

    }

    public void moverAbajo(double velocidadAbajo) {
        this.y += velocidadAbajo;
        if (y >= 700) {
            y -= 700;
            this.x = Math.floor(Math.random() * (700 - 100 + 1) + 100);
        }
    }

    public void arrancarArriba() {
        y = -200;
        this.x = Math.floor(Math.random() * (700 - 100 + 1) + 100);
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
}
