import java.awt.Color;
import java.awt.EventQueue;
import java.awt.MouseInfo;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.Timer;



public class MyFrame extends JFrame implements ActionListener, KeyListener, MouseListener {

	private MyPanel panel;
	private Ball ball;
	private Timer timer;
	private Game game;
	private boolean pressed;
	private int key;
	private boolean is_game = true;
	
	public MyFrame() {
        panel = new MyPanel();
        add(panel);
        timer = new Timer(10, this);
        timer.setInitialDelay(0);
        timer.setCoalesce(true);
        
        addKeyListener(this);
        addMouseListener(this);
    }
	
	public static void main(String[] args){
		final MyFrame frame = new MyFrame();
		EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
            	 frame.setTitle("Arkanoid");
            	 frame.setBackground(Color.gray);
                 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                // setResizable(false);
         		//setLocation(0,0);
                 frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
                 frame.setVisible(true);
                 frame.timer.start();
                
            }
        });

	}

	public void cos(){
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		if(is_game){
			game = panel.getGame();
			Ball b = game.getBall();
			Paddle p = game.getPaddle();
			LinkedList<Block> list = game.getList_blocks();
			
			//poruszanie paletk¹ i odbicia pi³ki
			int mousePoint = MouseInfo.getPointerInfo().getLocation().x ;
			p.setX(mousePoint - (p.getWidth()/2));
			if (b.isStick()) {
				b.setX( p.getX() + p.getWidth()/2 );

			} else 
			{
				//odbicia od œcian
				if(b.getX() + b.getVx() <= panel.getLeft()){
					b.setVx(-b.getVx());
				}
				else if(b.getX() + b.getVx() >= panel.getRight()-b.getD()){
					b.setVx(-b.getVx());
				}
				else if(b.getY() + b.getVy() <= panel.getTop()){
					b.setVy(-b.getVy());
				}
				
				
				//odbicia pi³ki
				if((b.getY()+b.getD() + b.getVy() >= p.getY()) && b.getX()+(int)(b.getD()/2)>=p.getX() && b.getX()+(int)(b.getD()/2)<=p.getX()+p.getWidth() && b.getY()+b.getD() <= p.getY()+p.getHeight() ){
					if(b.getX()+b.getD()>= p.getX() && b.getX()+b.getD()<= p.getX()+(int)(0.2*p.getWidth())){
						if(b.getVx()>0){
							b.setVx(-b.getVx()-2);
							b.setVy(-b.getVy());
						}
						else{
							b.setVx(b.getVx()-2);
							b.setVy(-b.getVy());
						}
					}
					else if(b.getX()+b.getD()> p.getX()+(int)(0.2*p.getWidth()) && b.getX()+b.getD()<= p.getX()+(int)(0.4*p.getWidth()) ){
						if(b.getVx()>0){
							b.setVx(-b.getVx()+1); //-2
							b.setVy(-b.getVy());
						}
						else{
							b.setVx(b.getVx()-1);  //2
							b.setVy(-b.getVy());
						}
					}
					else if(b.getX()+b.getD()> p.getX()+(int)(0.4*p.getWidth()) && b.getX()+b.getD()<= p.getX()+(int)(0.6*p.getWidth()) ){
						
							
							b.setVy(-b.getVy());
						
					}
					else if(b.getX()+b.getD()> p.getX()+(int)(0.6*p.getWidth()) && b.getX()+b.getD()<= p.getX()+(int)(0.8*p.getWidth()) ){
						if(b.getVx()>0){
							b.setVx(b.getVx()-1); //1
							b.setVy(-b.getVy());
						}
						else{
							b.setVx(-b.getVx()+1);  //-1
							b.setVy(-b.getVy());
						}
					}
					else if(b.getX()+b.getD()> p.getX()+(int)(0.8*p.getWidth()) && b.getX()+b.getD()<= p.getX()+p.getWidth() ){
						if(b.getVx()>0){
							b.setVx(b.getVx()+2);
							b.setVy(-b.getVy());
						}
						else{
							b.setVx(-b.getVx()+2);
							b.setVy(-b.getVy());
						}
					}
					
				}
				
				//zbijanie bloczków
				for(int i=0; i< list.size(); i++){
					if(game.getBlocks().isVisible()){
						//dó³
						if(b.getVy()<0 &&  b.getY()<=list.get(i).getY()+list.get(i).getHeight()-b.getVy()&& b.getY() >= list.get(i).getY() + list.get(i).getHeight() - 1){
							if(b.getX()+(int)(b.getD()/2)>= list.get(i).getX()-3 && b.getX()+(int)(b.getD()/2)<=(list.get(i).getX()+list.get(i).getWidth()+3)){
								System.out.println("Dó³");
								game.deleteBlock(i);
								game.addScore(10);
								b.setVy(-b.getVy());
							}
						}
						//góra
					else if(b.getVy()>0 && b.getY()+b.getD()>=list.get(i).getY()-b.getVy() && b.getY()+b.getD() <=list.get(i).getY()-1){
							
							if(b.getX()+(int)(b.getD()/2)>= list.get(i).getX()-3 && b.getX()+(int)(b.getD()/2)<=list.get(i).getX()+list.get(i).getWidth()+3){
								game.deleteBlock(i);
								game.addScore(10);
								b.setVy(-b.getVy());
							}
									
						}
					//	prawo
					else if(b.getVx()<0 && b.getX() <=list.get(i).getX() +list.get(i).getWidth()+b.getVx() && b.getX()>=list.get(i).getX()+list.get(i).getWidth()+b.getVx()-1 && b.getY()+(int)(b.getD()/2)>=list.get(i).getY()-3&& b.getY()+(int)(b.getD()/2)<=list.get(i).getY()+list.get(i).getHeight()+3){
							System.out.println("Prawo");
							game.deleteBlock(i);
							game.addScore(10);
							b.setVx(-b.getVx());
						
						}
						//lewo
					else if(b.getVx()>0 && b.getX()+b.getD() >= list.get(i).getX()-b.getVx() && b.getX()+b.getD() <= list.get(i).getX()-b.getVx()+1 && b.getY()+(int)(b.getD()/2) >=list.get(i).getY()-3&& b.getY()+(int)(b.getD()/2)<=list.get(i).getY()+list.get(i).getHeight()+3){
							System.out.println("Lewo");
							game.deleteBlock(i);
							game.addScore(10);
							b.setVx(-b.getVx());
							
						}			
					}
				}
				
				//jeœli pi³ka upadnie
				if(b.getY()+b.getD()+b.getVy() >= panel.getBottom()){
					game.deleteBall();
					b.setVy(-b.getVy());
					game.subLive();
					game.addBall();
					
				}
				
				//zbijanie dropów
				LinkedList<Drop> dr = game.getList_drops();
				for(int i=0; i< dr.size();i++){
					if(dr.get(i).getY() + dr.get(i).getHeight()>=panel.getBottom()-dr.get(i).getVy()){
						game.addScore(20);
						dr.remove(i);
					}
					//jeœli dotknie paletkê
					else if(dr.get(i).getX()>=p.getX()&&dr.get(i).getX()+dr.get(i).getWidth()<=p.getX()+p.getWidth()
							&&dr.get(i).getY()+dr.get(i).getHeight()>=p.getY()){
						game.addScore(20);
						System.out.println(dr.get(i).getNr_bonus());
						game.getBonus(dr.get(i).getNr_bonus());
					
						dr.remove(i);
						
					}
				}
			}
		}
			panel.repaint();
	
	}

	@Override
	public void keyPressed(KeyEvent e) {
		pressed = true;
		key = e.getKeyChar();
		
		if(key == 'p'){
			is_game = !is_game;
			panel.getGame().pause();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		pressed = false;
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
