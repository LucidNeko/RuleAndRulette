package GUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

import javax.swing.JPanel;

import GameLogic.Game;
import GameLogic.Input;
import GameLogic.Characters.Entity;

public class GUIPanel extends JPanel implements KeyListener{
	private static final long serialVersionUID = -2946375771339622409L;
	
	
	private Game game;
	
	private PixelImage canvas;

	public GUIPanel(PixelImage canvas){
		setBackground(Color.gray);
		this.addKeyListener(this);
		
		this.addKeyListener(Input.instance);
		this.canvas = canvas;
	}

	public void setGame(Game game) {
		this.game = game;
	}
	
	@Override
	public void paintComponent(Graphics gold) {
		super.paintComponent(gold);
		Graphics2D g = (Graphics2D)gold;
		
//		if( game == null ){
//			return;
//		}
//		
//		// I DRAW STUFF HERE
//		List<Entity> entities = game.getEntities();
//		if(entities == null ){
//			return;
//		}
//		
//		for(int i = 0; i < entities.size(); i++){
//			entities.get(i).render(canvas);
//		}
		
		g.drawImage(canvas.asBufferedImage(), null, 0, 0);
		
		
		drawUI(g);
	};

	private void drawUI(Graphics2D g) {
		// Draw which level we are on
		
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		if( e.getKeyCode() == KeyEvent.VK_D ){
			//System.out.println("Start moving right");
			game.startMovingCharacterRight();
		}
		else if( e.getKeyCode() == KeyEvent.VK_A ){
			//System.out.println("Start moving left");
			game.startMovingCharacterLeft();
		}
		else if( e.getKeyCode() == KeyEvent.VK_W ){
			//System.out.println("Start moving UP");
			game.startMovingCharacterUp();
		}
		else if( e.getKeyCode() == KeyEvent.VK_S ){
			//System.out.println("Start moving Down");
			game.startMovingCharacterDown();
		}
		
		switch(e.getKeyCode()) {
		case KeyEvent.VK_SPACE :
			game.jumpMovingCharacter();
			break;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if( e.getKeyCode() == KeyEvent.VK_D ){
			//System.out.println("STOP moving right");
			game.stopMovingCharacterRight();
		}
		else if( e.getKeyCode() == KeyEvent.VK_A ){
			//System.out.println("STOP moving left");
			game.stopMovingCharacterLeft();
		}
		else if( e.getKeyCode() == KeyEvent.VK_W ){
			//System.out.println("STOP moving UP");
			game.stopMovingCharacterUp();
		}
		else if( e.getKeyCode() == KeyEvent.VK_S ){
			//System.out.println("STOP moving Down");
			game.stopMovingCharacterDown();
		}
		
	}
	
	
}
