package view;

import controller.ThreadBola;
import controller.ThreadComp;
import model.Barra;
import model.Bola;
import model.Valores;

public class Principal {
	static Valores valores = new Valores();
	public static void main(String[] args) {
		
		valores.setPlayer(new Barra(70));	
		valores.setComp(new Barra(5));
		valores.setBola(new Bola());
		valores.setTela(new Tela(valores));
		
		
		ThreadBola tbola = new ThreadBola(valores);
		tbola.start();
		
		ThreadComp computer = new ThreadComp(valores);
		computer.start();
		
		
	}
}
