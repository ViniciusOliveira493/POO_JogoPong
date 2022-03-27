package controller;

import java.awt.Color;

import model.Barra;
import model.Valores;
import view.Tela;

public class ThreadComp extends Thread{
	Valores valores;

	private int tempoReacao = 6;
	private double espacoReacao = 2.5;
	
	public ThreadComp(Valores valores) {
		this.valores = valores;		
		this.valores.comp.setPosX(this.valores.tela.getWidth()-100);
		this.valores.comp.setPosY(20);
		this.valores.comp.setColor(Color.RED);		
	}
	
	private void iniciar() {
		while(true) {
			if(valores.bola.getPosX()>(valores.tela.getWidth()/espacoReacao)) {
				int espaco = valores.comp.getPosX()-valores.bola.getPosX();
				if(!(espaco<10)) {
					if(valores.bola.getPosY()>valores.comp.getPosY()) {
						this.valores.comp.up();
					}else {
						this.valores.comp.down();
					}
				}
				
			}
			this.valores.tela.atualizar();
			try {
				this.sleep(tempoReacao);
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
