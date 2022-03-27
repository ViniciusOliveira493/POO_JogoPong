package model;

import java.awt.Color;

public class Barra {
	private int posX;
	private int posY;
	private int width = 20;
	private int height = 80;
	private int spd;
	private Color color;
	
	public Barra(int speed) {
		this.spd = speed;
	}
	
	public void up() {
		posY += spd;
	}
	
	public void down() {
		posY -= spd;
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
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color c) {
		this.color = c;
	}
}
