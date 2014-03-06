import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class MyPanel extends JPanel {

	
	
	private int width, height;
	private Game game;
	private int top, right, bottom, left;
	private BufferedImage BGimage;
	private BufferedImage paddleImage;
	private BufferedImage ballImage;
	//private BufferedImage deadImage;
	private BufferedImage blockImage;
	//private BufferedImage blockImage2;
	private BufferedImage dropImage;
	private BufferedImage num0,num1,num2,num3,num4,num5,num6,num7,num8,num9;
	private BufferedImage boardScores;
	private String strScore;
	private String strLives;
	private BufferedImage allBg, panel, scores,lives,pause;
	
	public int getTop() {
		return top;
	}

	public void setTop(int top) {
		this.top = top;
	}

	public int getRight() {
		return right;
	}

	public void setRight(int right) {
		this.right = right;
	}

	public int getLeft() {
		return left;
	}

	public void setLeft(int left) {
		this.left = left;
	}
	
	public int getBottom() {
		return bottom;
	}

	public void setBottom(int bottom) {
		this.bottom = bottom;
	}

	MyPanel(){
		width = Toolkit.getDefaultToolkit().getScreenSize().width;
		height = Toolkit.getDefaultToolkit().getScreenSize().height;
		top = 50;
		left = 10;
		bottom = top + (int)(0.8*height);
		right = left + (int)(0.8*width);
		game = new Game(left, right);
		
		
		//dodanie t³a
		File imageFile = new File("C:/Users/aga/Documents/GitHub/Java/Nowy_Arkanoid/textures/bg.jpg");
		File imageFile2 = new File("C:/Users/aga/Documents/GitHub/Java/Nowy_Arkanoid/textures/raq.jpg");
		File imageFile3 = new File("C:/Users/aga/Documents/GitHub/Java/Nowy_Arkanoid/textures/red_ball.gif");
		//File imageFile4 = new File("C:/Users/aga/Documents/GitHub/Java/Nowy_Arkanoid/textures/dead.gif");
		File imageFile5 = new File("C:/Users/aga/Documents/GitHub/Java/Nowy_Arkanoid/textures/block.jpg");
		//File imageFile6 = new File("C:/Users/aga/Documents/GitHub/Java/Nowy_Arkanoid/textures/block2.jpg");
		File imageFile7 = new File("C:/Users/aga/Documents/GitHub/Java/Nowy_Arkanoid/textures/drop.gif");
		File n0 = new File("C:/Users/aga/Documents/GitHub/Java/Nowy_Arkanoid/textures/numbers/0.png");
		File n1 = new File("C:/Users/aga/Documents/GitHub/Java/Nowy_Arkanoid/textures/numbers/1.png");
		File n2 = new File("C:/Users/aga/Documents/GitHub/Java/Nowy_Arkanoid/textures/numbers/2.png");
		File n3 = new File("C:/Users/aga/Documents/GitHub/Java/Nowy_Arkanoid/textures/numbers/3.png");
		File n4 = new File("C:/Users/aga/Documents/GitHub/Java/Nowy_Arkanoid/textures/numbers/4.png");
		File n5 = new File("C:/Users/aga/Documents/GitHub/Java/Nowy_Arkanoid/textures/numbers/5.png");
		File n6 = new File("C:/Users/aga/Documents/GitHub/Java/Nowy_Arkanoid/textures/numbers/6.png");
		File n7 = new File("C:/Users/aga/Documents/GitHub/Java/Nowy_Arkanoid/textures/numbers/7.png");
		File n8 = new File("C:/Users/aga/Documents/GitHub/Java/Nowy_Arkanoid/textures/numbers/8.png");
		File n9 = new File("C:/Users/aga/Documents/GitHub/Java/Nowy_Arkanoid/textures/numbers/9.png");
		File boardSc = new File("C:/Users/aga/Documents/GitHub/Java/Nowy_Arkanoid/textures/numbers/board.jpg");
		File all = new File("C:/Users/aga/Documents/GitHub/Java/Nowy_Arkanoid/textures/allBg.jpg");
		File p = new File("C:/Users/aga/Documents/GitHub/Java/Nowy_Arkanoid/textures/panel.jpg");
		File sc = new File("C:/Users/aga/Documents/GitHub/Java/Nowy_Arkanoid/textures/scores.gif");
		File live = new File("C:/Users/aga/Documents/GitHub/Java/Nowy_Arkanoid/textures/lives.gif");
		File pause_ = new File("C:/Users/aga/Documents/GitHub/Java/Nowy_Arkanoid/textures/pause.gif");
		try {
            BGimage = ImageIO.read(imageFile);
            paddleImage = ImageIO.read(imageFile2);
            ballImage = ImageIO.read(imageFile3);
          //  deadImage = ImageIO.read(imageFile4);
            blockImage = ImageIO.read(imageFile5);
          //  blockImage2 = ImageIO.read(imageFile6);
            dropImage = ImageIO.read(imageFile7);
            num0 = ImageIO.read(n0);
            num1 = ImageIO.read(n1);
            num2 = ImageIO.read(n2);
            num3 = ImageIO.read(n3);
            num4 = ImageIO.read(n4);
            num5 = ImageIO.read(n5);
            num6 = ImageIO.read(n6);
            num7 = ImageIO.read(n7);
            num8 = ImageIO.read(n8);
            num9 = ImageIO.read(n9);
            allBg = ImageIO.read(all);
            panel = ImageIO.read(p);
            boardScores = ImageIO.read(boardSc);
            scores = ImageIO.read(sc);
            lives = ImageIO.read(live);
            pause = ImageIO.read(pause_);
            
            
        } catch (IOException e) {
            System.err.println("Blad odczytu obrazka");
            e.printStackTrace();
        }

	}
	
	public void paint(Graphics g){
		
		Paddle paddle = game.getPaddle();
		Ball ball = game.getBall();
		
		//malowanie t³a
		g.drawImage(allBg, 0,0,width,height,null);
		g.drawImage(BGimage,left,top,null);
	        
	
		//malowanie pi³ki
		if(game.getBall().isStart()){
			g.drawImage(ballImage,ball.getX(), ball.getY(), ball.getD(), ball.getD(), null);
		}
		//malowanie paletki
		g.drawImage(paddleImage, paddle.getX(), paddle.getY(), paddle.getWidth(), paddle.getHeight() , null);
		

		
		//malowanie dropa
				LinkedList<Drop> dr = game.getList_drops();
				for(int i=0; i<dr.size();i++){
					
					g.drawImage(dropImage,dr.get(i).getX(), dr.get(i).getY(), dr.get(i).getWidth(), dr.get(i).getHeight(), null);
				}
				
		//malowanie bloczków
		LinkedList<Block> bl = game.getList_blocks();
		
		for(int i=0; i< bl.size();i++){
			if(bl.get(i).isVisible()){
				g.drawImage(blockImage,bl.get(i).getX(), bl.get(i).getY(), bl.get(i).getWidth(),bl.get(i).getHeight(),null);
			//	g.drawImage(blockImage2,bl.get(i).getX(), bl.get(i).getY(), bl.get(i).getWidth(),bl.get(i).getHeight(),null);
			}
		}
		
		
		g.drawImage(panel, 1130, top, null);
		
		
		//malowanie scores
		g.drawImage(scores, 1185, top+30, 90, 20, null);
		g.drawImage(boardScores, 1135, top+60, 190, 70, null);
	
		strScore = Integer.toString(game.getScore());
		while (strScore.length() < 8)
			strScore = "0" + strScore;
		for (int i = 0; i < 8; i++) {

			switch (strScore.charAt(i)) {
			case '0':
				g.drawImage(num0, 1150 + i * 20, top+82, 16, 26, null);
				break;
			case '1':
				g.drawImage(num1, 1150 + i * 20, top+82, 16, 26, null);
				break;
			case '2':
				g.drawImage(num2, 1150 + i * 20, top+82, 16, 26, null);
				break;
			case '3':
				g.drawImage(num3, 1150 + i * 20, top+82, 16, 26, null);
				break;
			case '4':
				g.drawImage(num4, 1150 + i * 20, top+82, 16, 26, null);
				break;
			case '5':
				g.drawImage(num5, 1150 + i * 20, top+82, 16, 26, null);
				break;
			case '6':
				g.drawImage(num6, 1150 + i * 20, top+82, 16, 26, null);
				break;
			case '7':
				g.drawImage(num7, 1150 + i * 20, top+82, 16, 26, null);
				break;
			case '8':
				g.drawImage(num8, 1150 + i * 20, top+82, 16, 26, null);
				break;
			case '9':
				g.drawImage(num9, 1150 + i * 20, top+82, 16, 26, null);
				break;

			}		
		}
		
		
		//malowanie lives
		g.drawImage(lives, 1196, top+200, 70, 17, null);
		g.drawImage(boardScores, 1190, top+225, 80, 45, null);
		
		strLives = Integer.toString(game.getLives());
		while(strLives.length() < 2){
			strLives = "0" + strLives;
		}
		int poX = 1212;
		int poY = top+235;
		for(int i=0; i<2; i++){
			switch (strLives.charAt(i)) {
			case '0':
				g.drawImage(num0, poX + i * 20, poY, 16, 26, null);
				break;
			case '1':
				g.drawImage(num1,poX + i * 20, poY, 16, 26, null);
				break;
			case '2':
				g.drawImage(num2, poX + i * 20, poY, 16, 26, null);
				break;
			case '3':
				g.drawImage(num3,  poX + i * 20, poY, 16, 26, null);
				break;
			case '4':
				g.drawImage(num4,  poX + i * 20, poY, 16, 26, null);
				break;
			case '5':
				g.drawImage(num5,  poX + i * 20, poY, 16, 26, null);
				break;
			case '6':
				g.drawImage(num6,  poX + i * 20, poY, 16, 26, null);
				break;
			case '7':
				g.drawImage(num7,  poX + i * 20, poY, 16, 26, null);
				break;
			case '8':
				g.drawImage(num8,  poX + i * 20, poY, 16, 26, null);
				break;
			case '9':
				g.drawImage(num9,  poX + i * 20, poY, 16, 26, null);
				break;

			}		
		}
		
		//gdy pauza
		if(game.getBall().isPause() == true){
			((Graphics2D) g).setComposite(AlphaComposite.SrcOver.derive(0.65f));
			g.setColor(Color.GRAY);
			g.fillRect(left, top, right, bottom-top);
			g.drawImage(pause, (int)((left+right)/2)-65, (int)((bottom-2*top)/2)+20, 150, 60, null);
		}
	}
	
	public Game getGame(){
		return game;
	}
	

	
}
