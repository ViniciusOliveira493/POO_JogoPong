package view;

import controller.ThreadBola;
import controller.ThreadComp;
import model.Barra;
import model.Valores;

public class Principal {
	static Valores valores = new Valores();
	public static void main(String[] args) {
		
		valores.player = new Barra(50);	
		valores.comp = new Barra(5);
		valores.tela = new Tela(valores);
		
		
		ThreadBola tbola = new ThreadBola(valores);
		tbola.start();
		
		ThreadComp compute = new ThreadComp(valores);
		compute.start();
		
		
	}
}
