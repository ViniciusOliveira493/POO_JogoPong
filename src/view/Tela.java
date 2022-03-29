package view;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Barra;
import model.Bola;
import model.Valores;

public class Tela extends JFrame{
	JLabel lblBarraPlayer;
	JLabel lblBarraComp;
	JLabel lblPontosPlayer;
	JLabel lblPontosComp;
	JLabel lblPause;
	Panel panel;
	boolean pause = false;
	
	Valores valores;	
	int x,y;
	
	public Tela(Valores valores) {		
		this.setSize(900,500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setTitle("Pong");
		this.setLocationRelativeTo(null);
		this.setBackground(Color.lightGray);
		this.setResizable(false);
		
		this.valores = valores;
		valores.bola = new Bola();
		
		lblPause = new JLabel();
		lblPause.setText("Pause \n(Pressione P para voltar ao jogo)");
		lblPause.setBounds(getWidth()/2,getHeight()/3,300,300);
		
		lblPontosPlayer = new JLabel();
		panel = new Panel(this.getWidth(),this.getHeight(),this.valores.bola);
		this.add(panel);
		
		criarBarraPlayer(valores.player);
		criarBarraComp(valores.comp);			
		
		criarLblPontos();
		iniciarPlayer();
		ativarKeyListener();
		setVisible(true);	
		pause();
	}
	
	public void criarBarraPlayer(Barra barraPlayer) {
		lblBarraPlayer = new JLabel();
		lblBarraPlayer.setBounds(barraPlayer.getPosX(),barraPlayer.getPosY(),barraPlayer.getWidth(), barraPlayer.getHeight());
		lblBarraPlayer.setOpaque(true);
		lblBarraPlayer.setVisible(true);
		this.add(lblBarraPlayer);
	}
	
	public void criarBarraComp(Barra barraComp) {
		lblBarraComp = new JLabel();
		lblBarraComp.setBounds(barraComp.getPosX(),barraComp.getPosY(),barraComp.getWidth(), barraComp.getHeight());
		lblBarraComp.setOpaque(true);
		lblBarraComp.setVisible(true);	
		this.add(lblBarraComp);
	}
	
	public void atualizar() {		
		lblBarraPlayer.setBackground(valores.player.getColor());
		lblBarraComp.setBackground(valores.comp.getColor());
		lblPontosPlayer.setText(this.valores.pontosPlayer+"");
		lblPontosComp.setText(this.valores.pontosComputador+"");
		lblBarraPlayer.setBounds(valores.player.getPosX(),valores.player.getPosY(),valores.player.getWidth(), valores.player.getHeight());
		lblBarraComp.setBounds(valores.comp.getPosX(),valores.comp.getPosY(),valores.comp.getWidth(), valores.comp.getHeight());	
		this.panel.atualizar(this.valores.bola);
		this.repaint();
	}
	
	public void pontuaPlayer() {
		this.valores.pontosPlayer++;
		resetPlayer();
	}
	
	public void pontuaComputador() {
		this.valores.pontosComputador++;
		resetPlayer();
	}
	
	
	private void iniciarPlayer() {
		this.valores.player.setPosX(50);
		this.valores.player.setPosY(this.getHeight()/2-this.valores.player.getHeight());
		this.valores.player.setColor(Color.blue);
	}
	
	private void criarLblPontos() {
		int umQuarto = this.getWidth()/4;
		lblPontosPlayer = new JLabel();
		lblPontosPlayer.setFont(new Font("Arial",Font.BOLD,40));
		lblPontosPlayer.setBounds(umQuarto, 0, 100, 100);
		lblPontosPlayer.setText(this.valores.pontosPlayer+"");
		this.add(lblPontosPlayer);
		
		lblPontosComp = new JLabel();
		lblPontosComp.setFont(new Font("Arial",Font.BOLD,40));
		lblPontosComp.setBounds(umQuarto*3, 0, 100, 100);
		lblPontosComp.setText(this.valores.pontosComputador+"");
		this.add(lblPontosComp);
	}
	
	private void ativarKeyListener() {
		this.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				int code = e.getKeyCode();
				if(code == 38 || code == 87) {
					valores.player.down();								
				}else if(code == 80) {
					pause();
				}else{
					valores.player.up();		
				}
				
			}
		});
	}
	
	private void pause() {
		if(!pause) {
			x = valores.bola.getSpdX();
			y = valores.bola.getSpdY();					
			valores.bola.setSpdY(0);
			valores.bola.setSpdX(0);
			pause = true;
			lblPause.setVisible(true);
			this.add(lblPause);
		}else {
			valores.bola.setSpdY(y);
			valores.bola.setSpdX(x);
			pause = false;
			lblPause.setVisible(false);
		}
	}
	
	private void resetPlayer() {
		valores.player.setPosY(this.getHeight()/2-this.valores.player.getHeight());
	}
}
