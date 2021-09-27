package juego;

import java.awt.Image;
import entorno.Entorno;
import entorno.Herramientas;

public class Auto {

    double x;
    double y;
    Image imgDireccionDerecha;
    Image imgDireccionIzquierda;
    Image imgExplosion;
    double velocidad;
    double velocidadBase;
    boolean aparece;
    boolean explota;
    long contador;

    // true derecha, false izquierda
    boolean direccion;

    public Auto(double y, String imgIzquierda, String imgDerecha, String imgExplosion) {
        this.x = Math.floor(Math.random() * (700 - 100 + 1) + 100);
        this.y = y;
        imgDireccionDerecha = Herramientas.cargarImagen(imgDerecha);
        imgDireccionIzquierda = Herramientas.cargarImagen(imgIzquierda);
        direccion = utils.Utils.randomDerechaOIzquierda();
        velocidadBase = 1;
        velocidad = utils.Utils.randomVelocidad(velocidadBase);
        aparece = true;
        explota = false;
        contador = 0;

    }

    public void cambiarDireccionRandom() {
        direccion = utils.Utils.randomDerechaOIzquierda();
    }

    public void explotar() {
        aparece = false;
        explota = true;
        contador = 0;
    }

    public void dibujarse(Entorno entorno) {
        if (aparece) {
            if (direccion) {
                entorno.dibujarImagen(imgDireccionDerecha, x, y, 0, 0.09);

            } else {
                entorno.dibujarImagen(imgDireccionIzquierda, x, y, 0, 0.09);
            }
        } else if (explota) {
            if (contador < 80) {
                contador += 1;
                if (contador == 1)
                    imgExplosion = Herramientas.cargarImagen("imagenes/explosion.gif");
                entorno.dibujarImagen(imgExplosion, x, y, 0, 0.4);
            } else {
                contador = 0;
                explota = false;
            }
        }
    }

    public void moverIzquierda() {
        if (x < -100) {
            x = 900;
        }
        this.x -= velocidad;
    }

    public void arrancarArriba(double d) {
        y = d;
        aparece = true;
        explota = false;
        velocidadBase = velocidadBase + 1;
        velocidad = utils.Utils.randomVelocidad(velocidadBase);
    }

    public void moverDerecha() {
        if (x > 900) {
            x = -100;
        }
        this.x += velocidad;
    }

    public void mover(double VelocidadAbajo) {
        if (this.direccion) {
            moverDerecha();
        } else {
            moverIzquierda();
        }
        this.y += VelocidadAbajo;
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
