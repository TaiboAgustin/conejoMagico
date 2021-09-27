package juego;

import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class menuDeJuego {

	double x;
	double y;
	double angulo;
	Image img1;

	public menuDeJuego () {
		this.x = 400;
		this.y = 300;	
		img1 = Herramientas.cargarImagen("imagenes/menuDeJuego.png");

	}
	
	public void dibujarse (Entorno entorno) { 
			entorno.dibujarImagen(img1, this.x, this.y, this.angulo, 0.8);

}
}
