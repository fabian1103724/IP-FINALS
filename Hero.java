import java.io.IOException;
import javax.swing.JComponent;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.net.URL;

public class Hero{
	public Draw comp;
	public int xPos = 300;
	public int yPos = 300;
	public BufferedImage image;
	public int x = 30;
	public int y = 30;
	public int state = 0;
	public URL resource = getClass().getResource("run0.png");
	public int life = 200;
	public boolean contact = false;
	public int exp = 0;
	public int dmg = 1;
	
	
	public Hero(Draw comp){
		this.comp = comp;
	
	}
	

	public void reloadImage(){
		state++;

		if(state == 0){
			resource = getClass().getResource("run0.png");
		}
		else if(state == 1){
			resource = getClass().getResource("run1.png");
		}
		else if(state == 2){
			resource = getClass().getResource("run2.png");
		}
		else if(state == 3){
			resource = getClass().getResource("run3.png");
		}
		else if(state == 4){
			resource = getClass().getResource("run4.png");
		}
		else if(state == 5){
			resource = getClass().getResource("run5.png");
			state = 0;
		}

		try{
			image = ImageIO.read(resource);
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void reloadImage1(){
		state++;

		if(state == 0){
			resource = getClass().getResource("run10.png");
		}
		else if(state == 1){
			resource = getClass().getResource("run11.png");
		}
		else if(state == 2){
			resource = getClass().getResource("run12.png");
		}
		else if(state == 3){
			resource = getClass().getResource("run13.png");
		}
		else if(state == 4){
			resource = getClass().getResource("run14.png");
		}
		else if(state == 5){
			resource = getClass().getResource("run15.png");
			state = 0;
		}

		try{
			image = ImageIO.read(resource);
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}

	public void attackAnimation(){
		Thread thread1 = new Thread(new Runnable(){
			public void run(){
				for(int ctr = 0; ctr < 5; ctr++){
					try {
						if(ctr==4){
							resource = getClass().getResource("run0.png");
						}
						else{
							resource = getClass().getResource("attack"+ctr+".png");
						}
						
						try{
							image = ImageIO.read(resource);
						}
						catch(IOException e){
							e.printStackTrace();
						}
				        comp.repaint();
				        Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}


				for(int x=0; x<comp.monsters.length; x++){
					if(comp.monsters[x]!=null){
						if(comp.monsters[x].contact){
								if(comp.monsters[x].life > 0){
								comp.monsters[x].life = comp.monsters[x].life - comp.hero1.dmg;
								}
								else if(comp.monsters[x].life == 0){
									comp.hero1.dmg = comp.hero1.dmg + comp.monsters[x].exp;
								}
						}
					}
				}
			}
		});
		thread1.start();
	}
	
	public void attackAnimation1(){
		Thread thread2 = new Thread(new Runnable(){
			public void run(){
				for(int ctr = 4; ctr < 8; ctr++){
					try {
						if(ctr==7){
							resource = getClass().getResource("run10.png");
						}
						else{
							resource = getClass().getResource("attack"+ctr+".png");
						}
						
						try{
							image = ImageIO.read(resource);
						}
						catch(IOException e){
							e.printStackTrace();
						}
				        comp.repaint();
				        Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}


				for(int x=0; x<comp.monsters.length; x++){
					if(comp.monsters[x]!=null){
						if(comp.monsters[x].contact){
								if(comp.monsters[x].life > 0){
								comp.monsters[x].life = comp.monsters[x].life - comp.hero1.dmg;
								}
								else if(comp.monsters[x].life == 0){
									comp.monsters[x].life = 0;
	
									
								}
						}
					}
				}
			}
		});
		thread2.start();
	}

	public void moveUp(){
		y = y - 5;
		
		reloadImage();
		comp.repaint();
		comp.checkCollision();
		
	}

	public void moveDown(){
		y = y + 5;
		
		
		reloadImage();
		comp.repaint();
		comp.checkCollision();
		
	}

	public void moveLeft(){
		x = x - 5;
		reloadImage1();
		comp.repaint();
		comp.checkCollision();
	}

	public void moveRight(){
		x = x + 5;
		reloadImage();
		comp.repaint();
		comp.checkCollision();
	}

	public void attack(){
		attackAnimation();
	}
	
	public void attack2(){
		attackAnimation1();
	}



}