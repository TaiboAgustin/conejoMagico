package juego;

import java.awt.Image;
import entorno.Entorno;
import entorno.Herramientas;

public class Calle {

    double x;
    double y;
    double angulo;
    Image img1;
    Auto auto1;
    Auto auto2;
    Auto auto3;
    Auto auto4;
    Zanahoria zanahoria;

    public Calle(int y) {
        this.x = 400;
        this.y = y;
        this.img1 = Herramientas.cargarImagen("imagenes/calle_cuadruple.png");
        auto1 = new Auto(y - 140, "imagenes/AUTOVERDE-I.png", "imagenes/AUTOVERDE-D.png", "imagenes/explosion.gif");
        auto2 = new Auto(y - 55, "imagenes/AUTOAMARILLO-I.png", "imagenes/AUTOAMARILLO-D.png",
                "imagenes/explosion.gif");
        auto3 = new Auto(y + 55, "imagenes/AUTOAZUL-I.png", "imagenes/AUTOAZUL-D.png", "imagenes/explosion.gif");
        auto4 = new Auto(y + 140, "imagenes/AUTOROJO-I.png", "imagenes/AUTOROJO-D.png", "imagenes/explosion.gif");
        zanahoria = new Zanahoria("imagenes/zanahoria.png");
    }

    public void dibujarse(Entorno entorno) {
        entorno.dibujarImagen(this.img1, this.x, this.y, this.angulo, 0.8);
        auto1.dibujarse(entorno);
        auto2.dibujarse(entorno);
        auto3.dibujarse(entorno);
        auto4.dibujarse(entorno);
        zanahoria.dibujarse(entorno);
    }


    public boolean checkeoColisionKame(Kame kame) {
        if (utils.Utils.colisionKame((int) kame.getX(), (int) kame.getY(), (int) auto1.getX(), (int) auto1.getY())
                && auto1.aparece) {

            auto1.explotar();
            return true;
        }
        if (utils.Utils.colisionKame((int) kame.getX(), (int) kame.getY(), (int) auto2.getX(), (int) auto2.getY())
                && auto2.aparece) {

            auto2.explotar();
            return true;
        }
        if (utils.Utils.colisionKame((int) kame.getX(), (int) kame.getY(), (int) auto3.getX(), (int) auto3.getY())
                && auto3.aparece) {

            auto3.explotar();
            return true;
        }
        if (utils.Utils.colisionKame((int) kame.getX(), (int) kame.getY(), (int) auto4.getX(), (int) auto4.getY())
                && auto4.aparece) {

            auto4.explotar();
            return true;
        }
        return false;
    }


    public boolean checkeoColisionAuto(Conejo conejo) {
        if (utils.Utils.colisionAuto((int) conejo.getX(), (int) conejo.getY(), (int) auto1.getX(), (int) auto1.getY())
                && auto1.aparece) {
            return true;
        }
        if (utils.Utils.colisionAuto((int) conejo.getX(), (int) conejo.getY(), (int) auto2.getX(), (int) auto2.getY())
                && auto2.aparece) {
            return true;
        }
        if (utils.Utils.colisionAuto((int) conejo.getX(), (int) conejo.getY(), (int) auto3.getX(), (int) auto3.getY())
                && auto3.aparece) {
            return true;
        }
        if (utils.Utils.colisionAuto((int) conejo.getX(), (int) conejo.getY(), (int) auto4.getX(), (int) auto4.getY())
                && auto4.aparece) {
            return true;
        }
        return false;
    }

    public boolean checkeoColisionZanahoria(Conejo conejo) {
        return (zanahoria.aparece && utils.Utils.colisionAuto((int) conejo.getX(), (int) conejo.getY(),
                (int) zanahoria.getX(), (int) zanahoria.getY()));
    }

    public boolean moverAbajo(double VelocidadAbajo) {
        y += VelocidadAbajo;
        auto1.mover(VelocidadAbajo);
        auto2.mover(VelocidadAbajo);
        auto3.mover(VelocidadAbajo);
        auto4.mover(VelocidadAbajo);
        zanahoria.moverAbajo(VelocidadAbajo);
        if (y > 800) {
            // se sube todo
            y = -200;
            auto1.arrancarArriba(y - 140);
            auto1.direccion = utils.Utils.randomDerechaOIzquierda();
            auto2.arrancarArriba(y - 55);
            auto2.direccion = utils.Utils.randomDerechaOIzquierda();
            auto3.arrancarArriba(y + 55);
            auto3.direccion = utils.Utils.randomDerechaOIzquierda();
            auto4.arrancarArriba(y + 140);
            auto4.direccion = utils.Utils.randomDerechaOIzquierda();
            zanahoria.arrancarArriba();
            return true;
        }
        return false;
    }
}
