package model;

import view.Tela;

public class Bola {
	private int radius = 20;
	private int posX;
	private int posY;
	private int spdX = 2;
	private int spdY = 2;
	
	private int maxSpd = 8;
	private int minSpd = 2;

	public void mover() {
		posX += spdX;
		posY += spdY;
	}
	
	public void colidir(int screenWidth,int screenHeight, Barra comp,Barra player,Tela tela) {		
		if(posY>(screenHeight-radius-50) || posY<0) {
			if(!(spdY<0 && posY>(screenHeight-radius-50))) {
				spdY*=-1;
			}			
		}
		if (posX < comp.getPosX() + comp.getWidth() &&
			 posX + radius > comp.getPosX() &&
			 posY < comp.getPosY() + comp.getHeight() &&
			 posY + radius > comp.getPosY()) {
			
			spdX = (int) ((Math.random()*maxSpd)+1);
			spdX*=-1;			
		}
		
		if (posX < player.getPosX() + player.getWidth() &&
			 posX + radius > player.getPosX() &&
			 posY < player.getPosY() + player.getHeight() &&
			 posY + radius > player.getPosY()) {
			spdX = -(int) ((Math.random()*7)+minSpd);
			spdX*=-1;
		}
		
		if(posX>(screenWidth-radius-0)) {
			tela.pontuaPlayer();
			this.setPosX((screenWidth/2)-radius);
			this.setPosY((int)(Math.random()*screenHeight));
			spdX = 2;
		}
		
		if(posX<0) {
			tela.pontuaComputador();
			this.setPosX((screenWidth/2)-radius);
			this.setPosY((int)(Math.random()*(screenHeight-200)+50));
			spdX = -2;
		}
	}
	
	public int getRadius() {
		return radius;
	}
	public int getPosX() {
		return posX;
	}
	public void setPosX(int posX) {
		this.posX = posX;
	}
	public int getPosY() {
		return posY;
	}
	public void setPosY(int posY) {
		this.posY = posY;
	}
	public int getSpdX() {
		return spdX;
	}
	public void setSpdX(int spdX) {
		this.spdX = spdX;
	}
	public int getSpdY() {
		return spdY;
	}
	public void setSpdY(int spdY) {
		this.spdY = spdY;
	}		
}
