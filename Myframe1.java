import javax.swing.JFrame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.*;  
import javax.swing.*;  

public class MyFrame1 extends JFrame implements KeyListener{

	Draw drawing;

	public MyFrame1(){
		this.drawing = new Draw();
	}
	

	public void keyPressed(KeyEvent e){
		 if(e.getKeyCode() == KeyEvent.VK_UP){
			drawing.hero1.moveUp();
			System.out.println("pos: " + drawing.hero1.x + ", " +drawing.hero1.y);
		}
		else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			drawing.hero1.moveRight();
			System.out.println("pos: " + drawing.hero1.x + ", " + drawing.hero1.y);
		}
		else if(e.getKeyCode() == KeyEvent.VK_DOWN){
			drawing.hero1.moveDown();
			System.out.println("pos: " + drawing.hero1.x + ", " + drawing.hero1.y);
		}
		else if(e.getKeyCode() == KeyEvent.VK_LEFT){
			drawing.hero1.moveLeft();
			System.out.println("pos: " + drawing.hero1.x + ", " + drawing.hero1.y);
		}
		else if(e.getKeyCode() == KeyEvent.VK_SPACE){
			drawing.hero1.attack();
			System.out.println("damage " + drawing.hero1.dmg);
			
		}
		else if(e.getKeyCode() == KeyEvent.VK_S){
			drawing.spawnEnemy();
		}
		else if(e.getKeyCode() == KeyEvent.VK_H){
			drawing.hero1.heal();
			System.out.println("heal");
			
		}
	}

	public void keyReleased(KeyEvent e){

	}

	public void keyTyped(KeyEvent e){
		
	}
	

	public static void main(String args[]){
		MyFrame1 gameFrame = new MyFrame1();
		gameFrame.setSize(600,600);
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameFrame.setVisible(true);
		gameFrame.getContentPane().add(gameFrame.drawing);
		gameFrame.addKeyListener(gameFrame);
		System.out.println("practical programming");
	}
}