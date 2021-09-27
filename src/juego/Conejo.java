package juego;

import java.awt.Image;
import entorno.Entorno;
import entorno.Herramientas;


public class Conejo {

    double x;
    double y;
    double angulo;
    Image img1;
    double tamanioConejo = 0.3;

    public Conejo(int x, int y) {
        this.x = x;
        this.y = y;

        cambiarImagenConejo("imagenes/Bunny-Sprite-Derecha.gif");

    }

    public void dibujarse(Entorno entorno) {
        // entorno.dibujarTriangulo(this.x, this.y, 50, 30, this.angulo, Color.yellow);
     
            entorno.dibujarImagen(this.img1, this.x, this.y, this.angulo, tamanioConejo);

    }


    public void cambiarImagenConejo(String image) {
        this.img1 = Herramientas.cargarImagen(image);
    }

    public void tamanioConejo(double tamanio) {
        tamanioConejo = tamanio;
    }

    public void moverArriba(double velocidad) {
        if (y > 20) {
            this.y -= velocidad;
        }
    }

    public void moverDerecha(double velocidad) {
        if (x < 770) {
            this.x += velocidad;
        }
    }

    public void moverIzquierda(double velocidad) {
        if (x > 28) {
            this.x -= velocidad;
        }
    }

    public boolean moverAbajo(double velocidad) {
        this.y += velocidad;
        return !(y < 590);
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
