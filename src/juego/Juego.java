package juego;

import java.awt.Color;
import java.awt.Rectangle;
import entorno.Entorno;
import entorno.Herramientas;
import entorno.InterfaceJuego;
import utils.Utils;


public class Juego extends InterfaceJuego {
    // El objeto Entorno que controla el tiempo y otros
    private Entorno entorno;
    // Variables y métodos propios de cada grupo
    Fondo fondo;
    Calle calle;
    Conejo conejo;
    Kame kame;
    menuDeJuego menu;
    Obstaculo obstaculo;
    Obstaculo obstaculo1;
    Obstaculo obstaculo2;
    Rectangle rec;

    double velocidad;
    boolean enJuego;
    boolean conejoDerecha = true;


    int contadorCalles = 0;
    int contadorSaltos = 0;
    int contadorPuntaje = 0;
    int contadorKame = 1;
    int inicioDeJuego = 0;


    Juego() {
        // Inicializa el objeto entorno
        entorno = new Entorno(this, "Conejo magico - Grupo 2 Dominguez - Taibo - Stegman - Alphas", 800, 600);
        // velocidad inicial del juego
        velocidad = 1;
        rec = new Rectangle();
        fondo = new Fondo();
        calle = new Calle(0);
        conejo = new Conejo(400, 400);
        kame = new Kame("imagenes/energyBall.gif");
        enJuego = true;
        menu = new menuDeJuego();
        obstaculo = new Obstaculo("imagenes/slime.png");
        obstaculo1 = new Obstaculo("imagenes/slime.png");
        obstaculo2 = new Obstaculo("imagenes/slime.png");
        // Inicializar lo que haga falta para el juego
        // ...

        // Inicia el juego!
        entorno.iniciar();
        Herramientas.loop("sonidos/musicaDeFondo.wav");
    }

    /**
     * Durante el juego, el método tick() será ejecutado en cada instante y por lo tanto es el método
     * más importante de esta clase. Aquí se debe actualizar el estado interno del juego para simular
     * el paso del tiempo (ver el enunciado del TP para mayor detalle).
     */
    public void tick() {

        if (inicioDeJuego == 0) {
            menu.dibujarse(entorno);
            if (entorno.sePresiono(entorno.TECLA_ENTER)) {
                inicioDeJuego++;
                Herramientas.play("sonidos/startsound.wav");

            }

        } else {

            // Procesamiento de un instante de tiempo
            if (calle.moverAbajo(velocidad)) {
                // sube un 20% la velocidad
                velocidad += 0.2;
                if (enJuego) {
                    contadorCalles += 1;
                    contadorPuntaje += 100;
                }
            }
            fondo.dibujarse(entorno);
            kame.dibujarse(entorno);
            calle.dibujarse(entorno);
            conejo.dibujarse(entorno);
            obstaculo.moverAbajo(velocidad);
            obstaculo1.moverAbajo(velocidad);
            obstaculo2.moverAbajo(velocidad);
            obstaculo.dibujarse(entorno);
            obstaculo1.dibujarse(entorno);
            obstaculo2.dibujarse(entorno);


            if (calle.checkeoColisionZanahoria(conejo)) {
                calle.zanahoria.comer();
                contadorKame += 1;
                contadorPuntaje += 50;
            }
            if (contadorCalles >= 10) {
                entorno.cambiarFont("Papyrus", 60, Color.white);
                entorno.escribirTexto("Ganaste!!!!", 150, 200);
                entorno.escribirTexto("Puntaje :" + contadorPuntaje, 150, 300);
                conejo.moverAbajo(velocidad);
                enJuego = false;
            } else {
                if ((calle.checkeoColisionAuto(conejo) || conejo.moverAbajo(velocidad))) {

                    entorno.cambiarFont("Papyrus", 50, Color.white);
                    entorno.escribirTexto("Game over!!!!", 260, 300);
                    entorno.escribirTexto("Tu puntaje es:" + contadorPuntaje, 240, 350);

                    enJuego = false;
                    conejo.tamanioConejo(0.13);
                    if (conejoDerecha) {
                        conejo.cambiarImagenConejo("imagenes/conejoMuertoD.png");
                    } else {
                        conejo.cambiarImagenConejo("imagenes/conejoMuertoI.png");
                    }
                    // Herramientas.loop("sonidos/gameover.wav");

                } else {

                    if (entorno.sePresiono(entorno.TECLA_ESPACIO) && contadorKame > 0 && !kame.aparece) {
                        Herramientas.play("sonidos/bustershot.wav");
                        kame.disparar(conejo.getX(), conejo.getY());
                        contadorKame -= 1;
                    }
                    if (kame.aparece) {
                        kame.moverArriba(2);
                        kame.dibujarse(entorno);
                        if (calle.checkeoColisionKame(kame)) {

                            kame.explotar();
                        }
                    }

                    if (entorno.sePresiono(entorno.TECLA_DERECHA) && enJuego) {
                        Herramientas.play("sonidos/saltito.wav");
                        conejo.cambiarImagenConejo("imagenes/Bunny-Sprite-Derecha.gif");
                        conejo.moverDerecha(30);
                        conejoDerecha = true;
                    }
                    if (entorno.sePresiono(entorno.TECLA_IZQUIERDA) && enJuego) {
                        Herramientas.play("sonidos/saltito.wav");
                        conejo.cambiarImagenConejo("imagenes/Bunny-Sprite-Izquierda.gif");
                        conejo.moverIzquierda(30);
                        conejoDerecha = false;
                    }
                    if (entorno.sePresiono(entorno.TECLA_ARRIBA) && enJuego
                            && !(Utils.colisionObstaculo(conejo, obstaculo)
                                    || Utils.colisionObstaculo(conejo, obstaculo1)
                                    || Utils.colisionObstaculo(conejo, obstaculo2))) {
                        Herramientas.play("sonidos/saltito.wav");
                        conejo.moverArriba(30);
                        contadorSaltos += 1;
                    }
                }
            }

            entorno.cambiarFont("Papyrus", 20, Color.white);
            entorno.escribirTexto("Calles Recorridas: " + contadorCalles, 550, 50);
            entorno.escribirTexto("Cantidad Saltos: " + contadorSaltos, 550, 110);
            entorno.escribirTexto("Cantidad KameHameHa: " + contadorKame, 550, 170);

        }
    }

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        Juego juego = new Juego();
    }
}
