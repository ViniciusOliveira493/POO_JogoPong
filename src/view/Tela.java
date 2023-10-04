package view;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

import model.Barra;
import model.Valores;

public class Tela extends JFrame{
	private static final long serialVersionUID = 1L;
	
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
		setVisible(true);
		
		this.valores = valores;		
		
		panel = new Panel(this.getWidth(),this.getHeight(),this.valores.getBola());
		this.add(panel);
		
		criarBarraPlayer(valores.getPlayer());
		criarBarraComp(valores.getComp());			
		
		criarLblPause();
		criarLblPontos();
		iniciarPlayer();
		ativarKeyListener();	
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
		lblBarraPlayer.setBackground(valores.getPlayer().getColor());
		lblBarraComp.setBackground(valores.getComp().getColor());
		lblPontosPlayer.setText(this.valores.getPontosPlayer()+"");
		lblPontosComp.setText(this.valores.getPontosComputador()+"");
		lblBarraPlayer.setBounds(valores.getPlayer().getPosX(),valores.getPlayer().getPosY(),valores.getPlayer().getWidth(), valores.getPlayer().getHeight());
		lblBarraComp.setBounds(valores.getComp().getPosX(),valores.getComp().getPosY(),valores.getComp().getWidth(), valores.getComp().getHeight());	
		this.panel.atualizar(this.valores.getBola());
		this.repaint();
	}
	
	public void pontuaPlayer() {
		this.valores.pontuarPlayer();
		resetPlayer();
	}
	
	public void pontuaComputador() {
		this.valores.pontuarComputador();
		resetPlayer();
	}
	
	
	private void iniciarPlayer() {
		this.valores.getPlayer().setPosX(50);
		this.valores.getPlayer().setPosY(this.getHeight()/2-this.valores.getPlayer().getHeight());
		this.valores.getPlayer().setColor(Color.blue);
	}
	
	private void criarLblPontos() {
		int umQuarto = this.getWidth()/4;
		lblPontosPlayer = new JLabel();
		lblPontosPlayer.setFont(new Font("Arial",Font.BOLD,40));
		lblPontosPlayer.setBounds(umQuarto, 0, 100, 100);
		lblPontosPlayer.setText(this.valores.getPontosPlayer()+"");
		this.add(lblPontosPlayer);
		
		lblPontosComp = new JLabel();
		lblPontosComp.setFont(new Font("Arial",Font.BOLD,40));
		lblPontosComp.setBounds(umQuarto*3, 0, 100, 100);
		lblPontosComp.setText(this.valores.getPontosComputador()+"");
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
					valores.getPlayer().up();								
				}else if(code == 80) {
					pause();
				}else{
					valores.getPlayer().down();		
				}
				
			}
		});
	}
	
	private void pause() {
		if(!pause) {
			x = valores.getBola().getSpdX();
			y = valores.getBola().getSpdY();					
			valores.getBola().setSpdY(0);
			valores.getBola().setSpdX(0);
			pause = true;
			lblPause.setVisible(true);
			this.add(lblPause);
		}else {
			valores.getBola().setSpdY(y);
			valores.getBola().setSpdX(x);
			pause = false;
			lblPause.setVisible(false);
		}
	}
	
	private void resetPlayer() {
		valores.getPlayer().setPosY(this.getHeight()/2-this.valores.getPlayer().getHeight());
	}
	
	private void criarLblPause() {
		lblPause = new JLabel();
		lblPause.setText("Pause \n(Pressione P para voltar ao jogo)");
		lblPause.setBounds(getWidth()/2,getHeight()/3,300,300);		
	}
}
