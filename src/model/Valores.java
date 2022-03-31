package model;

import view.Tela;

public class Valores {
	private Bola bola;
	private Barra player; 
	private Barra comp;
	private Tela tela;
	private int pontosPlayer;
	private int pontosComputador;
	
	public void pontuarPlayer() {
		this.pontosPlayer++;
	}
	
	public void pontuarComputador() {
		this.pontosComputador++;
	}
	
	public Bola getBola() {
		return bola;
	}
	public void setBola(Bola bola) {
		this.bola = bola;
	}
	public Barra getPlayer() {
		return player;
	}
	public void setPlayer(Barra player) {
		this.player = player;
	}
	public Barra getComp() {
		return comp;
	}
	public void setComp(Barra comp) {
		this.comp = comp;
	}
	public Tela getTela() {
		return tela;
	}
	public void setTela(Tela tela) {
		this.tela = tela;
	}
	public int getPontosPlayer() {
		return pontosPlayer;
	}
	public void setPontosPlayer(int pontosPlayer) {
		this.pontosPlayer = pontosPlayer;
	}
	public int getPontosComputador() {
		return pontosComputador;
	}
	public void setPontosComputador(int pontosComputador) {
		this.pontosComputador = pontosComputador;
	}
	
}
