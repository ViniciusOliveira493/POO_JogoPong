package controller;

import model.Valores;

public class ThreadBola extends Thread{
	Valores valores;
	
	public ThreadBola(Valores valores) {
		this.valores = valores;		
		int px = (valores.getTela().getWidth()/2)-valores.getBola().getRadius()+4;
		int py = (valores.getTela().getHeight()/2)-valores.getBola().getRadius()-15;
		valores.getBola().setPosX(px);
		valores.getBola().setPosY(py);
	}
	
	private void iniciar() {
		while (true) {
			valores.getBola().mover();
			valores.getBola().colidir(valores.getComp(),valores.getPlayer(),valores.getTela());
			valores.getTela().atualizar();
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
