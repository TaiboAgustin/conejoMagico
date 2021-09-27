package juego;

import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Fondo{
	
	double x;
	double y;
	double angulo;
	Image img1;

	public Fondo () {
		this.x = 400;
		this.y = 300;	
		img1 = Herramientas.cargarImagen("imagenes/fondo-cesped.jpg");

	}
	
	public void dibujarse (Entorno entorno) { 
			entorno.dibujarImagen(img1, this.x, this.y, this.angulo, 1.6);
			}
}