package controller;

import model.Valores;

public class ThreadBola extends Thread{
	Valores valores;
	
	public ThreadBola(Valores valores) {
		this.valores = valores;		
		int px = (valores.tela.getWidth()/2)-valores.bola.getRadius()+4;
		int py = (valores.tela.getHeight()/2)-valores.bola.getRadius()-15;
		valores.bola.setPosX(px);
		valores.bola.setPosY(py);
	}
	
	private void iniciar() {
		while (true) {
			valores.bola.mover();
			valores.bola.colidir(valores.comp,valores.player,valores.tela);
			valores.tela.atualizar();
			try {
				sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}		
	}
	
	@Override
	public void run() {
		iniciar();
	}
	
}
