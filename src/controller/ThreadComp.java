package controller;

import java.awt.Color;
import model.Valores;

public class ThreadComp extends Thread{
	Valores valores;

	private int tempoReacao = 6;
	private double espacoReacao = 2.5;
	
	public ThreadComp(Valores valores) {
		this.valores = valores;		
		this.valores.getComp().setPosX(this.valores.getTela().getWidth()-100);
		this.valores.getComp().setPosY(20);
		this.valores.getComp().setColor(Color.RED);		
	}
	
	private void iniciar() {
		while(true) {
			if(valores.getBola().getPosX()>(valores.getTela().getWidth()/espacoReacao)) {
				int espaco = valores.getComp().getPosX()-valores.getBola().getPosX();
				if(!(espaco<10)) {
					if(valores.getBola().getPosY()>valores.getComp().getPosY()) {
						this.valores.getComp().up();
					}else {
						this.valores.getComp().down();
					}
				}
				
			}
			this.valores.getTela().atualizar();
			try {
				sleep(tempoReacao);
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
