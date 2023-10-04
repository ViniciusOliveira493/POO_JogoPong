package view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import model.Bola;

public class Panel extends JPanel{
	private static final long serialVersionUID = 1L;
	
	private int screenWidth;
	private int screenHeight;
	private Bola bola; 
	
	public Panel(int width,int height,Bola bola) {
		screenWidth = width;
		screenHeight = height;
		this.bola = bola;
		
		setSize(screenWidth,screenHeight);
		setLocation(0,0);
		setVisible(true);
		setOpaque(true);
	}
	
	public void paint(Graphics g) {
		//desenhar circulo
		g.setColor(Color.black);
		g.fillOval(getWidth()/2-55,getHeight()/2-75,100,100);
		
		//desenhar circulo
		g.setColor(Color.lightGray);
		g.fillOval(getWidth()/2-45,getHeight()/2-65,80,80);
		
		//desenhar rede
		g.setColor(Color.WHITE);
		g.fillRect(getWidth()/2-10,0,10,getHeight());
		
		//desenhar a bola
		g.setColor(Color.RED);
		g.fillOval(bola.getPosX(),bola.getPosY(),bola.getRadius(),bola.getRadius());
	}
	
	public void atualizar(Bola bola) {
		this.bola = bola;
	}
}
