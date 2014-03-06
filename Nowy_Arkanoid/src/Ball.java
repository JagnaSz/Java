import java.util.concurrent.TimeUnit;


public class Ball implements Runnable {

	private int d,vx,vy,x,y;
	private int pVx, pVy;    //prêdkoœci przed pauz¹
	private boolean start;
	private boolean pause;
	private boolean stick;
	private int paddleX;
//	private boolean stop;
	
	public boolean isPause() {
		return pause;
	}
	public boolean isStart() {
		return start;
	}
	public void setStart(boolean start) {
		this.start = start;
	}
	public Ball(){
		start =  true;
		d = 10;
		vx = 2;   //-2
		vy =-2;  //-2
		x = 550;  //300
		y = 610; 
		pause = false;
		setStick(false);
	}
	
	public Ball(int _x, int _y){
		start =  true;
		d = 10;
		vx = 2;   //-2
		vy =-2;  //-2
		x = _x;  //300
		y = _y; 
		pause = false;
		setStick(false);
	}
	public int getVx() {
		return vx;
	}

	public void setVx(int px) {
		this.vx = px;
	}

	public int getVy() {
		return vy;
	}

	public void setVy(int py) {
		this.vy = py;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getD() {
		return d;
	}

	public void setD(int d) {
		this.d = d;
	}
	
	public void pause(){
		if(!pause){
			pVx = vx;
			pVy = vy;
			vx = 0;
			vy = 0;
			pause = true;	
		}
		else{
			vx = pVx;
			vy = pVy;
			pause = false;
		}
		
	}
	
	public void stopBall(){
		if(!start){
			pVx = vx;
			pVy = vy;
			vx = 0;
			vy = 0;
			start = false;	
		}
		else{
			vx = pVx;
			vy = pVy;
			start = true;
		}
	}
	@Override
	public void run() {
		
		while(true){
			try {
				TimeUnit.MILLISECONDS.sleep(20);
				} catch (InterruptedException e) {
					e.printStackTrace();
			}
			x = x+vx;
			y = y+vy;
		}
		
	}
	public boolean isStick() {
		return stick;
	}
	public void setStick(boolean stick) {
		this.stick = stick;
	}
	public int getPaddleX() {
		return paddleX;
	}
	public void setPaddleX(int paddleX) {
		this.paddleX = paddleX;
	}
	
}
